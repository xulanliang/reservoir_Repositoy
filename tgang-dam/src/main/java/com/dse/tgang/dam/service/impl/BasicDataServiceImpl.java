package com.dse.tgang.dam.service.impl;

import com.dse.tgang.dam.domain.DistrictRsc;
import com.dse.tgang.dam.service.BasicDataService;
import com.dse.tgang.dam.util.DseStringUtil;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.apache.log.output.ServletOutputLogTarget;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoq on 2016-12-24.
 */
@Service
@Transactional
public class BasicDataServiceImpl implements BasicDataService {

    @Resource
    private JdbcTemplate jdbcTemplate;// 用于复杂sql

    @Override
    public JSONArray buildTree(HttpServletRequest request) throws Exception {
        List<Map<String, Object>> listReservoir = getReservoir(); // 水库
        List<Map<String, Object>> listDyke = getDyke(); // 坝
        List<Map<String, Object>> listSection = getSection(); // 断面
        List<Map<String, Object>> listMonitor = getMonitor(); // 监控点
        DistrictRsc dis = new DistrictRsc();
        List<DistrictRsc> children = new ArrayList<DistrictRsc>();
        dis.setId("-1");
        dis.setType("1");
        dis.setName("深圳市");
        dis.setChildren(children);
        cycBuildTree(children, listReservoir, listDyke, listSection, listMonitor, request.getContextPath());

        return JSONArray.fromObject(dis);
    }

    @Override
    public Object getReservoirList(Map<String, String> dataMap) {
        List<Object> param = new ArrayList<Object>();
        String ennm = dataMap.get("ennm");
        String sql="select PROJ_CD ennmcd ,PROJ_NM ennm from wr_proj_b where proj_cd in(1,2)";
//        String sql = "SELECT  ennmcd,ennm,infndt,lttd,lgtd,aduncd,adunnm,dmstatpl,bldt,encl,lvbslv,dlblp,rscci,exqs,rm,depma,macanu,stneass,rumafe,lrefe,deprfe,inwafe,inpofe,muopin,mafun,virar,viredar,maprra,conglar,atid,sdfl,rma,mdps,mddt,addvcd,adunadd,adunzip,adunfax,aduntel,depmacd,depmaadd,depmazip,depmafax,depmatel,adminnm,admintel,prodnm,prodtel,skillnm,skilltel,safetynm,safetytel FROM  TB0201_RSCMIN_044  WHERE 1=1  ";
        if (StringUtils.isNotEmpty(ennm)) {
            sql += " AND ENNM LIKE ?";
            param.add("%" + ennm + "%");
        }
        sql += " order by ennmcd";
        return jdbcTemplate.queryForList(sql, param.toArray());
    }

    @Override
    public Object getDykeList(Map<String, String> dataMap) {
        String id = dataMap.get("ennmcd");
        if (DseStringUtil.isEmpty(id)) {
            return null;
        }
        String sql = "select d.ennmcd,d.ennm,d.projcd from tb0401_dkcmin_044 d where d.projcd = ? ORDER BY ennmcd";
        return jdbcTemplate.queryForList(sql, id);
    }

    @Override
    public Object getSectionList(Map<String, String> dataMap) {
        String id = dataMap.get("ennmcd");
        if (DseStringUtil.isEmpty(id)) {
            return null;
        }
        String sql = "select b.ennmcd,b.bntrcd,b.bntr from tb0404_bnbdcrpr_044 b where b.ennmcd = ? ORDER BY bntrcd";
        return jdbcTemplate.queryForList(sql, id);
    }

    @Override
    public Object getMonitorList(Map<String, String> dataMap) {
        String id = dataMap.get("bntrcd");
        if (DseStringUtil.isEmpty(id)) {
            return null;
        }
        String sql = "select t.bntrcd,t.pointcd,t.point,t.ptype,t.category,t.category as ucategory from dse_monitoring_points t where t.bntrcd = ? ORDER BY pointcd";
        return jdbcTemplate.queryForList(sql, id);
    }

    @Override
    public void saveReservoir(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String ennmcd = dataMap.get("ennmcd");
        String ennm = dataMap.get("ennm");
        String encl = dataMap.get("encl");
        String addvcd = dataMap.get("addvcd");

        String lttd = dataMap.get("lttd");
        String lgtd = dataMap.get("lgtd");
        //
        String aduncd = dataMap.get("aduncd");
        String adunnm = dataMap.get("adunnm");
        String adunadd = dataMap.get("adunadd");
        String adunzip = dataMap.get("adunzip");

        String adunfax = dataMap.get("adunfax");
        String aduntel = dataMap.get("aduntel");
        String depma = dataMap.get("depma");
        String depmacd = dataMap.get("depmacd");

        String depmaadd = dataMap.get("depmaadd");
        String depmazip = dataMap.get("depmazip");
        String depmafax = dataMap.get("depmafax");
        String depmatel = dataMap.get("depmatel");

        String adminnm = dataMap.get("adminnm");
        String admintel = dataMap.get("admintel");
        String prodnm = dataMap.get("prodnm");
        String prodtel = dataMap.get("prodtel");

        String skillnm = dataMap.get("skillnm");
        String skilltel = dataMap.get("skilltel");
        String safetynm = dataMap.get("safetynm");
        String safetytel = dataMap.get("safetytel");

        String sql = "INSERT INTO TB0201_RSCMIN_044 (ENNMCD,ENNM,ENCL,ADDVCD,ADUNCD,ADUNNM,ADUNADD,ADUNZIP,ADUNFAX,ADUNTEL,DEPMA,DEPMACD,"
                + "DEPMAADD,DEPMAZIP,DEPMAFAX,DEPMATEL,ADMINNM,ADMINTEL,PRODNM,PRODTEL,SKILLNM,SKILLTEL,SAFETYNM,SAFETYTEL,LTTD,LGTD)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, ennmcd, ennm, encl, addvcd, aduncd, adunnm, adunadd, adunzip, adunfax, aduntel,
                depma, depmacd, depmaadd, depmazip, depmafax, depmatel, adminnm, admintel, prodnm, prodtel, skillnm, skilltel, safetynm, safetytel, lttd, lgtd);
    }

    @Override
    public void updateReservoir(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String ennmcd = dataMap.get("ennmcd");
        String oennmcd = dataMap.get("oennmcd");
        String ennm = dataMap.get("ennm");
        String encl = dataMap.get("encl");
        String addvcd = dataMap.get("addvcd");

        String lttd = dataMap.get("lttd");
        String lgtd = dataMap.get("lgtd");

        String aduncd = dataMap.get("aduncd");
        String adunnm = dataMap.get("adunnm");
        String adunadd = dataMap.get("adunadd");
        String adunzip = dataMap.get("adunzip");

        String adunfax = dataMap.get("adunfax");
        String aduntel = dataMap.get("aduntel");
        String depma = dataMap.get("depma");
        String depmacd = dataMap.get("depmacd");

        String depmaadd = dataMap.get("depmaadd");
        String depmazip = dataMap.get("depmazip");
        String depmafax = dataMap.get("depmafax");
        String depmatel = dataMap.get("depmatel");

        String adminnm = dataMap.get("adminnm");
        String admintel = dataMap.get("admintel");
        String prodnm = dataMap.get("prodnm");
        String prodtel = dataMap.get("prodtel");

        String skillnm = dataMap.get("skillnm");
        String skilltel = dataMap.get("skilltel");
        String safetynm = dataMap.get("safetynm");
        String safetytel = dataMap.get("safetytel");
        if (oennmcd.equals(ennmcd)) {
            String sql = "UPDATE TB0201_RSCMIN_044 SET ENNM = ?,ENCL = ?,ADDVCD = ? ,ADUNCD = ?,ADUNNM = ?,ADUNADD = ?,ADUNZIP = ?,ADUNFAX = ?,ADUNTEL = ?,DEPMA = ?,DEPMACD = ?,"
                    + "DEPMAADD = ?,DEPMAZIP = ?,DEPMAFAX = ?,DEPMATEL = ?,ADMINNM = ?,ADMINTEL = ?,PRODNM = ?,PRODTEL = ?,SKILLNM = ?,SKILLTEL = ?,SAFETYNM = ?,SAFETYTEL = ?,lttd = ?, lgtd = ?"
                    + " WHERE ENNMCD = ?";
            jdbcTemplate.update(sql, ennm, encl, addvcd, aduncd, adunnm, adunadd, adunzip, adunfax, aduntel, depma,
                    depmacd, depmaadd, depmazip, depmafax, depmatel, adminnm, admintel, prodnm, prodtel, skillnm, skilltel, safetynm, safetytel, lttd, lgtd, ennmcd);
        } else {
            String sql = "delete TB0201_RSCMIN_044 where ENNMCD = ?";
            jdbcTemplate.update(sql, oennmcd);
            sql = "update TB0401_DKCMIN_044 set PROJCD = ? where PROJCD = ?";
            jdbcTemplate.update(sql, ennmcd, oennmcd);
            saveReservoir(dataMap);
        }
    }

    @Override
    public void deleteReservoir(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String ennmcd = dataMap.get("ennmcd");
        if (DseStringUtil.empty(ennmcd)) {
            return;
        }

        String jsql = "DELETE FROM DSE_MONITORING_POINTS WHERE BNTRCD = " + "(SELECT TOP 1 T4.BNTRCD FROM TB0201_RSCMIN_044 T1,"
                + "TB0401_DKCMIN_044 T2,TB0404_BNBDCRPR_044 T3,DSE_MONITORING_POINTS T4 " + "WHERE T1.ENNMCD = T2.PROJCD AND T2.ENNMCD = T3.ENNMCD "
                + "AND T3.BNTRCD = T4.BNTRCD AND T1.ENNMCD = ?)";
        jdbcTemplate.update(jsql, ennmcd); // 删除监测点信息

        String dsql = "DELETE FROM TB0404_BNBDCRPR_044 WHERE ENNMCD " + "= (SELECT TOP 1 T3.ENNMCD FROM TB0201_RSCMIN_044 T1,"
                + "TB0401_DKCMIN_044 T2,TB0404_BNBDCRPR_044 T3 " + "WHERE T1.ENNMCD = T2.PROJCD AND " + "T2.ENNMCD = T3.ENNMCD  AND T1.ENNMCD = ?)";
        jdbcTemplate.update(dsql, ennmcd); // 删除断面信息

        String bsql = "DELETE FROM TB0401_DKCMIN_044 WHERE PROJCD " + "= (SELECT TOP 1 T2.PROJCD FROM TB0201_RSCMIN_044 T1,TB0401_DKCMIN_044 T2 "
                + "WHERE T1.ENNMCD = T2.PROJCD  AND T1.ENNMCD = ?)";
        jdbcTemplate.update(bsql, ennmcd); // 删除坝信息

        String ssql = "DELETE FROM TB0201_RSCMIN_044  WHERE ENNMCD = ?"; // 删除水库信息
        jdbcTemplate.update(ssql, ennmcd);
    }

    @Override
    public void saveDyke(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String ennmcd = dataMap.get("ennmcd");
        String ennm = dataMap.get("ennm");
        String projcd = dataMap.get("projcd");
        String sql = "INSERT INTO TB0401_DKCMIN_044 (ENNMCD,ENNM,PROJCD)VALUES(?,?,?)";
        jdbcTemplate.update(sql, ennmcd, ennm, projcd);
    }

    @Override
    public void updateDyke(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String ennmcd = dataMap.get("ennmcd");
        String oennmcd = dataMap.get("oennmcd");
        String ennm = dataMap.get("ennm");
        String projcd = dataMap.get("projcd");
        if (ennmcd.equals(oennmcd)) {
            String sql = "UPDATE TB0401_DKCMIN_044 SET ENNM = ?,PROJCD = ? WHERE ENNMCD = ?";
            jdbcTemplate.update(sql, ennm, projcd, ennmcd);
        } else {
            String sql = "delete TB0401_DKCMIN_044  WHERE ENNMCD = ?";
            jdbcTemplate.update(sql, oennmcd);
            sql = "update TB0404_BNBDCRPR_044 set ENNMCD = ? where ENNMCD = ?";
            jdbcTemplate.update(sql, ennmcd, oennmcd);
            saveDyke(dataMap);;
        }
    }

    @Override
    public void deleteDyke(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String ennmcd = dataMap.get("ennmcd");

        String jsql = "DELETE FROM DSE_MONITORING_POINTS WHERE BNTRCD =" + " (SELECT TOP 1 T4.BNTRCD FROM TB0401_DKCMIN_044 T2,"
                + "TB0404_BNBDCRPR_044 T3,DSE_MONITORING_POINTS T4 " + "WHERE T2.ENNMCD = T3.ENNMCD AND T3.BNTRCD = T4.BNTRCD AND T2.ENNMCD = ?)";
        jdbcTemplate.update(jsql, ennmcd); // 删除监测点信息

        String dsql = "DELETE FROM TB0404_BNBDCRPR_044 WHERE ENNMCD " + "= (SELECT TOP 1 T3.ENNMCD FROM TB0401_DKCMIN_044 T2,"
                + "TB0404_BNBDCRPR_044 T3 WHERE T2.ENNMCD = T3.ENNMCD  AND T2.ENNMCD = ?)";
        jdbcTemplate.update(dsql, ennmcd); // 删除断面信息

        String sql = "DELETE FROM TB0401_DKCMIN_044  WHERE ENNMCD = ?";
        jdbcTemplate.update(sql, ennmcd);
    }

    @Override
    public void saveSection(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String ennmcd = dataMap.get("ennmcd");
        String bntrcd = dataMap.get("bntrcd");
        String bntr = dataMap.get("bntr");
        String sql = "INSERT INTO TB0404_BNBDCRPR_044 (ENNMCD,BNTRCD,BNTR)VALUES(?,?,?)";
        jdbcTemplate.update(sql, ennmcd, bntrcd, bntr);
    }

    @Override
    public void updateSection(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String bntrcd = dataMap.get("bntrcd");
        String obntrcd = dataMap.get("obntrcd");
        String bntr = dataMap.get("bntr");
        if (bntrcd.equals(obntrcd)) {
            String sql = "UPDATE TB0404_BNBDCRPR_044 SET bntr = ? WHERE BNTRCD = ?";
            jdbcTemplate.update(sql, bntr, bntrcd);
        } else {
            String sql = "delete TB0404_BNBDCRPR_044 WHERE BNTRCD = ?";
            jdbcTemplate.update(sql, obntrcd);
            sql = "update DSE_MONITORING_POINTS set BNTRCD = ? where BNTRCD = ?";
            jdbcTemplate.update(sql, bntrcd, obntrcd);
            saveSection(dataMap);
        }

    }

    @Override
    public void deleteSection(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String bntrcd = dataMap.get("ennmcd");

        String jsql = "DELETE FROM DSE_MONITORING_POINTS WHERE BNTRCD =" + " (SELECT TOP 1 T4.BNTRCD FROM TB0404_BNBDCRPR_044 T3,"
                + "DSE_MONITORING_POINTS T4 WHERE  T3.BNTRCD = T4.BNTRCD AND T3.BNTRCD = ?)";
        jdbcTemplate.update(jsql, bntrcd); // 删除监测点信息

        String sql = "DELETE FROM TB0404_BNBDCRPR_044  WHERE bntrcd = ?";
        jdbcTemplate.update(sql, bntrcd);
    }

    @Override
    public void saveMonitor(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String bntrcd = dataMap.get("bntrcd");
        String pointcd = dataMap.get("pointcd");
        String point = dataMap.get("point");
        String ptype = dataMap.get("ptype");
        String category = dataMap.get("category");
        String sql = "INSERT INTO DSE_MONITORING_POINTS (BNTRCD,POINTCD,POINT,PTYPE,CATEGORY)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, bntrcd, pointcd, point, ptype, category);

        if (category.equals("3")) { // category等于3表示监测类型为渗压
            String pSql = "INSERT INTO DSE_MONITORING_OP_POINTS(POINTCD)VALUES(?)";
            jdbcTemplate.update(pSql, pointcd); // 保存监测点信息时如果监测点类型等于渗压时,往监测点扩张表插入一条数据
        }
    }

    @Override
    public void updateMonitor(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String pointcd = dataMap.get("pointcd");
        String opointcd = dataMap.get("opointcd");
        String point = dataMap.get("point");
        String ptype = dataMap.get("ptype");
        String category = dataMap.get("category");
        String ucategory = dataMap.get("ucategory");
        if (pointcd.equals(opointcd)) {
            String sql = "UPDATE DSE_MONITORING_POINTS SET POINT = ?,PTYPE = ?,CATEGORY = ? WHERE POINTCD = ?";
            jdbcTemplate.update(sql, point, ptype, category, pointcd);
        } else {
            String sql = "delete DSE_MONITORING_POINTS WHERE POINTCD = ?";
            jdbcTemplate.update(sql, opointcd);
            saveMonitor(dataMap);
        }


        if (ucategory.equals("3") && !ucategory.equals(category)) { // category等于3表示监测类型为渗压
            String pSql = "DELETE DSE_MONITORING_OP_POINTS WHERE POINTCD = ?";
            jdbcTemplate.update(pSql, opointcd); // 如果监测类型初始值等于渗压并且初始值发生改变则删除原有渗压扩展表中所增加的渗压记录
        } else if (!ucategory.equals(category) && category.equals("3")) {
            String pSql = "INSERT INTO DSE_MONITORING_OP_POINTS(POINTCD)VALUES(?)";
            jdbcTemplate.update(pSql, pointcd); // 如果监测类型的初始值改为渗压,则向渗压扩展表中增加一条记录
        }
    }

    @Override
    public void deleteMonitor(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String pointcd = dataMap.get("ennmcd");
        String pSql = "DELETE DSE_MONITORING_OP_POINTS WHERE POINTCD = ?";
        jdbcTemplate.update(pSql, pointcd);// 删除监测点信息同时删除监测点扩展表相对应的数据

        String sql = "DELETE FROM DSE_MONITORING_POINTS  WHERE POINTCD = ?";
        jdbcTemplate.update(sql, pointcd);
    }

    @Override
    public List<Map<String, Object>> listDM(String ennmcd) {
        if (DseStringUtil.empty(ennmcd)) {
            return null;
        }
        String sql = "select bntrcd,bntr from V_RSC_M_BNTR where ennmcd=?";
        return jdbcTemplate.queryForList(sql,ennmcd);
    }

    @Override
    public Object listFSQ(String bntrcd) {
        if (DseStringUtil.empty(bntrcd)) {
            return null;
        }
        String sql = "select id,bntrcd,x,topy,buttomy,flq_x,flq_y,beginx,beginy,ex,ey from dse_dbjc_009_fsqinfo where bntrcd=? ORDER BY x";
        return jdbcTemplate.queryForList(sql,bntrcd);
    }

    @Override
    public Object listBT(String bntrcd) {
        if (DseStringUtil.empty(bntrcd)) {
            return null;
        }
        String sql = "select xwidth,yheight,sn from dse_dbjc_009_cxcdinfo where bntrcd=? order by sn";
        return jdbcTemplate.queryForList(sql,bntrcd);
    }

    @Override
    public Object querySY(String bntrcd, String date) {
        if (DseStringUtil.empty(bntrcd)) {
            return null;
        }
        List<Object> array = new ArrayList<Object>();
        String sql="";
        sql="select a.stcd pointcd,a.stnm point, b.pptopel,b.ppbtmel,b.xlabel,t.origdata,t.prype,to_char(t.tm, 'yyyy-mm-dd') tm " +
                "  from wr_stat_m a " +
                "  left join dse_monitoring_op_points b " +
                "  on a.stcd = b.pointcd " +
                "  left join " +
                "  (select c.tm,c.stcd, nvl(c.calcdata, c.origdata) as origdata,c.gettype prype from WR_HYDO_B c ";
        if(StringUtils.isNotEmpty(date)){
            sql+=" where to_char(c.tm, 'yyyy-mm-dd') = ?";
            array.add(date);
        }
       sql+= " ) t on b.pointcd = t.stcd where a.stcd = b.pointcd and a.stcd in (select stcd from wr_st_rb_map where rb_cd = ?)";
        array.add(bntrcd);
        sql+="order by a.stcd";
        return jdbcTemplate.queryForList(sql,array.toArray());
    }

    @Override
    public Object querySW(String ennmcd,String date) {
        StringBuffer sql=new StringBuffer();
        if (DseStringUtil.empty(ennmcd)) {
            return null;
        }
        String stcd="S0000001";
        if(ennmcd.equals("2")){
              stcd="S0000004";

        }
//        String sql = "SELECT RZ AS Z  FROM  dse_st_rsvr_r  WHERE rownum=1 and trim(stcd) = trim(?) ORDER  BY tm DESC";
        sql.append("SELECT RZ AS Z  FROM  ST_RSVR_R  WHERE rownum=1 and trim(stcd) = trim(?) ") ;
        if (!DseStringUtil.empty(date)) {
          sql.append(" and to_char( tm,'yyyy-mm-dd') ='"+date+"' ");
        }
        sql.append(" ORDER  BY tm DESC ");
        return jdbcTemplate.queryForList(sql.toString(),stcd);
    }

    @Override
    public Object queryXXSW(String ennmcd) {
        if (DseStringUtil.empty(ennmcd)) {
            return null;
        }
        String sql = "select fsltdz from st_rsvrfsr_b,dse_stbprp_m_ennm  where to_number(bgmd)" +
                " <=to_number(replace(substr(to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),6,5),'-',''))" +
                " and (edmd is null or to_number(edmd)  >=" +
                " to_number(replace(substr(to_char(sysdate,'yyyy-mm-dd hh24:mi:ss'),6,5),'-','')))  and dse_stbprp_m_ennm.stcd=st_rsvrfsr_b.stcd " +
                " and dse_stbprp_m_ennm.ennmcd=?";
        return jdbcTemplate.queryForList(sql,ennmcd);
    }

    @Override
    public void updateConfig(Map<String, String> dataMap) {
        String uData = dataMap.get("uData");
        String flag = dataMap.get("flag");
        String sql="";
        String[] arrs = uData.split("@@");
        if(arrs!=null&&arrs.length>0){
            for(int i=0;i<arrs.length;i++){
                String[] arr = arrs[i].split(",");
                if("0".equals(flag)){//0 监控点    1 坝体关键点 2 防渗墙  3 新增坝体监控点
                    sql="UPDATE DSE_MONITORING_OP_POINTS SET XLABEL=?, PPTOPEL=?,PPBTMEL=? WHERE POINTCD=?";
                }else if("1".equals(flag)){
                    if (arr.length == 4) {
                        sql="UPDATE DSE_DBJC_009_CXCDINFO SET BNTRCD=?,XWIDTH=?,YHEIGHT=? WHERE SN=?";
                    } else {
                        sql="INSERT INTO DSE_DBJC_009_CXCDINFO VALUES(?,?,?,null,(SELECT ISNULL(MAX(SN),0)+1 FROM DSE_DBJC_009_CXCDINFO))";
                    }
                } else if ("2".equals(flag)) {
                    if (arr.length == 5) {
                        sql="UPDATE DSE_DBJC_009_FSQINFO SET BNTRCD=?,X=?,BUTTOMY=?,TOPY=? WHERE ID=?";
                    } else {
                        sql="INSERT INTO DSE_DBJC_009_FSQINFO (BNTRCD,X,BUTTOMY,TOPY) VALUES(?,?,?,?)";
                    }
                }
                jdbcTemplate.update(sql,arr);
            }
        }
    }

    @Override
    public void deletePoint(Map<String, String> dataMap) {
        String id = dataMap.get("key");
        if (DseStringUtil.empty(id)) {
            return;
        }
        jdbcTemplate.update("DELETE FROM DSE_DBJC_009_CXCDINFO  WHERE SN=?",
                id);
    }

    @Override
    public List<Map<String, Object>> queryDyKe(String ennmcd) {
        if (DseStringUtil.empty(ennmcd)) {
            return null;
        }
//        String sql = "select d.ennmcd,d.ennm from tb0401_dkcmin_044 d where d.projcd=?";
        String sql = "select PROJ_CD ennmcd ,PROJ_NM ennm from wr_proj_b where  proj_cd in ("+ennmcd+"001,"+ennmcd+"002,"+ennmcd+"003 )";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> querySectionByEnnmcd(String ennmcd) {
        if (DseStringUtil.empty(ennmcd)) {
            return null;
        }
        //String sql = "select b.bntrcd,b.bntr from tb0404_bnbdcrpr_044 b where b.ennmcd=?";
        String sql = "select rb_cd bntrcd,rb_nm  bntr from WR_RB_M " +
                "where rb_cd in(22,23,24,25,26,27,28,29,30,31,2,4,6,34,9,10,11,14,16,17) and  proj_cd_two=? order by proj_cd_two,rb_cd ";
        return jdbcTemplate.queryForList(sql, ennmcd);
    }

    @Override
    public Object getLevelInfo(String bntrcd, String sdate, String edate, String ennmcd) {
        if (DseStringUtil.empty(bntrcd) || DseStringUtil.empty(sdate) || DseStringUtil.empty(edate) || DseStringUtil.empty(ennmcd)) {
            return null;
        }
        sdate += " 00:00:00";
        edate += " 23:59:59";

        String levSql = "select '水  位' pointcd, '水  位' point, rz origdata,CONVERT(varchar(10),tm,20) + ' 08:00:00' tm  from DSE_ST_RSVR_R where stcd = ? and tm between CONVERT(datetime,?,20) and CONVERT(datetime,?,20) and ltrim(datepart(hh,tm)) = 8 order by tm";
        List<Map<String, Object>> levs = jdbcTemplate.queryForList(levSql, ennmcd, sdate, edate);
        String sql = "select m.pointcd,m.point,h.origdata,CONVERT(varchar(10),tm,20) + ' 08:00:00' tm  from DSE_DBJC_005_HYDORIGDATA h left join DSE_MONITORING_POINTS m on h.HYDCD = m.POINTCD where m.CATEGORY='3' and m.BNTRCD=? and h.tm between CONVERT(datetime,?,20) and CONVERT(datetime,?,20) order by h.tm";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, bntrcd, sdate, edate);
        if (list.size() > 0) {
            levs.addAll(list);
        }
        return levs;
    }

    @Override
    public Object getDisInfo(String bntrcd, String date) {
        if (DseStringUtil.empty(bntrcd)) {
            return null;
        }
        List<Object> array = new ArrayList<Object>();
        String sql = "select distinct t1.point,convert(varchar(16),t2.tm,120) as tm,t1.pointcd, t1.ptype, t3.xlabel, t3.pptopel, t3.ppbtmel,t2.origdata from dse_monitoring_op_points t3,dse_monitoring_points  t1 " +
                "left join DSE_DBJC_005_HYDORIGDATA t2 on t1.pointcd = t2.hydcd ";
        String append = "where t1.pointcd=t3.pointcd and t1.category = '3' and t1.bntrcd =? ";
        String defaultStr = "inner join (select HYDCD,max(tm) tm from dse_monitoring_op_points t3,dse_monitoring_points  t1  left join " +
                " DSE_DBJC_005_HYDORIGDATA t2 on t1.pointcd = t2.hydcd where t1.bntrcd = ?   group by (HYDCD) ) t4 on t4.tm = t2.tm ";
        array.add(bntrcd);
        if (DseStringUtil.notEmpty(date)) {
            sql += append;
            sql += " and convert(varchar(10),t2.tm,120) = ? ";
            array.add(date);
        } else {
            sql += defaultStr;
            sql += append;
            array.add(bntrcd);
        }
        sql += "order by t1.POINTCD";
        return jdbcTemplate.queryForList(sql,array.toArray());
    }

    @Override
    public void deleteData(Map<String, String> dataMap) {
        String tm = dataMap.get("key");
        if (DseStringUtil.empty(tm)) {
            return;
        }
        String[] str = tm.split(":");
        jdbcTemplate.update("DELETE FROM DSE_DBJC_005_HYDORIGDATA  WHERE CONVERT (VARCHAR(16),tm, 21) = ?",
                str[0] + ":" + str[1]);
    }

    @Override
    public void updateData(Map<String, Object> dataMap) {
        List<Map<String, Object>> updated = (List<Map<String, Object>>)dataMap.get("updated");
        List<Map<String, Object>> changed = (List<Map<String, Object>>)dataMap.get("changed");
        for (int i = 0; i < updated.size(); i++) {
            Map<String, Object> map = updated.get(i);
            List<String> keys = new ArrayList<>();
            List<Object> values = new ArrayList<>();
            String tm = (String) map.get("tm");
            String[] str = tm.split(":");
            for (String key : map.keySet()) {
                if (!key.equals("tm")) {
                    keys.add(key);
                    values.add(map.get(key));
                }
            }
            for (int j = 0; j < keys.size(); j++) {
                if (DseStringUtil.notEmpty(values.get(j))) {
                    String sql = "if exists (select 1 from DSE_DBJC_005_HYDORIGDATA where CONVERT (VARCHAR(16),tm, 21) = ? and HYDCD= ?) " +
                            "    begin " +
                            "       update DSE_DBJC_005_HYDORIGDATA " +
                            "       set origdata = ? where CONVERT (VARCHAR(16),tm, 21) = ? and HYDCD= ? " +
                            "    end " +
                            "else " +
                            "    begin " +
                            "       INSERT DSE_DBJC_005_HYDORIGDATA (HYDCD, TM, origdata) VALUES(?, ?, ?) " +
                            "    end";
                    jdbcTemplate.update(sql, str[0] + ":" + str[1], keys.get(j), values.get(j),str[0] + ":" + str[1], keys.get(j), keys.get(j), tm, values.get(j));
                } else {
                    jdbcTemplate.update("DELETE FROM DSE_DBJC_005_HYDORIGDATA  WHERE CONVERT (VARCHAR(16),tm, 21) = ? and HYDCD = ?",
                            str[0] + ":" + str[1], keys.get(j));
                }
            }
        }
        for (int i = 0; i < changed.size(); i++) {
            Map<String, Object> map = changed.get(i);
            List<String> keys = new ArrayList<>();
            List<Object> values = new ArrayList<>();
            String tm = (String) map.get("tm");
            for (String key : map.keySet()) {
                if (!key.equals("tm")) {
                    keys.add(key);
                    values.add(map.get(key));
                }
            }
            for (int j = 0; j < keys.size(); j++) {
                if (DseStringUtil.notEmpty(keys.get(j))) {
                    String sql = "INSERT DSE_DBJC_005_HYDORIGDATA (HYDCD, TM, origdata) VALUES(?, ?, ?)";
                    jdbcTemplate.update(sql, keys.get(j), tm, values.get(j));
                }
            }
        }
    }

    @Override
    public Object getPreMonitorList(Map<String, String> dataMap) {
        String id = dataMap.get("bntrcd");
        if (DseStringUtil.isEmpty(id)) {
            return null;
        }
        String sql = "select t.bntrcd,t.pointcd,t.point,t.ptype,t.category,t.category as ucategory from dse_monitoring_points t where t.bntrcd = ?  and t.category = '3'";
        return jdbcTemplate.queryForList(sql, id);
    }

    @Override
    public Object getWaterInfo() {
        String sql = "select * from DSE_DBJC_005_HYDORIGDATA_EXT where id in( SELECT max(id) FROM DSE_DBJC_005_HYDORIGDATA_EXT " +
                "where (notest1 =6 and notest2 = 1) or (notest1 =2 and notest2 = 21) or (notest1 =5 and notest2 = 9)  or (notest1 =4 and notest2 = 1)  " +
                "group by notest1,notest2) order by notest1,notest2";
        List<Map<String, Object>> list = (List<Map<String, Object>>) jdbcTemplate.queryForList(sql);
        String sql2="Select LevVal Z from TG " +
                "Where to_char(dates,'yyyy-mm-dd hh24:mi:ss') >= to_char(sysdate,'yyyy-mm-dd') || ' 00:00' " +
                " and  to_char(dates,'yyyy-mm-dd hh24:mi:ss') < to_char(sysdate,'yyyy-mm-dd') || ' 09:00'  order by dates";
        String sql3="Select LevVal Z from SY " +
                "Where to_char(dates,'yyyy-mm-dd hh24:mi:ss') >= to_char(sysdate,'yyyy-mm-dd') || ' 00:00' " +
                " and  to_char(dates,'yyyy-mm-dd hh24:mi:ss') < to_char(sysdate,'yyyy-mm-dd') || ' 09:00'  order by dates";
        double tgksw=0;
        double syksw=0;
        List<Map<String, Object>> list2 = (List<Map<String, Object>>) jdbcTemplate.queryForList(sql2);
        List<Map<String, Object>> list3 = (List<Map<String, Object>>) jdbcTemplate.queryForList(sql3);
        if(list2.size()>0){
            tgksw=Double.parseDouble(list2.get(0).get("Z").toString());
        }
        if(list3.size()>0){
            syksw=Double.parseDouble(list3.get(0).get("Z").toString());
        }
        if (list.size() > 3) {
            list.get(0).put("c1", tgksw);
            list.get(3).put("c1", syksw);
        }
        return  list;
    }

    @Override
    public Object getKrInfo(Map<String, Object> dataMap) {
        String stcd = (String) dataMap.get("stcd");
        String rz = (String) dataMap.get("rz");
        if (DseStringUtil.empty(stcd) || DseStringUtil.empty(rz)) {
            return  null;
        }
        String sql = "select w from ST_ZVARL_B where stcd = ? and rz = round(?, 2)";
        return  jdbcTemplate.queryForList(sql, stcd, rz);
    }

    @Override
    public void deleteFsq(Map<String, String> dataMap) {
        String id = dataMap.get("key");
        if (DseStringUtil.empty(id)) {
            return;
        }
        jdbcTemplate.update("DELETE FROM DSE_DBJC_009_FSQINFO  WHERE id=?",
                id);
    }

    @Override
    public Object getSeepageList(Map<String, String> dataMap) {
        String ennmcd = dataMap.get("ennmcd");
        String sdate = dataMap.get("sdate");
        String edate = dataMap.get("edate");
        if (DseStringUtil.isEmpty(ennmcd)) {
            return null;
        }
        String sql = new String();
        List<Object> array = new ArrayList<Object>();
        if (ennmcd.equals("5010103")) {
            sql = "select  CONVERT(varchar(19),h.Rtime,120) tm,t.sjbh stcd,h.j1 sht FROM DSE_DBJC_005_HYDORIGDATA_EXT h,DSE_DOT_INFO t where h.notest1 = t.dyh and h.notest2 = t.cdh and h.notest1=2 and h.notest2=21  ";
        } else {
            sql = "select  CONVERT(varchar(19),h.Rtime,120) tm,t.sjbh stcd,h.j1 sht FROM DSE_DBJC_005_HYDORIGDATA_EXT h,DSE_DOT_INFO t where h.notest1 = t.dyh and h.notest2 = t.cdh and h.notest1=6 and h.notest2=1 ";
        }
        if (DseStringUtil.notEmpty(sdate)) {
            sql += "and h.Rtime > CONVERT (datetime, ?, 120) ";
            array.add(sdate + " 00:00:00");
        }
        if (DseStringUtil.notEmpty(edate)) {
            sql += "and h.Rtime < CONVERT (datetime, ?, 120) ";
            array.add(edate + " 23:59:59");
        }
        sql += "ORDER BY h.Rtime";
        return jdbcTemplate.queryForList(sql, array.toArray());
    }

    @Override
    public void deleteSeepage(Map<String, String> dataMap) {
        String tm = dataMap.get("key");
        String ennmcd = dataMap.get("ennmcd");
        if (DseStringUtil.empty(tm) || DseStringUtil.empty(ennmcd)) {
            return;
        }
        String sql = "";
        if (ennmcd.equals("5010103")) {
            sql = "DELETE FROM DSE_DBJC_005_HYDORIGDATA_EXT  WHERE CONVERT (VARCHAR(19),Rtime, 120) = ? and notest1=2 and notest2=21  ";
        } else {
            sql = "DELETE FROM DSE_DBJC_005_HYDORIGDATA_EXT  WHERE CONVERT (VARCHAR(19),Rtime, 120) = ? and notest1=6 and notest2=1 ";
        }
        jdbcTemplate.update(sql,tm);
    }

    @Override
    public Object getStcdByEnnmcd(Map<String, String> dataMap) {
        String ennmcd = dataMap.get("ennmcd");
        if (DseStringUtil.isEmpty(ennmcd)) {
            return null;
        }
        String sql = new String();
        List<Object> array = new ArrayList<Object>();
        if (ennmcd.equals("5010103")) {
            sql = "select top 1 t.sjbh stcd FROM DSE_DOT_INFO t where t.dyh = 2 and t.cdh = 21";
        } else {
            sql = "select top 1 t.sjbh stcd FROM DSE_DOT_INFO t where t.dyh = 6 and t.cdh = 1";
        }
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public void saveSeepage(Map<String, Object> dataMap) throws Exception {
        List<Map<String, Object>> updated = (List<Map<String, Object>>)dataMap.get("updated");
        List<Map<String, Object>> changed = (List<Map<String, Object>>)dataMap.get("changed");
        String ennmcd = (String)dataMap.get("ennmcd");
        if (DseStringUtil.empty(ennmcd)) {
            throw new Exception();
        }
        for (int i = 0; i < updated.size(); i++) {
            Map<String, Object> map = updated.get(i);
            String tm = (String) map.get("tm");
            String st = (String) map.get("sht");
            String ll = "", temp = "";
            if (DseStringUtil.notEmpty(st)) {
                temp = (1.4 * Math.sqrt(Float.valueOf(st) * Float.valueOf(st) * Float.valueOf(st) * Float.valueOf(st) * Float.valueOf(st) / 100000) / 100) + "";
                String[] temps = temp.split("\\.");
                if (temps.length > 1 && temps[1].length() > 3) {
                    ll = temps[0] + "." + temps[1].substring(0, 3);
                } else {
                    ll = temp;
                }
            }
            if (ennmcd.equals("5010103")) {
                if (DseStringUtil.notEmpty(st)) {
                    String sql = "if exists (select 1 from DSE_DBJC_005_HYDORIGDATA_EXT where CONVERT (VARCHAR(19),Rtime, 120) = ? and notest1=2 and notest2=21 ) " +
                            "    begin " +
                            "       update DSE_DBJC_005_HYDORIGDATA_EXT " +
                            "       set j1 = ?, j2 = ? where CONVERT (VARCHAR(19),Rtime, 120) = ? and notest1=2 and notest2=21 " +
                            "    end " +
                            "else " +
                            "    begin " +
                            "       INSERT DSE_DBJC_005_HYDORIGDATA_EXT (notest1, notest2, Rtime, j1, j2) VALUES(2, 21, ?, ?, ?) " +
                            "    end";
                    jdbcTemplate.update(sql, tm, st, ll, tm, tm, st, ll);
                } else {
                    jdbcTemplate.update("DELETE FROM DSE_DBJC_005_HYDORIGDATA_EXT  WHERE CONVERT (VARCHAR(19),Rtime, 120) = ? and notest1=2 and notest2=21",tm);
                }
            } else {
                if (DseStringUtil.notEmpty(st)) {
                    String sql = "if exists (select 1 from DSE_DBJC_005_HYDORIGDATA_EXT where CONVERT (VARCHAR(19),Rtime, 120) = ? and notest1=6 and notest2=1 ) " +
                            "    begin " +
                            "       update DSE_DBJC_005_HYDORIGDATA_EXT " +
                            "       set j1 = ?, j2 = ? where CONVERT (VARCHAR(19),Rtime, 120) = ? and notest1=6 and notest2=1 " +
                            "    end " +
                            "else " +
                            "    begin " +
                            "       INSERT DSE_DBJC_005_HYDORIGDATA_EXT (notest1, notest2, Rtime, j1, j2) VALUES(6, 1, ?, ?, ?) " +
                            "    end";
                    jdbcTemplate.update(sql, tm, st, ll, tm, tm, st, ll);
                } else {
                    jdbcTemplate.update("DELETE FROM DSE_DBJC_005_HYDORIGDATA_EXT  WHERE CONVERT (VARCHAR(19),Rtime, 120) = ? and notest1=6 and notest2=1",tm);
                }
            }
        }
        for (int i = 0; i < changed.size(); i++) {
            Map<String, Object> map = changed.get(i);
            String tm = (String) map.get("tm");
            String st = (String) map.get("sht");
            String ll = "";
            String sql = "";
            if (DseStringUtil.notEmpty(st)) {
                ll = (1.4 * Math.sqrt(Float.valueOf(st) * Float.valueOf(st) * Float.valueOf(st) * Float.valueOf(st) * Float.valueOf(st) / 100000) / 100) + "";
                String[] lls = ll.split(".");
                if (lls.length > 1 && lls[1].length() > 3) {
                    ll = lls[0] + lls[1].substring(0, 3);
                }
                if (ennmcd.equals("5010103")) {
                    sql = "INSERT DSE_DBJC_005_HYDORIGDATA_EXT (notest1, notest2, Rtime, j1, j2) VALUES(2, 21, ?, ?, ?) ";
                } else {
                    sql = "INSERT DSE_DBJC_005_HYDORIGDATA_EXT (notest1, notest2, Rtime, j1, j2) VALUES(6, 1, ?, ?, ?) ";
                }
                jdbcTemplate.update(sql, tm, st, ll);
            }
        }
    }

    /**
     * 查询水库
     */
    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> getReservoir() {
        String sql = "SELECT R.ENNMCD,R.ENNM,R.ENCL,R.ADDVCD FROM TB0201_RSCMIN_044 R order by ENNMCD";
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 查询坝
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getDyke() {
        String sql = "SELECT D.ENNMCD,D.ENNM,D.PROJCD FROM TB0401_DKCMIN_044 D order by ENNMCD";
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 查询断面
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getSection() {
        String sql = "SELECT B.ENNMCD,B.BNTRCD,B.BNTR FROM TB0404_BNBDCRPR_044 B ORDER BY BNTRCD";
        return jdbcTemplate.queryForList(sql);
    }

    /**
     * 查询监控点
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getMonitor() {
        String sql = "SELECT P.BNTRCD,P.POINTCD,P.POINT,P.PTYPE,P.CATEGORY FROM DSE_MONITORING_POINTS P order by POINTCD";
        return jdbcTemplate.queryForList(sql);
    }

    private void cycBuildTree(List<DistrictRsc> childrenRsc, List<Map<String, Object>> listReservoir, List<Map<String, Object>> listDyke,
                              List<Map<String, Object>> listSection, List<Map<String, Object>> listMonitor, String request) throws Exception {
        for (Object obj : listReservoir) {
            Map<String, String> reservoirMap = (Map<String, String>) obj;
            DistrictRsc dr = new DistrictRsc();
            dr.setId(reservoirMap.get("ENNMCD"));
            dr.setName(reservoirMap.get("ENNM").trim());
            dr.setPid("-1");
            dr.setType("2");
            dr.setIcon(request + "/pages/app/damSafety/basicData/img/reservoir.png");
            childrenRsc.add(dr);
            // 坝
            for (Object dykey : listDyke) {
                Map<String, String> dykeMap = (Map<String, String>) dykey;
                if (dr.getId().equals(dykeMap.get("PROJCD"))) {
                    DistrictRsc dydr = new DistrictRsc();
                    dydr.setId(dykeMap.get("ENNMCD"));
                    dydr.setName(dykeMap.get("ENNM").trim());
                    dydr.setPid(dykeMap.get("PROJCD"));
                    dydr.setType("3");

                    List<DistrictRsc> dyChildren = dr.getChildren();
                    if (dyChildren == null) {
                        dyChildren = new ArrayList<DistrictRsc>();
                        dr.setChildren(dyChildren);
                    }
                    dyChildren.add(dydr);
                    // 断面
                    for (Object dmkey : listSection) {
                        Map<String, String> dmkeMap = (Map<String, String>) dmkey;
                        if (dmkeMap.get("ENNMCD").equals(dydr.getId())) {
                            DistrictRsc dmdr = new DistrictRsc();
                            dmdr.setId(dmkeMap.get("BNTRCD"));
                            dmdr.setName(dmkeMap.get("BNTR").trim());
                            dmdr.setPid(dmkeMap.get("ENNMCD"));
                            dmdr.setType("4");

                            List<DistrictRsc> dmChildren = dydr.getChildren();
                            if (dmChildren == null) {
                                dmChildren = new ArrayList<DistrictRsc>();
                                dydr.setChildren(dmChildren);
                            }
                            dmChildren.add(dmdr);
                            // 监控点
                            for (Object monkey : listMonitor) {
                                Map<String, String> monkeMap = (Map<String, String>) monkey;
                                if (dmdr.getId().equals(monkeMap.get("BNTRCD"))) {
                                    DistrictRsc mondr = new DistrictRsc();
                                    mondr.setId(monkeMap.get("POINTCD"));
                                    mondr.setName(monkeMap.get("POINT").trim());
                                    mondr.setPid(monkeMap.get("BNTRCD"));
                                    mondr.setType("5");
                                    List<DistrictRsc> monChildren = dmdr.getChildren();
                                    if (monChildren == null) {
                                        monChildren = new ArrayList<DistrictRsc>();
                                        dmdr.setChildren(monChildren);
                                    }
                                    monChildren.add(mondr);
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}

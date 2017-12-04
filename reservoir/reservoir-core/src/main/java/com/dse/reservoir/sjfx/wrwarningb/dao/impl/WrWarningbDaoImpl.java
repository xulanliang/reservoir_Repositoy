package com.dse.reservoir.sjfx.wrwarningb.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.sjfx.wrwarningb.pojo.WrWarningbModel;
import com.dse.reservoir.sjfx.wrwarningb.dao.WrWarningbDao;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by  on 2017-8-1.
 */
@Repository("wrWarningbDao")
public class WrWarningbDaoImpl extends BaseDao<WrWarningbModel, String> implements WrWarningbDao {

    //监测类型(1:渗压 2 渗流 3 水平位移4垂直位移5水位6雨量7气温<含气压>8深层位移9渡槽沉降)
    @Override
    public EasyUiPage getListInfoByParams(WrWarningbModel args, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT T.*, ");
        sql.append(" W.STNM AS STNM,P.PROJ_NM AS PROJ_CD_NAME,D.NAME AS MON_TP_NAME FROM  ( ");
        sql.append(" SELECT WA_ID, PROJ_CD, MON_TP, STCD,TO_CHAR(WA_DT,'yyyy-mm-dd') AS WA_DT,decode(WA_TP,'0','无数据','1','绝对值','2','最大值','3','变幅') WA_TP_NAME,WA_TP, ");
        sql.append(" WA_VALUE, REAL_VALUE, DA_VALUE, decode(WA_STATUS,'0','未处理','1','已处理') WA_STATUS_NAME,WA_STATUS, NT,TO_CHAR(TS,'yyyy-mm-dd') AS TS FROM WR_WARNING_B T WHERE 1=1 ");
        if (StringUtil.isNotEmpty(args.getMon_tp())) {
            if("0".equalsIgnoreCase(args.getMon_tp())){
                sql.append(" AND T.MON_TP in ('5','6','7') ");
            }else{
                sql.append(" AND T.MON_TP = ? ");
                params.add(args.getMon_tp());
            }
        }
        if (StringUtil.isNotEmpty(args.getProj_cd())) {
            sql.append(" AND T.PROJ_CD like ? ");
            params.add(args.getProj_cd()+"%");
        }
        if (StringUtil.isNotEmpty(args.getWa_tp())) {
            sql.append(" AND T.WA_TP = ? ");
            params.add(args.getWa_tp());
        }
        if (StringUtil.isNotEmpty(args.getWa_status())) {
            sql.append(" AND T.WA_STATUS = ? ");
            params.add(args.getWa_status());
        }
        if(StringUtil.isNotEmpty(args.getStm())){
            sql.append(" AND T.WA_DT>TO_DATE(?,'yyyy-mm-dd') ");
            params.add(args.getStm());
        }
        if(StringUtil.isNotEmpty(args.getEtm())){
            sql.append(" AND T.WA_DT<(TO_DATE(?,'yyyy-mm-dd')+1) ");
            params.add(args.getEtm());
        }

        sql.append(" ORDER BY T.WA_DT DESC ");
        sql.append(" ) T LEFT JOIN WR_STAT_M W ON T.STCD=W.STCD     ");
        sql.append("  LEFT JOIN WR_PROJ_B P ON P.PROJ_CD=substr(T.PROJ_CD,1,1)     ");
        sql.append("  LEFT JOIN T_SYS_DICTIONARY D ON D.CODE=T.MON_TP     ");
        sql.append("  ORDER BY  T.WA_DT DESC  ");
        return findEasyUiPageBySql(sql.toString(), easyUiPage, params.toArray());
    }

    @Override
    public Object deleteInfoByIds(String ids) throws Exception {
        if (StringUtil.isNotEmpty(ids)) {
            String[] id = ids.split(",");
            for (int i = 0; i < id.length; i++) {
                removeById(WrWarningbModel.class, id[i]);
            }
        }
        return true;
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception {
        if (StringUtil.isNotEmpty(dataStr)) {
            WrWarningbModel model = JsonUtil.json2Object(dataStr, WrWarningbModel.class);
            if (!StringUtil.isNotEmpty(model.getWa_id())) {
                model.setWa_id(DseSysCommonUtil.getNewId().toString());
            }
            if (model.getTs() == null) {
                model.setTs(new Date());
            }
            saveOrUpdate(model);
            return model;
        }
        return null;
    }

    @Override
    public Object getInfoById(String id) throws Exception {
        return get(id);
    }

    @Override
    public Object getWarnListByProjCd(Map<String,Object> conditionMap, EasyUiPage easyUiPage,String type) throws Exception {
        List<Object> params = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT  T.* ,")
        .append(" D.NAME AS MON_TP_NAME,  ")
        .append(" W.STNM  AS STNM, ")
        .append(" DECODE(WA_TP,'0','无数据','1','绝对值','2','最大值','3','变幅') WA_TP_NAME, ")
        .append(" TO_CHAR(T.TS,'yyyy-mm-dd') AS TSS , ")
        .append(" WB.PROJ_NM AS PROJ_CD_NAME ")
        .append(" FROM WR_WARNING_B T")
        .append(" LEFT JOIN WR_PROJ_B WB ")
        .append("    ON WB.PROJ_CD = T.PROJ_CD ")
        .append(" LEFT JOIN T_SYS_DICTIONARY D ")
        .append("    ON D.CODE = T.MON_TP ")
        .append(" LEFT JOIN WR_STAT_M W ")
        .append("  ON T.STCD = W.STCD ")
        .append("  WHERE 1=1  " );
        if(StringUtil.isNotEmpty(type) && "0".equals(type)){
            sql.append("AND T.WA_STATUS = '0'");
            if(!conditionMap.isEmpty() && conditionMap.containsKey("projcd") && DseStringUtil.isNotEmpty(conditionMap.get("projcd"))){
                sql.append(" AND substr(T.PROJ_CD,1,1) = ?")
                .append(" and  t.wa_dt > to_date(to_char(sysdate-30, 'yyyy-mm-dd'),'yyyy-mm-dd') ");
                params.add(conditionMap.get("projcd"));
            }
            if(!conditionMap.isEmpty() && conditionMap.containsKey("projcd_real") && DseStringUtil.isNotEmpty(conditionMap.get("projcd_real"))){
                sql.append(" AND T.PROJ_CD = ?")
                .append(" and  t.wa_dt > to_date(to_char(sysdate, 'yyyy-mm-dd'),'yyyy-mm-dd') ");
                params.add(conditionMap.get("projcd_real"));
            }
            return findEasyUiPageBySql(sql.toString(), easyUiPage, params.toArray());
        }else{
            sql.append(" AND t.WA_ID = '").append(conditionMap.get("WA_ID")).append("'");
            return findBySqlWithMap(sql.toString());
        }

    }

    @Override
    public Integer UpdateWarnStatus(Map<String, Object> params) throws Exception {

        StringBuilder updateSql = new StringBuilder();
        updateSql.append(" update wr_warning_b ")
                .append(" set wa_status = '1'");
        if(!params.isEmpty() && params.containsKey("nt")){
            updateSql.append(" , nt = '").append(params.get("nt")).append("'");
        }
        updateSql.append(" where ") ;
        if(!params.isEmpty() && params.containsKey("wa_id")){
            updateSql.append(" wa_id = '").append(params.get("wa_id")).append("'");
            return  this.updateBySql(updateSql.toString());
        }
        return 0;
    }

    /**
     * 根据条件获取设备数量
     */
    @Override
    public Object getRateData(Map<String, Object> params) throws Exception {
        StringBuilder querySql = new StringBuilder();
        StringBuilder commonSql = new StringBuilder();
        StringBuilder conditionSql = new StringBuilder();

        ArrayList<Object> queryList=new ArrayList<Object>();

        commonSql.append(" select t.pid ,count(1) as cou ")
                .append(" from (SELECT wsm.proj_cd,\n")
                .append("   wsm.st_tp,\n")
                .append("   substr(wsm.proj_cd, 1, 1) as pid,\n")
                .append("   t.stcd,\n")
                .append("   t.stnm,\n")
                .append("   t.onmea,\n")
                .append("   t.typeid,\n")
                .append("   t.isjidian\n")
                .append("  FROM WR_STAT_M T\n")
                .append("  inner join WR_ST_PROJ_TYPE_MAP wsm\n")
                .append("    on t.stcd = wsm.stcd) t\n")
                .append("  left join  wr_proj_b wb\n")
                .append("    on wb.proj_cd = t.proj_cd")
                .append("  where 1=1") ;

        if(!params.isEmpty()){
            if(params.containsKey("onmea")){
                conditionSql.append(" and t.onmea = ? ");
                queryList.add(params.get("onmea"));
            }

        }
        querySql.append(" select t.pid, t.cou as all_stat, t1.cou as useable_stat")
                .append(" from (" )
                .append(commonSql)
                .append(" group by t.pid")
                .append(" ) t ")
                .append("  left join ( ")
                .append(commonSql)
                .append(conditionSql)
                .append(" group by t.pid")
                .append(" ) t1" )
                .append(" on t.pid = t1.pid")
                .append(" where 1=1 ")
                .append(" order by t.pid ");

        return this.findBySqlWithMap(querySql.toString(),queryList.toArray());
    }


    /**
     * 获取 数据缺失率
     * @param params
     * @return
     * @throws Exception
     */
    public Object getLostRate(Map<String, Object> params) throws  Exception{
        StringBuilder commonSQL = new StringBuilder();
        StringBuilder querySQL = new StringBuilder();
        StringBuilder conditionSql = new StringBuilder();

        ArrayList<Object> queryList=new ArrayList<Object>();
        commonSQL.append(" select b.proj_cd, ")
                .append(" b.stcd,")
                .append(" b.wa_tp, ")
                .append(" substr(wb.proj_cd,1,1) as pid,")
                .append(" wm.onmea,")
                .append("  wm.typeid,")
                .append(" wm.isjidian")
                .append(" from wr_warning_b b ")
                .append(" left join WR_STAT_M wm")
                .append(" on b.stcd = wm.stcd")
                .append(" left join wr_proj_b wb")
                .append(" on b.proj_cd = wb.proj_cd")
                .append(" where wm.onmea = 1")
                .append(" and wm.typeid = 0");

        if(!params.isEmpty()){
            if(params.containsKey("waTp")){
                conditionSql.append(" and b.wa_tp = ? ");
                queryList.add(params.get("waTp"));
            }
        }
        querySQL.append(" select t5.pid, sum(t5.all_data) as all_data, sum(t5.lost_data) as lost_data   ")
                .append(" from ( ")
                .append("       select t3.* ")
                .append("       from (")
                .append("               select t.pid, NVL(t.cou, 1) as all_data, NVL(t1.cou, 0) as lost_data")
                .append("               from (")
                .append("                      select t.pid, count(1) as cou")
                .append("                       from ( ")
                .append(commonSQL)
                .append("                       ) t")
                .append("                       group by t.pid) t")
                .append("               left join (select t.pid, count(1) as cou")
                .append("                           from (")
                .append(commonSQL)
                .append(conditionSql)
                .append("                        ) t")
                .append("            group by t.pid) t1")
                .append("           on t.pid = t1.pid" )
                .append("         ) t3" )
                .append(" union ")
                .append(" select t4.* ")
                .append(" from ( ")
                .append("       select substr(p.proj_cd, 1, 1) as pid, 0 as all_data, 0 as lost_data")
                .append("       from wr_proj_b p ")
                .append("       group by substr(p.proj_cd, 1, 1)")
                .append("   ) t4")
                .append(" ) t5")
                .append(" group by t5.pid")
                .append(" order by t5.pid");

        return this.findBySqlWithMap(querySQL.toString(),queryList.toArray());
    }


    /**
     * 获取每个工程的无故障工作时间和出现故障次数
     * @param params
     * @return
     * @throws Exception
     */
    @Override
    public Object getWorkingHours(Map<String, Object> params) throws Exception{
        StringBuilder commonSQL = new StringBuilder();
        StringBuilder querySQL = new StringBuilder();
        ArrayList<Object> queryList=new ArrayList<Object>();

        querySQL.append(" select t5.pid, sum(t5.work_days) as work_days, sum(t5.times) as times ")
                .append(" from ( ")
                .append("  select t3.* from (")

                .append("           select t1.pid, t1.cou as work_days, nvl(t2.times, 1) as times ")
                .append("               from (select t.pid, count(1) as cou ")
                .append("                          from ( ")
                .append(getCommonSQL("1"))
                .append("                               ) t ")
                .append("                  group by t.pid) t1")
                .append("           left join (select d.pid, sum(d.times) as times ")
                .append("                   FROM (SELECT c.stcd AS stcd, c.pid, count(1) as times")
                .append("                       FROM (SELECT b.stcd,")
                .append("                               b.pid,")
                .append("                               (MAX(to_char(b.wa_dt, 'yyyymmdd')) -  MIN(to_char(b.wa_dt, 'yyyymmdd')) + 1) AS days ")
                .append("                               FROM (SELECT rownum,")
                .append("                                   a.stcd,")
                .append("                                   a.wa_dt,")
                .append("                                    a.pid,")
                .append("                                   to_number(to_char(a.wa_dt,'yyyymmdd') - rownum) AS days ")
                .append("                               FROM ( ")
                .append(                                    getCommonSQL("0"))
                .append("                                   ) a ")
                .append("                         ) b ")
                .append("                       GROUP BY b.stcd, b.pid, b.days) c")
                .append("                   WHERE c.days > 7")          // 连续超过7天无数据 算一次故障
                .append("               GROUP BY c.stcd, c.pid")
                .append("               ORDER BY c.stcd ASC) d")
                .append("           WHERE d.times < 4")     //  排除出故障3次以上的
                .append("           GROUP BY d.pid ) t2")
                .append("       on t1.pid = t2.pid")
                .append("       ) t3 ")
                .append("  union ")
                .append("   select t4.* from ( ")
                .append("       select substr(p.proj_cd, 1, 1) as pid, 0 as work_days, 0 as times")
                .append("       from wr_proj_b p")
                .append("       group by substr(p.proj_cd, 1, 1)) t4")
                .append("   ) t5")
                .append("  group by t5.pid")
                .append("  order by t5.pid ")
                .append(" ");

        return this.findBySqlWithMap(querySQL.toString(),queryList.toArray());
    }


    /**
     * 提取公用sql
     * @param waTp
     * @return
     */
    private  StringBuilder getCommonSQL(String waTp){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT  wb.stcd, ")
                .append("       substr(wb.proj_cd, 1, 1) as pid,")
                .append("       to_date(to_char(wb.wa_dt, 'yyyymmdd'), 'yyyymmdd') AS wa_dt")
                .append(" FROM wr_warning_b wb")
                .append("   left join wr_stat_m wm ")
                .append("    on wb.stcd = wm.stcd  ")
                .append("    WHERE wm.typeid = 0  ")
                .append("  AND to_char(wb.wa_dt, 'yyyy-mm-dd') >= to_char(ADD_MONTHS(sysdate, -12), 'yyyy-mm-dd')")
                .append("  AND to_char(wb.wa_dt, 'yyyy-mm-dd') <= to_char(sysdate, 'yyyy-mm-dd')");
            if("0".equals(waTp)){
                sql.append(" and wb.wa_tp = '0' ") ;
            }else if("1".equals(waTp)){
                sql.append(" and wb.wa_tp <> '0' ");
            }
            sql.append(" GROUP BY wb.stcd,  to_char(wb.wa_dt, 'yyyymmdd'), substr(wb.proj_cd, 1, 1) ")
                .append("  ORDER BY wb.stcd, ")
                .append(" to_char(wb.wa_dt, 'yyyymmdd')")
                .append(" ");
        return  sql ;
    }

    public Object getAlarmCountByCd(Map<String,Object> params){
        StringBuilder querySql = new StringBuilder();
        ArrayList<Object> paramArr = new ArrayList<>();
        querySql.append(" select count(1) as total")
                .append(" from wr_warning_b t ")
                .append(" where 1=1 ")
                .append(" and  to_char(t.wa_dt, 'yyyy-mm-dd') >= to_char(sysdate, 'yyyy-mm-dd') ");       //取今天的数据
        if(!params.isEmpty() && params.containsKey("proj_cd") && DseStringUtil.isNotEmpty(params.get("proj_cd"))){
            querySql.append(" and t.proj_cd = ? ");
            paramArr.add(params.get("proj_cd"));
        }

        return this.findBySqlWithMap(querySql.toString(),paramArr.toArray());

    }

}

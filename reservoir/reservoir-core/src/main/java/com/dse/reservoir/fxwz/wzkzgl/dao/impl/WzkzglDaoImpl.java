package com.dse.reservoir.fxwz.wzkzgl.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wrmaquanb.pojo.WrMaPK;
import com.dse.reservoir.api.fxwz.wrmaquanb.pojo.WrmaquanbModel;
import com.dse.reservoir.api.fxwz.wzcfxx.pojo.WzcfxxModel;
import com.dse.reservoir.api.fxwz.wzkzgl.pojo.CrkjlModel;
import com.dse.reservoir.api.fxwz.wzkzgl.pojo.WrMaInventoryPK;
import com.dse.reservoir.api.fxwz.wzkzgl.pojo.WzRowModel;
import com.dse.reservoir.api.fxwz.wzkzgl.pojo.WzkzglModel;
import com.dse.reservoir.fxwz.wzkzgl.dao.WzkzglDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *物资库存表
 */
@Repository("wzkzglDao")
public class WzkzglDaoImpl extends BaseDao implements WzkzglDao {


    @Override
    public EasyUiPage getListInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage){
        List<Object> params= new ArrayList<Object>();
        StringBuffer sql= new StringBuffer();
        sql.append(" SELECT T.*,WMT.MA_TYPE_NAME,TSD.NAME ORG_CD_NAME ");
        sql.append(" FROM (  SELECT T.* ");
        sql.append(" FROM (  ");
        sql.append(" SELECT T.*,WMB.STD_YEAR,WMB.MA_NM,WMB.MODEL,WMB.MU,WMB.MANUFACTURER, ");
        sql.append(" WMB.STATUS MA_STATUS ,WMB.MA_TYPE_ID,WMB.SL_STD_QUAN,WMB.GS_STD_QUAN,WH.WH_NM,WH.LOC FROM ( ");
        sql.append(" SELECT ID, MA_CD, WH_CD, ORG_CD, REAL_QUAN, STD_QUAN, TO_CHAR(TS,'yyyy-mm-dd') AS TS, NT, BINNUM FROM WR_MA_INVENTORY T WHERE 1=1 ");
        if(StringUtil.isNotEmpty(args.getWh_cd_name())){
            sql.append(" AND EXISTS ( SELECT WB.WH_CD FROM  WR_WH_B WB WHERE WB.WH_CD=T.WH_CD AND WB.WH_NM LIKE ? ) ");
            params.add("%"+args.getWh_cd_name()+"%");
        }
        if(StringUtil.isNotEmpty(args.getWh_cd())){
            sql.append(" AND WH_CD= ?  ");
            params.add(args.getWh_cd());
        }
        if(StringUtil.isNotEmpty(args.getOrg_cd())){
            sql.append(" AND ORG_CD= ?  ");
            params.add(args.getOrg_cd());
        }
        /*
        if(StringUtil.isNotEmpty(args.getMa_nm())){
            sql.append(" AND EXISTS ( SELECT WM.MA_CD FROM  WR_MATERIAL_B WM WHERE WM.MA_CD=T.MA_CD AND WM.MA_NM LIKE ? ) ");
            params.add("%"+args.getMa_nm()+"%");
        }
        if(StringUtil.isNotEmpty(args.getMa_status())){
            sql.append(" AND EXISTS ( SELECT WM.MA_CD FROM  WR_MATERIAL_B WM WHERE WM.MA_CD=T.MA_CD AND WM.STATUS=? ) ");
            params.add(args.getMa_status());
        }
        */

        sql.append(" ) T LEFT JOIN WR_MATERIAL_B WMB ON T.MA_CD=WMB.MA_CD ");
        sql.append(" LEFT JOIN WR_WH_B WH ON T.WH_CD=WH.WH_CD ");
        sql.append(" ) T WHERE 1=1 ");

        if(StringUtil.isNotEmpty(args.getMa_nm())){
            sql.append(" AND T.MA_NM LIKE ?  ");
            params.add("%"+args.getMa_nm()+"%");
        }
        if(StringUtil.isNotEmpty(args.getMa_status())){
            sql.append(" AND T.MA_STATUS=?  ");
            params.add(args.getMa_status());
        }
        if(StringUtil.isNotEmpty(args.getType())){
            sql.append(" AND T.MA_TYPE_ID=?  ");
            params.add(args.getType());
        }
        sql.append(" ) T ");
        sql.append(" LEFT JOIN WR_MATERIAL_TYPE WMT ON T.MA_TYPE_ID=WMT.MA_TYPE_ID ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD ON TSD.ID=T.ORG_CD ");
        sql.append(" ORDER BY T.ID DESC ");

        return this.findEasyUiPageBySql(sql.toString(),easyUiPage,params.toArray());
    }

    @Override
    public EasyUiPage getCrkListInfoByParams(String type,String sTime, String eTime, String dep_id, String ck_id,String statu, EasyUiPage easyUiPage) {
        StringBuffer sql = new StringBuffer();
        List params = new ArrayList();
        sql.append("SELECT Y.NAME,T.* FROM (SELECT EE.STATUS,S.MODEL,S.MU,S.MA_NM,BB.WH_NM,BB.ORG_CD,E.* FROM  WR_INOUT_STOCK_LINE E LEFT JOIN WR_WH_B BB ON E.WH_CD = BB.WH_CD LEFT JOIN WR_MATERIAL_B S ON E.MA_CD = S.MA_CD LEFT JOIN WR_INOUT_STOCK_E EE ON E.WR_INOUT_ID = EE.ID WHERE 1=1 ");
        //出库、入库
        if(StringUtil.isNotEmpty(type)){
            sql.append(" AND EE.IN_OUT = ?");
            params.add(type);
        }
        if(StringUtil.isNotEmpty(statu)){
            sql.append(" AND EE.STATUS = ?");
            params.add(statu);
        }
        if(StringUtil.isNotEmpty(sTime)){
            sql.append(" AND E.INOUT_DATE >= TO_DATE(?,'yyyy-mm-dd hh24:MI:ss')");
            params.add(sTime+" 00:00:00");
        }
        if(StringUtil.isNotEmpty(eTime)){
            sql.append(" AND E.INOUT_DATE <= TO_DATE(?,'yyyy-mm-dd hh24:MI:ss')");
            params.add(eTime +" 23:59:59");
        }
        if(StringUtil.isNotEmpty(ck_id)){
            sql.append(" AND E.WH_CD=?");
            params.add(ck_id);
        }
        //WHERE E.INOUT_DATE >= TO_DATE('2011-08-01','yyyy-mm-dd')
        sql.append(" ) T LEFT JOIN T_SYS_DICTIONARY Y ON T.ORG_CD = Y.ID WHERE 1=1");
        if(StringUtil.isNotEmpty(dep_id)){
            sql.append(" AND Y.ID = ?");
            params.add(dep_id);
        }
        sql.append(" ORDER BY TS ASC");
        EasyUiPage page = this.findEasyUiPageBySql(sql.toString(),easyUiPage,params.toArray());
        List rowList =page.getRows();
        if(rowList.size()>0){
            for(int i=0;i<rowList.size();i++){
                Map row = (Map) rowList.get(i);
                List kcNumList = getInfo(row.get("MA_CD").toString(),row.get("WH_CD").toString());
                if(kcNumList.size()>0){
                    Map p = (Map) kcNumList.get(0);
                    row.put("KC",p.get("REAL_QUAN"));
                }else {
                    row.put("KC",0);
                }
            }
        }
        return page;
    }

    /**
     *  获取库存数量
     * @param MA_CD 物资编码
     * @param WH_CD 仓库编码
     * @return
     */
    public List<Map> getInfo(String MA_CD,String WH_CD ){
        StringBuffer str = new StringBuffer();
        List params = new ArrayList();
        str.append("SELECT Y.REAL_QUAN FROM WR_MA_INVENTORY Y WHERE Y.MA_CD=? AND Y.WH_CD=?");
        params.add(MA_CD);
        params.add(WH_CD);
        List<Map> list=this.findBySqlWithMap(str.toString(),params.toArray());
        return list;
    }


    public EasyUiPage getWzkzylListInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage){
        List<Object> params= new ArrayList<Object>();//hh24:mi:ss
        StringBuffer sql= new StringBuffer();
        sql.append(" SELECT T.*, ");
        sql.append(" WMB.MA_NM,WH.WH_NM FROM ( ");
        sql.append(" SELECT WH_CD, MA_CD, MA_PC, BINNUM, REAL_QUAN, TO_CHAR(TS,'yyyy-mm-dd') AS TS , NT FROM WR_MA_QUAN_B T WHERE 1=1  ");
        if(StringUtil.isNotEmpty(args.getWh_cd())){
            sql.append(" AND  T.WH_CD= ? ");
            params.add(args.getWh_cd());
        }
        if(StringUtil.isNotEmpty(args.getMa_cd())){
            sql.append(" AND T.MA_CD= ? ");
            params.add(args.getMa_cd());
        }
        if(StringUtil.isNotEmpty(args.getMa_pc())){
            sql.append(" AND T.MA_PC like ? ");
            params.add("%"+args.getMa_pc()+"%");
        }
        if(StringUtil.isNotEmpty(args.getBinnum())){
            sql.append(" AND T.BINNUM like ? ");
            params.add("%"+args.getBinnum()+"%");
        }
        if(StringUtil.isNotEmpty(args.getSearch_page()) && !StringUtil.isNotEmpty(args.getWr_ma_inventory_id())){
            sql.append("  AND WH_CD='' AND MA_CD='' ");
        }
        if(StringUtil.isNotEmpty(args.getWr_ma_inventory_id())){
            sql.append("  AND EXISTS ( SELECT WMI.MA_CD,WMI.WH_CD FROM WR_MA_INVENTORY WMI WHERE WMI.MA_CD=T.MA_CD AND WMI.WH_CD=T.WH_CD AND WMI.ID=? ) ");
            params.add(args.getWr_ma_inventory_id());
        }
        sql.append(" ORDER BY T.TS DESC ");
        sql.append(" ) T LEFT JOIN WR_MATERIAL_B WMB ON T.MA_CD=WMB.MA_CD ");
        sql.append(" LEFT JOIN WR_WH_B WH ON T.WH_CD=WH.WH_CD ");
        sql.append(" ORDER BY T.TS DESC ");

        return this.findEasyUiPageBySql(sql.toString(),easyUiPage,params.toArray());
    }


    @Override
    public Object getInfoById(String id) {
        StringBuffer sql= new StringBuffer();
        sql.append(" SELECT T.ID, T.MA_CD, T.WH_CD, T.ORG_CD, T.REAL_QUAN, T.STD_QUAN, T.TS, T.NT, T.BINNUM, ");
        sql.append(" WMB.MA_NM,WMB.MODEL,WMB.MU,WMB.MANUFACTURER,WMB.MA_TYPE_ID,WH.WH_NM,WMT.MA_TYPE_NAME,TSD.NAME ORG_CD_NAME FROM ( ");
        sql.append(" SELECT ID, MA_CD, WH_CD, ORG_CD, REAL_QUAN, STD_QUAN, TO_CHAR(TS,'yyyy-mm-dd hh24:mi') AS TS, NT, BINNUM FROM WR_MA_INVENTORY T WHERE 1=1 ");
        if(StringUtil.isNotEmpty(id)){
            sql.append(" AND ID= ? ");
        }
        sql.append(" ) T LEFT JOIN WR_MATERIAL_B WMB ON T.MA_CD=WMB.MA_CD ");
        sql.append(" LEFT JOIN WR_WH_B WH ON T.WH_CD=WH.WH_CD ");
        sql.append(" LEFT JOIN WR_MATERIAL_TYPE WMT ON WMB.MA_TYPE_ID=WMT.MA_TYPE_ID ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD ON TSD.ID=T.ORG_CD ");

        return this.findBySqlWithMap(sql.toString(),id);
    }

    /**
     *  获取入库记录记录信息
     * @param id
     * @return
     */
    @Override
    public Object getCrkInfoById(String id) {
        StringBuffer str = new StringBuffer();
        List params = new ArrayList();
        str.append("SELECT Y.NAME,Y.ID AD,T.* FROM (SELECT EE.CHECK_TIME,EE.STATUS,S.MODEL,S.MU,S.MA_NM,BB.WH_NM,BB.ORG_CD,E.*" +
                "                        FROM  WR_INOUT_STOCK_LINE E" +
                "                        LEFT JOIN WR_WH_B BB ON E.WH_CD = BB.WH_CD" +
                "                        LEFT JOIN WR_MATERIAL_B S ON E.MA_CD = S.MA_CD" +
                "                        LEFT JOIN WR_INOUT_STOCK_E EE ON E.WR_INOUT_ID = EE.ID WHERE 1=1");
        if(StringUtil.isNotEmpty(id)){
            str.append(" AND E.ID = ?");
            params.add(id);
        }
        str.append(") T LEFT JOIN T_SYS_DICTIONARY Y ON T.ORG_CD = Y.ID");
        return this.findBySqlWithMap(str.toString(),params.toArray());
    }

    /**
     * 获取信息
     * @param args
     * @return
     */
    public Object getWrmaquanbInfoById(FxWzArgModel args){
        StringBuffer sql= new StringBuffer();//TO_CHAR(TS,'yyyy-mm-dd hh24:mi') AS
        sql.append(" SELECT T.*  ");//,WMB.MODEL,WMB.MU,WMB.MANUFACTURER,WMB.MA_TYPE_ID,WMT.MA_TYPE_NAME
        sql.append(" ,WMB.MA_NM, WH.WH_NM FROM ( ");
        sql.append(" SELECT WH_CD, MA_CD,MA_PC,BINNUM, REAL_QUAN,TS, NT FROM WR_MA_QUAN_B T WHERE 1=1 ");
        List<Object> params= new ArrayList<Object>();
        if(StringUtil.isNotEmpty(args.getWh_cd())){
            sql.append(" AND WH_CD= ? ");
            params.add(args.getWh_cd());
        }
        if(StringUtil.isNotEmpty(args.getMa_cd())){
            sql.append(" AND MA_CD= ? ");
            params.add(args.getMa_cd());
        }
        if(StringUtil.isNotEmpty(args.getMa_pc())){
            sql.append(" AND MA_PC= ? ");
            params.add(args.getMa_pc());
        }
        if(StringUtil.isNotEmpty(args.getBinnum())){
            sql.append(" AND BINNUM= ? ");
            params.add(args.getBinnum());
        }
        sql.append(" ) T  ");
        sql.append(" LEFT JOIN WR_MATERIAL_B WMB ON T.MA_CD=WMB.MA_CD ");
        sql.append(" LEFT JOIN WR_WH_B WH ON T.WH_CD=WH.WH_CD ");
        //sql.append(" LEFT JOIN WR_MATERIAL_TYPE WMT ON WMB.MA_TYPE_ID=WMT.MA_TYPE_ID ");

        return this.findBySqlWithMap(sql.toString(),params.toArray());

    }


    public Object saveOrUpdateInfo(String dataStr) {
        WzkzglModel model = JsonUtil.json2Object(dataStr,WzkzglModel.class);
        WrMaInventoryPK model2 = JsonUtil.json2Object(dataStr,WrMaInventoryPK.class);
        model.setIdpk(model2);
        if(model.getId()==null){
            model.setId(DseSysCommonUtil.getNewId());
        }
        this.saveOrUpdate(model);
        return true;
    }

    @Override
    public Object delCrkInfoByByIds(String ids) {
        StringBuffer str1 = new StringBuffer();
        StringBuffer str2 = new StringBuffer();
        List params = new ArrayList();
        //出入库登记表
        str1.append("DELETE FROM WR_INOUT_STOCK_E E WHERE E.ID IN( ");
        //出入库行（物资）
        str2.append("DELETE FROM WR_INOUT_STOCK_LINE E WHERE E.WR_INOUT_ID IN( ");
        if(StringUtil.isNotEmpty(ids)){
            String[] id =ids.split(",");
            for(int i=0;i<id.length;i++){
                if(i == id.length-1){
                    str1.append("?)");
                    str2.append("?)");
                }else {
                    str1.append("?,");
                    str2.append("?,");
                }
                params.add(id[i]);
            }
            this.updateBySql(str2.toString(),params.toArray());
            this.updateBySql(str1.toString(),params.toArray());
        }
        return true;
    }

    /**
     * 保存或修改
     * @param dataStr
     * @return
     */
    public Object saveOrUpdateWrmaquanbInfo(String dataStr){
        WrMaPK wrmapk = JsonUtil.json2Object(dataStr,WrMaPK.class);
        WrmaquanbModel wrmaquanbmodel = JsonUtil.json2Object(dataStr,WrmaquanbModel.class);
        wrmaquanbmodel.setIdd(wrmapk);
        //this.saveOrUpdate(wrmaquanbmodel);
        StringBuffer sql0=new StringBuffer("");
        sql0.append("  select wh_cd, ma_cd, ma_pc, binnum, real_quan from wr_ma_quan_b t where 1=1  ");
        if(StringUtil.isNotEmpty(wrmapk.getWh_cd())){
            sql0.append(" and t.wh_cd='"+wrmapk.getWh_cd()+"' ");
        }
        if(StringUtil.isNotEmpty(wrmapk.getMa_cd())){
            sql0.append(" and t.ma_cd='"+wrmapk.getMa_cd()+"' ");
        }
        if(StringUtil.isNotEmpty(wrmapk.getMa_pc())){
            sql0.append(" and t.ma_pc='"+wrmapk.getMa_pc()+"' ");
        }
        if(StringUtil.isNotEmpty(wrmapk.getBinnum())){
            sql0.append(" and t.binnum='"+wrmapk.getBinnum()+"' ");
        }
        List<Map> wr_ma_quan_bList = this.findBySqlWithMap(sql0.toString());
        //System.out.println(" wr_ma_quan_bList.size: "+wr_ma_quan_bList.size());
        if(wr_ma_quan_bList!=null && wr_ma_quan_bList.size()>0){
            Map data=  wr_ma_quan_bList.get(0);
            //Double real_quan=  (Double)data.get("real_quan");
            //System.out.println(" real_quan: "+real_quan);
            StringBuffer sql3=new StringBuffer();//ts = sysdate,
            sql3.append(" update wr_ma_quan_b t set  real_quan ="+wrmaquanbmodel.getReal_quan()+"  ");
            sql3.append(" , nt = TO_CHAR(sysdate, 'yyyy-mm-dd hh24:mi')||'重新计算:'||t.real_quan  where 1=1  ");
            if(StringUtil.isNotEmpty(wrmapk.getWh_cd())){
                sql3.append(" and t.wh_cd='"+wrmapk.getWh_cd()+"' ");
            }
            if(StringUtil.isNotEmpty(wrmapk.getMa_cd())){
                sql3.append(" and t.ma_cd='"+wrmapk.getMa_cd()+"' ");
            }
            if(StringUtil.isNotEmpty(wrmapk.getMa_pc())){
                sql3.append(" and t.ma_pc='"+wrmapk.getMa_pc()+"' ");
            }
            if(StringUtil.isNotEmpty(wrmapk.getBinnum())){
                sql3.append(" and t.binnum='"+wrmapk.getBinnum()+"' ");
            }
            int  count= this.updateBySql(sql3.toString());
        }else{
            StringBuffer sql2=new StringBuffer();
            sql2.append(" insert into wr_ma_quan_b (wh_cd, ma_cd, ma_pc, binnum, real_quan, ts, nt) ");
            sql2.append(" values ('"+wrmapk.getWh_cd()+"', '"+wrmapk.getMa_cd()+"', '"+wrmapk.getMa_pc()+"', '"+wrmapk.getBinnum()+"', "+wrmaquanbmodel.getReal_quan()+", sysdate, '"+wrmaquanbmodel.getNt()+"' ) ");
            int   count=this.updateBySql(sql2.toString());
        }
        return true;
    }


    /**
     * 修改
     * @param ma_cd
     * @param wh_cd
     * @return
     */
    public Object updateWrMaInventoryRealquan(String ma_cd,String wh_cd){
        StringBuffer sql2=new StringBuffer("");//,ts = sysdate
        sql2.append(" update wr_ma_inventory t set real_quan = ");
        sql2.append(" ( select sum(wmqb.real_quan) from WR_MA_QUAN_B wmqb where  wmqb.ma_cd = t.ma_cd and wmqb.wh_cd = t.wh_cd) ");
        sql2.append(" ,nt = TO_CHAR(sysdate, 'yyyy-mm-dd hh24:mi')||'重新计算:'||t.real_quan ");
        sql2.append("  where ma_cd ='"+ma_cd+"' ");
        sql2.append("  and wh_cd ='"+wh_cd+"' ");
        this.updateBySql(sql2.toString());
        return true;
    }

    @Override
    public Object saveCrkInfo(String dataStr) {
        String ID = DseSysCommonUtil.getNewId().toString();
        Map dataMap = JsonUtil.json2Map(dataStr);
        String status =(String) dataMap.get("STATUS");
        String rowID = DseSysCommonUtil.getNewId().toString();
        //出入库登记表
        CrkjlModel crkjlModel = JsonUtil.json2Object(dataStr,CrkjlModel.class);
        //出入库行（物资）表
        WzRowModel wzRowModel = JsonUtil.json2Object(dataStr,WzRowModel.class);
        //判断记录状态
//        if(!StringUtil.isNotEmpty(status)){
            //新建入库记录
            crkjlModel.setSTATUS("3");
            Date tm = new Date();
            crkjlModel.setID(ID);
            crkjlModel.setTS(tm);
            wzRowModel.setTS(tm);
            wzRowModel.setWR_INOUT_ID(ID);
            wzRowModel.setID(rowID);
            this.save(crkjlModel);
            this.save(wzRowModel);
//        }else {
//            //非新建入库记录
//            String valueID = (String) dataMap.get("ID");
//        }
//        if(StringUtil.isNotEmpty(status)){
            //物资存储定额表
            WrmaquanbModel wrmaquanbModel1 = JsonUtil.json2Object(dataStr,WrmaquanbModel.class);
            WrMaPK wrMaPK = JsonUtil.json2Object(dataStr,WrMaPK.class);
            wrmaquanbModel1.setIdd(wrMaPK);
            wrmaquanbModel1.setTs(new Date());
            //设置入库数量
            wrmaquanbModel1.setReal_quan(wzRowModel.getINOUT_QUAN());
            //更新 物资存储定额表
            StringBuffer getModel = new StringBuffer("SELECT * FROM WR_MA_QUAN_B B WHERE B.WH_CD=? AND B.MA_CD=? AND B.MA_PC=? ");
            List list = this.findBySqlWithMap(getModel.toString(),wrMaPK.getWh_cd(),wrMaPK.getMa_cd(),wrMaPK.getMa_pc());
            if(list.size() >0){
                //有当天同批次、同物资、同批次的记录
                Map map2 = (Map) list.get(0);
                double sum=0;
                //判断是出库、入库
                if(((String)dataMap.get("IN_OUT")).equals("1")){
                    //0:出库  1:入库
                    sum = ((BigDecimal)map2.get("REAL_QUAN")).doubleValue() + wzRowModel.getINOUT_QUAN();
                }else {
                    //出库
                    sum = ((BigDecimal)map2.get("REAL_QUAN")).doubleValue() - wzRowModel.getINOUT_QUAN();
                }
                String update1 = "UPDATE WR_MA_QUAN_B B SET B.REAL_QUAN =? WHERE B.WH_CD=? AND B.MA_CD=? AND B.MA_PC=? ";
                this.updateBySql(update1,sum,wrMaPK.getWh_cd(),wrMaPK.getMa_cd(),wrMaPK.getMa_pc());
            }else {
                this.save(wrmaquanbModel1);
            }
            //更新 物资库存表
//            WzkzglModel wzkzglModel = new WzkzglModel();
            StringBuffer getWzkzglModelStr = new StringBuffer();
            List params = new ArrayList();
            getWzkzglModelStr.append("SELECT * FROM WR_MA_INVENTORY Y WHERE Y.WH_CD=? AND Y.MA_CD=?");
            params.add(wzRowModel.getWH_CD());
            params.add(wzRowModel.getMA_CD());
            List list2 =this.findBySqlWithMap(getWzkzglModelStr.toString(),params.toArray());
            if(list2.size() > 0){
                //仓库中有该物资
                Map map1 = (Map) list2.get(0);
                if(((String)dataMap.get("IN_OUT")).equals("1")){
                    //0:出库  1:入库
                    map1.put("REAL_QUAN",((BigDecimal) map1.get("REAL_QUAN")).doubleValue() + wzRowModel.getINOUT_QUAN());
                }else {
                    //出库
                    map1.put("REAL_QUAN",((BigDecimal) map1.get("REAL_QUAN")).doubleValue() - wzRowModel.getINOUT_QUAN());
                }

                StringBuffer update = new StringBuffer();
                update.append("UPDATE WR_MA_INVENTORY Y SET Y.REAL_QUAN=? WHERE Y.MA_CD=? AND Y.WH_CD=?");
                this.updateBySql(update.toString(),map1.get("REAL_QUAN"),wzRowModel.getMA_CD(),wzRowModel.getWH_CD());
            }else {
                //仓库中无该物资
                WzkzglModel wzkzglModel = JsonUtil.json2Object(dataStr,WzkzglModel.class);

                StringBuffer str = new StringBuffer();
                List param = new ArrayList();
                str.append("INSERT INTO WR_MA_INVENTORY VALUES (?,?,?,?,?,?,?,?,?)");
                param.add(ID);
                param.add(dataMap.get("MA_CD"));
                param.add(dataMap.get("WH_CD"));
                param.add(dataMap.get("ORG_CD"));
                param.add(Double.valueOf((String)dataMap.get("INOUT_QUAN")));
                //获取物资存储定额
                param.add(Double.valueOf((String)dataMap.get("INOUT_QUAN")));
                param.add(new Date());
                param.add("");
                param.add("");
                this.updateBySql(str.toString(),param.toArray());
            }
            //将出入库状态改为“已完成”     (0:创建，1:审批中，2:待收发料，3:已完成,4:取消)
           /* List dataList = (List) getRkjlByID((String) dataMap.get("ID"));
            if(dataList.size() > 0){
                Map map = (Map) dataList.get(0);
                String id = (String) map.get("IDD");
                String sql = "UPDATE WR_INOUT_STOCK_E E SET E.STATUS ='3' WHERE E.ID=?";
                this.updateBySql(sql,id);
            }*/
//        }
        return true;
    }

    @Override
    public Object deleteInfoByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
            List<Object> params=new ArrayList<Object>() ;
            StringBuffer sql= new StringBuffer(" DELETE FROM WR_MA_INVENTORY WHERE 1=1 ");
            String[] arrIds=ids.split(",");
            sql.append(" AND ID IN(");
            for(int i=0;i<arrIds.length;i++){
                if((i+1)==arrIds.length){
                    sql.append("?)");
                    params.add(arrIds[i]);
                }else{
                    sql.append("?,");
                    params.add(arrIds[i]);
                }
            }
            this.updateByHql(sql.toString(),params.toArray());
        }
        return true;
    }

    /**
     *  通过入库行id获取出入库记录
     * @param id
     * @return
     */
    public Object getRkjlByID(String id) {
        String sql = "SELECT EE.*,E.ID IDD FROM WR_INOUT_STOCK_E E LEFT JOIN WR_INOUT_STOCK_LINE EE ON E.ID=EE.WR_INOUT_ID" +
                "       WHERE EE.ID=?";
        return this.findBySqlWithMap(sql,id);
    }

    @Override
    public EasyUiPage getCkListInfo(EasyUiPage easyUiPage) {
        StringBuffer selectSql=new StringBuffer();
        selectSql.append("SELECT  ID, MA_CD, WH_CD, ORG_CD, REAL_QUAN, STD_QUAN, TS, NT, BINNUM  FROM WR_MA_INVENTORY T");
        return this.findEasyUiPageBySql(selectSql.toString(),easyUiPage);
    }

    @Override
    public EasyUiPage getWzListInfo(EasyUiPage easyUiPage) {
        StringBuffer selectSql=new StringBuffer();
        selectSql.append("SELECT ID, MA_CD, WH_CD, ORG_CD, REAL_QUAN, STD_QUAN, TS, NT, BINNUM  FROM WR_MA_INVENTORY T ");
        return this.findEasyUiPageBySql(selectSql.toString(),easyUiPage);
    }

    /**
     *
     * @param dataStr
     * @return
     */
    public Object addwz2ck(String dataStr){
        WzkzglModel model = JsonUtil.json2Object(dataStr,WzkzglModel.class);
        FxWzArgModel fxwzargmodel = JsonUtil.json2Object(dataStr,FxWzArgModel.class);
        WrMaInventoryPK wrmainventorypk = JsonUtil.json2Object(dataStr,WrMaInventoryPK.class);
        if(model.getId()==null){
            model.setId(DseSysCommonUtil.getNewId());
        }

        //this.saveOrUpdate(model);

        if(StringUtil.isNotEmpty(fxwzargmodel.getMa_cds())){
            String[] macds = fxwzargmodel.getMa_cds().split(",");
            String[] gs_std_quans ;
            if(StringUtil.isNotEmpty(fxwzargmodel.getGs_std_quans())) {
                gs_std_quans = fxwzargmodel.getGs_std_quans().split(",");
            }
            if(macds!=null && macds.length>0){
                Session session2 = this.sessionFactory.openSession();
                Transaction tx =null;
                try{
                    tx = session2.beginTransaction();
                    int i=0;
                    int size=macds.length;
                    for(i=0;i<size;i++){
                        String key =  macds[i];
                        //String std_quans =  gs_std_quans[i];
                        StringBuffer  sql2=new StringBuffer("");
                        String std_quanStr="";
                        String std_quanVal="";
                        if(model.getStd_quan()!=null &&  model.getStd_quan()>0){
                            std_quanStr=" std_quan ,";
                            std_quanVal=" "+model.getStd_quan()+" , ";
                        }
                        sql2.append("  insert into wr_ma_inventory(id, ma_cd, wh_cd, org_cd, real_quan,"+std_quanStr+" ts, nt, binnum) ");
                        sql2.append(" values('"+model.getId()+"', '"+key+"', '"+wrmainventorypk.getWh_cd()+"', '"+model.getOrg_cd()+"', ");
                        sql2.append(model.getReal_quan()+", "+std_quanVal+" sysdate, '"+model.getNt()+"', '"+model.getBinnum()+"') ");

                        StringBuffer  sql3=new StringBuffer("");
                        sql3.append("  insert into wr_ma_quan_b (wh_cd, ma_cd, ma_pc, binnum, real_quan, ts, nt) ");
                        sql3.append("  values ('"+wrmainventorypk.getWh_cd()+"',  '"+key+"', '"+model.getMa_pc()+"', '"+model.getBinnum()+"', "+model.getReal_quan()+", sysdate, '"+model.getNt()+"') ");

                        Query query = session2.createSQLQuery(sql3.toString());
                        int count = query.executeUpdate();
                        Query query2 = session2.createSQLQuery(sql2.toString());
                        int count2 = query2.executeUpdate();
                        //this.updateByHql(sql3.toString());
                        //this.updateByHql(sql2.toString());
                    }
                    tx.commit();
                }catch (RuntimeException  ex){
                    if(tx!=null){
                        tx.rollback();
                    }
                }finally {
                    session2.close();
                }
            }
        }
        return true;
    }

}

package com.dse.reservoir.fxwz.wrmawarningb.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wrmawarningb.pojo.WrMaWarningbModel;
import com.dse.reservoir.fxwz.wrmawarningb.dao.WrMaWarningbDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by  on 2017-8-1.
 */
@Repository("wrMaWarningbDao")
public class WrMaWarningbDaoImpl extends BaseDao<WrMaWarningbModel, String> implements WrMaWarningbDao {

    //
    @Override
    public EasyUiPage getListInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT T.*,D.NAME AS ORG_CD_NAME FROM  (  ");
        sql.append(" SELECT T.* FROM  (  ");
        sql.append(" SELECT T.*, ");
        sql.append(" WMB.MA_NM AS MA_NM,WWB.WH_NM AS WH_NM  FROM  ( ");
        sql.append(" SELECT  WA_ID, ORG_CD, WH_CD, MA_CD,TO_CHAR(WA_DT,'yyyy-mm-dd') AS WA_DT, WA_TP,decode(WA_TP,'0','小于存储定额','1','超年限') WA_TP_NAME, WA_VALUE, REAL_VALUE, DA_VALUE ");
        sql.append(" ,decode(WA_STATUS,'0','未读','1','已读','2','已处理') WA_STATUS_NAME,WA_STATUS, NT,TO_CHAR(TS,'yyyy-mm-dd') AS TS FROM WR_MA_WARNING_B T WHERE 1=1 ");
        if (StringUtil.isNotEmpty(args.getOrg_cd())) {
            sql.append(" AND T.ORG_CD = ? ");
            params.add(args.getOrg_cd());
        }
        if (StringUtil.isNotEmpty(args.getWh_cd())) {
            sql.append(" AND T.WH_CD = ? ");
            params.add(args.getWh_cd());
        }
        if (StringUtil.isNotEmpty(args.getMa_cd())) {
            sql.append(" AND T.MA_CD = ? ");
            params.add(args.getMa_cd());
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
        sql.append(" ORDER BY T.TS ASC ");
        sql.append(" ) T LEFT JOIN WR_MATERIAL_B WMB ON T.MA_CD=WMB.MA_CD     ");
        sql.append("  LEFT JOIN WR_WH_B WWB ON WWB.WH_CD=T.WH_CD     ");
        sql.append(" ) T  WHERE 1=1 ");
        if (StringUtil.isNotEmpty(args.getMa_nm())) {
            sql.append(" AND T.MA_NM  LIKE  ? ");
            params.add("%"+args.getMa_nm()+"%");
        }
        sql.append(" ) T ");
        sql.append("  LEFT JOIN T_SYS_DICTIONARY D ON D.ID=T.ORG_CD     ");
        sql.append("  ORDER BY  T.TS ASC  ");
        return findEasyUiPageBySql(sql.toString(), easyUiPage, params.toArray());
    }

    @Override
    public Object deleteInfoByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
            StringBuffer sql=new StringBuffer();
            String[] arrIds=ids.split(",");
            sql.append(" AND WA_ID IN ( ");
            StringBuffer idsStr=new StringBuffer();
            for(int i=0;i<arrIds.length;i++){
                if((i+1)==arrIds.length){
                    idsStr.append(" '"+arrIds[i]+"' ");
                }else{
                    idsStr.append(" '"+arrIds[i]+"', ");
                }
            }
            sql.append(idsStr.toString());
            sql.append(" ) ");
            StringBuffer sql3= new StringBuffer(" DELETE FROM WR_MA_WARNING_B WHERE 1=1 ");
            sql3.append(sql);
            this.updateBySql(sql3.toString());
        }
        return true;
    }

    /***
     *
     * @param ids
     * @param stauts
     * @return
     */
    public Object updateStautsByIds(String ids,String stauts){

        if(!StringUtil.isNotEmpty(stauts)){
            stauts="0";
        }
        if (StringUtil.isNotEmpty(ids)) {
            StringBuffer sql =new StringBuffer();
            String[] arrIds = ids.split(",");
            sql.append(" AND WA_ID IN ( ");
            StringBuffer idsStr = new StringBuffer();
            for (int i = 0; i < arrIds.length; i++) {
                if ((i + 1) == arrIds.length) {
                    idsStr.append(" '" + arrIds[i] + "' ");
                } else {
                    idsStr.append(" '" + arrIds[i] + "', ");
                }
            }
            sql.append(idsStr.toString());
            sql.append(" ) ");
            StringBuffer sql2 = new StringBuffer(" UPDATE WR_MA_WARNING_B T SET T.WA_STATUS='"+stauts+"' WHERE 1=1 ");
            sql2.append(sql);
            this.updateBySql(sql2.toString());
        }
        return true;
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception {
        if (StringUtil.isNotEmpty(dataStr)) {
            WrMaWarningbModel model = JsonUtil.json2Object(dataStr, WrMaWarningbModel.class);
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
    public Object saveOrUpdateInfo(WrMaWarningbModel model) throws Exception {
            if (!StringUtil.isNotEmpty(model.getWa_id())) {
                model.setWa_id(DseSysCommonUtil.getNewId().toString());
            }
            if (model.getTs() == null) {
                model.setTs(new Date());
            }
            saveOrUpdate(model);
            return model;
    }

    @Override
    public Object getInfoById(String id) throws Exception {
        return get(id);
    }

    /****
     *
     * @param args
     * @return
     * @throws Exception
     */
    public  List<Map>  getWrMaWarningbStdGuanList(FxWzArgModel args) throws Exception{
        List<Object> params = new ArrayList<Object>();
        StringBuffer sql =new StringBuffer();
        sql.append(" SELECT T.* FROM ( ") ;
        sql.append("  SELECT WMI.ID,WMI.MA_CD,WMI.WH_CD,WMI.ORG_CD,WMI.REAL_QUAN,WMI.STD_QUAN,WMI.TS,WMB.GS_STD_QUAN,WMB.SL_STD_QUAN ");
        sql.append("  FROM WR_MA_INVENTORY WMI  ");
        sql.append("  INNER JOIN WR_MATERIAL_B WMB ON WMI.MA_CD=WMB.MA_CD AND WMB.STATUS='0' ");
        sql.append("  INNER JOIN WR_WH_B WWB ON WMI.WH_CD=WWB.WH_CD AND WWB.WH_STATUS='0' ");
        sql.append("  ) T WHERE T.REAL_QUAN<(NVL(STD_QUAN,GS_STD_QUAN)) ");
        sql.append("  ORDER BY T.TS DESC ");
        return this.findBySqlWithMap(sql.toString(),params.toArray());
    }

    public List<Map> getWrMaWarningbStdYearList(FxWzArgModel args) throws Exception{
        List<Object> params = new ArrayList<Object>();
        StringBuffer sql =new StringBuffer();
        sql.append(" SELECT T.* FROM ( ") ;
        sql.append("  SELECT WWB.ORG_CD,MAQ.WH_CD,MAQ.MA_CD,MAQ.MA_PC,MAQ.BINNUM,MAQ.REAL_QUAN,TO_CHAR(MAQ.TS,'YYYY-MM-DD') AS TS ");
        sql.append("  ,ROUND((SYSDATE-MAQ.TS)/365,2) NOWYEAR,WMB.STD_YEAR  ");
        sql.append("  FROM WR_MA_QUAN_B MAQ ");
        sql.append("   INNER JOIN WR_MATERIAL_B WMB ON MAQ.MA_CD=WMB.MA_CD AND WMB.STATUS='0' AND WMB.STD_YEAR IS NOT NULL ");
        sql.append("   INNER JOIN WR_WH_B WWB ON MAQ.WH_CD=WWB.WH_CD AND WWB.WH_STATUS='0' ");
        sql.append("    ) T WHERE (NOWYEAR>STD_YEAR) ORDER BY T.TS DESC ");

        return findBySqlWithMap(sql.toString(),params.toArray());
    }



}

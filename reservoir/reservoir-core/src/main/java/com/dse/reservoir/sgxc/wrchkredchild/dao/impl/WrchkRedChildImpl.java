package com.dse.reservoir.sgxc.wrchkredchild.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.sgxc.wrchkredchild.pojo.WrchkRedChildModel;
import com.dse.reservoir.api.sgxc.xcsb.pojo.XcsbModel;
import com.dse.reservoir.sgxc.wrchkredchild.dao.WrchkRedChildDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 巡查对象/巡查点
 */
@Repository("wrchkRedChildDao")
public class WrchkRedChildImpl extends BaseDao implements WrchkRedChildDao {


    /***
     * @param args
     * @param notcktkid
     * @return
     * @throws Exception
     */
    @Override
    public Object getList(WrchkRedChildModel args, String notcktkid) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT  ID, CK_RE_ID, CK_OBJ_ID,CK_CNT_ID,ISSUE_ID FROM WR_CHK_RED_CHILD T WHERE 1=1 ";
        if (StringUtil.isNotEmpty(notcktkid)) {
            sql += " AND ID != ? ";
            params.add(notcktkid);
        }
        if (StringUtil.isNotEmpty(args.getCk_obj_id())) {
            sql += " AND CK_OBJ_ID = ? ";
            params.add(args.getCk_obj_id());
        }
        if (StringUtil.isNotEmpty(args.getCk_cnt_id())) {
            sql += " AND CK_CNT_ID = ? ";
            params.add(args.getCk_cnt_id());
        }
        if (StringUtil.isNotEmpty(args.getId())) {
            sql += " AND ID = ? ";
            params.add(args.getId());
        }
        return findBySqlWithMap(sql, params.toArray());
    }

    /****
     * @param args
     * @return
     * @throws Exception
     */
    @Override
    public Object getCount(WrchkRedChildModel args) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT COUNT(*) AS NUM FROM WR_CHK_RED_CHILD WHERE 1=1 ";
        if (StringUtil.isNotEmpty(args.getId())) {
            sql += " AND ID = ? ";
            params.add(args.getId());
        }
        return findBySqlWithMap(sql, params.toArray());
    }

    @Override
    public EasyUiPage getListInfoByParams(String ques_status,String problem,WrchkRedChildModel args, EasyUiPage easyUiPage) {
        List<Object> params = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer(); //hh24:mi:ss
        sql.append(" SELECT  T.*, decode(T.CH_STATUS,'0','未开始','1','进行中','2','已完成') CH_STATUS_NAME,  ");
        sql.append(" WCO.CK_NAME AS CK_OBJ_ID_NAME  FROM ( ");
        sql.append("  SELECT BB.ISU_DESC,S.CK_TM_REQ,BB.ISU_STATUS,BB.ISU_RESOLVE,BB.RESOLVE_USER,TT.ID, TT.SEQ, TT.CK_RE_ID, TT.CK_OBJ_ID, TT.CK_CNT_ID, TT.CK_CNT_DESC, TT.CK_TAG_DESC, TT.ISSUE_ID, ");
        sql.append("  TO_CHAR(TT.TS,'yyyy-mm-dd hh24:mi') TS, TT.NT, CH_STATUS FROM WR_CHK_RED_CHILD TT LEFT JOIN WR_CH_ISSUES_B BB ON TT.ISSUE_ID = BB.ID LEFT JOIN WR_CHK_CONTENTS S ON TT.CK_CNT_ID = S.CK_CNT_ID WHERE 1=1   ");

        if(StringUtil.isNotEmpty(problem)){
            //通过是否有异常筛选  0:全部 1:是  2:否
            if(problem.equals("1")){
                //有异常
                sql.append(" AND TT.ISSUE_ID IS NOT NULL");
            }else if(problem.equals("2")) {
                //无异常
                sql.append(" AND TT.ISSUE_ID IS NULL");
            }
        }
        if(StringUtil.isNotEmpty(ques_status)){
            //通过问题的状态筛选  0：新建  1：解决中   2：已解决   3：未解决
            sql.append(" AND BB.ISU_STATUS=?");
            params.add(ques_status);
        }
        if (StringUtil.isNotEmpty(args.getCk_obj_id())) {
            sql.append(" AND EXISTS (SELECT WCB.CK_OBJ_ID FROM WR_CHK_OBJECT WCB WHERE WCB.CK_OBJECT=? AND WCB.CK_OBJ_ID=T.CK_OBJ_ID ) ");
            params.add(args.getCk_obj_id());
        }
        if (StringUtil.isNotEmpty(args.getCk_obj_id())) {
            sql.append("  AND CK_OBJ_ID= ? ");
            params.add(args.getCk_obj_id());
        }
        if (StringUtil.isNotEmpty(args.getCh_status())) {
            sql.append("  AND CH_STATUS= ? ");
            params.add(args.getCh_status());
        }
        if (StringUtil.isNotEmpty(args.getCk_re_id())) {
            sql.append("  AND CK_RE_ID= ? ");
            params.add(args.getCk_re_id());
        }
        if(StringUtil.isNotEmpty(args.getSearch_ck_re_page()) && !StringUtil.isNotEmpty(args.getCk_re_id())){
            sql.append("  AND CK_RE_ID='' ");
        }
        if (StringUtil.isNotEmpty(args.getCk_cnt_desc())) {
            sql.append("  AND CK_CNT_DESC like ? ");
            params.add("%" + args.getCk_cnt_desc() + "%");
        }
        sql.append(" ) T  ");
        sql.append(" LEFT JOIN WR_CHK_OBJECT WCO ON WCO.CK_OBJ_ID=T.CK_OBJ_ID ");
        sql.append(" ORDER BY T.SEQ, T.ID DESC ");

        return this.findEasyUiPageBySql(sql.toString(), easyUiPage, params.toArray());
    }

    @Override
    public Object getInfoById(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT  T.*, decode(T.CH_STATUS,'0','未开始','1','进行中','2','已完成') CH_STATUS_NAME,  ");
        sql.append(" WCO.CK_NAME AS CK_OBJ_ID_NAME  FROM ( ");
        sql.append("  SELECT B.ISU_DESC,B.ISU_STATUS,B.ISU_RESOLVE,B.RESOLVE_USER,TT.ID, TT.SEQ, TT.CK_RE_ID, TT.CK_OBJ_ID, TT.CK_CNT_ID, TT.CK_CNT_DESC, TT.CK_TAG_DESC, TT.ISSUE_ID, ");
        sql.append("  TO_CHAR(TT.TS,'yyyy-mm-dd hh24:mi:ss') TS, TT.NT, TT.CH_STATUS FROM WR_CHK_RED_CHILD TT LEFT JOIN WR_CH_ISSUES_B B ON TT.ISSUE_ID=B.ID WHERE 1=1   ");
        if (StringUtil.isNotEmpty(id)) {
            sql.append("  AND TT.ID = ? ");
        }
        sql.append(" ) T  ");
        sql.append(" LEFT JOIN WR_CHK_OBJECT WCO ON WCO.CK_OBJ_ID=T.CK_OBJ_ID ");
        sql.append(" ORDER BY T.SEQ, T.ID DESC ");

        return this.findBySqlWithMap(sql.toString(), id);
    }


    public Object saveOrUpdateInfo(String dataStr) {
        WrchkRedChildModel model = JsonUtil.json2Object(dataStr, WrchkRedChildModel.class);
        XcsbModel xcsbModel = JsonUtil.json2Object(dataStr, XcsbModel.class);
        StringBuffer sql=new StringBuffer("UPDATE WR_CH_ISSUES_B B SET B.ISU_DESC=?,B.ISU_RESOLVE=? ");
        ArrayList params = new ArrayList();
        params.add(xcsbModel.getISU_DESC());
        params.add(xcsbModel.getISU_RESOLVE());
        if(StringUtil.isNotEmpty(xcsbModel.getISU_RESOLVE())){
            sql.append(",B.ISU_STATUS='2' ");
        }
        sql.append(" WHERE B.ID=?");
        params.add(model.getIssue_id());
        this.updateBySql(sql.toString(),params.toArray());
        if (model.getId() == null || !StringUtil.isNotEmpty(model.getId())) {
            model.setId(DseSysCommonUtil.getNewId() + "");
        }
        if (model.getTs() == null) {
            model.setTs(new Date());
        }
        this.saveOrUpdate(model);
        return true;
    }

    @Override
    public Object deleteInfoByIds(String ids) {
        if (StringUtil.isNotEmpty(ids)) {
            StringBuffer sql = new StringBuffer(" DELETE FROM WR_CHK_RED_CHILD WHERE 1=1 ");
            String[] arrIds = ids.split(",");
            sql.append(" AND ID IN ( ");
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
            this.updateBySql(sql.toString());
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
            stauts="1";
        }
        if (StringUtil.isNotEmpty(ids)) {
            StringBuffer sql = new StringBuffer(" UPDATE WR_CHK_RED_CHILD T SET T.CH_STATUS='"+stauts+"' WHERE 1=1 ");
            String[] arrIds = ids.split(",");
            sql.append(" AND ID IN ( ");
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
            this.updateBySql(sql.toString());


        }
        return true;
    }
}

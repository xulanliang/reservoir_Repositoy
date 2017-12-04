package com.dse.reservoir.sgxc.wrchkrecord.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.sgxc.wrchkrecord.pojo.WrchkRecordModel;
import com.dse.reservoir.api.sgxc.wrchktask.pojo.WrchkTaskModel;
import com.dse.reservoir.sgxc.wrchkrecord.dao.WrchkRecordDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *巡查对象/巡查点
 */
@Repository("wrchkRecordDao")
public class WrchkRecordImpl extends BaseDao implements WrchkRecordDao {

    /***
     *
     * @param args
     * @param notcktkid
     * @return
     * @throws Exception
     */
    @Override
    public Object getWrchkRecordList(WrchkRecordModel args, String notcktkid) throws Exception{
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT   CK_RE_ID, CK_TK_DESC, CK_OBJ_ID,CK_TK_ID FROM WR_CHK_RECORD T WHERE 1=1 ";
        if(StringUtil.isNotEmpty(notcktkid)){
            sql += " AND CK_RE_ID != ? ";
            params.add(notcktkid);
        }
        if(StringUtil.isNotEmpty(args.getCk_obj_id())){
            sql += " AND CK_OBJ_ID = ? ";
            params.add(args.getCk_obj_id());
        }
        if(StringUtil.isNotEmpty(args.getCk_tk_id())){
            sql += " AND CK_TK_ID = ? ";
            params.add(args.getCk_tk_id());
        }
        if(StringUtil.isNotEmpty(args.getCk_re_id())){
            sql += " AND CK_RE_ID = ? ";
            params.add(args.getCk_re_id());
        }
        return findBySqlWithMap(sql,params.toArray());
    }

    /****
     *
     * @param args
     * @return
     * @throws Exception
     */
    @Override
    public Object getWrchkRecordCount(WrchkRecordModel args) throws Exception{
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT COUNT(*) AS NUM FROM WR_CHK_RECORD WHERE 1=1 ";
        if(StringUtil.isNotEmpty(args.getCk_re_id())){
            sql += " AND CK_RE_ID = ? ";
            params.add(args.getCk_re_id());
        }
        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public EasyUiPage getListInfoByParams(WrchkRecordModel args, EasyUiPage easyUiPage){
        List<Object> params= new ArrayList<Object>();
        StringBuffer sql= new StringBuffer(); //hh24:mi:ss
        sql.append(" SELECT  T.*, decode(T.STATUS,'0','未开始','1','进行中','2','已完成') STATUS_NAME,WCO.CK_OBJECT,TSD5.NAME AS CK_OBJECT_NAME,  ");
        sql.append(" TSD1.NAME AS CK_TYPE_NAME ,WCO.CK_NAME AS CK_OBJ_ID_NAME ,TSD.NAME AS CK_ORG_NAME   FROM ( ");
        sql.append("  SELECT CK_RE_ID, CK_TK_DESC, CK_OBJ_ID, TO_CHAR(CK_BEGIN,'yyyy-mm-dd hh24:mi') CK_BEGIN, ");
        sql.append("  TO_CHAR(CK_END,'yyyy-mm-dd hh24:mi') CK_END, CK_ORG, ");
        sql.append("  CK_TYPE, CK_USERS, CK_TK_ID, CK_RE_PCOUNT, CK_RE_ECOUNT, CH_NOTE_USER, ");
        sql.append("  CH_REVIEW_USER, TO_CHAR(TS,'yyyy-mm-dd hh24:mi') TS, STATUS, NT FROM WR_CHK_RECORD  T WHERE 1=1 ");

        if(StringUtil.isNotEmpty(args.getCk_type())){
            sql.append(" AND CK_TYPE= ?  ");
            params.add(args.getCk_type());
        }
        if(StringUtil.isNotEmpty(args.getCk_org())){
            sql.append("  AND CK_ORG= ? ");
            params.add(args.getCk_org());
        }
        if(StringUtil.isNotEmpty(args.getCk_object())){
            sql.append(" AND EXISTS (SELECT WCB.CK_OBJ_ID FROM WR_CHK_OBJECT WCB WHERE WCB.CK_OBJECT=? AND WCB.CK_OBJ_ID=T.CK_OBJ_ID ) ");
            params.add(args.getCk_object());
        }

        if(StringUtil.isNotEmpty(args.getStatus())){
            sql.append("  AND STATUS= ? ");
            params.add(args.getStatus());
        }
        if(StringUtil.isNotEmpty(args.getCk_obj_id())){
            sql.append("  AND CK_OBJ_ID= ? ");
            params.add(args.getCk_obj_id());
        }
        if(StringUtil.isNotEmpty(args.getCk_tk_desc())){
            sql.append("  AND CK_TK_DESC like ? ");
            params.add("%"+args.getCk_tk_desc()+"%");
        }
        sql.append(" ) T  ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD1 ON TSD1.ID=T.CK_TYPE ");
        sql.append(" LEFT JOIN WR_CHK_OBJECT WCO ON WCO.CK_OBJ_ID=T.CK_OBJ_ID ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD ON TSD.ID=T.CK_ORG ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD5 ON WCO.CK_OBJECT=TSD5.ID ");
        sql.append(" ORDER BY CK_RE_ID DESC ");

        return this.findEasyUiPageBySql(sql.toString(),easyUiPage,params.toArray());
    }

    @Override
    public EasyUiPage getXctjListInfoByParams(String sTime, String eTime, String dep_name, String ck_type, EasyUiPage easyUiPage) {
        StringBuffer sql = new StringBuffer();
        ArrayList params = new ArrayList();
        sql.append("SELECT B.ISU_DESC,B.ISU_STATUS,B.ISU_RESOLVE,B.RESOLVE_USER,S.*,WCO.CK_NAME,WCO.CK_ORG ,TSD2.NAME ck_org_name,wco.ck_object,tsd.name ck_object_name,wco.ck_type,tsd1.name ck_type_name,wco.ck_obj_pid FROM (" +
                "                 SELECT * from WR_CHK_RED_CHILD s WHERE S.CK_OBJ_ID IS NOT NULL" +
                "                ) s LEFT JOIN wr_chk_object wco ON s.ck_obj_id=wco.ck_obj_id" +
                "                    LEFT JOIN WR_CH_ISSUES_B B ON S.ISSUE_ID = B.ID" +
                "                    LEFT JOIN t_sys_dictionary tsd ON tsd.id=wco.ck_object" +
                "                    LEFT JOIN t_sys_dictionary tsd1 ON tsd1.id=wco.ck_type " +
                "                    LEFT JOIN t_sys_dictionary tsd2 ON tsd2.id=wco.ck_org WHERE 1=1");
        if(StringUtil.isNotEmpty(sTime)){
            sql.append(" AND S.TS>= to_date(?,'yyyy-mm-dd hh24:mi:ss')");
            params.add(sTime+" 00:00:00");
        }
        if(StringUtil.isNotEmpty(eTime)){
            sql.append(" AND S.TS<= to_date(?,'yyyy-mm-dd hh24:mi:ss')");
            params.add(eTime+" 23:59:59");
        }
        if(StringUtil.isNotEmpty(dep_name)){
            sql.append(" AND WCO.CK_ORG=?");
            params.add(dep_name);
        }
        if(StringUtil.isNotEmpty(ck_type)){
            sql.append(" AND WCO.CK_TYPE=?");
            params.add(ck_type);
        }
        sql.append(" ORDER BY S.TS DESC");
        return this.findEasyUiPageBySql(sql.toString(),easyUiPage,params.toArray());
    }


    @Override
    public Object getInfoById(String id) {
        StringBuffer sql= new StringBuffer();
        sql.append(" SELECT  T.*, decode(T.STATUS,'0','未开始','1','进行中','2','已完成') STATUS_NAME,WCO.CK_OBJECT,TSD5.NAME AS CK_OBJECT_NAME,  ");
        sql.append(" TSD1.NAME AS CK_TYPE_NAME ,WCO.CK_NAME AS CK_OBJ_ID_NAME ,TSD.NAME AS CK_ORG_NAME   FROM ( ");
        sql.append("  SELECT CK_RE_ID, CK_TK_DESC, CK_OBJ_ID, TO_CHAR(CK_BEGIN,'yyyy-mm-dd hh24:mi:ss') CK_BEGIN, ");
        sql.append("  TO_CHAR(CK_END,'yyyy-mm-dd hh24:mi:ss') CK_END, CK_ORG, ");
        sql.append("  CK_TYPE, CK_USERS, CK_TK_ID, CK_RE_PCOUNT, CK_RE_ECOUNT, CH_NOTE_USER, ");
        sql.append("  CH_REVIEW_USER, TO_CHAR(TS,'yyyy-mm-dd hh24:mi:ss') TS, STATUS, NT FROM WR_CHK_RECORD  T WHERE 1=1 ");
        if(StringUtil.isNotEmpty(id)){
            sql.append("  AND CK_RE_ID = ? ");
        }
        sql.append(" ) T  ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD1 ON TSD1.ID=T.CK_TYPE ");
        sql.append(" LEFT JOIN WR_CHK_OBJECT WCO ON WCO.CK_OBJ_ID=T.CK_OBJ_ID ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD ON TSD.ID=T.CK_ORG ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD5 ON WCO.CK_OBJECT=TSD5.ID ");
        sql.append(" ORDER BY CK_RE_ID DESC ");

        return this.findBySqlWithMap(sql.toString(),id);
    }


    public Object saveOrUpdateInfo(String dataStr) {
        WrchkRecordModel model = JsonUtil.json2Object(dataStr,WrchkRecordModel.class);
        if(model.getCk_re_id()==null || !StringUtil.isNotEmpty(model.getCk_re_id())){
            model.setCk_re_id(DseSysCommonUtil.getNewId()+"");
        }
        if(model.getTs()==null){
            model.setTs(new Date());
        }
        this.saveOrUpdate(model);
        return true;
    }


    @Override
    public Object deleteInfoByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
            StringBuffer sql=new StringBuffer();
            String[] arrIds=ids.split(",");
            sql.append(" AND CK_RE_ID IN ( ");
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

            StringBuffer sql3= new StringBuffer(" DELETE FROM WR_CHK_RED_CHILD WHERE 1=1 ");
            sql3.append(sql);

            StringBuffer sql2= new StringBuffer(" DELETE FROM WR_CHK_RECORD WHERE 1=1 ");
            sql2.append(sql);

            this.updateBySql(sql3.toString());
            this.updateBySql(sql2.toString());

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
            StringBuffer sql =new StringBuffer();
            String[] arrIds = ids.split(",");
            sql.append(" AND CK_RE_ID IN ( ");
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

            StringBuffer sql3 = new StringBuffer(" UPDATE WR_CHK_RED_CHILD T SET T.CH_STATUS='"+stauts+"' WHERE 1=1 ");
            sql3.append(" AND T.CK_RE_ID IN (SELECT WCR.CK_RE_ID　FROM WR_CHK_RECORD WCR WHERE 1=1 ");
            sql3.append(sql);
            sql3.append(" ) ");

            StringBuffer sql2 = new StringBuffer(" UPDATE WR_CHK_RECORD T SET T.STATUS='"+stauts+"' WHERE 1=1 ");
            sql2.append(sql);

            this.updateBySql(sql3.toString());

            this.updateBySql(sql2.toString());

        }
        return true;
    }

    /***
     * 根据计划生成任务方法
     * @param taskmodel
     * @return
     */
    public Object createWrChkRecordData(WrchkTaskModel taskmodel) {

        WrchkRecordModel recordmodel=new WrchkRecordModel();
        recordmodel.setCk_tk_id(taskmodel.getCk_tk_id());
        recordmodel.setCk_obj_id(taskmodel.getCk_obj_id());
        recordmodel.setCk_tk_desc(taskmodel.getCk_tk_desc());
        recordmodel.setCk_org(taskmodel.getCk_org());
        recordmodel.setCk_type(taskmodel.getCk_type());
        recordmodel.setCk_users(taskmodel.getCk_users());
        recordmodel.setCk_begin(new Date());
        recordmodel.setCk_end(taskmodel.getLast_create_date());
        recordmodel.setNt(taskmodel.getNt());
        if(recordmodel.getCk_re_id()==null || !StringUtil.isNotEmpty(recordmodel.getCk_re_id())){
            recordmodel.setCk_re_id(DseSysCommonUtil.getNewId()+"");
        }
        saveWrChkRecord(recordmodel);
        saveWrChkRedChild(recordmodel);
        updateWrChkTask(taskmodel);
        return true;
    }

    /***
     * 巡查任务
     * @param taskmodel
     * @return
     */
    public Object updateWrChkTask(WrchkTaskModel taskmodel) {
        StringBuffer sql= new StringBuffer(" ");
        sql.append(" update wr_chk_task set    ");
        sql.append(" last_create_date = TO_DATE('"+taskmodel.getLast_create_dateStr()+"','yyyy-mm-dd hh24:mi:ss') ");
        sql.append(" where ck_tk_id = '"+taskmodel.getCk_tk_id()+"'  ");
        Integer flag = this.updateBySql(sql.toString());
        return flag;
    }

    /****
     * 巡查记录信息
     * @param recordmodel
     * @return
     */
    public Object saveWrChkRecord(WrchkRecordModel recordmodel) {
        StringBuffer sql= new StringBuffer(" ");
        sql.append(" insert into wr_chk_record (ck_re_id, ck_tk_desc, ck_obj_id, ck_begin, ck_end, ck_org, ck_type ");
        sql.append(" ,ck_users, ck_tk_id,ck_re_pcount, ck_re_ecount, ts, status, nt ) ");
        sql.append(" values('"+recordmodel.getCk_re_id()+"', '"+recordmodel.getCk_tk_desc()+"', '"+recordmodel.getCk_obj_id()+"', ");
        sql.append("  TO_DATE('"+recordmodel.getCk_beginStr()+"','yyyy-mm-dd hh24:mi:ss'), TO_DATE('"+recordmodel.getCk_endStr()+"','yyyy-mm-dd hh24:mi:ss'), ");
        sql.append(" '"+recordmodel.getCk_org()+"', '"+recordmodel.getCk_type()+"', '"+recordmodel.getCk_users()+"', '"+recordmodel.getCk_tk_id()+"', ");
        sql.append("(select count(1) from wr_chk_object wco where wco.ck_obj_pid='"+recordmodel.getCk_obj_id()+"' and wco.ck_item='1'),");
        sql.append("  0,sysdate, '0', '"+recordmodel.getNt()+"') ");
        Integer flag = this.updateBySql(sql.toString());
        return flag;
    }

    /****
     * 巡查记录项目详情表
     * @param recordmodel
     * @return
     */
    public Object saveWrChkRedChild(WrchkRecordModel recordmodel) {
        StringBuffer sql= new StringBuffer(" ");
        sql.append(" insert into wr_chk_red_child(id, seq, ck_re_id, ck_obj_id,  ");
        sql.append("  ck_cnt_id, ck_cnt_desc, ck_tag_desc, ts, ch_status, nt ) ");
        sql.append(" select wr_chk_red_child_id_seq.Nextval id,wkc.seq ,");
        sql.append(" '"+recordmodel.getCk_re_id()+"' ck_re_id ");
        sql.append(" ,wkc.ck_obj_id,wkc.ck_cnt_id,");
        sql.append(" wkc.ck_cnt_desc,wkc.ck_tag_desc,sysdate ts,'0' ch_status,'"+recordmodel.getNt()+"' nt from ( ");
        sql.append("  select wco.ck_obj_id,wco.ck_obj_pid,wco.ck_object from wr_chk_object wco where  wco.ck_item='1' ");
        sql.append(" and wco.ck_obj_pid='"+recordmodel.getCk_obj_id()+"'  ");
        sql.append(" ) wco inner join wr_chk_contents wkc on wkc.ck_obj_id=wco.ck_obj_id and wkc.ck_cnt_desc is not null  ");
        Integer flag =this.updateBySql(sql.toString());
        return flag;
    }

}

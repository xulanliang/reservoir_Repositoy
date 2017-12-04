package com.dse.reservoir.sgxc.wrchktask.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.sgxc.wrchktask.pojo.WrchkTaskModel;
import com.dse.reservoir.sgxc.wrchkrecord.dao.impl.WrchkRecordImpl;
import com.dse.reservoir.sgxc.wrchktask.dao.WrchkTaskDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *巡查对象/巡查点
 */
@Repository("wrchkTaskDao")
public class WrchkTaskImpl extends BaseDao implements WrchkTaskDao {

    /***
     *
     * @param args
     * @param notcktkid
     * @return
     * @throws Exception
     */
    @Override
    public Object getWrchkTaskList(WrchkTaskModel args, String notcktkid) throws Exception{
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT  CK_TK_ID, CK_TK_DESC, CK_OBJ_ID FROM WR_CHK_TASK T WHERE 1=1 ";
        if(StringUtil.isNotEmpty(notcktkid)){
            sql += " AND CK_TK_ID != ? ";
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
        return findBySqlWithMap(sql,params.toArray());
    }

    /****
     *
     * @param args
     * @return
     * @throws Exception
     */
    @Override
    public Object getWrchkTaskCount(WrchkTaskModel args) throws Exception{
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT COUNT(*) AS NUM FROM WR_CHK_TASK WHERE 1=1 ";
        if(StringUtil.isNotEmpty(args.getCk_tk_id())){
            sql += " AND CK_TK_ID = ? ";
            params.add(args.getCk_tk_id());
        }
        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public EasyUiPage getListInfoByParams(WrchkTaskModel args, EasyUiPage easyUiPage){
        List<Object> params= new ArrayList<Object>();
        StringBuffer sql= new StringBuffer(); //hh24:mi:ss
        sql.append(" SELECT  T.*, decode(T.STATUS,'0','不活动','1','启用状态','2','暂停状态') STATUS_NAME,  ");
        sql.append(" TSD1.NAME AS CK_TYPE_NAME ,WCO.CK_NAME AS CK_OBJ_ID_NAME ,WCO.CK_OBJECT,TSD5.NAME AS CK_OBJECT_NAME,TSD.NAME AS CK_ORG_NAME ,TSD2.NAME AS CK_CYCLE_NAME  FROM ( ");
        sql.append(" SELECT CK_TK_ID, CK_TK_DESC, CK_OBJ_ID, CREATE_USER, TO_CHAR(CREATE_DATE,'yyyy-mm-dd') CREATE_DATE, ");
        sql.append(" TO_CHAR(CK_BEGIN,'yyyy-mm-dd hh24:mi') CK_BEGIN, TO_CHAR(CK_END,'yyyy-mm-dd hh24:mi') CK_END , ");
        sql.append(" CK_ORG, CK_TYPE,CK_USERS, CK_CYCLE,CK_FREQUENCY, CK_INT_HOURS, STATUS, TO_CHAR(TS,'yyyy-mm-dd hh24:mi') AS TS, NT, ");
        sql.append(" TO_CHAR(LAST_CREATE_DATE,'yyyy-mm-dd hh24:mi') LAST_CREATE_DATE FROM WR_CHK_TASK T WHERE 1=1 ");

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
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD2 ON TSD2.CODE=T.CK_CYCLE ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD5 ON WCO.CK_OBJECT=TSD5.ID ");
        sql.append(" ORDER BY CK_TK_ID DESC ");

        return this.findEasyUiPageBySql(sql.toString(),easyUiPage,params.toArray());
    }

    @Override
    public Object getInfoById(String id) {
        StringBuffer sql= new StringBuffer();//hh24:mi:ss
        sql.append(" SELECT  T.*, decode(T.STATUS,'0','不活动','1','启用状态','2','暂停状态') STATUS_NAME,  ");
        sql.append(" TSD1.NAME AS CK_TYPE_NAME ,WCO.CK_NAME AS CK_OBJ_ID_NAME ,WCO.CK_OBJECT,TSD5.NAME AS CK_OBJECT_NAME,TSD.NAME AS CK_ORG_NAME,TSD2.NAME AS CK_CYCLE_NAME FROM ( ");
        sql.append(" SELECT CK_TK_ID, CK_TK_DESC, CK_OBJ_ID, CREATE_USER, TO_CHAR(CREATE_DATE,'yyyy-mm-dd hh24:mi:ss') CREATE_DATE, ");
        sql.append(" TO_CHAR(CK_BEGIN,'yyyy-mm-dd hh24:mi:ss') CK_BEGIN, TO_CHAR(CK_END,'yyyy-mm-dd hh24:mi:ss') CK_END , ");
        sql.append(" CK_ORG, CK_TYPE,CK_USERS, CK_CYCLE,CK_FREQUENCY, CK_INT_HOURS, STATUS, TO_CHAR(TS,'yyyy-mm-dd hh24:mi:ss') AS TS, NT, ");
        sql.append(" TO_CHAR(LAST_CREATE_DATE,'yyyy-mm-dd hh24:mi:ss') LAST_CREATE_DATE FROM WR_CHK_TASK T WHERE 1=1 ");
        if(StringUtil.isNotEmpty(id)){
            sql.append("  AND CK_TK_ID = ? ");
        }
        sql.append(" ) T  ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD1 ON TSD1.ID=T.CK_TYPE ");
        sql.append(" LEFT JOIN WR_CHK_OBJECT WCO ON WCO.CK_OBJ_ID=T.CK_OBJ_ID ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD ON TSD.ID=T.CK_ORG ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD2 ON TSD2.CODE=T.CK_CYCLE ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD5 ON WCO.CK_OBJECT=TSD5.ID ");
        sql.append(" ORDER BY CK_TK_ID DESC ");

        return this.findBySqlWithMap(sql.toString(),id);
    }


    public Object saveOrUpdateInfo(String dataStr) {
        WrchkTaskModel model = JsonUtil.json2Object(dataStr,WrchkTaskModel.class);
        if(model.getCk_tk_id()==null || !StringUtil.isNotEmpty(model.getCk_tk_id())){
            model.setCk_tk_id(DseSysCommonUtil.getNewId()+"");
        }
        if(model.getTs()==null){
            model.setTs(new Date());
        }
        if(model.getCreate_date()==null){
            model.setCreate_date(new Date());
        }
        this.saveOrUpdate(model);
        return true;
    }

    @Override
    public Object deleteInfoByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
            String[] arrIds=ids.split(",");
            StringBuffer idsStr=new StringBuffer();
            for(int i=0;i<arrIds.length;i++){
                if((i+1)==arrIds.length){
                    idsStr.append(" '"+arrIds[i]+"' ");
                }else{
                    idsStr.append(" '"+arrIds[i]+"', ");
                }
            }
            /**
             * 删除巡查记录任务和巡查记录详情
             */
            StringBuffer str = new StringBuffer("SELECT D.CK_RE_ID FROM WR_CHK_RECORD D WHERE D.CK_TK_ID IN( ");
            str.append(idsStr.toString()+" )");
            List list= (List) this.findBySqlWithMap(str.toString());
            String codes = "";
            for(int i=0;i<list.size();i++){
                Map map = (Map) list.get(i);
                String code = (String) map.get("CK_RE_ID");
                if(list.size() !=1 && i!=0){
                    codes+=","+code;
                }else {
                    codes+=code;
                }
            }
            deleteinfoByIds(codes);


            StringBuffer sql= new StringBuffer(" DELETE FROM WR_CHK_TASK WHERE 1=1 ");
            sql.append(" AND CK_TK_ID IN ( ");
            sql.append(idsStr.toString());
            sql.append(" ) ");
            this.updateBySql(sql.toString());
        }
        return true;
    }

    public Object deleteinfoByIds(String ids) {
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


    /****
     *
     * @param args
     * @return
     * @throws Exception
     */
    public Object getJobWrchkTaskList(WrchkTaskModel args) throws Exception{
        List<Object> params = new ArrayList<Object>();
        StringBuffer sql =new StringBuffer();
        sql.append(" SELECT CK_TK_ID, CK_TK_DESC, CK_OBJ_ID, CREATE_USER, CREATE_DATE,CK_BEGIN, CK_END, CK_ORG, CK_TYPE, CK_USERS, CK_CYCLE, CK_FREQUENCY, ") ;
        sql.append("  CK_INT_HOURS,LAST_CREATE_DATE FROM WR_CHK_TASK T WHERE 1=1 ");
        if(args!=null && StringUtil.isNotEmpty(args.getTaskids())){
            String ck_tk_ids = args.getTaskids();
            ck_tk_ids = ck_tk_ids.replace(",","','");
            sql.append(" AND T.CK_TK_ID IN ('','"+ck_tk_ids+"') ");
        }else{
            sql.append(" AND T.STATUS='1' ");
            sql.append(" AND (( T.CK_BEGIN is null or T.CK_BEGIN<=SYSDATE ) AND ( T.CK_END is null or T.CK_END>= SYSDATE ) ) ");
            sql.append(" AND (T.LAST_CREATE_DATE IS NULL OR T.LAST_CREATE_DATE<=SYSDATE  OR (T.LAST_CREATE_DATE-(5/(24*60)))<=SYSDATE ) ");
        }
        return findBySqlWithMap(sql.toString(),params.toArray());
    }

    /**
     *
     * @param args
     * @return
     * @throws Exception
     */
    public List<WrchkTaskModel> getJobWrchkTaskList2(WrchkTaskModel args) throws Exception{
        StringBuffer hql =new StringBuffer();
        hql.append("  FROM WrchkTaskModel T WHERE 1=1 ");
        if(args!=null && StringUtil.isNotEmpty(args.getTaskids())){
            String ck_tk_ids = args.getTaskids();
            ck_tk_ids = ck_tk_ids.replace(",","','");
            hql.append(" AND T.ck_tk_id IN ('','"+ck_tk_ids+"') ");
        }else {
            hql.append(" AND T.status='1' ");
            hql.append("  AND ((T.ck_begin is null or T.ck_begin<=SYSDATE ) AND ( T.ck_end is null or  T.ck_end>= SYSDATE ) ) ");
            hql.append("  AND (T.last_create_date IS NULL OR T.last_create_date<=SYSDATE  OR (T.last_create_date-(5/(24*60)))<=SYSDATE ) ");
        }
        return findByHql(hql.toString());

    }

}

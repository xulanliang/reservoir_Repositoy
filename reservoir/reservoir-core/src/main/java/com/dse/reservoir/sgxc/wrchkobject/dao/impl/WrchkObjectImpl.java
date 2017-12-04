package com.dse.reservoir.sgxc.wrchkobject.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.sgxc.wrchkobject.pojo.WrchkObjectModel;
import com.dse.reservoir.api.sgxc.wrchkobject.pojo.XcnrModel;
import com.dse.reservoir.sgxc.wrchkobject.dao.WrchkObjectDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *巡查对象/巡查点
 */
@Repository("wrchkObjectDao")
public class WrchkObjectImpl extends BaseDao implements WrchkObjectDao {

    /***
     *
     * @param args
     * @param notCkObjId
     * @return
     * @throws Exception
     */
    @Override
    public Object getWrChkObjectList(WrchkObjectModel args,String notCkObjId) throws Exception{
        List<Object> params = new ArrayList<Object>();
//        String sql = "SELECT T.CK_OBJ_ID,T.CK_NAME,T.CK_OBJ_PID FROM WR_CHK_OBJECT T WHERE 1=1 ";
        String sql = " SELECT T.*  FROM WR_CHK_OBJECT T WHERE 1=1 ";

        if(StringUtil.isNotEmpty(notCkObjId)){
            sql += " AND CK_OBJ_ID != ? ";
            params.add(notCkObjId);
        }
        if(StringUtil.isNotEmpty(args.getCk_obj_pid())){
            sql += " AND CK_OBJ_PID = ? ";
            params.add(args.getCk_obj_pid());
        }
        if(StringUtil.isNotEmpty(args.getCk_org())){
            sql += " AND CK_ORG = ? ";
            params.add(args.getCk_org());
        }
        if(StringUtil.isNotEmpty(args.getCk_object())){
            sql += " AND CK_OBJECT = ? ";
            params.add(args.getCk_object());
        }
        if(StringUtil.isNotEmpty(args.getCk_type())){
            sql += " AND CK_TYPE = ? ";
            params.add(args.getCk_type());
        }
        if(StringUtil.isNotEmpty(args.getRootNode())){
            sql += " AND ( CK_OBJ_PID is null or CK_OBJ_PID='' ) ";
        }
        if(StringUtil.isNotEmpty(args.getCk_obj_id())){
            sql += " AND CK_OBJ_ID = ? ";
            params.add(args.getCk_obj_id());
        }
        if(StringUtil.isNotEmpty(args.getCk_item())){
            sql += " AND CK_ITEM = ? ";
            params.add(args.getCk_item());
        }
        sql += " ORDER BY SEQ,CK_OBJ_ID  ";
        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object getXcnrInfoById(String id) throws Exception {
        String sql = "SELECT B.*,wco.ck_name,wco.ck_org ,tsd2.name ck_org_name,wco.ck_object,tsd.name ck_object_name,wco.ck_type,tsd1.name ck_type_name,wco.ck_obj_pid FROM (" +
                " SELECT S.CK_CNT_ID,S.CK_CNT_DESC,S.CK_TAG_DESC,S.CK_OBJ_ID,S.CK_TM_REQ,S.SEQ,S.TS,S.NT,S.CK_TYPE TYPEE,S.TYPE from WR_CHK_CONTENTS S WHERE S.CK_CNT_ID =? " +
                ") B LEFT JOIN wr_chk_object wco ON B.ck_obj_id=wco.ck_obj_id " +
                "    LEFT JOIN t_sys_dictionary tsd ON tsd.id=wco.ck_object " +
                "    LEFT JOIN t_sys_dictionary tsd1 ON tsd1.id=wco.ck_type " +
                "    LEFT JOIN t_sys_dictionary tsd2 ON tsd2.id=wco.ck_org";
        return this.findBySqlWithMap(sql,id);
    }

    /****
     *
     * @param args
     * @return
     * @throws Exception
     */
    @Override
    public Object getWrChkObjectCount(WrchkObjectModel args) throws Exception{
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT COUNT(*) AS NUM FROM WR_CHK_OBJECT WHERE 1=1 ";
        if(StringUtil.isNotEmpty(args.getCk_obj_pid())){
            sql += " AND CK_OBJ_PID = ? ";
            params.add(args.getCk_obj_pid());
        }
        if(StringUtil.isNotEmpty(args.getCk_obj_id())){
            sql += " AND CK_OBJ_ID = ? ";
            params.add(args.getCk_obj_id());
        }
        if(StringUtil.isNotEmpty(args.getCk_item())){
            sql += " AND CK_ITEM = ? ";
            params.add(args.getCk_item());
        }
        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public EasyUiPage getListInfoByParams(WrchkObjectModel args, EasyUiPage easyUiPage){
        List<Object> params= new ArrayList<Object>();
        StringBuffer sql= new StringBuffer();
        sql.append(" SELECT  T.CK_OBJ_ID, T.CK_NAME, T.CK_ORG, T.CK_OBJECT, T.CK_OBJ_PID,WCO.CK_NAME AS CK_OBJ_PID_NAME, T.CK_TYPE,T.CK_MG_PRO, T.LGTD, ");
        sql.append(" T.LTTD, T.CK_WIR_RADIUS, T.CK_RADIUS,T.CK_TM_REQ, T.SEQ,T.LOC,T.TS, T.NT, T.CK_ITEM, T.TERM_CD,");
        sql.append(" TSD1.NAME AS CK_TYPE_NAME ,");//TSD2.NAME AS CK_OBJECT_NAME
        if((args.getCk_item()).equals("1")){
            //巡查点
            if(StringUtil.isNotEmpty(args.getCk_object())){
                sql.append("(SELECT TT.CK_NAME FROM WR_CHK_OBJECT TT WHERE TT.CK_OBJ_ID = ? )AS CK_OBJECT_NAME");
                params.add(args.getCk_object());
            }else{
                sql.append("TSD2.NAME AS CK_OBJECT_NAME");
            }
        }else {
            //巡查对象
            sql.append("TSD2.NAME AS CK_OBJECT_NAME");
        }
        /*if(StringUtil.isNotEmpty(args.getCk_object())){
            sql.append("(SELECT TT.CK_NAME FROM WR_CHK_OBJECT TT WHERE TT.CK_OBJ_ID = ? )AS CK_OBJECT_NAME");
            params.add(args.getCk_object());
        }*//*else{
            sql.append("TSD2.NAME AS CK_OBJECT_NAME");
        }*/
        sql.append(",TSD.NAME AS CK_ORG_NAME FROM ( ");
        sql.append("  SELECT CK_OBJ_ID, CK_NAME, CK_ORG, CK_OBJECT, CK_OBJ_PID, CK_TYPE, ");
        sql.append(" CK_MG_PRO, LGTD, LTTD, CK_WIR_RADIUS, CK_RADIUS, CK_TM_REQ, SEQ, LOC, ");
        sql.append(" TO_CHAR(TS,'yyyy-mm-dd hh24:mi:ss') AS TS , NT, CK_ITEM, TERM_CD FROM WR_CHK_OBJECT T WHERE 1=1 ");

        if(StringUtil.isNotEmpty(args.getCk_type())){
            sql.append(" AND CK_TYPE= ?  ");
            params.add(args.getCk_type());
        }
        if(StringUtil.isNotEmpty(args.getCk_object())){
            sql.append("  AND CK_OBJECT = (SELECT DD.CK_OBJECT FROM WR_CHK_OBJECT DD WHERE DD.CK_OBJ_ID = ? ) ");
            params.add(args.getCk_object());
        }
        if(StringUtil.isNotEmpty(args.getCk_org())){
            sql.append("  AND CK_ORG= ? ");
            params.add(args.getCk_org());
        }
        if(StringUtil.isNotEmpty(args.getCk_item())){
            sql.append("  AND CK_ITEM= ? ");
            params.add(args.getCk_item());
        }
        if(StringUtil.isNotEmpty(args.getCk_obj_pid())){
//            sql.append("  AND CK_OBJ_PID= ? ");
            sql.append("  AND CK_OBJECT= ? ");
            params.add(args.getCk_obj_pid());
        }
        if(StringUtil.isNotEmpty(args.getCk_name())){
            sql.append("  AND CK_NAME like ? ");
            params.add("%"+args.getCk_name()+"%");
        }
        sql.append(" ) T  ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD1 ON TSD1.ID=T.CK_TYPE ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD2 ON TSD2.ID=T.CK_OBJECT ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD ON TSD.ID=T.CK_ORG ");
        sql.append(" LEFT JOIN WR_CHK_OBJECT WCO ON WCO.CK_OBJ_ID=T.CK_OBJ_PID ");
        sql.append(" ORDER BY CK_OBJ_ID DESC ");

        return this.findEasyUiPageBySql(sql.toString(),easyUiPage,params.toArray());
    }

    @Override
    public EasyUiPage getXcnrListInfoByParams(String depID,String objID,String CK_OBJ_ID, EasyUiPage easyUiPage) {
        ArrayList param = new ArrayList();
        String sql = "SELECT TT.CK_NAME,S.* FROM WR_CHK_CONTENTS S LEFT JOIN WR_CHK_OBJECT TT ON S.CK_OBJ_ID =TT.CK_OBJ_ID WHERE 1=1 ";
        String extend="";
        if(StringUtil.isNotEmpty(depID)){
            extend=" AND S.CK_OBJ_ID IN (SELECT T.CK_OBJ_ID FROM WR_CHK_OBJECT T WHERE T.CK_ORG =? AND T.CK_ITEM=1 ) ";
            param.add(depID);
        }
        if(StringUtil.isNotEmpty(objID)){
            extend=" AND S.CK_OBJ_ID IN (SELECT T.CK_OBJ_ID FROM WR_CHK_OBJECT T WHERE T.CK_ORG =? AND T.CK_ITEM=1 AND T.CK_OBJECT=?) ";
            param.add(objID);
        }
        if(StringUtil.isNotEmpty(CK_OBJ_ID)){
            extend=" AND S.CK_OBJ_ID=?";
            param.clear();
            param.add(CK_OBJ_ID);
        }
//        if(StringUtil.isNotEmpty(CK_OBJ_ID)){
//            param.add(CK_OBJ_ID);
//            sql=sql+"and s.CK_OBJ_ID=?";
//        }
        return this.findEasyUiPageBySql(sql+extend,easyUiPage,param.toArray());
    }

    @Override
    public Object getInfoById(String id) {
        StringBuffer sql= new StringBuffer();
        sql.append(" SELECT  T.CK_OBJ_ID, T.CK_NAME, T.CK_ORG, T.CK_OBJECT, T.CK_OBJ_PID,WCO.CK_NAME AS CK_OBJ_PID_NAME, T.CK_TYPE,T.CK_MG_PRO, T.LGTD, ");
        sql.append(" T.LTTD, T.CK_WIR_RADIUS, T.CK_RADIUS,T.CK_TM_REQ, T.SEQ,T.LOC,T.TS, T.NT, T.CK_ITEM, T.TERM_CD,");
        sql.append(" TSD1.NAME AS CK_TYPE_NAME ,TSD2.NAME AS CK_OBJECT_NAME  ,TSD.NAME AS CK_ORG_NAME FROM ( ");
        sql.append("  SELECT CK_OBJ_ID, CK_NAME, CK_ORG, CK_OBJECT, CK_OBJ_PID, CK_TYPE, ");
        sql.append(" CK_MG_PRO, LGTD, LTTD, CK_WIR_RADIUS, CK_RADIUS, CK_TM_REQ, SEQ, LOC, ");
        sql.append(" TO_CHAR(TS,'YYYY-MM-DD HH24:MI:SS') AS TS , NT, CK_ITEM, TERM_CD FROM WR_CHK_OBJECT T WHERE 1=1 ");

        if(StringUtil.isNotEmpty(id)){
            sql.append(" AND CK_OBJ_ID= ? ");
        }
        sql.append(" ) T  ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD1 ON TSD1.ID=T.CK_TYPE ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD2 ON TSD2.ID=T.CK_OBJECT ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD ON TSD.ID=T.CK_ORG ");
        sql.append(" LEFT JOIN WR_CHK_OBJECT WCO ON WCO.CK_OBJ_ID=T.CK_OBJ_PID ");
        return this.findBySqlWithMap(sql.toString(),id);
    }


    public Object saveOrUpdateInfo(String dataStr) {
        WrchkObjectModel model = JsonUtil.json2Object(dataStr,WrchkObjectModel.class);
        if(model.getCk_obj_id()==null || !StringUtil.isNotEmpty(model.getCk_obj_id())){
            model.setCk_obj_id(DseSysCommonUtil.getNewId()+"");
        }
        if(model.getTs()==null){
            model.setTs(new Date());
        }
        this.saveOrUpdate(model);
        return true;
    }

    @Override
    public Object saveOrUpdateXcnrInfo(String dataStr,String checkID) {
        if(StringUtil.isNotEmpty(dataStr)){
            XcnrModel xcnrModel = JsonUtil.json2Object(dataStr,XcnrModel.class);
            if(StringUtil.isNotEmpty(checkID)){
                xcnrModel.setCK_OBJ_ID(checkID);
            }
            if(xcnrModel.getCK_CNT_ID()==null || !StringUtil.isNotEmpty(xcnrModel.getCK_CNT_ID())){
                xcnrModel.setCK_CNT_ID(DseSysCommonUtil.getNewId()+"");
            }
            if(xcnrModel.getTS()==null){
                xcnrModel.setTS(new Date());
            }
            this.saveOrUpdate(xcnrModel);
        }
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
            StringBuffer sql4= new StringBuffer(" DELETE FROM WR_CHK_CONTENTS WHERE 1=1 AND ( CK_OBJ_ID IN ("+idsStr.toString()+" ) OR CK_OBJ_ID IN ( SELECT CK_OBJ_ID FROM WR_CHK_OBJECT WHERE CK_OBJ_PID IN ("+idsStr.toString()+") ) ) ");
            StringBuffer sql3= new StringBuffer(" DELETE FROM WR_CHK_OBJECT WHERE 1=1 AND CK_OBJ_PID IN ("+idsStr.toString()+" )");
            StringBuffer sql2= new StringBuffer(" DELETE FROM WR_CHK_OBJECT WHERE 1=1  AND CK_OBJ_ID IN ("+idsStr.toString()+" )");
            this.updateBySql(sql4.toString());
            this.updateBySql(sql3.toString());
            this.updateBySql(sql2.toString());

        }
        return true;
    }

    @Override
    public Object deleteXcnrInfoByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
            StringBuffer sql= new StringBuffer(" DELETE FROM WR_CHK_CONTENTS WHERE 1=1 ");
            String[] arrIds=ids.split(",");
            sql.append(" AND CK_CNT_ID IN ( ");
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
            this.updateBySql(sql.toString());
        }
        return true;
    }

}

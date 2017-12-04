package com.dse.reservoir.fxwz.wzcfxx.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.fxwz.wzcfxx.pojo.WzcfxxModel;
import com.dse.reservoir.fxwz.wzcfxx.dao.WzcfxxDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Repository("wzcfxxDao")
public class WzcfxxDaoImpl extends BaseDao implements WzcfxxDao {


    @Override
    public EasyUiPage getListInfoByParams(String ckname, String wzname, String year, EasyUiPage easyUiPage){

        List<Object> params= new ArrayList<Object>();
        String sql = "SELECT (WZCK.ID) AS ID,(WZCK.YEAR) AS YEAR ,(WZCK.PC) AS PC ,(WZCK.WZNUM) AS WZNUM," +
                "(WZCK.KYNUM) AS KYNUM,(WZCK.SHNUM) AS SHNUM,(WZCK.JSRNAME) AS JSRNAME,(WZCK.REMARK) AS REMARK," +
                "CK.CKNAME,WZ.WZNAME FROM DSE_SF_WZCF_INFO_B WZCK,DSE_SF_WZ_INFO_B WZ,DSE_SF_CK_INFO_B CK " +
                "WHERE WZCK.CKID = CK.CKID AND WZCK.WZID = WZ.WZID ";

        if(StringUtil.isNotEmpty(ckname)){
            sql += " AND CK.CKNAME LIKE ? ";
            params.add("%"+ckname+"%");
        }
        if(StringUtil.isNotEmpty(wzname)){
            sql +=" AND WZ.WZNAME LIKE ? ";
            params.add("%"+wzname+"%");
        }
        if(StringUtil.isNotEmpty(year)){
            sql +=" AND WZCK.YEAR = ? ";
            params.add(year);
        }
        sql +=" ORDER BY WZCK.ID DESC ";
        return this.findEasyUiPageBySql(sql,easyUiPage,params.toArray());
       // return getDao().findSQLByEasyUiPage(sql,easyUiPage,params.toArray());
    }


    @Override
    public Object getInfoById(String id) {
//    return getDao().executeSQLRetMap("select (wzck.id) as id,(wzck.year) as year ,(wzck.pc) " +
//            "as pc ,(wzck.wznum) as wznum,(wzck.kynum) as kynum,(wzck.shnum)" +
//            " as shnum,(wzck.jsrname) as jsrname,(wzck.remark) as remark,ck.ckname,wz.wzname from " +
//            " sf_wz_cfinfo_b wzck,sf_wz_baseinfo_b wz,sf_ck_baseinfo_b ck " +
//            " where wzck.ckid = ck.ckid and wzck.wzid = wz.wzid and wzck.id=? ",id);

        StringBuffer sql= new StringBuffer("SELECT WZCK.ID,WZCK.CKID,WZCK.WZID,WZCK.YEAR ,WZCK.PC ," +
                "WZCK.WZNUM,WZCK.KYNUM,WZCK.SHNUM,WZCK.JSRNAME,WZCK.REMARK,CK.CKNAME,WZ.WZNAME" +
                " FROM DSE_SF_WZCF_INFO_B WZCK,DSE_SF_WZ_INFO_B WZ,DSE_SF_CK_INFO_B CK " +
                "WHERE WZCK.CKID = CK.CKID AND WZCK.WZID = WZ.WZID " +
                "AND WZCK.ID= ? ");

        return this.findBySqlWithMap(sql.toString(),id);

        // return getDao().executeSQLRetMap(sql.toString(),id);
    }


    public Object saveOrUpdateInfo(String dataStr) {
        WzcfxxModel model = JsonUtil.json2Object(dataStr,WzcfxxModel.class);
        if(model.getId()==null){
            model.setId(DseSysCommonUtil.getNewId());
        }
        this.saveOrUpdate(model);
        //getDao().saveOrUpdate(model);
        return true;
    }
    @Override
    public Object deleteInfoByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
            List<Object> params=new ArrayList<Object>() ;
            StringBuffer sql= new StringBuffer(" DELETE FROM DSE_SF_WZCF_INFO_B WHERE 1=1 ");
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
            //getDao().executeSQLInsertOrUpdate(sql.toString(),params.toArray());
        }
        return true;
    }

    @Override
    public EasyUiPage getCkListInfo(EasyUiPage easyUiPage) {
        StringBuffer selectSql=new StringBuffer();
        selectSql.append("SELECT T.CKID,T.CKNAME,T.CKADDRESS,T.WZLY,T.FZRNAME,T.FZRTEL FROM DSE_SF_CK_INFO_B T");
        //return getDao().findSQLByEasyUiPage(selectSql.toString(),easyUiPage);
        return this.findEasyUiPageBySql(selectSql.toString(),easyUiPage);
    }

    @Override
    public EasyUiPage getWzListInfo(EasyUiPage easyUiPage) {
        StringBuffer selectSql=new StringBuffer();
        selectSql.append("SELECT T.WZID,T.WZNAME,T.XHCS,T.WZCJ,T.REMARK FROM DSE_SF_WZ_INFO_B T");
        //return getDao().findSQLByEasyUiPage(selectSql.toString(),easyUiPage);
        return this.findEasyUiPageBySql(selectSql.toString(),easyUiPage);
    }


}

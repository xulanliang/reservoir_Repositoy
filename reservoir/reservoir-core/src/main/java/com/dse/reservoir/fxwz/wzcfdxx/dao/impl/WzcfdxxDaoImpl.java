package com.dse.reservoir.fxwz.wzcfdxx.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.fxwz.wzcfdxx.pojo.WzcfdxxModel;
import com.dse.reservoir.fxwz.wzcfdxx.dao.WzcfdxxDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Repository("wzcfdxxDao")
public class WzcfdxxDaoImpl extends BaseDao implements WzcfdxxDao {


    @Override
    public EasyUiPage getListInfoByParams(String adcd, String ckname, String year, EasyUiPage easyUiPage) {
        StringBuffer selectSql=new StringBuffer();
        selectSql.append("SELECT T.CKID,T.CKNAME,T.YEAR,T.LGTD,T.LTTD,T.ADCD,T.CKADDRESS,T.WZLY,T.LXTEL,T.FZRNAME," +
                "T.FZRTEL,T.REMARK ,B.NAME FROM DSE_SF_CK_INFO_B T left JOIN T_SYS_DIVISION B ON T.ADCD=B.ID WHERE 1=1");
        ArrayList<Object> params=new ArrayList<Object>();
        if(StringUtil.isNotEmpty(adcd)){
            selectSql.append(" AND T.ADCD=?");
            params.add(adcd);
        }
        if(StringUtil.isNotEmpty(ckname)){
            selectSql.append(" AND T.CKNAME LIKE ?");
            params.add("%"+ckname+"%");
        }
        if(StringUtil.isNotEmpty(year)){
            selectSql.append(" AND T.YEAR =?");
            params.add(year);
        }

        selectSql.append(" ORDER BY T.CKID DESC");
        return findEasyUiPageBySql(selectSql.toString(),easyUiPage,params.toArray());
        // return getDao().findSQLByEasyUiPage(selectSql.toString(),easyUiPage,params.toArray());
    }

    @Override
    public Object deleteInfoByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
            List<Object> params=new ArrayList<Object>() ;
            StringBuffer sql= new StringBuffer("DELETE FROM DSE_SF_CK_INFO_B WHERE 1=1");
            String[] arrIds=ids.split(",");
            sql.append(" AND CKID IN(");
            for(int i=0;i<arrIds.length;i++){
                if((i+1)==arrIds.length){
                    sql.append("?)");
                    params.add(arrIds[i]);
                }else{
                    sql.append("?,");
                    params.add(arrIds[i]);
                }
            }
            this.updateBySql(sql.toString(),params.toArray());
           // getDao().executeSQLInsertOrUpdate(sql.toString(),params.toArray());
        }
        return true;
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            WzcfdxxModel model = JsonUtil.json2Object(dataStr,WzcfdxxModel.class);
            if(model.getCkid()==null){
                model.setCkid(DseSysCommonUtil.getNewId());
            }
            this.saveOrUpdate(model);
            // getDao().saveOrUpdate(model);
        }
        return true;
    }

    @Override
    public Object getInfoById(String ckid) {
        StringBuffer selectSql=new StringBuffer();
        selectSql.append("SELECT T.CKID,T.CKNAME,T.YEAR,T.LGTD,T.LTTD,T.ADCD,T.CKADDRESS," +
                "T.WZLY,T.LXTEL,T.FZRNAME,T.FZRTEL,T.REMARK FROM DSE_SF_CK_INFO_B T WHERE T.CKID=?");

        return this.findBySqlWithMap(selectSql.toString(),ckid);
        // return getDao().executeSQLRetMap(selectSql.toString(),ckid);
    }


}

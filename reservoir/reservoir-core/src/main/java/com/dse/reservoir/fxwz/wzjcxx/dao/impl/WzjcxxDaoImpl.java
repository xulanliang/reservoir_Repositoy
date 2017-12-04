package com.dse.reservoir.fxwz.wzjcxx.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.fxwz.wzjcxx.pojo.WzjcxxModel;
import com.dse.reservoir.fxwz.wzjcxx.dao.WzjcxxDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Repository("wzjcxxDao")
public class WzjcxxDaoImpl extends BaseDao implements WzjcxxDao {

    @Override
    public EasyUiPage getListInfoByParams(String wzname, String wztype, EasyUiPage easyUiPage) {
        StringBuffer selectSql=new StringBuffer();
        ArrayList<Object> params=new ArrayList<Object>();
        selectSql.append("SELECT T.WZID,T.WZNAME,T.WZDW,T.WZDJ," +
                "CASE T.WZTYPE " +
                "    WHEN '0' THEN '工程抢险机具' WHEN '1' THEN '工程抢险物料' WHEN '2' THEN '救生救援器材'  " +
                "    WHEN '3' THEN '应急照明器材' WHEN '4' THEN '抗旱器具物料'WHEN '5' THEN '其他' " +
                "    END AS WZTYPE," +
                "T.XHCS,T.WZCJ,T.REMARK,T.LTEL FROM DSE_SF_WZ_INFO_B T WHERE 1=1");
        if(StringUtil.isNotEmpty(wzname)){
            selectSql.append(" AND T.WZNAME LIKE ?");
            params.add("%"+wzname+"%");
        }
        if(StringUtil.isNotEmpty(wztype)){
            selectSql.append(" AND T.WZTYPE =?");
            params.add(wztype);
        }
        selectSql.append(" ORDER BY T.WZID DESC");
        return this.findEasyUiPageBySql(selectSql.toString(),easyUiPage,params.toArray());
      //  return getDao().findSQLByEasyUiPage(selectSql.toString(),easyUiPage,params.toArray());
    }

    @Override
    public Object getInfoById(String wzid) {
        return this.findBySqlWithMap("SELECT * FROM DSE_SF_WZ_INFO_B T WHERE T.WZID=?",wzid);
       // return getDao().executeSQLRetMap("SELECT * FROM DSE_SF_WZ_INFO_B T WHERE T.WZID=?",wzid);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            WzjcxxModel model = JsonUtil.json2Object(dataStr,WzjcxxModel.class);
            if(model.getWzid()==null){
                model.setWzid(DseSysCommonUtil.getNewId());
            }
            this.saveOrUpdate(model);
            //getDao().saveOrUpdate(model);
        }
        return true;
    }

    @Override
    public Object deleteInfoByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
            List<Object> params=new ArrayList<Object>() ;
            StringBuffer sql= new StringBuffer("DELETE FROM DSE_SF_WZ_INFO_B WHERE 1=1");
            String[] arrIds=ids.split(",");
            sql.append(" AND WZID IN(");
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
            // getDao().executeSQLInsertOrUpdate(sql.toString(),params.toArray());
        }
        return true;
    }
}

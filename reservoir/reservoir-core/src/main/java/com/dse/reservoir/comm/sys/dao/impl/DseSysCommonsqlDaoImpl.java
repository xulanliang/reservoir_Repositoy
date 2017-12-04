package com.dse.reservoir.comm.sys.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.comm.sys.dao.DseSysCommonsqlDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/30.
 */

@Repository("dseSysCommonsqlDao")
public class DseSysCommonsqlDaoImpl  extends BaseDao implements DseSysCommonsqlDao {


    @Override
    public Object divisionInfo(String code) {
        List<Object> param = new ArrayList<Object>();
        String sql = "SELECT D.ID,D.CODE,D.NAME,D.PID FROM T_SYS_DIVISION D WHERE 1=1 ";
        if(StringUtil.isNotEmpty(code)){
            sql += " AND D.CODE LIKE ? ";
            param.add(getCode(code)+"%");
        }
        sql += " ORDER BY D.CODE,D.ORDER_INDEX ASC";

        return this.findBySqlWithMap(sql, param.toArray());
        //return getDao().executeSQLRetMap(sql, param.toArray());
    }

    @Override
    public Object getStationInfo(Map<String, String> dataMap) throws Exception {
        return null;
    }

    @Override
    public Object getListBycode(String ids,String state,String pcode) throws Exception {
        List<Object> param = new ArrayList<Object>();
        String sql = " SELECT T.ID,T.CODE,T.NAME,T.PID,T.DESCRIPTION FROM T_SYS_DICTIONARY T WHERE T.DEL_FLAG='0' ";
        if(StringUtil.isNotEmpty(pcode)){
            sql += " AND T.PID IN (SELECT TSD.ID FROM T_SYS_DICTIONARY TSD WHERE TSD.CODE= ? ) ";
            param.add(pcode);
            //如果编码为“wzmc”，为查询对应仓库中的物资信息
            if(StringUtil.isNotEmpty(state)){
//                sql="SELECT B.MU,B.MODEL,B.MA_NM,Y.* FROM WR_MA_INVENTORY Y LEFT JOIN WR_MATERIAL_B B ON Y.MA_CD = B.MA_CD WHERE Y.WH_CD = ?";
                sql = "SELECT * FROM WR_MATERIAL_B B";
                return this.findBySqlWithMap(sql);
            }
            //通过 仓库id 查询物资信息
            if(StringUtil.isNotEmpty(ids)){
                String [] id = ids.split(",");

                sql="SELECT B.MU,B.MODEL,B.MA_NM,Y.* FROM WR_MA_INVENTORY Y LEFT JOIN WR_MATERIAL_B B ON Y.MA_CD = B.MA_CD WHERE Y.ORG_CD = ? AND Y.WH_CD = ?";
                return this.findBySqlWithMap(sql,id[0],id[1]);
            }
        }
        sql += " ORDER BY T.ORDER_INDEX ASC";
        //巡查对象
        if(pcode.equals("XCDXX")){
            sql = "SELECT T.CK_NAME NAME,T.CK_OBJ_ID ID FROM WR_CHK_OBJECT T WHERE T.CK_ITEM = '0'";
            param.clear();
//            param.add(pcode);
        }
        return this.findBySqlWithMap(sql, param.toArray());
    }

    @Override
    public Object getWzInfoBycode2(String id) throws Exception {
        StringBuffer sql=new StringBuffer();
        List params = new ArrayList();
        String [] idArr = id.split(",");
        if (idArr.length > 1) {
            sql.append("SELECT T.*,B.MA_NM,B.MODEL,B.MU FROM (SELECT Y.* FROM WR_MA_INVENTORY Y WHERE 1=1" +
                    "               AND Y.ORG_CD = ?" +
                    "               AND Y.WH_CD = ?" +
                    "               AND Y.MA_CD = ?) T " +
                    "LEFT JOIN WR_MATERIAL_B B ON T.MA_CD = B.MA_CD");
            params.add(idArr[0]);
            params.add(idArr[1]);
            params.add(idArr[2]);
        }else{
            params.clear();
            sql.append("SELECT * FROM WR_MATERIAL_B B WHERE 1=1 AND B.MA_CD =?");
            params.add(idArr[0]);
        }
        return this.findBySqlWithMap(sql.toString(),params.toArray());
    }

    @Override
    public Object getListCheckObj(String pcode, String ck_org) throws Exception {
        StringBuffer sql=new StringBuffer();
        ArrayList params = new ArrayList();
        sql.append("SELECT * FROM WR_CHK_OBJECT T WHERE T.CK_ITEM = 0 ");
        if(StringUtil.isNotEmpty(ck_org)){
            sql.append(" AND T.CK_ORG=?");
            params.add(ck_org);
        }
        sql.append(" ORDER BY T.SEQ ASC");
        return this.findBySqlWithMap(sql.toString(), params.toArray());
    }


    /**
     * 去除行政区划右边‘000’
     */
    public static String  getCode(String adcd) {
        String code = adcd.trim();
        if (StringUtil.isNotEmpty(code)) {
            while (code.length()>6 &&"000".equals(code.substring(code.length() - 3, code.length()))) {
                code = code.substring(0, code.length() - 3);
            }

            while (code.length() < 7&& "00".equals(code.substring(code.length() - 2,code.length()))) {
                code = code.substring(0, code.length() - 2);
            }
        }

        return code;
    }
}

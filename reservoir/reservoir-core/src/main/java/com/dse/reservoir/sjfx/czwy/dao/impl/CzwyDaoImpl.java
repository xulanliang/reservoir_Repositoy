package com.dse.reservoir.sjfx.czwy.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.sjfx.czwy.dao.CzwyDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 垂直位移Dao层
 */
@Repository("czwyDao")
public class CzwyDaoImpl extends BaseDao implements CzwyDao {

    @Override
    public EasyUiPage getDateList(String stm, String etm,GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT BB.NAME,BB.ST_TP,A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,NVL(A.CALCDATA,A.ORIGDATA) AS DATA FROM WR_VSFT_B A LEFT JOIN (SELECT * FROM WR_ST_PROJ_TYPE_MAP M LEFT JOIN (SELECT Y.CODE,Y.NAME FROM T_SYS_DICTIONARY Y WHERE Y.PID=(SELECT ID FROM T_SYS_DICTIONARY YY WHERE YY.CODE='0')) TT ON M.ST_TP=TT.CODE) BB " +
                "ON A.STCD = BB.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE BB.ST_TP = '4' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sql += " AND BB.PROJ_CD = ? ";
            params.add(gcxArgs.getProjcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getStcdids())){
            String stcds = gcxArgs.getStcdids();
            stcds = stcds.replace(",","','");
            sql += " AND A.STCD IN ('','"+stcds+"') ";
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sql+=" AND A.STCD in ( ";
            sql+=" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd= ? ";
            sql+=" )  ";
            params.add(gcxArgs.getWrrbm_rbcd());
        }

        sql += " ORDER BY TM DESC ";

        return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
    }

    /**
     * 查询垂直位移数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs 参数值
     * @return
     */
    public Object getGcxDateList(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        List<Object> params = new ArrayList<Object>();// hh24:mi:ss
        String sql = "SELECT A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd') AS TM,NVL(A.CALCDATA,A.ORIGDATA) AS DATA FROM WR_VSFT_B A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '4' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sql += " AND M.PROJ_CD = ? ";
            params.add(gcxArgs.getProjcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getKeyword())){
           // sql += " AND S.STNM LIKE ? ";
           // params.add("%"+gcxArgs.getKeyword()+"%");
            String stcds = gcxArgs.getKeyword();
            stcds = stcds.replace(",","','");
            sql += " AND A.STCD IN ('','"+stcds+"') ";
        }
        if(StringUtil.isNotEmpty(gcxArgs.getStcdids())){
            //sql +="  AND '"+gcxArgs.getStcdids()+ "'  like '%'||S.STCD||'%' ";
            String stcds = gcxArgs.getStcdids();
            stcds = stcds.replace(",","','");
            sql += " AND A.STCD IN ('','"+stcds+"') ";
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sql+=" AND A.STCD in ( ";
            sql+=" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd= ? ";
            sql+=" )  ";
            params.add(gcxArgs.getWrrbm_rbcd());
        }

        sql += " ORDER BY TM,STCD";

        return findBySqlWithMap(sql, params.toArray());

    }


    @Override
    public EasyUiPage getDnpjtzzList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(syear) && StringUtil.isNotEmpty(eyear)) {
            List<Object> params = new ArrayList<Object>();
            String sql = "SELECT A.*," +
                    "       A.MAXDATA - A.MINDATA AS BF," +
                    "       P.STNM," +
                    "       S.PROJ_CD," +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "          FROM WR_VSFT_B" +
                    "         WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA" +
                    "           AND STCD = A.STCD" +
                    "           AND TO_CHAR(TM, 'yyyy') >= ?" +
                    "           AND TO_CHAR(TM, 'yyyy') <= ?" +
                    "           AND ROWNUM = 1) AS MAXTM," +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "          FROM WR_VSFT_B" +
                    "         WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA" +
                    "           AND STCD = A.STCD" +
                    "           AND TO_CHAR(TM, 'yyyy') >= ?" +
                    "           AND TO_CHAR(TM, 'yyyy') <= ?" +
                    "           AND ROWNUM = 1) AS MINTM" +
                    "  FROM (SELECT STCD," +
                    "               MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA," +
                    "               MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA," +
                    "               AVG(NVL(CALCDATA, ORIGDATA)) AS AVGDATA" +
                    "          FROM WR_VSFT_B" +
                    "         WHERE TO_CHAR(TM, 'yyyy') >= ?" +
                    "           AND TO_CHAR(TM, 'yyyy') <= ?" +
                    "         GROUP BY STCD) A" +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "    ON A.STCD = S.STCD" +
                    "  LEFT JOIN WR_STAT_M P" +
                    "    ON A.STCD = P.STCD" +
                    " WHERE S.ST_TP = '4'";

            params.add(syear);
            params.add(eyear);
            params.add(syear);
            params.add(eyear);
            params.add(syear);
            params.add(eyear);

            if(StringUtil.isNotEmpty(projcd)){
                sql += " AND S.PROJ_CD = ? ";
                params.add(projcd);
            }
            sql+=" ORDER BY A.STCD ASC";

            return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }

}

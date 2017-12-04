package com.dse.reservoir.sjfx.dccj.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.sjfx.dccj.dao.DccjDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 渡槽沉降Dao层
 */
@Repository("dccjDao")
public class DccjDaoImpl extends BaseDao implements DccjDao {

    @Override
    public EasyUiPage getDateList(String stm, String etm,  GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,round(NVL(A.CALCDATA,A.ORIGDATA),2) AS DATA FROM WR_CSFT_B A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '9' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sql += " AND M.PROJ_CD = ? ";
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
        sql += " ORDER BY TM DESC";

        return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
    }

    /**
     *查询渡槽数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs 参数值
     * @return
     */
    public Object getGcxDateList(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        List<Object> params = new ArrayList<Object>();// hh24:mi:ss
        String sql = "SELECT A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd') AS TM,round(NVL(A.CALCDATA,A.ORIGDATA),2) AS DATA FROM WR_CSFT_B A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '9' AND S.ISJIDIAN = '0' ";

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
                    "          FROM WR_CSFT_B" +
                    "         WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA" +
                    "           AND STCD = A.STCD" +
                    "           AND TO_CHAR(TM, 'yyyy') >= ?" +
                    "           AND TO_CHAR(TM, 'yyyy') <= ?" +
                    "           AND ROWNUM = 1) AS MAXTM," +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "          FROM WR_CSFT_B" +
                    "         WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA" +
                    "           AND STCD = A.STCD" +
                    "           AND TO_CHAR(TM, 'yyyy') >= ?" +
                    "           AND TO_CHAR(TM, 'yyyy') <= ?" +
                    "           AND ROWNUM = 1) AS MINTM" +
                    "  FROM (SELECT STCD," +
                    "               MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA," +
                    "               MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA," +
                    "               AVG(NVL(CALCDATA, ORIGDATA)) AS AVGDATA" +
                    "          FROM WR_CSFT_B" +
                    "         WHERE TO_CHAR(TM, 'yyyy') >= ?" +
                    "           AND TO_CHAR(TM, 'yyyy') <= ?" +
                    "         GROUP BY STCD) A" +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "    ON A.STCD = S.STCD" +
                    "  LEFT JOIN WR_STAT_M P" +
                    "    ON A.STCD = P.STCD" +
                    " WHERE S.ST_TP = '9'";

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

            return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getjnbbList(String stime, String etime, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(stime) && StringUtil.isNotEmpty(etime) && StringUtil.isNotEmpty(projcd)) {
            List<Object> params = new ArrayList<Object>();
            String sql = "SELECT 'mm' AS UNIT," +
                    "       AA.MAXDATA," +
                    "       AA.MINDATA," +
                    "       AA.MAXTM," +
                    "       AA.MINTM," +
                    "       AA.LASTDATA," +
                    "       BB.*," +
                    "       P.STNM," +
                    "       S.PROJ_CD" +
                    "  FROM (SELECT A.*," +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                  FROM WR_CSFT_B" +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA" +
                    "                   AND STCD = A.STCD" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                   AND ROWNUM = 1) AS MAXTM," +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                  FROM WR_CSFT_B" +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA" +
                    "                   AND STCD = A.STCD" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                   AND ROWNUM = 1) AS MINTM," +
                    "               (SELECT DATA" +
                    "                  FROM (SELECT NVL(CALCDATA, ORIGDATA) AS DATA" +
                    "                          FROM WR_CSFT_B C" +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                            ON C.STCD = S.STCD" +
                    "                           AND S.ST_TP = '9'" +
                    "                         WHERE S.PROJ_CD = ?" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                         ORDER BY TM DESC)" +
                    "                 WHERE ROWNUM = 1) AS LASTDATA" +
                    "          FROM (SELECT STCD," +
                    "                       MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA," +
                    "                       MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA" +
                    "                  FROM WR_CSFT_B" +
                    "                 WHERE TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                 GROUP BY STCD) A) AA" +
                    "  FULL JOIN (SELECT B.*," +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                       FROM WR_CSFT_B" +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMAXDATA" +
                    "                        AND STCD = B.STCD" +
                    "                        AND ROWNUM = 1) AS LSMAXTM," +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                       FROM WR_CSFT_B" +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMINDATA" +
                    "                        AND STCD = B.STCD" +
                    "                        AND ROWNUM = 1) AS LSMINTM" +
                    "               FROM (SELECT STCD," +
                    "                            MAX(NVL(CALCDATA, ORIGDATA)) AS LSMAXDATA," +
                    "                            MIN(NVL(CALCDATA, ORIGDATA)) AS LSMINDATA" +
                    "                       FROM WR_CSFT_B" +
                    "                      GROUP BY STCD) B) BB" +
                    "    ON AA.STCD = BB.STCD" +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "    ON BB.STCD = S.STCD" +
                    "  LEFT JOIN WR_STAT_M P" +
                    "    ON BB.STCD = P.STCD" +
                    " WHERE S.ST_TP = '9' AND S.PROJ_CD = ? ";
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(projcd);
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(projcd);

            return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbList(String tm, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(projcd)) {
            String sql2 = "SELECT STCD FROM WR_ST_PROJ_TYPE_MAP WHERE ST_TP = '9' AND PROJ_CD = ? ";
            List<Map> list = findBySqlWithMap(sql2, projcd);
            String lname = "";
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    lname += "'"+list.get(i).get("STCD")+"'" + " AS " + list.get(i).get("STCD");
                } else {
                    lname += "," + "'"+list.get(i).get("STCD")+"'"  + " AS " + list.get(i).get("STCD");
                }
            }

            List<Object> params = new ArrayList<Object>();
            String sql = "SELECT * FROM " +
                    "(SELECT TO_CHAR(TM, 'yyyy-mm-dd') AS XM," +
                    "       C.STCD," +
                    "       AVG(NVL(CALCDATA, ORIGDATA)) AS VAL" +
                    "  FROM WR_CSFT_B C" +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "    ON C.STCD = S.STCD" +
                    " WHERE S.ST_TP = '9' ";

            if(StringUtil.isNotEmpty(projcd)){
                sql += "  AND S.PROJ_CD = ? ";
                params.add(projcd);
            }

            if(StringUtil.isNotEmpty(tm)){
                sql += "  AND TO_CHAR(TM, 'yyyy-mm') = ? ";
                params.add(tm);
            }

            sql += " GROUP BY TO_CHAR(TM, 'yyyy-mm-dd'), C.STCD)" +
                    "  PIVOT(AVG(VAL) FOR STCD IN("+lname+"))" +
                    " ORDER BY XM DESC ";

            return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbTJList(String tm, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(tm) && StringUtil.isNotEmpty(projcd)) {
            String sql2 = "SELECT STCD FROM WR_ST_PROJ_TYPE_MAP WHERE ST_TP = '9' AND PROJ_CD = ? ";
            List<Map> list = findBySqlWithMap(sql2, projcd);
            String lname = "";
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    lname += "'"+list.get(i).get("STCD")+"'" + " AS " + list.get(i).get("STCD");
                } else {
                    lname += "," + "'"+list.get(i).get("STCD")+"'"  + " AS " + list.get(i).get("STCD");
                }
            }

            List<Object> params = new ArrayList<Object>();

            String sql = "SELECT X.X,X.XM,DC.* FROM " +
                    "(SELECT *" +
                    "  FROM (SELECT 'A' AS A," +
                    "               'B' AS B," +
                    "               'C' AS C," +
                    "               'D' AS D," +
                    "               'E' AS E," +
                    "               'F' AS F," +
                    "               'G' AS G," +
                    "               'H' AS H," +
                    "               'I' AS I" +
                    "          FROM DUAL) UNPIVOT(X FOR XM IN(A AS '最大值'," +
                    "                                         B AS '最大值日期'," +
                    "                                         C AS '最小值'," +
                    "                                         D AS '最小值日期'," +
                    "                                         E AS '变幅'," +
                    "                                         F AS '历史最大值'," +
                    "                                         G AS '历史最大值日期'," +
                    "                                         H AS '历史最小值'," +
                    "                                         I AS '历史最小值日期'))) X";

            //渡槽
            sql += " LEFT JOIN " +
                    "(SELECT *" +
                    "  FROM (SELECT NVL(C.STCD, B.STCD) AS STCD," +
                    "               B.MAXVAL," +
                    "               B.MINVAL," +
                    "               B.MAXVALTM," +
                    "               B.MINVALTM," +
                    "               B.BF," +
                    "               C.LSMAXVAL," +
                    "               C.LSMINVAL," +
                    "               C.LSMAXVALTM," +
                    "               C.LSMINVALTM" +
                    "          FROM (SELECT STCD," +
                    "                       TO_CHAR(A.MAXVAL) AS MAXVAL," +
                    "                       TO_CHAR(A.MINVAL) AS MINVAL," +
                    "                       TO_CHAR(MAXVAL - MINVAL) AS BF," +
                    "                       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                          FROM WR_CSFT_B" +
                    "                         WHERE NVL(CALCDATA, ORIGDATA) = A.MAXVAL" +
                    "                           AND STCD = A.STCD" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND ROWNUM = '1') AS MAXVALTM," +
                    "                       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                          FROM WR_CSFT_B" +
                    "                         WHERE NVL(CALCDATA, ORIGDATA) = A.MINVAL" +
                    "                           AND STCD = A.STCD" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND ROWNUM = '1') AS MINVALTM" +
                    "                  FROM (SELECT H.STCD," +
                    "                               TO_CHAR(H.TM, 'yyyy-mm') AS TM," +
                    "                               MAX(NVL(CALCDATA, ORIGDATA)) AS MAXVAL," +
                    "                               MIN(NVL(CALCDATA, ORIGDATA)) AS MINVAL" +
                    "                          FROM WR_CSFT_B H" +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                            ON H.STCD = S.STCD" +
                    "                           AND S.ST_TP = '9'" +
                    "                         WHERE TO_CHAR(H.TM, 'yyyy-mm') = ?" +
                    "                           AND S.PROJ_CD = ?" +
                    "                         GROUP BY TO_CHAR(H.TM, 'yyyy-mm'), H.STCD) A) B" +
                    "          FULL JOIN (SELECT STCD," +
                    "                           TO_CHAR(A.LSMAXVAL) AS LSMAXVAL," +
                    "                           TO_CHAR(A.LSMINVAL) AS LSMINVAL," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM WR_CSFT_B" +
                    "                             WHERE NVL(CALCDATA, ORIGDATA) = A.LSMAXVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMAXVALTM," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM WR_CSFT_B" +
                    "                             WHERE NVL(CALCDATA, ORIGDATA) = A.LSMINVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMINVALTM" +
                    "                      FROM (SELECT H.STCD," +
                    "                                   MAX(NVL(CALCDATA, ORIGDATA)) AS LSMAXVAL," +
                    "                                   MIN(NVL(CALCDATA, ORIGDATA)) AS LSMINVAL" +
                    "                              FROM WR_CSFT_B H" +
                    "                              LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                                ON H.STCD = S.STCD" +
                    "                               AND S.ST_TP = '9'" +
                    "                             WHERE S.PROJ_CD = ?" +
                    "                             GROUP BY H.STCD) A) C" +
                    "            ON B.STCD = C.STCD) UNPIVOT(DC FOR SYXM IN(MAXVAL AS '最大值'," +
                    "                                                       MAXVALTM AS '最大值日期'," +
                    "                                                       MINVAL AS '最小值'," +
                    "                                                       MINVALTM AS '最小值日期'," +
                    "                                                       BF AS '变幅'," +
                    "                                                       LSMAXVAL AS '历史最大值'," +
                    "                                                       LSMAXVALTM AS '历史最大值日期'," +
                    "                                                       LSMINVAL AS '历史最小值'," +
                    "                                                       LSMINVALTM AS '历史最小值日期'))" +
                    "                                                       PIVOT (MAX(DC) FOR STCD IN ("+lname+"))) DC" +
                    "                               ON X.XM = DC.SYXM " +
                    "   ORDER BY X.X";

            params.add(tm);
            params.add(projcd);
            params.add(projcd);


            return findEasyUiPageBySql(sql,easyUiPage,params.toArray());
        }
        return easyUiPage;
    }

}

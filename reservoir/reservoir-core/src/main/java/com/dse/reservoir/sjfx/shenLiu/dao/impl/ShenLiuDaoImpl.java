package com.dse.reservoir.sjfx.shenLiu.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.sjfx.shenLiu.dao.ShenLiuDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 渗流Dao
 */
@Repository("shenLiuDao")
public class ShenLiuDaoImpl extends BaseDao implements ShenLiuDao {

    @Override
    public EasyUiPage getDateList(String stm, String etm,  GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
//        String sql = "SELECT M.ST_TP,A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,round(NVL(A.CALCDATA,A.ORIGDATA),2) AS DATA FROM WR_WEIO_B A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
//                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '2' AND S.ISJIDIAN = '0' ";
        String sql = "SELECT BB.NAME,BB.ST_TP,A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,round(NVL(A.CALCDATA,A.ORIGDATA),2) AS DATA FROM WR_WEIO_B A LEFT JOIN (SELECT * FROM WR_ST_PROJ_TYPE_MAP M LEFT JOIN (SELECT Y.CODE,Y.NAME FROM T_SYS_DICTIONARY Y WHERE Y.PID=(SELECT ID FROM T_SYS_DICTIONARY YY WHERE YY.CODE='0')) TT ON M.ST_TP=TT.CODE) BB " +
                "ON A.STCD = BB.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE BB.ST_TP = '2' AND S.ISJIDIAN = '0' ";

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
        sql += " ORDER BY TM DESC";

        return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
    }

    /**
     * 查询渗流数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs
     * @return
     */
    public Object getGcxDateList(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        List<Object> params = new ArrayList<Object>();// hh24:mi:ss
        String sql = "SELECT A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd') AS TM,round(NVL(A.CALCDATA,A.ORIGDATA),2) AS DATA FROM WR_WEIO_B A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '2' AND S.ISJIDIAN = '0' ";

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
    public EasyUiPage getBaseDataList(String tm,String ppcd, String projcd,EasyUiPage easyUiPage) throws Exception {

        if (StringUtil.isNotEmpty(ppcd) && StringUtil.isNotEmpty(projcd)) {
            String sql = "SELECT STCD FROM WR_ST_PROJ_TYPE_MAP WHERE ST_TP = '2' AND PROJ_CD = ? ";
            List<Map> list = findBySqlWithMap(sql, projcd);
            String lname = "";
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    lname += "'"+list.get(i).get("STCD")+"'" + " AS " + list.get(i).get("STCD");
                } else {
                    lname += "," + "'"+list.get(i).get("STCD")+"'"  + " AS " + list.get(i).get("STCD");
                }
            }

            List<Object> params = new ArrayList<Object>();

            String sql2 = "SELECT NVL(AA.TM, BB.TM) AS XM, AA.RZ, AA.DYP, BB.* " +
                    "                      FROM (SELECT A.PROJ_CD, A.TM, A.RZ, A.DYP" +
                    "                              FROM (SELECT NVL(R.PROJ_CD, P.PROJ_CD) AS PROJ_CD," +
                    "                                           NVL (TO_CHAR(R.TM, 'yyyy-mm-dd'),"+
                    "                                                TO_CHAR(P.TM, 'yyyy-mm-dd')) AS TM," +
                    "                                           R.RZ," +
                    "                                           P.DYP " +
                    "                                      FROM (SELECT *" +
                    "                                                  FROM ST_RSVR_R R1     " +      //水库水情表
                    "                                                  LEFT JOIN WR_ST_PROJ_TYPE_MAP S2" +
                    "                                                      ON R1.STCD = S2.STCD" +
                    "                                                      AND S2.ST_TP = '5') R" +
                    "                                           FULL JOIN (SELECT *" +
                    "                                                  FROM ST_PPTN_R P1       " +    //降水量表
                    "                                                  LEFT JOIN WR_ST_PROJ_TYPE_MAP S3" +
                    "                                                          ON P1.STCD = S3.STCD" +
                    "                                                          AND S3.ST_TP = '6') P               " +
                    "                                        on R.PROJ_CD = P.PROJ_CD AND TO_CHAR(R.TM, 'yyyy-mm-dd') =" +
                    "                                           TO_CHAR(P.TM, 'yyyy-mm-dd')) A " +
                    "                             WHERE 1=1 ";

            if (StringUtil.isNotEmpty(ppcd)) {
                sql2 += "  AND PROJ_CD = ? ";
                params.add(ppcd);
            }

            if (StringUtil.isNotEmpty(tm)) {
                sql2 += "  AND TO_CHAR(TO_DATE(A.TM, 'yyyy-mm-dd'),'yyyy-mm') = ? ";
                params.add(tm);
            }

            sql2 += ") AA" +
                    "                      FULL JOIN" +
                    "                     (SELECT *" +
                    "                        FROM (SELECT TO_CHAR(TM, 'yyyy-mm-dd') AS TM," +
                    "                                     S.STCD," +
                    "                                     AVG(NVL(CALCDATA, ORIGDATA)) AS DATA" +
                    "                                FROM WR_WEIO_B H       " +         //渗流监测数据表
                    "                                LEFT JOIN WR_ST_PROJ_TYPE_MAP S  " +
                    "                                       ON H.STCD = S.STCD       " +
                    "                                       WHERE S.ST_TP = '2' ";

            if (StringUtil.isNotEmpty(projcd)) {
                sql2 += "  AND S.PROJ_CD = ? ";
                params.add(projcd);
            }

            if (StringUtil.isNotEmpty(tm)) {
                sql2 += "  AND TO_CHAR(TM, 'yyyy-mm') = ? ";
                params.add(tm);
            }

            sql2 += " GROUP BY TO_CHAR(TM, 'yyyy-mm-dd'), S.STCD) PIVOT(AVG(DATA) FOR STCD IN("+lname+"))" +
                    "                       ORDER BY TM DESC) BB" +
                    "                        ON AA.TM = BB.TM" +
                    "                     ORDER BY XM DESC";

            return this.findEasyUiPageBySql(sql2, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }


    @Override
    public EasyUiPage getCountDataList(String tm,String ppcd,String projcd,EasyUiPage easyUiPage) throws Exception {

        if(StringUtil.isNotEmpty(tm) && StringUtil.isNotEmpty(ppcd) && StringUtil.isNotEmpty(projcd)) {
            String sql = "SELECT STCD FROM WR_ST_PROJ_TYPE_MAP WHERE ST_TP = '2' AND PROJ_CD = ? ";
            List<Map> list = findBySqlWithMap(sql, projcd);
            String lname = "";
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    lname += "'"+list.get(i).get("STCD")+"'" + " AS " + list.get(i).get("STCD");
                } else {
                    lname += "," + "'"+list.get(i).get("STCD")+"'"  + " AS " + list.get(i).get("STCD");
                }
            }

            List<Object> params = new ArrayList<Object>();


            String sql2 = "SELECT X.X,X.XM,RZ.RZ,DYP.DYP,SY.* FROM " +
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

            //水位
            sql2 += " LEFT JOIN " +
                    "(SELECT *" +
                    "  FROM (SELECT B.MAXVAL," +
                    "               B.MINVAL," +
                    "               B.MAXVALTM," +
                    "               B.MINVALTM," +
                    "               B.BF," +
                    "               C.LSMAXVAL," +
                    "               C.LSMAXVALTM," +
                    "               C.LSMINVAL," +
                    "               C.LSMINVALTM" +
                    "          FROM (SELECT STCD," +
                    "                       TO_CHAR(A.MAXVAL) AS MAXVAL," +
                    "                       TO_CHAR(A.MINVAL) AS MINVAL," +
                    "                       TO_CHAR(MAXVAL - MINVAL) AS BF," +
                    "                       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                          FROM ST_RSVR_R" +
                    "                         WHERE RZ = A.MAXVAL" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND STCD = A.STCD" +
                    "                           AND ROWNUM = '1') AS MAXVALTM," +
                    "                       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                          FROM ST_RSVR_R" +
                    "                         WHERE RZ = A.MINVAL" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND STCD = A.STCD" +
                    "                           AND ROWNUM = '1') AS MINVALTM" +
                    "                  FROM (SELECT T.STCD," +
                    "                               TO_CHAR(T.TM, 'yyyy-mm') AS TM," +
                    "                               MAX(RZ) AS MAXVAL," +
                    "                               MIN(RZ) AS MINVAL" +
                    "                          FROM ST_RSVR_R T" +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                            ON T.STCD = S.STCD" +
                    "                           AND S.ST_TP = '5'" +
                    "                         WHERE TO_CHAR(T.TM, 'yyyy-mm') = ?" +
                    "                           AND S.PROJ_CD = ?" +
                    "                         GROUP BY TO_CHAR(T.TM, 'yyyy-mm'), T.STCD) A) B" +
                    "          FULL JOIN (SELECT STCD," +
                    "                           TO_CHAR(A.LSMAXVAL) AS LSMAXVAL," +
                    "                           TO_CHAR(A.LSMINVAL) AS LSMINVAL," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM ST_RSVR_R" +
                    "                             WHERE RZ = A.LSMAXVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMAXVALTM," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM ST_RSVR_R" +
                    "                             WHERE RZ = A.LSMINVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMINVALTM" +
                    "                      FROM (SELECT T.STCD," +
                    "                                   MAX(RZ) AS LSMAXVAL," +
                    "                                   MIN(RZ) AS LSMINVAL" +
                    "                              FROM ST_RSVR_R T" +
                    "                              LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                                ON T.STCD = S.STCD" +
                    "                               AND S.ST_TP = '5'" +
                    "                             WHERE S.PROJ_CD = ?" +
                    "                             GROUP BY T.STCD) A) C" +
                    "            ON B.STCD = C.STCD) UNPIVOT(RZ FOR XM IN(MAXVAL AS '最大值'," +
                    "                                                       MAXVALTM AS '最大值日期'," +
                    "                                                       MINVAL AS '最小值'," +
                    "                                                       MINVALTM AS '最小值日期'," +
                    "                                                       BF AS '变幅'," +
                    "                                                       LSMAXVAL AS '历史最大值'," +
                    "                                                       LSMAXVALTM AS" +
                    "                                                       '历史最大值日期'," +
                    "                                                       LSMINVAL AS '历史最小值'," +
                    "                                                       LSMINVALTM AS" +
                    "                                                       '历史最小值日期'))) RZ " +
                    "                       ON X.XM = RZ.XM";

            params.add(tm);
            params.add(ppcd);
            params.add(ppcd);

            //降雨
            sql2 += " LEFT JOIN " +
                    "(SELECT *" +
                    "  FROM (SELECT B.MAXVAL," +
                    "               B.MINVAL," +
                    "               B.MAXVALTM," +
                    "               B.MINVALTM," +
                    "               B.BF," +
                    "               C.LSMAXVAL," +
                    "               C.LSMAXVALTM," +
                    "               C.LSMINVAL," +
                    "               C.LSMINVALTM" +
                    "          FROM (SELECT STCD," +
                    "                       TO_CHAR(A.MAXVAL) AS MAXVAL," +
                    "                       TO_CHAR(A.MINVAL) AS MINVAL," +
                    "                       TO_CHAR(MAXVAL - MINVAL) AS BF," +
                    "                       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                          FROM ST_PPTN_R" +
                    "                         WHERE DYP = A.MAXVAL" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND STCD = A.STCD" +
                    "                           AND ROWNUM = '1') AS MAXVALTM," +
                    "                       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                          FROM ST_PPTN_R" +
                    "                         WHERE DYP = A.MINVAL" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND STCD = A.STCD" +
                    "                           AND ROWNUM = '1') AS MINVALTM" +
                    "                  FROM (SELECT T.STCD," +
                    "                               TO_CHAR(T.TM, 'yyyy-mm') AS TM," +
                    "                               MAX(DYP) AS MAXVAL," +
                    "                               MIN(DYP) AS MINVAL" +
                    "                          FROM ST_PPTN_R T" +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                            ON T.STCD = S.STCD" +
                    "                           AND S.ST_TP = '6'" +
                    "                         WHERE TO_CHAR(T.TM, 'yyyy-mm') = ?" +
                    "                           AND S.PROJ_CD = ?" +
                    "                         GROUP BY TO_CHAR(T.TM, 'yyyy-mm'), T.STCD) A) B" +
                    "          FULL JOIN (SELECT STCD," +
                    "                           TO_CHAR(A.LSMAXVAL) AS LSMAXVAL," +
                    "                           TO_CHAR(A.LSMINVAL) AS LSMINVAL," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM ST_PPTN_R" +
                    "                             WHERE DYP = A.LSMAXVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMAXVALTM," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM ST_PPTN_R" +
                    "                             WHERE DYP = A.LSMINVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMINVALTM" +
                    "                      FROM (SELECT T.STCD," +
                    "                                   MAX(DYP) AS LSMAXVAL," +
                    "                                   MIN(DYP) AS LSMINVAL" +
                    "                              FROM ST_PPTN_R T" +
                    "                              LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                                ON T.STCD = S.STCD" +
                    "                               AND S.ST_TP = '6'" +
                    "                             WHERE S.PROJ_CD = ?" +
                    "                             GROUP BY T.STCD) A) C" +
                    "            ON B.STCD = C.STCD) UNPIVOT(DYP FOR XM IN(MAXVAL AS '最大值'," +
                    "                                                       MAXVALTM AS '最大值日期'," +
                    "                                                       MINVAL AS '最小值'," +
                    "                                                       MINVALTM AS '最小值日期'," +
                    "                                                       BF AS '变幅'," +
                    "                                                       LSMAXVAL AS '历史最大值'," +
                    "                                                       LSMAXVALTM AS" +
                    "                                                       '历史最大值日期'," +
                    "                                                       LSMINVAL AS '历史最小值'," +
                    "                                                       LSMINVALTM AS" +
                    "                                                       '历史最小值日期'))) DYP" +
                    "                       ON X.XM = DYP.XM  ";

            params.add(tm);
            params.add(ppcd);
            params.add(ppcd);

            //渗流
            sql2 += " LEFT JOIN " +
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
                    "                          FROM WR_WEIO_B" +
            "                         WHERE NVL(CALCDATA, ORIGDATA) = A.MAXVAL" +
                    "                           AND STCD = A.STCD" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND ROWNUM = '1') AS MAXVALTM," +
                    "                       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                          FROM WR_WEIO_B" +
                    "                         WHERE NVL(CALCDATA, ORIGDATA) = A.MINVAL" +
                    "                           AND STCD = A.STCD" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND ROWNUM = '1') AS MINVALTM" +
                    "                  FROM (SELECT H.STCD," +
                    "                               TO_CHAR(H.TM, 'yyyy-mm') AS TM," +
                    "                               MAX(NVL(CALCDATA, ORIGDATA)) AS MAXVAL," +
                    "                               MIN(NVL(CALCDATA, ORIGDATA)) AS MINVAL" +
                    "                          FROM WR_WEIO_B H" +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                            ON H.STCD = S.STCD" +
                    "                         WHERE TO_CHAR(H.TM, 'yyyy-mm') = ?" +
                    "                           AND S.ST_TP = '2'" +
                    "                           AND S.PROJ_CD = ?" +
                    "                         GROUP BY TO_CHAR(H.TM, 'yyyy-mm'), H.STCD) A) B" +
                    "          FULL JOIN (SELECT STCD," +
                    "                           TO_CHAR(A.LSMAXVAL) AS LSMAXVAL," +
                    "                           TO_CHAR(A.LSMINVAL) AS LSMINVAL," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM WR_WEIO_B" +
                    "                             WHERE NVL(CALCDATA, ORIGDATA) = A.LSMAXVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMAXVALTM," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM WR_WEIO_B" +
                    "                             WHERE NVL(CALCDATA, ORIGDATA) = A.LSMINVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMINVALTM" +
                    "                      FROM (SELECT H.STCD," +
                    "                                   MAX(NVL(CALCDATA, ORIGDATA)) AS LSMAXVAL," +
                    "                                   MIN(NVL(CALCDATA, ORIGDATA)) AS LSMINVAL" +
                    "                              FROM WR_WEIO_B H" +
                    "                              LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                                ON H.STCD = S.STCD" +
                    "                             WHERE S.ST_TP = '2' AND S.PROJ_CD = ?" +
                    "                             GROUP BY H.STCD) A) C" +
                    "            ON B.STCD = C.STCD) UNPIVOT(SY FOR SYXM IN(MAXVAL AS '最大值'," +
                    "                                                       MAXVALTM AS '最大值日期'," +
                    "                                                       MINVAL AS '最小值'," +
                    "                                                       MINVALTM AS '最小值日期'," +
                    "                                                       BF AS '变幅'," +
                    "                                                       LSMAXVAL AS '历史最大值'," +
                    "                                                       LSMAXVALTM AS '历史最大值日期'," +
                    "                                                       LSMINVAL AS '历史最小值'," +
                    "                                                       LSMINVALTM AS '历史最小值日期'))" +
                    "                                                       PIVOT (MAX(SY) FOR STCD IN ("+lname+"))) SY" +
                    "                               ON X.XM = SY.SYXM " +
                    "   ORDER BY X.X";

            params.add(tm);
            params.add(projcd);
            params.add(projcd);

            return findEasyUiPageBySql(sql2,easyUiPage,params.toArray());
        }
        return easyUiPage;
    }


    @Override
    public EasyUiPage getjnbbList(String stime, String etime, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(stime) && StringUtil.isNotEmpty(etime)) {
            List<Object> params = new ArrayList<Object>();
            String aql="SELECT 'l/s' AS UNIT," +
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
                    "                  FROM WR_WEIO_B" +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA" +
                    "                   AND STCD = A.STCD" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                   AND ROWNUM = 1) AS MAXTM," +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                  FROM WR_WEIO_B" +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA" +
                    "                   AND STCD = A.STCD" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                   AND ROWNUM = 1) AS MINTM," +
                    "               (SELECT DATA" +
                    "                  FROM (SELECT NVL(CALCDATA, ORIGDATA) AS DATA" +
                    "                          FROM WR_WEIO_B H" +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                            ON H.STCD = S.STCD" +
                    "                         WHERE S.ST_TP = '2' AND S.PROJ_CD = ?" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                         ORDER BY TM DESC)" +
                    "                 WHERE ROWNUM = 1) AS LASTDATA" +
                    "          FROM (SELECT STCD," +
                    "                       MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA," +
                    "                       MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA" +
                    "                  FROM WR_WEIO_B" +
                    "                 WHERE TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                 GROUP BY STCD) A) AA" +
                    "  FULL JOIN (SELECT B.*," +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                       FROM WR_WEIO_B" +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMAXDATA" +
                    "                        AND STCD = B.STCD" +
                    "                        AND ROWNUM = 1) AS LSMAXTM," +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                       FROM WR_WEIO_B" +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMINDATA" +
                    "                        AND STCD = B.STCD" +
                    "                        AND ROWNUM = 1) AS LSMINTM" +
                    "               FROM (SELECT STCD," +
                    "                            MAX(NVL(CALCDATA, ORIGDATA)) AS LSMAXDATA," +
                    "                            MIN(NVL(CALCDATA, ORIGDATA)) AS LSMINDATA" +
                    "                       FROM WR_WEIO_B" +
                    "                      GROUP BY STCD) B) BB" +
                    "    ON AA.STCD = BB.STCD" +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "    ON BB.STCD = S.STCD" +
                    "  LEFT JOIN WR_STAT_M P" +
                    "    ON BB.STCD = P.STCD" +
                    " WHERE S.ST_TP = '2' AND S.PROJ_CD = ? ";

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

            return findEasyUiPageBySql(aql, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }


}
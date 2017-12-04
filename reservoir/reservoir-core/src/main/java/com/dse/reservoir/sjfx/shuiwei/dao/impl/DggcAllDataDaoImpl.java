package com.dse.reservoir.sjfx.shuiwei.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.sjfx.shuiwei.dao.DggcAllDataDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/24.
 */
@Repository("dggcAllDataDao")
public class DggcAllDataDaoImpl extends BaseDao implements DggcAllDataDao {
    @Override
    public EasyUiPage getDggcAllData(String tm, String projcd, EasyUiPage easyUiPage) throws Exception {
        StringBuffer sql = new StringBuffer();
        List param = new ArrayList();
        if(projcd.equals("3")){
            StringBuffer str = new StringBuffer();
            List params = new ArrayList();
            if(StringUtils.isNotEmpty(projcd)){
                params.add(projcd+"%");
            }
            str.append("SELECT S.STNM, YY.* " +
                    "  FROM WR_STAT_M S    " +
                    "  LEFT JOIN (SELECT M.*, TT.NAME" +
                    "               FROM WR_ST_PROJ_TYPE_MAP M  " +
                    "              INNER JOIN (SELECT Y.CODE, Y.NAME" +
                    "                           FROM T_SYS_DICTIONARY Y" +
                    "                          WHERE Y.PID =" +
                    "                                (SELECT T.ID" +
                    "                                   FROM T_SYS_DICTIONARY T" +
                    "                                  WHERE T.ID =" +
                    "                                        '8a10d4815d7cd89b015d8d629d2d0077')) TT" +
                    "                 ON M.ST_TP = TT.CODE) YY" +
                    "    ON S.STCD = YY.STCD" +
                    "   AND YY.PROJ_CD LIKE ?" +
                    " WHERE ISJIDIAN = 0" +
                    "   AND S.TYPEID = '0'" +
                    "   AND (YY.NAME = '5' OR YY.ST_TP = '5' OR YY.ST_TP = '1' OR YY.ST_TP = '2' OR YY.ST_TP = '5' OR YY.ST_TP = '7' OR YY.ST_TP = '8' OR YY.ST_TP = '9' )");
            List list = this.findBySqlWithMap(str.toString(),params.toArray());

            String sw = "";     //水位    5
            List<Map> sw1= new ArrayList();

            String dccj="";     //渡槽沉降  9
            List<Map> dccj1= new ArrayList();

            String sy="";     //渗压  1
            List<Map> sy1= new ArrayList();

            String scwy="";     //深层位移  8
            List<Map> scwy1= new ArrayList();

            /**
             * 将测点数据进行分组
             */
            for(int i=0;i<list.size();i++){
                Map map = (Map) list.get(i);
                String type= String.valueOf( map.get("ST_TP"));
                if(type.equals("5")){
                    //水位
                    sw1.add(map);
                }else if(type.equals("9")){
                    //渡槽沉降
                    dccj1.add(map);
                }else if(type.equals("1")){
                    //渗压
                    sy1.add(map);
                }else if(type.equals("8")){
                    //深层位移
                    scwy1.add(map);
                }
            }
            /**
             *  拼接各组数据字符串
             */
            //水位 S
            for (int i = 0; i < sw1.size(); i++) {
                if (i == 0) {
                    sw += "'"+sw1.get(i).get("STCD")+"'" + " AS " + sw1.get(i).get("STCD");
                } else {
                    sw += "," + "'"+sw1.get(i).get("STCD")+"'"  + " AS " + sw1.get(i).get("STCD");
                }
            }
            //水位 E
            //渡槽沉降 S
            for (int i = 0; i < dccj1.size(); i++) {
                if (i == 0) {
                    dccj += "'"+dccj1.get(i).get("STCD")+"'" + " AS " + dccj1.get(i).get("STCD");
                } else {
                    dccj += "," + "'"+dccj1.get(i).get("STCD")+"'"  + " AS " + dccj1.get(i).get("STCD");
                }
            }
            //渡槽沉降 E
            //渗压 S
            for (int i = 0; i < sy1.size(); i++) {
                if (i == 0) {
                    sy += "'"+sy1.get(i).get("STCD")+"'" + " AS " + sy1.get(i).get("STCD");
                } else {
                    sy += "," + "'"+sy1.get(i).get("STCD")+"'"  + " AS " + sy1.get(i).get("STCD");
                }
            }
            //渗压 E
            //深层位移 S
            for (int i = 0; i < scwy1.size(); i++) {
                if (i == 0) {
                    scwy += "'"+scwy1.get(i).get("STCD")+"'" + " AS " + scwy1.get(i).get("STCD");
                } else {
                    scwy += "," + "'"+scwy1.get(i).get("STCD")+"'"  + " AS " + scwy1.get(i).get("STCD");
                }
            }
            //深层位移 E

            sql.append("SELECT * " +
                    "  FROM (SELECT * " +
                    "          FROM (SELECT TO_CHAR(TM, 'yyyy-mm-dd') AS XM, C.STCD, ROUND(AVG(Z),3) AS VAL " +
                    "                  FROM WR_SW_R C " +
                    "                  LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                    ON C.STCD = S.STCD " +
                    "                 WHERE S.ST_TP = '5' " +
                    "                   AND S.PROJ_CD LIKE '3%' " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm') = ? ");// +
            param.add(tm);
            sql.append("                 GROUP BY TO_CHAR(TM, 'yyyy-mm-dd'), C.STCD) PIVOT(AVG(VAL) FOR STCD IN(" + sw + "))) AA " +
                    "  FULL JOIN (SELECT * " +
                    "               FROM (SELECT TO_CHAR(TM, 'yyyy-mm-dd') AS XB, " +
                    "                            C.STCD, " +
                    "                            ROUND(AVG(NVL(CALCDATA, ORIGDATA)),3) AS VAL " +
                    "                       FROM WR_MSFT_B C " +
                    "                       LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                         ON C.STCD = S.STCD " +
                    "                      WHERE S.ST_TP = '8' " +
                    "                        AND S.PROJ_CD LIKE '3%' " +
                    "                        AND TO_CHAR(TM, 'yyyy-mm') = ? ");// +
            param.add(tm);
            sql.append("                 GROUP BY TO_CHAR(TM, 'yyyy-mm-dd'), C.STCD) PIVOT(AVG(VAL) FOR STCD IN(" + scwy + "))) AB " +
                    "    ON AA.XM = AB.XB " +
                    "  FULL JOIN (SELECT * " +
                    "               FROM (SELECT TO_CHAR(TM, 'yyyy-mm-dd') AS XC, " +
                    "                            C.STCD, " +
                    "                            ROUND(AVG(NVL(CALCDATA, ORIGDATA)),3) AS VAL " +
                    "                       FROM WR_CSFT_B C " +
                    "                       LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                         ON C.STCD = S.STCD " +
                    "                      WHERE S.ST_TP = '9' " +
                    "                        AND S.PROJ_CD LIKE '3%' " +
                    "                        AND TO_CHAR(TM, 'yyyy-mm') = ? ");// +
            param.add(tm);
            sql.append("                  GROUP BY TO_CHAR(TM, 'yyyy-mm-dd'), C.STCD) PIVOT(AVG(VAL) FOR STCD IN(" + dccj + "))) AC " +
                    "    ON AA.XM = AC.XC " +
                    "  LEFT JOIN (SELECT BB.* " +
                    "               FROM (SELECT * " +
                    "                       FROM (SELECT TO_CHAR(TM, 'yyyy-mm-dd') AS XD, " +
                    "                                    S.STCD, " +
                    "                                    ROUND(AVG(NVL(CALCDATA, ORIGDATA)),3) AS DATA " +
                    "                               FROM WR_HYDO_B H " +
                    "                               LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                                 ON H.STCD = S.STCD " +
                    "                              WHERE S.ST_TP = '1' " +
                    "                                AND S.PROJ_CD LIKE '3%' " +
                    "                                AND TO_CHAR(TM, 'yyyy-mm') = ? ");// +
            param.add(tm);
            sql.append("                          GROUP BY TO_CHAR(TM, 'yyyy-mm-dd'), S.STCD) PIVOT(AVG(DATA) FOR STCD IN(" + sy +"))" +
                    "                      ORDER BY XD DESC) BB) AD" +
                    "    ON AA.XM = AD.XD");
        }
        return this.findEasyUiPageBySql(sql.toString(),easyUiPage,param.toArray());
    }

    @Override
    public EasyUiPage getGcjlbTJList(String tm, String projcd, EasyUiPage easyUiPage) throws Exception {
        StringBuffer sql = new StringBuffer();
        List param = new ArrayList();
        if(projcd.equals("3")){
            StringBuffer str = new StringBuffer();
            List params = new ArrayList();
            if(StringUtils.isNotEmpty(projcd)){
                params.add(projcd+"%");
            }
            str.append("SELECT S.STNM, YY.* " +
                    "  FROM WR_STAT_M S    " +
                    "  LEFT JOIN (SELECT M.*, TT.NAME" +
                    "               FROM WR_ST_PROJ_TYPE_MAP M  " +
                    "              INNER JOIN (SELECT Y.CODE, Y.NAME" +
                    "                           FROM T_SYS_DICTIONARY Y" +
                    "                          WHERE Y.PID =" +
                    "                                (SELECT T.ID" +
                    "                                   FROM T_SYS_DICTIONARY T" +
                    "                                  WHERE T.ID =" +
                    "                                        '8a10d4815d7cd89b015d8d629d2d0077')) TT" +
                    "                 ON M.ST_TP = TT.CODE) YY" +
                    "    ON S.STCD = YY.STCD" +
                    "   AND YY.PROJ_CD LIKE ?" +
                    " WHERE ISJIDIAN = 0" +
                    "   AND S.TYPEID = '0'" +
                    "   AND (YY.NAME = '5' OR YY.ST_TP = '5' OR YY.ST_TP = '1' OR YY.ST_TP = '2' OR YY.ST_TP = '5' OR YY.ST_TP = '7' OR YY.ST_TP = '8' OR YY.ST_TP = '9' )");
            List list = this.findBySqlWithMap(str.toString(),params.toArray());

            String sw = "";     //水位    5
            String swStcd="";
            List<Map> sw1= new ArrayList();

            String dccj="";     //渡槽沉降  9
            String dccjStcd="";
            List<Map> dccj1= new ArrayList();

            String sy="";     //渗压  1
            String syStcd="";
            List<Map> sy1= new ArrayList();

            String scwy="";     //深层位移  8
            String scwyStcd="";
            List<Map> scwy1= new ArrayList();

            /**
             * 将测点数据进行分组
             */
            for(int i=0;i<list.size();i++){
                Map map = (Map) list.get(i);
                String type= String.valueOf( map.get("ST_TP"));
                if(type.equals("5")){
                    //水位
                    sw1.add(map);
                }else if(type.equals("9")){
                    //渡槽沉降
                    dccj1.add(map);
                }else if(type.equals("1")){
                    //渗压
                    sy1.add(map);
                }else if(type.equals("8")){
                    //深层位移
                    scwy1.add(map);
                }
            }
            /**
             *  拼接各组数据字符串
             */
            //水位 S
            for (int i = 0; i < sw1.size(); i++) {
                if (i == 0) {
                    sw += "'"+sw1.get(i).get("STCD")+"'" + " AS " + sw1.get(i).get("STCD");
                    swStcd += "'" +sw1.get(i).get("STCD")+"'";
                } else {
                    sw += "," + "'"+sw1.get(i).get("STCD")+"'"  + " AS " + sw1.get(i).get("STCD");
                    swStcd +="," + "'" +sw1.get(i).get("STCD")+"'";
                }
            }
            //水位 E
            //渡槽沉降 S
            for (int i = 0; i < dccj1.size(); i++) {
                if (i == 0) {
                    dccj += "'"+dccj1.get(i).get("STCD")+"'" + " AS " + dccj1.get(i).get("STCD");
                    dccjStcd += "'"+dccj1.get(i).get("STCD")+"'";
                } else {
                    dccj += "," + "'"+dccj1.get(i).get("STCD")+"'"  + " AS " + dccj1.get(i).get("STCD");
                    dccjStcd += ","+"'"+dccj1.get(i).get("STCD")+"'";
                }
            }
            //渡槽沉降 E
            //渗压 S
            for (int i = 0; i < sy1.size(); i++) {
                if (i == 0) {
                    sy += "'"+sy1.get(i).get("STCD")+"'" + " AS " + sy1.get(i).get("STCD");
                    syStcd += "'"+sy1.get(i).get("STCD")+"'";
                } else {
                    sy += "," + "'"+sy1.get(i).get("STCD")+"'"  + " AS " + sy1.get(i).get("STCD");
                    syStcd += ","+"'"+sy1.get(i).get("STCD")+"'";
                }
            }
            //渗压 E
            //深层位移 S
            for (int i = 0; i < scwy1.size(); i++) {
                if (i == 0) {
                    scwy += "'"+scwy1.get(i).get("STCD")+"'" + " AS " + scwy1.get(i).get("STCD");
                    scwyStcd += "'"+scwy1.get(i).get("STCD")+"'";
                } else {
                    scwy += "," + "'"+scwy1.get(i).get("STCD")+"'"  + " AS " + scwy1.get(i).get("STCD");
                    scwyStcd += ","+"'"+scwy1.get(i).get("STCD")+"'";
                }
            }
            //深层位移 E

            sql.append("SELECT X.X, X.XM, DC.*, AA.*, BB.*, CC.* " +
                    "  FROM (SELECT * " +
                    "          FROM (SELECT 'A' AS A, " +
                    "                       'B' AS B, " +
                    "                       'C' AS C, " +
                    "                       'D' AS D, " +
                    "                       'E' AS E, " +
                    "                       'F' AS F, " +
                    "                       'G' AS G, " +
                    "                       'H' AS H, " +
                    "                       'I' AS I " +
                    "                  FROM DUAL) UNPIVOT(X FOR XM IN(A AS '最大值', " +
                    "                                                 B AS '最大值日期', " +
                    "                                                 C AS '最小值', " +
                    "                                                 D AS '最小值日期', " +
                    "                                                 E AS '变幅', " +
                    "                                                 F AS '历史最大值', " +
                    "                                                 G AS '历史最大值日期', " +
                    "                                                 H AS '历史最小值', " +
                    "                                                 I AS '历史最小值日期'))) X " +
                    "  LEFT JOIN (SELECT * " +
                    "               FROM (SELECT NVL(C.STCD, B.STCD) AS STCD, " +
                    "                            B.MAXVAL, " +
                    "                            B.MINVAL, " +
                    "                            B.MAXVALTM, " +
                    "                            B.MINVALTM, " +
                    "                            B.BF, " +
                    "                            C.LSMAXVAL, " +
                    "                            C.LSMINVAL, " +
                    "                            C.LSMAXVALTM, " +
                    "                            C.LSMINVALTM " +
                    "                       FROM (SELECT STCD, " +
                    "                                    TO_CHAR(A.MAXVAL,'999999999990.99') AS MAXVAL, " +
                    "                                    TO_CHAR(A.MINVAL,'999999999990.99') AS MINVAL, " +
                    "                                    TO_CHAR(MAXVAL - MINVAL,'999999999990.99') AS BF, " +
                    "                                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                                       FROM WR_SW_R " +
                    "                                      WHERE Z = A.MAXVAL " +
                    "                                        AND STCD = A.STCD " +
                    "                                        AND TO_CHAR(TM, 'yyyy-mm') = A.TM " +
                    "                                        AND ROWNUM = '1') AS MAXVALTM, " +
                    "                                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                                       FROM WR_SW_R " +
                    "                                      WHERE Z = A.MINVAL " +
                    "                                        AND STCD = A.STCD " +
                    "                                        AND TO_CHAR(TM, 'yyyy-mm') = A.TM " +
                    "                                        AND ROWNUM = '1') AS MINVALTM " +
                    "                               FROM (SELECT H.STCD, " +
                    "                                            S.ST_TP, " +
                    "                                            TO_CHAR(H.TM, 'yyyy-mm') AS TM, " +
                    "                                            MAX(Z) AS MAXVAL, " +
                    "                                            MIN(Z) AS MINVAL " +
                    "                                       FROM WR_SW_R H " +          //水位
                    "                                       LEFT JOIN WR_STAT_M S " +
                    "                                         ON H.STCD = S.STCD " +
                    "                                        AND S.ST_TP = '5' " +
                    "                                      WHERE TO_CHAR(H.TM, 'yyyy-mm') = ?" +
                    "                                        AND H.STCD IN ("+swStcd+") ");   // +
            param.add(tm);
            sql.append("                                      GROUP BY TO_CHAR(H.TM, 'yyyy-mm'), " +
                    "                                               H.STCD, " +
                    "                                               S.ST_TP) A) B " +
                    "                       FULL JOIN (SELECT STCD, " +
                    "                                        TO_CHAR(A.LSMAXVAL,'999999999990.99') AS LSMAXVAL, " +
                    "                                        TO_CHAR(A.LSMINVAL,'999999999990.99') AS LSMINVAL, " +
                    "                                        (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                                           FROM WR_SW_R " +
                    "                                          WHERE Z = A.LSMAXVAL " +
                    "                                            AND STCD = A.STCD " +
                    "                                            AND ROWNUM = '1') AS LSMAXVALTM, " +
                    "                                        (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                                           FROM WR_SW_R " +
                    "                                          WHERE Z = A.LSMINVAL " +
                    "                                            AND STCD = A.STCD " +
                    "                                            AND ROWNUM = '1') AS LSMINVALTM " +
                    "                                   FROM (SELECT H.STCD, " +
                    "                                                MAX(Z) AS LSMAXVAL, " +
                    "                                                MIN(Z) AS LSMINVAL " +
                    "                                           FROM WR_SW_R H " +      //水位
                    "                                           LEFT JOIN WR_STAT_M S " +
                    "                                             ON H.STCD = S.STCD " +
                    "                                          " +
                    "                                          WHERE H.STCD IN ("+swStcd+") ");  // +
            sql.append("GROUP BY H.STCD) A) C " +
                    "                         ON B.STCD = C.STCD) UNPIVOT(DC FOR SYXM IN(MAXVAL AS " +
                    "                                                                    '最大值', " +
                    "                                                                    MAXVALTM AS " +
                    "                                                                    '最大值日期', " +
                    "                                                                    MINVAL AS " +
                    "                                                                    '最小值', " +
                    "                                                                    MINVALTM AS " +
                    "                                                                    '最小值日期', " +
                    "                                                                    BF AS '变幅', " +
                    "                                                                    LSMAXVAL AS " +
                    "                                                                    '历史最大值', " +
                    "                                                                    LSMAXVALTM AS " +
                    "                                                                    '历史最大值日期', " +
                    "                                                                    LSMINVAL AS " +
                    "                                                                    '历史最小值', " +
                    "                                                                    LSMINVALTM AS " +
                    "                                                                    '历史最小值日期')) PIVOT(MAX(DC) FOR STCD IN("+sw+"))) DC ");  // +
            sql.append(" ON X.XM = DC.SYXM " +
                    "  LEFT JOIN (SELECT X.XMA, DC.* " +
                    "               FROM (SELECT * " +
                    "                       FROM (SELECT 'A' AS A, " +
                    "                                    'B' AS B, " +
                    "                                    'C' AS C, " +
                    "                                    'D' AS D, " +
                    "                                    'E' AS E, " +
                    "                                    'F' AS F, " +
                    "                                    'G' AS G, " +
                    "                                    'H' AS H, " +
                    "                                    'I' AS I " +
                    "                               FROM DUAL) UNPIVOT(X FOR XMA IN(A AS '最大值', " +
                    "                                                               B AS '最大值日期', " +
                    "                                                               C AS '最小值', " +
                    "                                                               D AS '最小值日期', " +
                    "                                                               E AS '变幅', " +
                    "                                                               F AS '历史最大值', " +
                    "                                                               G AS '历史最大值日期', " +
                    "                                                               H AS '历史最小值', " +
                    "                                                               I AS '历史最小值日期'))) X " +
                    "               LEFT JOIN (SELECT * " +
                    "                           FROM (SELECT NVL(C.STCD, B.STCD) AS STCD, " +
                    "                                        B.MAXVAL, " +
                    "                                        B.MINVAL, " +
                    "                                        B.MAXVALTM, " +
                    "                                        B.MINVALTM, " +
                    "                                        B.BF, " +
                    "                                        C.LSMAXVAL, " +
                    "                                        C.LSMINVAL, " +
                    "                                        C.LSMAXVALTM, " +
                    "                                        C.LSMINVALTM " +
                    "                                   FROM (SELECT STCD, " +
                    "                                                TO_CHAR(A.MAXVAL,'999999999990.99') AS MAXVAL, " +
                    "                                                TO_CHAR(A.MINVAL,'999999999990.99') AS MINVAL, " +
                    "                                                TO_CHAR(MAXVAL - MINVAL,'999999999990.99') AS BF, " +
                    "                                                (SELECT TO_CHAR(TM, " +
                    "                                                                'yyyy-mm-dd') " +
                    "                                                   FROM WR_MSFT_B " +
                    "                                                  WHERE NVL(CALCDATA, ORIGDATA) = " +
                    "                                                        A.MAXVAL " +
                    "                                                    AND STCD = A.STCD " +
                    "                                                    AND TO_CHAR(TM, 'yyyy-mm') = A.TM " +
                    "                                                    AND ROWNUM = '1') AS MAXVALTM, " +
                    "                                                (SELECT TO_CHAR(TM, " +
                    "                                                                'yyyy-mm-dd') " +
                    "                                                   FROM WR_MSFT_B " +
                    "                                                  WHERE NVL(CALCDATA, ORIGDATA) = " +
                    "                                                        A.MINVAL " +
                    "                                                    AND STCD = A.STCD " +
                    "                                                    AND TO_CHAR(TM, 'yyyy-mm') = A.TM " +
                    "                                                    AND ROWNUM = '1') AS MINVALTM " +
                    "                                           FROM (SELECT H.STCD, " +
                    "                                                        TO_CHAR(H.TM, 'yyyy-mm') AS TM, " +
                    "                                                        MAX(NVL(CALCDATA, " +
                    "                                                                ORIGDATA)) AS MAXVAL, " +
                    "                                                        MIN(NVL(CALCDATA, " +
                    "                                                                ORIGDATA)) AS MINVAL " +
                    "                                                   FROM WR_MSFT_B H " +    //多点位移监测信息表
                    "                                                   LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                                                     ON H.STCD = S.STCD " +
                    "                                                    AND S.ST_TP = '8' " +
                    "                                                  WHERE TO_CHAR(H.TM, 'yyyy-mm') = ?"+
                    "                                                 AND S.PROJ_CD LIKE '3%' " +
                    "                                                    AND H.STCD IN  ("+scwyStcd+") ");
            param.add(tm);
            sql.append("                                           GROUP BY TO_CHAR(H.TM, " +
                    "                                                                   'yyyy-mm'), " +
                    "                                                           H.STCD) A) B " +
                    "                                   FULL JOIN (SELECT STCD, " +
                    "                                                    TO_CHAR(A.LSMAXVAL,'999999999990.99') AS LSMAXVAL, " +
                    "                                                    TO_CHAR(A.LSMINVAL,'999999999990.99') AS LSMINVAL, " +
                    "                                                    (SELECT TO_CHAR(TM, " +
                    "                                                                    'yyyy-mm-dd') " +
                    "                                                       FROM WR_MSFT_B " +
                    "                                                      WHERE NVL(CALCDATA, " +
                    "                                                                ORIGDATA) = " +
                    "                                                            A.LSMAXVAL " +
                    "                                                        AND STCD = A.STCD " +
                    "                                                        AND ROWNUM = '1') AS LSMAXVALTM, " +
                    "                                                    (SELECT TO_CHAR(TM, " +
                    "                                                                    'yyyy-mm-dd') " +
                    "                                                       FROM WR_MSFT_B " +
                    "                                                      WHERE NVL(CALCDATA, " +
                    "                                                                ORIGDATA) = " +
                    "                                                            A.LSMINVAL " +
                    "                                                        AND STCD = A.STCD " +
                    "                                                        AND ROWNUM = '1') AS LSMINVALTM " +
                    "                                               FROM (SELECT H.STCD, " +
                    "                                                            MAX(NVL(CALCDATA, " +
                    "                                                                    ORIGDATA)) AS LSMAXVAL, " +
                    "                                                            MIN(NVL(CALCDATA, " +
                    "                                                                    ORIGDATA)) AS LSMINVAL " +
                    "                                                       FROM WR_MSFT_B H " +
                    "                                                       LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                                                         ON H.STCD = S.STCD " +
                    "                                                        AND S.ST_TP = '8' " +
                    "                                                      WHERE S.PROJ_CD LIKE '3%' " +
                    "                                                        AND H.STCD IN ("+scwyStcd+") ");
            sql.append("                                                  GROUP BY H.STCD) A) C " +
                    "                                     ON B.STCD = C.STCD) UNPIVOT(DC FOR SYXMA IN(MAXVAL AS " +
                    "                                                                                 '最大值', " +
                    "                                                                                 MAXVALTM AS " +
                    "                                                                                 '最大值日期', " +
                    "                                                                                 MINVAL AS " +
                    "                                                                                 '最小值', " +
                    "                                                                                 MINVALTM AS " +
                    "                                                                                 '最小值日期', " +
                    "                                                                                 BF AS '变幅', " +
                    "                                                                                 LSMAXVAL AS " +
                    "                                                                                 '历史最大值', " +
                    "                                                                                 LSMAXVALTM AS " +
                    "                                                                                 '历史最大值日期', " +
                    "                                                                                 LSMINVAL AS " +
                    "                                                                                 '历史最小值', " +
                    "                                                                                 LSMINVALTM AS " +
                    "                                                                                 '历史最小值日期')) PIVOT(MAX(DC) FOR STCD IN("+scwy+"))) DC "); // +
            sql.append("               ON X.XMA = DC.SYXMA " +
                    "              ORDER BY X.X) AA " +
                    "    ON X.XM = AA.XMA " +
                    "  LEFT JOIN (SELECT X.XMB, DC.* " +
                    "               FROM (SELECT * " +
                    "                       FROM (SELECT 'A' AS A, " +
                    "                                    'B' AS B, " +
                    "                                    'C' AS C, " +
                    "                                    'D' AS D, " +
                    "                                    'E' AS E, " +
                    "                                    'F' AS F, " +
                    "                                    'G' AS G, " +
                    "                                    'H' AS H, " +
                    "                                    'I' AS I " +
                    "                               FROM DUAL) UNPIVOT(X FOR XMB IN(A AS '最大值', " +
                    "                                                               B AS '最大值日期', " +
                    "                                                               C AS '最小值', " +
                    "                                                               D AS '最小值日期', " +
                    "                                                               E AS '变幅', " +
                    "                                                               F AS '历史最大值', " +
                    "                                                               G AS '历史最大值日期', " +
                    "                                                               H AS '历史最小值', " +
                    "                                                               I AS '历史最小值日期'))) X " +
                    "               LEFT JOIN (SELECT * " +
                    "                           FROM (SELECT NVL(C.STCD, B.STCD) AS STCD, " +
                    "                                        B.MAXVAL, " +
                    "                                        B.MINVAL, " +
                    "                                        B.MAXVALTM, " +
                    "                                        B.MINVALTM, " +
                    "                                        B.BF, " +
                    "                                        C.LSMAXVAL, " +
                    "                                        C.LSMINVAL, " +
                    "                                        C.LSMAXVALTM, " +
                    "                                        C.LSMINVALTM " +
                    "                                   FROM (SELECT STCD, " +
                    "                                                TO_CHAR(A.MAXVAL,'999999999990.99') AS MAXVAL, " +
                    "                                                TO_CHAR(A.MINVAL,'999999999990.99') AS MINVAL, " +
                    "                                                TO_CHAR(MAXVAL - MINVAL,'999999999990.99') AS BF, " +
                    "                                                (SELECT TO_CHAR(TM, " +
                    "                                                                'yyyy-mm-dd') " +
                    "                                                   FROM WR_CSFT_B " +
                    "                                                  WHERE NVL(CALCDATA, ORIGDATA) = " +
                    "                                                        A.MAXVAL " +
                    "                                                    AND STCD = A.STCD " +
                    "                                                    AND TO_CHAR(TM, 'yyyy-mm') = A.TM " +
                    "                                                    AND ROWNUM = '1') AS MAXVALTM, " +
                    "                                                (SELECT TO_CHAR(TM, " +
                    "                                                                'yyyy-mm-dd') " +
                    "                                                   FROM WR_CSFT_B " +
                    "                                                  WHERE NVL(CALCDATA, ORIGDATA) = " +
                    "                                                        A.MINVAL " +
                    "                                                    AND STCD = A.STCD " +
                    "                                                    AND TO_CHAR(TM, 'yyyy-mm') = A.TM " +
                    "                                                    AND ROWNUM = '1') AS MINVALTM " +
                    "                                           FROM (SELECT H.STCD, " +
                    "                                                        TO_CHAR(H.TM, 'yyyy-mm') AS TM, " +
                    "                                                        MAX(NVL(CALCDATA, " +
                    "                                                                ORIGDATA)) AS MAXVAL, " +
                    "                                                        MIN(NVL(CALCDATA, " +
                    "                                                                ORIGDATA)) AS MINVAL " +
                    "                                                   FROM WR_CSFT_B H " +    //渡槽沉降监测信息表
                    "                                                   LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                                                     ON H.STCD = S.STCD " +
                    "                                                    AND S.ST_TP = '9' " +
                    "                                                  WHERE TO_CHAR(H.TM, 'yyyy-mm') = ?" +
                    "                                                    AND S.PROJ_CD LIKE '3%' " +
                    "                                                    AND H.STCD IN ("+dccjStcd+") " ); //+
            param.add(tm);
            sql.append("                                               GROUP BY TO_CHAR(H.TM, " +
                    "                                                                   'yyyy-mm'), " +
                    "                                                           H.STCD) A) B " +
                    "                                   FULL JOIN (SELECT STCD, " +
                    "                                                    TO_CHAR(A.LSMAXVAL,'999999999990.99') AS LSMAXVAL, " +
                    "                                                    TO_CHAR(A.LSMINVAL,'999999999990.99') AS LSMINVAL, " +
                    "                                                    (SELECT TO_CHAR(TM, " +
                    "                                                                    'yyyy-mm-dd') " +
                    "                                                       FROM WR_CSFT_B " +
                    "                                                      WHERE NVL(CALCDATA, " +
                    "                                                                ORIGDATA) = " +
                    "                                                            A.LSMAXVAL " +
                    "                                                        AND STCD = A.STCD " +
                    "                                                        AND ROWNUM = '1') AS LSMAXVALTM, " +
                    "                                                    (SELECT TO_CHAR(TM, " +
                    "                                                                    'yyyy-mm-dd') " +
                    "                                                       FROM WR_CSFT_B " +
                    "                                                      WHERE NVL(CALCDATA, " +
                    "                                                                ORIGDATA) = " +
                    "                                                            A.LSMINVAL " +
                    "                                                        AND STCD = A.STCD " +
                    "                                                        AND ROWNUM = '1') AS LSMINVALTM " +
                    "                                               FROM (SELECT H.STCD, " +
                    "                                                            MAX(NVL(CALCDATA, " +
                    "                                                                    ORIGDATA)) AS LSMAXVAL, " +
                    "                                                            MIN(NVL(CALCDATA, " +
                    "                                                                    ORIGDATA)) AS LSMINVAL " +
                    "                                                       FROM WR_CSFT_B H " +        //渡槽沉降监测信息表
                    "                                                       LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                                                         ON H.STCD = S.STCD " +
                    "                                                        AND S.ST_TP = '9' " +
                    "                                                      WHERE S.PROJ_CD LIKE '3%' " +
                    "                                                        AND H.STCD IN  ("+dccjStcd+") "); // +
            sql.append("                                                  GROUP BY H.STCD) A) C " +
                    "                                     ON B.STCD = C.STCD) UNPIVOT(DC FOR SYXMB IN(MAXVAL AS " +
                    "                                                                                 '最大值', " +
                    "                                                                                 MAXVALTM AS " +
                    "                                                                                 '最大值日期', " +
                    "                                                                                 MINVAL AS " +
                    "                                                                                 '最小值', " +
                    "                                                                                 MINVALTM AS " +
                    "                                                                                 '最小值日期', " +
                    "                                                                                 BF AS '变幅', " +
                    "                                                                                 LSMAXVAL AS " +
                    "                                                                                 '历史最大值', " +
                    "                                                                                 LSMAXVALTM AS " +
                    "                                                                                 '历史最大值日期', " +
                    "                                                                                 LSMINVAL AS " +
                    "                                                                                 '历史最小值', " +
                    "                                                                                 LSMINVALTM AS " +
                    "                                                                                 '历史最小值日期')) PIVOT(MAX(DC) FOR STCD IN("+dccj+"))) DC "); // +
            sql.append("               ON X.XMB = DC.SYXMB " +
                    "              ORDER BY X.X) BB " +
                    "    ON X.XM = BB.XMB " +
                    "  LEFT JOIN (SELECT X.XMC, SY.* " +
                    "               FROM (SELECT * " +
                    "                       FROM (SELECT 'A' AS A, " +
                    "                                    'B' AS B, " +
                    "                                    'C' AS C, " +
                    "                                    'D' AS D, " +
                    "                                    'E' AS E, " +
                    "                                    'F' AS F, " +
                    "                                    'G' AS G, " +
                    "                                    'H' AS H, " +
                    "                                    'I' AS I " +
                    "                               FROM DUAL) UNPIVOT(X FOR XMC IN(A AS '最大值', " +
                    "                                                               B AS '最大值日期', " +
                    "                                                               C AS '最小值', " +
                    "                                                               D AS '最小值日期', " +
                    "                                                               E AS '变幅', " +
                    "                                                               F AS '历史最大值', " +
                    "                                                               G AS '历史最大值日期', " +
                    "                                                               H AS '历史最小值', " +
                    "                                                               I AS '历史最小值日期'))) X " +
                    "               LEFT JOIN (SELECT * " +
                    "                           FROM (SELECT NVL(C.STCD, B.STCD) AS STCD, " +
                    "                                        B.MAXVAL, " +
                    "                                        B.MINVAL, " +
                    "                                        B.MAXVALTM, " +
                    "                                        B.MINVALTM, " +
                    "                                        B.BF, " +
                    "                                        C.LSMAXVAL, " +
                    "                                        C.LSMINVAL, " +
                    "                                        C.LSMAXVALTM, " +
                    "                                        C.LSMINVALTM " +
                    "                                   FROM (SELECT STCD, " +
                    "                                                TO_CHAR(A.MAXVAL,'999999999990.99') AS MAXVAL, " +
                    "                                                TO_CHAR(A.MINVAL,'999999999990.99') AS MINVAL, " +
                    "                                                TO_CHAR(MAXVAL - MINVAL,'999999999990.99') AS BF, " +
                    "                                                (SELECT TO_CHAR(TM, " +
                    "                                                                'yyyy-mm-dd') " +
                    "                                                   FROM WR_HYDO_B " +
                    "                                                  WHERE NVL(CALCDATA, ORIGDATA) = " +
                    "                                                        A.MAXVAL " +
                    "                                                    AND STCD = A.STCD " +
                    "                                                    AND TO_CHAR(TM, 'yyyy-mm') = A.TM " +
                    "                                                    AND ROWNUM = '1') AS MAXVALTM, " +
                    "                                                (SELECT TO_CHAR(TM, " +
                    "                                                                'yyyy-mm-dd') " +
                    "                                                   FROM WR_HYDO_B " +
                    "                                                  WHERE NVL(CALCDATA, ORIGDATA) = " +
                    "                                                        A.MINVAL " +
                    "                                                    AND STCD = A.STCD " +
                    "                                                    AND TO_CHAR(TM, 'yyyy-mm') = A.TM " +
                    "                                                    AND ROWNUM = '1') AS MINVALTM " +
                    "                                           FROM (SELECT H.STCD, " +
                    "                                                        TO_CHAR(H.TM, 'yyyy-mm') AS TM, " +
                    "                                                        MAX(NVL(CALCDATA, " +
                    "                                                                ORIGDATA)) AS MAXVAL, " +
                    "                                                        MIN(NVL(CALCDATA, " +
                    "                                                                ORIGDATA)) AS MINVAL " +
                    "                                                   FROM WR_HYDO_B H " +    //渗压监测数据表
                    "                                                   LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                                                     ON H.STCD = S.STCD " +
                    "                                                    AND S.ST_TP = '1' " +
                    "                                                  WHERE TO_CHAR(H.TM, 'yyyy-mm') = ?" +
                    "                                                    AND S.PROJ_CD LIKE '3%' " +
                    "                                                    AND H.STCD IN ("+syStcd+") " );
            param.add(tm);
            sql.append("                                             GROUP BY TO_CHAR(H.TM, " +
                    "                                                                   'yyyy-mm'), " +
                    "                                                           H.STCD) A) B " +
                    "                                   FULL JOIN (SELECT STCD, " +
                    "                                                    TO_CHAR(A.LSMAXVAL,'999999999990.99') AS LSMAXVAL, " +
                    "                                                    TO_CHAR(A.LSMINVAL,'999999999990.99') AS LSMINVAL, " +
                    "                                                    (SELECT TO_CHAR(TM, " +
                    "                                                                    'yyyy-mm-dd') " +
                    "                                                       FROM WR_HYDO_B " +
                    "                                                      WHERE NVL(CALCDATA, " +
                    "                                                                ORIGDATA) = " +
                    "                                                            A.LSMAXVAL " +
                    "                                                        AND STCD = A.STCD " +
                    "                                                        AND ROWNUM = '1') AS LSMAXVALTM, " +
                    "                                                    (SELECT TO_CHAR(TM, " +
                    "                                                                    'yyyy-mm-dd') " +
                    "                                                       FROM WR_HYDO_B " +
                    "                                                      WHERE NVL(CALCDATA, " +
                    "                                                                ORIGDATA) = " +
                    "                                                            A.LSMINVAL " +
                    "                                                        AND STCD = A.STCD " +
                    "                                                        AND ROWNUM = '1') AS LSMINVALTM " +
                    "                                               FROM (SELECT H.STCD, " +
                    "                                                            MAX(NVL(CALCDATA, " +
                    "                                                                    ORIGDATA)) AS LSMAXVAL, " +
                    "                                                            MIN(NVL(CALCDATA, " +
                    "                                                                    ORIGDATA)) AS LSMINVAL " +
                    "                                                       FROM WR_HYDO_B H " +    //渗压
                    "                                                       LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                                                         ON H.STCD = S.STCD " +
                    "                                                        AND S.ST_TP = '1' " +
                    "                                                      WHERE S.PROJ_CD LIKE '3%' " +
                    "                                                        AND H.STCD IN ("+syStcd+") ");
            sql.append("                                                   GROUP BY H.STCD) A) C " +
                    "                                     ON B.STCD = C.STCD) UNPIVOT(SY FOR SYXMC IN(MAXVAL AS " +
                    "                                                                                 '最大值', " +
                    "                                                                                 MAXVALTM AS " +
                    "                                                                                 '最大值日期', " +
                    "                                                                                 MINVAL AS " +
                    "                                                                                 '最小值', " +
                    "                                                                                 MINVALTM AS " +
                    "                                                                                 '最小值日期', " +
                    "                                                                                 BF AS '变幅', " +
                    "                                                                                 LSMAXVAL AS " +
                    "                                                                                 '历史最大值', " +
                    "                                                                                 LSMAXVALTM AS " +
                    "                                                                                 '历史最大值日期', " +
                    "                                                                                 LSMINVAL AS " +
                    "                                                                                 '历史最小值', " +
                    "                                                                                 LSMINVALTM AS " +
                    "                                                                                 '历史最小值日期')) PIVOT(MAX(SY) FOR STCD IN("+sy+"))) SY " );
            sql.append("              ON X.XMC = SY.SYXMC " +
                    "              ORDER BY X.X) CC " +
                    "    ON X.XM = CC.XMC " +
                    " ORDER BY X.X");
        }

        return this.findEasyUiPageBySql(sql.toString(),easyUiPage,param.toArray());
    }

    @Override
    public EasyUiPage getjnbbListDg(String stime, String etime, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(stime) && StringUtil.isNotEmpty(etime) && StringUtil.isNotEmpty(projcd)) {
            StringBuffer sql = new StringBuffer();
            List params = new ArrayList();
            sql.append("SELECT 'm' AS UNIT, " +
                    "       AA.MAXDATA, " +
                    "       AA.MINDATA, " +
                    "       AA.MAXTM, " +
                    "       AA.MINTM, " +
                    "       AA.LASTDATA, " +
                    "       BB.*, " +
                    "       P.STNM, " +
                    "       S.PROJ_CD " +
                    "  FROM (SELECT A.*, " +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                  FROM WR_SW_R " +
                    "                 WHERE Z = A.MAXDATA " +
                    "                   AND STCD = A.STCD " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                   AND ROWNUM = 1) AS MAXTM, " +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                  FROM WR_SW_R " +
                    "                 WHERE Z = A.MINDATA " +
                    "                   AND STCD = A.STCD " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                   AND ROWNUM = 1) AS MINTM, " +
                    "               (SELECT Z " +
                    "                  FROM (SELECT Z " +
                    "                          FROM WR_SW_R C " +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                            ON C.STCD = S.STCD " +
                    "                           AND S.ST_TP = '5' " +
                    "                         WHERE S.PROJ_CD LIKE '3%' " +
                    "                           AND TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                           AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                         ORDER BY TM DESC) " +
                    "                 WHERE ROWNUM = 1) AS LASTDATA " +
                    "          FROM (SELECT STCD, MAX(Z) AS MAXDATA, MIN(Z) AS MINDATA " +
                    "                  FROM WR_SW_R " +
                    "                 WHERE TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                 GROUP BY STCD) A) AA " +
                    "  FULL JOIN (SELECT B.*, " +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                       FROM WR_SW_R " +
                    "                      WHERE Z = B.LSMAXDATA " +
                    "                        AND STCD = B.STCD " +
                    "                        AND ROWNUM = 1) AS LSMAXTM, " +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                       FROM WR_SW_R " +
                    "                      WHERE Z = B.LSMINDATA " +
                    "                        AND STCD = B.STCD " +
                    "                        AND ROWNUM = 1) AS LSMINTM " +
                    "               FROM (SELECT STCD, MAX(Z) AS LSMAXDATA, MIN(Z) AS LSMINDATA " +
                    "                       FROM WR_SW_R " +
                    "                      GROUP BY STCD) B) BB " +
                    "    ON AA.STCD = BB.STCD " +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "    ON BB.STCD = S.STCD " +
                    "  LEFT JOIN WR_STAT_M P " +
                    "    ON BB.STCD = P.STCD " +
                    " WHERE S.ST_TP = '5' " +
                    "   AND S.PROJ_CD LIKE '3%' " +
                    "UNION ALL " +
                    "SELECT 'mm' AS UNIT, " +
                    "       AA.MAXDATA, " +
                    "       AA.MINDATA, " +
                    "       AA.MAXTM, " +
                    "       AA.MINTM, " +
                    "       AA.LASTDATA, " +
                    "       BB.*, " +
                    "       P.STNM, " +
                    "       S.PROJ_CD " +
                    "  FROM (SELECT A.*, " +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                  FROM WR_MSFT_B " +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA " +
                    "                   AND STCD = A.STCD " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                   AND ROWNUM = 1) AS MAXTM, " +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                  FROM WR_MSFT_B " +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA " +
                    "                   AND STCD = A.STCD " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                   AND ROWNUM = 1) AS MINTM, " +
                    "               (SELECT DATA " +
                    "                  FROM (SELECT NVL(CALCDATA, ORIGDATA) AS DATA " +
                    "                          FROM WR_MSFT_B C " +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                            ON C.STCD = S.STCD " +
                    "                           AND S.ST_TP = '8' " +
                    "                         WHERE S.PROJ_CD LIKE '3%' " +
                    "                           AND TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                           AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                         ORDER BY TM DESC) " +
                    "                 WHERE ROWNUM = 1) AS LASTDATA " +
                    "          FROM (SELECT STCD, " +
                    "                       MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA, " +
                    "                       MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA " +
                    "                  FROM WR_MSFT_B " +
                    "                 WHERE TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                 GROUP BY STCD) A) AA " +
                    "  FULL JOIN (SELECT B.*, " +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                       FROM WR_MSFT_B " +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMAXDATA " +
                    "                        AND STCD = B.STCD " +
                    "                        AND ROWNUM = 1) AS LSMAXTM, " +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                       FROM WR_MSFT_B " +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMINDATA " +
                    "                        AND STCD = B.STCD " +
                    "                        AND ROWNUM = 1) AS LSMINTM " +
                    "               FROM (SELECT STCD, " +
                    "                            MAX(NVL(CALCDATA, ORIGDATA)) AS LSMAXDATA, " +
                    "                            MIN(NVL(CALCDATA, ORIGDATA)) AS LSMINDATA " +
                    "                       FROM WR_MSFT_B " +
                    "                      GROUP BY STCD) B) BB " +
                    "    ON AA.STCD = BB.STCD " +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "    ON BB.STCD = S.STCD " +
                    "  LEFT JOIN WR_STAT_M P " +
                    "    ON BB.STCD = P.STCD " +
                    " WHERE S.ST_TP = '8' " +
                    "   AND S.PROJ_CD LIKE '3%' " +
                    "UNION ALL " +
                    "SELECT 'mm' AS UNIT, " +
                    "       AA.MAXDATA, " +
                    "       AA.MINDATA, " +
                    "       AA.MAXTM, " +
                    "       AA.MINTM, " +
                    "       AA.LASTDATA, " +
                    "       BB.*, " +
                    "       P.STNM, " +
                    "       S.PROJ_CD " +
                    "  FROM (SELECT A.*, " +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                  FROM WR_CSFT_B " +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA " +
                    "                   AND STCD = A.STCD " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                   AND ROWNUM = 1) AS MAXTM, " +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                  FROM WR_CSFT_B " +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA " +
                    "                   AND STCD = A.STCD " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                   AND ROWNUM = 1) AS MINTM, " +
                    "               (SELECT DATA " +
                    "                  FROM (SELECT NVL(CALCDATA, ORIGDATA) AS DATA " +
                    "                          FROM WR_CSFT_B C " +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                            ON C.STCD = S.STCD " +
                    "                           AND S.ST_TP = '9' " +
                    "                         WHERE S.PROJ_CD LIKE '3%' " +
                    "                           AND TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                           AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                         ORDER BY TM DESC) " +
                    "                 WHERE ROWNUM = 1) AS LASTDATA " +
                    "          FROM (SELECT STCD, " +
                    "                       MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA, " +
                    "                       MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA " +
                    "                  FROM WR_CSFT_B " +
                    "                 WHERE TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                 GROUP BY STCD) A) AA " +
                    "  FULL JOIN (SELECT B.*, " +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                       FROM WR_CSFT_B " +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMAXDATA " +
                    "                        AND STCD = B.STCD " +
                    "                        AND ROWNUM = 1) AS LSMAXTM, " +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                       FROM WR_CSFT_B " +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMINDATA " +
                    "                        AND STCD = B.STCD " +
                    "                        AND ROWNUM = 1) AS LSMINTM " +
                    "               FROM (SELECT STCD, " +
                    "                            MAX(NVL(CALCDATA, ORIGDATA)) AS LSMAXDATA, " +
                    "                            MIN(NVL(CALCDATA, ORIGDATA)) AS LSMINDATA " +
                    "                       FROM WR_CSFT_B " +
                    "                      GROUP BY STCD) B) BB " +
                    "    ON AA.STCD = BB.STCD " +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "    ON BB.STCD = S.STCD " +
                    "  LEFT JOIN WR_STAT_M P " +
                    "    ON BB.STCD = P.STCD " +
                    " WHERE S.ST_TP = '9' " +
                    "   AND S.PROJ_CD LIKE '3%' " +
                    "UNION ALL " +
                    "SELECT 'm' AS UNIT, " +
                    "       AA.MAXDATA, " +
                    "       AA.MINDATA, " +
                    "       AA.MAXTM, " +
                    "       AA.MINTM, " +
                    "       AA.LASTDATA, " +
                    "       BB.*, " +
                    "       P.STNM, " +
                    "       S.PROJ_CD " +
                    "  FROM (SELECT A.*, " +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                  FROM WR_HYDO_B " +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA " +
                    "                   AND STCD = A.STCD " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                   AND ROWNUM = 1) AS MAXTM, " +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                  FROM WR_HYDO_B " +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA " +
                    "                   AND STCD = A.STCD " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                   AND ROWNUM = 1) AS MINTM, " +
                    "               (SELECT DATA " +
                    "                  FROM (SELECT NVL(CALCDATA, ORIGDATA) AS DATA " +
                    "                          FROM WR_HYDO_B H " +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "                            ON H.STCD = S.STCD " +
                    "                         WHERE S.ST_TP = '1' " +
                    "                           AND S.PROJ_CD LIKE '3%' " +
                    "                           AND TO_CHAR(TM, 'yyyy-mm-dd') = ? " +
                    "                         ORDER BY TM DESC) " +
                    "                 WHERE ROWNUM = 1) AS LASTDATA " +
                    "          FROM (SELECT STCD, " +
                    "                       MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA, " +
                    "                       MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA " +
                    "                  FROM WR_HYDO_B " +
                    "                 WHERE TO_CHAR(TM, 'yyyy-mm-dd') >= ? " +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ? " +
                    "                 GROUP BY STCD) A) AA " +
                    "  FULL JOIN (SELECT B.*, " +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                       FROM WR_HYDO_B " +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMAXDATA " +
                    "                        AND STCD = B.STCD " +
                    "                        AND ROWNUM = 1) AS LSMAXTM, " +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "                       FROM WR_HYDO_B " +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMINDATA " +
                    "                        AND STCD = B.STCD " +
                    "                        AND ROWNUM = 1) AS LSMINTM " +
                    "               FROM (SELECT STCD, " +
                    "                            MAX(NVL(CALCDATA, ORIGDATA)) AS LSMAXDATA, " +
                    "                            MIN(NVL(CALCDATA, ORIGDATA)) AS LSMINDATA " +
                    "                       FROM WR_HYDO_B " +
                    "                      GROUP BY STCD) B) BB " +
                    "    ON AA.STCD = BB.STCD " +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "    ON BB.STCD = S.STCD " +
                    "  LEFT JOIN WR_STAT_M P " +
                    "    ON BB.STCD = P.STCD " +
                    " WHERE S.ST_TP = '1' " +
                    "   AND S.PROJ_CD LIKE '3%'");
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            return this.findEasyUiPageBySql(sql.toString(),easyUiPage,params.toArray());
        }else {
            return easyUiPage;
        }

    }

    @Override
    public EasyUiPage getDnpjtzzList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(syear) && StringUtil.isNotEmpty(eyear) && StringUtil.isNotEmpty(projcd)){
            StringBuffer sql = new StringBuffer();
            List params = new ArrayList();
            sql.append("SELECT A.*, " +
                    "       A.MAXDATA - A.MINDATA AS BF, " +
                    "       P.STNM, " +
                    "       S.PROJ_CD, " +
                    "       'm' AS UNIT, " +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "          FROM WR_SW_R " +
                    "         WHERE Z = A.MAXDATA " +
                    "           AND STCD = A.STCD " +
                    "           AND TO_CHAR(TM, 'yyyy') >= ? " +
                    "           AND TO_CHAR(TM, 'yyyy') <= ? " +
                    "           AND ROWNUM = 1) AS MAXTM, " +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "          FROM WR_SW_R " +
                    "         WHERE Z = A.MINDATA " +
                    "           AND STCD = A.STCD " +
                    "           AND TO_CHAR(TM, 'yyyy') >= ? " +
                    "           AND TO_CHAR(TM, 'yyyy') <= ? " +
                    "           AND ROWNUM = 1) AS MINTM " +
                    "  FROM (SELECT STCD, " +
                    "               MAX(Z) AS MAXDATA, " +
                    "               MIN(Z) AS MINDATA, " +
                    "               ROUND(AVG(Z), 3) AS AVGDATA " +
                    "          FROM WR_SW_R " +
                    "         WHERE TO_CHAR(TM, 'yyyy') >= ? " +
                    "           AND TO_CHAR(TM, 'yyyy') <= ? " +
                    "         GROUP BY STCD) A " +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "    ON A.STCD = S.STCD " +
                    "  LEFT JOIN WR_STAT_M P " +
                    "    ON A.STCD = P.STCD " +
                    " WHERE S.ST_TP = '5' " +
                    "   AND S.PROJ_CD LIKE '3%' " +
                    "UNION ALL " +
                    "SELECT A.*, " +
                    "       A.MAXDATA - A.MINDATA AS BF, " +
                    "       P.STNM, " +
                    "       S.PROJ_CD, " +
                    "       'mm' AS UNIT, " +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "          FROM WR_MSFT_B " +
                    "         WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA " +
                    "           AND STCD = A.STCD " +
                    "           AND TO_CHAR(TM, 'yyyy') >= ? " +
                    "           AND TO_CHAR(TM, 'yyyy') <= ? " +
                    "           AND ROWNUM = 1) AS MAXTM, " +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "          FROM WR_MSFT_B " +
                    "         WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA " +
                    "           AND STCD = A.STCD " +
                    "           AND TO_CHAR(TM, 'yyyy') >= ? " +
                    "           AND TO_CHAR(TM, 'yyyy') <= ? " +
                    "           AND ROWNUM = 1) AS MINTM " +
                    "  FROM (SELECT STCD, " +
                    "               MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA, " +
                    "               MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA, " +
                    "               ROUND(AVG(NVL(CALCDATA, ORIGDATA)), 3) AS AVGDATA " +
                    "          FROM WR_MSFT_B " +
                    "         WHERE TO_CHAR(TM, 'yyyy') >= ? " +
                    "           AND TO_CHAR(TM, 'yyyy') <= ? " +
                    "         GROUP BY STCD) A " +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "    ON A.STCD = S.STCD " +
                    "  LEFT JOIN WR_STAT_M P " +
                    "    ON A.STCD = P.STCD " +
                    " WHERE S.ST_TP = '8' " +
                    "   AND S.PROJ_CD LIKE '3%' " +
                    "UNION ALL " +
                    "SELECT A.*, " +
                    "       A.MAXDATA - A.MINDATA AS BF, " +
                    "       P.STNM, " +
                    "       S.PROJ_CD, " +
                    "       'mm' AS UNIT, " +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "          FROM WR_CSFT_B " +
                    "         WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA " +
                    "           AND STCD = A.STCD " +
                    "           AND TO_CHAR(TM, 'yyyy') >= ? " +
                    "           AND TO_CHAR(TM, 'yyyy') <= ? " +
                    "           AND ROWNUM = 1) AS MAXTM, " +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "          FROM WR_CSFT_B " +
                    "         WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA " +
                    "           AND STCD = A.STCD " +
                    "           AND TO_CHAR(TM, 'yyyy') >= ? " +
                    "           AND TO_CHAR(TM, 'yyyy') <= ? " +
                    "           AND ROWNUM = 1) AS MINTM " +
                    "  FROM (SELECT STCD, " +
                    "               MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA, " +
                    "               MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA, " +
                    "               ROUND(AVG(NVL(CALCDATA, ORIGDATA)), 3) AS AVGDATA " +
                    "          FROM WR_CSFT_B " +
                    "         WHERE TO_CHAR(TM, 'yyyy') >= ? " +
                    "           AND TO_CHAR(TM, 'yyyy') <= ? " +
                    "         GROUP BY STCD) A " +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "    ON A.STCD = S.STCD " +
                    "  LEFT JOIN WR_STAT_M P " +
                    "    ON A.STCD = P.STCD " +
                    " WHERE S.ST_TP = '9' " +
                    "   AND S.PROJ_CD LIKE '3%' " +
                    "UNION ALL " +
                    "SELECT A.*, " +
                    "       A.MAXDATA - A.MINDATA AS BF, " +
                    "       P.STNM, " +
                    "       S.PROJ_CD, " +
                    "       'm' AS UNIT, " +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "          FROM WR_HYDO_B " +
                    "         WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA " +
                    "           AND STCD = A.STCD " +
                    "           AND TO_CHAR(TM, 'yyyy') >= ? " +
                    "           AND TO_CHAR(TM, 'yyyy') <= ? " +
                    "           AND ROWNUM = 1) AS MAXTM, " +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd') " +
                    "          FROM WR_HYDO_B " +
                    "         WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA " +
                    "           AND STCD = A.STCD " +
                    "           AND TO_CHAR(TM, 'yyyy') >= ? " +
                    "           AND TO_CHAR(TM, 'yyyy') <= ? " +
                    "           AND ROWNUM = 1) AS MINTM " +
                    "  FROM (SELECT STCD, " +
                    "               MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA, " +
                    "               MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA, " +
                    "               ROUND(AVG(NVL(CALCDATA, ORIGDATA)), 3) AS AVGDATA " +
                    "          FROM WR_HYDO_B " +
                    "         WHERE TO_CHAR(TM, 'yyyy') >= ? " +
                    "           AND TO_CHAR(TM, 'yyyy') <= ? " +
                    "         GROUP BY STCD) A " +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S " +
                    "    ON A.STCD = S.STCD " +
                    "  LEFT JOIN WR_STAT_M P " +
                    "    ON A.STCD = P.STCD " +
                    " WHERE S.ST_TP = '1' " +
                    "   AND S.PROJ_CD LIKE '3%' ");
            params.add(syear);
            params.add(eyear);
            params.add(syear);
            params.add(eyear);
            params.add(syear);
            params.add(eyear);
            params.add(syear);
            params.add(eyear);
            params.add(syear);
            params.add(eyear);
            params.add(syear);
            params.add(eyear);
            params.add(syear);
            params.add(eyear);
            params.add(syear);
            params.add(eyear);
            params.add(syear);
            params.add(eyear);
            params.add(syear);
            params.add(eyear);
            params.add(syear);
            params.add(eyear);
            params.add(syear);
            params.add(eyear);
            return this.findEasyUiPageBySql(sql.toString(),easyUiPage,params.toArray());
        }else {
            return easyUiPage;
        }
    }
}

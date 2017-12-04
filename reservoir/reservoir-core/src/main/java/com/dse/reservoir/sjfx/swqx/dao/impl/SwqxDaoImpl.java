package com.dse.reservoir.sjfx.swqx.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.pojo.entity.SjfxDataEntity;
import com.dse.reservoir.sjfx.swqx.dao.SwqxDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 水文气象Dao层
 */
@Repository("swqxDao")
public class SwqxDaoImpl extends BaseDao implements SwqxDao {

    @Override
    public List<Map> getTree() throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT PROJ_CD AS ID,PROJ_NM AS NAME,PID,ISSW,ISSY,ISDC,ISSC,ISCZ,ISSP FROM WR_PROJ_B T WHERE T.ISDISPLAY='0'  ORDER BY ID";

        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public EasyUiPage getQxDate(String stm, String etm, String projcd, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT '"+ SjfxDataEntity.ST_TP_5+"' ST_TP, A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,round(A.RZ,2) AS DATA FROM ST_RSVR_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '5' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(projcd)){
            sql += " AND M.PROJ_CD = ? ";
            params.add(projcd);
        }

        sql += " UNION ALL SELECT '"+ SjfxDataEntity.ST_TP_6+"' ST_TP, A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,round(A.DYP,2) AS DATA FROM ST_PPTN_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '6' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(projcd)){
            sql += " AND M.PROJ_CD = ? ";
            params.add(projcd);
        }

        sql += " UNION ALL SELECT '"+ SjfxDataEntity.ST_TP_7+"' ST_TP, A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,round(NVL(A.CATMP,A.ATMP),2) AS DATA FROM ST_TMP_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '7' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(projcd)){
            sql += " AND M.PROJ_CD = ? ";
            params.add(projcd);
        }

        sql += " UNION ALL SELECT '"+ SjfxDataEntity.ST_TP_7_1+"' ST_TP, A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,round(NVL(CAIRP,AIRP),2) AS DATA FROM ST_TMP_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '7' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(projcd)){
            sql += " AND M.PROJ_CD = ? ";
            params.add(projcd);
        }

        sql += " ORDER BY TM DESC";

        return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
    }

    @Override
    public EasyUiPage getSwDate(String stm, String etm, String projcd, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,round(A.RZ,2) RZ FROM ST_RSVR_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '5' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(projcd)){
            sql += " AND M.PROJ_CD = ? ";
            params.add(projcd);
        }

        sql += " ORDER BY TM DESC";

        return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
    }

    @Override
    public Object getGcxSwDate(String stm, String etm, GcxEntity gcxArgs) throws Exception {
        List<Object> params = new ArrayList<Object>();// hh24:mi:ss
        String sql = "SELECT A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd') AS TM,round(A.RZ,2) RZ FROM ST_RSVR_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '5' AND S.ISJIDIAN = '0' ";

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
        sql += " ORDER BY TM,STCD";

        return findBySqlWithMap(sql, params.toArray());
    }

    @Override
    public EasyUiPage getYlDate(String stm, String etm, String projcd, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,round(A.DYP,2) DYP FROM ST_PPTN_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '6' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(projcd)){
            sql += " AND M.PROJ_CD = ? ";
            params.add(projcd);
        }

        sql += " ORDER BY TM DESC";

        return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
    }

    @Override
    public Object getGcxYlDate(String stm, String etm, GcxEntity gcxArgs) throws Exception {
        List<Object> params = new ArrayList<Object>();// hh24:mi:ss
        String sql = "SELECT A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd') AS TM,round(A.DYP,2) DYP FROM ST_PPTN_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '6' AND S.ISJIDIAN = '0' ";

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
        sql += " ORDER BY TM,STCD";

        return findBySqlWithMap(sql, params.toArray());
    }



    @Override
    public EasyUiPage getQwqyDate(String stm, String etm, String projcd, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,round(NVL(A.CATMP,A.ATMP),2) AS ATMP,round(NVL(CAIRP,AIRP),2) AS AIRP FROM ST_TMP_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '7' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(projcd)){
            sql += " AND M.PROJ_CD = ? ";
            params.add(projcd);
        }

        sql += " ORDER BY TM DESC";

        return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
    }

    /**
     * 查询气温气压数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs
     * @return
     */
    public Object getGcxQwqyDate(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        List<Object> params = new ArrayList<Object>();// hh24:mi:ss
        String sql = "SELECT A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd') AS TM,round(NVL(A.CATMP,A.ATMP),2) AS ATMP,round(NVL(CAIRP,AIRP),2) AS AIRP FROM ST_TMP_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '7' AND S.ISJIDIAN = '0' ";

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
        sql += " ORDER BY TM,STCD";

        return findBySqlWithMap(sql, params.toArray());
    }

    @Override
    public String getSwStcd(String projcd) throws Exception {
        if(StringUtil.isNotEmpty(projcd)) {
            String sql = "SELECT STCD FROM WR_ST_PROJ_TYPE_MAP WHERE PROJ_CD = ? AND ST_TP = '5' AND ROWNUM = '1' ";
            List<Map> list = findBySqlWithMap(sql,projcd);
            String stcd = (String)list.get(0).get("STCD");
            return stcd;
        }
        return null;
    }

    @Override
    public String getYlStcd(String projcd) throws Exception {
        if(StringUtil.isNotEmpty(projcd)) {
            String sql = "SELECT STCD FROM WR_ST_PROJ_TYPE_MAP WHERE PROJ_CD = ? AND ST_TP = '6' AND ROWNUM = '1' ";
            List<Map> list = findBySqlWithMap(sql,projcd);
            String stcd = (String)list.get(0).get("STCD");
            return stcd;
        }
        return null;
    }

    @Override
    public String getQwStcd(String projcd) throws Exception {
        if(StringUtil.isNotEmpty(projcd)) {
            String sql = "SELECT STCD FROM WR_ST_PROJ_TYPE_MAP WHERE PROJ_CD = ? AND ST_TP = '7' AND ROWNUM = '1' ";
            List<Map> list = findBySqlWithMap(sql,projcd);
            String stcd = (String)list.get(0).get("STCD");
            return stcd;
        }
        return null;
    }

    //季年度报表
    @Override
    public EasyUiPage getjnbbList(String stime, String etime, String swstcd, String ylstcd, String qwstcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(stime) && StringUtil.isNotEmpty(etime) && StringUtil.isNotEmpty(swstcd) && StringUtil.isNotEmpty(ylstcd) && StringUtil.isNotEmpty(qwstcd)) {
            List<Object> params = new ArrayList<Object>();
            //气温行数据
            String sql = "SELECT '气温' AS NAME,\n" +
                    "       '°C' AS UNIT,\n" +
                    "       A2.STCD,\n" +
                    "       A.MAXATMP AS MAXVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_TMP_R\n" +
                    "         WHERE STCD = A2.STCD\n" +
                    "           AND TM >= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND TM <= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND NVL(CATMP, ATMP) = A.MAXATMP\n" +
                    "           AND ROWNUM = 1) AS MAXTM,\n" +
                    "       A.MINATMP AS MINVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_TMP_R\n" +
                    "         WHERE STCD = A2.STCD\n" +
                    "           AND TM >= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND TM <= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND NVL(CATMP, ATMP) = A.MINATMP\n" +
                    "           AND ROWNUM = 1) AS MINTM,\n" +
                    "       (SELECT ATMP\n" +
                    "          FROM (SELECT ATMP\n" +
                    "                  FROM ST_TMP_R\n" +
                    "                 WHERE STCD = ?\n" +
                    "                   AND TO_CHAR(TM,'yyyy-mm-dd') = ?\n" +
                    "                 ORDER BY TM DESC)\n" +
                    "         WHERE ROWNUM = 1) AS LASTVAL,\n" +
                    "       A2.LSMAXATMP AS LSMAXVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_TMP_R\n" +
                    "         WHERE STCD = A2.STCD\n" +
                    "           AND NVL(CATMP, ATMP) = A2.LSMAXATMP\n" +
                    "           AND ROWNUM = 1) AS LSMAXTM,\n" +
                    "       A2.LSMINATMP AS LSMINVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_TMP_R\n" +
                    "         WHERE STCD = A2.STCD\n" +
                    "           AND NVL(CATMP, ATMP) = A2.LSMINATMP\n" +
                    "           AND ROWNUM = 1) AS LSMINTM\n" +
                    "  FROM (SELECT STCD,\n" +
                    "               MAX(NVL(CATMP, ATMP)) AS MAXATMP,\n" +
                    "               MIN(NVL(CATMP, ATMP)) AS MINATMP\n" +
                    "          FROM ST_TMP_R\n" +
                    "         WHERE TM >= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND TM <= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND STCD = ?\n" +
                    "         GROUP BY STCD) A,\n" +
                    "       (SELECT STCD,\n" +
                    "               MAX(NVL(CATMP, ATMP)) AS LSMAXATMP,\n" +
                    "               MIN(NVL(CATMP, ATMP)) AS LSMINATMP\n" +
                    "          FROM ST_TMP_R\n" +
                    "         WHERE STCD = ?\n" +
                    "         GROUP BY STCD) A2 ";
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(qwstcd);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(qwstcd);
            params.add(qwstcd);

            //气压行数据
            sql +=  " UNION ALL\n" +
                    "SELECT '气压' AS NAME,\n" +
                    "       'kpa' AS UNIT,\n" +
                    "       B2.STCD,\n" +
                    "       B.MAXAIRP AS MAXVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_TMP_R\n" +
                    "         WHERE STCD = B2.STCD\n" +
                    "           AND TM >= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND TM <= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND NVL(CAIRP, AIRP) = B.MAXAIRP\n" +
                    "           AND ROWNUM = 1) AS MAXTM,\n" +
                    "       B.MINAIRP AS MINVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_TMP_R\n" +
                    "         WHERE STCD = B2.STCD\n" +
                    "           AND TM >= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND TM <= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND NVL(CAIRP, AIRP) = B.MINAIRP\n" +
                    "           AND ROWNUM = 1) AS MINTM,\n" +
                    "       (SELECT AIRP\n" +
                    "          FROM (SELECT AIRP\n" +
                    "                  FROM ST_TMP_R\n" +
                    "                 WHERE STCD = ?\n" +
                    "                   AND TO_CHAR(TM,'yyyy-mm-dd') = ?\n" +
                    "                 ORDER BY TM DESC)\n" +
                    "         WHERE ROWNUM = 1) AS LASTVAL,\n" +
                    "       B2.LSMAXAIRP AS LSMAXVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_TMP_R\n" +
                    "         WHERE STCD = B2.STCD\n" +
                    "           AND NVL(CAIRP, AIRP) = B2.LSMAXAIRP\n" +
                    "           AND ROWNUM = 1) AS LSMAXTM,\n" +
                    "       B2.LSMINAIRP AS LSMINVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_TMP_R\n" +
                    "         WHERE STCD = B2.STCD\n" +
                    "           AND NVL(CAIRP, AIRP) = B2.LSMINAIRP\n" +
                    "           AND ROWNUM = 1) AS LSMINTM\n" +
                    "  FROM (SELECT STCD,\n" +
                    "               MAX(NVL(CAIRP, AIRP)) AS MAXAIRP,\n" +
                    "               MIN(NVL(CAIRP, AIRP)) AS MINAIRP\n" +
                    "          FROM ST_TMP_R\n" +
                    "         WHERE TM >= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND TM <= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND STCD = ?\n" +
                    "         GROUP BY STCD) B,\n" +
                    "       (SELECT STCD,\n" +
                    "               MAX(NVL(CAIRP, AIRP)) AS LSMAXAIRP,\n" +
                    "               MIN(NVL(CAIRP, AIRP)) AS LSMINAIRP\n" +
                    "          FROM ST_TMP_R\n" +
                    "         WHERE STCD = ?\n" +
                    "         GROUP BY STCD) B2 ";
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(qwstcd);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(qwstcd);
            params.add(qwstcd);

            //水位行数据
            sql +=  " UNION ALL\n" +
                    "SELECT '水位' AS NAME,\n" +
                    "       'm' AS UNIT,\n" +
                    "       C2.STCD,\n" +
                    "       C.MAXRZ AS MAXVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_RSVR_R\n" +
                    "         WHERE STCD = C2.STCD\n" +
                    "           AND TM >= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND TM <= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND RZ = C.MAXRZ\n" +
                    "           AND ROWNUM = 1) AS MAXTM,\n" +
                    "       C.MINRZ AS MINVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_RSVR_R\n" +
                    "         WHERE STCD = C2.STCD\n" +
                    "           AND TM >= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND TM <= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND RZ = C.MINRZ\n" +
                    "           AND ROWNUM = 1) AS MINTM,\n" +
                    "       (SELECT RZ\n" +
                    "          FROM (SELECT RZ\n" +
                    "                  FROM ST_RSVR_R\n" +
                    "                 WHERE STCD = ?\n" +
                    "                   AND TO_CHAR(TM,'yyyy-mm-dd') = ?\n" +
                    "                 ORDER BY TM DESC)\n" +
                    "         WHERE ROWNUM = 1) AS LASTVAL,\n" +
                    "       C2.LSMAXRZ AS LSMAXVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_RSVR_R\n" +
                    "         WHERE STCD = C2.STCD\n" +
                    "           AND RZ = C2.LSMAXRZ\n" +
                    "           AND ROWNUM = 1) AS LSMAXTM,\n" +
                    "       C2.LSMINRZ AS LSMINVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_RSVR_R\n" +
                    "         WHERE STCD = C2.STCD\n" +
                    "           AND RZ = C2.LSMINRZ\n" +
                    "           AND ROWNUM = 1) AS LSMINTM\n" +
                    "  FROM (SELECT STCD, MAX(RZ) AS MAXRZ, MIN(RZ) AS MINRZ\n" +
                    "          FROM ST_RSVR_R\n" +
                    "         WHERE TM >= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND TM <= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND STCD = ?\n" +
                    "         GROUP BY STCD) C,\n" +
                    "       (SELECT STCD, MAX(RZ) AS LSMAXRZ, MIN(RZ) AS LSMINRZ\n" +
                    "          FROM ST_RSVR_R\n" +
                    "         WHERE STCD = ?\n" +
                    "         GROUP BY STCD) C2 ";
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(swstcd);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(swstcd);
            params.add(swstcd);

            //降雨量行数据
            sql +=  " UNION ALL\n" +
                    "SELECT '降雨量' AS NAME,\n" +
                    "       'mm' AS UNIT,\n" +
                    "       D2.STCD,\n" +
                    "       D.MAXDYP AS MAXVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_PPTN_R\n" +
                    "         WHERE STCD = D2.STCD\n" +
                    "           AND TM >= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND TM <= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND DYP = D.MAXDYP\n" +
                    "           AND ROWNUM = 1) AS MAXTM,\n" +
                    "       D.MINDYP AS MINVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_PPTN_R\n" +
                    "         WHERE STCD = D2.STCD\n" +
                    "           AND TM >= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND TM <= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND DYP = D.MINDYP\n" +
                    "           AND ROWNUM = 1) AS MINTM,\n" +
                    "       (SELECT DYP\n" +
                    "          FROM (SELECT DYP\n" +
                    "                  FROM ST_PPTN_R\n" +
                    "                 WHERE STCD = ?\n" +
                    "                   AND TO_CHAR(TM,'yyyy-mm-dd') = ?\n" +
                    "                 ORDER BY TM DESC)\n" +
                    "         WHERE ROWNUM = 1) AS LASTVAL,\n" +
                    "       D2.LSMAXDYP AS LSMAXVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_PPTN_R\n" +
                    "         WHERE STCD = D2.STCD\n" +
                    "           AND DYP = D2.LSMAXDYP\n" +
                    "           AND ROWNUM = 1) AS LSMAXTM,\n" +
                    "       D2.LSMINDYP AS LSMINVAL,\n" +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')\n" +
                    "          FROM ST_PPTN_R\n" +
                    "         WHERE STCD = D2.STCD\n" +
                    "           AND DYP = D2.LSMINDYP\n" +
                    "           AND ROWNUM = 1) AS LSMINTM\n" +
                    "  FROM (SELECT STCD, MAX(DYP) AS MAXDYP, MIN(DYP) AS MINDYP\n" +
                    "          FROM ST_PPTN_R\n" +
                    "         WHERE TM >= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND TM <= TO_DATE(?, 'yyyy-mm-dd')\n" +
                    "           AND STCD = ?\n" +
                    "         GROUP BY STCD) D,\n" +
                    "       (SELECT STCD, MAX(DYP) AS LSMAXDYP, MIN(DYP) AS LSMINDYP\n" +
                    "          FROM ST_PPTN_R\n" +
                    "         WHERE STCD = ?\n" +
                    "         GROUP BY STCD) D2\n ";
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(ylstcd);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(ylstcd);
            params.add(ylstcd);

            return this.findEasyUiPageBySql(sql,easyUiPage,params.toArray());
        }
        return easyUiPage;
    }

    //水位特征值报表
    @Override
    public EasyUiPage getSwtzzbbList(String syear, String eyear, String stcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(syear) && StringUtil.isNotEmpty(eyear) && StringUtil.isNotEmpty(stcd)) {
            List<Object> params = new ArrayList<Object>();
            //历年数据
            String sql = "SELECT A.YEAR,A.MAXVAL,(SELECT TO_CHAR(TM,'yyyy-mm-dd') FROM ST_RSVR_R " +
                    "WHERE STCD = ? AND TO_CHAR(TM,'yyyy') >= ? AND TO_CHAR(TM,'yyyy') <= ? AND RZ = A.MAXVAL AND ROWNUM = 1) AS MAXTM," +
                    "A.MINVAL,(SELECT TO_CHAR(TM,'yyyy-mm-dd') FROM ST_RSVR_R " +
                    "WHERE STCD = ? AND TO_CHAR(TM,'yyyy') >= ? AND TO_CHAR(TM,'yyyy') <= ? AND RZ = A.MINVAL AND ROWNUM = 1) AS MINTM," +
                    "A.AVGVAL,A.MAXVAL - A.MINVAL AS BF FROM " +
                    "(SELECT TO_CHAR(TM,'yyyy') AS YEAR,MAX(RZ) AS MAXVAL,MIN(RZ) AS MINVAL,AVG(RZ) AS AVGVAL FROM ST_RSVR_R " +
                    "WHERE STCD = ? GROUP BY TO_CHAR(TM,'yyyy') HAVING TO_CHAR(TM,'yyyy') >= ? AND TO_CHAR(TM,'yyyy') <= ?) A ";
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);

            //合计
            sql +=  "UNION ALL " +
                    "SELECT B.YEAR,B.MAXVAL,(SELECT TO_CHAR(TM,'yyyy-mm-dd') FROM ST_RSVR_R " +
                    "WHERE STCD = ? AND TO_CHAR(TM,'yyyy') >= ? AND TO_CHAR(TM,'yyyy') <= ? AND RZ = B.MAXVAL AND ROWNUM = 1) AS MAXTM," +
                    "B.MINVAL,(SELECT TO_CHAR(TM,'yyyy-mm-dd') FROM ST_RSVR_R " +
                    "WHERE STCD = ? AND TO_CHAR(TM,'yyyy') >= ? AND TO_CHAR(TM,'yyyy') <= ? AND RZ = B.MINVAL AND ROWNUM = 1) AS MINTM," +
                    "B.AVGVAL,B.MAXVAL - B.MINVAL AS BF FROM " +
                    "(SELECT ? AS YEAR,MAX(RZ) AS MAXVAL,MIN(RZ) AS MINVAL,AVG(RZ) AS AVGVAL FROM ST_RSVR_R " +
                    "WHERE STCD = ? AND TO_CHAR(TM,'yyyy') >= ? AND TO_CHAR(TM,'yyyy') <= ?) B" ;
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(syear+'-'+eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);

            return this.findEasyUiPageBySql(sql,easyUiPage,params.toArray());
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getYltzzbbList(String syear, String eyear, String stcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(syear) && StringUtil.isNotEmpty(eyear) && StringUtil.isNotEmpty(stcd)) {
            List<Object> params = new ArrayList<Object>();
            //历年数据
            String sql = "SELECT B.YEAR," +
                    "       B.RMAXVAL," +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "          FROM ST_PPTN_R" +
                    "         WHERE STCD = ? AND TO_CHAR(TM,'yyyy') >= ? AND TO_CHAR(TM,'yyyy') <= ? AND DYP = B.RMAXVAL AND ROWNUM = 1) AS RMAXTM," +
                    "       C.YMAXVAL," +
                    "       (SELECT YEAR" +
                    "          FROM (SELECT TO_CHAR(TM, 'yyyy-mm') AS YEAR, SUM(DYP) AS VAL" +
                    "                  FROM ST_PPTN_R WHERE STCD = ? " +
                    "                 GROUP BY TO_CHAR(TM, 'yyyy-mm'))" +
                    "         WHERE SUBSTR(YEAR, 0, 4) >= ? AND SUBSTR(YEAR, 0, 4) <= ? AND VAL = C.YMAXVAL AND ROWNUM = 1) AS YMAXTM," +
                    "       B.SUMVAL" +
                    "  FROM (SELECT TO_CHAR(TM, 'yyyy') AS YEAR," +
                    "               MAX(DYP) AS RMAXVAL," +
                    "               SUM(DYP) AS SUMVAL" +
                    "          FROM ST_PPTN_R WHERE STCD = ? AND TO_CHAR(TM,'yyyy') >= ? AND TO_CHAR(TM,'yyyy') <= ?" +
                    "         GROUP BY TO_CHAR(TM, 'yyyy')) B" +
                    "  LEFT JOIN (SELECT SUBSTR(A.YEAR, 0, 4) AS YEAR, MAX(A.VAL) AS YMAXVAL" +
                    "               FROM (SELECT TO_CHAR(TM, 'yyyy-mm') AS YEAR, SUM(DYP) AS VAL" +
                    "                       FROM ST_PPTN_R WHERE STCD = ? AND TO_CHAR(TM,'yyyy') >= ? AND TO_CHAR(TM,'yyyy') <= ?" +
                    "                      GROUP BY TO_CHAR(TM, 'yyyy-mm')) A" +
                    "              GROUP BY SUBSTR(A.YEAR, 0, 4)) C" +
                    "    ON B.YEAR = C.YEAR ";
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);

            //合计
            sql += "UNION ALL " +
                    "SELECT E.YEAR," +
                    "       E.RMAXVAL," +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "          FROM ST_PPTN_R" +
                    "         WHERE STCD = ? AND TO_CHAR(TM,'yyyy') >= ? AND TO_CHAR(TM,'yyyy') <= ? AND DYP = E.RMAXVAL AND ROWNUM = 1) AS RMAXTM," +
                    "       F.YMAXVAL," +
                    "       (SELECT YEAR" +
                    "          FROM (SELECT TO_CHAR(TM, 'yyyy-mm') AS YEAR, SUM(DYP) AS VAL" +
                    "                  FROM ST_PPTN_R WHERE STCD = ? " +
                    "                 GROUP BY TO_CHAR(TM, 'yyyy-mm'))" +
                    "         WHERE SUBSTR(YEAR, 0, 4) >= ? AND SUBSTR(YEAR, 0, 4) <= ? AND VAL = F.YMAXVAL AND ROWNUM = 1) AS YMAXTM," +
                    "       E.SUMVAL" +
                    "  FROM (SELECT ? AS YEAR, MAX(DYP) AS RMAXVAL, SUM(DYP) AS SUMVAL" +
                    "          FROM ST_PPTN_R" +
                    "         WHERE STCD = ?" +
                    "           AND TO_CHAR(TM, 'yyyy') >= ?" +
                    "           AND TO_CHAR(TM, 'yyyy') <= ?) E" +
                    "  LEFT JOIN" +
                    " (SELECT ? AS YEAR, MAX(D.VAL) AS YMAXVAL" +
                    "    FROM (SELECT TO_CHAR(TM, 'yyyy-mm') AS YEAR, SUM(DYP) AS VAL" +
                    "            FROM ST_PPTN_R" +
                    "           WHERE STCD = ?" +
                    "             AND TO_CHAR(TM, 'yyyy') >= ?" +
                    "             AND TO_CHAR(TM, 'yyyy') <= ?" +
                    "           GROUP BY TO_CHAR(TM, 'yyyy-mm')) D) F" +
                    "    ON E.YEAR = F.YEAR";
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(syear+'-'+eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(syear+'-'+eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);

            return this.findEasyUiPageBySql(sql,easyUiPage,params.toArray());
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getQwtzzbbList(String syear, String eyear, String stcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(syear) && StringUtil.isNotEmpty(eyear) && StringUtil.isNotEmpty(stcd)) {
            List<Object> params = new ArrayList<Object>();
            //历年数据
            String sql = "SELECT A.YEAR,A.MAXVAL," +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd') FROM ST_TMP_R " +
                    "WHERE STCD = ? AND TO_CHAR(TM, 'yyyy') >= ? AND TO_CHAR(TM, 'yyyy') <= ? AND NVL(CATMP, ATMP) = A.MAXVAL AND ROWNUM = 1) AS MAXTM," +
                    "       A.MINVAL," +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd') FROM ST_TMP_R " +
                    "WHERE STCD = ? AND TO_CHAR(TM, 'yyyy') >= ? AND TO_CHAR(TM, 'yyyy') <= ? AND NVL(CATMP, ATMP) = A.MINVAL AND ROWNUM = 1) AS MINTM," +
                    "       A.AVGVAL," +
                    "       A.MAXVAL - A.MINVAL AS BF" +
                    "  FROM (SELECT TO_CHAR(TM, 'yyyy') AS YEAR," +
                    "               MAX(NVL(CATMP, ATMP)) AS MAXVAL," +
                    "               MIN(NVL(CATMP, ATMP)) AS MINVAL," +
                    "               AVG(NVL(CATMP, ATMP)) AS AVGVAL" +
                    "          FROM ST_TMP_R" +
                    "         WHERE STCD = ? GROUP BY TO_CHAR(TM, 'yyyy')" +
                    "        HAVING TO_CHAR(TM, 'yyyy') >= ? AND TO_CHAR(TM, 'yyyy') <= ?) A ";
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);

            //合计
            sql +=  "UNION ALL " +
                    "SELECT B.YEAR,B.MAXVAL," +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd') FROM ST_TMP_R " +
                    "WHERE STCD = ? AND TO_CHAR(TM, 'yyyy') >= ? AND TO_CHAR(TM, 'yyyy') <= ? AND NVL(CATMP, ATMP) = B.MAXVAL AND ROWNUM = 1) AS MAXTM," +
                    "       B.MINVAL," +
                    "       (SELECT TO_CHAR(TM, 'yyyy-mm-dd') FROM ST_TMP_R " +
                    "WHERE STCD = ? AND TO_CHAR(TM, 'yyyy') >= ? AND TO_CHAR(TM, 'yyyy') <= ? AND NVL(CATMP, ATMP) = B.MINVAL AND ROWNUM = 1) AS MINTM," +
                    "       B.AVGVAL," +
                    "       B.MAXVAL - B.MINVAL AS BF" +
                    "  FROM (SELECT ? AS YEAR," +
                    "               MAX(NVL(CATMP, ATMP)) AS MAXVAL," +
                    "               MIN(NVL(CATMP, ATMP)) AS MINVAL," +
                    "               AVG(NVL(CATMP, ATMP)) AS AVGVAL" +
                    "          FROM ST_TMP_R" +
                    "         WHERE STCD = ? AND TO_CHAR(TM, 'yyyy') >= ? AND TO_CHAR(TM, 'yyyy') <= ?) B";
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);
            params.add(syear+'-'+eyear);
            params.add(stcd);
            params.add(syear);
            params.add(eyear);

            return this.findEasyUiPageBySql(sql,easyUiPage,params.toArray());
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbList(String tm, String projcd, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT A.PROJ_CD, A.TM AS XM, ROUND(A.ATMP,1) AS ATMP, ROUND(A.AIRP,1) AS AIRP, ROUND(A.RZ,2) AS RZ, ROUND(A.DYP,1) AS DYP" +
                "  FROM (SELECT NVL(NVL(T.PROJ_CD, R.PROJ_CD), P.PROJ_CD) AS PROJ_CD," +
                "               NVL(NVL(TO_CHAR(T.TM, 'yyyy-mm-dd')," +
                "                       TO_CHAR(R.TM, 'yyyy-mm-dd'))," +
                "                   TO_CHAR(P.TM, 'yyyy-mm-dd')) AS TM," +
                "               NVL(T.CATMP, T.ATMP) AS ATMP," +
                "               NVL(T.CAIRP, T.AIRP) AS AIRP," +
                "               R.RZ," +
                "               P.DYP" +
                "          FROM (SELECT *" +
                "                  FROM ST_TMP_R T1" +
                "                  LEFT JOIN WR_ST_PROJ_TYPE_MAP S1" +
                "                    ON T1.STCD = S1.STCD" +
                "                   AND S1.ST_TP = '7' WHERE 1=1 ";

        if(StringUtil.isNotEmpty(projcd)) {
            sql += " AND S1.PROJ_CD = ? ";
            params.add(projcd);
        }

        if(StringUtil.isNotEmpty(tm)) {
            sql += " AND TO_CHAR(T1.TM, 'yyyy-mm') = ? ";
            params.add(tm);
        }

        sql += ") T" +
                "          FULL JOIN (SELECT *" +
                "                      FROM ST_RSVR_R R1" +
                "                      LEFT JOIN WR_ST_PROJ_TYPE_MAP S2" +
                "                        ON R1.STCD = S2.STCD" +
                "                       AND S2.ST_TP = '5' WHERE 1=1 ";

        if(StringUtil.isNotEmpty(projcd)) {
            sql += " AND S2.PROJ_CD = ? ";
            params.add(projcd);
        }

        if(StringUtil.isNotEmpty(tm)) {
            sql += " AND TO_CHAR(R1.TM, 'yyyy-mm') = ? ";
            params.add(tm);
        }

        sql += ") R" +
                "            ON T.PROJ_CD = R.PROJ_CD" +
                "           AND TO_CHAR(T.TM, 'yyyy-mm-dd') = TO_CHAR(R.TM, 'yyyy-mm-dd')" +
                "          FULL JOIN (SELECT *" +
                "                      FROM ST_PPTN_R P1" +
                "                      LEFT JOIN WR_ST_PROJ_TYPE_MAP S3" +
                "                        ON P1.STCD = S3.STCD" +
                "                       AND S3.ST_TP = '6' WHERE 1=1 ";

        if(StringUtil.isNotEmpty(projcd)) {
            sql += " AND S3.PROJ_CD = ? ";
            params.add(projcd);
        }

        if(StringUtil.isNotEmpty(tm)) {
            sql += " AND TO_CHAR(P1.TM, 'yyyy-mm') = ? ";
            params.add(tm);
        }

        sql += ") P" +
                "            ON (T.PROJ_CD = P.PROJ_CD AND" +
                "               TO_CHAR(T.TM, 'yyyy-mm-dd') = TO_CHAR(P.TM, 'yyyy-mm-dd'))" +
                "            OR (R.PROJ_CD = P.PROJ_CD AND" +
                "               TO_CHAR(R.TM, 'yyyy-mm-dd') = TO_CHAR(P.TM, 'yyyy-mm-dd'))) A ";

        sql += " ORDER BY XM DESC";

        return this.findEasyUiPageBySql(sql,easyUiPage,params.toArray());
    }

    @Override
    public EasyUiPage getGcjlbTJList(String tm, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(tm) && StringUtil.isNotEmpty(projcd)) {
            List<Object> params = new ArrayList<Object>();

            String sql = "SELECT X.X,X.XM,RZ.RZ,DYP.DYP,AIRP.AIRP,ATMP.ATMP FROM " +
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
            sql += " LEFT JOIN " +
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
            params.add(projcd);
            params.add(projcd);

            //降雨
            sql += " LEFT JOIN " +
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
            params.add(projcd);
            params.add(projcd);

            //气压
            sql += " LEFT JOIN " +
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
                    "                          FROM ST_TMP_R" +
                    "                         WHERE NVL(CAIRP, AIRP) = A.MAXVAL" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND STCD = A.STCD" +
                    "                           AND ROWNUM = '1') AS MAXVALTM," +
                    "                       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                          FROM ST_TMP_R" +
                    "                         WHERE NVL(CAIRP, AIRP) = A.MINVAL" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND STCD = A.STCD" +
                    "                           AND ROWNUM = '1') AS MINVALTM" +
                    "                  FROM (SELECT T.STCD," +
                    "                               TO_CHAR(T.TM, 'yyyy-mm') AS TM," +
                    "                               MAX(NVL(CAIRP, AIRP)) AS MAXVAL," +
                    "                               MIN(NVL(CAIRP, AIRP)) AS MINVAL" +
                    "                          FROM ST_TMP_R T" +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                            ON T.STCD = S.STCD" +
                    "                           AND S.ST_TP = '7'" +
                    "                         WHERE TO_CHAR(T.TM, 'yyyy-mm') = ?" +
                    "                           AND S.PROJ_CD = ?" +
                    "                         GROUP BY TO_CHAR(T.TM, 'yyyy-mm'), T.STCD) A) B" +
                    "          FULL JOIN (SELECT STCD," +
                    "                           TO_CHAR(A.LSMAXVAL) AS LSMAXVAL," +
                    "                           TO_CHAR(A.LSMINVAL) AS LSMINVAL," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM ST_TMP_R" +
                    "                             WHERE NVL(CAIRP, AIRP) = A.LSMAXVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMAXVALTM," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM ST_TMP_R" +
                    "                             WHERE NVL(CAIRP, AIRP) = A.LSMINVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMINVALTM" +
                    "                      FROM (SELECT T.STCD," +
                    "                                   MAX(NVL(CAIRP, AIRP)) AS LSMAXVAL," +
                    "                                   MIN(NVL(CAIRP, AIRP)) AS LSMINVAL" +
                    "                              FROM ST_TMP_R T" +
                    "                              LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                                ON T.STCD = S.STCD" +
                    "                               AND S.ST_TP = '7'" +
                    "                             WHERE S.PROJ_CD = ?" +
                    "                             GROUP BY T.STCD) A) C" +
                    "            ON B.STCD = C.STCD) UNPIVOT(AIRP FOR XM IN(MAXVAL AS '最大值'," +
                    "                                                       MAXVALTM AS '最大值日期'," +
                    "                                                       MINVAL AS '最小值'," +
                    "                                                       MINVALTM AS '最小值日期'," +
                    "                                                       BF AS '变幅'," +
                    "                                                       LSMAXVAL AS '历史最大值'," +
                    "                                                       LSMAXVALTM AS" +
                    "                                                       '历史最大值日期'," +
                    "                                                       LSMINVAL AS '历史最小值'," +
                    "                                                       LSMINVALTM AS" +
                    "                                                       '历史最小值日期'))) AIRP" +
                    "                                                       ON X.XM = AIRP.XM";

            params.add(tm);
            params.add(projcd);
            params.add(projcd);

            //气温
            sql += " LEFT JOIN " +
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
                    "                          FROM ST_TMP_R" +
                    "                         WHERE NVL(CATMP, ATMP) = A.MAXVAL" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND STCD = A.STCD" +
                    "                           AND ROWNUM = '1') AS MAXVALTM," +
                    "                       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                          FROM ST_TMP_R" +
                    "                         WHERE NVL(CATMP, ATMP) = A.MINVAL" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND STCD = A.STCD" +
                    "                           AND ROWNUM = '1') AS MINVALTM" +
                    "                  FROM (SELECT T.STCD," +
                    "                               TO_CHAR(T.TM, 'yyyy-mm') AS TM," +
                    "                               MAX(NVL(CATMP, ATMP)) AS MAXVAL," +
                    "                               MIN(NVL(CATMP, ATMP)) AS MINVAL" +
                    "                          FROM ST_TMP_R T" +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                            ON T.STCD = S.STCD" +
                    "                           AND S.ST_TP = '7'" +
                    "                         WHERE TO_CHAR(T.TM, 'yyyy-mm') = ?" +
                    "                           AND S.PROJ_CD = ?" +
                    "                         GROUP BY TO_CHAR(T.TM, 'yyyy-mm'), T.STCD) A) B" +
                    "          FULL JOIN (SELECT STCD," +
                    "                           TO_CHAR(A.LSMAXVAL) AS LSMAXVAL," +
                    "                           TO_CHAR(A.LSMINVAL) AS LSMINVAL," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM ST_TMP_R" +
                    "                             WHERE NVL(CATMP, ATMP) = A.LSMAXVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMAXVALTM," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM ST_TMP_R" +
                    "                             WHERE NVL(CATMP, ATMP) = A.LSMINVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMINVALTM" +
                    "                      FROM (SELECT T.STCD," +
                    "                                   MAX(NVL(CATMP, ATMP)) AS LSMAXVAL," +
                    "                                   MIN(NVL(CATMP, ATMP)) AS LSMINVAL" +
                    "                              FROM ST_TMP_R T" +
                    "                              LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                                ON T.STCD = S.STCD" +
                    "                               AND S.ST_TP = '7'" +
                    "                             WHERE S.PROJ_CD = ?" +
                    "                             GROUP BY T.STCD) A) C" +
                    "            ON B.STCD = C.STCD) UNPIVOT(ATMP FOR XM IN(MAXVAL AS '最大值',MAXVALTM AS '最大值日期',MINVAL AS '最小值',MINVALTM AS '最小值日期',BF AS '变幅',LSMAXVAL AS '历史最大值',LSMAXVALTM AS '历史最大值日期',LSMINVAL AS '历史最小值',LSMINVALTM AS '历史最小值日期'))" +
                    "            ) ATMP" +
                    "            ON X.XM = ATMP.XM" +
                    "  ORDER BY X.X";

            params.add(tm);
            params.add(projcd);
            params.add(projcd);

            return findEasyUiPageBySql(sql,easyUiPage,params.toArray());
        }
        return easyUiPage;
    }

}

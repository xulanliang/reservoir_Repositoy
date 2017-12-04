package com.dse.reservoir.sjfx.shenya.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.pojo.entity.WrrbmEntity;
import com.dse.reservoir.sjfx.shenya.dao.ShenyaDao;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 渗压Dao层
 */
@Repository("shenyaDao")
public class ShenyaDaoImpl extends BaseDao implements ShenyaDao {

    @Override
    public Object getProject(String projcd) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT * FROM WR_PROJ_B WHERE 1=1 ";

        if(StringUtil.isNotEmpty(projcd)){
            sql += " AND PID = ?";
            params.add(projcd);
        }

        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object getDmID(String projcd, String st_tp) throws Exception {
        StringBuffer str = new StringBuffer();
        List params = new ArrayList();
        str.append("SELECT M.RB_CD FROM WR_RB_M M WHERE M.RB_TYPE ='0' ");
        if(StringUtil.isNotEmpty(projcd)){
            str.append(" AND M.PROJ_CD_TWO= ?");
            params.add(projcd);
        }
        if(StringUtil.isNotEmpty(st_tp)){
            str.append(" AND M.ST_TP_LIST LIKE ? ");
            params.add("%"+st_tp+"%");
        }
        return this.findBySqlWithMap(str.toString(),params.toArray());
    }

    @Override
    public Object getRb(WrrbmEntity args) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT * FROM WR_RB_M WHERE 1=1 ";

        if(StringUtil.isNotEmpty(args.getProj_cd_two())){
            sql += " AND PROJ_CD_TWO = ? ";
            params.add(args.getProj_cd_two());
        }
        if(StringUtil.isNotEmpty(args.getRb_cd())){
            sql += " AND rb_cd=? ";
            params.add(args.getRb_cd());
        }
        if(StringUtil.isNotEmpty(args.getProj_cd_one())){
            sql += " AND proj_cd_one=? ";
            params.add(args.getProj_cd_one());
        }
        if(StringUtil.isNotEmpty(args.getProj_cd_two())){
            sql += " AND proj_cd_two = ? ";
            params.add(args.getProj_cd_two());
        }
        if(StringUtil.isNotEmpty(args.getItem_cd())){
            sql += " AND item_cd = ? ";
            params.add(args.getItem_cd());
        }
        if(StringUtil.isNotEmpty(args.getRb_type())){
            sql += " AND RB_TYPE = ? ";
            params.add(args.getRb_type());
        }
        if(StringUtil.isNotEmpty(args.getSt_tp_list())){
            sql += " AND ST_TP_LIST like ? ";
            params.add("%"+args.getSt_tp_list()+"%");
        }
        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object getPoint(String projcd,String type) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT S.STNM,YY.* " +
                " FROM WR_STAT_M S " +
                " LEFT JOIN ( " +
                "   SELECT M.*, TT.NAME FROM WR_ST_PROJ_TYPE_MAP M " +
                "       INNER JOIN (" +
                "           SELECT Y.CODE," +
                "               Y.NAME " +
                "           FROM T_SYS_DICTIONARY Y " +
                "           WHERE Y.PID = (" +
                "               SELECT T.ID " +
                "               FROM T_SYS_DICTIONARY T " +
                "               WHERE T.ID = '8a10d4815d7cd89b015d8d629d2d0077'" +
                "               )" +
                "           ) TT " +
                "   ON M.ST_TP = TT.CODE" +
                "   ) YY " +
                    " ON S.STCD = YY.STCD " ;
                if(StringUtil.isNotEmpty(projcd)){
                    sql += " AND YY.PROJ_CD LIKE ?";
                    params.add(projcd+"%");
                }
        if(type.equals("垂直位移") || type.equals("水平位移") || type.equals("3") || type.equals("4")){
            sql += " WHERE ISJIDIAN = 0 AND S.TYPEID ='1' ";
        }else{
            sql += " WHERE ISJIDIAN = 0 AND S.TYPEID ='0' ";
        }


        if(StringUtil.isNotEmpty(type)){
            if(projcd.equals("3")){
                sql+=" AND (YY.NAME = '5' OR YY.ST_TP = '5' OR YY.ST_TP = '1' OR YY.ST_TP = '2' OR YY.ST_TP = '5' OR YY.ST_TP = '7' OR YY.ST_TP = '8' OR YY.ST_TP = '9' )";
            }else {
                sql += " AND (YY.NAME = ? OR YY.ST_TP=? )";
                params.add(type);
                params.add(type);
            }
        }
//        if(StringUtil.isNotEmpty(projcd) && StringUtils.isEmpty(type)){
//            sql = "SELECT DISTINCT KK.STCD,KK.STNM FROM( SELECT  S.STNM, S.STCD" +
//                    "  FROM WR_STAT_M S" +
//                    "  LEFT JOIN (SELECT M.*, TT.NAME" +
//                    "  FROM WR_ST_PROJ_TYPE_MAP M" +
//                    "  LEFT JOIN (SELECT Y.CODE, Y.NAME" +
//                    "  FROM T_SYS_DICTIONARY Y" +
//                    "  WHERE Y.PID =" +
//                    "  (SELECT T.ID" +
//                    "  FROM T_SYS_DICTIONARY T" +
//                    "  WHERE T.ID =" +
//                    "  '8a10d4815d7cd89b015d8d629d2d0077')) TT" +
//                    "  ON M.ST_TP = TT.CODE) YY" +
//                    "  ON S.STCD = YY.STCD" +
//                    "  WHERE ISJIDIAN = 0" +
//                    "  AND YY.PROJ_CD LIKE ? )KK;";
//            params.clear();
//            params.add(projcd+"%");
//        }
        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object getPointByRb(String rbcd) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT S.STCD,S.STNM FROM WR_ST_RB_MAP M LEFT JOIN WR_STAT_M S ON M.STCD = S.STCD WHERE ISJIDIAN = 0 ";

        if(StringUtil.isNotEmpty(rbcd)){
            sql += " AND M.RB_CD = ?";
            params.add(rbcd);
        }

        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object getColByIds(List list) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT DISTINCT S.STCD,S.STNM FROM WR_ST_RB_MAP M LEFT JOIN WR_STAT_M S ON M.STCD = S.STCD WHERE ISJIDIAN = 0 ";

        if(list.size()>0){
            sql += " AND M.RB_CD IN ( ";
            for(int i=0;i<list.size();i++){
                Map map = (Map) list.get(i);
                if( i==0){
                    sql+= map.get("RB_CD");
                }else{
                    sql+=", "+map.get("RB_CD");
                }
            }
            sql+=" ) ORDER BY S.STNM ASC";
        }
        return findBySqlWithMap(sql);
    }

    @Override
    public EasyUiPage getDateList(String stm, String etm,  GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT BB.NAME,BB.ST_TP,A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,round(NVL(A.CALCDATA,A.ORIGDATA),2) AS DATA FROM WR_HYDO_B A LEFT JOIN (SELECT * FROM WR_ST_PROJ_TYPE_MAP M LEFT JOIN (SELECT Y.CODE,Y.NAME FROM T_SYS_DICTIONARY Y WHERE Y.PID=(SELECT ID FROM T_SYS_DICTIONARY YY WHERE YY.CODE='0')) TT ON M.ST_TP=TT.CODE) BB " +
                "ON A.STCD = BB.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE BB.ST_TP = '1' AND S.ISJIDIAN = '0' ";

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
     *
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs 参数值
     * @return
     */
    public Object getGcxDateList(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        List<Object> params = new ArrayList<Object>();// hh24:mi:ss
        String sql = "SELECT A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd') AS TM,round(NVL(A.CALCDATA,A.ORIGDATA),2) AS DATA FROM WR_HYDO_B A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '1' AND S.ISJIDIAN = '0' ";

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
    public EasyUiPage getjnbbList(String stime, String etime, String rbcd,List list, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(stime) && StringUtil.isNotEmpty(etime) && list.size()>0) {
            List<Object> params = new ArrayList<Object>();
            String sql = "SELECT 'm' AS UNIT," +
                    "       AA.MAXDATA," +
                    "       AA.MINDATA," +
                    "       AA.MAXTM," +
                    "       AA.MINTM," +
                    "       AA.LASTDATA," +
                    "       BB.*," +
                    "       P.STNM," +
                    "       S.RB_CD" +
                    "  FROM (SELECT A.*," +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                  FROM WR_HYDO_B" +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA" +
                    "                   AND STCD = A.STCD" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                   AND ROWNUM = 1) AS MAXTM," +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                  FROM WR_HYDO_B" +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA" +
                    "                   AND STCD = A.STCD" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                   AND ROWNUM = 1) AS MINTM," +
                    "               (SELECT DATA" +
                    "                  FROM (SELECT NVL(CALCDATA, ORIGDATA) AS DATA" +
                    "                          FROM WR_HYDO_B H" +
                    "                          LEFT JOIN WR_ST_RB_MAP S" +
                    "                            ON H.STCD = S.STCD" +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP M" +
                    "                            ON H.STCD = M.STCD" +
                    "                         WHERE M.ST_TP = '1' AND S.RB_CD = ?" +
                    "                           AND TO_CHAR(TM,'yyyy-mm-dd') = ?" +
                    "                         ORDER BY TM DESC)" +
                    "                 WHERE ROWNUM = 1) AS LASTDATA" +
                    "          FROM (SELECT STCD," +
                    "                       MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA," +
                    "                       MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA" +
                    "                  FROM WR_HYDO_B" +
                    "                 WHERE TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                 GROUP BY STCD) A) AA" +
                    "  FULL JOIN (SELECT B.*," +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                       FROM WR_HYDO_B" +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMAXDATA" +
                    "                        AND STCD = B.STCD" +
                    "                        AND ROWNUM = 1) AS LSMAXTM," +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                       FROM WR_HYDO_B" +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMINDATA" +
                    "                        AND STCD = B.STCD" +
                    "                        AND ROWNUM = 1) AS LSMINTM" +
                    "               FROM (SELECT STCD," +
                    "                            MAX(NVL(CALCDATA, ORIGDATA)) AS LSMAXDATA," +
                    "                            MIN(NVL(CALCDATA, ORIGDATA)) AS LSMINDATA" +
                    "                       FROM WR_HYDO_B" +
                    "                      GROUP BY STCD) B) BB" +
                    "    ON AA.STCD = BB.STCD" +
                    "  LEFT JOIN WR_ST_RB_MAP S" +
                    "    ON BB.STCD = S.STCD" +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP M" +
                    "    ON BB.STCD = M.STCD" +
                    "  LEFT JOIN WR_STAT_M P" +
                    "    ON BB.STCD = P.STCD" +
                    " WHERE M.ST_TP = '1' AND S.RB_CD IN ( ";
            String str="";
            if(list.size()>0){
                for(int i=0;i<list.size();i++){
                    Map map = (Map) list.get(i);
                    if(i==0){
                        str+=map.get("RB_CD");
                    }else {
                        str+=","+map.get("RB_CD");
                    }
                }
            }
            sql+=str + " )";
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(rbcd);
            params.add(etime);
            params.add(stime);
            params.add(etime);

            return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getjnbbListDg(String stime, String etime, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(stime) && StringUtil.isNotEmpty(etime) && StringUtil.isNotEmpty(projcd)) {
            List<Object> params = new ArrayList<Object>();
            String sql = "SELECT 'm' AS UNIT," +
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
                    "                  FROM WR_HYDO_B" +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA" +
                    "                   AND STCD = A.STCD" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                   AND ROWNUM = 1) AS MAXTM," +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                  FROM WR_HYDO_B" +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA" +
                    "                   AND STCD = A.STCD" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                   AND ROWNUM = 1) AS MINTM," +
                    "               (SELECT DATA" +
                    "                  FROM (SELECT NVL(CALCDATA, ORIGDATA) AS DATA" +
                    "                          FROM WR_HYDO_B H" +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                            ON H.STCD = S.STCD" +
                    "                         WHERE S.ST_TP = '1' AND S.PROJ_CD = ?" +
                    "                           AND TO_CHAR(TM,'yyyy-mm-dd') = ?" +
                    "                         ORDER BY TM DESC)" +
                    "                 WHERE ROWNUM = 1) AS LASTDATA" +
                    "          FROM (SELECT STCD," +
                    "                       MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA," +
                    "                       MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA" +
                    "                  FROM WR_HYDO_B" +
                    "                 WHERE TO_CHAR(TM, 'yyyy-mm-dd') >= ?" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm-dd') <= ?" +
                    "                 GROUP BY STCD) A) AA" +
                    "  FULL JOIN (SELECT B.*," +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                       FROM WR_HYDO_B" +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMAXDATA" +
                    "                        AND STCD = B.STCD" +
                    "                        AND ROWNUM = 1) AS LSMAXTM," +
                    "                    (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                       FROM WR_HYDO_B" +
                    "                      WHERE NVL(CALCDATA, ORIGDATA) = B.LSMINDATA" +
                    "                        AND STCD = B.STCD" +
                    "                        AND ROWNUM = 1) AS LSMINTM" +
                    "               FROM (SELECT STCD," +
                    "                            MAX(NVL(CALCDATA, ORIGDATA)) AS LSMAXDATA," +
                    "                            MIN(NVL(CALCDATA, ORIGDATA)) AS LSMINDATA" +
                    "                       FROM WR_HYDO_B" +
                    "                      GROUP BY STCD) B) BB" +
                    "    ON AA.STCD = BB.STCD" +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "    ON BB.STCD = S.STCD" +
                    "  LEFT JOIN WR_STAT_M P" +
                    "    ON BB.STCD = P.STCD" +
                    " WHERE S.ST_TP = '1' AND S.PROJ_CD = ? ";
            params.add(stime);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(projcd);
            params.add(etime);
            params.add(stime);
            params.add(etime);
            params.add(projcd);

            return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getSytzzbbList(String time, String ppcd, String rbcd,List list, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(time)) {
            List<Object> params = new ArrayList<Object>();
            String sql = "SELECT AA.*," +
                    "       AA.MAXDATA - AA.MINDATA AS BF," +
                    "       T.STNM," +
                    "       S.RB_CD," +
                    "       P.RB_NM," +
                    "       (SELECT NVL(CATMP, ATMP)" +
                    "          FROM ST_TMP_R B1" +
                    "          LEFT JOIN WR_ST_PROJ_TYPE_MAP B2" +
                    "            ON B1.STCD = B2.STCD" +
                    "           AND B2.ST_TP = '7'" +
                    "         WHERE B2.PROJ_CD = ?" +
                    "           AND TO_CHAR(B1.TM, 'yyyy-mm-dd') = AA.MAXTM" +
                    "           AND ROWNUM = 1) AS MAXATMP," +
                    "       (SELECT DYP" +
                    "          FROM ST_PPTN_R C1" +
                    "          LEFT JOIN WR_ST_PROJ_TYPE_MAP C2" +
                    "            ON C1.STCD = C2.STCD" +
                    "           AND C2.ST_TP = '6'" +
                    "         WHERE C2.PROJ_CD = ?" +
                    "           AND TO_CHAR(C1.TM, 'yyyy-mm-dd') = AA.MAXTM" +
                    "           AND ROWNUM = 1) AS MAXDYP," +
                    "       (SELECT RZ" +
                    "          FROM ST_RSVR_R D1" +
                    "          LEFT JOIN WR_ST_PROJ_TYPE_MAP D2" +
                    "            ON D1.STCD = D2.STCD" +
                    "           AND D2.ST_TP = '5'" +
                    "         WHERE D2.PROJ_CD = ?" +
                    "           AND TO_CHAR(D1.TM, 'yyyy-mm-dd') = AA.MAXTM" +
                    "           AND ROWNUM = 1) AS MAXRZ," +
                    "       (SELECT NVL(CATMP, ATMP)" +
                    "          FROM ST_TMP_R B3" +
                    "          LEFT JOIN WR_ST_PROJ_TYPE_MAP B4" +
                    "            ON B3.STCD = B4.STCD" +
                    "           AND B4.ST_TP = '7'" +
                    "         WHERE B4.PROJ_CD = ?" +
                    "           AND TO_CHAR(B3.TM, 'yyyy-mm-dd') = AA.MINTM" +
                    "           AND ROWNUM = 1) AS MINATMP," +
                    "       (SELECT DYP" +
                    "          FROM ST_PPTN_R C3" +
                    "          LEFT JOIN WR_ST_PROJ_TYPE_MAP C4" +
                    "            ON C3.STCD = C4.STCD" +
                    "           AND C4.ST_TP = '6'" +
                    "         WHERE C4.PROJ_CD = ?" +
                    "           AND TO_CHAR(C3.TM, 'yyyy-mm-dd') = AA.MINTM" +
                    "           AND ROWNUM = 1) AS MINDYP," +
                    "       (SELECT RZ" +
                    "          FROM ST_RSVR_R D3" +
                    "          LEFT JOIN WR_ST_PROJ_TYPE_MAP D4" +
                    "            ON D3.STCD = D4.STCD" +
                    "           AND D4.ST_TP = '5'" +
                    "         WHERE D4.PROJ_CD = ?" +
                    "           AND TO_CHAR(D3.TM, 'yyyy-mm-dd') = AA.MINTM" +
                    "           AND ROWNUM = 1) AS MINRZ" +
                    "  FROM (SELECT A.*," +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                  FROM WR_HYDO_B" +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA" +
                    "                   AND STCD = A.STCD" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                   AND ROWNUM = 1) AS MAXTM," +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                  FROM WR_HYDO_B" +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA" +
                    "                   AND STCD = A.STCD" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                   AND ROWNUM = 1) AS MINTM" +
                    "          FROM (SELECT STCD," +
                    "                       TO_CHAR(TM, 'yyyy-mm') AS TM," +
                    "                       MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA," +
                    "                       MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA," +
                    "                       AVG(NVL(CALCDATA, ORIGDATA)) AS AVGDATA" +
                    "                  FROM WR_HYDO_B" +
                    "                 GROUP BY TO_CHAR(TM, 'yyyy-mm'), STCD" +
                    "                HAVING TO_CHAR(TM, 'yyyy-mm') = ?) A) AA" +
                    "  LEFT JOIN WR_ST_RB_MAP S" +
                    "    ON AA.STCD = S.STCD" +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP M" +
                    "    ON AA.STCD = M.STCD" +
                    "  LEFT JOIN WR_STAT_M T" +
                    "    ON AA.STCD = T.STCD" +
                    "  LEFT JOIN WR_RB_M P" +
                    "    ON S.RB_CD = P.RB_CD" +
                    " WHERE M.ST_TP = '1' ";

            params.add(ppcd);
            params.add(ppcd);
            params.add(ppcd);
            params.add(ppcd);
            params.add(ppcd);
            params.add(ppcd);
            params.add(time);

            if(list.size()>0){
                sql += " AND S.RB_CD IN( ";
                for(int i=0;i<list.size();i++){
                    Map map = (Map) list.get(i);
                    if(i==0){
                        sql+=map.get("RB_CD");
                    }else{
                        sql+=","+map.get("RB_CD");
                    }
                }
                sql+=" )";
            }

            return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getSytzzbbListDg(String time, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(time)) {
            List<Object> params = new ArrayList<Object>();
            String sql = "SELECT AA.*," +
                    "       AA.MAXDATA - AA.MINDATA AS BF," +
                    "       T.STNM," +
                    "       S.PROJ_CD," +
                    "       P.PROJ_NM," +
                    "       (SELECT NVL(CATMP, ATMP)" +
                    "          FROM ST_TMP_R B1" +
                    "          LEFT JOIN WR_ST_PROJ_TYPE_MAP B2" +
                    "            ON B1.STCD = B2.STCD" +
                    "           AND B2.ST_TP = '7'" +
                    "         WHERE B2.PROJ_CD = ?" +
                    "           AND TO_CHAR(B1.TM, 'yyyy-mm-dd') = AA.MAXTM" +
                    "           AND ROWNUM = 1) AS MAXATMP," +
                    "       (SELECT DYP" +
                    "          FROM ST_PPTN_R C1" +
                    "          LEFT JOIN WR_ST_PROJ_TYPE_MAP C2" +
                    "            ON C1.STCD = C2.STCD" +
                    "           AND C2.ST_TP = '6'" +
                    "         WHERE C2.PROJ_CD = ?" +
                    "           AND TO_CHAR(C1.TM, 'yyyy-mm-dd') = AA.MAXTM" +
                    "           AND ROWNUM = 1) AS MAXDYP," +
                    "       (SELECT RZ" +
                    "          FROM ST_RSVR_R D1" +
                    "          LEFT JOIN WR_ST_PROJ_TYPE_MAP D2" +
                    "            ON D1.STCD = D2.STCD" +
                    "           AND D2.ST_TP = '5'" +
                    "         WHERE D2.PROJ_CD = ?" +
                    "           AND TO_CHAR(D1.TM, 'yyyy-mm-dd') = AA.MAXTM" +
                    "           AND ROWNUM = 1) AS MAXRZ," +
                    "       (SELECT NVL(CATMP, ATMP)" +
                    "          FROM ST_TMP_R B3" +
                    "          LEFT JOIN WR_ST_PROJ_TYPE_MAP B4" +
                    "            ON B3.STCD = B4.STCD" +
                    "           AND B4.ST_TP = '7'" +
                    "         WHERE B4.PROJ_CD = ?" +
                    "           AND TO_CHAR(B3.TM, 'yyyy-mm-dd') = AA.MINTM" +
                    "           AND ROWNUM = 1) AS MINATMP," +
                    "       (SELECT DYP" +
                    "          FROM ST_PPTN_R C3" +
                    "          LEFT JOIN WR_ST_PROJ_TYPE_MAP C4" +
                    "            ON C3.STCD = C4.STCD" +
                    "           AND C4.ST_TP = '6'" +
                    "         WHERE C4.PROJ_CD = ?" +
                    "           AND TO_CHAR(C3.TM, 'yyyy-mm-dd') = AA.MINTM" +
                    "           AND ROWNUM = 1) AS MINDYP," +
                    "       (SELECT RZ" +
                    "          FROM ST_RSVR_R D3" +
                    "          LEFT JOIN WR_ST_PROJ_TYPE_MAP D4" +
                    "            ON D3.STCD = D4.STCD" +
                    "           AND D4.ST_TP = '5'" +
                    "         WHERE D4.PROJ_CD = ?" +
                    "           AND TO_CHAR(D3.TM, 'yyyy-mm-dd') = AA.MINTM" +
                    "           AND ROWNUM = 1) AS MINRZ" +
                    "  FROM (SELECT A.*," +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                  FROM WR_HYDO_B" +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MAXDATA" +
                    "                   AND STCD = A.STCD" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                   AND ROWNUM = 1) AS MAXTM," +
                    "               (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                  FROM WR_HYDO_B" +
                    "                 WHERE NVL(CALCDATA, ORIGDATA) = A.MINDATA" +
                    "                   AND STCD = A.STCD" +
                    "                   AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                   AND ROWNUM = 1) AS MINTM" +
                    "          FROM (SELECT STCD," +
                    "                       TO_CHAR(TM, 'yyyy-mm') AS TM," +
                    "                       MAX(NVL(CALCDATA, ORIGDATA)) AS MAXDATA," +
                    "                       MIN(NVL(CALCDATA, ORIGDATA)) AS MINDATA," +
                    "                       AVG(NVL(CALCDATA, ORIGDATA)) AS AVGDATA" +
                    "                  FROM WR_HYDO_B" +
                    "                 GROUP BY TO_CHAR(TM, 'yyyy-mm'), STCD" +
                    "                HAVING TO_CHAR(TM, 'yyyy-mm') = ?) A) AA" +
                    "  LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "    ON AA.STCD = S.STCD" +
                    "  LEFT JOIN WR_STAT_M T" +
                    "    ON AA.STCD = T.STCD" +
                    "  LEFT JOIN WR_PROJ_B P" +
                    "    ON S.PROJ_CD = P.PROJ_CD" +
                    " WHERE S.ST_TP = '1' ";

            params.add(ppcd);
            params.add(ppcd);
            params.add(ppcd);
            params.add(ppcd);
            params.add(ppcd);
            params.add(ppcd);
            params.add(time);

            if(StringUtil.isNotEmpty(projcd)){
                sql += " AND S.PROJ_CD = ? ";
                params.add(projcd);
            }

            return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbList(String tm, String ppcd, String rbcd,List dataList, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(ppcd) && dataList.size()>0) {
            String sql = "SELECT DISTINCT R.STCD FROM WR_ST_RB_MAP R LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON R.STCD = M.STCD WHERE M.ST_TP = '1' AND R.RB_CD IN(  ";
            List listID = new ArrayList();
            for(int i=0;i<dataList.size();i++){
                Map map = (Map) dataList.get(i);
                listID.add(map.get("RB_CD"));
                if(i==0 || i==(dataList.size()-1)){
                    sql+=map.get("RB_CD");
                }else {
                    sql+=","+map.get("RB_CD");
                }
            }
            sql+=" )";
            List<Map> list = findBySqlWithMap(sql);
            String lname = "";
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    lname += "'"+list.get(i).get("STCD")+"'" + " AS " + list.get(i).get("STCD");
                } else {
                    lname += "," + "'"+list.get(i).get("STCD")+"'"  + " AS " + list.get(i).get("STCD");
                }
            }

            List<Object> params = new ArrayList<Object>();
            String sql2 = "SELECT NVL(AA.TM, BB.TM) AS XM, AA.ATMP, AA.AIRP, AA.RZ, AA.DYP, BB.*" +
                    "  FROM (SELECT A.PROJ_CD, A.TM, A.ATMP, A.AIRP, A.RZ, A.DYP" +
                    "          FROM (SELECT NVL(NVL(T.PROJ_CD, R.PROJ_CD), P.PROJ_CD) AS PROJ_CD," +
                    "                       NVL(NVL(TO_CHAR(T.TM, 'yyyy-mm-dd')," +
                    "                               TO_CHAR(R.TM, 'yyyy-mm-dd'))," +
                    "                           TO_CHAR(P.TM, 'yyyy-mm-dd')) AS TM," +
                    "                       NVL(T.CATMP, T.ATMP) AS ATMP," +
                    "                       NVL(T.CAIRP, T.AIRP) AS AIRP," +
                    "                       R.RZ," +
                    "                       P.DYP" +
                    "                  FROM (SELECT *" +
                    "                          FROM ST_TMP_R T1" +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S1" +
                    "                            ON T1.STCD = S1.STCD" +
                    "                           AND S1.ST_TP = '7' WHERE 1=1 ";

            if(StringUtil.isNotEmpty(ppcd)) {
                sql2 += " AND S1.PROJ_CD = ? ";
                params.add(ppcd);
            }

            if(StringUtil.isNotEmpty(tm)) {
                sql2 += " AND TO_CHAR(T1.TM, 'yyyy-mm') = ? ";
                params.add(tm);
            }

            sql2 += ") T" +
                    "                  FULL JOIN (SELECT *" +
                    "                              FROM ST_RSVR_R R1" +
                    "                              LEFT JOIN WR_ST_PROJ_TYPE_MAP S2" +
                    "                                ON R1.STCD = S2.STCD" +
                    "                               AND S2.ST_TP = '5' WHERE 1=1 ";

            if(StringUtil.isNotEmpty(ppcd)) {
                sql2 += " AND S2.PROJ_CD = ? ";
                params.add(ppcd);
            }

            if(StringUtil.isNotEmpty(tm)) {
                sql2 += " AND TO_CHAR(R1.TM, 'yyyy-mm') = ? ";
                params.add(tm);
            }

            sql2 += ") R" +
                    "                    ON T.PROJ_CD = R.PROJ_CD" +
                    "                   AND TO_CHAR(T.TM, 'yyyy-mm-dd') =" +
                    "                       TO_CHAR(R.TM, 'yyyy-mm-dd')" +
                    "                  FULL JOIN (SELECT *" +
                    "                              FROM ST_PPTN_R P1" +
                    "                              LEFT JOIN WR_ST_PROJ_TYPE_MAP S3" +
                    "                                ON P1.STCD = S3.STCD" +
                    "                               AND S3.ST_TP = '6' WHERE 1=1 ";

            if(StringUtil.isNotEmpty(ppcd)) {
                sql2 += " AND S3.PROJ_CD = ? ";
                params.add(ppcd);
            }

            if(StringUtil.isNotEmpty(tm)) {
                sql2 += " AND TO_CHAR(P1.TM, 'yyyy-mm') = ? ";
                params.add(tm);
            }

            sql2 += ") P" +
                    "                    ON (T.PROJ_CD = P.PROJ_CD AND TO_CHAR(T.TM, 'yyyy-mm-dd') =" +
                    "                       TO_CHAR(P.TM, 'yyyy-mm-dd'))" +
                    "                    OR (R.PROJ_CD = P.PROJ_CD AND TO_CHAR(R.TM, 'yyyy-mm-dd') =" +
                    "                       TO_CHAR(P.TM, 'yyyy-mm-dd'))) A";

            sql2 += ") AA" +
                    "  FULL JOIN" +
                    " (SELECT *" +
                    "    FROM (SELECT TO_CHAR(TM, 'yyyy-mm-dd') AS TM," +
                    "                 S.STCD," +
                    "                 ROUND(AVG(NVL(CALCDATA, ORIGDATA)),3) AS DATA" +
                    "            FROM WR_HYDO_B H" +
                    "            LEFT JOIN WR_ST_RB_MAP S" +
                    "              ON H.STCD = S.STCD" +
                    "            LEFT JOIN WR_ST_PROJ_TYPE_MAP M" +
                    "              ON H.STCD = M.STCD" +
                    "           WHERE M.ST_TP = '1' ";

            if (StringUtil.isNotEmpty(rbcd)) {
                sql2 += "  AND S.RB_CD = ? ";
                params.add(rbcd);
            }

            if (StringUtil.isNotEmpty(tm)) {
                sql2 += "  AND TO_CHAR(TM, 'yyyy-mm') = ? ";
                params.add(tm);
            }

            sql2 += " GROUP BY TO_CHAR(TM, 'yyyy-mm-dd'), S.STCD) PIVOT(AVG((ROUND(DATA,3))) FOR STCD IN(" + lname + "))" +
                    "   ORDER BY TM DESC) BB" +
                    "    ON AA.TM = BB.TM" +
                    " ORDER BY XM DESC";

            return findEasyUiPageBySql(sql2, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbListDg(String tm, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(ppcd) && StringUtil.isNotEmpty(projcd)) {
            String sql = "SELECT STCD FROM WR_ST_PROJ_TYPE_MAP WHERE ST_TP = '1' AND PROJ_CD = ? ";
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
            String sql2 = "SELECT BB.TM AS XM, BB.*" +
                    "  FROM (SELECT *" +
                    "    FROM (SELECT TO_CHAR(TM, 'yyyy-mm-dd') AS TM," +
                    "                 S.STCD," +
                    "                 AVG(NVL(CALCDATA, ORIGDATA)) AS DATA" +
                    "            FROM WR_HYDO_B H" +
                    "            LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "              ON H.STCD = S.STCD" +
                    "           WHERE S.ST_TP = '1' ";

            if (StringUtil.isNotEmpty(projcd)) {
                sql2 += "  AND S.PROJ_CD = ? ";
                params.add(projcd);
            }

            if (StringUtil.isNotEmpty(tm)) {
                sql2 += "  AND TO_CHAR(TM, 'yyyy-mm') = ? ";
                params.add(tm);
            }

            sql2 += "           GROUP BY TO_CHAR(TM, 'yyyy-mm-dd'), S.STCD) PIVOT(AVG(DATA) FOR STCD IN(" + lname + "))" +
                    "   ORDER BY TM DESC) BB" +
                    " ORDER BY XM DESC";

            return findEasyUiPageBySql(sql2, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbTJList(String tm, String ppcd, String rbcd,List listt, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(tm) && listt.size()>0 && StringUtil.isNotEmpty(ppcd)) {
            String sql2 = "SELECT DISTINCT R.STCD FROM WR_ST_RB_MAP R LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON R.STCD = M.STCD WHERE M.ST_TP = '1' AND R.RB_CD IN ( ";
            String str="";
            for(int i=0;i<listt.size();i++){
                Map map = (Map) listt.get(i);
                if(i==0){
                    str+=map.get("RB_CD");
                }else{
                    str+=","+ map.get("RB_CD");
                }
            }
            sql2+=str+" )";
            List<Map> list = findBySqlWithMap(sql2);
            String lname = "";
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    lname += "'"+list.get(i).get("STCD")+"'" + " AS " + list.get(i).get("STCD");
                } else {
                    lname += "," + "'"+list.get(i).get("STCD")+"'"  + " AS " + list.get(i).get("STCD");
                }
            }

            List<Object> params = new ArrayList<Object>();

            String sql = "SELECT X.X,X.XM,RZ.RZ,DYP.DYP,AIRP.AIRP,ATMP.ATMP,SY.* FROM " +
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
            params.add(ppcd);
            params.add(ppcd);

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
            params.add(ppcd);
            params.add(ppcd);

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
            params.add(ppcd);
            params.add(ppcd);

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
                    "            ON X.XM = ATMP.XM";

            params.add(tm);
            params.add(ppcd);
            params.add(ppcd);

            //渗压
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
                    "                          FROM WR_HYDO_B" +
                    "                         WHERE NVL(CALCDATA, ORIGDATA) = A.MAXVAL" +
                    "                           AND STCD = A.STCD" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND ROWNUM = '1') AS MAXVALTM," +
                    "                       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                          FROM WR_HYDO_B" +
                    "                         WHERE NVL(CALCDATA, ORIGDATA) = A.MINVAL" +
                    "                           AND STCD = A.STCD" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND ROWNUM = '1') AS MINVALTM" +
                    "                  FROM (SELECT H.STCD," +
                    "                               TO_CHAR(H.TM, 'yyyy-mm') AS TM," +
                    "                               MAX(NVL(CALCDATA, ORIGDATA)) AS MAXVAL," +
                    "                               MIN(NVL(CALCDATA, ORIGDATA)) AS MINVAL" +
                    "                          FROM WR_HYDO_B H" +
                    "                          LEFT JOIN WR_ST_RB_MAP S" +
                    "                            ON H.STCD = S.STCD" +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP M" +
                    "                            ON H.STCD = M.STCD" +
                    "                         WHERE TO_CHAR(H.TM, 'yyyy-mm') = ?" +
                    "                           AND M.ST_TP = '1'" +
                    "                           AND S.RB_CD IN (" + str +" )"+
                    "                         GROUP BY TO_CHAR(H.TM, 'yyyy-mm'), H.STCD) A) B" +
                    "          FULL JOIN (SELECT STCD," +
                    "                           TO_CHAR(A.LSMAXVAL) AS LSMAXVAL," +
                    "                           TO_CHAR(A.LSMINVAL) AS LSMINVAL," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM WR_HYDO_B" +
                    "                             WHERE NVL(CALCDATA, ORIGDATA) = A.LSMAXVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMAXVALTM," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM WR_HYDO_B" +
                    "                             WHERE NVL(CALCDATA, ORIGDATA) = A.LSMINVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMINVALTM" +
                    "                      FROM (SELECT H.STCD," +
                    "                                   MAX(NVL(CALCDATA, ORIGDATA)) AS LSMAXVAL," +
                    "                                   MIN(NVL(CALCDATA, ORIGDATA)) AS LSMINVAL" +
                    "                              FROM WR_HYDO_B H" +
                    "                              LEFT JOIN WR_ST_RB_MAP S" +
                    "                                ON H.STCD = S.STCD" +
                    "                              LEFT JOIN WR_ST_PROJ_TYPE_MAP M" +
                    "                                ON H.STCD = M.STCD" +
                    "                             WHERE M.ST_TP = '1' AND S.RB_CD IN (" +str+" )"+
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
                    "                                                       PIVOT (MAX(SY) FOR STCD IN (" + lname + "))) SY" +
                    "                               ON X.XM = SY.SYXM " +
                    "   ORDER BY X.X";

            params.add(tm);

            return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbTJListDg(String tm, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(tm) && StringUtil.isNotEmpty(projcd) && StringUtil.isNotEmpty(ppcd)) {
            String sql2 = "SELECT STCD FROM WR_ST_PROJ_TYPE_MAP WHERE ST_TP = '1' AND PROJ_CD = ? ";
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

            String sql = "SELECT X.X,X.XM,SY.* FROM " +
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

            //渗压
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
                    "                          FROM WR_HYDO_B" +
                    "                         WHERE NVL(CALCDATA, ORIGDATA) = A.MAXVAL" +
                    "                           AND STCD = A.STCD" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND ROWNUM = '1') AS MAXVALTM," +
                    "                       (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                          FROM WR_HYDO_B" +
                    "                         WHERE NVL(CALCDATA, ORIGDATA) = A.MINVAL" +
                    "                           AND STCD = A.STCD" +
                    "                           AND TO_CHAR(TM, 'yyyy-mm') = A.TM" +
                    "                           AND ROWNUM = '1') AS MINVALTM" +
                    "                  FROM (SELECT H.STCD," +
                    "                               TO_CHAR(H.TM, 'yyyy-mm') AS TM," +
                    "                               MAX(NVL(CALCDATA, ORIGDATA)) AS MAXVAL," +
                    "                               MIN(NVL(CALCDATA, ORIGDATA)) AS MINVAL" +
                    "                          FROM WR_HYDO_B H" +
                    "                          LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                            ON H.STCD = S.STCD" +
                    "                           AND S.ST_TP = '1'" +
                    "                         WHERE TO_CHAR(H.TM, 'yyyy-mm') = ?" +
                    "                           AND S.PROJ_CD = ?" +
                    "                         GROUP BY TO_CHAR(H.TM, 'yyyy-mm'), H.STCD) A) B" +
                    "          FULL JOIN (SELECT STCD," +
                    "                           TO_CHAR(A.LSMAXVAL) AS LSMAXVAL," +
                    "                           TO_CHAR(A.LSMINVAL) AS LSMINVAL," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM WR_HYDO_B" +
                    "                             WHERE NVL(CALCDATA, ORIGDATA) = A.LSMAXVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMAXVALTM," +
                    "                           (SELECT TO_CHAR(TM, 'yyyy-mm-dd')" +
                    "                              FROM WR_HYDO_B" +
                    "                             WHERE NVL(CALCDATA, ORIGDATA) = A.LSMINVAL" +
                    "                               AND STCD = A.STCD" +
                    "                               AND ROWNUM = '1') AS LSMINVALTM" +
                    "                      FROM (SELECT H.STCD," +
                    "                                   MAX(NVL(CALCDATA, ORIGDATA)) AS LSMAXVAL," +
                    "                                   MIN(NVL(CALCDATA, ORIGDATA)) AS LSMINVAL" +
                    "                              FROM WR_HYDO_B H" +
                    "                              LEFT JOIN WR_ST_PROJ_TYPE_MAP S" +
                    "                                ON H.STCD = S.STCD" +
                    "                               AND S.ST_TP = '1'" +
                    "                             WHERE S.PROJ_CD = ?" +
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
                    "                                                       PIVOT (MAX(SY) FOR STCD IN (" + lname + "))) SY" +
                    "                               ON X.XM = SY.SYXM " +
                    "   ORDER BY X.X";

            params.add(tm);
            params.add(projcd);
            params.add(projcd);

            return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
        }
        return easyUiPage;
    }

}

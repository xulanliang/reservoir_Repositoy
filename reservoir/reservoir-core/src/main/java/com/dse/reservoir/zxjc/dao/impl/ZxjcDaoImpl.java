package com.dse.reservoir.zxjc.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.pojo.entity.SjfxDataEntity;
import com.dse.reservoir.zxjc.dao.ZxjcDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2017-7-13.
 */
@Repository("zxjcDao")
public class ZxjcDaoImpl extends BaseDao implements ZxjcDao {

    @Override
    public List<Map> getTree() throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT PROJ_CD AS ID,PROJ_NM AS NAME,PID,ISSW,ISSY,ISDC,ISSC,ISCZ,ISSP FROM WR_PROJ_B T WHERE T.ISDISPLAY='0'  ORDER BY ID";

        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public EasyUiPage getZxjcDate(String stm, String etm, GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT '"+ SjfxDataEntity.ST_TP_5+"' ST_TP, A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,A.RZ AS DATA FROM ST_RSVR_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '5' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sql += " AND M.PROJ_CD LIKE ? ";
            params.add(gcxArgs.getProjcd()+"%");
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
        sql += " UNION ALL SELECT '"+ SjfxDataEntity.ST_TP_6+"' ST_TP, A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,A.DYP AS DATA FROM ST_PPTN_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '6' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sql += " AND M.PROJ_CD LIKE ? ";
            params.add(gcxArgs.getProjcd()+"%");
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
        sql += " UNION ALL SELECT  '"+ SjfxDataEntity.ST_TP_7+"' ST_TP, A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,NVL(A.CATMP,A.ATMP) AS DATA FROM ST_TMP_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '7' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sql += " AND M.PROJ_CD LIKE ? ";
            params.add(gcxArgs.getProjcd()+"%");
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
        sql += " UNION ALL SELECT '"+ SjfxDataEntity.ST_TP_7_1+"' ST_TP, A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,NVL(CAIRP,AIRP) AS DATA FROM ST_TMP_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '7' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sql += " AND M.PROJ_CD LIKE ? ";
            params.add(gcxArgs.getProjcd()+"%");
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
        sql += " UNION ALL SELECT '"+ SjfxDataEntity.ST_TP_5+"' ST_TP, A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,Z AS DATA FROM WR_SW_R A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '5' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sql += " AND M.PROJ_CD LIKE ? ";
            params.add(gcxArgs.getProjcd()+"%");
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
        sql += " UNION ALL SELECT '"+ SjfxDataEntity.ST_TP_1+"' ST_TP, A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,NVL(A.CALCDATA,A.ORIGDATA) AS DATA FROM WR_HYDO_B A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '1' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sql += " AND M.PROJ_CD LIKE ? ";
            params.add(gcxArgs.getProjcd()+"%");
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
        sql += " UNION ALL SELECT '"+ SjfxDataEntity.ST_TP_2+"' ST_TP, A.STCD,S.STNM,TO_CHAR(A.TM,'yyyy-mm-dd hh24:mi:ss') AS TM,NVL(A.CALCDATA,A.ORIGDATA) AS DATA FROM WR_WEIO_B A LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON A.STCD = M.STCD " +
                "LEFT JOIN WR_STAT_M S ON A.STCD = S.STCD WHERE M.ST_TP = '2' AND S.ISJIDIAN = '0' ";

        if(StringUtil.isNotEmpty(stm) && StringUtil.isNotEmpty(etm)){
            sql += " AND A.TM>TO_DATE(?,'yyyy-mm-dd') AND A.TM<(TO_DATE(?,'yyyy-mm-dd')+1) ";
            params.add(stm);
            params.add(etm);
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sql += " AND M.PROJ_CD LIKE ? ";
            params.add(gcxArgs.getProjcd()+"%");
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


        if(StringUtil.isNotEmpty(gcxArgs.getCkID())){
            sql = " SELECT * FROM  ("+ sql +" ) T WHERE T.ST_TP=?";
            params.add(gcxArgs.getCkID());
        }
        sql += " ORDER BY TM DESC";

        return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
    }

    @Override
    public Object getPointByKey(String key, String projcd, String type) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT S.* FROM WR_STAT_M S LEFT JOIN WR_ST_PROJ_TYPE_MAP M ON S.STCD = M.STCD WHERE 1=1 ";

        if(StringUtil.isNotEmpty(projcd)){
            sql += " AND M.PROJ_CD = ?";
            params.add(projcd);
        }

        if(StringUtil.isNotEmpty(type)){
            sql += " AND M.ST_TP = ?";
            params.add(type);
        }

        if(StringUtil.isNotEmpty(key)){
            sql += " AND S.STNM LIKE ?";
            params.add("%"+key+"%");
        }

        return findBySqlWithMap(sql,params.toArray());
    }

}

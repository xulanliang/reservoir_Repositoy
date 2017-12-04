package com.dse.reservoir.shouye.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.shouye.dao.ShouyeDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 渗压Dao层
 */
@Repository("shouyeDao")
public class ShouyeDaoImpl extends BaseDao implements ShouyeDao {

    @Override
    public EasyUiPage getProject(String projcd, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT PROJ_NM,PID FROM WR_PROJ_B WHERE 1=1";

        if(StringUtil.isNotEmpty(projcd)) {
            sql += " AND PID = ? ";
            params.add(projcd);
        }

        return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
    }

    @Override
    public EasyUiPage getPoint(String projcd, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT S.STCD,S.STNM,P.PROJ_CD,P.PROJ_NM,P.PID FROM WR_STAT_M S LEFT JOIN WR_PROJ_B P ON S.PROJ_CD = P.PROJ_CD WHERE 1=1";

        if(StringUtil.isNotEmpty(projcd)) {
            sql += " AND P.PID = ? ";
            params.add(projcd);
        }

        return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
    }

    @Override
    public List<Map<String, Object>> getProjAlarmInfo(Map<String, Object> conditions) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("")
                .append(" SELECT substr(WB.PROJ_CD,1,1) AS PID, NVL(SUM(T.COU),0) AS TOTAL ")
                .append(" FROM WR_PROJ_B WB")
                .append(" LEFT JOIN ( ")
                .append(" SELECT COUNT(1) AS COU, T.PROJ_CD")
                .append(" FROM WR_WARNING_B T")
                .append(" WHERE T.WA_STATUS = '0'")         //只查询未读的报警信息
                .append(" and  t.wa_dt > to_date(to_char(sysdate-30, 'yyyy-mm-dd'),'yyyy-mm-dd') ")         // 查询最近30天的报警数据
                // .append(" AND T.MON_TP  = '2'")
                .append(" GROUP BY T.PROJ_CD) T ")
                .append(" ON T.PROJ_CD = WB.PROJ_CD")
                .append("  WHERE 1=1")
                .append("  GROUP BY substr(WB.PROJ_CD,1,1) ")
                .append("");

        return findBySqlWithMap(sql.toString(),conditions);
    }

}

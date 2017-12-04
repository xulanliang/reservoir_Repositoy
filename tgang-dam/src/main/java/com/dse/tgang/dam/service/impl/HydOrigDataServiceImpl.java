package com.dse.tgang.dam.service.impl;

import com.dse.tgang.dam.service.HydOrigDataService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/13.
 */
@Service
@Transactional
public class HydOrigDataServiceImpl implements HydOrigDataService {

    @Resource
    private JdbcTemplate jdbcTemplate;// 用于复杂sql

    //查询测点编号及渗压水位
    @Override
    public Object queryCdbhjSysw(Map<String, String> dataMap) {

        String bntrcd = dataMap.get("bntrcd");//根据断面编号查询测点编号及水位
        String startTm = dataMap.get("startTm");//开始时间
        String endTm = dataMap.get("endTm");//结束时间

        StringBuffer sb = new StringBuffer();
        sb.append(" SELECT t.TM,t.HYDCD,t.ORIGDATA  FROM DSE_DBJC_005_HYDORIGDATA t WHERE 1=1 ");
        sb.append(" AND t.HYDCD IN (select t1.POINTCD from dse_monitoring_points t1 WHERE t1.BNTRCD= ?)");
        sb.append(" AND t.tm between CONVERT(datetime,?,20) and CONVERT(datetime,?,20) order by t.tm");
        return jdbcTemplate.queryForList(sb.toString(), bntrcd, startTm, endTm);
    }

    @Override
    public Boolean updateCdbhjSysw(Map<String, String> dataMap) {
        return null;
    }

    @Override
    public Boolean saveCdbhjSysw(Map<String, String> dataMap) {
        return null;
    }
}

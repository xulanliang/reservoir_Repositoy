package com.dse.tgang.dam.service.impl;

import com.dse.tgang.dam.dao.BasicFeatureDao;
import com.dse.tgang.dam.service.BasicFeatureService;
import com.dse.tgang.dam.util.DseStringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by gaoq on 2017-4-18.
 */
@Service
@Transactional
public class BasicFeatureServiceImpl implements BasicFeatureService{

    @Resource
    private JdbcTemplate jdbcTemplate;// 用于复杂sql
    @Resource
    private BasicFeatureDao basicFeatureDao;

    @Override
    public Object getList(Map<String, String> dataMap) {
        List<Object> param = new ArrayList<Object>();
        String ennmcd = dataMap.get("ennmcd");
        if (DseStringUtil.empty(ennmcd)) {
            return null;
        }
        String sql = "select p.ennmcd,CONVERT (VARCHAR (19), p.utm, 120) utm,CONVERT (VARCHAR (19), p.ctm, 120) ctm,cast(p.wsgtlv as decimal(8, 2)) wsgtlv,cast(p.fldlim as decimal(8, 2)) fldlim,cast(p.dsfllv as decimal(8, 2)) dsfllv, r.ennm from pj0206_rspp p left join TB0201_RSCMIN_044 r on p.ennmcd = r.ENNMCD " +
                "where p.ennmcd = ? order by utm DESC";
        return jdbcTemplate.queryForList(sql,ennmcd);
    }

    @Override
    public void saveInfo(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String ennmcd = dataMap.get("ennmcd");
        String utm = dataMap.get("utm");
        String ctm = dataMap.get("ctm");
        String wsgtlv = dataMap.get("wsgtlv");
        String fldlim = dataMap.get("fldlim");
        String dsfllv = dataMap.get("dsfllv");

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String infndt=sdf.format(date);

        String sql = "INSERT INTO pj0206_rspp (ennmcd,utm,ctm,wsgtlv,fldlim,dsfllv,infndt) VALUES(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, ennmcd, utm, ctm, wsgtlv, fldlim, dsfllv, infndt);
    }

    @Override
    public void updateInfo(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String ennmcd = dataMap.get("ennmcd");
        String utm = dataMap.get("utm");
        String outm = dataMap.get("outm");
        String ctm = dataMap.get("ctm");
        String wsgtlv = dataMap.get("wsgtlv");
        String fldlim = dataMap.get("fldlim");
        String dsfllv = dataMap.get("dsfllv");

        String sql = "UPDATE pj0206_rspp SET utm=?,ctm=?,wsgtlv=?,fldlim=?,dsfllv=? WHERE ennmcd=? and CONVERT(VARCHAR (19),utm,120) = ? ";
        jdbcTemplate.update(sql, utm, ctm, wsgtlv, fldlim, dsfllv, ennmcd, outm);
    }

    @Override
    public void deleteInfo(Map<String, String> dataMap) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        String ennmcd = dataMap.get("ennmcd");
        String utm = dataMap.get("utm");

        String jsql = "DELETE FROM pj0206_rspp WHERE ennmcd=? and CONVERT(VARCHAR (19),utm,120) = ?";
        jdbcTemplate.update(jsql, ennmcd, utm);
    }

    @Override
    public void exchangeData(Map<String, String> dataMap) throws Exception {
        basicFeatureDao.exchangeData(dataMap);
    }
}

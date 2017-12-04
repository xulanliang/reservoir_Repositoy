package com.dse.reservoir.comm.sys.service.impl;


import com.dse.reservoir.api.comm.sys.service.DseSysCommonsqlService;
import com.dse.reservoir.comm.sys.dao.DseSysCommonsqlDao;
import com.dse.reservoir.sjfx.spwy.dao.SpwyDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/30.
 */

@Service("dseSysCommonsqlService")
@Transactional
public class DseSysCommonsqlServiceImpl implements DseSysCommonsqlService {

    @Resource(name = "dseSysCommonsqlDao")
    private DseSysCommonsqlDao dseSysCommonsqlDao;



    @Override
    public Object divisionInfo(String code) {
        return dseSysCommonsqlDao.divisionInfo(code);
    }

    @Override
    public Object getStationInfo(Map<String, String> dataMap) throws Exception {
        return null;
    }

    @Override
    public Object getListBycode(String ids,String state,String pcode) throws Exception {
        return dseSysCommonsqlDao.getListBycode(ids,state,pcode);
    }

    @Override
    public Object getWzInfoBycode2(String id) throws Exception {
        return dseSysCommonsqlDao.getWzInfoBycode2(id);
    }

    @Override
    public Object getListCheckObj(String pcode, String ck_org) throws Exception {
        return dseSysCommonsqlDao.getListCheckObj(pcode,ck_org);
    }
}

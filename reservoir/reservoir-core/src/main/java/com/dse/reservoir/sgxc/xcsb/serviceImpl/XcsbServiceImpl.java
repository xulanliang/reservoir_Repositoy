package com.dse.reservoir.sgxc.xcsb.serviceImpl;

import com.dse.reservoir.api.sgxc.xcsb.service.XcsbService;
import com.dse.reservoir.sgxc.xcsb.dao.XcsbDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by dse on 2017/8/22.
 */
@Transactional
@Service("xcsbService")
public class XcsbServiceImpl implements XcsbService {

    @Resource(name = "xcsbDao")
    XcsbDao xcsbDao;

    @Override
    public Object saveXcsb(String taskID,String ckID, String issure,String issueID) {
        return xcsbDao.saveXcsb(taskID,ckID,issure,issueID);
    }

    @Override
    public Object doSave(String taskID) {
        return xcsbDao.doSave(taskID);
    }
}

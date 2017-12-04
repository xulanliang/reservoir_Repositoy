package com.dse.reservoir.sgxc.xcsb.dao;

import com.dse.common.dao.IBaseDao;

/**
 * Created by dse on 2017/8/22.
 */
public interface XcsbDao extends IBaseDao {
    public Object saveXcsb(String taskID,String ckID, String issure,String issueID);

    public Object doSave(String taskID);
}

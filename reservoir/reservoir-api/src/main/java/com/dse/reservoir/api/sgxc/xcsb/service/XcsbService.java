package com.dse.reservoir.api.sgxc.xcsb.service;

/**
 *   巡查上报
 * Created by dse on 2017/8/22.
 */
public interface XcsbService {
    /**
     *  保存巡查内容
     * @param ckID
     * @param issure
     * @return
     */
    public Object saveXcsb(String taskID,String ckID,String issure,String issueID);

    /**
     *  上报巡查任务
     * @param taskID
     * @return
     */
    public Object doSave(String taskID);

}

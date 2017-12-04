package com.dse.reservoir.api.fxwz.wrmapatrolb.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;

/**
 * Created by  on 2017-9-5.
 */
public interface WrMaPatrolbService {

    /**
     * 查询基础数据
     * @param args
     * @return
     */
    public EasyUiPage getListInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage) throws Exception;

    /**
     *  获取物资巡查内容
     * @param isflood
     * @param easyUiPage
     * @return
     * @throws Exception
     */
    public EasyUiPage getListWZXCNRInfoByParams(String isflood, EasyUiPage easyUiPage) throws Exception;

    /**
     *  获取巡查任务的巡查内容
     * @param search_ck_re_id
     * @param easyUiPage
     * @return
     * @throws Exception
     */
    public EasyUiPage getWZXCListInfoByParams(String search_ck_re_id,String search_ck_cnt_desc,String search_ch_status, EasyUiPage easyUiPage) throws Exception;

    /**
     * 删除数据
     * @param ids
     * @return
     */
    public Object deleteInfoByIds(String ids) throws Exception;

    /**
     * 保存或修改
     * @param dataStr
     * @return
     */
    public Object saveOrUpdateInfo(String dataStr) throws Exception;


    /**
     *  防汛物资巡查上报
     * @param taskID
     * @return
     * @throws Exception
     */
    public Object doSave(String taskID) throws Exception;

    /**
     * 保存防汛物资巡查上报
     * @param ckID
     * @param issue
     * @param issueID
     * @param taskID
     * @return
     * @throws Exception
     */
    public Object saveXcsb(String ckID,String issue,String issueID,String taskID) throws Exception;

    /**
     * 获取详情
     * @param id
     * @return
     */
    public Object getInfoById(String id) throws Exception;

    public Object updateStautsByIds(String ids,String stauts) throws Exception;

}

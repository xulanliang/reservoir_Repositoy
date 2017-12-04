package com.dse.reservoir.api.sgxc.wrchktask.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sgxc.wrchktask.pojo.WrchkTaskModel;

import java.util.List;

/***
 *巡查任务
 * 2017-08-09
 */

public interface WrchkTaskService {

    /***
     *
     * @param args
     * @param notcktkid
     * @return
     * @throws Exception
     */
    public Object getWrchkTaskList(WrchkTaskModel args, String notcktkid) throws Exception;

    /****
     * @param args
     * @return
     * @throws Exception
     */
    public Object getWrchkTaskCount(WrchkTaskModel args) throws Exception;

    /**
     * 查询基础信息
     * @param args 仓库名称
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getListInfoByParams(WrchkTaskModel args, EasyUiPage easyUiPage);

    /**
     * 获取信息
     * @param id
     * @return
     */
    public Object getInfoById(String id);

    /**
     * 保存或修改
     * @param dataStr
     * @return
     */
    public Object saveOrUpdateInfo(String dataStr);

    /**
     * 删除
     * @param ids
     * @return
     */
    public Object deleteInfoByIds(String ids);

    /***
     *
     * @param args
     * @return
     * @throws Exception
     */
    public Object getJobWrchkTaskList(WrchkTaskModel args) throws Exception;

    /**
     *
     * @param args
     * @return
     * @throws Exception
     */
    public List<WrchkTaskModel> getJobWrchkTaskList2(WrchkTaskModel args) throws Exception;

    /***
     * 根据计划生成任务方法
     * @param taskmodel
     * @return
     */
    public Object createJobToWrChkRecordData(WrchkTaskModel taskmodel) throws Exception;

    /***
     *
     * @param taskmodel
     * @throws Exception
     */
    public Object execTask(WrchkTaskModel taskmodel) throws Exception;
}

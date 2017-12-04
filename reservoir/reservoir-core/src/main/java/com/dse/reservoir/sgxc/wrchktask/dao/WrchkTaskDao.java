package com.dse.reservoir.sgxc.wrchktask.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sgxc.wrchktask.pojo.WrchkTaskModel;

import java.util.List;

/***
 *巡查任务
 * 2017-08-08
 */
public interface WrchkTaskDao extends IBaseDao {

    /***
     *
     * @param args
     * @param notCkObjId
     * @return
     * @throws Exception
     */
    public Object getWrchkTaskList(WrchkTaskModel args, String notCkObjId) throws Exception;

    /****
     *
     * @param args
     * @return
     * @throws Exception
     */
    public Object getWrchkTaskCount(WrchkTaskModel args) throws Exception;

    /**
     * 查询基础信息
     * @param args
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

    public Object getJobWrchkTaskList(WrchkTaskModel args) throws Exception;

    /**
     *
     * @param args
     * @return
     * @throws Exception
     */
    public List<WrchkTaskModel> getJobWrchkTaskList2(WrchkTaskModel args) throws Exception;
}

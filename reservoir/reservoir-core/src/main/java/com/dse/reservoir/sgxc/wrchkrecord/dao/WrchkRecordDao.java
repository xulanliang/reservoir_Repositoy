package com.dse.reservoir.sgxc.wrchkrecord.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sgxc.wrchkrecord.pojo.WrchkRecordModel;
import com.dse.reservoir.api.sgxc.wrchktask.pojo.WrchkTaskModel;

/***
 *巡查记录信息
 * 2017-08-08
 */
public interface WrchkRecordDao extends IBaseDao {

    /***
     * @param args
     * @param notckreid
     * @return
     * @throws Exception
     */
    public Object getWrchkRecordList(WrchkRecordModel args, String notckreid) throws Exception;

    /****
     *
     * @param args
     * @return
     * @throws Exception
     */
    public Object getWrchkRecordCount(WrchkRecordModel args) throws Exception;

    /**
     * 查询基础信息
     * @param args
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getListInfoByParams(WrchkRecordModel args, EasyUiPage easyUiPage);

    public EasyUiPage getXctjListInfoByParams(String sTime, String eTime, String dep_name, String ck_type, EasyUiPage easyUiPage);

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
     * @param ids
     * @param stauts
     * @return
     */
    public Object updateStautsByIds(String ids,String stauts);

    /***
     * 根据计划生成任务方法
     * @param taskmodel
     * @return
     */
    public Object createWrChkRecordData(WrchkTaskModel taskmodel);

    /***
     * 巡查任务
     * @param taskmodel
     * @return
     */
    public Object updateWrChkTask(WrchkTaskModel taskmodel);

    /****
     * 巡查记录信息
     * @param recordmodel
     * @return
     */
    public Object saveWrChkRecord(WrchkRecordModel recordmodel);
    /****
     * 巡查记录项目详情表
     * @param recordmodel
     * @return
     */
    public Object saveWrChkRedChild(WrchkRecordModel recordmodel);


}

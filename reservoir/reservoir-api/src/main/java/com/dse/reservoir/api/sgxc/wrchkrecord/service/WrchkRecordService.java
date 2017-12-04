package com.dse.reservoir.api.sgxc.wrchkrecord.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sgxc.wrchkrecord.pojo.WrchkRecordModel;


/***
 * 巡查记录信息
 *WR_CHK_RECORD
 * 2017-08-11
 */

public interface WrchkRecordService {

    /***
     *
     * @param args
     * @param notckreid
     * @return
     * @throws Exception
     */
    public Object getWrchkTaskList(WrchkRecordModel args, String notckreid) throws Exception;

    /****
     * @param args
     * @return
     * @throws Exception
     */
    public Object getWrchkTaskCount(WrchkRecordModel args) throws Exception;

    /**
     * 查询基础信息
     * @param args 仓库名称
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getListInfoByParams(WrchkRecordModel args, EasyUiPage easyUiPage);

    /**
     *  巡查统计
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getXctjListInfoByParams(String sTime,String eTime,String dep_name,String ck_type, EasyUiPage easyUiPage);

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

}

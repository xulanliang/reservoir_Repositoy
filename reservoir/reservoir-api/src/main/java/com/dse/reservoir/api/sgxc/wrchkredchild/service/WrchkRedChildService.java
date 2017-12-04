package com.dse.reservoir.api.sgxc.wrchkredchild.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sgxc.wrchkredchild.pojo.WrchkRedChildModel;


/***
 * 巡查记录信息
 *WrchkRedChild
 * 2017-08-11
 */

public interface WrchkRedChildService {

    /***
     *
     * @param args
     * @param notckreid
     * @returnID
     * @throws Exception
     */
    public Object getList(WrchkRedChildModel args, String notckreid) throws Exception;

    /****
     * @param args
     * @return
     * @throws Exception
     */
    public Object getCount(WrchkRedChildModel args) throws Exception;

    /**
     * 查询基础信息
     * @param args 仓库名称
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getListInfoByParams(String ques_status,String problem,WrchkRedChildModel args, EasyUiPage easyUiPage);

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

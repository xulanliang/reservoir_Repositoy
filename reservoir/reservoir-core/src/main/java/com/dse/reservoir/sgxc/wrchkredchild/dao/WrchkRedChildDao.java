package com.dse.reservoir.sgxc.wrchkredchild.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sgxc.wrchkredchild.pojo.WrchkRedChildModel;

/***
 *巡查记录信息
 * 2017-08-08
 */
public interface WrchkRedChildDao extends IBaseDao {

    /***
     * @param args
     * @param notckreid
     * @return
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
     * @param args
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

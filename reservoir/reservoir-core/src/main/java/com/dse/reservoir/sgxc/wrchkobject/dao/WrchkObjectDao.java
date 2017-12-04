package com.dse.reservoir.sgxc.wrchkobject.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sgxc.wrchkobject.pojo.WrchkObjectModel;

/***
 *巡查对象/巡查点
 * 2017-08-08
 */
public interface WrchkObjectDao extends IBaseDao {

    /***
     *
     * @param args
     * @param notCkObjId
     * @return
     * @throws Exception
     */
    public Object getWrChkObjectList(WrchkObjectModel args,String notCkObjId) throws Exception;

    public Object getXcnrInfoById(String id) throws Exception;

    /****
     *
     * @param args
     * @return
     * @throws Exception
     */
    public Object getWrChkObjectCount(WrchkObjectModel args) throws Exception;

    /**
     * 查询基础信息
     * @param args
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getListInfoByParams(WrchkObjectModel args, EasyUiPage easyUiPage);

    /**
     *  根据测点id查询巡查内容
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getXcnrListInfoByParams(String depID,String objID,String CK_OBJ_ID, EasyUiPage easyUiPage);

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
     *  保存、修改巡查内容
     * @param dataStr
     * @return
     */
    public Object saveOrUpdateXcnrInfo(String dataStr,String checkID);

    /**
     * 删除
     * @param ids
     * @return
     */
    public Object deleteInfoByIds(String ids);
    /**
     * 删除巡查内容
     * @param ids
     * @return
     */
    public Object deleteXcnrInfoByIds(String ids);


}

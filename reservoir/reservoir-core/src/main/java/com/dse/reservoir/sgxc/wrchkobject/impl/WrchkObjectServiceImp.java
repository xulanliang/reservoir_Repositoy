package com.dse.reservoir.sgxc.wrchkobject.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sgxc.wrchkobject.pojo.WrchkObjectModel;
import com.dse.reservoir.api.sgxc.wrchkobject.service.WrchkObjectService;
import com.dse.reservoir.sgxc.wrchkobject.dao.WrchkObjectDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/***
 *
 */
@Service("wrchkObjectService")
@Transactional
public class WrchkObjectServiceImp implements WrchkObjectService {

    @Resource(name="wrchkObjectDao")
    public WrchkObjectDao wrchkObjectDao;

    /***
     *
     * @param args
     * @param notCkObjId
     * @return
     * @throws Exception
     */
    public Object getWrChkObjectList(WrchkObjectModel args,String notCkObjId) throws Exception{
        return wrchkObjectDao.getWrChkObjectList(args,notCkObjId);
    }

    @Override
    public Object getXcnrInfoById(String id) throws Exception {
        return wrchkObjectDao.getXcnrInfoById(id);
    }

    /****
     *
     * @param args
     * @return
     * @throws Exception
     */
    public Object getWrChkObjectCount(WrchkObjectModel args) throws Exception{
        return wrchkObjectDao.getWrChkObjectCount(args);
    }

    @Override
    public EasyUiPage getListInfoByParams(WrchkObjectModel args, EasyUiPage easyUiPage){
        return wrchkObjectDao.getListInfoByParams(args,easyUiPage);
    }

    @Override
    public EasyUiPage getXcnrListInfoByParams(String depID,String objID,String CK_OBJ_ID, EasyUiPage easyUiPage) {
        return wrchkObjectDao.getXcnrListInfoByParams(depID,objID,CK_OBJ_ID,easyUiPage);
    }

    @Override
    public Object getInfoById(String id) {
        return wrchkObjectDao.getInfoById(id);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) {
        return wrchkObjectDao.saveOrUpdateInfo(dataStr);
    }

    @Override
    public Object saveOrUpdateXcnrInfo(String dataStr,String checkID) {
        return wrchkObjectDao.saveOrUpdateXcnrInfo(dataStr,checkID);
    }

    @Override
    public Object deleteInfoByIds(String ids) {
         return wrchkObjectDao.deleteInfoByIds(ids);
    }

    @Override
    public Object deleteXcnrInfoByIds(String ids) {
        return wrchkObjectDao.deleteXcnrInfoByIds(ids);
    }


}

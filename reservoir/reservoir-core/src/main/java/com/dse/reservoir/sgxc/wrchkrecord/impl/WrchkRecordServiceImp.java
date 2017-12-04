package com.dse.reservoir.sgxc.wrchkrecord.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sgxc.wrchkrecord.pojo.WrchkRecordModel;
import com.dse.reservoir.api.sgxc.wrchkrecord.service.WrchkRecordService;
import com.dse.reservoir.sgxc.wrchkrecord.dao.WrchkRecordDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/***
 *
 */
@Service("wrchkRecordService")
@Transactional
public class WrchkRecordServiceImp implements WrchkRecordService {

    @Resource(name = "wrchkRecordDao")
    public WrchkRecordDao wrchkRecordDao;

    /***
     *
     * @param args
     * @param notcktkid
     * @return
     * @throws Exception
     */
    public Object getWrchkTaskList(WrchkRecordModel args, String notcktkid) throws Exception{
        return wrchkRecordDao.getWrchkRecordList(args,notcktkid);
    }

    /****
     *
     * @param args
     * @return
     * @throws Exception
     */
    public Object getWrchkTaskCount(WrchkRecordModel args) throws Exception{
        return wrchkRecordDao.getWrchkRecordCount(args);
    }

    @Override
    public EasyUiPage getListInfoByParams(WrchkRecordModel args, EasyUiPage easyUiPage){
        return wrchkRecordDao.getListInfoByParams(args,easyUiPage);
    }

    @Override
    public EasyUiPage getXctjListInfoByParams(String sTime, String eTime, String dep_name, String ck_type, EasyUiPage easyUiPage) {
        return wrchkRecordDao.getXctjListInfoByParams(sTime,eTime,dep_name,ck_type,easyUiPage);
    }

    @Override
    public Object getInfoById(String id) {
        return wrchkRecordDao.getInfoById(id);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) {
        return wrchkRecordDao.saveOrUpdateInfo(dataStr);
    }

    @Override
    public Object deleteInfoByIds(String ids) {
         return wrchkRecordDao.deleteInfoByIds(ids);
    }

    /***
     *
     * @param ids
     * @param stauts
     * @return
     */
    public Object updateStautsByIds(String ids,String stauts){
        return wrchkRecordDao.updateStautsByIds(ids,stauts);
    }
}

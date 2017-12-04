package com.dse.reservoir.sgxc.wrchkredchild.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sgxc.wrchkredchild.pojo.WrchkRedChildModel;
import com.dse.reservoir.api.sgxc.wrchkredchild.service.WrchkRedChildService;
import com.dse.reservoir.sgxc.wrchkredchild.dao.WrchkRedChildDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/***
 *
 */
@Service("wrchkRedChildService")
@Transactional
public class WrchkRedChildServiceImp implements WrchkRedChildService {

    @Resource(name = "wrchkRedChildDao")
    public WrchkRedChildDao wrchkRedChildDao;

    /***
     *
     * @param args
     * @param notcktkid
     * @return
     * @throws Exception
     */
    public Object getList(WrchkRedChildModel args, String notcktkid) throws Exception{
        return wrchkRedChildDao.getList(args,notcktkid);
    }

    /****
     *
     * @param args
     * @return
     * @throws Exception
     */
    public Object getCount(WrchkRedChildModel args) throws Exception{
        return wrchkRedChildDao.getCount(args);
    }

    @Override
    public EasyUiPage getListInfoByParams(String ques_status,String problem,WrchkRedChildModel args, EasyUiPage easyUiPage){
        return wrchkRedChildDao.getListInfoByParams(ques_status,problem,args,easyUiPage);
    }

    @Override
    public Object getInfoById(String id) {
        return wrchkRedChildDao.getInfoById(id);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) {
        return wrchkRedChildDao.saveOrUpdateInfo(dataStr);
    }

    @Override
    public Object deleteInfoByIds(String ids) {
         return wrchkRedChildDao.deleteInfoByIds(ids);
    }

    /***
     *
     * @param ids
     * @param stauts
     * @return
     */
    public Object updateStautsByIds(String ids,String stauts){
        return wrchkRedChildDao.updateStautsByIds(ids,stauts);
    }

}

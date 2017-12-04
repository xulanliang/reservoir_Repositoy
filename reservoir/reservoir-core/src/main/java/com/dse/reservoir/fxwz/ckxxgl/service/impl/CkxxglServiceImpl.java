package com.dse.reservoir.fxwz.ckxxgl.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.ckxxgl.pojo.WrWhB;
import com.dse.reservoir.api.fxwz.ckxxgl.service.CkxxglService;
import com.dse.reservoir.fxwz.ckxxgl.dao.CkxxglDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by pc on 2017-8-2.
 */
@Service("ckxxglService")
@Transactional
public class CkxxglServiceImpl implements CkxxglService {

    @Resource(name="ckxxglDao")
    public CkxxglDao ckxxglDao;

    @Override
    public Object getOrg() throws Exception {
        return ckxxglDao.getOrg();
    }

    @Override
    public Object getXcdListBycode(String depID,String objID) throws Exception {
        return ckxxglDao.getXcdListBycode(depID,objID);
    }

    @Override
    public Object getGetType() throws Exception {
        return ckxxglDao.getGetType();
    }

    @Override
    public Object getJclx() throws Exception {
        return ckxxglDao.getJclx();
    }

    @Override
    public Object getProject() throws Exception {
        return ckxxglDao.getProject();
    }

    @Override
    public Object getMDNAME(String PROJ_CD) throws Exception {
        return ckxxglDao.getMDNAME(PROJ_CD);
    }

    @Override
    public Object getCdclzt() throws Exception {
        return ckxxglDao.getCdclzt();
    }

    @Override
    public EasyUiPage getListInfoByParams(WrWhB args, EasyUiPage easyUiPage) throws Exception {
        return ckxxglDao.getListInfoByParams(args, easyUiPage);
    }

    /***
     *
     * @param args
     * @return
     * @throws Exception
     */
    public Object getListDataByParams(WrWhB args)  throws Exception{
        return ckxxglDao.getListDataByParams(args);
    }


    @Override
    public Object deleteInfoByIds(String ids) throws Exception {
        return ckxxglDao.deleteInfoByIds(ids);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception {
        return ckxxglDao.saveOrUpdateInfo(dataStr);
    }

    @Override
    public Object getInfoById(String id) throws Exception {
        return ckxxglDao.getInfoById(id);
    }

}

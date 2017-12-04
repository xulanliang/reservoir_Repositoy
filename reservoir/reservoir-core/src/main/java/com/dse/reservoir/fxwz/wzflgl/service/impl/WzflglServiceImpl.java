package com.dse.reservoir.fxwz.wzflgl.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.wzflgl.service.WzflglService;
import com.dse.reservoir.fxwz.wzcfdxx.dao.WzcfdxxDao;
import com.dse.reservoir.fxwz.wzflgl.dao.WzflglDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by pc on 2017-8-1.
 */
@Service("wzflglService")
@Transactional
public class WzflglServiceImpl implements WzflglService {

    @Resource(name="wzflglDao")
    public WzflglDao wzflglDao;

    @Override
    public Object getfl(String id) throws Exception{
        return wzflglDao.getfl(id);
    }

    @Override
    public Object checkId(String id) throws Exception {
        return wzflglDao.checkId(id);
    }

    @Override
    public EasyUiPage getListInfoByParams(String wztypename, EasyUiPage easyUiPage) throws Exception{
        return wzflglDao.getListInfoByParams( wztypename,  easyUiPage);
    }

    @Override
    public Object deleteInfoByIds(String ids) throws Exception {
        return wzflglDao.deleteInfoByIds( ids);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception {
        return wzflglDao.saveOrUpdateInfo( dataStr);
    }

    @Override
    public Object getInfoById(String ckid) throws Exception {
        return wzflglDao.getInfoById( ckid);
    }

}

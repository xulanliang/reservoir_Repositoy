package com.dse.reservoir.fxwz.wzcfxx.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.wzcfxx.service.WzcfxxService;
import com.dse.reservoir.fxwz.wzcfxx.dao.WzcfxxDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * Created by Zhangli on 2016/11/7.
 */
@Service("wzcfxxService")
@Transactional
public class WzcfxxServiceImp implements WzcfxxService {

    @Resource(name="wzcfxxDao")
    public WzcfxxDao wzcfxxDao;

    @Override
    public EasyUiPage getListInfoByParams(String ckname, String wzname, String year, EasyUiPage easyUiPage){
        return wzcfxxDao.getListInfoByParams(ckname,wzname,year,easyUiPage);
    }


    @Override
    public Object getInfoById(String id) {
        return wzcfxxDao.getInfoById(id);
    }


    public Object saveOrUpdateInfo(String dataStr) {
        return wzcfxxDao.saveOrUpdateInfo(dataStr);
    }
    @Override
    public Object deleteInfoByIds(String ids) {
         return wzcfxxDao.deleteInfoByIds(ids);
    }

    @Override
    public EasyUiPage getCkListInfo(EasyUiPage easyUiPage) {
        return wzcfxxDao.getCkListInfo(easyUiPage);
    }

    @Override
    public EasyUiPage getWzListInfo(EasyUiPage easyUiPage) {
        return wzcfxxDao.getWzListInfo(easyUiPage);
    }

}

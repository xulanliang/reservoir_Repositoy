package com.dse.reservoir.fxwz.wzcfdxx.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.wzcfdxx.service.WzcfdxxService;
import com.dse.reservoir.fxwz.wzcfdxx.dao.WzcfdxxDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * 物资存放地
 * Created by pengzx on 2017/6/29.
 */
@Service("wzcfdxxService")
@Transactional
public class WzcfdxxServiceImpl implements WzcfdxxService {

    @Resource(name="wzcfdxxDao")
    public WzcfdxxDao wzcfdxxDao;

    @Override
    public EasyUiPage getListInfoByParams(String adcd, String ckname, String year, EasyUiPage easyUiPage) {
        return wzcfdxxDao.getListInfoByParams( adcd,  ckname,  year,  easyUiPage);
    }

    @Override
    public Object deleteInfoByIds(String ids) {
        return wzcfdxxDao.deleteInfoByIds( ids);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) {
        return wzcfdxxDao.saveOrUpdateInfo( dataStr);
    }

    @Override
    public Object getInfoById(String ckid) {
         return wzcfdxxDao.getInfoById( ckid);
    }
}

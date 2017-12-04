package com.dse.reservoir.sjfx.wralarmparamm.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.wralarmparamm.pojo.WrAlarmParammModel;
import com.dse.reservoir.api.sjfx.wralarmparamm.service.WrAlarmParammService;
import com.dse.reservoir.sjfx.wralarmparamm.dao.WrAlarmParammDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by  on 2017-08-22.
 */
@Service("wrAlarmParammService")
@Transactional
public class WrAlarmParammImpl implements WrAlarmParammService {

    @Resource(name = "wrAlarmParammDao")
    public WrAlarmParammDao wrAlarmParammDao;


    @Override
    public EasyUiPage getListInfoByParams(WrAlarmParammModel args, EasyUiPage easyUiPage) throws Exception {
        return wrAlarmParammDao.getListInfoByParams(args, easyUiPage);
    }

    @Override
    public Object deleteInfoByIds(String ids) throws Exception {
        return wrAlarmParammDao.deleteInfoByIds(ids);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception {
        return wrAlarmParammDao.saveOrUpdateInfo(dataStr);
    }

    @Override
    public Object getInfoById(String ckid) throws Exception {
        return wrAlarmParammDao.getInfoById(ckid);
    }

}

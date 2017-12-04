package com.dse.reservoir.sjfx.wrwarningb.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.wralarmparamm.pojo.WrAlarmParammModel;
import com.dse.reservoir.api.sjfx.wrwarningb.pojo.WrWarningbModel;
import com.dse.reservoir.api.sjfx.wrwarningb.service.WrWarningbService;
import com.dse.reservoir.fxwz.wzflgl.dao.WzflglDao;
import com.dse.reservoir.sjfx.wrwarningb.dao.WrWarningbDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by  on 2017-8-1.
 */
@Service("wrWarningbService")
@Transactional
public class WrWarningbServiceImpl implements WrWarningbService {

    @Resource(name = "wrWarningbDao")
    public WrWarningbDao wrWarningbDao;


    @Override
    public EasyUiPage getListInfoByParams(WrWarningbModel args, EasyUiPage easyUiPage) throws Exception {
        return wrWarningbDao.getListInfoByParams(args, easyUiPage);
    }

    @Override
    public Object deleteInfoByIds(String ids) throws Exception {
        return wrWarningbDao.deleteInfoByIds(ids);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception {
        return wrWarningbDao.saveOrUpdateInfo(dataStr);
    }

    @Override
    public Object getInfoById(String ckid) throws Exception {
        return wrWarningbDao.getInfoById(ckid);
    }

    @Override
    public Object getWarnListByProjCd(Map<String, Object> condtionMap, EasyUiPage easyUiPage, String type) throws Exception {
        return wrWarningbDao.getWarnListByProjCd(condtionMap,easyUiPage,type);
    }

    @Override
    public Integer saveOrUpdate(Map<String,Object> params) throws Exception {
        return  wrWarningbDao.UpdateWarnStatus(params);
    }

    @Override
    public Object getRateData(Map<String, Object> params) throws Exception {
        return wrWarningbDao.getRateData(params);
    }

    @Override
    public Object getLostRate(Map<String, Object> params) throws Exception {
        return wrWarningbDao.getLostRate(params);
    }

    @Override
    public Object getWorkingHours(Map<String, Object> params) throws Exception {
        return wrWarningbDao.getWorkingHours(params);
    }

    @Override
    public Object getAlarmCountByCd(Map<String, Object> params) throws Exception{
        return wrWarningbDao.getAlarmCountByCd(params);
    }
}

package com.dse.reservoir.fxwz.wrmawarningb.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wrmawarningb.pojo.WrMaWarningbModel;
import com.dse.reservoir.api.fxwz.wrmawarningb.service.WrMaWarningbService;
import com.dse.reservoir.fxwz.wrmawarningb.dao.WrMaWarningbDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by  on 2017-8-1.
 */
@Service("wrMaWarningbService")
@Transactional
public class WrMaWarningbServiceImpl implements WrMaWarningbService {

    @Resource(name = "wrMaWarningbDao")
    public WrMaWarningbDao wrMaWarningbDao;


    @Override
    public EasyUiPage getListInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage) throws Exception {
        return wrMaWarningbDao.getListInfoByParams(args, easyUiPage);
    }

    @Override
    public Object deleteInfoByIds(String ids) throws Exception {
        return wrMaWarningbDao.deleteInfoByIds(ids);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception {
        return wrMaWarningbDao.saveOrUpdateInfo(dataStr);
    }

    @Override
    public Object getInfoById(String ckid) throws Exception {
        return wrMaWarningbDao.getInfoById(ckid);
    }

    public Object updateStautsByIds(String ids,String stauts) throws Exception{
        return wrMaWarningbDao.updateStautsByIds(ids,stauts);
    }

    public List<Map> getWrMaWarningbStdGuanList(FxWzArgModel args) throws Exception{
        return wrMaWarningbDao.getWrMaWarningbStdGuanList(args);
    }

    public List<Map> getWrMaWarningbStdYearList(FxWzArgModel args) throws Exception{
        return wrMaWarningbDao.getWrMaWarningbStdYearList(args);
    }

    public Object saveOrUpdateInfo(WrMaWarningbModel model) throws Exception{
        return wrMaWarningbDao.saveOrUpdateInfo(model);
    }

}

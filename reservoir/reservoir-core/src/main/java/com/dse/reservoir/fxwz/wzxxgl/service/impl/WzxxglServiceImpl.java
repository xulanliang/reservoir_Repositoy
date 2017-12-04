package com.dse.reservoir.fxwz.wzxxgl.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wzxxgl.service.WzxxglService;
import com.dse.reservoir.fxwz.wzxxgl.dao.WzxxglDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by pc on 2017-8-3.
 */
@Service("wzxxglService")
@Transactional
public class WzxxglServiceImpl implements WzxxglService {

    @Resource(name="wzxxglDao")
    public WzxxglDao wzxxglDao;

    @Override
    public EasyUiPage getListInfoByParams(String name, String type, EasyUiPage easyUiPage) throws Exception {
        return wzxxglDao.getListInfoByParams(name, type, easyUiPage);
    }

    @Override
    public Object deleteInfoByIds(String ids) throws Exception {
        return wzxxglDao.deleteInfoByIds(ids);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception {
        return wzxxglDao.saveOrUpdateInfo(dataStr);
    }

    @Override
    public Object getInfoById(String id) throws Exception {
        return wzxxglDao.getInfoById(id);
    }

    public EasyUiPage getListWzCkPcBinInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage) throws Exception{
        return wzxxglDao.getListWzCkPcBinInfoByParams(args,easyUiPage);
    }

    @Override
    public EasyUiPage getListWzCkPcBinInfoByParamsNew(FxWzArgModel args, EasyUiPage easyUiPage) throws Exception {
        return wzxxglDao.getListWzCkPcBinInfoByParamsNew(args,easyUiPage);
    }

    public Object getWzCkPcBinInfoById(FxWzArgModel args) throws Exception{
        return wzxxglDao.getWzCkPcBinInfoById(args);
    }

}

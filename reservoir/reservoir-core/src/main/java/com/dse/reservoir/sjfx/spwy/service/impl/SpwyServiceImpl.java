package com.dse.reservoir.sjfx.spwy.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.spwy.service.SpwyService;
import com.dse.reservoir.sjfx.spwy.dao.SpwyDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 水平位移服务层
 */
@Service("spwyService")
@Transactional
public class SpwyServiceImpl implements SpwyService {

    @Resource(name = "spwyDao")
    private SpwyDao spwyDao;

    @Override
    public EasyUiPage getDateList(String stm, String etm,  GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception {
        return spwyDao.getDateList(stm, etm, gcxArgs, easyUiPage);
    }

    /**
     *
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs 参数值
     * @return
     */
    public Object getGcxDateList(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        return spwyDao.getGcxDateList(stm,etm,gcxArgs);
    }

    @Override
    public EasyUiPage getDnpjtzzList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception {
        return spwyDao.getDnpjtzzList(syear, eyear, projcd, easyUiPage);
    }

    @Override
    public EasyUiPage getBaseDataList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception {
        return spwyDao.getBaseDataList(syear, eyear, projcd, easyUiPage);
    }


}

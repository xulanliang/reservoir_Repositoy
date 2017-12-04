package com.dse.reservoir.sjfx.czwy.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.czwy.service.CzwyService;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.sjfx.czwy.dao.CzwyDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 垂直位移服务层
 */
@Service("czwyService")
@Transactional
public class CzwyServiceImpl implements CzwyService {

    @Resource(name = "czwyDao")
    private CzwyDao czwyDao;

    @Override
    public EasyUiPage getDateList(String stm, String etm, GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception {
        return czwyDao.getDateList(stm,etm,gcxArgs,easyUiPage);
    }
    /**
     * 查询垂直位移数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs 参数值
     * @return
     */
    public Object getGcxDateList(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        return czwyDao.getGcxDateList(stm,etm,gcxArgs);
    }


    @Override
    public EasyUiPage getDnpjtzzList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception {
        return czwyDao.getDnpjtzzList(syear, eyear, projcd, easyUiPage);
    }

}

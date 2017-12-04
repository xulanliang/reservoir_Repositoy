package com.dse.reservoir.shouye.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.shouye.service.ShouyeService;
import com.dse.reservoir.shouye.dao.ShouyeDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 首页服务层
 */
@Service("shouyeService")
@Transactional
public class ShouyeServiceImpl implements ShouyeService {

    @Resource(name = "shouyeDao")
    private ShouyeDao shouyeDao;

    @Override
    public EasyUiPage getProject(String projcd, EasyUiPage easyUiPage) throws Exception {
        return shouyeDao.getProject(projcd,easyUiPage);
    }

    @Override
    public EasyUiPage getPoint(String projcd, EasyUiPage easyUiPage) throws Exception {
        return shouyeDao.getPoint(projcd,easyUiPage);
    }

    @Override
    public List<Map<String, Object>> getProjAlarmInfo(Map<String, Object> conditions) throws Exception {
        return shouyeDao.getProjAlarmInfo(conditions);
    }

}

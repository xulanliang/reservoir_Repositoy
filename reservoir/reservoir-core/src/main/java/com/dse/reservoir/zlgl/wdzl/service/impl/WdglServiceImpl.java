package com.dse.reservoir.zlgl.wdzl.service.impl;

import com.dse.reservoir.api.zlgl.wdzl.WdglService;
import com.dse.reservoir.zlgl.wdzl.dao.WdzlDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 许兰良 on 2017/6/21.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Service("wdglService")
@Transactional
public class WdglServiceImpl implements WdglService {

    @Resource(name = "wdzlDao")
    private WdzlDao wdzlDao;

    @Override
    public Object getListBycode(String pcode) throws Exception {
        return wdzlDao.getListBycode(pcode);
    }
}

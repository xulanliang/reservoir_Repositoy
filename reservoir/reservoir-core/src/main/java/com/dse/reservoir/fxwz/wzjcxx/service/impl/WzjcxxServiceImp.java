package com.dse.reservoir.fxwz.wzjcxx.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.wzjcxx.service.WzjcxxService;
import com.dse.reservoir.fxwz.wzjcxx.dao.WzjcxxDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;


/**
 * @Description:物资基础信息
 * @Copyright: Copyright 2016 ShenZhen DSE Software Corporation
 * @Company: 深圳市东深电子股份有限公司
 * @author 刘旭
 * @version 2.0 2016-11-07
 */

@Service("wzjcxxService")
@Transactional
public class WzjcxxServiceImp  implements WzjcxxService {

    @Resource(name="wzjcxxDao")
    public WzjcxxDao wzjcxxDao;


    @Override
    public EasyUiPage getListInfoByParams(String wzname, String wztype, EasyUiPage easyUiPage) {
        return wzjcxxDao.getListInfoByParams(wzname, wztype, easyUiPage);
    }

    @Override
    public Object getInfoById(String wzid) {
        return wzjcxxDao.getInfoById(wzid);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) {
        return wzjcxxDao.saveOrUpdateInfo(dataStr);
    }

    @Override
    public Object deleteInfoByIds(String ids) {
        return wzjcxxDao.deleteInfoByIds(ids);
    }
}
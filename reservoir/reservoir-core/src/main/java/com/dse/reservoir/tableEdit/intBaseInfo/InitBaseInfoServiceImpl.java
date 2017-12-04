package com.dse.reservoir.tableEdit.intBaseInfo;

import com.dse.reservoir.api.tableEdit.initBaseInfo.service.InitBaseInfoService;
import com.dse.reservoir.tableEdit.intBaseInfo.dao.InitBaseInfoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 许兰良 on 2017/7/7.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Service("initBaseInfoServiceImpl")
@Transactional
public class InitBaseInfoServiceImpl implements InitBaseInfoService {
    @Resource(name = "InitBaseInfoDaoI")
    InitBaseInfoDao initBaseInfoDao;
    @Override
    public Object reservoirInfo() {
        return initBaseInfoDao.reservoirInfo();
    }

    @Override
    public Object initSectionInfo() {
        return initBaseInfoDao.initSectionInfo();
    }

    @Override
    public Object initSectionExtendInfo(String string) {
        return initBaseInfoDao.initSectionExtendInfo(string);
    }
    @Override
    public Object initCcxmInfo() {
        return initBaseInfoDao.initCcxmInfo();
    }
}

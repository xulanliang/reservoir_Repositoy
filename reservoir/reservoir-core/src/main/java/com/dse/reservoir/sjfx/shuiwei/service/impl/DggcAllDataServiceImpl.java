package com.dse.reservoir.sjfx.shuiwei.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.shuiwei.service.DggcAllDataService;
import com.dse.reservoir.sjfx.shuiwei.dao.DggcAllDataDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/11/24.
 */
@Service("dggcAllDataService")
@Transactional
public class DggcAllDataServiceImpl implements DggcAllDataService {
    @Resource(name = "dggcAllDataDao")
    private DggcAllDataDao dggcAllDataDao;

    @Override
    public EasyUiPage getDggcAllData(String year, String month, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return dggcAllDataDao.getDggcAllData(tm,projcd,easyUiPage);
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbTJList(String year, String month, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return dggcAllDataDao.getGcjlbTJList(tm,projcd,easyUiPage);
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getjnbbListDg(String type, String year, String season, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(type) && StringUtil.isNotEmpty(year)) {
            String stime = "";
            String etime = "";
            if (type.equals("1")) {
                if (season.equals("1")) {
                    stime = year + "-01-01";
                    etime = year + "-03-31";
                } else if (season.equals("2")) {
                    stime = year + "-04-01";
                    etime = year + "-06-30";
                } else if (season.equals("3")) {
                    stime = year + "-07-01";
                    etime = year + "-09-30";
                } else if (season.equals("4")) {
                    stime = year + "-10-01";
                    etime = year + "-12-31";
                }
            } else if (type.equals("2")) {
                stime = year + "-01-01";
                etime = year + "-12-31";
            }
            return dggcAllDataDao.getjnbbListDg(stime, etime, projcd,easyUiPage);
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getDnpjtzzList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception {
        return dggcAllDataDao.getDnpjtzzList(syear,eyear,projcd,easyUiPage);
    }
}

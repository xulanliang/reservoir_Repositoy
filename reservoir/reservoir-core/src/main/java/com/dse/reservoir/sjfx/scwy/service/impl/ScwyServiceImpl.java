package com.dse.reservoir.sjfx.scwy.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.scwy.service.ScwyService;
import com.dse.reservoir.sjfx.scwy.dao.ScwyDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 深层位移服务层
 */
@Service("scwyService")
@Transactional
public class ScwyServiceImpl implements ScwyService {

    @Resource(name = "scwyDao")
    private ScwyDao scwyDao;

    @Override
    public EasyUiPage getDateList(String stm, String etm,GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception {
        return scwyDao.getDateList(stm, etm, gcxArgs, easyUiPage);
    }

    /**
     *查询深层位移数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs 参数值
     * @return
     */
    public Object getGcxDateList(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        return scwyDao.getGcxDateList(stm, etm, gcxArgs);
    }

    @Override
    public EasyUiPage getDnpjtzzList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception {
        return scwyDao.getDnpjtzzList(syear, eyear, projcd, easyUiPage);
    }

    @Override
    public EasyUiPage getjnbbList(String type, String year, String season, String projcd, EasyUiPage easyUiPage) throws Exception {
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
            return scwyDao.getjnbbList(stime, etime, projcd,easyUiPage);
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbList(String year, String month, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return scwyDao.getGcjlbList(tm, ppcd, projcd, easyUiPage);
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbTJList(String year, String month, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return scwyDao.getGcjlbTJList( tm, ppcd, projcd, easyUiPage);
        }
        return null;
    }

}

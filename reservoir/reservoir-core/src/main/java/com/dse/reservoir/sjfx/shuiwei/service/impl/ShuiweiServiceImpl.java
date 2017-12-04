package com.dse.reservoir.sjfx.shuiwei.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.shuiwei.service.ShuiweiService;
import com.dse.reservoir.sjfx.shuiwei.dao.ShuiweiDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 水位服务层
 */
@Service("shuiweiService")
@Transactional
public class ShuiweiServiceImpl implements ShuiweiService {

    @Resource(name = "shuiweiDao")
    private ShuiweiDao shuiweiDao;

    @Override
    public EasyUiPage getDateList(String stm, String etm, GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception {
        return shuiweiDao.getDateList(stm, etm, gcxArgs, easyUiPage);
    }

    /**
     *查询水位数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs 参数值
     * @return
     */
    public Object getGcxDateList(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        return shuiweiDao.getGcxDateList(stm, etm, gcxArgs);
    }

    @Override
    public EasyUiPage getDnpjtzzList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception {
        return shuiweiDao.getDnpjtzzList(syear, eyear, projcd, easyUiPage);
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
            return shuiweiDao.getjnbbList(stime, etime, projcd,easyUiPage);
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
            return shuiweiDao.getGcjlbList(tm, ppcd, projcd, easyUiPage);
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
            return shuiweiDao.getGcjlbTJList( tm, ppcd, projcd, easyUiPage);
        }
        return null;
    }

}

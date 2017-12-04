package com.dse.reservoir.sjfx.shenLiu.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.shenLiu.service.ShenLiuService;
import com.dse.reservoir.sjfx.shenLiu.dao.ShenLiuDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 渗流服务层
 * Created by  on 2017/6/8.
 */
@Service("shenLiuService")
@Transactional
public class ShenLiuServiceImpl implements ShenLiuService{

    @Resource(name = "shenLiuDao")
    private ShenLiuDao shenLiuDao;

    @Override
    public EasyUiPage getDateList(String stm, String etm, GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception {
        return shenLiuDao.getDateList(stm, etm,gcxArgs, easyUiPage);
    }

    /**
     * 查询渗流数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs
     * @return
     */
    public Object getGcxDateList(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        return shenLiuDao.getGcxDateList(stm, etm, gcxArgs);
    }

    @Override
    public EasyUiPage getBaseDataList(String year, String month, String ppcd, String projcd,EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return shenLiuDao.getBaseDataList(tm,ppcd,projcd,easyUiPage);
        }
        return easyUiPage;
    }


    @Override
    public EasyUiPage getCountDataList(String year, String month, String ppcd, String projcd,EasyUiPage easyUiPage) throws Exception{
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return shenLiuDao.getCountDataList(tm, ppcd,projcd,easyUiPage);
        }
        return easyUiPage;
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
            return shenLiuDao.getjnbbList(stime, etime, projcd,easyUiPage);
        }
        return easyUiPage;
    }
}

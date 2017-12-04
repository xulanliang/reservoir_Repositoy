package com.dse.reservoir.sjfx.shenya.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.pojo.entity.WrrbmEntity;
import com.dse.reservoir.api.sjfx.shenya.service.ShenyaService;
import com.dse.reservoir.api.sjfx.swqx.service.SwqxService;
import com.dse.reservoir.sjfx.shenya.dao.ShenyaDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 渗压服务层
 */
@Service("shenyaService")
@Transactional
public class ShenyaServiceImpl implements ShenyaService {

    @Resource(name = "shenyaDao")
    private ShenyaDao shenyaDao;

    @Override
    public Object getProject(String projcd) throws Exception {
        return shenyaDao.getProject(projcd);
    }

    @Override
    public Object getDmID(String projcd, String st_tp) throws Exception {
        return shenyaDao.getDmID(projcd,st_tp);
    }

    @Override
    public Object getRb(WrrbmEntity args) throws Exception {
        return shenyaDao.getRb(args);
    }

    @Override
    public Object getPoint(String projcd,String type) throws Exception {
        return shenyaDao.getPoint(projcd,type);
    }

    @Override
    public Object getPointByRb(String rbcd) throws Exception {
        return shenyaDao.getPointByRb(rbcd);
    }

    @Override
    public Object getColByIds(List list) throws Exception {
        return shenyaDao.getColByIds(list);
    }

    @Override
    public EasyUiPage getDateList(String stm, String etm,  GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception {
        return shenyaDao.getDateList(stm,etm,gcxArgs,easyUiPage);
    }

    /**
     *
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs 参数值
     * @return
     */
    public Object getGcxDateList(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        return shenyaDao.getGcxDateList(stm,etm,gcxArgs);
    }

    @Override
    public EasyUiPage getjnbbList(String type, String year, String season, String rbcd,List list, EasyUiPage easyUiPage) throws Exception {
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
            return shenyaDao.getjnbbList(stime, etime, rbcd,list,easyUiPage);
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
            return shenyaDao.getjnbbListDg(stime, etime, projcd,easyUiPage);
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getSytzzbbList(String year, String month, String ppcd, String rbcd,List list, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return shenyaDao.getSytzzbbList(tm, ppcd, rbcd,list, easyUiPage);
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getSytzzbbListDg(String year, String month, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return shenyaDao.getSytzzbbListDg(tm, ppcd, projcd, easyUiPage);
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbList(String year, String month, String ppcd, String rbcd, List list, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return shenyaDao.getGcjlbList(tm, ppcd, rbcd,list, easyUiPage);
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbListDg(String year, String month, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return shenyaDao.getGcjlbListDg(tm, ppcd, projcd, easyUiPage);
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbTJList(String year, String month, String ppcd, String rbcd,List list, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return shenyaDao.getGcjlbTJList( tm, ppcd, rbcd,list, easyUiPage);
        }
        return null;
    }

    @Override
    public EasyUiPage getGcjlbTJListDg(String year, String month, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return shenyaDao.getGcjlbTJListDg( tm, ppcd, projcd, easyUiPage);
        }
        return null;
    }

}

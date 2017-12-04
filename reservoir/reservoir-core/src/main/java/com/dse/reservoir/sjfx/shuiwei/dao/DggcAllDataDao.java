package com.dse.reservoir.sjfx.shuiwei.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;

/**
 * Created by Administrator on 2017/11/24.
 */
public interface DggcAllDataDao extends IBaseDao {
    public EasyUiPage getDggcAllData(String tm, String projcd, EasyUiPage easyUiPage) throws Exception;

    public EasyUiPage getGcjlbTJList(String tm, String projcd, EasyUiPage easyUiPage) throws Exception;

    public EasyUiPage getjnbbListDg(String stime,String  etime,String projcd,EasyUiPage easyUiPage) throws Exception;

    public EasyUiPage getDnpjtzzList(String syear,String eyear,String projcd,EasyUiPage easyUiPage) throws Exception;
}

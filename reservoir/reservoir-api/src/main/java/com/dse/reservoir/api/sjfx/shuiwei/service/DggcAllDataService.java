package com.dse.reservoir.api.sjfx.shuiwei.service;

import com.dse.common.entity.EasyUiPage;

/**
 * Created by Administrator on 2017/11/24.
 */
public interface DggcAllDataService {
    public EasyUiPage getDggcAllData(String year, String month, String projcd,  EasyUiPage easyUiPage) throws Exception;

    public EasyUiPage getGcjlbTJList(String year, String month, String projcd,  EasyUiPage easyUiPage) throws Exception;

    public EasyUiPage getjnbbListDg(String type,String year,String season,String projcd,EasyUiPage easyUiPage) throws Exception;

    public EasyUiPage getDnpjtzzList(String syear,String eyear,String projcd,EasyUiPage easyUiPage) throws Exception;
}

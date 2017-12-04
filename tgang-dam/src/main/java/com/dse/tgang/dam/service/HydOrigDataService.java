package com.dse.tgang.dam.service;

import java.util.Map;

/**
 * Created by Administrator on 2017/1/13.
 */
public interface HydOrigDataService {

    //查询
    public Object queryCdbhjSysw(Map<String, String> dataMap);

    //更新
    public Boolean updateCdbhjSysw(Map<String, String> dataMap);

    //保存
    public Boolean saveCdbhjSysw(Map<String, String> dataMap);

}

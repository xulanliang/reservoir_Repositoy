package com.dse.reservoir.api.shouye.service;

import com.dse.common.entity.EasyUiPage;

import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2017-7-7.
 */
public interface ShouyeService {

    /**
     * 获取子项目
     * @param projcd 一级工程ID
     * @return
     */
    public EasyUiPage getProject(String projcd,EasyUiPage easyUiPage) throws Exception;

    /**
     * 获取测点
     * @param projcd 工程ID
     * @return
     */
    public EasyUiPage getPoint(String projcd,EasyUiPage easyUiPage) throws Exception;

    /**
     *  获取各个工程的报警数量信息
     * @param conditions
     * @return
     * @throws Exception
     */
    public List<Map<String,Object>> getProjAlarmInfo(Map<String,Object> conditions) throws  Exception;

}

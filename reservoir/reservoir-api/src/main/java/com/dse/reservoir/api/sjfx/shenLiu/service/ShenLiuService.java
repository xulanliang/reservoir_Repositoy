package com.dse.reservoir.api.sjfx.shenLiu.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;

/**
 *
 * Created by   on 2017/6/8.
 */
public interface ShenLiuService {

    /**
     * 查询渗流数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param  GcxEntity gcxArgs 项目ID
     * @return
     */
    public EasyUiPage getDateList(String stm, String etm,  GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询渗流数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs 项目ID
     * @return
     */
    public Object getGcxDateList(String stm, String etm, GcxEntity gcxArgs) throws Exception;


    /**
     * 查询渗流观测记录表基础数据
     * @param year 年份
     * @param month 月份
     * @param ppcd 一级项目ID
     * @param projcd 二级项目ID
     * @return
     */
    public EasyUiPage getBaseDataList(String year, String month, String ppcd, String projcd,EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询渗流观测记录表统计数据
     * @param year 年份
     * @param month 月份
     * @param ppcd 一级项目ID
     * @param projcd 二级项目ID
     * @return
     */
    public EasyUiPage getCountDataList(String year,String month, String ppcd, String projcd,EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询渗流季（年）报表数据
     * @param type 类型
     * @param year 年份
     * @param season 季度
     * @param projcd 二级项目ID
     * @return
     */
    public EasyUiPage getjnbbList(String type, String year, String season, String projcd, EasyUiPage easyUiPage) throws Exception;

}

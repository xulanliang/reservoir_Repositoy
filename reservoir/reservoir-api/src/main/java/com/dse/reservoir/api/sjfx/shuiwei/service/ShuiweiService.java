package com.dse.reservoir.api.sjfx.shuiwei.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;

/**
 * Created by pc on 2017-6-19.
 */
public interface ShuiweiService {

    /**
     * 查询水位数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param stnm 测点名称
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getDateList(String stm, String etm,  GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception;

    /**
     *查询水位数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs 参数值
     * @return
     */
    public Object getGcxDateList(String stm, String etm, GcxEntity gcxArgs) throws Exception;

    /**
     * 多年平均特征值数据
     * @param syear 开始年份
     * @param eyear 结束月份
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getDnpjtzzList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询季（年）报表数据
     * @param type 类型
     * @param year 年份
     * @param season 季度
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getjnbbList(String type, String year, String season, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象观测记录表数据
     * @param year 年份
     * @param month 月份
     * @param ppcd 一级项目ID
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getGcjlbList(String year, String month, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象观测记录表统计数据
     * @param year 年份
     * @param month 月份
     * @param ppcd 一级项目ID
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getGcjlbTJList(String year, String month, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception;

}

package com.dse.reservoir.api.sjfx.swqx.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;

/**
 * Created by pc on 2017-6-1.
 */
public interface SwqxService {

    /**
     * 获取时间下拉
     * @return
     */
    public Object getYear() throws Exception;

    /**
     * 获取左侧菜单树
     * @return
     */
    public Object getTree() throws Exception;

    /**
     * 获取左侧菜单树
     * @return
     */
    public Object getWrwarningTree() throws Exception;



    /**
     * 查询水文气象数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getQxDate(String stm, String etm, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水位数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getSwDate(String stm, String etm, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水位数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs
     * @return
     */
    public Object getGcxSwDate(String stm, String etm, GcxEntity gcxArgs) throws Exception;

    
    /**
     * 查询雨量数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getYlDate(String stm, String etm, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询雨量数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs
     * @return
     */
    public Object getGcxYlDate(String stm, String etm, GcxEntity gcxArgs) throws Exception;

    /**
     * 查询气温气压数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getQwqyDate(String stm, String etm, String projcd, EasyUiPage easyUiPage) throws Exception;


    /**
     * 查询气温气压数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs
     * @return
     */
    public Object getGcxQwqyDate(String stm, String etm, GcxEntity gcxArgs) throws Exception;

    /**
     * 查询水文气象季（年）报表数据
     * @param type 类型
     * @param year 年份
     * @param season 季度
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getjnbbList(String type, String year, String season, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象水位特征值数据
     * @param syear 开始年份
     * @param eyear 结束年份
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getSwtzzbbList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象雨量特征值数据
     * @param syear 开始年份
     * @param eyear 结束年份
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getYltzzbbList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象气温特征值数据
     * @param syear 开始年份
     * @param eyear 结束年份
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getQwtzzbbList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象观测记录表数据
     * @param year 年份
     * @param month 月份
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getGcjlbList(String year, String month, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象观测记录表统计数据
     * @param year 年份
     * @param month 月份
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getGcjlbTJList(String year, String month, String projcd, EasyUiPage easyUiPage) throws Exception;

}

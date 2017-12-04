package com.dse.reservoir.sjfx.dccj.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;

/**
 * Created by pc on 2017-6-16.
 */
public interface DccjDao extends IBaseDao {

    /**
     * 查询渡槽数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param  GcxEntity gcxArgs 测点名称
     * @param  GcxEntity gcxArgs 项目ID
     * @return
     */
    public EasyUiPage getDateList(String stm, String etm,  GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception;

    /**
     *查询渡槽数据
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
     * @param stime 开始时间
     * @param etime 结束时间
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getjnbbList(String stime, String etime, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象观测记录表数据
     * @param tm 时间
     * @param ppcd 一级项目ID
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getGcjlbList(String tm, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象观测记录表统计数据
     * @param tm 时间
     * @param ppcd 一级项目ID
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getGcjlbTJList(String tm, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception;

}

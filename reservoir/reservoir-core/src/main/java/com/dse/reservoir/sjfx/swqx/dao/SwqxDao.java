package com.dse.reservoir.sjfx.swqx.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2017-6-1.
 */
public interface SwqxDao extends IBaseDao {

    /**
     * 获取左侧菜单树
     * @return
     */
    public List<Map> getTree() throws Exception;

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
     * 获取对应的水位STCD
     * @param projcd 项目ID
     * @return
     */
    public String getSwStcd(String projcd) throws Exception;

    /**
     * 获取对应的雨量STCD
     * @param projcd 项目ID
     * @return
     */
    public String getYlStcd(String projcd) throws Exception;

    /**
     * 获取对应的气温，气压STCD
     * @param projcd 项目ID
     * @return
     */
    public String getQwStcd(String projcd) throws Exception;

    /**
     * 查询水文气象季（年）报表数据
     * @param stime 开始时间
     * @param etime 结束时间
     * @param swstcd 水位编码
     * @param ylstcd 雨量编码
     * @param qwstcd 气温，气压编码
     * @return
     */
    public EasyUiPage getjnbbList(String stime, String etime, String swstcd, String ylstcd, String qwstcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象水位特征值数据
     * @param syear 开始年份
     * @param eyear 结束年份
     * @param stcd 编码
     * @return
     */
    public EasyUiPage getSwtzzbbList(String syear, String eyear, String stcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象雨量特征值数据
     * @param syear 开始年份
     * @param eyear 结束年份
     * @param stcd 编码
     * @return
     */
    public EasyUiPage getYltzzbbList(String syear, String eyear, String stcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象气温特征值数据
     * @param syear 开始年份
     * @param eyear 结束年份
     * @param stcd 编码
     * @return
     */
    public EasyUiPage getQwtzzbbList(String syear, String eyear, String stcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象观测记录表数据
     * @param tm 时间
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getGcjlbList(String tm, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询水文气象观测记录表统计数据
     * @param tm 时间
     * @param projcd 项目ID
     * @return
     */
    public EasyUiPage getGcjlbTJList(String tm, String projcd, EasyUiPage easyUiPage) throws Exception;

}

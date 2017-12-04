package com.dse.reservoir.api.sjfx.shenya.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.pojo.entity.WrrbmEntity;

import java.util.List;

/**
 * Created by pc on 2017-6-8.
 */
public interface ShenyaService {

    /**
     * 获取子项目
     * @param projcd 一级工程ID
     * @return
     */
    public Object getProject(String projcd) throws Exception;

    /**
     * 获取断面ID
     * @param projcd
     * @param st_tp
     * @return
     * @throws Exception
     */
    public Object getDmID(String projcd,String st_tp) throws Exception;

    /**
     * 获取断面
     * @param args 二级工程ID
     * @return
     */
    public Object getRb(WrrbmEntity args) throws Exception;

    /**
     * 获取测点
     * @param projcd 工程ID
     * @param type 测点类型
     * @return
     */
    public Object getPoint(String projcd,String type) throws Exception;

    /**
     * 获取测点
     * @param rbcd 断面编号
     * @return
     */
    public Object getPointByRb(String rbcd) throws Exception;


    /**
     * 获取测点
     * @param list 断面ID
     * @return
     * @throws Exception
     */
    public Object getColByIds(List list) throws Exception;

    /**
     * 查询渗压数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param  GcxEntity gcxArgs 测点名称
     * @param  GcxEntity gcxArgs 项目ID
     * @return
     */
    public EasyUiPage getDateList(String stm, String etm, GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception;

    /**
     *
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs 参数值
     * @return
     */
    public Object getGcxDateList(String stm, String etm, GcxEntity gcxArgs) throws Exception;


    /**
     * 查询渗压季（年）报表数据
     * @param type 类型
     * @param year 年份
     * @param season 季度
     * @param rbcd 断面编号
     * @return
     */
    public EasyUiPage getjnbbList(String type, String year, String season, String rbcd,List list, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询渗压季（年）报表数据
     * @param type 类型
     * @param year 年份
     * @param season 季度
     * @param projcd 项目编号
     * @return
     */
    public EasyUiPage getjnbbListDg(String type, String year, String season, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询渗压特征值数据
     * @param year 年份
     * @param month 月份
     * @param ppcd 一级项目ID
     * @param rbcd 断面编号
     * @return
     */
    public EasyUiPage getSytzzbbList(String year, String month, String ppcd, String rbcd,List list, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询渗压特征值数据
     * @param year 年份
     * @param month 月份
     * @param ppcd 一级项目ID
     * @param projcd 二级项目编号
     * @return
     */
    public EasyUiPage getSytzzbbListDg(String year, String month, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询渗压观测记录表数据
     * @param year 年份
     * @param month 月份
     * @param ppcd 一级项目ID
     * @param rbcd 断面编号
     * @return
     */
    public EasyUiPage getGcjlbList(String year, String month, String ppcd, String rbcd, List list, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询渗压观测记录表数据
     * @param year 年份
     * @param month 月份
     * @param ppcd 一级项目ID
     * @param projcd 二级项目编号
     * @return
     */
    public EasyUiPage getGcjlbListDg(String year, String month, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询渗压观测记录表统计数据
     * @param year 年份
     * @param month 月份
     * @param ppcd 一级项目ID
     * @param rbcd 断面编号
     * @return
     */
    public EasyUiPage getGcjlbTJList(String year, String month, String ppcd, String rbcd,List list, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询渗压观测记录表统计数据
     * @param year 年份
     * @param month 月份
     * @param ppcd 一级项目ID
     * @param projcd 二级项目编号
     * @return
     */
    public EasyUiPage getGcjlbTJListDg(String year, String month, String ppcd, String projcd, EasyUiPage easyUiPage) throws Exception;

}

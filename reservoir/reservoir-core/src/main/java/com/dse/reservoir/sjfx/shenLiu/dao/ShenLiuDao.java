package com.dse.reservoir.sjfx.shenLiu.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;


public interface ShenLiuDao extends IBaseDao {

    /**
     * 查询渗流数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param  GcxEntity gcxArgs 项目ID
     * @return
     */
    public EasyUiPage getDateList(String stm, String etm, GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception;

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
     * @param tm 时间
     * @param ppcd 一级项目ID
     * @param projcd 断面编号
     * @return
     */
    public EasyUiPage getBaseDataList(String tm,String ppcd,String projcd,EasyUiPage easyUiPage) throws Exception;

   /**
     * 查询渗流观测记录表统计数据
     * @param tm 时间
     * @param ppcd 一级项目ID
     * @param projcd 断面编号
     * @return
     */
    public EasyUiPage getCountDataList(String tm,String ppcd,String projcd,EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询渗流季（年）报表数据
     * @param stime 开始时间
     * @param etime 结束时间
     * @param projcd 断面编号
     * @return
     */
    public EasyUiPage getjnbbList(String stime, String etime, String projcd,EasyUiPage easyUiPage) throws Exception;


}

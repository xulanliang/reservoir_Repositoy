package com.dse.reservoir.sjfx.czwy.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;

/**
 * Created by pc on 2017-6-13.
 */
public interface CzwyDao extends IBaseDao {

    /**
     * 查询垂直位移数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param GcxEntity gcxArgs 项目ID
     * @return
     */
    public EasyUiPage getDateList(String stm, String etm, GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception;

    /**
     * 查询垂直位移数据
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

}

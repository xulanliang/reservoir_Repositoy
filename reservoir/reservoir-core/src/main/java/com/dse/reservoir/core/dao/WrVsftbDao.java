package com.dse.reservoir.core.dao;


import com.dse.common.dao.IBaseDao;
import com.dse.reservoir.api.pojo.entity.WrVsftb;
import java.util.List;
import java.util.Map;


/**
 * 用于记录垂直位置监测信息表(垂直位置监测信息表)数据信息
 * Created by pengzx on 2017/5/26.
 */
public interface WrVsftbDao extends IBaseDao<WrVsftb, String> {

    /**
     * 查询垂直位置监测信息数据
     *
     * @param stcd 测点编号
     * @param tm       时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    List getWrVsftbData(String stcd, String tm) throws Exception;


    /**
     * 查询垂直位置监测信息数据
     *
     * @param stcd     测点编号
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    List<Map> getChartData(String stcd, String stm, String etm) throws Exception;

}
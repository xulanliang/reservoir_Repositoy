package com.dse.reservoir.sjfx.swqx.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;

import java.util.List;
import java.util.Map;

/**
 * 用于获取过程线数据信息
 * Created by pengzx on 2017/6/2.
 */
public interface GcxDao extends IBaseDao {

    /**
     * 查询 水库水情表 监测信息数据
     *
     * @param GcxEntity gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    public Object getStRsvrrChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception;

    /**
     * 查询 水库水情表 监测信息数据
     *
     * @param GcxEntity gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    public Object getStRsvrrChartDataMaxMin(GcxEntity gcxArgs, String stm, String etm) throws Exception;

    /**
     * 查询 降水量表 监测信息数据
     *
     * @param GcxEntity gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    public Object  getStPptnrChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception;

    /**
     * 查询 气温气压表 监测信息数据
     *
     * @param GcxEntity gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    public Object  getStTmprChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception;


    /**
     * 查询 渗压过程线 监测信息数据
     *
     * @param GcxEntity gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    public Object  getShenYaGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception ;

    /**
     * 查询 渗压过程线 监测信息数据
     *
     * @param GcxEntity gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    public Object  getShenLiuGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception;

    /**
     * 查询 水平位移监测数据表 监测信息数据
     *
     * @param GcxEntity gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年06月17日
     */
    public Object  getSpwyZxfbtGcxChartData(GcxEntity gcxArgs, String year, String endYear,String season) throws Exception ;

    /**
     * 查询 水平位移监测数据表 监测信息数据
     *
     * @param GcxEntity gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年06月17日
     */
    public Object  getSpwyGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception ;

    /**
     * 查询  垂直位移监测信息表 监测信息数据
     *
     * @param GcxEntity gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年06月17日
     */
    public Object  getCzwyZxfbtGcxChartData(GcxEntity gcxArgs, String stm, String etm, String season) throws Exception ;

    /**
     * 查询 垂直位移监测信息表 监测信息数据
     *
     * @param GcxEntity gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年06月17日
     */
    public Object  getCzwyGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception ;


    /**
     * 查询 WR_SW_R 水位表 监测信息数据
     *
     * @param GcxEntity gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询 WR_SW_R 水位表 结果集
     * @author pengzx
     * @date 2017年06月19日
     */
    public Object  getWrswrGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception;

    /**
     * 查询 WR_MSFT_B 多点位移监测信息表 监测信息数据
     *
     * @param GcxEntity gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询 WR_MSFT_B 多点位移监测信息表 结果集
     * @author pengzx
     * @date 2017年06月20日
     */
    public Object  getWrmsftbGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception;

    /**
     * 查询 WR_CSFT_B 渡槽沉降监测信息表 监测信息数据
     *
     * @param GcxEntity gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询 WR_CSFT_B 渡槽沉降监测信息表 结果集
     * @author pengzx
     * @date 2017年06月20日
     */
    public Object  getWrcsftbGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception;

}

package com.dse.reservoir.sjfx.swqx.service.impl;

import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.swqx.service.GcxService;
import com.dse.reservoir.sjfx.swqx.dao.GcxDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用于获取过程线数据信息
 * Created by pengzx on 2017/6/2.
 */
@Service("gcxService")
@Transactional
public class GcxServiceImpl implements GcxService {

    @Resource(name="gcxDao")
    public GcxDao gcxDao;
    @Override
    public Object getStRsvrrChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        List<Map> dataMap= (List<Map>) gcxDao.getStRsvrrChartData(gcxArgs,stm,etm);

        return dataMap;
    }

    /**
     * 查询 水库水情表 监测信息数据
     *
     * @param gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    public Object getStRsvrrChartDataMaxMin(GcxEntity gcxArgs, String stm, String etm) throws Exception{
        List<Map> dataMap= (List<Map>) gcxDao.getStRsvrrChartDataMaxMin(gcxArgs,stm,etm);

        return dataMap;
    }

    @Override
    public Object getStPptnrChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        List<Map> dataMap = (List<Map>)gcxDao.getStPptnrChartData(gcxArgs, stm, etm);
        return dataMap;
    }

    @Override
    public Object getStTmprChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        List<Map> dataMap=(List<Map>)gcxDao.getStTmprChartData(gcxArgs,stm,etm);
        return dataMap;
    }

    /**
     * 查询 渗压过程线 监测信息数据
     *
     * @param gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    public Object  getShenYaGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        List<Map> dataMap=(List<Map>)gcxDao.getShenYaGcxChartData(gcxArgs,stm,etm);
        return dataMap;
    }

    /**
     * 查询 渗压过程线 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    public Object  getShenLiuGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception{
        List<Map> dataMap=(List<Map>)gcxDao.getShenLiuGcxChartData(gcxArgs,stm,etm);
        return dataMap;
    }

    /**
     * 查询 水平位移监测数据表 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年06月17日
     */
    public Object getSpwyZxfbtGcxChartData(GcxEntity gcxArgs, String year,String endyear, String season) throws Exception {

        List<Map> dataMap=(List<Map>)gcxDao.getSpwyZxfbtGcxChartData(gcxArgs,year,endyear,season);
        return dataMap;
    }

    /**
     * 查询 水平位移监测数据表 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年06月17日
     */
    public Object  getSpwyGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception{
        List<Map> dataMap=(List<Map>)gcxDao.getSpwyGcxChartData(gcxArgs,stm,etm);
        return dataMap;
    }

    /**
     * 查询  垂直位移监测信息表 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年06月17日
     */
    public Object  getCzwyZxfbtGcxChartData(GcxEntity gcxArgs, String stm, String etm, String season) throws Exception{
        List<Map> dataMap=(List<Map>)gcxDao.getCzwyZxfbtGcxChartData(gcxArgs,stm,etm,season);
        return dataMap;
    }

    /**
     * 查询 垂直位移监测信息表 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年06月17日
     */
    public Object  getCzwyGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        List<Map> dataMap=(List<Map>)gcxDao.getCzwyGcxChartData(gcxArgs,stm,etm);
        return dataMap;
    }

    /**
     * 查询 WR_SW_R 水位表 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询 WR_SW_R 水位表 结果集
     * @author pengzx
     * @date 2017年06月19日
     */
    public Object  getWrswrGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        List<Map> dataMap=(List<Map>)gcxDao.getWrswrGcxChartData(gcxArgs,stm,etm);
        return dataMap;
    }

    /**
     * 查询 WR_MSFT_B 多点位移监测信息表 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询 WR_MSFT_B 多点位移监测信息表 结果集
     * @author pengzx
     * @date 2017年06月20日
     */
    public Object  getWrmsftbGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception{
        List<Map> dataMap=(List<Map>)gcxDao.getWrmsftbGcxChartData(gcxArgs,stm,etm);
        return dataMap;
    }

    /**
     * 查询 WR_CSFT_B 渡槽沉降监测信息表 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询 WR_CSFT_B 渡槽沉降监测信息表 结果集
     * @author pengzx
     * @date 2017年06月20日
     */
    public Object  getWrcsftbGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception{
        List<Map> dataMap=(List<Map>)gcxDao.getWrcsftbGcxChartData(gcxArgs,stm,etm);
        return dataMap;
    }


}

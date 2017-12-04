package com.dse.reservoir.api.sjfx.shenya.service;


import com.dse.reservoir.api.sjfx.pojo.entity.WrrbmEntity;

/**
 * 用于获取过程线数据信息
 * Created by pengzx on 2017/6/2.
 */
public interface WrrbmService {

    /**
     * 查询 水库水情表 监测信息数据
     *
     * @param  args
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年06月06日
     */
   public Object getWrrbmListData(WrrbmEntity args) throws Exception;

}

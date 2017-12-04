package com.dse.reservoir.sjfx.shenya.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.reservoir.api.sjfx.pojo.entity.WrrbmEntity;

import java.util.Map;

/**
 * 用于获取过程线数据信息
 * Created by pengzx on 2017/6/2.
 */
public interface WrrbmDao extends IBaseDao {

    /**
     * 查询
     *
     * @param args
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    public Object getWrrbmListData(WrrbmEntity args) throws Exception;


    Object getPointsByRb(Map<String,Object> queryMap) throws Exception ;


}

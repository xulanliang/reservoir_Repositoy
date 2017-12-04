package com.dse.reservoir.fzjc.dao;

import com.dse.common.dao.IBaseDao;

import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @date 2017-10-26
 */
public interface IFzjcDao extends IBaseDao {

    /**
     * 获取测点的 因子表达式 及 回归系数
     * @param queryMap
     * @return
     */
    Object getModeParam(Map<String,Object> queryMap) ;

    Object getRSVRList (Map<String, Object> queryMap);

    Object getPPTNList(Map<String, Object> queryMap);

    Object getTMPList (Map<String, Object> queryMap);

    Object getDataList(String tableName,Map<String,Object> columnMap,Map<String,Object> conditionMap);

    Object getStatsModeData(Map<String,Object> conditionMap);

}

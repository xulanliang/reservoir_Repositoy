package com.dse.reservoir.api.fzjc;

import java.util.Map;

/**
 * 辅助决策service
 *
 * @author
 * @date 2017-10-25
 */
public interface IFzjcService {
    /**
     * 获取左侧菜单树
     * @return
     */
    public Object getTree() throws Exception;

    /**
     * 根据断面获取测点
     * @param queryMap
     * @return
     * @throws Exception
     */
     Object getPointsByRb(Map<String,Object> queryMap) throws Exception;

     Object getShenYaStatsData(Map<String,Object> queryMap) ;

     Object getShenLiuStatsData(Map<String,Object> queryMap) ;

//     Object getRSVRList(Map<String,Object> queryMap);

}

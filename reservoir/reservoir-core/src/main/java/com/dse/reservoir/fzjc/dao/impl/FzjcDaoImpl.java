package com.dse.reservoir.fzjc.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.reservoir.api.util.Utility;
import com.dse.reservoir.fzjc.dao.IFzjcDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @date 2017-10-26
 */
@Repository("fzjcDao")
public class FzjcDaoImpl extends BaseDao implements IFzjcDao {

    @Override
    public Object getModeParam(Map<String, Object> queryMap) {

        if(Utility.isEmpty(queryMap) || !queryMap.containsKey("stcd") || !queryMap.containsKey("st_tp")){
            return null;
        }
        Map<String,Object> params = new HashMap<>();
        StringBuilder querySql = new StringBuilder() ;
        /*querySql.append(" SELECT t1.*, t2.stcd, t2.coefficent ")
                .append(" from WR_STATS_MODE_FACTOR t1")
                .append(" left join WR_STATS_MODE_COEFFICENT t2 ")
                .append(" on t1.factor_id = t2.factor_id")
                .append(" where t2.stcd = :stcd ")
                .append(" and t1.st_tp = :st_tp")
                .append(" ");*/
        querySql.append(" select t.* from WR_STATS_MODE_R T")
                .append( " where 1=1 and t.stcd = :stcd ")
                .append( " and t.st_tp = :st_tp ")
                .append( "");
        params.put("stcd",queryMap.get("stcd"));
        params.put("st_tp",queryMap.get("st_tp"));

        return findBySqlWithMap(querySql.toString(),params);
    }

    @Override
    public Object getRSVRList (Map<String, Object> queryMap){

        if(Utility.isEmpty(queryMap) || !queryMap.containsKey("stcd") || !queryMap.containsKey("stm") || !queryMap.containsKey("etm") ){
            return null;
        }
        Map<String,Object> params = new HashMap<>();
        StringBuilder querySql = new StringBuilder();
        querySql.append(" select t.tm as KEY, t.RZ as value from   ST_RSVR_R   t ")
                .append(" where t.stcd =:stcd " )
                .append(" and to_char(t.tm,'yyyy-mm-dd') >= :stm " )
                .append(" and to_char(t.tm,'yyyy-mm-dd') <= :etm  " )
                .append(" " );

        params.put("stcd",queryMap.get("stcd"));
        params.put("stm",queryMap.get("stm"));
        params.put("etm",queryMap.get("etm"));
        return findBySqlWithMap(querySql.toString(),params) ;
    }

    @Override
    public Object getPPTNList(Map<String, Object> queryMap){
        if(Utility.isEmpty(queryMap) || !queryMap.containsKey("stcd") || !queryMap.containsKey("stm") || !queryMap.containsKey("etm") ){
            return null;
        }
        Map<String,Object> params = new HashMap<>();
        StringBuilder querySql = new StringBuilder();
        querySql.append(" select t.tm as KEY , t.DYP as VALUE from   ST_PPTN_R   t ")
                .append(" where t.stcd =:stcd " )
                .append(" and to_char(t.tm,'yyyy-mm-dd') >= :stm " )
                .append(" and to_char(t.tm,'yyyy-mm-dd') <= :etm  " )
                .append(" " );

        params.put("stcd",queryMap.get("stcd"));
        params.put("stm",queryMap.get("stm"));
        params.put("etm",queryMap.get("etm"));
        return findBySqlWithMap(querySql.toString(),params) ;
    }

    @Override
    public Object getTMPList (Map<String, Object> queryMap){
        if(Utility.isEmpty(queryMap) || !queryMap.containsKey("stcd") || !queryMap.containsKey("stm") || !queryMap.containsKey("etm") ){
            return null;
        }
        Map<String,Object> params = new HashMap<>();
        StringBuilder querySql = new StringBuilder();
        querySql.append(" select t.tm as KEY , t.ATMP as VALUE from   ST_TMP_R   t ")
                .append(" where t.stcd =:stcd " )
                .append(" and to_char(t.tm,'yyyy-mm-dd') >= :stm " )
                .append(" and to_char(t.tm,'yyyy-mm-dd') <= :etm  " )
                .append(" " );

        params.put("stcd",queryMap.get("stcd"));
        params.put("stm",queryMap.get("stm"));
        params.put("etm",queryMap.get("etm"));
        return findBySqlWithMap(querySql.toString(),params) ;
    }

    @Override
    public Object getDataList(String tableName,Map<String,Object> columnMap,Map<String,Object> conditionMap){
        StringBuilder querySql = new StringBuilder();
        Map<String,Object> params = new HashMap<>();
        querySql.append(" select ");
        Iterator<Map.Entry<String,Object>> columnIterator = columnMap.entrySet().iterator();
        while (columnIterator.hasNext()){
            Map.Entry<String, Object> entry = columnIterator.next();
            querySql.append(entry.getKey()).append(" as ").append(entry.getValue()).append(", ");
        }
        querySql.deleteCharAt(querySql.lastIndexOf(","));
        querySql.append(" from ")
                .append(tableName)
                .append(" t where 1=1 ");

        Iterator<Map.Entry<String,Object>> condIterator = conditionMap.entrySet().iterator();
        while (condIterator.hasNext()){
            Map.Entry<String, Object> entry = condIterator.next();
            if("t.stm".equalsIgnoreCase(entry.getKey())){
                querySql.append(" and to_char(t.tm,'yyyy-mm-dd') >= :").append(entry.getKey());
                params.put(entry.getKey(),entry.getValue());
                continue;
            }
            if("t.etm".equalsIgnoreCase(entry.getKey())){
                querySql.append(" and to_char(t.tm,'yyyy-mm-dd') <= :").append(entry.getKey());
                params.put(entry.getKey(),entry.getValue());
                continue;
            }
            querySql.append(" and ").append(entry.getKey()).append("= :").append(entry.getKey());
            params.put(entry.getKey(),entry.getValue());
        }
        querySql.append(" order by t.tm ");

        return findBySqlWithMap(querySql.toString(),params) ;
    }

    public Object getStatsModeData(Map<String,Object> conditionMap){
        StringBuilder querySql = new StringBuilder();
        Map<String,Object> params = new HashMap<>();
        if(Utility.isEmpty(conditionMap) || !conditionMap.containsKey("projcd") || !conditionMap.containsKey("stm") || !conditionMap.containsKey("st_tp") ){
            return null;
        }
        querySql.append(" select t.* from ST_STATS_MODE_LOG t ")
                .append(" where t.proj_cd =:projcd " )
                .append(" and t.st_tp =:st_tp")
                .append(" and to_char(t.tm,'yyyy-mm-dd') >=:stm " )
                .append(" and to_char(t.tm,'yyyy-mm-dd') <= :etm  " )
                .append(" " );
        params.put("projcd",conditionMap.get("projcd"));
        params.put("st_tp",conditionMap.get("st_tp"));
        params.put("stm",conditionMap.get("stm"));
        params.put("etm",conditionMap.get("etm"));

        return findBySqlWithMap(querySql.toString(),params) ;
    }

}

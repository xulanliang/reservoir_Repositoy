package com.dse.reservoir.sjfx.shenya.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.WrrbmEntity;
import com.dse.reservoir.sjfx.shenya.dao.WrrbmDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于获取过程线数据信息
 * Created by pengzx on 2017/6/2.
 */
@Repository("wrrbmDao")
public class WrrbmDaoImpl extends BaseDao implements WrrbmDao {


    @Override
    public Object getWrrbmListData(WrrbmEntity args) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        //,t.proj_cd_one,t.proj_cd_two,t.item_cd,TO_CHAR(t.ts,'YYYY/MM/DD') ts,t.nt
        String sql=" select t.rb_cd  ,t.rb_nm  from wr_rb_m t where 1=1 ";

        if(StringUtil.isNotEmpty(args.getRb_cd())){
            sql += " AND t.rb_cd=:rb_cd ";
            params.put("rb_cd", args.getRb_cd());
        }

        if(StringUtil.isNotEmpty(args.getProj_cd_one())){
            sql += " AND t.proj_cd_one=:proj_cd_one ";
            params.put("proj_cd_one", args.getProj_cd_one());
        }

        if(StringUtil.isNotEmpty(args.getProj_cd_two())){
            sql += " AND t.proj_cd_two = :proj_cd_two ";
            params.put("proj_cd_two", args.getProj_cd_two());
        }

        if(StringUtil.isNotEmpty(args.getItem_cd())){
            sql += " AND t.item_cd = :item_cd ";
            params.put("item_cd", args.getItem_cd());
        }

        if(StringUtil.isNotEmpty(args.getRb_type())){
            sql += " AND t.RB_TYPE = :RB_TYPE ";
            params.put("RB_TYPE", args.getRb_type());
        }
        if(StringUtil.isNotEmpty(args.getSt_tp_list())){
            sql += " AND t.ST_TP_LIST like :ST_TP_LIST ";
            params.put("ST_TP_LIST", "%"+args.getSt_tp_list()+"%");
        }
        sql += " order by rb_cd asc  ";

        return findBySqlWithMap(sql,params);
    }

    @Override
    public Object getPointsByRb(Map<String,Object> queryMap) {
        if(!queryMap.containsKey("st_tp") || !queryMap.containsKey("proj_cd")
                || !queryMap.containsKey("rb_cd")){
            return null;
        }
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            StringBuilder querySql = new StringBuilder();
            querySql.append(" select t.*, ")
                    .append(" wr.rb_cd,")
                    .append(" wr.rb_nm,")
                    .append(" wr.proj_cd_one,")
                    .append(" wr.proj_cd_two ")
                    .append(" from (select ws.stcd, ws.stnm, wm.proj_cd, wm.st_tp ")
                    .append("       from wr_stat_m ws ")
                    .append("           inner join wr_st_proj_type_map wm ")
                    .append("               on ws.stcd = wm.stcd")
                    .append("       where wm.st_tp = :st_tp ) t")
                    .append("  left join wr_rb_m wr ")
                    .append("   on wr.proj_cd_two = t.proj_cd")
                    .append("   and t.st_tp in wr.st_tp_list")
                    .append(" where wr.proj_cd_one = :proj_cd_one ")
                    .append(" and  wr.proj_cd_two =  :proj_cd_two ")
                    .append(" and wr.rb_cd = :rb_cd");
            params.put("st_tp",queryMap.get("st_tp"));
            params.put("proj_cd_one",String.valueOf(queryMap.get("proj_cd")).substring(0, 1));
            params.put("proj_cd_two",queryMap.get("proj_cd"));
            params.put("rb_cd",queryMap.get("rb_cd"));
            return findBySqlWithMap(querySql.toString(),params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

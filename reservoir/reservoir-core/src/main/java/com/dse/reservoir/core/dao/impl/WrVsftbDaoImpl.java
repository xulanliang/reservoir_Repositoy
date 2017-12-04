package com.dse.reservoir.core.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.pojo.entity.WrVsftb;
import com.dse.reservoir.core.dao.WrVsftbDao;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用于记录垂直位置监测信息表(垂直位置监测信息表)数据信息
 * Created by pengzx on 2017/5/26.
 */

@Repository("wrVsftbDao")
public class WrVsftbDaoImpl extends BaseDao<WrVsftb, String> implements WrVsftbDao {

    /**
     * 查询垂直位置监测信息数据
     * @param stcd 测点编号
     * @param tm       时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    @Override
    public List getWrVsftbData(String stcd, String tm) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        String sql=" select stcd, tm, origdata, calcdata, jcl, transst, otdesc, gattype, ts, nt from wr_vsft_b t WHERE 1=1 ";
        if(StringUtil.isNotEmpty(stcd)){
            sql += " AND INSTR(t.stcd,(:stcd)) > 0 ";
            params.put("stcd", stcd);
        }
        if(StringUtil.isNotEmpty(tm)){
            sql += " AND T0_CHAR(t.TM,'YYYY-MM-DD') = (:tm) ";
            params.put("tm", tm);
        }
        return findBySqlWithMap(sql,params);
    }

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
    @Override
    public  List<Map> getChartData(String stcd, String stm, String etm) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();

        String sql=" select stcd, tm, origdata, calcdata, jcl, transst," +
                " otdesc, gattype, ts, nt from wr_vsft_b t WHERE 1=1 ";

        if(StringUtil.isNotEmpty(stcd)){
            sql += " AND INSTR(t.stcd,(:stcd)) > 0 ";
            params.put("stcd", stcd);
        }

        if(StringUtil.isNotEmpty(stm)){
            sql += " AND TO_CHAR(TM,'YYYY-MM-DD hh24:mi:ss') >= (:stm) ";
            params.put("stm", stm);
        }

        if(StringUtil.isNotEmpty(etm)){
            sql += " AND TO_CHAR(TM,'YYYY-MM-DD hh24:mi:ss') <= (:etm) ";
            params.put("etm", etm);
        }

        return findBySqlWithMap(sql,params);
    }
}
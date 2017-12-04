package com.dse.reservoir.zlgl.wdzl.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.reservoir.zlgl.wdzl.dao.WdzlDao;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Xll on 2017/6/21.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Repository("wdzlDao")
public class WdzlDaoImpl extends BaseDao implements WdzlDao {
    @Override
    public Object getListBycode(String pcode) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT * FROM T_SYS_DICTIONARY WHERE PID IN(SELECT ID FROM T_SYS_DICTIONARY WHERE  CODE=?) AND DEL_FLAG = '0' ORDER BY ORDER_INDEX ASC";
        params.add(pcode);
        System.out.println("HibernateEntityDao---688---:" + sql);
//        findBySql(sql,params);
//        Map<String,String> map = new HashMap<String,String>();


//        find
        return findBySqlWithMap(sql,params.toArray());
    }
}

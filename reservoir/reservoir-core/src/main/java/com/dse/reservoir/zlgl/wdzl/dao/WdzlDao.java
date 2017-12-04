package com.dse.reservoir.zlgl.wdzl.dao;

import com.dse.common.dao.IBaseDao;

/**
 * Created by 许兰良 on 2017/6/21.
 *
 * @Company 深圳市东深电子股份有限公司
 */
public interface WdzlDao extends IBaseDao {
    public Object getListBycode( String pcode) throws Exception;
}

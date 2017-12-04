package com.dse.reservoir.tableEdit.importData.dao;

import com.dse.common.dao.IBaseDao;

import java.util.List;

/**
 * Created by dse on 2017/8/16.
 */
public interface DataImportDao extends IBaseDao {
    public List getModel(String name);

    public Object saveCzwyjcxx(List list);
}

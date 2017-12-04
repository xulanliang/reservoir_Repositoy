package com.dse.reservoir.tableEdit.importData.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.reservoir.api.tableEdit.importData.service.DataImportService;
import com.dse.reservoir.api.tableEdit.pojo.CzwyjcxxModel;
import com.dse.reservoir.tableEdit.importData.dao.DataImportDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dse on 2017/8/16.
 */
@Repository("dataImportDao")
public class DataImportDaoImpl extends BaseDao implements DataImportDao {
    @Override
    public List getModel(String name) {
        String sql = "SELECT * FROM WR_STAT_M M WHERE M.STNM=?";
        return this.findBySqlWithMap(sql,name);
    }

    @Override
    public Object saveCzwyjcxx(List list) {
        for(int i=0;i<list.size();i++){
//            CzwyjcxxModel model = new CzwyjcxxModel();
            CzwyjcxxModel model= (CzwyjcxxModel) list.get(i);
            this.save(model);
        }
        return true;
    }
}

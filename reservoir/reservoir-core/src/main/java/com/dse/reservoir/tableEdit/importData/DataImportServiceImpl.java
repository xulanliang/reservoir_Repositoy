package com.dse.reservoir.tableEdit.importData;

import com.dse.reservoir.api.tableEdit.importData.service.DataImportService;
import com.dse.reservoir.tableEdit.importData.dao.DataImportDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dse on 2017/8/16.
 */
@Service("dataImportService")
@Transactional
public class DataImportServiceImpl implements DataImportService {

    @Resource(name = "dataImportDao")
    private DataImportDao dao;
    @Override
    public List getModel(String name) {
        return dao.getModel(name);
    }

    @Override
    public Object saveCzwyjcxx(List list) {
        return dao.saveCzwyjcxx(list);
    }
}

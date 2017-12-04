package com.dse.reservoir.sjfx.shenya.service.impl;

import com.dse.reservoir.api.sjfx.pojo.entity.WrrbmEntity;
import com.dse.reservoir.api.sjfx.shenya.service.WrrbmService;
import com.dse.reservoir.sjfx.shenya.dao.WrrbmDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用于获取过程线数据信息
 * Created by pengzx on 2017/6/2.
 */
@Service("wrrbmService")
@Transactional
public class WrrbmServiceImpl implements WrrbmService {

    @Resource(name="wrrbmDao")
    public WrrbmDao wrrbmDao;

    @Override
    public Object getWrrbmListData(WrrbmEntity args) throws Exception {
        List<Map> dataMap= (List<Map>) wrrbmDao.getWrrbmListData(args);

        return dataMap;
    }

}

package com.dse.reservoir.core.service.impl;


import com.dse.reservoir.api.service.WrVsftbService;
import com.dse.reservoir.core.dao.WrVsftbDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于记录垂直位置监测信息表(垂直位置监测信息表)数据信息
 * Created by pengzx on 2017/5/26.
 */
@Service("wrVsftbService")
@Transactional
public class WrVsftbServiceImpl implements WrVsftbService {

    @Resource(name = "wrVsftbDao")
    private WrVsftbDao wrVsftbDao;

    /**
     *
     * @param stcd 设备名称
     * @param tm 时间
     * @author pengzx
     * @date  2017年05月27日
     * @return List<Map>:查询到的结果集
     */
    public List getWrVsftbData(String stcd, String tm) throws Exception {
        return wrVsftbDao.getWrVsftbData(stcd,tm);
    }

    /**
     *
     * @param stm 设备名称
     * @param stm 开始时间
     * @param etm 结束时间
     * @author pengzx
     * @date  2017年05月27日
     * @return List<Map>:查询到的结果集
     */
    @Override
    public Map getChartData(String stcd, String stm, String etm) throws Exception {
        Map map = new HashMap();
        List<Map> list = wrVsftbDao.getChartData(stcd,stm,etm);
        List timelist = new ArrayList();
        List datalist = new ArrayList();
        for(int i=0;i<list.size();i++){
            Map m = list.get(i);
            timelist.add(i,m.get("TM"));
            datalist.add(i,m.get(stcd));
        }
        map.put("timelist",timelist);
        map.put("datalist",datalist);
        return map;
    }


}

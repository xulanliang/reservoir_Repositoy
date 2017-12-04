package com.dse.reservoir.zxjc.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.zxjc.service.ZxjcService;
import com.dse.reservoir.zxjc.dao.ZxjcDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pc on 2017-7-13.
 */
@Service("zxjcService")
@Transactional
public class ZxjcServiceImpl implements ZxjcService {

    @Resource(name = "zxjcDao")
    private ZxjcDao zxjcDao;

    @Override
    public Object getTree() throws Exception {
        List<Map> list = zxjcDao.getTree();
        List<Map> list2 = new ArrayList();
        int size = list.size();
        for(int i=0;i<size;i++){
            Map map = list.get(i);
            map.put("MYURL","/pages/app/zxjc/proj/projPage.html?projcd="+map.get("ID"));
            if(map.get("PID")==null){
                map.put("open","true");
            }
            if("1".equals(map.get("ID")) || "2".equals(map.get("ID"))){
                Map swmap = new HashMap();
                swmap.put("ID",map.get("ID")+"1");
                swmap.put("PID",map.get("ID"));
                swmap.put("NAME","水文气象");
                swmap.put("MYURL","/pages/app/zxjc/swqx/swqxPage.html?projcd="+map.get("ID"));
                list2.add(swmap);
                Map map1 = new HashMap();
                map1.put("ID",swmap.get("ID")+"1");
                map1.put("PID",swmap.get("ID"));
                map1.put("NAME","水位");
                map1.put("MYURL","/pages/app/zxjc/swqx/sw/swPage.html?projcd="+map.get("ID")+"&type=5");
                list.add(map1);
                Map map2 = new HashMap();
                map2.put("ID",swmap.get("ID")+"2");
                map2.put("PID",swmap.get("ID"));
                map2.put("NAME","雨量");
                map2.put("MYURL","/pages/app/zxjc/swqx/yl/ylPage.html?projcd="+map.get("ID")+"&type=6");
                list.add(map2);
                Map map3 = new HashMap();
                map3.put("ID",swmap.get("ID")+"3");
                map3.put("PID",swmap.get("ID"));
                map3.put("NAME","气温");
                map3.put("MYURL","/pages/app/zxjc/swqx/qw/qwPage.html?projcd="+map.get("ID")+"&type=7");
                list.add(map3);
                Map map4 = new HashMap();
                map4.put("ID",swmap.get("ID")+"4");
                map4.put("PID",swmap.get("ID"));
                map4.put("NAME","气压");
                map4.put("MYURL","/pages/app/zxjc/swqx/qy/qyPage.html?projcd="+map.get("ID")+"&type=7");
                list.add(map4);
            }
            if("1".equals(map.get("PID")) || "2".equals(map.get("PID"))){
                if(!(map.get("NAME")).equals("高边坡")){
                    Map map1 = new HashMap();
                    map1.put("ID",map.get("ID")+"1");
                    map1.put("PID",map.get("ID"));
                    map1.put("NAME","渗透压力");
                    map1.put("MYURL","/pages/app/zxjc/shenya/shenyaPage.html?st_tp=1&projcd="+map.get("ID")+"&type=1");
                    list.add(map1);
                    Map map2 = new HashMap();
                    map2.put("ID",map.get("ID")+"2");
                    map2.put("PID",map.get("ID"));
                    map2.put("NAME","渗流量");
                    map2.put("MYURL","/pages/app/zxjc/shenliu/shenliuPage.html?st_tp=2&projcd="+map.get("ID")+"&type=2");
                    list.add(map2);
                }else {
                    Map map6 = new HashMap();
                    map6.put("ID", map.get("ID") + "4");
                    map6.put("PID", map.get("ID"));
                    map6.put("NAME", "深层位移");
                    map6.put("MYURL", "/pages/app/zxjc/scwy/scwyPage.html?st_tp=8&projcd=" + map.get("ID")+"&type=8");
                    list.add(map6);
                }
                Map map3 = new HashMap();
                map3.put("ID",map.get("ID")+"3");
                map3.put("PID",map.get("ID"));
                map3.put("NAME","水平位移");
                map3.put("MYURL","/pages/app/zxjc/spwy/spwyPage.html?st_tp=3&projcd="+map.get("ID")+"&type=3");
                list.add(map3);
                if(!(map.get("NAME")).equals("溢洪道")){
                    Map map4 = new HashMap();
                    map4.put("ID",map.get("ID")+"4");
                    map4.put("PID",map.get("ID"));
                    map4.put("NAME","垂直位移");
                    map4.put("MYURL","/pages/app/zxjc/czwy/czwyPage.html?st_tp=4&projcd="+map.get("ID")+"&type=4");
                    list.add(map4);
                }
            }
            if("3".equals(map.get("PID"))){
                if("1".equals(map.get("ISSW").toString())) {
                    Map map1 = new HashMap();
                    map1.put("ID", map.get("ID") + "1");
                    map1.put("PID", map.get("ID"));
                    map1.put("NAME", "水位");
                    map1.put("MYURL", "/pages/app/zxjc/shuiwei/shuiweiPage.html?projcd=" + map.get("ID")+"&type=5");
                    list.add(map1);
                }
                if("1".equals(map.get("ISSY").toString())) {
                    Map map2 = new HashMap();
                    map2.put("ID", map.get("ID") + "2");
                    map2.put("PID", map.get("ID"));
                    map2.put("NAME", "渗透压力");
                    map2.put("MYURL", "/pages/app/zxjc/shenya/shenyaPage.html?st_tp=1&projcd=" + map.get("ID")+"&type=1");
                    list.add(map2);
                }
                if("1".equals(map.get("ISDC").toString())) {
                    Map map3 = new HashMap();
                    map3.put("ID", map.get("ID") + "3");
                    map3.put("PID", map.get("ID"));
                    map3.put("NAME", "渡槽沉降");
                    map3.put("MYURL", "/pages/app/zxjc/dccj/dccjPage.html?st_tp=9&projcd=" + map.get("ID")+"&type=9");
                    list.add(map3);
                }
                if("1".equals(map.get("ISSC").toString())) {
                    Map map4 = new HashMap();
                    map4.put("ID", map.get("ID") + "4");
                    map4.put("PID", map.get("ID"));
                    if("3015".equals(map.get("ID"))){
                        map4.put("NAME", "多点位移计");
                    }else{
                        map4.put("NAME", "深层位移");
                    }
                    map4.put("MYURL", "/pages/app/zxjc/scwy/scwyPage.html?st_tp=8&projcd=" + map.get("ID")+"&type=8");
                    list.add(map4);
                }
                if("1".equals(map.get("ISSP").toString())) {
                    Map map5 = new HashMap();
                    map5.put("ID", map.get("ID") + "3");
                    map5.put("PID", map.get("ID"));
                    map5.put("NAME", "水平位移");
                    map5.put("MYURL", "/pages/app/zxjc/spwy/spwyPage.html?st_tp=3&projcd=" + map.get("ID")+"&type=3");
                    list.add(map5);
                }
                if("1".equals(map.get("ISCZ").toString())) {
                    Map map6 = new HashMap();
                    map6.put("ID", map.get("ID") + "4");
                    map6.put("PID", map.get("ID"));
                    map6.put("NAME", "垂直位移");
                    map6.put("MYURL", "/pages/app/zxjc/czwy/czwyPage.html?st_tp=4&projcd=" + map.get("ID")+"&type=4");
                    list.add(map6);
                }
            }
        }
        list2.addAll(list);
        return list2;
    }

    @Override
    public EasyUiPage getZxjcDate(String stm, String etm, GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception {
        return zxjcDao.getZxjcDate(stm, etm, gcxArgs, easyUiPage);
    }

    @Override
    public Object getPointByKey(String key, String projcd, String type) throws Exception {
        return zxjcDao.getPointByKey(key, projcd, type);
    }

}

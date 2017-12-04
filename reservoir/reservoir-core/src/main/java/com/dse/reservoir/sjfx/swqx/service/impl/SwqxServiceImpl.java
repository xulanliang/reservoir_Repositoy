package com.dse.reservoir.sjfx.swqx.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.swqx.service.SwqxService;
import com.dse.reservoir.sjfx.swqx.dao.SwqxDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 水文气象服务层
 */
@Service("swqxService")
@Transactional
public class SwqxServiceImpl implements SwqxService {

    @Resource(name = "swqxDao")
    private SwqxDao swqxDao;

    @Override
    public Object getTree() throws Exception {
        List<Map> list = swqxDao.getTree();
        List<Map> list2 = new ArrayList();

        int size = list.size();
        for(int i=0;i<size;i++){
            Map map = list.get(i);
            if(map.get("PID")==null){
                map.put("open","true");
            }
            if("1".equals(map.get("ID")) || "2".equals(map.get("ID"))){
                Map swmap = new HashMap();
                swmap.put("ID",map.get("ID")+"1");
                swmap.put("PID",map.get("ID"));
                swmap.put("NAME","水文气象");
                swmap.put("MYURL","/pages/app/sjfx/szsk/swqx/swqxPage.html?projcd="+map.get("ID"));
                list2.add(swmap);
            }
            if("1".equals(map.get("PID")) || "2".equals(map.get("PID"))){
                if(map.get("ISSY")==null || (!"0".equals(map.get("ISSY").toString()))) {
                    Map map1 = new HashMap();
                    map1.put("ID", map.get("ID") + "1");
                    map1.put("PID", map.get("ID"));
                    map1.put("NAME", "渗透压力");
                    map1.put("MYURL", "/pages/app/sjfx/szsk/shenya/shenyaPage.html?st_tp=1&projcd=" + map.get("ID") + "&ppcd=" + map.get("PID"));
                    list.add(map1);
                }
                if(map.get("ISSW")==null || (!"0".equals(map.get("ISSW").toString()))) {
                    if((!"溢洪道".equals(map.get("NAME").toString()))){
                        if(("2".equals(map.get("PID"))) && ("主坝".equals(map.get("NAME").toString()))){
                        }else{
                            Map map2 = new HashMap();
                            map2.put("ID", map.get("ID") + "2");
                            map2.put("PID", map.get("ID"));
                            map2.put("NAME", "渗流量");
                            map2.put("MYURL", "/pages/app/sjfx/szsk/shenLiu/shenLiuPage.html?st_tp=2&projcd=" + map.get("ID") + "&ppcd=" + map.get("PID"));
                            list.add(map2);
                        }
                    }
                }

                Map map3 = new HashMap();
                map3.put("ID",map.get("ID")+"3");
                map3.put("PID",map.get("ID"));
                map3.put("NAME","水平位移");
                map3.put("MYURL","/pages/app/sjfx/szsk/spwy/spwyPage.html?st_tp=3&projcd="+map.get("ID")+"&ppcd="+map.get("PID"));
                list.add(map3);

            if(map.get("ISCZ")==null || (!"0".equals(map.get("ISCZ").toString()))){
                Map map4 = new HashMap();
                map4.put("ID", map.get("ID") + "4");
                map4.put("PID", map.get("ID"));
                map4.put("NAME", "垂直位移");
                map4.put("MYURL", "/pages/app/sjfx/szsk/czwy/czwyPage.html?st_tp=4&projcd=" + map.get("ID") + "&ppcd=" + map.get("PID"));
                list.add(map4);
            }
            if(map.get("ID")!=null && "1005".equals(map.get("ID"))){
                    Map map5 = new HashMap();
                    map5.put("ID", map.get("ID") + "4");
                    map5.put("PID", map.get("ID"));
                    map5.put("NAME", "深层位移");
                    map5.put("MYURL", "/pages/app/sjfx/dggc/scwy/scwyPage.html?st_tp=8&projcd=" + map.get("ID") + "&ppcd=" + map.get("PID"));
                    list.add(map5);
            }

            }
            if("3".equals(map.get("PID"))){
                if("1".equals(map.get("ISSW").toString())) {
                    Map map1 = new HashMap();
                    map1.put("ID",map.get("ID")+"1");
                    map1.put("PID",map.get("ID"));
                    map1.put("NAME","水位");
                    map1.put("MYURL","/pages/app/sjfx/dggc/shuiwei/shuiweiPage.html?st_tp=5&projcd="+map.get("ID")+"&ppcd="+map.get("PID"));
                    list.add(map1);
                }
                if("1".equals(map.get("ISSY").toString())) {
                    Map map2 = new HashMap();
                    map2.put("ID", map.get("ID") + "2");
                    map2.put("PID", map.get("ID"));
                    map2.put("NAME", "渗透压力");
                    map2.put("MYURL", "/pages/app/sjfx/dggc/shenya/shenyaPage.html?st_tp=1&projcd=" + map.get("ID") + "&ppcd=" + map.get("PID"));
                    list.add(map2);
                }
                if("1".equals(map.get("ISDC").toString())) {
                    Map map3 = new HashMap();
                    map3.put("ID", map.get("ID") + "3");
                    map3.put("PID", map.get("ID"));
                    map3.put("NAME", "渡槽沉降");
                    map3.put("MYURL", "/pages/app/sjfx/dggc/dccj/dccjPage.html?st_tp=9&projcd=" + map.get("ID") + "&ppcd=" + map.get("PID"));
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
                    map4.put("MYURL", "/pages/app/sjfx/dggc/scwy/scwyPage.html?st_tp=8&projcd=" + map.get("ID") + "&ppcd=" + map.get("PID"));
                    list.add(map4);
                }
                if("1".equals(map.get("ISSP").toString())) {
                    Map map5 = new HashMap();
                    map5.put("ID", map.get("ID") + "3");
                    map5.put("PID", map.get("ID"));
                    map5.put("NAME", "水平位移");
                    map5.put("MYURL", "/pages/app/sjfx/szsk/spwy/spwyPage.html?st_tp=3&projcd=" + map.get("ID") + "&ppcd=" + map.get("PID"));
                    list.add(map5);
                }
                if("1".equals(map.get("ISCZ").toString())) {
                    Map map6 = new HashMap();
                    map6.put("ID", map.get("ID") + "4");
                    map6.put("PID", map.get("ID"));
                    map6.put("NAME", "垂直位移");
                    map6.put("MYURL", "/pages/app/sjfx/szsk/czwy/czwyPage.html?st_tp=4&projcd=" + map.get("ID") + "&ppcd=" + map.get("PID"));
                    list.add(map6);
                }
            }
            //东改工程数据展示、导出
            if("3".equals(map.get("ID").toString())){
                map.put("MYURL","/pages/app/sjfx/dggc/export/allDatas/shuiweiPage.html?st_tp=5&projcd="+map.get("ID")+"&ppcd="+map.get("PID"));
            }
        }
        list2.addAll(list);
        return list2;
    }

    @Override
    public Object getWrwarningTree() throws Exception {
        List<Map> list = swqxDao.getTree();
        List<Map> list2 = new ArrayList();
        //
        Map<String,String> rootProjMap=new HashMap<String,String> ();
        int size = list.size();
        for(int i=0;i<size;i++){
            Map map = list.get(i);
            if(map.get("PID")==null){
                map.put("open","true");
                rootProjMap.put(map.get("ID").toString(),map.get("NAME").toString());
            }
        }
        list.clear();

        List<Map<String,String>> lastList=new ArrayList();
        Map<String,String> alarmMap=new HashMap<String,String>();
        alarmMap.put("10001","报警设置");
        alarmMap.put("10002","报警查询");

        if(rootProjMap!=null && rootProjMap.size()>0){
            for(String key:alarmMap.keySet()){
                Map swmap5 = new HashMap();
                swmap5.put("ID",key);
                swmap5.put("PID","");
                swmap5.put("NAME",alarmMap.get(key));
                swmap5.put("MYURL","");
                swmap5.put("open","true");
                lastList.add(swmap5);

                for (String akey:rootProjMap.keySet()){
                    if("10001".equalsIgnoreCase(key)) {
                        Map map4 = new HashMap();
                        map4.put("ID", key + akey);
                        map4.put("PID", key);
                        map4.put("CPID",akey);
                        map4.put("NAME", rootProjMap.get(akey));
                        map4.put("open","true");
                        // map4.put("MYURL", "/pages/app/sjfx/wralarmparamm/wralarmparammPage.html?projcd=" + akey);
                        lastList.add(map4);
                    }else if("10002".equalsIgnoreCase(key)){
                        Map map6 = new HashMap();
                        map6.put("ID",  key + akey);
                        map6.put("PID", key);
                        map6.put("CPID",akey);
                        map6.put("NAME", rootProjMap.get(akey));
                        map6.put("open","true");
                        // map6.put("MYURL", "/pages/app/sjfx/wrmawarningb/wrwarningbPage.html?projcd=" +akey);
                        lastList.add(map6);
                    }
                }
            }
        }
        for (int i = 0; i < lastList.size(); i++) {
            Map map = lastList.get(i);
            if ("10001".equals(map.get("PID")) ) { //报警设置
                if("3".equals(map.get("CPID")) ){
                    Map map1 = new HashMap();
                    map1.put("ID", map.get("ID") + "1");
                    map1.put("PID", map.get("ID"));
                    map1.put("NAME", "水平位移");
                    map1.put("MYURL",  "/pages/app/sjfx/wralarmparamm/environmentfactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=3" );
                    list.add(map1);
                    Map map2 = new HashMap();
                    map2.put("ID", map.get("ID") + "2");
                    map2.put("PID", map.get("ID"));
                    map2.put("NAME", "垂直位移");
                    map2.put("MYURL",  "/pages/app/sjfx/wralarmparamm/environmentfactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=4" );
                    list.add(map2);
                    Map map3 = new HashMap();
                    map3.put("ID", map.get("ID") + "3");
                    map3.put("PID", map.get("ID"));
                    map3.put("NAME", "渗透压力");
                    map3.put("MYURL",  "/pages/app/sjfx/wralarmparamm/environmentfactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=1" );
                    list.add(map3);
                    Map map4 = new HashMap();
                    map4.put("ID", map.get("ID") + "4");
                    map4.put("PID", map.get("ID"));
                    map4.put("NAME", "水位");
                    map4.put("MYURL",  "/pages/app/sjfx/wralarmparamm/environmentfactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=5" );
                    list.add(map4);
                    Map map5 = new HashMap();
                    map5.put("ID", map.get("ID") + "5");
                    map5.put("PID", map.get("ID"));
                    map5.put("NAME", "多点位移");
                    map5.put("MYURL",  "/pages/app/sjfx/wralarmparamm/environmentfactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=8" );
                    list.add(map5);
                }else{
                    Map map5 = new HashMap();
                    map5.put("ID", map.get("ID") + "1");
                    map5.put("PID", map.get("ID"));
                    map5.put("NAME", "环境量");
                    map5.put("MYURL", "/pages/app/sjfx/wralarmparamm/environmentfactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=0" );
                    list.add(map5);
                    Map map1 = new HashMap();
                    map1.put("ID", map.get("ID") + "2");
                    map1.put("PID", map.get("ID"));
                    map1.put("NAME", "渗透压力");
                    map1.put("MYURL",  "/pages/app/sjfx/wralarmparamm/environmentfactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=1" );
                    list.add(map1);
                    Map map2 = new HashMap();
                    map2.put("ID", map.get("ID") + "3");
                    map2.put("PID", map.get("ID"));
                    map2.put("NAME", "渗流量");
                    map2.put("MYURL",  "/pages/app/sjfx/wralarmparamm/environmentfactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=2" );
                    list.add(map2);
                    Map map3 = new HashMap();
                    map3.put("ID", map.get("ID") + "4");
                    map3.put("PID", map.get("ID"));
                    map3.put("NAME", "水平位移");
                    map3.put("MYURL",  "/pages/app/sjfx/wralarmparamm/environmentfactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=3" );
                    list.add(map3);
                    Map map4 = new HashMap();
                    map4.put("ID", map.get("ID") + "5");
                    map4.put("PID", map.get("ID"));
                    map4.put("NAME", "垂直位移");
                    map4.put("MYURL",  "/pages/app/sjfx/wralarmparamm/environmentfactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=4" );
                    list.add(map4);
                }
            }else if( "10002".equals(map.get("PID"))){ //报警查询
                if("3".equals(map.get("CPID"))){
                    Map map1 = new HashMap();
                    map1.put("ID", map.get("ID") + "1");
                    map1.put("PID", map.get("ID"));
                    map1.put("NAME", "水平位移");
                    map1.put("MYURL", "/pages/app/sjfx/wrwarningb/environmentFactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=3");
                    list.add(map1);
                    Map map2 = new HashMap();
                    map2.put("ID", map.get("ID") + "2");
                    map2.put("PID", map.get("ID"));
                    map2.put("NAME", "垂直位移");
                    map2.put("MYURL", "/pages/app/sjfx/wrwarningb/environmentFactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=4");
                    list.add(map2);
                    Map map3 = new HashMap();
                    map3.put("ID", map.get("ID") + "3");
                    map3.put("PID", map.get("ID"));
                    map3.put("NAME", "渗透压力");
                    map3.put("MYURL", "/pages/app/sjfx/wrwarningb/environmentFactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=1");
                    list.add(map3);
                    Map map4 = new HashMap();
                    map4.put("ID", map.get("ID") + "4");
                    map4.put("PID", map.get("ID"));
                    map4.put("NAME", "水位");
                    map4.put("MYURL", "/pages/app/sjfx/wrwarningb/environmentFactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=5" );
                    list.add(map4);
                    Map map5 = new HashMap();
                    map5.put("ID", map.get("ID") + "5");
                    map5.put("PID", map.get("ID"));
                    map5.put("NAME", "多点位移");
                    map5.put("MYURL", "/pages/app/sjfx/wrwarningb/environmentFactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=8");
                    list.add(map5);
                }else{
                    Map map5 = new HashMap();
                    map5.put("ID", map.get("ID") + "1");
                    map5.put("PID", map.get("ID"));
                    map5.put("NAME", "环境量");
                    map5.put("MYURL", "/pages/app/sjfx/wrwarningb/environmentFactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=0" );
                    list.add(map5);
                    Map map1 = new HashMap();
                    map1.put("ID", map.get("ID") + "2");
                    map1.put("PID", map.get("ID"));
                    map1.put("NAME", "渗透压力");
                    map1.put("MYURL", "/pages/app/sjfx/wrwarningb/environmentFactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=1");
                    list.add(map1);
                    Map map2 = new HashMap();
                    map2.put("ID", map.get("ID") + "3");
                    map2.put("PID", map.get("ID"));
                    map2.put("NAME", "渗流量");
                    map2.put("MYURL", "/pages/app/sjfx/wrwarningb/environmentFactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=2");
                    list.add(map2);
                    Map map3 = new HashMap();
                    map3.put("ID", map.get("ID") + "4");
                    map3.put("PID", map.get("ID"));
                    map3.put("NAME", "水平位移");
                    map3.put("MYURL", "/pages/app/sjfx/wrwarningb/environmentFactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=3");
                    list.add(map3);
                    Map map4 = new HashMap();
                    map4.put("ID", map.get("ID") + "5");
                    map4.put("PID", map.get("ID"));
                    map4.put("NAME", "垂直位移");
                    map4.put("MYURL", "/pages/app/sjfx/wrwarningb/environmentFactor/listPage.html?projcd=" + map.get("CPID") + "&mon_tp=4");
                    list.add(map4);
                }
            }
        }
        list2.addAll(list);
        list2.addAll(lastList);
        return list2;
    }

    @Override
    public Object getYear() throws Exception {
        List list = new ArrayList();
        Calendar now = Calendar.getInstance();
        Integer year = now.get(Calendar.YEAR);
        for(int i=0;i<49;i++){
            Map map = new HashMap();
            String id = Integer.toString(year-i);
            String text = year-i + "年";
            map.put("id",id);
            map.put("text",text);
            list.add(map);
        }
        return list;
    }

    @Override
    public EasyUiPage getQxDate(String stm, String etm, String projcd, EasyUiPage easyUiPage) throws Exception {
        return swqxDao.getQxDate(stm, etm, projcd, easyUiPage);
    }

    @Override
    public EasyUiPage getSwDate(String stm, String etm, String projcd, EasyUiPage easyUiPage) throws Exception {
        return swqxDao.getSwDate(stm, etm, projcd, easyUiPage);
    }
    /**
     * 查询水位数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs
     * @return
     */
    public Object getGcxSwDate(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        return swqxDao.getGcxSwDate(stm, etm, gcxArgs);
    }

    @Override
    public EasyUiPage getYlDate(String stm, String etm, String projcd, EasyUiPage easyUiPage) throws Exception {
        return swqxDao.getYlDate(stm, etm, projcd, easyUiPage);
    }

    public Object getGcxYlDate(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        return swqxDao.getGcxYlDate(stm, etm, gcxArgs);
    }

    /**
     * 查询雨量数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param projcd 项目ID
     * @return
     */

    @Override
    public EasyUiPage getQwqyDate(String stm, String etm, String projcd, EasyUiPage easyUiPage) throws Exception {
        return swqxDao.getQwqyDate(stm, etm, projcd, easyUiPage);
    }

    /**
     * 查询气温气压数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param gcxArgs
     * @return
     */
    public Object getGcxQwqyDate(String stm, String etm, GcxEntity gcxArgs) throws Exception{
        return swqxDao.getGcxQwqyDate(stm, etm, gcxArgs);
}

    @Override
    public EasyUiPage getjnbbList(String type, String year, String season, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(type) && StringUtil.isNotEmpty(year)) {
            String stime = "";
            String etime = "";
            String swstcd = swqxDao.getSwStcd(projcd);
            String ylstcd = swqxDao.getYlStcd(projcd);
            String qwstcd = swqxDao.getQwStcd(projcd);
            if (type.equals("1")) {
                if (season.equals("1")) {
                    stime = year + "-01-01";
                    etime = year + "-03-31";
                } else if (season.equals("2")) {
                    stime = year + "-04-01";
                    etime = year + "-06-30";
                } else if (season.equals("3")) {
                    stime = year + "-07-01";
                    etime = year + "-09-30";
                } else if (season.equals("4")) {
                    stime = year + "-10-01";
                    etime = year + "-12-31";
                }
            } else if (type.equals("2")) {
                stime = year + "-01-01";
                etime = year + "-12-31";
            }
            return swqxDao.getjnbbList(stime, etime, swstcd, ylstcd, qwstcd, easyUiPage);
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getSwtzzbbList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception {
        String stcd = swqxDao.getSwStcd(projcd);
        return swqxDao.getSwtzzbbList(syear, eyear, stcd,easyUiPage);
    }

    @Override
    public EasyUiPage getYltzzbbList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception {
        String stcd = swqxDao.getYlStcd(projcd);
        return swqxDao.getYltzzbbList(syear, eyear, stcd,easyUiPage);
    }

    @Override
    public EasyUiPage getQwtzzbbList(String syear, String eyear, String projcd, EasyUiPage easyUiPage) throws Exception {
        String stcd = swqxDao.getQwStcd(projcd);
        return swqxDao.getQwtzzbbList(syear, eyear, stcd,easyUiPage);
    }

    @Override
    public EasyUiPage getGcjlbList(String year, String month, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return swqxDao.getGcjlbList(tm, projcd, easyUiPage);
        }
        return easyUiPage;
    }

    @Override
    public EasyUiPage getGcjlbTJList(String year, String month, String projcd, EasyUiPage easyUiPage) throws Exception {
        if(StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(month)) {
            String tm = "";
            if (Integer.valueOf(month) < 10) {
                tm = year + "-0" + month;
            } else {
                tm = year + "-" + month;
            }
            return swqxDao.getGcjlbTJList(tm, projcd, easyUiPage);
        }
        return easyUiPage;
    }

}

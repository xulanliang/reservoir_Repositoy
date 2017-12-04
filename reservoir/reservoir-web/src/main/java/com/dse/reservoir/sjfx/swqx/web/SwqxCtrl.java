package com.dse.reservoir.sjfx.swqx.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.pojo.entity.SjfxDataEntity;
import com.dse.reservoir.api.sjfx.swqx.service.SwqxService;
import com.dse.reservoir.sjfx.SjfxDataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 水文气象控制层
 */
@Controller
@RequestMapping("/swqxCtrl")
public class SwqxCtrl {

    @Resource(name = "swqxService")
    private SwqxService swqxService;

    /**
     * 获取年份下拉
     * @return
     */
    @RequestMapping(value = "/getYear")
    @ResponseBody
    public Object getYear(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            return InvokeResult.success(swqxService.getYear());
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取左侧菜单树
     * @return
     */
    @RequestMapping(value = "/getTree")
    @ResponseBody
    public Object getTree(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            return swqxService.getTree();
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取左侧菜单树
     * @return
     */
    @RequestMapping(value = "/getWrwarningTree")
    @ResponseBody
    public Object getWrwarningTree(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            return swqxService.getWrwarningTree();
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    /**
     * 查询水文气象数据
     */
    @RequestMapping(value = "/getQxDate")
    @ResponseBody
    public Object getQxDate(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String stm=request.getParameter("stm");
            String etm=request.getParameter("etm");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(100000);
            return swqxService.getQxDate(stm,etm,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询水位数据
     */
    @RequestMapping(value = "/getSwDate")
    @ResponseBody
    public Object getSwDate(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String stm=request.getParameter("stm");
            String etm=request.getParameter("etm");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(100000);
            return swqxService.getSwDate(stm,etm,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询水位数据
     */
    @RequestMapping(value = "/getGcxSwDate")
    @ResponseBody
    public Object getGcxSwDate(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            String stm=request.getParameter("stm");
            String etm=request.getParameter("etm");
            String projcd=request.getParameter("projcd");
            String keyword=request.getParameter("keyword");
            String stcdids=request.getParameter("stcdids");
            GcxEntity gcxArgs =new GcxEntity();
            gcxArgs.setProjcd(projcd);
            gcxArgs.setStcdids(stcdids);
            gcxArgs.setKeyword(keyword);

            Map dataMap=new HashMap();
            List<Map> gcxdataList=(List<Map>)swqxService.getGcxSwDate(stm,etm,gcxArgs);
            List gcxkeys=new ArrayList();
            List gcxvalues=new ArrayList();
            Map<String,List> yaMap=new HashMap<String,List>();
            if(gcxdataList!=null&& gcxdataList.size()>0){
                for (Map data:gcxdataList) {
                    if(!gcxkeys.contains(data.get("TM"))){
                        gcxkeys.add(data.get("TM"));
                    }//STCD
                    if(!gcxvalues.contains(data.get("STNM"))){
                        gcxvalues.add(data.get("STNM"));
                    }
                    List  yaDataList=null;
                    if(!yaMap.containsKey(data.get("STNM").toString())) {
                        yaDataList= new ArrayList();
                        yaDataList.add(data.get("RZ"));
                        yaMap.put(data.get("STNM").toString(),yaDataList);
                    }else{
                        yaDataList= yaMap.get(data.get("STNM").toString());
                        yaDataList.add(data.get("RZ"));
                        yaMap.put(data.get("STNM").toString(),yaDataList);
                    }
                }
            }

            dataMap.put("RESULT_xAxisDatas",gcxkeys);//
            dataMap.put("RESULT_legendDatas",gcxvalues);//
            dataMap.put("RESULT_Datas",yaMap);//

            String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
            System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);

            return  dataMap;
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询雨量数据
     */
    @RequestMapping(value = "/getYlDate")
    @ResponseBody
    public Object getYlDate(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String stm=request.getParameter("stm");
            String etm=request.getParameter("etm");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(100000);
            return swqxService.getYlDate(stm,etm,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询雨量数据
     */
    @RequestMapping(value = "/getGcxYlDate")
    @ResponseBody
    public Object getGcxYlDate(HttpServletRequest request, HttpServletResponse response) throws Exception{
          try {
            String stm=request.getParameter("stm");
            String etm=request.getParameter("etm");
            String projcd=request.getParameter("projcd");
            String keyword=request.getParameter("keyword");
            String stcdids=request.getParameter("stcdids");
            GcxEntity gcxArgs =new GcxEntity();
            gcxArgs.setProjcd(projcd);
            gcxArgs.setStcdids(stcdids);
            gcxArgs.setKeyword(keyword);

            Map dataMap=new HashMap();
            List<Map> gcxdataList=(List<Map>)swqxService.getGcxYlDate(stm,etm,gcxArgs);
            List gcxkeys=new ArrayList();
            List gcxvalues=new ArrayList();
            Map<String,List> yaMap=new HashMap<String,List>();
            if(gcxdataList!=null&& gcxdataList.size()>0){
                for (Map data:gcxdataList) {
                    if(!gcxkeys.contains(data.get("TM"))){
                        gcxkeys.add(data.get("TM"));
                    }//STCD
                    if(!gcxvalues.contains(data.get("STNM"))){
                        gcxvalues.add(data.get("STNM"));
                    }
                    List  yaDataList=null;
                    if(!yaMap.containsKey(data.get("STNM").toString())) {
                        yaDataList= new ArrayList();
                        yaDataList.add(data.get("DYP"));
                        yaMap.put(data.get("STNM").toString(),yaDataList);
                    }else{
                        yaDataList= yaMap.get(data.get("STNM").toString());
                        yaDataList.add(data.get("DYP"));
                        yaMap.put(data.get("STNM").toString(),yaDataList);
                    }
                }
            }

            dataMap.put("RESULT_xAxisDatas",gcxkeys);//
            dataMap.put("RESULT_legendDatas",gcxvalues);//
            dataMap.put("RESULT_Datas",yaMap);//

            String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
            System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);

            return  dataMap;
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询气温气压数据
     */
    @RequestMapping(value = "/getQwqyDate")
    @ResponseBody
    public Object getQwqyDate(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String stm=request.getParameter("stm");
            String etm=request.getParameter("etm");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(100000);
            return swqxService.getQwqyDate(stm,etm,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询气温气压数据
     */
    @RequestMapping(value = "/getGcxQwqyDate")
    @ResponseBody
    public Object getGcxQwqyDate(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            String stm=request.getParameter("stm");
            String etm=request.getParameter("etm");
            String projcd=request.getParameter("projcd");
            String keyword=request.getParameter("keyword");
            String stcdids=request.getParameter("stcdids");
            GcxEntity gcxArgs =new GcxEntity();
            gcxArgs.setProjcd(projcd);
            gcxArgs.setStcdids(stcdids);
            gcxArgs.setKeyword(keyword);

            Map dataMap=new HashMap();
            //查询结果集
            List<Map> gcxdataList=(List<Map>)swqxService.getGcxQwqyDate(stm,etm,gcxArgs);
            //按时间日期
            List<String> gcxkeys=new ArrayList<String>();
            //按测点
            List<String> gcxvalues=new ArrayList<String>();
            //数值列表
            Map<String,List> qwitemDataMap=new HashMap<String,List>();
            //数值列表
            Map<String,List> qyitemDataMap=new HashMap<String,List>();
            //数据存储
            Map<String,SjfxDataEntity> dataValueMap=new HashMap<String,SjfxDataEntity>();
            /***
             * 数据处理填充
             */
            SjfxDataUtil.execSjfxData(gcxdataList,gcxkeys,gcxvalues,dataValueMap,qwitemDataMap, qyitemDataMap);

            /*
            if(gcxdataList!=null&& gcxdataList.size()>0){
                for (Map data:gcxdataList) {

                    String key=data.get("STNM").toString()+","+data.get("TM");
                    SjfxDataEntity sjfxValue=new SjfxDataEntity();
                    sjfxValue.setAirp(data.get("ATMP"));
                    sjfxValue.setAtmp(data.get("AIRP"));
                    dataValueMap.put(key,sjfxValue);

                    if(!gcxkeys.contains(data.get("TM"))){
                        gcxkeys.add(data.get("TM"));
                    }//STCD
                    if(!gcxvalues.contains(data.get("STNM"))){
                        gcxvalues.add(data.get("STNM"));
                    }
//
//                    List  qwDataList=null;
//                    if(!qwMap.containsKey(data.get("STNM").toString())) {
//                        qwDataList= new ArrayList();
//                        qwDataList.add(data.get("ATMP"));
//                        qwMap.put(data.get("STNM").toString(),qwDataList);
//                    }else{
//                        qwDataList= qwMap.get(data.get("STNM").toString());
//                        qwDataList.add(data.get("ATMP"));
//                        qwMap.put(data.get("STNM").toString(),qwDataList);
//                    }
//                    List  qyDataList=null;
//                    if(!qyMap.containsKey(data.get("STNM").toString())) {
//                        qyDataList= new ArrayList();
//                        qyDataList.add(data.get("AIRP"));
//                        qyMap.put(data.get("STNM").toString(),qyDataList);
//                    }else{
//                        qyDataList= qyMap.get(data.get("STNM").toString());
//                        qyDataList.add(data.get("AIRP"));
//                        qyMap.put(data.get("STNM").toString(),qyDataList);
//                    }
//
                }
            }

            Map<String,List> qwMap2=new HashMap<String,List>();
            Map<String,List> qyMap2=new HashMap<String,List>();
            for (Object gcxkey:gcxkeys)
                for (Object gcxvalue : gcxvalues) {
                    String key = gcxvalue + "," + gcxkey;
                    List qwDataList = null;
                    List qyDataList = null;
                    SjfxDataEntity sjfxValue=dataValueMap.get(key);
                    if (!qwMap2.containsKey(gcxvalue)) {
                        qwDataList = new ArrayList();
                        qyDataList = new ArrayList();
                        if(sjfxValue!=null){
                            qwDataList.add(sjfxValue.getAtmp());
                            qyDataList.add(sjfxValue.getAirp());
                        }else{
                            qwDataList.add("");
                            qyDataList.add("");
                        }
                        qwMap2.put(gcxvalue.toString(), qwDataList);
                        qyMap2.put(gcxvalue.toString(), qyDataList);
                    } else {
                        qwDataList = qwMap.get(gcxvalue);
                        qyDataList = qyMap.get(gcxvalue);
                        if(sjfxValue!=null){
                            qwDataList.add(sjfxValue.getAtmp());
                            qyDataList.add(sjfxValue.getAirp());
                        }else{
                            qwDataList.add("");
                            qyDataList.add("");
                        }
                        qwMap2.put(gcxvalue.toString(), qwDataList);
                        qyMap2.put(gcxvalue.toString(), qyDataList);
                    }
                }
            */

            dataMap.put("RESULT_xAxisDatas",gcxkeys);//
            dataMap.put("RESULT_legendDatas",gcxvalues);//
            dataMap.put("RESULT_Datas",qwitemDataMap);//
            dataMap.put("RESULT_Datas_QY",qyitemDataMap);//

            String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
            System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);

            return  dataMap;
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询水文气象季（年）报表数据
     */
    @RequestMapping(value = "/getjnbbList")
    @ResponseBody
    public Object getjnbbList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String type=request.getParameter("type");
            String year=request.getParameter("year");
            String season=request.getParameter("season");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return swqxService.getjnbbList(type,year,season,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询水文气象水位特征值数据
     */
    @RequestMapping(value = "/getSwtzzbbList")
    @ResponseBody
    public Object getSwtzzbbList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String syear=request.getParameter("syear");
            String eyear=request.getParameter("eyear");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(10000);
            return swqxService.getSwtzzbbList(syear,eyear,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询水文气象雨量特征值数据
     */
    @RequestMapping(value = "/getYltzzbbList")
    @ResponseBody
    public Object getYltzzbbList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String syear=request.getParameter("syear");
            String eyear=request.getParameter("eyear");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(10000);
            return swqxService.getYltzzbbList(syear,eyear,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询水文气象气温特征值数据
     */
    @RequestMapping(value = "/getQwtzzbbList")
    @ResponseBody
    public Object getQwtzzbbList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String syear=request.getParameter("syear");
            String eyear=request.getParameter("eyear");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(10000);
            return swqxService.getQwtzzbbList(syear,eyear,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询水文气象观测记录表基础数据
     */
    @RequestMapping(value = "/getGcjlbList")
    @ResponseBody
    public Object getGcjlbList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return swqxService.getGcjlbList(year,month,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询水文气象观测记录表统计数据
     */
    @RequestMapping(value = "/getGcjlbTJList")
    @ResponseBody
    public Object getGcjlbTJList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return swqxService.getGcjlbTJList(year,month,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询水文气象观测记录表Excel数据
     */
    @RequestMapping(value = "/getGcjlbExcel")
    @ResponseBody
    public Object getGcjlbExcel(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(100000);
            List<Object> list = new ArrayList<Object>();
            List<Object> jclist = swqxService.getGcjlbList(year,month,projcd,easyUiPage).getRows();
            List<Object> tjlist = swqxService.getGcjlbTJList(year,month,projcd,easyUiPage).getRows();
            list.addAll(jclist);
            list.addAll(tjlist);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


}

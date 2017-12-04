package com.dse.reservoir.sjfx.swqx.web;

import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.swqx.service.GcxService;
import com.dse.reservoir.api.util.MathUtil;
import com.dse.reservoir.api.util.Utility;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by pengzx on 2017/6/2.
 */
@Controller
@RequestMapping("/gcxCtrl")
public class GcxCtrl {

    @Resource(name="gcxService")
    private GcxService gcxService;



    @RequestMapping(value = "/getQxGcxChartData")
    @ResponseBody
    public Object getQxGcxChartData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String projcd=request.getParameter("projcd");
        String stcd=request.getParameter("stcd");
        String stm=request.getParameter("stm");
        String etm=request.getParameter("etm");
        GcxEntity gcxArgs =new GcxEntity();
        gcxArgs.setProjcd(projcd);
        gcxArgs.setStcd(stcd);
        List<Map> rsdataList=(List<Map>)gcxService.getStRsvrrChartData(gcxArgs,stm,etm);
        Map dataMap=new HashMap();
        List rskeys=new ArrayList();
        List rsvalues=new ArrayList();
        if(rsdataList!=null&& rsdataList.size()>0){
            for (Map data:rsdataList) {
                rskeys.add(data.get("TM"));
                rsvalues.add(data.get("RZ"));
            }
        }
        dataMap.put("STRSVRR_TM",rskeys);//
        dataMap.put("STRSVRR_RZ",rsvalues);//

        List<Map> ppdataList= (List<Map>)gcxService.getStPptnrChartData(gcxArgs,stm,etm);
        List ppkeys=new ArrayList();
        List ppvalues=new ArrayList();
        if(ppdataList!=null &&ppdataList.size()>0){
            for (Map data:ppdataList) {
                ppkeys.add(data.get("TM"));
                ppvalues.add(data.get("DYP"));
            }
        }
        dataMap.put("STPPTNR_TM",ppkeys);//
        dataMap.put("STPPTNR_DYP",ppvalues);//

        List<Map> tmdataList= (List<Map>)gcxService.getStTmprChartData(gcxArgs,stm,etm);
        List tmkeys=new ArrayList();
        List tmvalues=new ArrayList();
        List prvalues=new ArrayList();
        if(tmdataList!=null &&tmdataList.size()>0){
            for (Map data:tmdataList) {
                tmkeys.add(data.get("TM"));
                tmvalues.add(data.get("CATMP"));
                prvalues.add(data.get("CAIRP"));
            }
        }
        dataMap.put("STTMPR_TM",tmkeys);//
        dataMap.put("STTMPR_TM_ATMP",tmvalues);//
        dataMap.put("STTMPR_PR_AIRP",prvalues);//

        //String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
        // System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);
        return  dataMap;
    }

    /***
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getShenYaGcxChartData")
    @ResponseBody
    public Object getShenYaGcxChartData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String wrrbm_rbcd=request.getParameter("wrrbm_rbcd");
        String projcd=request.getParameter("projcd");
        String stcd=request.getParameter("stcd");
        String stm=request.getParameter("stm");
        String etm=request.getParameter("etm");
        GcxEntity gcxArgs =new GcxEntity();
        gcxArgs.setProjcd(projcd);
        gcxArgs.setStcd(stcd);
        gcxArgs.setWrrbm_rbcd(wrrbm_rbcd);
        GcxEntity gcxArgs2 =new GcxEntity();
        //设置显示一级工程的数据条件
        if(StringUtil.isNotEmpty(projcd)){
            gcxArgs2.setProjcd(projcd.substring(0,1));
        }else{
            gcxArgs2.setProjcd(projcd);
        }
        gcxArgs2.setStcd(stcd);
        // gcxArgs2.setWrrbm_rbcd(wrrbm_rbcd);

        //组装数据,单图展示,三图合一，水位，降雨量，渗压，三图合一
        //水位数据
        List<Map> rsdataList=(List<Map>)gcxService.getStRsvrrChartData(gcxArgs2,stm,etm);
        //返回数据Map
        Map dataMap=new HashMap();
        //单图展示数据
        List rskeys=new ArrayList();
        List rsvalues=new ArrayList();
        //三图合一组装数据
        List<String> tmKeys=new  ArrayList<String>();
        Map<String,Object> rsMapData=new HashMap<String,Object>();
        if(rsdataList!=null&& rsdataList.size()>0){
            for (Map data:rsdataList) {
                rskeys.add(data.get("TM"));
                rsvalues.add(data.get("RZ"));
                //三图合一组装数据 begin
                String tmStr=data.get("TM").toString();
                if(!tmKeys.contains(tmStr)){
                    tmKeys.add(tmStr);
                }
                if(!rsMapData.containsKey(tmStr)) {
                    rsMapData.put(tmStr,data.get("RZ"));
                }else{
                    rsMapData.put(tmStr,data.get("RZ"));
                }
                //三图合一组装数据 end
            }
        }
        dataMap.put("STRSVRR_TM",rskeys);//
        dataMap.put("STRSVRR_RZ",rsvalues);//
        //降雨量数据
        List<Map> ppdataList= (List<Map>)gcxService.getStPptnrChartData(gcxArgs2,stm,etm);
        //单图展示数据
        List ppkeys=new ArrayList();
        List ppvalues=new ArrayList();
        //三图合一组装数据
        Map<String,Object> jyMapData=new HashMap<String,Object>();
        List jyDataVal=new ArrayList();
        if(ppdataList!=null &&ppdataList.size()>0){
            for (Map data:ppdataList) {
                ppkeys.add(data.get("TM"));
                ppvalues.add(data.get("DYP"));
                //三图合一组装数据 begin
                String tmStr=data.get("TM").toString();
                if(!tmKeys.contains(tmStr)){
                    tmKeys.add(tmStr);
                }
                if(!rsMapData.containsKey(tmStr)) {
                    jyMapData.put(tmStr,data.get("DYP"));
                }else{
                    jyMapData.put(tmStr,data.get("DYP"));
                }
                //三图合一组装数据 end
            }
        }
        dataMap.put("STPPTNR_TM",ppkeys);//
        dataMap.put("STPPTNR_DYP",ppvalues);//
        //气温气压
        List<Map> tmdataList= (List<Map>)gcxService.getStTmprChartData(gcxArgs2,stm,etm);
        //单图展示数据
        List tmkeys=new ArrayList();
        List tmvalues=new ArrayList();
        List prvalues=new ArrayList();
        if(tmdataList!=null &&tmdataList.size()>0){
            for (Map data:tmdataList) {
                tmkeys.add(data.get("TM"));
                tmvalues.add(data.get("CATMP"));
                prvalues.add(data.get("CAIRP"));
            }
        }
        dataMap.put("STTMPR_TM",tmkeys);//
        dataMap.put("STTMPR_TM_ATMP",tmvalues);//
        dataMap.put("STTMPR_PR_AIRP",prvalues);//
        //渗压
        List<Map> yaGcxdataList=(List<Map>)gcxService.getShenYaGcxChartData(gcxArgs,stm,etm);
        //单图展示数据
        List yaGcxkeys=new ArrayList();
        List<String> yaGcxvalues=new ArrayList<String>();
        Map<String,List> yaMap=new HashMap<String,List>();
        //三图合一组装数据
        Map<String,Object> yaMapData=new HashMap<String,Object>();

        if(yaGcxdataList!=null&& yaGcxdataList.size()>0){
            for (Map data:yaGcxdataList) {
                if(!yaGcxkeys.contains(data.get("TM"))){
                    yaGcxkeys.add(data.get("TM"));
                }
                if(!yaGcxvalues.contains(data.get("STCD"))){
                    yaGcxvalues.add(data.get("STCD").toString());
                }
                List  yaDataList=null;
                if(!yaMap.containsKey(data.get("STCD").toString())) {
                    yaDataList= new ArrayList();
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }else{
                    yaDataList= yaMap.get(data.get("STCD").toString());
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }

                //三图合一组装数据 begin
                String tmStr=data.get("TM").toString();
                if(!tmKeys.contains(tmStr)){
                    tmKeys.add(tmStr);
                }
                String yakeyStcdTm=data.get("STCD")+"_"+tmStr;
                if(!yaMapData.containsKey(yakeyStcdTm)) {
                    yaMapData.put(yakeyStcdTm,data.get("CALCDATA"));
                }else{
                    yaMapData.put(yakeyStcdTm,data.get("CALCDATA"));
                }
                //三图合一组装数据 end
            }
        }
        //System.err.println(this.getClass().getName()+" >>>>>>>>>.tmKeys："+JsonUtil.object2Json(tmKeys));
        java.util.Collections.sort(tmKeys);
        //System.err.println(this.getClass().getName()+" >>>>>>>>>.tmKeys2："+JsonUtil.object2Json(tmKeys));
        //三图合一组装数据 begin
        //水位
        List sySwdataVal=new ArrayList();
        //降雨量
        List syJydataVal=new ArrayList();
        //渗压
        //三图合一组装数据
        Map<String,List> sydataVal=new HashMap<String,List>();

        if(tmKeys!=null && tmKeys.size()>0){
            for (String tm:tmKeys) {
                //水位
                sySwdataVal.add(rsMapData.get(tm)==null?0:rsMapData.get(tm));
                //降雨量
                syJydataVal.add(jyMapData.get(tm)==null?0:jyMapData.get(tm));
                //气温
                for (String keyStcd: yaGcxvalues){
                    String yakeyStcdTm=keyStcd+"_"+tm;
                    List  yaDataList=null;
                    if(!sydataVal.containsKey(keyStcd)) {
                        yaDataList= new ArrayList();
                        yaDataList.add(yaMapData.get(yakeyStcdTm)==null?0:yaMapData.get(yakeyStcdTm));
                        sydataVal.put(keyStcd,yaDataList);
                    }else{
                        yaDataList= sydataVal.get(keyStcd);
                        yaDataList.add(yaMapData.get(yakeyStcdTm)==null?0:yaMapData.get(yakeyStcdTm));
                        sydataVal.put(keyStcd,yaDataList);
                    }
                }
            }
        }
        //三图合一组装数据 end

        dataMap.put("WRHYDOB_xAxisDatas",yaGcxkeys);//
        dataMap.put("WRHYDOB_legendDatas",yaGcxvalues);//
        dataMap.put("WRHYDOB_Datas",yaMap);//

        dataMap.put("RESULT_tmKeys",tmKeys);//
        dataMap.put("RESULT_sySwdataVal",sySwdataVal);//
        dataMap.put("RESULT_syJydataVal",syJydataVal);//
        dataMap.put("RESULT_Map_Key",yaGcxvalues);//
        dataMap.put("RESULT_Map_sydataVal",sydataVal);//

        String jsonStr=JsonUtil.object2Json(dataMap);
        System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);
        return  dataMap;
    }


    @RequestMapping(value = "/getShenYaXgtChartData")
    @ResponseBody
    public Object getShenYaXgtChartData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String wrrbm_rbcd=request.getParameter("wrrbm_rbcd");
        String projcd=request.getParameter("projcd");
        String stcd=request.getParameter("stcd");
        String stm=request.getParameter("stm");
        String etm=request.getParameter("etm");
        GcxEntity gcxArgs =new GcxEntity();
        gcxArgs.setProjcd(projcd);
        gcxArgs.setStcd(stcd);
        gcxArgs.setWrrbm_rbcd(wrrbm_rbcd);

        GcxEntity gcxArgs2 =new GcxEntity();
        if(StringUtil.isNotEmpty(projcd)){
            gcxArgs2.setProjcd(projcd.substring(0,1));
        }else{
            gcxArgs2.setProjcd(projcd);
        }
        //gcxArgs2.setStcd(stcd);
        // gcxArgs2.setWrrbm_rbcd(wrrbm_rbcd);

        List<Map> rsdataList=(List<Map>)gcxService.getStRsvrrChartData(gcxArgs2,stm,etm);
        Map dataMap=new HashMap();
        List<String> tmKeys=new  ArrayList<String>();
        Map<String,Object> rsMapData=new HashMap<String,Object>();
        List rsDataVal=new ArrayList();
        if(rsdataList!=null&& rsdataList.size()>0){
            for (Map data:rsdataList) {
                String tmStr=data.get("TM").toString();
                if(!tmKeys.contains(tmStr)){
                    tmKeys.add(tmStr);
                }
                if(!rsMapData.containsKey(tmStr)) {
                    rsMapData.put(tmStr,data.get("RZ"));
                }else{
                    rsMapData.put(tmStr,data.get("RZ"));
                }
                rsDataVal.add(data.get("RZ"));
            }
        }

        // String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(rsdataList);
        // System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);

        //降雨量
        List<Map> jydataList= (List<Map>)gcxService.getStPptnrChartData(gcxArgs2,stm,etm);
        Map<String,Object> jyMapData=new HashMap<String,Object>();
        List jyDataVal=new ArrayList();
        if(jydataList!=null&& jydataList.size()>0){
            for (Map data:jydataList) {
                String tmStr=data.get("TM").toString();
                if(!tmKeys.contains(tmStr)){
                    tmKeys.add(tmStr);
                }
                if(!rsMapData.containsKey(tmStr)) {
                    jyMapData.put(tmStr,data.get("DYP"));
                }else{
                    jyMapData.put(tmStr,data.get("DYP"));
                }
                jyDataVal.add(data.get("DYP"));
            }
        }
        //气温气压
        List<Map> qwqydataList= (List<Map>)gcxService.getStTmprChartData(gcxArgs2,stm,etm);
        Map<String,Object> qwMapData=new HashMap<String,Object>();
        List qwDataVal=new ArrayList();
//        Map<String,Object> qyMapData=new HashMap<String,Object>();
//        List qyDataVal=new ArrayList();
        if(qwqydataList!=null&& qwqydataList.size()>0){
            for (Map data:qwqydataList) {
                String tmStr=data.get("TM").toString();
                if(!tmKeys.contains(tmStr)){
                    tmKeys.add(tmStr);
                }
                if(!qwMapData.containsKey(tmStr)) {
                    qwMapData.put(tmStr,data.get("CATMP"));
                }else{
                    qwMapData.put(tmStr,data.get("CATMP"));
                }
//                if(!qyMapData.containsKey(tmStr)) {
//                    qyMapData.put(tmStr,data.get("CAIRP"));
//                }else{
//                    qyMapData.put(tmStr,data.get("CAIRP"));
//                }
                qwDataVal.add(data.get("CATMP"));
                //qyDataVal.add(data.get("CAIRP"));
            }
        }
        //渗压数据
        List<Map> yadataList=(List<Map>)gcxService.getShenYaGcxChartData(gcxArgs,stm,etm);
        Map<String,Object> yaMapData=new HashMap<String,Object>();
        List yaDataVal=new ArrayList();
        if(yadataList!=null&& yadataList.size()>0){
            for (Map data:yadataList) {
                String tmStr=data.get("TM").toString();
                if(!tmKeys.contains(tmStr)){
                    tmKeys.add(tmStr);
                }
                if(!yaMapData.containsKey(tmStr)) {
                    yaMapData.put(tmStr,data.get("CALCDATA"));
                }else{
                    yaMapData.put(tmStr,data.get("CALCDATA"));
                }
                yaDataVal.add(data.get("CALCDATA"));
            }
        }

        String jsonStr2= JsonUtil.object2Json(yadataList);
        System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr2："+jsonStr2);

        Map<String,Object> sySwValuesMap=new HashMap<String,Object>();
        List sySwValuesList=new ArrayList();

        Map<String,Object> syJyValuesMap=new HashMap<String,Object>();
        List syJyValuesList=new ArrayList();

        Map<String,Object> qwValuesMap=new HashMap<String,Object>();
        List qwValuesList=new ArrayList();

        //System.err.println(this.getClass().getName()+" >>>>>>>>>.tmKeys："+JsonUtil.object2Json(tmKeys));
        java.util.Collections.sort(tmKeys);
        //System.err.println(this.getClass().getName()+" >>>>>>>>>.tmKeys2："+JsonUtil.object2Json(tmKeys));
        if(tmKeys!=null && tmKeys.size()>0){
            for (String tm:tmKeys) {
                List values=null;
                //sySwValuesMap
                if(!sySwValuesMap.containsKey(tm)){
                    values=new ArrayList();
                    Object rsObj=rsMapData.get(tm)==null?0:rsMapData.get(tm);;
                    Object yaObj=yaMapData.get(tm)==null?0:yaMapData.get(tm);;
                    values.add(rsObj);
                    values.add(yaObj);
                    sySwValuesMap.put(tm,values);
                }else{
                    values=(List)sySwValuesMap.get(tm);
                    values.clear();
                    Object rsObj=rsMapData.get(tm)==null?0:rsMapData.get(tm);
                    Object yaObj=yaMapData.get(tm)==null?0:yaMapData.get(tm);
                    values.add(rsObj);
                    values.add(yaObj);
                    sySwValuesMap.put(tm,values);
                }
                //syJyValuesMap /降雨量
                if(!syJyValuesMap.containsKey(tm)){
                    values=new ArrayList();
                    Object rsObj=jyMapData.get(tm)==null?0:jyMapData.get(tm);;
                    Object yaObj=yaMapData.get(tm)==null?0:yaMapData.get(tm);;
                    values.add(rsObj);
                    values.add(yaObj);
                    syJyValuesMap.put(tm,values);
                }else{
                    values=(List)syJyValuesMap.get(tm);
                    values.clear();
                    Object rsObj=jyMapData.get(tm)==null?0:jyMapData.get(tm);
                    Object yaObj=yaMapData.get(tm)==null?0:yaMapData.get(tm);
                    values.add(rsObj);
                    values.add(yaObj);
                    syJyValuesMap.put(tm,values);
                }
                //气温
                if(!qwValuesMap.containsKey(tm)){
                    values=new ArrayList();
                    Object rsObj=qwMapData.get(tm)==null?0:qwMapData.get(tm);;
                    Object yaObj=yaMapData.get(tm)==null?0:yaMapData.get(tm);;
                    values.add(rsObj);
                    values.add(yaObj);
                    qwValuesMap.put(tm,values);
                }else{
                    values=(List)qwValuesMap.get(tm);
                    values.clear();
                    Object rsObj=qwMapData.get(tm)==null?0:qwMapData.get(tm);
                    Object yaObj=yaMapData.get(tm)==null?0:yaMapData.get(tm);
                    values.add(rsObj);
                    values.add(yaObj);
                    qwValuesMap.put(tm,values);
                }
                //水位
                List sySwdataVal=new ArrayList();
                sySwdataVal.add(rsMapData.get(tm)==null?0:rsMapData.get(tm));
                sySwdataVal.add(yaMapData.get(tm)==null?0:yaMapData.get(tm));
                sySwValuesList.add(sySwdataVal);
                //降雨量
                List syJydataVal=new ArrayList();
                syJydataVal.add(jyMapData.get(tm)==null?0:jyMapData.get(tm));
                syJydataVal.add(yaMapData.get(tm)==null?0:yaMapData.get(tm));
                syJyValuesList.add(syJydataVal);

                //气温
                List qwdataVal=new ArrayList();
                qwdataVal.add(qwMapData.get(tm)==null?0:qwMapData.get(tm));
                qwdataVal.add(yaMapData.get(tm)==null?0:yaMapData.get(tm));
                qwValuesList.add(qwdataVal);

            }
        }

        // 相关系数计算
        double swCoefficient ;      //
        double swCovariance = MathUtil.calcuteCovariation(rsDataVal,yaDataVal);   //渗压协方差
        double swStandard = MathUtil.calculateStandardDeviation(rsDataVal,yaDataVal);       //渗压标准差
        swCoefficient = swStandard != 0 ? swCovariance/swStandard : 0 ;
        dataMap.put("swStandard",swStandard);
        dataMap.put("swCoefficient",swCoefficient);

        double jyCoefficient ;
        double jyCovariance = MathUtil.calcuteCovariation(jyDataVal,yaDataVal);   //渗压协方差
        double jyStandard = MathUtil.calculateStandardDeviation(jyDataVal,yaDataVal);       //渗压标准差
        jyCoefficient = jyStandard != 0 ? jyCovariance/jyStandard : 0 ;
        dataMap.put("jyStandard",jyStandard);
        dataMap.put("jyCoefficient",jyCoefficient);

        double qwCoefficient ;
        double qwCovariance = MathUtil.calcuteCovariation(qwDataVal,yaDataVal);   //渗压协方差
        double qwStandard = MathUtil.calculateStandardDeviation(qwDataVal,yaDataVal);       //渗压标准差
        qwCoefficient = qwStandard != 0 ? qwCovariance/qwStandard : 0 ;
        dataMap.put("qwStandard",qwStandard);
        dataMap.put("qwCoefficient",qwCoefficient);

        System.out.println("syCoefficient ===" +swCoefficient);

        dataMap.put("RESULT_xAxisDatas",sySwValuesMap);//
        dataMap.put("RESULT_legendDatas",tmKeys);//
        dataMap.put("RESULT_Datas_sySw",sySwValuesList);//
        dataMap.put("RESULT_Datas_syJy",syJyValuesList);//
        dataMap.put("RESULT_Datas_syQw",qwValuesList);//
        dataMap.put("RESULT_rsDataVal",rsDataVal);//
        dataMap.put("RESULT_yaDataVal",yaDataVal);//
        dataMap.put("RESULT_jyDataVal",jyDataVal);//
        dataMap.put("RESULT_qwDataVal",qwDataVal);//
        dataMap.put("RESULT_Datas2",sySwValuesMap.values());//

         String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
         System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);
        return  dataMap;
    }


    @RequestMapping(value = "/getShenLiuGcxChartData")
    @ResponseBody
    public Object getShenLiuGcxChartData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String wrrbm_rbcd=request.getParameter("wrrbm_rbcd");
        String projcd=request.getParameter("projcd");
        String stcd=request.getParameter("stcd");
        String stm=request.getParameter("stm");
        String etm=request.getParameter("etm");
        GcxEntity gcxArgs =new GcxEntity();
        gcxArgs.setProjcd(projcd);
        gcxArgs.setStcd(stcd);
        gcxArgs.setWrrbm_rbcd(wrrbm_rbcd);

        Map dataMap=new HashMap();
        List<Map> yaGcxdataList=(List<Map>)gcxService.getShenLiuGcxChartData(gcxArgs,stm,etm);
        List yaGcxkeys=new ArrayList();
        List yaGcxvalues=new ArrayList();
        Map<String,List> yaMap=new HashMap<String,List>();
        if(yaGcxdataList!=null&& yaGcxdataList.size()>0){
            for (Map data:yaGcxdataList) {
                if(!yaGcxkeys.contains(data.get("TM"))){
                    yaGcxkeys.add(data.get("TM"));
                }
                if(!yaGcxvalues.contains(data.get("STCD"))){
                    yaGcxvalues.add(data.get("STCD"));
                }
                List  yaDataList=null;
                if(!yaMap.containsKey(data.get("STCD").toString())) {
                    yaDataList= new ArrayList();
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }else{
                    yaDataList= yaMap.get(data.get("STCD").toString());
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }
            }
        }
        dataMap.put("WRHYDOB_xAxisDatas",yaGcxkeys);//
        dataMap.put("WRHYDOB_legendDatas",yaGcxvalues);//
        dataMap.put("WRHYDOB_Datas",yaMap);//

        String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
         System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);
        return  dataMap;
    }

    @RequestMapping(value = "/getSpwyZxfbtGcxChartData")
    @ResponseBody
    public Object getSpwyZxfbtGcxChartData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String wrrbm_rbcd=request.getParameter("wrrbm_rbcd");
        String projcd=request.getParameter("projcd");
        String stm=request.getParameter("stm");
        String etm=request.getParameter("etm");
        String season=request.getParameter("season");
        String wrprojb_proj_cd=request.getParameter("wrprojb_proj_cd");
        GcxEntity gcxArgs =new GcxEntity();
        gcxArgs.setProjcd(projcd);
        gcxArgs.setWrrbm_rbcd(wrrbm_rbcd);
        gcxArgs.setWrprojb_proj_cd(wrprojb_proj_cd);
        Map dataMap=new HashMap();

        List<Map> yaGcxdataList=(List<Map>)gcxService.getSpwyZxfbtGcxChartData(gcxArgs,stm,etm,season);
        List yaGcxkeys=new ArrayList();
        List yaGcxvalues=new ArrayList();
        Map<String,List> yaMap=new HashMap<String,List>();
        if(yaGcxdataList!=null&& yaGcxdataList.size()>0){
            for (Map data:yaGcxdataList) {
                if(!yaGcxkeys.contains(data.get("STCD"))){
                    yaGcxkeys.add(data.get("STCD"));
                }
                if(!yaGcxvalues.contains(data.get("TM"))){
                    yaGcxvalues.add(data.get("TM"));
                }
                List  yaDataList=null;
                if(!yaMap.containsKey(data.get("TM").toString())) {
                    yaDataList= new ArrayList();
                    yaDataList.add(data.get("FSHIFT"));
                    yaMap.put(data.get("TM").toString(),yaDataList);
                }else{
                    yaDataList= yaMap.get(data.get("TM").toString());
                    yaDataList.add(data.get("FSHIFT"));
                    yaMap.put(data.get("TM").toString(),yaDataList);
                }
            }
        }
        dataMap.put("WRHYDOB_xAxisDatas",yaGcxkeys);//
        dataMap.put("WRHYDOB_legendDatas",yaGcxvalues);//
        dataMap.put("WRHYDOB_Datas",yaMap);//

        // String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
        // System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);
        return  dataMap;
    }

    @RequestMapping(value = "/getSpwyGcxChartData")
    @ResponseBody
    public Object getSpwyGcxChartData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String wrrbm_rbcd=request.getParameter("wrrbm_rbcd");
        String projcd=request.getParameter("projcd");
        String stm=request.getParameter("stm");
        String etm=request.getParameter("etm");
        String wrprojb_proj_cd=request.getParameter("wrprojb_proj_cd");
        GcxEntity gcxArgs =new GcxEntity();
        gcxArgs.setProjcd(projcd);
        gcxArgs.setWrrbm_rbcd(wrrbm_rbcd);
        gcxArgs.setWrprojb_proj_cd(wrprojb_proj_cd);
        Map dataMap=new HashMap();

        List<Map> yaGcxdataList=(List<Map>)gcxService.getSpwyGcxChartData(gcxArgs,stm,etm);
        List yaGcxkeys=new ArrayList();
        List yaGcxvalues=new ArrayList();
        Map<String,List> yaMap=new HashMap<String,List>();
        if(yaGcxdataList!=null&& yaGcxdataList.size()>0){
            for (Map data:yaGcxdataList) {
                if(!yaGcxkeys.contains(data.get("TM"))){
                    yaGcxkeys.add(data.get("TM"));
                }
                if(!yaGcxvalues.contains(data.get("STCD"))){
                    yaGcxvalues.add(data.get("STCD"));
                }
                List  yaDataList=null;
                if(!yaMap.containsKey(data.get("STCD").toString())) {
                    yaDataList= new ArrayList();
                    yaDataList.add(data.get("FSHIFT"));
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }else{
                    yaDataList= yaMap.get(data.get("STCD").toString());
                    yaDataList.add(data.get("FSHIFT"));
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }
            }
        }
        dataMap.put("WRHYDOB_xAxisDatas",yaGcxkeys);//
        dataMap.put("WRHYDOB_legendDatas",yaGcxvalues);//
        dataMap.put("WRHYDOB_Datas",yaMap);//

        // String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
        // System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);
        return  dataMap;
    }


    @RequestMapping(value = "/getCzwyZxfbtGcxChartData")
    @ResponseBody
    public Object getCzwyZxfbtGcxChartData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String wrrbm_rbcd=request.getParameter("wrrbm_rbcd");
        String projcd=request.getParameter("projcd");
        String stm=request.getParameter("stm");
        String etm=request.getParameter("etm");
        String season=request.getParameter("season");
        String wrprojb_proj_cd=request.getParameter("wrprojb_proj_cd");
        GcxEntity gcxArgs =new GcxEntity();
        gcxArgs.setProjcd(projcd);
        gcxArgs.setWrrbm_rbcd(wrrbm_rbcd);
        gcxArgs.setWrprojb_proj_cd(wrprojb_proj_cd);

        Map dataMap=new HashMap();

        List<Map> yaGcxdataList=(List<Map>)gcxService.getCzwyZxfbtGcxChartData(gcxArgs,stm,etm,season);
        List yaGcxkeys=new ArrayList();
        List yaGcxvalues=new ArrayList();
        Map<String,List> yaMap=new HashMap<String,List>();
        if(yaGcxdataList!=null&& yaGcxdataList.size()>0){
            for (Map data:yaGcxdataList) {
                if(!yaGcxkeys.contains(data.get("STCD"))){
                    yaGcxkeys.add(data.get("STCD"));
                }
                if(!yaGcxvalues.contains(data.get("TM"))){
                    yaGcxvalues.add(data.get("TM"));
                }
                List  yaDataList=null;
                if(!yaMap.containsKey(data.get("TM").toString())) {
                    yaDataList= new ArrayList();
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("TM").toString(),yaDataList);
                }else{
                    yaDataList= yaMap.get(data.get("TM").toString());
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("TM").toString(),yaDataList);
                }
            }
        }
        dataMap.put("WRHYDOB_xAxisDatas",yaGcxkeys);//
        dataMap.put("WRHYDOB_legendDatas",yaGcxvalues);//
        dataMap.put("WRHYDOB_Datas",yaMap);//

        // String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
        // System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);
        return  dataMap;
    }

    @RequestMapping(value = "/getCzwyGcxChartData")
    @ResponseBody
    public Object getCzwyGcxChartData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String wrrbm_rbcd=request.getParameter("wrrbm_rbcd");
        String projcd=request.getParameter("projcd");
        String stm=request.getParameter("stm");
        String etm=request.getParameter("etm");
        String wrprojb_proj_cd=request.getParameter("wrprojb_proj_cd");
        GcxEntity gcxArgs =new GcxEntity();
        gcxArgs.setProjcd(projcd);
        gcxArgs.setWrrbm_rbcd(wrrbm_rbcd);
        gcxArgs.setWrprojb_proj_cd(wrprojb_proj_cd);
        Map dataMap=new HashMap();

        List<Map> yaGcxdataList=(List<Map>)gcxService.getCzwyGcxChartData(gcxArgs,stm,etm);
        List yaGcxkeys=new ArrayList();
        List yaGcxvalues=new ArrayList();
        Map<String,List> yaMap=new HashMap<String,List>();
        if(yaGcxdataList!=null&& yaGcxdataList.size()>0){
            for (Map data:yaGcxdataList) {
                if(!yaGcxkeys.contains(data.get("TM"))){
                    yaGcxkeys.add(data.get("TM"));
                }
                if(!yaGcxvalues.contains(data.get("STCD"))){
                    yaGcxvalues.add(data.get("STCD"));
                }
                List  yaDataList=null;
                if(!yaMap.containsKey(data.get("STCD").toString())) {
                    yaDataList= new ArrayList();
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }else{
                    yaDataList= yaMap.get(data.get("STCD").toString());
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }
            }
        }
        dataMap.put("WRHYDOB_xAxisDatas",yaGcxkeys);//
        dataMap.put("WRHYDOB_legendDatas",yaGcxvalues);//
        dataMap.put("WRHYDOB_Datas",yaMap);//

        // String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
        // System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);
        return  dataMap;
    }


    @RequestMapping(value = "/getSwGcxChartData")
    @ResponseBody
    public Object getSwGcxChartData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String wrprojb_proj_cd=request.getParameter("wrprojb_proj_cd");
        String projcd=request.getParameter("projcd");
        String stm=request.getParameter("stm");
        String etm=request.getParameter("etm");
        GcxEntity gcxArgs =new GcxEntity();
        gcxArgs.setProjcd(projcd);
        gcxArgs.setWrprojb_proj_cd(wrprojb_proj_cd);
        Map dataMap=new HashMap();

        List<Map> yaGcxdataList=(List<Map>)gcxService.getWrswrGcxChartData(gcxArgs,stm,etm);
        List yaGcxkeys=new ArrayList();
        List yaGcxvalues=new ArrayList();
        Map<String,List> yaMap=new HashMap<String,List>();
        if(yaGcxdataList!=null&& yaGcxdataList.size()>0){
            for (Map data:yaGcxdataList) {
                if(!yaGcxkeys.contains(data.get("TM"))){
                    yaGcxkeys.add(data.get("TM"));
                }
                if(!yaGcxvalues.contains(data.get("STCD"))){
                    yaGcxvalues.add(data.get("STCD"));
                }
                List  yaDataList=null;
                if(!yaMap.containsKey(data.get("STCD").toString())) {
                    yaDataList= new ArrayList();
                    yaDataList.add(Utility.isNotEmpty(data.get("Z")) ? data.get("Z") : "--");
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }else{
                    yaDataList= yaMap.get(data.get("STCD").toString());
                    yaDataList.add(Utility.isNotEmpty(data.get("Z")) ? data.get("Z") : "--");
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }
            }
        }
        dataMap.put("WRHYDOB_xAxisDatas",yaGcxkeys);//
        dataMap.put("WRHYDOB_legendDatas",yaGcxvalues);//
        dataMap.put("WRHYDOB_Datas",yaMap);//

        // String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
        // System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);
        return  dataMap;
    }

    @RequestMapping(value = "/getSyGcxChartData")
    @ResponseBody
    public Object getSyGcxChartData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String wrprojb_proj_cd=request.getParameter("wrprojb_proj_cd");
        String projcd=request.getParameter("projcd");
        String stm=request.getParameter("stm");
        String etm=request.getParameter("etm");
        String wrrbm_rbcd=request.getParameter("wrrbm_rbcd");
        GcxEntity gcxArgs =new GcxEntity();
        gcxArgs.setProjcd(projcd);
        gcxArgs.setWrprojb_proj_cd(wrprojb_proj_cd);
        gcxArgs.setWrrbm_rbcd(wrrbm_rbcd);

        Map dataMap=new HashMap();

        List<Map> yaGcxdataList=(List<Map>)gcxService.getShenYaGcxChartData(gcxArgs,stm,etm);
        List yaGcxkeys=new ArrayList();
        List yaGcxvalues=new ArrayList();
        Map<String,List> yaMap=new HashMap<String,List>();
        if(yaGcxdataList!=null&& yaGcxdataList.size()>0){
            for (Map data:yaGcxdataList) {
                if(!yaGcxkeys.contains(data.get("TM"))){
                    yaGcxkeys.add(data.get("TM"));
                }
                if(!yaGcxvalues.contains(data.get("STCD"))){
                    yaGcxvalues.add(data.get("STCD"));
                }
                List  yaDataList=null;
                if(!yaMap.containsKey(data.get("STCD").toString())) {
                    yaDataList= new ArrayList();
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }else{
                    yaDataList= yaMap.get(data.get("STCD").toString());
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }
            }
        }
        dataMap.put("WRHYDOB_xAxisDatas",yaGcxkeys);//
        dataMap.put("WRHYDOB_legendDatas",yaGcxvalues);//
        dataMap.put("WRHYDOB_Datas",yaMap);//

        // String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
        // System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);
        return  dataMap;
    }

    @RequestMapping(value = "/getScwyGcxChartData")
    @ResponseBody
    public Object getScwyGcxChartData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String wrprojb_proj_cd=request.getParameter("wrprojb_proj_cd");
        String projcd=request.getParameter("projcd");
        String stm=request.getParameter("stm");
        String etm=request.getParameter("etm");
        String wrrbm_rbcd=request.getParameter("wrrbm_rbcd");
        GcxEntity gcxArgs =new GcxEntity();
        gcxArgs.setProjcd(projcd);
        gcxArgs.setWrprojb_proj_cd(wrprojb_proj_cd);
        gcxArgs.setWrrbm_rbcd(wrrbm_rbcd);

        Map dataMap=new HashMap();

        List<Map> yaGcxdataList=(List<Map>)gcxService.getWrmsftbGcxChartData(gcxArgs,stm,etm);
        List yaGcxkeys=new ArrayList();
        List yaGcxvalues=new ArrayList();
        Map<String,List> yaMap=new HashMap<String,List>();
        if(yaGcxdataList!=null&& yaGcxdataList.size()>0){
            for (Map data:yaGcxdataList) {
                if(!yaGcxkeys.contains(data.get("STCD"))){
                    yaGcxkeys.add(data.get("STCD"));
                }
                if(!yaGcxvalues.contains(data.get("TM"))){
                    yaGcxvalues.add(data.get("TM"));
                }
                List  yaDataList=null;
                if(!yaMap.containsKey(data.get("TM").toString())) {
                    yaDataList= new ArrayList();
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("TM").toString(),yaDataList);
                }else{
                    yaDataList= yaMap.get(data.get("TM").toString());
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("TM").toString(),yaDataList);
                }
            }
        }
        dataMap.put("WRHYDOB_xAxisDatas",yaGcxvalues);//
        dataMap.put("WRHYDOB_legendDatas",yaGcxkeys);//
        dataMap.put("WRHYDOB_Datas",yaMap);//

        // String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
        // System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);
        return  dataMap;
    }

    @RequestMapping(value = "/getDccjGcxChartData")
    @ResponseBody
    public Object getDccjGcxChartData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String wrprojb_proj_cd=request.getParameter("wrprojb_proj_cd");
        String projcd=request.getParameter("projcd");
        String stm=request.getParameter("stm");
        String etm=request.getParameter("etm");
        GcxEntity gcxArgs =new GcxEntity();
        gcxArgs.setProjcd(projcd);
        gcxArgs.setWrprojb_proj_cd(wrprojb_proj_cd);
        Map dataMap=new HashMap();

        List<Map> yaGcxdataList=(List<Map>)gcxService.getWrcsftbGcxChartData(gcxArgs,stm,etm);
        List yaGcxkeys=new ArrayList();
        List yaGcxvalues=new ArrayList();
        Map<String,List> yaMap=new HashMap<String,List>();
        if(yaGcxdataList!=null&& yaGcxdataList.size()>0){
            for (Map data:yaGcxdataList) {
                if(!yaGcxkeys.contains(data.get("TM"))){
                    yaGcxkeys.add(data.get("TM"));
                }
                if(!yaGcxvalues.contains(data.get("STCD"))){
                    yaGcxvalues.add(data.get("STCD"));
                }
                List  yaDataList=null;
                if(!yaMap.containsKey(data.get("STCD").toString())) {
                    yaDataList= new ArrayList();
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }else{
                    yaDataList= yaMap.get(data.get("STCD").toString());
                    yaDataList.add(data.get("CALCDATA"));
                    yaMap.put(data.get("STCD").toString(),yaDataList);
                }
            }
        }
        dataMap.put("WRHYDOB_xAxisDatas",yaGcxkeys);//
        dataMap.put("WRHYDOB_legendDatas",yaGcxvalues);//
        dataMap.put("WRHYDOB_Datas",yaMap);//

        // String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
        // System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);
        return  dataMap;
    }



}

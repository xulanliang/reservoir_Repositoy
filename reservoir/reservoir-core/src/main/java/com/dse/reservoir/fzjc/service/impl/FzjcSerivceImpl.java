package com.dse.reservoir.fzjc.service.impl;

import com.dse.reservoir.api.fzjc.IFzjcService;
import com.dse.reservoir.api.util.CONSTANT;
import com.dse.reservoir.api.util.DateUtil;
import com.dse.reservoir.api.util.MathUtil;
import com.dse.reservoir.api.util.Utility;
import com.dse.reservoir.fzjc.dao.IFzjcDao;
import com.dse.reservoir.sjfx.shenya.dao.WrrbmDao;
import com.dse.reservoir.sjfx.swqx.dao.SwqxDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author
 * @date 2017-10-25
 */
@Service("fzjcService")
@Transactional
public class FzjcSerivceImpl implements IFzjcService {

    @Resource(name = "swqxDao")
    private SwqxDao swqxDao;

    @Resource
    private WrrbmDao wrrbmDao;

    @Resource
    private IFzjcDao fzjcDao;

    @Override
    public Object getTree() throws Exception {

        List<Map> list = swqxDao.getTree();
        List<Map> list2 = new ArrayList();
        List<Map> returnList = new ArrayList<>();
        int size = list.size();
        for(int i=0;i<size;i++){
            Map map = list.get(i);
            if("1".equals(String.valueOf(map.get("ID")).substring(0,1))){
                if(map.get("PID")==null){
                    map.put("open","true");
                    returnList.add(map);
                }
                if( "1001".equals(map.get("ID")) || "1002".equals(map.get("ID") ) || "1003".equals(map.get("ID")) ){
                    map.put("open","true");
                    returnList.add(map);
                    Map map1 = new HashMap();
                    map1.put("ID", map.get("ID") + "1");
                    map1.put("PID", map.get("ID"));
                    map1.put("NAME", "渗压");
                    map1.put("MYURL", "/pages/app/fzjc/shenYa/shenyaStatsPage.html?projcd=" + map.get("ID") + "&ppcd=" + map.get("PID") +"&st_tp=1");
                    returnList.add(map1);
                    Map map2 = new HashMap();
                    map2.put("ID", map.get("ID") + "2");
                    map2.put("PID", map.get("ID"));
                    map2.put("NAME", "渗流");
//                    map2.put("MYURL", "/pages/app/sjfx/szsk/shenLiu/shenLiuPage.html?st_tp=2&projcd=" + map.get("ID") + "&ppcd=" + map.get("PID"));
                    map2.put("MYURL", "/pages/app/fzjc/shenLiu/shenLiuStatsPage.html?projcd=" + map.get("ID") + "&ppcd=" + map.get("PID") +"&st_tp=2");
                    returnList.add(map2);
                }
            }
        }

        return returnList;
    }

    @Override
    public Object getPointsByRb(Map<String, Object> queryMap) throws Exception {
        List<Map> dataMap = (List<Map>) wrrbmDao.getPointsByRb(queryMap);
        return dataMap;
    }

    /**
     *             Y= B0 + d1*X1 + d2*X2 + d3*X3 + a4*X4 + a5*X5 + a6*X6 + a7*X7 + a8*X8 + b9*X9 + b10*X10 + b11*X11 + b12*X12 + b13*X13 + c14*X14 + c15*X15 + c16*X16 + c17*X17 + c18*X18
     * 统计模型 公式 Y= B0 + d1*I1 + d2*I2 + d3*I3 + a4*H1 + a5*H2 + a6*H3 + a7*H4 + a8*H5 + b9*R1 + b10*R2 +  b11*R3 +  b12*R4 +  b13*R5 +  c14*T1+  c15*T2  +  c16*T3  + c17*T4  + c18*T5
     *  a、b、c、d 取 回归系数
     * 其中t1＝(t－t0)/365＝(观测日序值－基准日序值)/365。基准日期取为首测日期。 t0是取所选时段的数据第一个值。
     * @param queryMap
     * @return
     */
    @Override
    public  Object getShenYaStatsData(Map<String,Object> queryMap){
        if(Utility.isEmpty(queryMap)){
            return null;
        }

        Map<String,Object> returnMap = new HashMap<>();
        Map<String,Object> dataMap = new TreeMap<>();
        Map<String,Object> legendMap = new HashMap<>();
        List<Object> legendList = new ArrayList<>();
        List<String> xList = new ArrayList<>();

        String stm = queryMap.get("stm").toString();
        String etm = queryMap.get("etm").toString();
        String rbcd = queryMap.containsKey("rbcd") ?  queryMap.get("rbcd").toString() :"";    //断面ID
        String stcd = queryMap.get("stcd").toString();    //测点ID
        String st_tp = queryMap.get("st_tp").toString();
        String projcd = queryMap.get("projcd").toString();          //工程ID


        Map<String,Object> modeMap = new HashMap<>();
        modeMap.put("st_tp",st_tp);
        modeMap.put("stcd",stcd);

        List<Object> rzList = new ArrayList<>();        // 水位list
        List<Object> pptnList = new ArrayList<>();      //降雨list
        List<Object> tmpList = new ArrayList<>();       //气温list
        List<Object> timeList = new ArrayList<>();      //时效因子list
        String legendStr_rz = "上游水位分量";
        String legendStr_pptn = "降雨分量";
        String legendStr_tmp = "温度分量";
        String legendStr_time = "时效分量";
        int days = DateUtil.daysBetween(stm,etm);
        if(days > 0){
            List<Map> modeParamList = (List<Map>) fzjcDao.getModeParam(modeMap) ;       //取出测点的各个因子的回归系数

            String dayStr = stm ;

            Map<String, Object> conditionMap = new HashMap<>();
            conditionMap.put("projcd", projcd);
            conditionMap.put("st_tp", "1"); //水位
            conditionMap.put("stm", stm);
            conditionMap.put("etm", etm);
            List<Map> statsModeRZList = (List<Map>) fzjcDao.getStatsModeData(conditionMap);         //水位数据
            conditionMap.clear();
            conditionMap.put("projcd", projcd);
            conditionMap.put("st_tp", "2"); //降雨
            conditionMap.put("stm", stm);
            conditionMap.put("etm", etm);
            List<Map> statsModeDYPList = (List<Map>) fzjcDao.getStatsModeData(conditionMap);         //降雨数据

            conditionMap.clear();
            conditionMap.put("projcd", projcd);
            conditionMap.put("st_tp", "3"); //气温
            conditionMap.put("stm", stm);
            conditionMap.put("etm", etm);
            List<Map> statsModeatmpList = (List<Map>) fzjcDao.getStatsModeData(conditionMap);         //气温

            //其中，t1＝(t－t0)/365＝(观测日序值－基准日序值)/365。基准日期取为首测日期。
            for (int i=0 ; i<= days ;i++){

                Double base =  365d;
                Double t1 = Double.valueOf(i /base );
                if(modeParamList.size() > 0 ){
                    Map<String,Object> mode = modeParamList.get(0);
                    if(Utility.isNotEmpty(mode)) {
                        Double timeVal = 0d;
                        Double bo = Utility.isNotEmpty(mode.get("B0")) ? Double.valueOf(mode.get("B0").toString()) : 0d;
                        if (Utility.isNotEmpty(mode.get("B0"))) {
                            timeVal = MathUtil.add(timeVal, bo);
                        }

                        if (Utility.isNotEmpty(mode.get("X1"))) {
                            timeVal = MathUtil.add(timeVal, Double.valueOf(mode.get("X1").toString()) * t1);
                        }

                        if (Utility.isNotEmpty(mode.get("X2"))) {
                            timeVal = MathUtil.add(timeVal, Double.valueOf(mode.get("X2").toString()) * Math.log(t1 + 1));
                        }
                        if (Utility.isNotEmpty(mode.get("X3"))) {
                            timeVal = MathUtil.add(timeVal, Double.valueOf(mode.get("X3").toString()) * (1 - Math.exp(-t1)));
                        }

                        timeList.add(MathUtil.round(timeVal,3));

                        //水位
                        Double rzVal = 0d;
                        Map rzMap =  getStatsModeData(statsModeRZList,dayStr,projcd);
                        if(Utility.isNotEmpty(rzMap) ){

                            if (Utility.isNotEmpty(rzMap.get("RZ")) && Utility.isNotEmpty(mode.get("X4")) ) {
                                //当天取值
                                rzVal = MathUtil.add(rzVal,Double.valueOf(mode.get("X4").toString()) * Double.valueOf(rzMap.get("RZ").toString()));
                            }
                            if (Utility.isNotEmpty(rzMap.get("RZ1")) &&Utility.isNotEmpty(mode.get("X5"))) {
                                //前1-15天平均值
                                rzVal = MathUtil.add(rzVal,Double.valueOf(mode.get("X5").toString()) * Double.valueOf(rzMap.get("RZ1").toString()));
                            }
                            if (Utility.isNotEmpty(rzMap.get("RZ2")) &&Utility.isNotEmpty(mode.get("X6"))) {
                                //前16-30天平均值
                                rzVal = MathUtil.add(rzVal,Double.valueOf(mode.get("X6").toString()) * Double.valueOf(rzMap.get("RZ2").toString()));
                            }
                            if (Utility.isNotEmpty(rzMap.get("RZ3")) &&Utility.isNotEmpty(mode.get("X7"))) {
                                //前31-60天平均值
                                rzVal = MathUtil.add(rzVal,Double.valueOf(mode.get("X7").toString()) * Double.valueOf(rzMap.get("RZ3").toString()));
                            }

                            //前61-90天平均值
                            if (Utility.isNotEmpty(rzMap.get("RZ4")) &&Utility.isNotEmpty(mode.get("X8"))) {
                                rzVal = MathUtil.add(rzVal,Double.valueOf(mode.get("X8").toString()) * Double.valueOf(rzMap.get("RZ4").toString()));
                            }
                        }

                        rzList.add(MathUtil.round(rzVal,3)) ;

                        //降雨
                        Double pptnVal = 0d;
                        //降雨量数据
                        Map dypMap =  getStatsModeData(statsModeDYPList,dayStr,projcd);
                        if(Utility.isNotEmpty(dypMap)){
                            if (Utility.isNotEmpty(dypMap.get("RZ")) && Utility.isNotEmpty(mode.get("X9")) ) {
                                pptnVal = MathUtil.add(pptnVal,Double.valueOf(mode.get("X9").toString()) * Double.valueOf(dypMap.get("RZ").toString()));
                            }
                            if (Utility.isNotEmpty(dypMap.get("RZ1")) &&Utility.isNotEmpty(mode.get("X10"))) {
                                //前1-15天累计值
                                pptnVal = MathUtil.add(pptnVal,Double.valueOf(mode.get("X10").toString()) * Double.valueOf(dypMap.get("RZ1").toString()));
                            }
                            if (Utility.isNotEmpty(dypMap.get("RZ2")) &&Utility.isNotEmpty(mode.get("X11"))) {
                                  //前16-30天累计值
                                pptnVal = MathUtil.add(pptnVal,Double.valueOf(mode.get("X11").toString()) * Double.valueOf(dypMap.get("RZ2").toString()));
                            }
                            if (Utility.isNotEmpty(dypMap.get("RZ3")) &&Utility.isNotEmpty(mode.get("X12"))) {
                               //前31-60天累计值
                                pptnVal = MathUtil.add(pptnVal,Double.valueOf(mode.get("X12").toString()) * Double.valueOf(dypMap.get("RZ3").toString()));
                            }
                            if (Utility.isNotEmpty(dypMap.get("RZ4")) &&Utility.isNotEmpty(mode.get("X13"))) {
                                //前61-90天累计值
                                pptnVal = MathUtil.add(pptnVal,Double.valueOf(mode.get("X13").toString()) * Double.valueOf(dypMap.get("RZ4").toString()));
                            }
                        }
                        pptnList.add(MathUtil.round(pptnVal,3));

                        //温度
                        Double tmpVal = 0d;
                        Map tmpMap =  getStatsModeData(statsModeatmpList,dayStr,projcd);
                        if(Utility.isNotEmpty(tmpMap)) {
                            if (Utility.isNotEmpty(tmpMap.get("RZ")) && Utility.isNotEmpty(mode.get("X14"))) {
                                tmpVal = MathUtil.add(tmpVal, Double.valueOf(mode.get("X14").toString()) * Double.valueOf(tmpMap.get("RZ").toString()));
                            }
                            if (Utility.isNotEmpty(tmpMap.get("RZ1")) && Utility.isNotEmpty(mode.get("X15"))) {
                                  //前1-15天平均值
                                tmpVal = MathUtil.add(tmpVal, Double.valueOf(mode.get("X15").toString()) * Double.valueOf(tmpMap.get("RZ1").toString()));
                            }
                            if (Utility.isNotEmpty(tmpMap.get("RZ2")) && Utility.isNotEmpty(mode.get("X16"))) {
                                 //前16-30天平均值
                                tmpVal = MathUtil.add(tmpVal, Double.valueOf(mode.get("X16").toString()) * Double.valueOf(tmpMap.get("RZ2").toString()));
                            }
                            if (Utility.isNotEmpty(tmpMap.get("RZ3")) && Utility.isNotEmpty(mode.get("X17"))) {
                                //前31-60天平均值
                                tmpVal = MathUtil.add(tmpVal, Double.valueOf(mode.get("X17").toString()) * Double.valueOf(tmpMap.get("RZ3").toString()));
                            }
                            if (Utility.isNotEmpty(tmpMap.get("RZ4")) && Utility.isNotEmpty(mode.get("X18"))) {
                                //前61-90天平均值
                                tmpVal = MathUtil.add(tmpVal, Double.valueOf(mode.get("X18").toString()) * Double.valueOf(tmpMap.get("RZ4").toString()));
                            }
                        }
                        tmpList.add(MathUtil.round(tmpVal,3));

                    }




                  /* val =MathUtil.round(val,3);
                    xList.add(dayStr);
                    yList.add(val);
                    dataMap.put(dayStr,val);*/
                }
                xList.add(dayStr);
                dayStr = DateUtil.addDay(dayStr,1);
            }
        }
        dataMap.put(legendStr_rz,rzList);
        dataMap.put(legendStr_pptn,pptnList);
        dataMap.put(legendStr_tmp,tmpList);
        dataMap.put(legendStr_time,timeList);
        legendMap.put("legend_rz",legendStr_rz);
        legendMap.put("legend_pptn",legendStr_pptn);
        legendMap.put("legend_tmp",legendStr_tmp);
        legendMap.put("legend_time",legendStr_time);
        legendList.add(legendStr_rz);
        legendList.add(legendStr_pptn);
        legendList.add(legendStr_tmp);
        legendList.add(legendStr_time);

        returnMap.put("Axis_Data",dataMap);
        returnMap.put("legendList",legendList);
        returnMap.put("xList",xList);
        returnMap.put("legendMap",legendMap);

        return  returnMap;
    }

    public Map getStatsModeData(List<Map> list ,String dateStr,String projcd){
        if(Utility.isEmpty(list) || list.size() < 1){
            return null;
        }
        for (Map map : list){
            for (Object key : map.keySet()){
                if("PROJ_CD".equalsIgnoreCase(key.toString())){
                    String PROJ_CD = map.get("PROJ_CD").toString();
                    if(PROJ_CD.equalsIgnoreCase(projcd)){
                        Object tm = map.get("TM");
                        if(DateUtil.compareDate(dateStr,tm.toString()) == 0){
//                            Double val = Double.valueOf(Utility.isNotEmpty(map.get(rzType).toString()) ? map.get(rzType).toString() : "0");
                            list.remove(map);
                            return map ;
                        }
                    }

                }
            }
        }
    return null;
    }

    /**
     * 渗流数据组装
     *
     * @param queryMap
     * @return
     */
    @Override
    public Object getShenLiuStatsData(Map<String,Object> queryMap){
        if(Utility.isEmpty(queryMap)){
            return null;
        }

        Map<String,Object> returnMap = new HashMap<>();
        Map<String,Object> dataMap = new TreeMap<>();
        Map<String,Object> legendMap = new HashMap<>();
        List<Object> legendList = new ArrayList<>();
        List<String> xList = new ArrayList<>();

        String stm = queryMap.get("stm").toString();
        String etm = queryMap.get("etm").toString();
        String stcd = queryMap.get("stcd").toString();    //测点ID
        String st_tp = queryMap.get("st_tp").toString();
        String projcd = queryMap.get("projcd").toString();


        List<Object> rzList = new ArrayList<>();        // 水位list
        List<Object> pptnList = new ArrayList<>();      //降雨list
        List<Object> tmpList = new ArrayList<>();       //气温list
        List<Object> timeList = new ArrayList<>();      //时效因子list
        String legendStr_rz = "上游水位分量";
        String legendStr_pptn = "降雨分量";
        String legendStr_tmp = "温度分量";
        String legendStr_time = "时效分量";

        int days = DateUtil.daysBetween(stm,etm);
        if(days > 0){

            String dayStr = stm ;

            Map<String, Object> conditionMap = new HashMap<>();
            conditionMap.put("projcd", projcd);
            conditionMap.put("st_tp", "1"); //水位
            conditionMap.put("stm", stm);
            conditionMap.put("etm", etm);
            List<Map> statsModeRZList = (List<Map>) fzjcDao.getStatsModeData(conditionMap);         //水位数据
            conditionMap.clear();
            conditionMap.put("projcd", projcd);
            conditionMap.put("st_tp", "2"); //降雨
            conditionMap.put("stm", stm);
            conditionMap.put("etm", etm);
            List<Map> statsModeDYPList = (List<Map>) fzjcDao.getStatsModeData(conditionMap);         //降雨数据

            conditionMap.clear();
            conditionMap.put("projcd", projcd);
            conditionMap.put("st_tp", "3"); //气温
            conditionMap.put("stm", stm);
            conditionMap.put("etm", etm);
            List<Map> statsModeatmpList = (List<Map>) fzjcDao.getStatsModeData(conditionMap);         //气温


            for (int i=0 ; i<= days ;i++){
                Double rzVal = 0d;
                Double pptnVal  = 0d;
                Double tmpVal = 0d;
                Double timeVal = 0d;

                Double base =  365d;
                Double t1 = Double.valueOf(i /base );

                //水位
                Map rzMap =  getStatsModeData(statsModeRZList,dayStr,projcd);
                //降雨量数据
                Map dypMap =  getStatsModeData(statsModeDYPList,dayStr,projcd);
                //气温
                Map tmpMap =  getStatsModeData(statsModeatmpList,dayStr,projcd);

                if(CONSTANT.STATS_TYPE_SL_M2.equals(stcd)){
                    rzVal = MathUtil.add(rzVal,-5.5748);        //常数项
                    if(Utility.isNotEmpty(rzMap)){
                        //当天数据
                        if(Utility.isNotEmpty(rzMap.get("RZ")) ){
                            rzVal = MathUtil.add(rzVal,MathUtil.mul(0.41568,Double.valueOf(rzMap.get("RZ").toString())));      // 0.41568*H1-1
                        }
                        //前1-15天数据
                        if(Utility.isNotEmpty(rzMap.get("RZ1")) ){
                            rzVal = MathUtil.sub(rzVal,MathUtil.mul(0.20095,Double.valueOf(rzMap.get("RZ1").toString())));
                        }
                    }
                    if (Utility.isNotEmpty(dypMap)){
                        if(Utility.isNotEmpty(dypMap.get("RZ"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.04780,Double.valueOf(dypMap.get("RZ").toString())));          // +0.04780*R1
                        }
                        if(Utility.isNotEmpty(dypMap.get("RZ1"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.19698,Double.valueOf(dypMap.get("RZ1").toString())));     // + 0.19698*R1-15
                        }
                        if(Utility.isNotEmpty(dypMap.get("RZ2"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.04334,Double.valueOf(dypMap.get("RZ2").toString())));       // +0.04334*R16-30
                        }
                        if(Utility.isNotEmpty(dypMap.get("RZ3"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.04425,Double.valueOf(dypMap.get("RZ3").toString())));      // +0.04425*R31-60
                        }
                    }
                    if(Utility.isNotEmpty(tmpMap)){
                        if(Utility.isNotEmpty(tmpMap.get("RZ"))){
                            tmpVal = MathUtil.sub(tmpVal,MathUtil.mul(0.02216,Double.valueOf(tmpMap.get("RZ").toString())));              // - 0.02216T1-1
                        }
                        if(Utility.isNotEmpty(tmpMap.get("RZ2"))){
                            tmpVal = MathUtil.sub(tmpVal,MathUtil.mul(0.03216,Double.valueOf(tmpMap.get("RZ2").toString())));
                        }
                        if(Utility.isNotEmpty(tmpMap.get("RZ3"))){
                            tmpVal = MathUtil.add(tmpVal,MathUtil.mul(0.05707,Double.valueOf(tmpMap.get("RZ3").toString())));
                        }
                        if(Utility.isNotEmpty(tmpMap.get("RZ4"))){
                            tmpVal = MathUtil.add(tmpVal,MathUtil.mul(0.02429,Double.valueOf(tmpMap.get("RZ4").toString())));
                        }
                    }

                    timeVal = MathUtil.sub(timeVal,MathUtil.mul(0.20955,t1));           // - 0.20955*t1
                    timeVal = MathUtil.add(timeVal,MathUtil.mul(2.81168,Math.log(t1+1)));
                    timeVal = MathUtil.sub(timeVal,MathUtil.mul(3.53523,1- Math.exp(-t1)));     // - 3.53523 * (1-e(-t1))

                }else if(CONSTANT.STATS_TYPE_SL_L.equals(stcd)){
                    //"Q = -3.16450 + 0.03807H1 + 0.03979H1-15 + 0.01123H16-30 + 0.01335H31-60 +0.01399H61-90 +
                    // 0.00168R1 + 0.00810R1-15 + 0.00194R16-30 + 0.00320R31-60 + 0.00100R61-90
                    // -0.00098T1 +  0.00420T61-90
                    //- 0.06704t1 - 0.75661ln(t1+1) +1.29256(1-e-t1)";
                    rzVal = MathUtil.add(rzVal,-3.16450);        //常数项
                    if(Utility.isNotEmpty(rzMap)){
                        //当天数据
                        if(Utility.isNotEmpty(rzMap.get("RZ")) ){
                            rzVal = MathUtil.add(rzVal,MathUtil.mul(0.03807,Double.valueOf(rzMap.get("RZ").toString())));      // 0.41568*H1-1
                        }
                        //前1-15天数据
                        if(Utility.isNotEmpty(rzMap.get("RZ1")) ){
                            rzVal = MathUtil.add(rzVal,MathUtil.mul(0.03979,Double.valueOf(rzMap.get("RZ1").toString())));
                        }
                        if(Utility.isNotEmpty(rzMap.get("RZ2")) ){
                            rzVal = MathUtil.add(rzVal,MathUtil.mul(0.01123,Double.valueOf(rzMap.get("RZ2").toString())));
                        }
                        if(Utility.isNotEmpty(rzMap.get("RZ3")) ){
                            rzVal = MathUtil.add(rzVal,MathUtil.mul(0.01335,Double.valueOf(rzMap.get("RZ3").toString())));
                        }
                        if(Utility.isNotEmpty(rzMap.get("RZ4")) ){
                            rzVal = MathUtil.add(rzVal,MathUtil.mul(0.01399,Double.valueOf(rzMap.get("RZ4").toString())));
                        }
                    }
                    if (Utility.isNotEmpty(dypMap)){
                        if(Utility.isNotEmpty(dypMap.get("RZ"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.00168,Double.valueOf(dypMap.get("RZ").toString())));          // +0.00168*R1
                        }
                        if(Utility.isNotEmpty(dypMap.get("RZ1"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.00810,Double.valueOf(dypMap.get("RZ1").toString())));     // + 0.19698*R1-15
                        }
                        if(Utility.isNotEmpty(dypMap.get("RZ2"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.00194,Double.valueOf(dypMap.get("RZ2").toString())));       // +0.00194*R16-30
                        }
                        if(Utility.isNotEmpty(dypMap.get("RZ3"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.0032,Double.valueOf(dypMap.get("RZ3").toString())));      // +0.04425*R31-60
                        }
                        if(Utility.isNotEmpty(dypMap.get("RZ4"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.00100,Double.valueOf(dypMap.get("RZ4").toString())));      // +0.04425*R31-60
                        }
                    }
                    if(Utility.isNotEmpty(tmpMap)){
                        if(Utility.isNotEmpty(tmpMap.get("RZ"))){
                            tmpVal = MathUtil.sub(tmpVal,MathUtil.mul(0.00098,Double.valueOf(tmpMap.get("RZ").toString())));              // - 0.00098T1-1
                        }
                        if(Utility.isNotEmpty(tmpMap.get("RZ4"))){
                            tmpVal = MathUtil.add(tmpVal,MathUtil.mul(0.00420,Double.valueOf(tmpMap.get("RZ4").toString())));
                        }
                    }

                    timeVal = MathUtil.sub(timeVal,MathUtil.mul(0.06704,t1));           // - 0.20955*t1
                    timeVal = MathUtil.add(timeVal,MathUtil.mul(0.75661,Math.log(t1+1)));
                    timeVal = MathUtil.sub(timeVal,MathUtil.mul(1.29256,1- Math.exp(-t1)));     // - 3.53523 * (1-e(-t1))

                } else if(CONSTANT.STATS_TYPE_SL_L4.equals(stcd)){
                    //"Q = -0.63390 + 0.08854H1 - 0.02851H31-60 -0.01877H61-90
                    // + 0.00896R1 + 0.01584R1-15
                    // - 0.00594T16-30
                    // +0.00816t1 - 0.40115ln(t1+1) + 1.06368(1-e-t1)";
                    rzVal = MathUtil.add(rzVal,-0.63390);        //常数项
                    if(Utility.isNotEmpty(rzMap)){
                        //当天数据
                        if(Utility.isNotEmpty(rzMap.get("RZ")) ){
                            rzVal = MathUtil.add(rzVal,MathUtil.mul(0.08854,Double.valueOf(rzMap.get("RZ").toString())));      // 0.41568*H1-1
                        }
                        if(Utility.isNotEmpty(rzMap.get("RZ3")) ){
                            rzVal = MathUtil.sub(rzVal,MathUtil.mul(0.02851,Double.valueOf(rzMap.get("RZ3").toString())));
                        }
                        if(Utility.isNotEmpty(rzMap.get("RZ4")) ){
                            rzVal = MathUtil.sub(rzVal,MathUtil.mul(0.01877,Double.valueOf(rzMap.get("RZ4").toString())));
                        }
                    }
                    if (Utility.isNotEmpty(dypMap)){
                        if(Utility.isNotEmpty(dypMap.get("RZ"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.00896,Double.valueOf(dypMap.get("RZ").toString())));          // +0.00168*R1
                        }
                        if(Utility.isNotEmpty(dypMap.get("RZ1"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.01584,Double.valueOf(dypMap.get("RZ1").toString())));     // + 0.19698*R1-15
                        }
                    }
                    if(Utility.isNotEmpty(tmpMap)){
                        if(Utility.isNotEmpty(tmpMap.get("RZ2"))){
                            tmpVal = MathUtil.sub(tmpVal,MathUtil.mul(0.00594,Double.valueOf(tmpMap.get("RZ2").toString())));              // - 0.00098T1-1
                        }
                    }
                    timeVal = MathUtil.add(timeVal,MathUtil.mul(0.00816,t1));
                    timeVal = MathUtil.sub(timeVal,MathUtil.mul(0.40115,Math.log(t1+1)));
                    timeVal = MathUtil.add(timeVal,MathUtil.mul(1.06368,1- Math.exp(-t1)));
                }else if(CONSTANT.STATS_TYPE_SL_R2.equals(stcd)){
                    //"Q =  -9.8324 + 0.38652H1 - 0.08217H1-15 -0.08494H61-90
                    // + 0.01842R1 + 0.02025R1-15 +0.00464R31-60
                    // - 0.01358T1 - 0.00828T16-30 + 0.00842T31-60 + 0.00579T61-90  " +
                    //"- 0.08407t1 - 0.50059ln(t1+1) + 0.63857(1-e-t1)"
                    rzVal = MathUtil.add(rzVal,-9.8324);        //常数项
                    if(Utility.isNotEmpty(rzMap)){
                        //当天数据
                        if(Utility.isNotEmpty(rzMap.get("RZ")) ){
                            rzVal = MathUtil.add(rzVal,MathUtil.mul(0.38652,Double.valueOf(rzMap.get("RZ").toString())));      // 0.41568*H1-1
                        }
                        if(Utility.isNotEmpty(rzMap.get("RZ1")) ){
                            rzVal = MathUtil.sub(rzVal,MathUtil.mul(0.08217,Double.valueOf(rzMap.get("RZ1").toString())));
                        }
                        if(Utility.isNotEmpty(rzMap.get("RZ4")) ){
                            rzVal = MathUtil.sub(rzVal,MathUtil.mul(0.08494,Double.valueOf(rzMap.get("RZ4").toString())));
                        }
                    }
                    if (Utility.isNotEmpty(dypMap)){
                        if(Utility.isNotEmpty(dypMap.get("RZ"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.01842,Double.valueOf(dypMap.get("RZ").toString())));          // +0.00168*R1
                        }
                        if(Utility.isNotEmpty(dypMap.get("RZ1"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.02025,Double.valueOf(dypMap.get("RZ1").toString())));     // + 0.19698*R1-15
                        }
                        if(Utility.isNotEmpty(dypMap.get("RZ3"))){
                            pptnVal = MathUtil.add(pptnVal,MathUtil.mul(0.00464,Double.valueOf(dypMap.get("RZ3").toString())));
                        }
                    }
                    if(Utility.isNotEmpty(tmpMap)){
                        if(Utility.isNotEmpty(tmpMap.get("RZ"))){
                            tmpVal = MathUtil.sub(tmpVal,MathUtil.mul(0.01358,Double.valueOf(tmpMap.get("RZ").toString())));
                        }
                        if(Utility.isNotEmpty(tmpMap.get("RZ2"))){
                            tmpVal = MathUtil.sub(tmpVal,MathUtil.mul(0.00828,Double.valueOf(tmpMap.get("RZ2").toString())));
                        }
                        if(Utility.isNotEmpty(tmpMap.get("RZ3"))){
                            tmpVal = MathUtil.sub(tmpVal,MathUtil.mul(0.00842,Double.valueOf(tmpMap.get("RZ3").toString())));
                        }
                        if(Utility.isNotEmpty(tmpMap.get("RZ4"))){
                            tmpVal = MathUtil.sub(tmpVal,MathUtil.mul(0.00579,Double.valueOf(tmpMap.get("RZ4").toString())));
                        }
                    }

                    timeVal = MathUtil.sub(timeVal,MathUtil.mul(0.08407,t1));
                    timeVal = MathUtil.sub(timeVal,MathUtil.mul(0.50059,Math.log(t1+1)));
                    timeVal = MathUtil.add(timeVal,MathUtil.mul(0.63857,1- Math.exp(-t1)));
                }

                rzList.add(MathUtil.round(rzVal,3));
                pptnList.add(MathUtil.round(pptnVal,5));
                tmpList.add(MathUtil.round(tmpVal,5));
                timeList.add(MathUtil.round(timeVal,5));

                xList.add(dayStr);
                dayStr = DateUtil.addDay(dayStr,1);
            }
        }
        dataMap.put(legendStr_rz,rzList);
        dataMap.put(legendStr_pptn,pptnList);
        dataMap.put(legendStr_tmp,tmpList);
        dataMap.put(legendStr_time,timeList);
        legendMap.put("legend_rz",legendStr_rz);
        legendMap.put("legend_pptn",legendStr_pptn);
        legendMap.put("legend_tmp",legendStr_tmp);
        legendMap.put("legend_time",legendStr_time);
        legendList.add(legendStr_rz);
        legendList.add(legendStr_pptn);
        legendList.add(legendStr_tmp);
        legendList.add(legendStr_time);

        returnMap.put("Axis_Data",dataMap);
        returnMap.put("legendList",legendList);
        returnMap.put("xList",xList);
        returnMap.put("legendMap",legendMap);

        return  returnMap;
    }



    public static void main(String[] args) throws ParseException {
        // TODO Auto-generated method stub
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1=sdf.parse("2012-09-08 10:10:10");
        Date d2=sdf.parse("2012-09-15 00:00:00");
//        System.out.println(DateUtil.daysBetween("2017-8","2017-10-1"));
//        System.out.println(DateUtil.daysBetween("2012-09-08 10:10:10","2012-09-15 00:00:00"));
        Map<String,Object> map = new HashMap<>();
        map.put("stm","2017-02-01");
        map.put("etm","2017-08-01");
//        getStatsData(map);
        List<Map> list = new ArrayList<>();
        list.add(map);


    }



}

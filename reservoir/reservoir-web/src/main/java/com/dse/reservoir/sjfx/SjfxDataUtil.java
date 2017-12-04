package com.dse.reservoir.sjfx;

import com.dse.reservoir.api.sjfx.pojo.entity.SjfxDataEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/24.
 */
public class SjfxDataUtil {
    //数据存储

    /****
     *
     * @param gcxdataList
     * @param gcxkeys
     * @param gcxvalues
     * @param dataValueMap
     * @param itemDataMap
     * @param dataKey
     */
    public synchronized static void  execSjfxData( List<Map> gcxdataList,List<String> gcxkeys,List<String> gcxvalues,Map<String,SjfxDataEntity> dataValueMap,
                                     Map<String,List> itemDataMap,String dataKey){

        if(gcxdataList!=null&& gcxdataList.size()>0){
            for (Map data:gcxdataList) {
                String stnm=data.get("STNM").toString();
                String tm=data.get("TM").toString();
                //数据存储 begin
                String key=stnm+","+tm;
                SjfxDataEntity sjfxValue=new SjfxDataEntity();
                sjfxValue.setData(data.get(dataKey));
                dataValueMap.put(key,sjfxValue);
                //数据存储 end

                if(!gcxkeys.contains(tm)){
                    gcxkeys.add(tm);
                }//STCD
                if(!gcxvalues.contains(stnm)){
                    gcxvalues.add(stnm);
                }
            }
        }
        //组装数据
        for (String gcxkey:gcxkeys) {
            for (String gcxvalue : gcxvalues) {
                String key = gcxvalue + "," + gcxkey;
                SjfxDataEntity sjfxValue = dataValueMap.get(key);
                List itemDataList = null;
                if (!itemDataMap.containsKey(gcxvalue)) {
                    itemDataList = new ArrayList();
                    if (sjfxValue != null) {
                        itemDataList.add(sjfxValue.getData());
                    } else {
                        itemDataList.add("");
                    }
                    itemDataMap.put(gcxvalue.toString(), itemDataList);
                } else {
                    itemDataList = itemDataMap.get(gcxvalue);
                    if (sjfxValue != null) {
                        itemDataList.add(sjfxValue.getData());
                    } else {
                        itemDataList.add("");
                    }
                    itemDataMap.put(gcxvalue.toString(), itemDataList);
                }
            }
        }

    /*

    for (Object gcxkey:gcxkeys) {
                for (Object gcxvalue : gcxvalues) {
                    String key = gcxvalue + "," + gcxkey;
                    SjfxDataEntity sjfxValue = dataValueMap.get(key);
                    List itemDataList = null;
                    if (!itemDataMap.containsKey(gcxvalue.toString())) {
                        itemDataList = new ArrayList();
                        if (sjfxValue != null) {
                            itemDataList.add(sjfxValue.getData());
                        } else {
                            itemDataList.add("");
                        }
                        itemDataMap.put(gcxvalue.toString(), itemDataList);
                    } else {
                        itemDataList = itemDataMap.get(gcxvalue.toString());
                        if (sjfxValue != null) {
                            itemDataList.add(sjfxValue.getData());
                        } else {
                            itemDataList.add("");
                        }
                        itemDataMap.put(gcxvalue.toString(), itemDataList);
                    }
                }
            }

     */


    }


    /****
     *
     * @param gcxdataList
     * @param gcxkeys
     * @param gcxvalues
     * @param dataValueMap
     * @param qwitemDataMap
     * @param qyitemDataMap
     */
    public synchronized static void  execSjfxData( List<Map> gcxdataList,List<String> gcxkeys,List<String> gcxvalues,Map<String,SjfxDataEntity> dataValueMap,
                                                   Map<String,List> qwitemDataMap, Map<String,List> qyitemDataMap){
        if(gcxdataList!=null&& gcxdataList.size()>0){
            for (Map data:gcxdataList) {
                String stnm=data.get("STNM").toString();
                String tm=data.get("TM").toString();
                //数据存储 begin
                String key=stnm+","+tm;
                SjfxDataEntity sjfxValue=new SjfxDataEntity();
                sjfxValue.setAirp(data.get("AIRP"));
                sjfxValue.setAtmp(data.get("ATMP"));
                dataValueMap.put(key,sjfxValue);

                if(!gcxkeys.contains(tm)){
                    gcxkeys.add(tm);
                }//STCD
                if(!gcxvalues.contains(stnm)){
                    gcxvalues.add(stnm);
                }
                    /*
                    List  qwDataList=null;
                    if(!qwMap.containsKey(data.get("STNM").toString())) {
                        qwDataList= new ArrayList();
                        qwDataList.add(data.get("ATMP"));
                        qwMap.put(data.get("STNM").toString(),qwDataList);
                    }else{
                        qwDataList= qwMap.get(data.get("STNM").toString());
                        qwDataList.add(data.get("ATMP"));
                        qwMap.put(data.get("STNM").toString(),qwDataList);
                    }
                    List  qyDataList=null;
                    if(!qyMap.containsKey(data.get("STNM").toString())) {
                        qyDataList= new ArrayList();
                        qyDataList.add(data.get("AIRP"));
                        qyMap.put(data.get("STNM").toString(),qyDataList);
                    }else{
                        qyDataList= qyMap.get(data.get("STNM").toString());
                        qyDataList.add(data.get("AIRP"));
                        qyMap.put(data.get("STNM").toString(),qyDataList);
                    }
                    */
            }
        }
        for (String gcxkey:gcxkeys)
            for (String gcxvalue : gcxvalues) {
                String key = gcxvalue + "," + gcxkey;
                List qwDataList = null;
                List qyDataList = null;
                SjfxDataEntity sjfxValue=dataValueMap.get(key);
                if (!qwitemDataMap.containsKey(gcxvalue)) {
                    qwDataList = new ArrayList();
                    qyDataList = new ArrayList();
                    if(sjfxValue!=null){
                        qwDataList.add(sjfxValue.getAtmp());
                        qyDataList.add(sjfxValue.getAirp());
                    }else{
                        qwDataList.add("");
                        qyDataList.add("");
                    }
                    qwitemDataMap.put(gcxvalue, qwDataList);
                    qyitemDataMap.put(gcxvalue, qyDataList);
                } else {
                    qwDataList = qwitemDataMap.get(gcxvalue);
                    qyDataList = qyitemDataMap.get(gcxvalue);
                    if(sjfxValue!=null){
                        qwDataList.add(sjfxValue.getAtmp());
                        qyDataList.add(sjfxValue.getAirp());
                    }else{
                        qwDataList.add("");
                        qyDataList.add("");
                    }
                    qwitemDataMap.put(gcxvalue, qwDataList);
                    qyitemDataMap.put(gcxvalue, qyDataList);
                }
            }
    }

}

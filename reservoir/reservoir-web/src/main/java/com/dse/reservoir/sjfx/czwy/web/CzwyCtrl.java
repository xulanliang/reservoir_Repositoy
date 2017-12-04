package com.dse.reservoir.sjfx.czwy.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.sjfx.czwy.service.CzwyService;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.pojo.entity.SjfxDataEntity;
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
 * 垂直位移控制层
 */
@Controller
@RequestMapping("/czwyCtrl")
public class CzwyCtrl {

    @Resource(name = "czwyService")
    private CzwyService czwyService;

    /**
     * 查询垂直位移数据
     */
    @RequestMapping(value = "/getDateList")
    @ResponseBody
    public Object getDateList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String stm=request.getParameter("stm");
            String etm=request.getParameter("etm");
            String projcd=request.getParameter("projcd");
            String stcdids=request.getParameter("stcds");
            String wrrbm_rbcd=request.getParameter("wrrbm_rbcd");
            GcxEntity gcxArgs =new GcxEntity();
            gcxArgs.setProjcd(projcd);
            gcxArgs.setStcdids(stcdids);
            gcxArgs.setWrrbm_rbcd(wrrbm_rbcd);
            easyUiPage.setPageSize(100000);
            return czwyService.getDateList(stm,etm,gcxArgs,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询垂直位移数据
     */
    @RequestMapping(value = "/getGcxDateList")
    @ResponseBody
    public Object getGcxDateList(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            String stm=request.getParameter("stm");
            String etm=request.getParameter("etm");
            String projcd=request.getParameter("projcd");
            String keyword=request.getParameter("keyword");
            String stcdids=request.getParameter("stcdids");
            String wrrbm_rbcd=request.getParameter("wrrbm_rbcd");
            GcxEntity gcxArgs =new GcxEntity();
            gcxArgs.setProjcd(projcd);
            gcxArgs.setStcdids(stcdids);
            gcxArgs.setKeyword(keyword);
            gcxArgs.setWrrbm_rbcd(wrrbm_rbcd);
            Map dataMap=new HashMap();
            //查询结果集
            List<Map> gcxdataList=(List<Map>)czwyService.getGcxDateList(stm,etm,gcxArgs);

            //按时间日期
            List<String> gcxkeys=new ArrayList<String>();
            //按测点
            List<String> gcxvalues=new ArrayList<String>();
            //数值列表
            Map<String,List> itemDataMap=new HashMap<String,List>();
            //数据存储
            Map<String,SjfxDataEntity> dataValueMap=new HashMap<String,SjfxDataEntity>();
            /***
             * 数据处理填充
             */
            SjfxDataUtil.execSjfxData(gcxdataList,gcxkeys,gcxvalues,dataValueMap,itemDataMap,"DATA");

            /*
            List yaGcxkeys=new ArrayList();
            List yaGcxvalues=new ArrayList();
            Map<String,List> yaMap=new HashMap<String,List>();
            if(gcxdataList!=null&& gcxdataList.size()>0){
                for (Map data:gcxdataList) {
                    if(!yaGcxkeys.contains(data.get("TM"))){
                        yaGcxkeys.add(data.get("TM"));
                    }//STCD
                    if(!yaGcxvalues.contains(data.get("STNM"))){
                        yaGcxvalues.add(data.get("STNM"));
                    }
                    List  yaDataList=null;
                    if(!yaMap.containsKey(data.get("STNM").toString())) {
                        yaDataList= new ArrayList();
                        yaDataList.add(data.get("DATA"));
                        yaMap.put(data.get("STNM").toString(),yaDataList);
                    }else{
                        yaDataList= yaMap.get(data.get("STNM").toString());
                        yaDataList.add(data.get("DATA"));
                        yaMap.put(data.get("STNM").toString(),yaDataList);
                    }
                }
            }
            */

            dataMap.put("RESULT_xAxisDatas",gcxkeys);//
            dataMap.put("RESULT_legendDatas",gcxvalues);//
            dataMap.put("RESULT_Datas",itemDataMap);//

             String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(dataMap);
             System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);

            return  dataMap;
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 多年平均特征值数据
     */
    @RequestMapping(value = "/getDnpjtzzList")
    @ResponseBody
    public Object getDnpjtzzList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String syear=request.getParameter("syear");
            String eyear=request.getParameter("eyear");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(10000);
            return czwyService.getDnpjtzzList(syear,eyear,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

}

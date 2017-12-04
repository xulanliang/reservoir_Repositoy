package com.dse.reservoir.sjfx.shenLiu.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.common.util.FileUtil;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.pojo.entity.SjfxDataEntity;
import com.dse.reservoir.api.sjfx.shenLiu.service.ShenLiuService;
import com.dse.reservoir.api.sjfx.shenya.service.ShenyaService;
import com.dse.reservoir.api.util.ExcelUtil;
import com.dse.reservoir.api.util.Utility;
import com.dse.reservoir.sjfx.SjfxDataUtil;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 渗流控制层
 */
@Controller
@RequestMapping("/shenLiuCtrl")
public class ShenLiuCtrl {

    @Resource(name = "shenLiuService")
    private ShenLiuService shenLiuService;
    @Resource
    private ShenyaService shenyaService;

    /**
     * 查询渗流数据
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
            return shenLiuService.getDateList(stm,etm,gcxArgs,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询渗流数据
     */
    @RequestMapping(value = "/getGcxDateList")
    @ResponseBody
    public Object getGcxDateList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
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
            List<Map> gcxdataList=(List<Map>)shenLiuService.getGcxDateList(stm,etm,gcxArgs);
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
     * 查询渗流观测记录表基础数据
     */
    @RequestMapping(value = "/getBaseDataList")
    @ResponseBody
    public Object getBaseDataList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String ppcd=request.getParameter("ppcd");
            String projcd=request.getParameter("projcd");

            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return shenLiuService.getBaseDataList(year,month,ppcd,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    /**
     * 查询渗流观测记录表统计数据
     */
    @RequestMapping(value = "/getCountDataList")
    @ResponseBody
    public Object getCountDataList(HttpServletRequest request, HttpServletResponse response,EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String ppcd=request.getParameter("ppcd");
            String projcd=request.getParameter("projcd");

            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return shenLiuService.getCountDataList(year,month,ppcd,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    /**
     * 查询渗压季（年）报表数据
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
            return shenLiuService.getjnbbList(type,year,season,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询渗流观测记录表Excel数据
     */
    @RequestMapping(value = "/getGcjlbExcel")
    @ResponseBody
    public Object getGcjlbExcel(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String ppcd=request.getParameter("ppcd");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(100000);
            List<Object> list = new ArrayList<Object>();
            List<Object> jclist = shenLiuService.getBaseDataList(year,month,ppcd,projcd,easyUiPage).getRows();
            List<Object> tjlist = shenLiuService.getCountDataList(year,month,ppcd,projcd,easyUiPage).getRows();
            list.addAll(jclist);
            list.addAll(tjlist);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 导出 渗流的 季年报表
     * @param request
     * @param response
     */
    @RequestMapping(value = "/exportSZSKJnbbExcel")
    @ResponseBody
    public void exportSZSKJnbbExcel(HttpServletRequest request, HttpServletResponse response){
        OutputStream out = null;
        try{
            String type=request.getParameter("type");
            String year=request.getParameter("year");
            String season=request.getParameter("season");
            String projcd=request.getParameter("projcd");
            String fileName = request.getParameter("fileName");     // 导出名称从调用出获取
            fileName= URLDecoder.decode(fileName, FileUtil.ENCODE_NAME_UTF_8);

            EasyUiPage easyUiPage = new EasyUiPage();
            easyUiPage.setPageSize(10000);


            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            easyUiPage =  shenLiuService.getjnbbList(type,year,season,projcd,easyUiPage);
            List<Object> list =  new ArrayList<>();
            list = easyUiPage.getRows();


            Map<String, Object> colMap =  new ListOrderedMap<>();
            colMap.put("STNM","项目");
            colMap.put("UNIT","单位");
            colMap.put("MAXDATA","最大值");
            colMap.put("MAXTM","相应日期");
            colMap.put("MINDATA","最小值");
            colMap.put("MINTM","相应日期");
            colMap.put("LASTDATA","最后一天测值");
            colMap.put("LSMAXDATA","最大值");
            colMap.put("LSMAXTM","相应日期");
            colMap.put("LSMINDATA","最小值");
            colMap.put("LSMINTM","相应日期");
            colMap.put("CKZ","参考值");

            // 列表头的上一层表头，哪几列要合并就往里面加，前面是合并列名称，后面是需要合并几列
            Map<String, Object> spanHeaderMap = new ListOrderedMap();
            spanHeaderMap.put("",3);
            spanHeaderMap.put("本季（年）度监测情况",5);
            spanHeaderMap.put("历史监测情况",4);

            JSONArray dataArray =  JSONArray.parseArray(JSON.toJSONString(list));
            //String fileName ="深圳水库_主坝_渗流量_季（年）报表.xls";

            response.setContentType("application/msexcel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("gb2312"), "iso8859-1"));
            out = response.getOutputStream();
            ExcelUtil.exportExcel(fileName, colMap,dataArray,"" , out, false,spanHeaderMap);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * 导出观测记录表
     * @param request
     * @param response
     */
    @RequestMapping(value = "/exportSZSKGcjlbExcel")
    @ResponseBody
    public void exportSZSKGcjlbExcel(HttpServletRequest request,HttpServletResponse response){
        OutputStream out = null;
        try{
            //带入页面的查询条件。
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String ppcd=request.getParameter("ppcd");
            String projcd=request.getParameter("projcd");
            String type = request.getParameter("type");
            String rows = request.getParameter("rows");
            String fileName = request.getParameter("fileName");     // 导出名称从调用出获取
            fileName= URLDecoder.decode(fileName, FileUtil.ENCODE_NAME_UTF_8);

            EasyUiPage easyUiPage = new EasyUiPage();

            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(rows) ? rows : "10000"));
           // easyUiPage =  shenLiuService.getCountDataList(year,month,ppcd,projcd,easyUiPage);

            List<Object> list = new ArrayList<Object>();

            if("1".equals(type)){
                List<Object> jclist = shenLiuService.getBaseDataList(year,month,ppcd,projcd,easyUiPage).getRows();
                list.addAll(jclist);
            }else{
                List<Object> tjlist = shenLiuService.getCountDataList(year,month,ppcd,projcd,easyUiPage).getRows();
                list.addAll(tjlist);
            }
            Map<String, Object> colMap =  new ListOrderedMap<>();
            colMap.put("XM","项目");
            colMap.put("RZ","上游水位(m)");
            colMap.put("DYP","降雨量(mm)");

            // 动态列  数据，
            String pointType = String.valueOf("2");
            List pointObj = (List) shenyaService.getPoint(projcd,pointType);
            if(Utility.isNotEmpty(pointObj) && pointObj.size() > 0){
                for (int i = 0 , len = pointObj.size() ; i< len ; i++ ){
                    Object o = pointObj.get(i);
                    Map<String,Object> map = (Map<String, Object>) pointObj.get(i);
                    colMap.put(map.get("STCD").toString(),map.get("STNM"));
                }
            }

            // 列表头的上一层表头，哪几列要合并就往里面加，前面是合并列名称，后面是需要合并几列
            Map<String, Object> spanHeaderMap = new ListOrderedMap();
            spanHeaderMap.put("",4);
            spanHeaderMap.put("测点编号（单位：l/s）",pointObj.size());

            JSONArray dataArray =  JSONArray.parseArray(JSON.toJSONString(list));
            //String fileName ="深圳水库_主坝_渗流_观测记录表.xls";

            response.setContentType("application/msexcel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("gb2312"), "iso8859-1"));
            out = response.getOutputStream();
            ExcelUtil.exportExcel(fileName, colMap,dataArray,"" , out, false,spanHeaderMap);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

}

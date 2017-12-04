package com.dse.reservoir.sjfx.shuiwei.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.common.util.FileUtil;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.shenya.service.ShenyaService;
import com.dse.reservoir.api.sjfx.shuiwei.service.DggcAllDataService;
import com.dse.reservoir.api.util.ExcelUtil;
import com.dse.reservoir.api.util.Utility;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
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
import java.util.List;
import java.util.Map;

/**
 * 东改工程数据整合
 */
@Controller
@RequestMapping("/dggcAllDataCtr")
public class DggcAllDataCtr {
    @Resource(name = "dggcAllDataService")
    private DggcAllDataService dggcAllDataService;
    @Resource(name = "shenyaService")
    private ShenyaService shenyaService;


    /**
     * 查询东改工程数据
     */
    @RequestMapping(value = "/getDggcAllData")
    @ResponseBody
    public Object getDggcAllData(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return dggcAllDataService.getDggcAllData(year,month,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询东改工程_观测记录表统计数据
     */
    @RequestMapping(value = "/getGcjlbTJList")
    @ResponseBody
    public Object getGcjlbTJList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return dggcAllDataService.getGcjlbTJList(year,month,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询工改工程季（年）报表数据
     */
    @RequestMapping(value = "/getjnbbListDg")
    @ResponseBody
    public Object getjnbbListDg(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String type=request.getParameter("type");
            String year=request.getParameter("year");
            String season=request.getParameter("season");
            String projcd=request.getParameter("projcd");
            String st_tp=request.getParameter("st_tp");

            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return dggcAllDataService.getjnbbListDg(type,year,season,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 东改工程多年平均特征值数据
     */
    @RequestMapping(value = "/getDnpjtzzList")
    @ResponseBody
    public Object getDnpjtzzList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String syear=request.getParameter("syear");
            String eyear=request.getParameter("eyear");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(10000);
            return dggcAllDataService.getDnpjtzzList(syear,eyear,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 导出观测记录表
     * @param request
     * @param response
     * @param data
     */
    @RequestMapping(value = "/exportGcjlbExcel")
    @ResponseBody
    public void exportGcjlbExcel(HttpServletRequest request,HttpServletResponse response,String data ){
        OutputStream out = null;
        try{
            //带入页面的查询条件。
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String projcd=request.getParameter("projcd");
            String fileName = request.getParameter("fileName");     // 导出名称从调用出获取
            fileName= URLDecoder.decode(fileName, FileUtil.ENCODE_NAME_UTF_8);

            EasyUiPage easyUiPage = new EasyUiPage();
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows")) ? request.getParameter("rows") : "10000"));
            List<Object> list = new ArrayList<Object>();
            List<Object> jclist = dggcAllDataService.getDggcAllData(year,month,projcd,easyUiPage).getRows();
            List<Object> tjlist = dggcAllDataService.getGcjlbTJList(year,month,projcd,easyUiPage).getRows();

            //添加数据
            list.addAll(jclist);
            list.addAll(tjlist);
            Map<String, Object> colMap =  new ListOrderedMap<>();
            colMap.put("XM","项目");

            // 动态列  数据，

            List pointObj = (List) shenyaService.getPoint(projcd,"5");
            if(Utility.isNotEmpty(pointObj) && pointObj.size() > 0){
                for (int i = 0 , len = pointObj.size() ; i< len ; i++ ){
                    Object o = pointObj.get(i);
                    Map<String,Object> map = (Map<String, Object>) pointObj.get(i);
                    colMap.put(map.get("STCD").toString(),map.get("STNM"));
                }
            }

            // 列表头的上一层表头，哪几列要合并就往里面加，前面是合并列名称，后面是需要合并几列
            Map<String, Object> spanHeaderMap = new ListOrderedMap();
            spanHeaderMap.put("",2);
            spanHeaderMap.put("测点名称",pointObj.size());

            JSONArray dataArray =  JSONArray.parseArray(JSON.toJSONString(list));
            //  String fileName ="深圳水库_主坝_渗压_观测记录表.xls";

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
     * 导出 工改工程 季年报表
     * @param request
     * @param response
     */
    @RequestMapping(value = "/exportJnbbExcel")
    @ResponseBody
    public void exportJnbbExcel(HttpServletRequest request, HttpServletResponse response){
        OutputStream out = null;
        try{
            String type=request.getParameter("type");
            String year=request.getParameter("year");
            String season=request.getParameter("season");
            String projcd=request.getParameter("projcd");

            String fileName = request.getParameter("fileName");     // 导出名称从调用出获取
            fileName= URLDecoder.decode(fileName, FileUtil.ENCODE_NAME_UTF_8);

            EasyUiPage easyUiPage = new EasyUiPage();
            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10000"));
            List<Object> list = dggcAllDataService.getjnbbListDg(type,year,season,projcd,easyUiPage).getRows();

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

            // 列表头的上一层表头，哪几列要合并就往里面加，前面是合并列名称，后面是需要合并几列
            Map<String, Object> spanHeaderMap = new ListOrderedMap();
            spanHeaderMap.put("",3);
            spanHeaderMap.put("本季（年）度监测情况",5);
            spanHeaderMap.put("历史监测情况",4);

            JSONArray dataArray =  JSONArray.parseArray(JSON.toJSONString(list));

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

package com.dse.reservoir.sjfx.shenya.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.common.util.FileUtil;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.sjfx.pojo.entity.SjfxDataEntity;
import com.dse.reservoir.api.sjfx.pojo.entity.WrrbmEntity;
import com.dse.reservoir.api.sjfx.shenya.service.ShenyaService;
import com.dse.reservoir.api.sjfx.wrwarningb.pojo.WrWarningbModel;
import com.dse.reservoir.api.util.ExcelUtil;
import com.dse.reservoir.api.util.Utility;
import com.dse.reservoir.sjfx.SjfxDataUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 渗压控制层
 */
@Controller
@RequestMapping("/shenyaCtrl")
public class ShenyaCtrl {

    @Resource(name = "shenyaService")
    private ShenyaService shenyaService;

    /**
     * 获取子项目
     * @return
     */
    @RequestMapping(value = "/getProject")
    @ResponseBody
    public Object getProject(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String projcd=request.getParameter("projcd");
            return InvokeResult.success(shenyaService.getProject(projcd));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取断面ID
     * @param projcd
     * @param st_tp
     * @return
     * @throws Exception
     */
    public Object getDmID(String projcd,String st_tp) throws Exception{
        try {
            return shenyaService.getDmID(projcd,st_tp);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取断面
     * @return
     */
    @RequestMapping(value = "/getRb")
    @ResponseBody
    public Object getRb(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String proj_cd_two=request.getParameter("projcd");
            String rb_cd=request.getParameter("rb_cd");
            String proj_cd_one=request.getParameter("proj_cd_one");
            String item_cd=request.getParameter("item_cd");
            String rb_type=request.getParameter("rb_type");
            String st_tp=request.getParameter("st_tp");

            WrrbmEntity args=new WrrbmEntity();
            args.setItem_cd(item_cd);
            args.setProj_cd_one(proj_cd_one);
            args.setProj_cd_two(proj_cd_two);
            args.setRb_cd(rb_cd);
            args.setRb_type(rb_type);
            args.setSt_tp_list(st_tp);

            return InvokeResult.success(shenyaService.getRb(args));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取测点
     * @return
     */
    @RequestMapping(value = "/getPoint")
    @ResponseBody
    public Object getPoint(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String projcd=request.getParameter("projcd");
            String type=request.getParameter("type");
            return InvokeResult.success(shenyaService.getPoint(projcd,type));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 通过断面获取测点
     * @return
     */
    @RequestMapping(value = "/getPointByRb")
    @ResponseBody
    public Object getPointByRb(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String rbcd=request.getParameter("rbcd");
            String projcd=request.getParameter("projcd");
            String st_tp=request.getParameter("st_tp");
            List list = (List) getDmID(projcd,st_tp);
//            return InvokeResult.success(shenyaService.getPointByRb(rbcd));
            return InvokeResult.success(shenyaService.getColByIds(list));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取测点
     * @return
     */
    @RequestMapping(value = "/getStcd")
    @ResponseBody
    public Object getStcd(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String rbcd=request.getParameter("rbcd");
            if("".equals(rbcd)){
                String projcd=request.getParameter("projcd");
                // 解决中文出现乱码的问题
                String type= new String(request.getParameter("type").getBytes("ISO8859-1"), "UTF-8");
                return InvokeResult.success(shenyaService.getPoint(projcd,type));
            }else{
                return InvokeResult.success(shenyaService.getPointByRb(rbcd));
            }
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询渗压数据
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
            return shenyaService.getDateList(stm,etm,gcxArgs,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询渗压数据
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
            List<Map> gcxdataList=(List<Map>)shenyaService.getGcxDateList(stm,etm,gcxArgs);
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
     * 查询渗压季（年）报表数据
     */
    @RequestMapping(value = "/getjnbbList")
    @ResponseBody
    public Object getjnbbList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String type=request.getParameter("type");
            String year=request.getParameter("year");
            String season=request.getParameter("season");
            String rbcd=request.getParameter("RB_CD");

            String st_tp=request.getParameter("st_tp");     //测点类型（1:渗压 2 渗流 3 水平位移4垂直位移5水位6雨量7气温<含气压>8深层位移9渡槽沉降);例：3,5
            String projcd=request.getParameter("projcd");     //工程编码
            List list = (List) getDmID(projcd,st_tp);

            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return shenyaService.getjnbbList(type,year,season,rbcd,list,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询渗压季（年）报表数据
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
            return shenyaService.getjnbbListDg(type,year,season,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询渗压特征值数据
     */
    @RequestMapping(value = "/getSytzzbbList")
    @ResponseBody
    public Object getSytzzbbList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String ppcd=request.getParameter("ppcd");
            String rbcd=request.getParameter("RB_CD");
            easyUiPage.setPageSize(10000);
            String st_tp=request.getParameter("st_tp");     //测点类型（1:渗压 2 渗流 3 水平位移4垂直位移5水位6雨量7气温<含气压>8深层位移9渡槽沉降);例：3,5
            String projcd=request.getParameter("projcd");     //工程编码
            List list = (List) getDmID(projcd,st_tp);

            return shenyaService.getSytzzbbList(year,month,ppcd,rbcd,list,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询渗压特征值数据
     */
    @RequestMapping(value = "/getSytzzbbListDg")
    @ResponseBody
    public Object getSytzzbbListDg(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String ppcd=request.getParameter("ppcd");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(10000);
            return shenyaService.getSytzzbbListDg(year,month,ppcd,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询渗压观测记录表基础数据
     */
    @RequestMapping(value = "/getGcjlbList")
    @ResponseBody
    public Object getGcjlbList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String ppcd=request.getParameter("ppcd");
            String rbcd=request.getParameter("RB_CD");

            String st_tp=request.getParameter("st_tp");     //测点类型（1:渗压 2 渗流 3 水平位移4垂直位移5水位6雨量7气温<含气压>8深层位移9渡槽沉降);例：3,5
            String projcd=request.getParameter("projcd");     //工程编码
            List list = (List) getDmID(projcd,st_tp);
            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return shenyaService.getGcjlbList(year,month,ppcd,rbcd,list,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询渗压观测记录表基础数据
     */
    @RequestMapping(value = "/getGcjlbListDg")
    @ResponseBody
    public Object getGcjlbListDg(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String ppcd=request.getParameter("ppcd");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return shenyaService.getGcjlbListDg(year,month,ppcd,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询渗压观测记录表统计数据
     */
    @RequestMapping(value = "/getGcjlbTJList")
    @ResponseBody
    public Object getGcjlbTJList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String ppcd=request.getParameter("ppcd");
            String rbcd=request.getParameter("RB_CD");
            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));

            String st_tp=request.getParameter("st_tp");     //测点类型（1:渗压 2 渗流 3 水平位移4垂直位移5水位6雨量7气温<含气压>8深层位移9渡槽沉降);例：3,5
            String projcd=request.getParameter("projcd");     //工程编码
            List list = (List) getDmID(projcd,st_tp);

            return shenyaService.getGcjlbTJList(year,month,ppcd,rbcd,list,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询渗压观测记录表统计数据
     */
    @RequestMapping(value = "/getGcjlbTJListDg")
    @ResponseBody
    public Object getGcjlbTJListDg(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String ppcd=request.getParameter("ppcd");
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return shenyaService.getGcjlbTJListDg(year,month,ppcd,projcd,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询渗压观测记录表Excel数据
     */
    @RequestMapping(value = "/getGcjlbExcel")
    @ResponseBody
    public Object getGcjlbExcel(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String ppcd=request.getParameter("ppcd");
            String rbcd=request.getParameter("RB_CD");
            easyUiPage.setPageSize(100000);
            List<Object> list = new ArrayList<Object>();
            List<Object> jclist = shenyaService.getGcjlbList(year,month,ppcd,rbcd,list,easyUiPage).getRows();
            List<Object> tjlist = shenyaService.getGcjlbTJList(year,month,ppcd,rbcd,list,easyUiPage).getRows();
            list.addAll(jclist);
            list.addAll(tjlist);
            return list;
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
    @RequestMapping(value = "/export2Excel")
    @ResponseBody
    public void export2Excel(HttpServletRequest request,HttpServletResponse response,String data ){
        OutputStream out = null;
        try{
            //带入页面的查询条件。
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String ppcd=request.getParameter("ppcd");
            String projcd=request.getParameter("projcd");
            String rbcd=request.getParameter("RB_CD");
            String type = request.getParameter("type");
            String fileName = request.getParameter("fileName");     // 导出名称从调用出获取
            String st_tp = request.getParameter("st_tp");     // 导出名称从调用出获取
            fileName= URLDecoder.decode(fileName, FileUtil.ENCODE_NAME_UTF_8);

            EasyUiPage easyUiPage = new EasyUiPage();
//            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows")) ? request.getParameter("rows") : "10"));
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows")) ? "31" : "10"));
            List listData = (List) getDmID(projcd,st_tp);

            List<Object> list = new ArrayList<Object>();
            List<Object> jclist = shenyaService.getGcjlbList(year,month,ppcd,rbcd,listData,easyUiPage).getRows();
            List<Object> tjlist = shenyaService.getGcjlbTJList(year,month,ppcd,rbcd,listData,easyUiPage).getRows();
//            if("1".equals(type)){
//                list.addAll(jclist);
//            }else{
//                list.addAll(tjlist);
//            }
            list.addAll(jclist);
            list.addAll(tjlist);
            Map<String, Object> colMap =  new ListOrderedMap<>();
            colMap.put("XM","项目");
            colMap.put("RZ","水库水位(m)");
            colMap.put("DYP","降雨量(mm)");
            colMap.put("AIRP","气压(kpa)");
            colMap.put("ATMP","气温(℃");

            // 动态列  数据，
//            List pointObj = (List) shenyaService.getPointByRb(rbcd);
            List listt = (List) getDmID(projcd,st_tp);
            List pointObj = (List) shenyaService.getColByIds(listt);
            if(Utility.isNotEmpty(pointObj) && pointObj.size() > 0){
                for (int i = 0 , len = pointObj.size() ; i< len ; i++ ){
                    Object o = pointObj.get(i);
                    Map<String,Object> map = (Map<String, Object>) pointObj.get(i);
                    colMap.put(map.get("STCD").toString(),map.get("STNM"));
                }
            }

            // 列表头的上一层表头，哪几列要合并就往里面加，前面是合并列名称，后面是需要合并几列
            Map<String, Object> spanHeaderMap = new ListOrderedMap();
            spanHeaderMap.put("",6);
            spanHeaderMap.put("测点编号（单位：m）",pointObj.size());

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
     * 导出深圳水库季  年 报表
     * @param request
     * @param response
     */
    @RequestMapping(value = "/exportSZSKJnbbExcel")
    @ResponseBody
    public void exportSZSKJnbbExcel(HttpServletRequest request,HttpServletResponse response){
        OutputStream out = null;
        try{
            String projcd = request.getParameter("projcd");
            String st_tp = request.getParameter("st_tp");
            String type=request.getParameter("type");
            String year=request.getParameter("year");
            String ppcd=request.getParameter("ppcd");
            String season=request.getParameter("season");
            String rbcd=request.getParameter("RB_CD");
            String queryType = request.getParameter("queryType");    //查询的来源
            String fileName = request.getParameter("fileName");     // 导出名称从调用出获取
            fileName= URLDecoder.decode(fileName, FileUtil.ENCODE_NAME_UTF_8);
            List listData = (List) getDmID(projcd,st_tp);


            EasyUiPage easyUiPage = new EasyUiPage();
            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            if("szsk".equals(queryType)){
                easyUiPage =  shenyaService.getjnbbList(type,year,season,rbcd,listData,easyUiPage);

            }else{
                easyUiPage = shenyaService.getjnbbListDg(type,year,season,projcd,easyUiPage);
            }
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
            colMap.put("FXPD","分析判断");
            colMap.put("JL","结论");

            // 列表头的上一层表头，哪几列要合并就往里面加，前面是合并列名称，后面是需要合并几列
            Map<String, Object> spanHeaderMap = new ListOrderedMap();
            spanHeaderMap.put("",3);
            spanHeaderMap.put("本季（年）度监测情况",5);
            spanHeaderMap.put("历史监测情况",4);
            spanHeaderMap.put("",3);

            JSONArray dataArray =  JSONArray.parseArray(JSON.toJSONString(list));
            //String fileName ="";

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
     *导出深圳水库渗压特征值 报表
     */
    @RequestMapping(value = "/exportSZSKSytzzExcel")
    @ResponseBody
    public void exportSZSKSytzzExcel(HttpServletRequest request,HttpServletResponse response){
        OutputStream out = null;
        try{
            String year=request.getParameter("year");
            String month=request.getParameter("month");
            String ppcd=request.getParameter("ppcd");
            String rbcd=request.getParameter("RB_CD");
            String fileName = request.getParameter("fileName");     // 导出名称从调用出获取
            fileName= URLDecoder.decode(fileName, FileUtil.ENCODE_NAME_UTF_8);

            EasyUiPage easyUiPage = new EasyUiPage();
            easyUiPage.setPageSize(10000);
            String st_tp=request.getParameter("st_tp");     //测点类型（1:渗压 2 渗流 3 水平位移4垂直位移5水位6雨量7气温<含气压>8深层位移9渡槽沉降);例：3,5
            String projcd=request.getParameter("projcd");     //工程编码
            List listt = (List) getDmID(projcd,st_tp);


            easyUiPage.setPageSize(Integer.valueOf(StringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            easyUiPage =  shenyaService.getSytzzbbList(year,month,ppcd,rbcd,listt,easyUiPage);
            List<Object> list =  new ArrayList<>();
            list = easyUiPage.getRows();

            Map<String, Object> colMap =  new ListOrderedMap<>();
            colMap.put("RB_NM","断面");
            colMap.put("STNM","测点编号");
            colMap.put("MAXDATA","数值(m)");
            colMap.put("MAXTM","对应日期");
            colMap.put("MAXRZ","当日上游水位");
            colMap.put("MAXATMP","当日气温");
            colMap.put("MAXDYP","当日降雨");
            colMap.put("MINDATA","数值(m)");
            colMap.put("MINTM","对应日期");
            colMap.put("MINRZ","当日上游水位");
            colMap.put("MINATMP","当日气温");
            colMap.put("MINDYP","当日降雨");
            colMap.put("BF","变幅(m)");
            colMap.put("AVGDATA","平均值(m)");

            // 列表头的上一层表头，哪几列要合并就往里面加，前面是合并列名称，后面是需要合并几列
            Map<String, Object> spanHeaderMap = new ListOrderedMap();
            spanHeaderMap.put("",3);
            spanHeaderMap.put("最高渗压水位",5);
            spanHeaderMap.put("最低渗压水位",6);
            spanHeaderMap.put("",2);

            JSONArray dataArray =  JSONArray.parseArray(JSON.toJSONString(list));
            //String fileName ="深圳水库_主坝_渗压_季（年）报表.xls";
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

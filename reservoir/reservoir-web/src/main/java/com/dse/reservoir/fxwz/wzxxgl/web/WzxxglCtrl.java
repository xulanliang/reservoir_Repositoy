package com.dse.reservoir.fxwz.wzxxgl.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.common.util.FileUtil;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wzxxgl.service.WzxxglService;
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
 * 物资信息管理
 */
@Controller
@RequestMapping(value = "wzxxglCtrl")
public class WzxxglCtrl {

    @Resource(name = "wzxxglService")
    private WzxxglService wzxxglService;

    @RequestMapping(value = "/getListInfoByParams")
    @ResponseBody
    public Object getListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String name=request.getParameter("name");
            String type=request.getParameter("wztype");
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wzxxglService.getListInfoByParams(name,type,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getInfoById")
    @ResponseBody
    public Object getInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String id=request.getParameter("id");
            return InvokeResult.success(wzxxglService.getInfoById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getListWzCkPcBinInfoByParams")
    @ResponseBody
    public Object getListWzCkPcBinInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String name=request.getParameter("name");
            String type=request.getParameter("wztype");
            String org_cd=request.getParameter("org_cd");
            String wh_cd=request.getParameter("wh_cd");
            String ma_status=request.getParameter("ma_status");
            FxWzArgModel args =new FxWzArgModel();
            args.setMa_nm(name);
            args.setType(type);
            args.setMa_status(ma_status);
            args.setOrg_cd(org_cd);
            args.setWh_cd(wh_cd);
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wzxxglService.getListWzCkPcBinInfoByParams(args,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/export2Excel")
    @ResponseBody
    public void export2Excel(HttpServletRequest request,HttpServletResponse response,String data ){
        OutputStream out = null;
        try{
            //带入页面的查询条件。
            String name=request.getParameter("name");
            String type=request.getParameter("wztype");
            String org_cd=request.getParameter("org_cd");
            String wh_cd=request.getParameter("wh_cd");
            String ma_status=request.getParameter("ma_status");
            FxWzArgModel args =new FxWzArgModel();
            args.setMa_nm(name);
            args.setType(type);
            args.setMa_status(ma_status);
            args.setOrg_cd(org_cd);
            args.setWh_cd(wh_cd);
            String fileName = request.getParameter("fileName");     // 导出名称从调用出获取
            fileName= URLDecoder.decode(fileName, FileUtil.ENCODE_NAME_UTF_8);

            EasyUiPage easyUiPage = new EasyUiPage();
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows")) ? request.getParameter("rows") : "10"));

            List<Object> list = new ArrayList<Object>();
            List<Object> jclist = wzxxglService.getListWzCkPcBinInfoByParamsNew(args,easyUiPage).getRows();
//            if("1".equals(type)){
//                list.addAll(jclist);
//            }else{
//                list.addAll(tjlist);
//            }
            list.addAll(jclist);
            Map<String, Object> colMap =  new ListOrderedMap<>();
            //列数据
            colMap.put("MA_NM","物资名称");
            colMap.put("NAME","管理部门");
            colMap.put("WH_NM","仓库名称");
            colMap.put("MODEL","规格或型号");
            colMap.put("MU","单位");
            colMap.put("BINNUM","货柜");
            colMap.put("REAL_QUAN","库存量");
            colMap.put("LOC","所在地点");
            colMap.put("STD_YEAR","参考储备年限");
            colMap.put("STD_QUAN","仓库存储定额");
            colMap.put("GS_STD_QUAN","公司储备定额");
            colMap.put("SL_STD_QUAN","水利部定额");

            // 列表头的上一层表头，哪几列要合并就往里面加，前面是合并列名称，后面是需要合并几列
            Map<String, Object> spanHeaderMap = new ListOrderedMap();

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

    @RequestMapping(value = "/getListWzCkPcBinInfoByParamsNew")
    @ResponseBody
    public Object getListWzCkPcBinInfoByParamsNew(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String name=request.getParameter("name");
            String type=request.getParameter("wztype");
            String org_cd=request.getParameter("org_cd");
            String wh_cd=request.getParameter("wh_cd");
            String ma_status=request.getParameter("ma_status");
            FxWzArgModel args =new FxWzArgModel();
            args.setMa_nm(name);
            args.setType(type);
            args.setMa_status(ma_status);
            args.setOrg_cd(org_cd);
            args.setWh_cd(wh_cd);
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wzxxglService.getListWzCkPcBinInfoByParamsNew(args,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getWzCkPcBinInfoById")
    @ResponseBody
    public Object getWzCkPcBinInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String wh_cd=request.getParameter("wh_cd");//仓库
            String ma_cd=request.getParameter("ma_cd");//物资
            String ma_pc=request.getParameter("ma_pc");//
            String binnum=request.getParameter("binnum");//年份
            FxWzArgModel args=new FxWzArgModel();
            args.setMa_cd(ma_cd);
            args.setWh_cd(wh_cd);
            args.setMa_pc(ma_pc);
            args.setBinnum(binnum);

            return InvokeResult.success(wzxxglService.getWzCkPcBinInfoById(args));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/saveOrUpdateInfo")
    @ResponseBody
    public Object saveOrUpdateInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(wzxxglService.saveOrUpdateInfo(dataStr));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/deleteInfoByIds")
    @ResponseBody
    public Object deleteInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(wzxxglService.deleteInfoByIds(ids));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

}

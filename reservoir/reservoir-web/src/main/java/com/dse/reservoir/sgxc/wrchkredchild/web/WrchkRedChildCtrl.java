package com.dse.reservoir.sgxc.wrchkredchild.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.common.util.FileUtil;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.sgxc.wrchkredchild.pojo.WrchkRedChildModel;
import com.dse.reservoir.api.sgxc.wrchkredchild.service.WrchkRedChildService;
import com.dse.reservoir.api.util.ExcelUtil;
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

/****
 * 巡查记录项目详情表
 * 20170808
 */
@Controller
@RequestMapping("/wrchkredchildCtrl")
public class WrchkRedChildCtrl {

    @Resource(name = "wrchkRedChildService")
    private WrchkRedChildService wrchkRedChildService;

    @RequestMapping(value = "/getListInfoByParamsList")
    @ResponseBody
    public Object getListInfoByParamsList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ck_obj_id=request.getParameter("ck_obj_id");//
            String ck_cnt_desc=request.getParameter("search_ck_cnt_desc");//
            String ch_status=request.getParameter("search_ch_status");//
            String ck_re_id=request.getParameter("search_ck_re_id");//
            String search_ck_re_page=request.getParameter("search_ck_re_page");//
            String problem=request.getParameter("problem");//
            String ques_status=request.getParameter("ques_status");//

            WrchkRedChildModel args=new WrchkRedChildModel();
            args.setCk_re_id(ck_re_id);
            args.setCk_obj_id(ck_obj_id);
            args.setCh_status(ch_status);
            args.setCk_cnt_desc(ck_cnt_desc);
            args.setSearch_ck_re_page(search_ck_re_page);
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wrchkRedChildService.getListInfoByParams(ques_status,problem,args,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getListInfoByParams")
    @ResponseBody
    public Object getListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ck_obj_id=request.getParameter("ck_obj_id");//
            String ck_cnt_desc=request.getParameter("search_ck_cnt_desc");//
            String ch_status=request.getParameter("search_ch_status");//
            String ck_re_id=request.getParameter("search_ck_re_id");//
            String search_ck_re_page=request.getParameter("search_ck_re_page");//
            String problem=request.getParameter("problem");//
            String ques_status=request.getParameter("ques_status");//

            WrchkRedChildModel args=new WrchkRedChildModel();
            args.setCk_re_id(ck_re_id);
            args.setCk_obj_id(ck_obj_id);
            args.setCh_status(ch_status);
            args.setCk_cnt_desc(ck_cnt_desc);
            args.setSearch_ck_re_page(search_ck_re_page);

            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wrchkRedChildService.getListInfoByParams(ques_status,problem,args,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getList")
    @ResponseBody
    public Object getList(HttpServletRequest request, HttpServletResponse response){
        try {
            String ck_obj_id=request.getParameter("ck_obj_id");//
            String notcktkid=request.getParameter("notcktkid");//
            String id=request.getParameter("id");//

            WrchkRedChildModel args=new WrchkRedChildModel();
            args.setCk_obj_id(ck_obj_id);
            args.setId(id);

            return InvokeResult.success(wrchkRedChildService.getList(args,notcktkid));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    //导出
    @RequestMapping(value = "/export2Excel")
    @ResponseBody
    public void export2Excel(HttpServletRequest request,HttpServletResponse response,String data ){
        OutputStream out = null;
        try{
            //带入页面的查询条件。
            String search_ck_re_id=request.getParameter("ck_re_id");
            String search_ck_cnt_desc=request.getParameter("search_ck_cnt_desc");
            String search_ch_status=request.getParameter("search_ch_status");
            WrchkRedChildModel args=new WrchkRedChildModel();
            args.setCk_re_id(search_ck_re_id);
            args.setCh_status(search_ch_status);
            args.setCk_cnt_desc(search_ck_cnt_desc);
            String fileName = request.getParameter("fileName");     // 导出名称从调用出获取
            fileName= URLDecoder.decode(fileName, FileUtil.ENCODE_NAME_UTF_8);

            EasyUiPage easyUiPage = new EasyUiPage();
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows")) ? request.getParameter("rows") : "10"));

            List<Object> list = new ArrayList<Object>();
            List<Object> jclist = wrchkRedChildService.getListInfoByParams(search_ch_status,null,args,easyUiPage).getRows();
            list.addAll(jclist);
            Map<String, Object> colMap =  new ListOrderedMap<>();
            //列数据
            colMap.put("CK_OBJ_ID_NAME","部位");
            colMap.put("CK_CNT_DESC","巡查内容及标准");
            colMap.put("CK_TM_REQ","周期");
            colMap.put("ISU_DESC","存在问题");

            // 列表头的上一层表头，哪几列要合并就往里面加，前面是合并列名称，后面是需要合并几列
            Map<String, Object> spanHeaderMap = new ListOrderedMap();
            spanHeaderMap.put("建筑物名称：",0);

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

    @RequestMapping(value = "/getCount")
    @ResponseBody
    public Object getCount(HttpServletRequest request, HttpServletResponse response,WrchkRedChildModel bean){
        try {
            String id=request.getParameter("id");//
            String ck_obj_id=request.getParameter("ck_obj_id");//

            WrchkRedChildModel args=new WrchkRedChildModel();
            args.setCk_obj_id(ck_obj_id);
            args.setId(id);


            return InvokeResult.success(wrchkRedChildService.getCount(args));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getInfoById")
    @ResponseBody
    public Object getInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String id=request.getParameter("id");
            return InvokeResult.success(wrchkRedChildService.getInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/updateStautsByIds")
    @ResponseBody
    public Object updateStautsByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            String ch_status=request.getParameter("ch_status");
            return InvokeResult.success(wrchkRedChildService.updateStautsByIds(ids,ch_status));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/saveOrUpdateInfo")
    @ResponseBody
    public Object saveOrUpdateInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(wrchkRedChildService.saveOrUpdateInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/deleteInfoByIds")
    @ResponseBody
    public Object deleteInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(wrchkRedChildService.deleteInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
}

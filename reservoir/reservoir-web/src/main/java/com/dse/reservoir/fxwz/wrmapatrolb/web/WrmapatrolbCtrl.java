package com.dse.reservoir.fxwz.wrmapatrolb.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.common.util.FileUtil;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wrmapatrolb.service.WrMaPatrolbService;
import com.dse.reservoir.api.fxwz.wzxxgl.service.WzxxglService;
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
import java.util.List;
import java.util.Map;

/**
 * 物资信息管理
 */
@Controller
@RequestMapping(value = "wrmapatrolbCtrl")
public class WrmapatrolbCtrl {

    @Resource(name = "wrmapatrolbService")
    private WrMaPatrolbService wrmapatrolbService;

    @RequestMapping(value = "/getListInfoByParams")
    @ResponseBody
    public Object getListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String desc=request.getParameter("desc");
            String org_cd=request.getParameter("org_cd");
            String wh_cd=request.getParameter("wh_cd");
            String is_flood=request.getParameter("is_flood");
            String stm=request.getParameter("stm");
            String etm=request.getParameter("etm");
            String pa_status=request.getParameter("pa_status");
            FxWzArgModel args=new FxWzArgModel();
            args.setOrg_cd(org_cd);
            args.setWh_cd(wh_cd);
            args.setIs_flood(is_flood);
            args.setStm(stm);
            args.setEtm(etm);
            args.setPa_status(pa_status);
            args.setDesc(desc);

            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wrmapatrolbService.getListInfoByParams(args,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  获取物资巡查内容
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getListWZXCNRInfoByParams")
    @ResponseBody
    public Object getListWZXCNRInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String isflood=request.getParameter("isflood");
            easyUiPage.setPageSize(1000);
            return wrmapatrolbService.getListWZXCNRInfoByParams(isflood,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  导出 防汛物资巡查表
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
            String search_ck_re_id=request.getParameter("search_ck_re_id");
            String isflood = request.getParameter("isflood");     // 导出名称从调用出获取
            String fileName = request.getParameter("fileName");     // 导出名称从调用出获取
            fileName= URLDecoder.decode(fileName, FileUtil.ENCODE_NAME_UTF_8);

            EasyUiPage easyUiPage = new EasyUiPage();
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows")) ? request.getParameter("rows") : "10"));

            List<Object> list = new ArrayList<Object>();
            List<Object> jclist = wrmapatrolbService.getWZXCListInfoByParams(search_ck_re_id,null,null,easyUiPage).getRows();
            list.addAll(jclist);
            Map<String, Object> colMap =  new ListOrderedMap<>();
            //列数据
            colMap.put("CK_CNT_DESC","巡查内容");
            colMap.put("ISU_DESC","存在问题");
            colMap.put("ISU_DURE","处理措施");
            colMap.put("PL_TIME","计划完成时间");
            colMap.put("CK_USER","检察人员");
            colMap.put("LS_QU","落实情况");
            colMap.put("TM","完成时间");


            // 列表头的上一层表头，哪几列要合并就往里面加，前面是合并列名称，后面是需要合并几列
            Map<String, Object> spanHeaderMap = new ListOrderedMap();
            spanHeaderMap.put("巡察单位：                                    巡查时间：                                  记录编号：",8);
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


    @RequestMapping(value = "/getWZXCListInfoByParams")
    @ResponseBody
    public Object getWZXCListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String search_ck_re_id=request.getParameter("search_ck_re_id");
            String search_ck_cnt_desc=request.getParameter("search_ck_cnt_desc");
            String search_ch_status=request.getParameter("search_ch_status");
            return wrmapatrolbService.getWZXCListInfoByParams(search_ck_re_id,search_ck_cnt_desc,search_ch_status,easyUiPage);
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
            return InvokeResult.success(wrmapatrolbService.getInfoById(id));
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
            return InvokeResult.success(wrmapatrolbService.saveOrUpdateInfo(dataStr));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  保存物资巡查上报
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/doSave")
    @ResponseBody
    public Object doSave(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String taskID=request.getParameter("taskID");
            return InvokeResult.success(wrmapatrolbService.doSave(taskID));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  保存物资巡查上报
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveXcsb")
    @ResponseBody
    public Object saveXcsb(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ckID=request.getParameter("ckID");
            String issue=request.getParameter("issue");
            String issueID=request.getParameter("issueID");
            String taskID=request.getParameter("taskID");
            return InvokeResult.success(wrmapatrolbService.saveXcsb(ckID,issue,issueID,taskID));
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
            return InvokeResult.success(wrmapatrolbService.deleteInfoByIds(ids));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/updateStautsByIds")
    @ResponseBody
    public Object updateStautsByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            String status=request.getParameter("status");
            return InvokeResult.success(wrmapatrolbService.updateStautsByIds(ids,status));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

}

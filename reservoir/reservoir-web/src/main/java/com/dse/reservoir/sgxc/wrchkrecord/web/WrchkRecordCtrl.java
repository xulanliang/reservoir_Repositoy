package com.dse.reservoir.sgxc.wrchkrecord.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.sgxc.wrchkrecord.pojo.WrchkRecordModel;
import com.dse.reservoir.api.sgxc.wrchkrecord.service.WrchkRecordService;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/****
 * 物资库存管理
 * 20170808
 */
@Controller
@RequestMapping("/wrchkRecordCtrl")
public class WrchkRecordCtrl {

    @Resource(name = "wrchkRecordService")
    private WrchkRecordService wrchkRecordService;

    @RequestMapping(value = "/getListInfoByParams")
    @ResponseBody
    public Object getListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ck_obj_id=request.getParameter("ck_obj_id");//
            String ck_tk_desc=request.getParameter("ck_tk_desc");//
            String ck_org=request.getParameter("CK_ORG");//
            String status=request.getParameter("STATUS");//
            String ck_type=request.getParameter("CK_TYPE");//
            String ck_object=request.getParameter("CK_OBJECT");//

            WrchkRecordModel args=new WrchkRecordModel();
            args.setCk_org(ck_org);
            args.setCk_type(ck_type);
            args.setStatus(status);
            args.setCk_tk_desc(ck_tk_desc);
            args.setCk_obj_id(ck_obj_id);
            args.setCk_object(ck_object);

            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wrchkRecordService.getListInfoByParams(args,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/getXctjListInfoByParams")
    @ResponseBody
    public Object getXctjListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String sTime=request.getParameter("sTime");
            String eTime=request.getParameter("eTime");
            String dep_name=request.getParameter("dep_name");
            String ck_type=request.getParameter("ck_type");

            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wrchkRecordService.getXctjListInfoByParams(sTime,eTime,dep_name,ck_type,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getWrchkRecordList")
    @ResponseBody
    public Object getWrchkRecordList(HttpServletRequest request, HttpServletResponse response){
        try {
            String ck_obj_id=request.getParameter("ck_obj_id");//
            String notcktkid=request.getParameter("notcktkid");//
            String ck_tk_id=request.getParameter("ck_tk_id");//

            WrchkRecordModel args=new WrchkRecordModel();
            args.setCk_obj_id(ck_obj_id);
            args.setCk_tk_id(ck_tk_id);

            return InvokeResult.success(wrchkRecordService.getWrchkTaskList(args,notcktkid));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getWrchkRecordCount")
    @ResponseBody
    public Object getWrchkRecordCount(HttpServletRequest request, HttpServletResponse response,WrchkRecordModel bean){
        try {
            String ck_tk_id=request.getParameter("ck_tk_id");//
            String ck_obj_id=request.getParameter("ck_obj_id");//

            WrchkRecordModel args=new WrchkRecordModel();
            args.setCk_obj_id(ck_obj_id);
            args.setCk_tk_id(ck_tk_id);

            return InvokeResult.success(wrchkRecordService.getWrchkTaskCount(args));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getInfoById")
    @ResponseBody
    public Object getInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String id=request.getParameter("id");
            return InvokeResult.success(wrchkRecordService.getInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/saveOrUpdateInfo")
    @ResponseBody
    public Object saveOrUpdateInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(wrchkRecordService.saveOrUpdateInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/deleteInfoByIds")
    @ResponseBody
    public Object deleteInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(wrchkRecordService.deleteInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/updateStautsByIds")
    @ResponseBody
    public Object updateStautsByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            String status=request.getParameter("status");
            return InvokeResult.success(wrchkRecordService.updateStautsByIds(ids,status));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
}

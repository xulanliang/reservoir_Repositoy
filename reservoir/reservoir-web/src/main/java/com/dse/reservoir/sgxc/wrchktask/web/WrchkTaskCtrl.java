package com.dse.reservoir.sgxc.wrchktask.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sgxc.wrchktask.pojo.WrchkTaskModel;
import com.dse.reservoir.api.sgxc.wrchktask.service.WrchkTaskService;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
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

/****
 * 物资库存管理
 * 20170808
 */
@Controller
@RequestMapping("/wrchkTaskCtrl")
public class WrchkTaskCtrl {

    @Resource(name = "wrchkTaskService")
    private WrchkTaskService wrchkTaskService;

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

            WrchkTaskModel args=new WrchkTaskModel();
            args.setCk_org(ck_org);
            args.setCk_type(ck_type);
            args.setStatus(status);
            args.setCk_tk_desc(ck_tk_desc);
            args.setCk_obj_id(ck_obj_id);
            args.setCk_object(ck_object);

            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wrchkTaskService.getListInfoByParams(args,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getWrchkTaskList")
    @ResponseBody
    public Object getWrchkTaskList(HttpServletRequest request, HttpServletResponse response){
        try {
            String ck_obj_id=request.getParameter("ck_obj_id");//
            String notcktkid=request.getParameter("notcktkid");//
            String ck_tk_id=request.getParameter("ck_tk_id");//

            WrchkTaskModel args=new WrchkTaskModel();
            args.setCk_obj_id(ck_obj_id);
            args.setCk_tk_id(ck_tk_id);

            return InvokeResult.success(wrchkTaskService.getWrchkTaskList(args,notcktkid));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getWrchkTaskCount")
    @ResponseBody
    public Object getWrchkTaskCount(HttpServletRequest request, HttpServletResponse response,WrchkTaskModel bean){
        try {
            String ck_tk_id=request.getParameter("ck_tk_id");//
            String ck_obj_id=request.getParameter("ck_obj_id");//

            WrchkTaskModel args=new WrchkTaskModel();
            args.setCk_obj_id(ck_obj_id);
            args.setCk_tk_id(ck_tk_id);

            return InvokeResult.success(wrchkTaskService.getWrchkTaskCount(args));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getInfoById")
    @ResponseBody
    public Object getInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String id=request.getParameter("id");
            return InvokeResult.success(wrchkTaskService.getInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/saveOrUpdateInfo")
    @ResponseBody
    public Object saveOrUpdateInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(wrchkTaskService.saveOrUpdateInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/deleteInfoByIds")
    @ResponseBody
    public Object deleteInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(wrchkTaskService.deleteInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    /**
     * 查询数据
     */
    @RequestMapping(value = "/execCreateTaskRecord")
    @ResponseBody
    public Object execCreateTaskRecord(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            String taskids=request.getParameter("taskids");
            WrchkTaskModel args=new WrchkTaskModel();
            args.setTaskids(taskids);
            List<WrchkTaskModel> taskList = wrchkTaskService.getJobWrchkTaskList2(args);
            Object  flag=null;
            for(WrchkTaskModel taskmodel:taskList){
                if(StringUtil.isNotEmpty(taskmodel.getNt())){
                    taskmodel.setNt(taskmodel.getNt()+"系统自动");
                }else{
                    taskmodel.setNt("系统自动");
                }
                if(taskmodel.getLast_create_date()==null){
                    taskmodel.setLast_create_date(new java.util.Date());
                }
                String modelNam = taskmodel.getCk_users();
                if(modelNam ==null){
                    taskmodel.setCk_users("");
                }
                flag=wrchkTaskService.execTask(taskmodel);
            }
            return InvokeResult.success(flag);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
}

package com.dse.reservoir.sgxc.wrchkobject.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.sgxc.wrchkobject.pojo.WrchkObjectModel;
import com.dse.reservoir.api.sgxc.wrchkobject.service.WrchkObjectService;
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
@RequestMapping("/wrchkobjectCtrl")
public class WrchkObjectCtrl {

    @Resource(name = "wrchkObjectService")
    private WrchkObjectService wrchkObjectService;

    @RequestMapping(value = "/getListInfoByParams")
    @ResponseBody
    public Object getListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ck_obj_pid=request.getParameter("CK_OBJECT_PID");//
            String ck_name=request.getParameter("ck_name");//
            String ck_org=request.getParameter("CK_ORG");//
            String ck_object=request.getParameter("CK_OBJECT");//
            String ck_type=request.getParameter("CK_TYPE");//
            String ck_item=request.getParameter("CK_ITEM");//

            WrchkObjectModel args=new WrchkObjectModel();
            args.setCk_obj_pid(ck_obj_pid);
            args.setCk_name(ck_name);
            args.setCk_org(ck_org);
            args.setCk_object(ck_object);
            args.setCk_type(ck_type);
            args.setCk_item(ck_item);

            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wrchkObjectService.getListInfoByParams(args,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  根据巡查点id查询巡内容
     * @param
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getXcnrListInfoByParams")
    @ResponseBody
    public Object getXcnrListInfoByParams(String depID,String objID,String CK_OBJ_ID,HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wrchkObjectService.getXcnrListInfoByParams(depID,objID,CK_OBJ_ID,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getWrChkObjectList")
    @ResponseBody
    public Object getWrChkObjectList(HttpServletRequest request, HttpServletResponse response){
        try {
            String ck_obj_pid=request.getParameter("ck_obj_pid");//
            String ck_obj_id=request.getParameter("ck_obj_id");//
            String ck_item=request.getParameter("ck_item");//
            String notckobjid=request.getParameter("notckobjid");//
            String rootnode=request.getParameter("rootnode");//
            String ck_org=request.getParameter("ck_org");//
            String ck_object=request.getParameter("ck_object");//
            String ck_type=request.getParameter("ck_type");//


            WrchkObjectModel args=new WrchkObjectModel();
            args.setCk_obj_pid(ck_obj_pid);
            args.setCk_obj_id(ck_obj_id);
            args.setCk_item(ck_item);
            args.setRootNode(rootnode);

            args.setCk_type(ck_type);
            args.setCk_object(ck_object);
            args.setCk_org(ck_org);

            return InvokeResult.success(wrchkObjectService.getWrChkObjectList(args,notckobjid));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  根据id获得巡查内容
     * @param id
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getXcnrInfoById")
    @ResponseBody
    public Object getXcnrInfoById(String id,HttpServletRequest request, HttpServletResponse response){
        try {
            return InvokeResult.success(wrchkObjectService.getXcnrInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getWrChkObjectCount")
    @ResponseBody
    public Object getWrChkObjectCount(HttpServletRequest request, HttpServletResponse response,WrchkObjectModel bean){
        try {
            String ck_obj_pid=request.getParameter("ck_obj_pid");//
            String ck_obj_id=request.getParameter("ck_obj_id");//
            String ck_item=request.getParameter("ck_item");//

            WrchkObjectModel args=new WrchkObjectModel();
            args.setCk_obj_pid(ck_obj_pid);
            args.setCk_obj_id(ck_obj_id);
            args.setCk_item(ck_item);

            return InvokeResult.success(wrchkObjectService.getWrChkObjectCount(args));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getInfoById")
    @ResponseBody
    public Object getInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String id=request.getParameter("id");
            return InvokeResult.success(wrchkObjectService.getInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/saveOrUpdateInfo")
    @ResponseBody
    public Object saveOrUpdateInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(wrchkObjectService.saveOrUpdateInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  添加、编辑巡查内容
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateXcnrInfo")
    @ResponseBody
    public Object saveOrUpdateXcnrInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            String checkID=request.getParameter("id");
            return InvokeResult.success(wrchkObjectService.saveOrUpdateXcnrInfo(dataStr,checkID));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/deleteInfoByIds")
    @ResponseBody
    public Object deleteInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(wrchkObjectService.deleteInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    @RequestMapping(value = "/deleteXcnrInfoByIds")
    @ResponseBody
    public Object deleteXcnrInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(wrchkObjectService.deleteXcnrInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
}

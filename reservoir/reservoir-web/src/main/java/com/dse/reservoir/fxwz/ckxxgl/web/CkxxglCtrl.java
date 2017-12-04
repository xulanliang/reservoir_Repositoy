package com.dse.reservoir.fxwz.ckxxgl.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.fxwz.ckxxgl.pojo.WrWhB;
import com.dse.reservoir.api.fxwz.ckxxgl.service.CkxxglService;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 仓库信息管理
 */
@Controller
@RequestMapping(value = "ckxxglCtrl")
public class CkxxglCtrl {

    @Resource(name = "ckxxglService")
    private CkxxglService ckxxglService;

    @RequestMapping(value = "/getOrg")
    @ResponseBody
    public Object getOrg(HttpServletRequest request, HttpServletResponse response){
        try {
            return InvokeResult.success(ckxxglService.getOrg());
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  获取巡查点
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getXcdListBycode")
    @ResponseBody
    public Object getXcdListBycode(String depID,String objID,HttpServletRequest request, HttpServletResponse response){
        try {
            return InvokeResult.success(ckxxglService.getXcdListBycode(depID,objID));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    /**
     *  获取采集方式
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getGetType")
    @ResponseBody
    public Object getGetType(HttpServletRequest request, HttpServletResponse response){
        try {
            return InvokeResult.success(ckxxglService.getGetType());
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    @RequestMapping(value = "/getJclx")
    @ResponseBody
    public Object getJclx(HttpServletRequest request, HttpServletResponse response){
        try {
            return InvokeResult.success(ckxxglService.getJclx());
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  获取一级工程名称
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getProject")
    @ResponseBody
    public Object getProject(HttpServletRequest request, HttpServletResponse response){
        try {
            return InvokeResult.success(ckxxglService.getProject());
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    /**
     *  根据工程名称获取模块名称
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getMDNAME")
    @ResponseBody
    public Object getMDNAME(HttpServletRequest request, HttpServletResponse response){
        try {
            String PROJ_CD =request.getParameter("PROJ_CD");
            return InvokeResult.success(ckxxglService.getMDNAME(PROJ_CD));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  获取测点测量状态
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getCdclzt")
    @ResponseBody
    public Object getCdclzt(HttpServletRequest request, HttpServletResponse response){
        try {
            return InvokeResult.success(ckxxglService.getCdclzt());
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  获取测点测量状态
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getListDataByParams")
    @ResponseBody
    public Object getListDataByParams(HttpServletRequest request, HttpServletResponse response){
        try {
            String org_cd =request.getParameter("org_cd");
            String wh_status =request.getParameter("wh_status");
            WrWhB args=new WrWhB();
            args.setOrg_cd(org_cd);
            args.setWh_status(wh_status);
            return InvokeResult.success(ckxxglService.getListDataByParams(args));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/getListInfoByParams")
    @ResponseBody
    public Object getListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String name=request.getParameter("name");
            String ssglbm=request.getParameter("SSGLDW");
            String wh_status=request.getParameter("wh_status");
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            WrWhB args =new WrWhB();
            args.setWh_nm(name);
            args.setOrg_cd(ssglbm);
            args.setWh_status(wh_status);

            return ckxxglService.getListInfoByParams(args,easyUiPage);
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
            return InvokeResult.success(ckxxglService.getInfoById(id));
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
            return InvokeResult.success(ckxxglService.saveOrUpdateInfo(dataStr));
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
            return InvokeResult.success(ckxxglService.deleteInfoByIds(ids));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

}

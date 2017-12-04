package com.dse.reservoir.fxwz.wrmawarningb.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wrmawarningb.pojo.WrMaWarningbModel;
import com.dse.reservoir.api.fxwz.wrmawarningb.service.WrMaWarningbService;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@Controller
@RequestMapping(value = "wrmaWarningbCtrl")
public class WrMaWarningbCtrl {

    @Resource(name = "wrMaWarningbService")
    private WrMaWarningbService wrMaWarningbService;


    @RequestMapping(value = "/getListInfoByParams")
    @ResponseBody
    public Object getListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) {
        try {
            String org_cd = request.getParameter("org_cd");
            String wh_cd = request.getParameter("wh_cd");
            String stm = request.getParameter("stm");
            String etm = request.getParameter("etm");
            String wa_status = request.getParameter("wa_status");
            String wa_tp = request.getParameter("wa_tp");
            String ma_nm = request.getParameter("ma_nm");


            FxWzArgModel args = new FxWzArgModel();
            args.setOrg_cd(org_cd);
            args.setWh_cd(wh_cd);
            args.setStm(stm);
            args.setEtm(etm);
            args.setWa_status(wa_status);
            args.setWa_tp(wa_tp);
            args.setMa_nm(ma_nm);

            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows")) ? request.getParameter("rows") : "10"));
            return wrMaWarningbService.getListInfoByParams(args, easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getInfoById")
    @ResponseBody
    public Object getInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) {
        try {
            String id = request.getParameter("id");
            return InvokeResult.success(wrMaWarningbService.getInfoById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/saveOrUpdateInfo")
    @ResponseBody
    public Object saveOrUpdateInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) {

        try {
            String dataStr = request.getParameter("dataStr");
            return InvokeResult.success(wrMaWarningbService.saveOrUpdateInfo(dataStr));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/deleteInfoByIds")
    @ResponseBody
    public Object deleteInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) {
        try {
            String ids = request.getParameter("ids");
            return InvokeResult.success(wrMaWarningbService.deleteInfoByIds(ids));
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
            return InvokeResult.success(wrMaWarningbService.updateStautsByIds(ids,status));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

}

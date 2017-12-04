package com.dse.reservoir.sjfx.wralarmparamm.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.fxwz.wzflgl.service.WzflglService;
import com.dse.reservoir.api.sjfx.wralarmparamm.pojo.WrAlarmParammModel;
import com.dse.reservoir.api.sjfx.wralarmparamm.service.WrAlarmParammService;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 报警设置
 */
@Controller
@RequestMapping(value = "wralarmparammCtrl")
public class WrAlarmParammCtrl {

    @Resource(name = "wrAlarmParammService")
    private WrAlarmParammService wrAlarmParammService;


    @RequestMapping(value = "/getListInfoByParams")
    @ResponseBody
    public Object getListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) {
        try {
            String projcd = request.getParameter("projcd");
            String mon_tp = request.getParameter("mon_tp");
            WrAlarmParammModel args = new WrAlarmParammModel();
            args.setProj_cd(projcd);
            args.setMon_tp(mon_tp);

            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows")) ? request.getParameter("rows") : "10"));
            return wrAlarmParammService.getListInfoByParams(args, easyUiPage);
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
            return InvokeResult.success(wrAlarmParammService.getInfoById(id));
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
            return InvokeResult.success(wrAlarmParammService.saveOrUpdateInfo(dataStr));
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
            return InvokeResult.success(wrAlarmParammService.deleteInfoByIds(ids));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

}

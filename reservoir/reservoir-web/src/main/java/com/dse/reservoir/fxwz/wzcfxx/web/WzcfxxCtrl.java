package com.dse.reservoir.fxwz.wzcfxx.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.fxwz.wzcfxx.service.WzcfxxService;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 仓库物资管理
 * Created by zhangli on 2016/11/4.
 */
@Controller
@RequestMapping("/wzcfxxCtrl")
public class WzcfxxCtrl {

    @Resource(name = "wzcfxxService")
    private WzcfxxService wzcfxxService;

    @RequestMapping(value = "/getListInfoByParams")
    @ResponseBody
    public Object getListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ckname=request.getParameter("CKNAME");//仓库名称
            String wzname=request.getParameter("WZNAME");//物资名称
            String year=request.getParameter("YEAR");//年份
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wzcfxxService.getListInfoByParams(ckname,wzname,year,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取物资集合
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getWzListInfo")
    @ResponseBody
    public Object getWzListInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.MAX_VALUE);
            return wzcfxxService.getWzListInfo(easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取仓库集合
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getCkListInfo")
    @ResponseBody
    public Object getCkListInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.MAX_VALUE);
            return wzcfxxService.getCkListInfo(easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getInfoById")
    @ResponseBody
    public Object getInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String id=request.getParameter("id");
            return InvokeResult.success(wzcfxxService.getInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/saveOrUpdateInfo")
    @ResponseBody
    public Object saveOrUpdateInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(wzcfxxService.saveOrUpdateInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/deleteInfoByIds")
    @ResponseBody
    public Object deleteInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(wzcfxxService.deleteInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
}

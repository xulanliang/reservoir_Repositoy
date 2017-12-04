package com.dse.reservoir.tableEdit.web;

import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.tableEdit.initBaseInfo.service.InitBaseInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Created by Xll on 2017/7/7.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Controller
@RequestMapping("initBaseInfoCtel")
public class InitBaseInfoCtrl {
    @Resource(name = "initBaseInfoServiceImpl")
    InitBaseInfoService service;
    /**
     * 获取水库信息
     * @return
     */
    @RequestMapping("initReservoirInfo")
    @ResponseBody
    public Object reservoirInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            return InvokeResult.success(service.reservoirInfo());
        }catch (Exception e){
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  获取断面基础信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("initSectionInfo")
    @ResponseBody
    public Object initSectionInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            return InvokeResult.success(service.initSectionInfo());
        }catch (Exception e){
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  获取二级工程等信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("initSectionExtendInfo")
    @ResponseBody
    public Object initSectionExtendInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String levOneID = request.getParameter("levOneID");
        try {
            return InvokeResult.success(service.initSectionExtendInfo(levOneID));
        }catch (Exception e){
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  获取监测项目信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("initCcxmInfo")
    @ResponseBody
    public Object initCcxmInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String levOneID = request.getParameter("levOneID");
        try {
            return InvokeResult.success(service.initCcxmInfo());
        }catch (Exception e){
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

}

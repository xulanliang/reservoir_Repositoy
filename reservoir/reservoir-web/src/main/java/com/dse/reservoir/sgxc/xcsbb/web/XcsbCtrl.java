package com.dse.reservoir.sgxc.xcsbb.web;

import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.sgxc.xcsb.service.XcsbService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dse on 2017/8/22.
 */
@Controller
@RequestMapping("/xcsbCtrl")
public class XcsbCtrl {

    @Resource(name = "xcsbService")
    XcsbService xcsbService;

    @RequestMapping(value = "/saveXcsb")
    @ResponseBody
    public Object saveXcsb(HttpServletRequest request, HttpServletResponse response){

        try {
            String ckID=request.getParameter("ckID");
            String issue=request.getParameter("issue");
            String issueID=request.getParameter("issueID");
            String taskID=request.getParameter("taskID");

            return InvokeResult.success(xcsbService.saveXcsb(taskID,ckID,issue,issueID));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/doSave")
    @ResponseBody
    public Object doSave(HttpServletRequest request, HttpServletResponse response){
        try {
            String taskID=request.getParameter("taskID");
            return InvokeResult.success(xcsbService.doSave(taskID));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
}

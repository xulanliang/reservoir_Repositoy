package com.dse.reservoir.zxjc.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.api.zxjc.service.ZxjcService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/zxjcCtrl")
public class ZxjcCtrl {

    @Resource(name = "zxjcService")
    private ZxjcService zxjcService;

    /**
     * 获取左侧菜单树
     * @return
     */
    @RequestMapping(value = "/getTree")
    @ResponseBody
    public Object getTree(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            return zxjcService.getTree();
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 查询在线监测数据
     */
    @RequestMapping(value = "/getZxjcDate")
    @ResponseBody
    public Object getZxjcDate(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String stm=request.getParameter("stm");
            String etm=request.getParameter("etm");
            String projcd=request.getParameter("projcd");
            String stcdids=request.getParameter("stcds");
            String wrrbm_rbcd=request.getParameter("wrrbm_rbcd");
            String ckID=request.getParameter("ckID");
            GcxEntity gcxArgs =new GcxEntity();
            gcxArgs.setCkID(ckID);
            gcxArgs.setProjcd(projcd);
            gcxArgs.setStcdids(stcdids);
            gcxArgs.setWrrbm_rbcd(wrrbm_rbcd);
            easyUiPage.setPageSize(1000000);
            return zxjcService.getZxjcDate(stm,etm,gcxArgs,easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 测点名称模糊查询
     * @author HUANGC
     * @date  2017年03月13日
     * @return Object:查询到的结果集
     */
    @RequestMapping(value = "/getPointByKey")
    @ResponseBody
    public Object getPointByKey(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            String key = request.getParameter("q");
            String projcd = request.getParameter("projcd");
            String type = request.getParameter("type");
            return zxjcService.getPointByKey(key,projcd,type);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

}

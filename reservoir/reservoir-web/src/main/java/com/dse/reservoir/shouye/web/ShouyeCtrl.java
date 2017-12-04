package com.dse.reservoir.shouye.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.shouye.service.ShouyeService;
import com.dse.reservoir.api.sjfx.wrwarningb.pojo.WrWarningbModel;
import com.dse.reservoir.api.sjfx.wrwarningb.service.WrWarningbService;
import com.dse.reservoir.zlgl.wdzl.util.DseJsonUtil;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页控制层
 */
@Controller
@RequestMapping("/shouyeCtrl")
public class ShouyeCtrl {

    @Resource(name = "shouyeService")
    private ShouyeService shouyeService;

    @Resource
    private WrWarningbService wrWarningbService;

    /**
     * 获取工程信息
     * @return
     */
    @RequestMapping(value = "/getProject")
    @ResponseBody
    public Object getProject(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(10000);
            return shouyeService.getProject(projcd,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取测点信息
     * @return
     */
    @RequestMapping(value = "/getPoint")
    @ResponseBody
    public Object getPoint(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception{
        try {
            String projcd=request.getParameter("projcd");
            easyUiPage.setPageSize(10000);
            return shouyeService.getPoint(projcd,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping("/getAlarmInfo")
    @ResponseBody
    public Object getAlarmInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String,Object> conditionMap = new HashMap<>();
        try {
            return shouyeService.getProjAlarmInfo(conditionMap);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }

    }


    @RequestMapping(value = "/getWarnListByProjCd")
    @ResponseBody
    public Object getWarnListByProjCd(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) {
        try {
            String projcd = request.getParameter("projcd");
            String projcd_real = request.getParameter("projcd_real");

            Map<String,Object> condtionMap = new HashMap<>();
            condtionMap.put("projcd",projcd);
            condtionMap.put("projcd_real",projcd_real);

            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows")) ? request.getParameter("rows") : "10"));
            return wrWarningbService.getWarnListByProjCd(condtionMap, easyUiPage,"0");
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取首页仪器完好率 无故障工作时间 数据缺失率 等数据
     * onmea // 测点测量状态  0：停测 1：测量 2：待修理 3：报废
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getRateData")
    @ResponseBody
    public Object getRateData(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
            Map<String,Object> returnMap = new HashMap<>();
        try {
            String onmea = request.getParameter("onmea");
            Map<String, Object> params = new HashMap<>();
            params.put("onmea", "1");
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows")) ? request.getParameter("rows") : "10"));
//            List<Map<String,Object>> allStat = (List<Map<String,Object>>) wrWarningbService.getRateData(new HashMap<String,Object>());       //所有测点
//            List<Map<String,Object>> useableStat =(List<Map<String,Object>>) wrWarningbService.getRateData(params);                         //有效测点
//
//            returnMap.put("allStat", allStat);
//            returnMap.put("useableStat",useableStat);

            Object rateData = wrWarningbService.getRateData(params);
            returnMap.put("rateData",rateData);

            // 缺失率数据
            params.clear();
            params.put("waTp",0);
            Object lostRateData = wrWarningbService.getLostRate(params);
            returnMap.put("lostRateData",lostRateData);

            //无故障工作时间
            params.clear();
            Object workingHours = wrWarningbService.getWorkingHours(params);
            returnMap.put("workingHours",workingHours);


            return InvokeResult.success(returnMap);
        }catch (Exception e){
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取报警数量
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getAlarmCount")
    @ResponseBody
    public Object getAlarmCountByCd(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> queryMap = new HashMap<>();
        try {
            String proj_cd = request.getParameter("proj_cd");
            queryMap.put("proj_cd",proj_cd);

            return  InvokeResult.success(wrWarningbService.getAlarmCountByCd(queryMap));
        }catch (Exception e){
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

}

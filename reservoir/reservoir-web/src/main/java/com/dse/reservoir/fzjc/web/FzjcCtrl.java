package com.dse.reservoir.fzjc.web;

import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.fzjc.IFzjcService;
import com.dse.reservoir.api.util.CONSTANT;
import com.dse.reservoir.api.util.Utility;
import org.apache.ecs.wml.U;
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

/**
 * 辅助决策控制层
 *
 * @author
 * @date 2017-10-25
 */
@Controller
@RequestMapping("/fzjcCtrl")
public class FzjcCtrl {

    @Resource(name = "fzjcService")
    IFzjcService fzjcService;
    /**
     * 获取左侧菜单树
     * @return
     */
    @RequestMapping(value = "/getTree")
    @ResponseBody
    public Object getTree(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            return fzjcService.getTree();
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 根据断面编号取测点数据
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/getPointsByRb")
    @ResponseBody
    public Object getStcd(HttpServletRequest request, HttpServletResponse response) throws Exception{
        try {
            String rbcd=request.getParameter("rbcd");           // 断面编码
            String projcd=request.getParameter("projcd");       //工程编码
            String st_tp= new String(request.getParameter("type").getBytes("ISO8859-1"), "UTF-8");
            Map<String,Object> queryMap  = new HashMap<>();
            queryMap.put("st_tp",st_tp);
            queryMap.put("proj_cd",projcd);
            queryMap.put("rb_cd",rbcd);
            return InvokeResult.success(fzjcService.getPointsByRb(queryMap));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping("/getStatsData")
    @ResponseBody
    public Object getStatsData(HttpServletRequest request, HttpServletResponse response,String statsType){
        Map dataMap=new HashMap();
        String rbcd = request.getParameter("rbcd");             //断面编码
        String projcd = Utility.isNotEmpty(request.getParameter("projcd")) ? request.getParameter("projcd") : "1";           //工程编号
        String stm = request.getParameter("stm");              //开始时间
        String etm = request.getParameter("etm");              //结束时间
        String stcd = request.getParameter("stcd");              //测点编号
        String st_tp = request.getParameter("st_tp") ;           // 监测类型


        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("stm",stm);
        queryMap.put("etm",etm);
        queryMap.put("st_tp",st_tp);
        queryMap.put("projcd",projcd.substring(0,1));
        queryMap.put("stcd",stcd);

        if(Utility.isEmpty(projcd) || Utility.isEmpty(stcd)  || Utility.isEmpty(stm) || Utility.isEmpty(etm)){
            return dataMap;
        }

        Map map = new HashMap();
        if(CONSTANT.STATS_TYPE_SY.equalsIgnoreCase(statsType)){
            map = (Map) fzjcService.getShenYaStatsData(queryMap);
        }else if(CONSTANT.STATS_TYPE_SL.equalsIgnoreCase(statsType)){
            map = (Map) fzjcService.getShenLiuStatsData(queryMap);
        }

        if(Utility.isNotEmpty(map)){
            dataMap.put("xList",map.get("xList"));//
            dataMap.put("legendList",map.get("legendList"));//
            dataMap.put("legendMap",map.get("legendMap"));//
            dataMap.put("Axis_Data",map.get("Axis_Data"));
        }


        return dataMap;
    }

}

package com.dse.reservoir.web;


import com.dse.reservoir.api.service.WrVsftbService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description:
 * @Copyright: Copyright 2017 ShenZhen DSE Software Corporation
 * @Company: 深圳市东深电子股份有限公司
 * @author pengzx
 * @version 1.0 2017-05-27
 */
@Controller
@RequestMapping("/wrVsftbController")
public class WrVsftbController {

    @Resource(name = "wrVsftbService")
    private WrVsftbService wrVsftbService;


    /**
     * 查询数据
     * @author pengzx
     * @date  2017年05月27日
     * @return
     */
    @RequestMapping(value = "/getVsftbData")
    @ResponseBody
    public Object getVsftbData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String stcd=request.getParameter("stcd");
        String tm=request.getParameter("tm");
        List result = wrVsftbService.getWrVsftbData(stcd, tm);
        String strResult= com.dse.common.util.json.JsonOfJacksonUtil.object2Json(result);
        System.out.println(this.getClass()+">>>>>>>>>>>>>>>>>>> strResult: "+strResult);
        return strResult;
    }


    /**
     * 查询图表数据
     * @author pengzx
     * @date  2017年05月27日
     * @return
     */
    @RequestMapping(value = "/getChartData")
    @ResponseBody
    public Object getChartData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String stcd= request.getParameter("stcd");
        String  stm=request.getParameter("stm");
        String  etm=request.getParameter("etm");
        return wrVsftbService.getChartData(stcd,stm,etm);
    }


}

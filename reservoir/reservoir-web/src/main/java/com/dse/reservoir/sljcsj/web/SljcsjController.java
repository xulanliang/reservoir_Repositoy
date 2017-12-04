package com.dse.reservoir.sljcsj.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.pojo.vo.Sljcsj;
import com.dse.reservoir.api.tableEdit.sljcsj.SljcsjService;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yuan_feng on 2017/9/6.
 */
@Controller
@RequestMapping("/sljcsjController")
public class SljcsjController {
    @Resource(name ="sljcsjServiceImpl")
    private SljcsjService sljcsjService;
    //获得渗流监测数据
    @RequestMapping(value="/searchSljcsjList")
    @ResponseBody
    public Object searchSljcsjList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            Sljcsj slc=new Sljcsj();
            slc.setStcd(request.getParameter("STCD"));
            slc.setTm(request.getParameter("TM"));
            slc.setGattype(request.getParameter("GATTYPE"));
            if(request.getParameter("id")!=null){
                String temp[]=request.getParameter("id").split("tm");
                slc.setStcd(temp[0]);
                slc.setTm(temp[1]);
            }
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return sljcsjService.getSljcsjListService(slc,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    @RequestMapping(value="/deleteSljcsj")
    @ResponseBody
    public Object deleteSljcsj(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            Sljcsj slc=new Sljcsj();
            String param=request.getParameter("ids");
            String temp[]=param.split("tm");
            slc.setStcd(temp[0]);
            slc.setTm(temp[1]);
            return InvokeResult.success(sljcsjService.deleteSljcsjService(slc));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    @RequestMapping(value="/saveSljcsj")
    @ResponseBody
    public Object saveSljcsj(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(sljcsjService.saveSljcsjService(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
//    获得渡槽基本信息
@RequestMapping(value="/searchDcList")
@ResponseBody
public Object searchDcList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
    try {
        String dcCd=request.getParameter("DC_CD");
        String dcNm=request.getParameter("DC_NM");
        easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
        return sljcsjService.getDcListService(dcCd,dcNm,easyUiPage);
    } catch (Exception e) {
        return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
    }
}
    @RequestMapping(value="/deleteDc")
    @ResponseBody
    public Object deleteDc(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String dcCd=request.getParameter("ids");
            return InvokeResult.success(sljcsjService.deleteDcServiceById(dcCd));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    @RequestMapping(value="/saveDc")
    @ResponseBody
    public Object saveDc(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(sljcsjService.savevDcService(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    //渡槽沉降监测信息表
    @RequestMapping(value="/searchDccjList")
    @ResponseBody
    public Object searchDccjList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            Sljcsj slc=new Sljcsj();
            slc.setStcd(request.getParameter("STCD"));
            slc.setTm(request.getParameter("TM"));
            slc.setGattype(request.getParameter("GATTYPE"));
            if(request.getParameter("id")!=null){
                String temp[]=request.getParameter("id").split("tm");
                slc.setStcd(temp[0]);
                slc.setTm(temp[1]);
            }
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return sljcsjService.getDccjListService(slc,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    @RequestMapping(value="/deleteDccj")
    @ResponseBody
    public Object deleteDccj(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            Sljcsj slc=new Sljcsj();
            String param=request.getParameter("ids");
            String temp[]=param.split("tm");
            slc.setStcd(temp[0]);
            slc.setTm(temp[1]);
            return InvokeResult.success(sljcsjService.deleteDccjService(slc));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    @RequestMapping(value="/saveDccj")
    @ResponseBody
    public Object saveDccj(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(sljcsjService.saveDccjService(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    //获得监测断面与测点映射表
    @RequestMapping(value="/searchJcdmCdList")
    @ResponseBody
    public Object searchJcdmCdList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String name=request.getParameter("NAME");
            String id=request.getParameter("id");
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return sljcsjService.getJcdmCdService(id,name,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    @RequestMapping(value="/deleteJcdmCd")
    @ResponseBody
    public Object deleteJcdmCd(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String id=request.getParameter("ids");
            return InvokeResult.success(sljcsjService.deleteJcdmCdService(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    @RequestMapping(value="/saveJcdmCd")
    @ResponseBody
    public Object saveJcdmCd(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(sljcsjService.saveJcdmCdService(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
}



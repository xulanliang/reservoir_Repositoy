package com.dse.reservoir.cdgc.web;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.tableEdit.cdgclx.CdgclxService;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yuan_feng on 2017/8/22.
 */
@Controller
@RequestMapping("/cdgcController")
public class CdgcController {
    @Resource(name = "cdgclxServiceImpl")
    private CdgclxService cdgclxService;
    @RequestMapping(value = "/getCdgcList")
    @ResponseBody
//    获得测点工程类型映射数据
    public Object getCdgcList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ITEM_NM=request.getParameter("ITEM_NM");   //测点类型
            String MON_TP=request.getParameter("MON_TP");
            String id=request.getParameter("id");
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return cdgclxService.getCdgclxList(ITEM_NM,MON_TP,id,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    @RequestMapping(value = "/deleteCdgcByIds")
    @ResponseBody
 //   删除测点工程类型映射数据
    public Object deleteCdgcByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(cdgclxService.deleteCdgcByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    @RequestMapping(value = "/cdgcListSave")
    @ResponseBody
//    修改测点工程类型映射数据
    public Object cdgcListSave(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(cdgclxService.saveOrUpdateCdgcList(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
//    获得涵管基本信息
    @RequestMapping(value = "/getHgList")
    @ResponseBody
   public Object getHgList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
    try {
        String HG_NM=request.getParameter("HG_NM");   //涵管名称
        String HG_DESC=request.getParameter("HG_DESC");
        String ids=request.getParameter("id");
        easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
        return cdgclxService.getHgList(HG_NM,HG_DESC,ids,easyUiPage);
    } catch (Exception e) {
        return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
    }
}

    @RequestMapping(value = "/deleteHgByIds")
@ResponseBody
//    删除涵管基本信息
   public Object deleteHgByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
    try {
        String ids=request.getParameter("ids");
        return InvokeResult.success(cdgclxService.deleteHgByIds(ids));
    } catch (Exception e) {
        return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
    }
}
    @RequestMapping(value = "/saveOrUpdateHgList")
    @ResponseBody
//    保存涵管基本信息
    public Object saveOrUpdateHgList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(cdgclxService.saveOrUpdateHgList(dataStr));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

//    获得渗压监测数据
    @RequestMapping(value = "/getSyjcList")
    @ResponseBody
    public Object getSyjcList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String id=request.getParameter("id");
            String tm=request.getParameter("TM");   //涵管名称
            String getType=request.getParameter("GETTYPE");
            String ids=request.getParameter("STCD");
            if(id!=null){
                String temp[]=id.split("tm");
                ids=temp[0];
                tm=temp[1];
            }
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return cdgclxService.getSyjc(ids,tm,getType,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/deleteSyjcByIds")
    @ResponseBody
//    删除渗压监测数据
    public Object deleteSyjcByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String param=request.getParameter("ids");
            String temp[]=param.split("tm");
            String ids=temp[0];
            String tm=temp[1];
            return InvokeResult.success(cdgclxService.deleteSyjcByIds(ids,tm));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
    @RequestMapping(value = "/saveOrUpdateSyjcList")
    @ResponseBody
//    保存渗压监测数据
    public Object saveOrUpdateSyjcList(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(cdgclxService.saveOrUpdateSyjc(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


}

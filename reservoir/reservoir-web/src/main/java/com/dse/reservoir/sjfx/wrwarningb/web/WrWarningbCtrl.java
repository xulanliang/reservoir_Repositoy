package com.dse.reservoir.sjfx.wrwarningb.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.sjfx.wrwarningb.pojo.WrWarningbModel;
import com.dse.reservoir.api.sjfx.wrwarningb.service.WrWarningbService;
import com.dse.reservoir.api.util.ExcelUtil;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
@RequestMapping(value = "wrwarningbCtrl")
public class WrWarningbCtrl {

    @Resource(name = "wrWarningbService")
    private WrWarningbService wrWarningbService;


    @RequestMapping(value = "/getListInfoByParams")
    @ResponseBody
    public Object getListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) {
        try {
            String projcd = request.getParameter("projcd");
            String mon_tp = request.getParameter("mon_tp");
            String stm = request.getParameter("stm");
            String etm = request.getParameter("etm");
            String wa_status = request.getParameter("wa_status");
            String wa_tp = request.getParameter("wa_tp");

            WrWarningbModel args = new WrWarningbModel();
            args.setProj_cd(projcd);
            args.setMon_tp(mon_tp);
            args.setStm(stm);
            args.setEtm(etm);
            args.setWa_status(wa_status);
            args.setWa_tp(wa_tp);

            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows")) ? request.getParameter("rows") : "10"));
            return wrWarningbService.getListInfoByParams(args, easyUiPage);
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getInfoById")
    @ResponseBody
    public Object getInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage,String wa_id) {
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("WA_ID",wa_id);
            return InvokeResult.success(wrWarningbService.getWarnListByProjCd(map,easyUiPage,"1"));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/saveOrUpdateInfo")
    @ResponseBody
    public Object saveOrUpdateInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage ,String waId,String nt) {
        try {
            Map<String,Object> params = new HashMap<>();
            params.put("wa_id",waId);    //id
            params.put("nt",nt);        //备注

            return  InvokeResult.success(wrWarningbService.saveOrUpdate(params));
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
            return InvokeResult.success(wrWarningbService.deleteInfoByIds(ids));
        } catch (Exception e) {
            e.printStackTrace();
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/export2Excel")
    @ResponseBody
    public void export2Excel(HttpServletRequest request,HttpServletResponse response,String data ){
        OutputStream out = null;
        try{
        //带入页面的查询条件。
        String projcd = request.getParameter("projcd");
        String mon_tp = request.getParameter("mon_tp");
        String stm = request.getParameter("stm");
        String etm = request.getParameter("etm");
        String wa_status = request.getParameter("wa_status");
        String wa_tp = request.getParameter("wa_tp");

        WrWarningbModel args = new WrWarningbModel();
        args.setProj_cd(projcd);
        args.setMon_tp(mon_tp);
        args.setStm(stm);
        args.setEtm(etm);
        args.setWa_status(wa_status);
        args.setWa_tp(wa_tp);

        EasyUiPage easyUiPage = new EasyUiPage();
        easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows")) ? request.getParameter("rows") : "10"));
        EasyUiPage object =  wrWarningbService.getListInfoByParams(args, easyUiPage);

        Map<String, Object> colMap =  new ListOrderedMap<>();
        List list = object.getRows();
        colMap.put("PROJ_CD_NAME","工程名称");
        colMap.put("MON_TP_NAME","监测类型");
        colMap.put("STNM","测点编号");
        colMap.put("WA_DT","发生时间");
        colMap.put("WA_TP_NAME","报警类型");
        colMap.put("WA_VALUE","报警值");
        colMap.put("REAL_VALUE","实际值");
        colMap.put("DA_VALUE","超预警值");
        colMap.put("WA_STATUS_NAME","报警状态");
        colMap.put("NT","处理意见");

        JSONArray dataArray =  JSONArray.parseArray(JSON.toJSONString(list));
        String fileName ="报警查询.xls";

        response.setContentType("application/msexcel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("gb2312"), "iso8859-1"));
        out = response.getOutputStream();
        ExcelUtil.exportExcel(fileName, colMap,dataArray,"" , out, false);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
        }
    }



}

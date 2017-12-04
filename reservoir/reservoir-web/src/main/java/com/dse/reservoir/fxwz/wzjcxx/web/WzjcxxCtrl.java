package com.dse.reservoir.fxwz.wzjcxx.web;


import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.fxwz.wzjcxx.service.WzjcxxService;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:物资基础信息
 * @Copyright: Copyright 2016 ShenZhen DSE Software Corporation
 * @Company: 深圳市东深电子股份有限公司
 * @author 刘旭
 * @version 2.0 2016-11-07
 */

@Controller
@RequestMapping(value = "wzjcxxCtrl")
public class WzjcxxCtrl {

	@Resource(name = "wzjcxxService")
	private WzjcxxService service;

	@RequestMapping(value = "/getListInfoByParams")
	@ResponseBody
    public Object getListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
		try {
			String wzname=request.getParameter("wzname");//物资名称
			String wztype=request.getParameter("wztype");//物资类型
			easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
			return service.getListInfoByParams(wzname,wztype,easyUiPage);
		} catch (Exception e) {
			return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
		}
	}

	@RequestMapping(value = "/getInfoById")
	@ResponseBody
	public Object getInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
		try {
			String id=request.getParameter("id");
			return InvokeResult.success(service.getInfoById(id));
		} catch (Exception e) {
			return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
		}
	}

	@RequestMapping(value = "/saveOrUpdateInfo")
	@ResponseBody
	public Object saveOrUpdateInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

		try {
			String dataStr=request.getParameter("dataStr");
			return InvokeResult.success(service.saveOrUpdateInfo(dataStr));
		} catch (Exception e) {
			return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
		}
	}

	@RequestMapping(value = "/deleteInfoByIds")
	@ResponseBody
	public Object deleteInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
		try {
			String ids=request.getParameter("ids");
			return InvokeResult.success(service.deleteInfoByIds(ids));
		} catch (Exception e) {
			return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
		}
	}


}
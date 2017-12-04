package com.dse.reservoir.fxwz.wzkzgl.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wrmaquanb.pojo.WrMaPK;
import com.dse.reservoir.api.fxwz.wzcfxx.service.WzcfxxService;
import com.dse.reservoir.api.fxwz.wzkzgl.pojo.WzkzglModel;
import com.dse.reservoir.api.fxwz.wzkzgl.service.WzkzglService;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/****
 * 物资库存管理
 * 20170806
 */
@Controller
@RequestMapping("/wzkzglCtrl")
public class WzkzglCtrl {

    @Resource(name = "wzkzglService")
    private WzkzglService wzkzglService;

    @RequestMapping(value = "/getListInfoByParams")
    @ResponseBody
    public Object getListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String org_cd=request.getParameter("org_cd");//
            String wh_cd=request.getParameter("wh_cd");//仓库
            String ma_nm=request.getParameter("ma_nm");//仓库
            String ma_status=request.getParameter("ma_status");//物资名称
            String wztype=request.getParameter("wztype");//物资名称

            FxWzArgModel args=new FxWzArgModel();
            args.setOrg_cd(org_cd);
            args.setWh_cd(wh_cd);
            args.setMa_nm(ma_nm);
            args.setMa_status(ma_status);
            args.setType(wztype);

            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wzkzglService.getListInfoByParams(args,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getCrkListInfoByParams")
    @ResponseBody
    public Object getCrkListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String sTime=request.getParameter("sTime");//
            String eTime=request.getParameter("eTime");//
            String dep_id=request.getParameter("dep_name");//管理部门id
            String ck_id=request.getParameter("ck");//仓库id
            //记录状态
            String statu=request.getParameter("statu");
            //0:出库  1:入库
            String type=request.getParameter("type");

            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wzkzglService.getCrkListInfoByParams(type,sTime,eTime,dep_id,ck_id,statu,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/getWzkzylListInfoByParams")
    @ResponseBody
    public Object getWzkzylListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String wh_cd=request.getParameter("wh_cd");//仓库
            String ma_cd=request.getParameter("ma_cd");//物资
            String ma_pc=request.getParameter("ma_pc");//
            String binnum=request.getParameter("binnum");//年份

            String wr_ma_inventory_id=request.getParameter("search_wr_ma_inventory_id");//
            String search_wh_cd=request.getParameter("search_wh_cd");//
            String search_ma_cd=request.getParameter("search_ma_cd");//
            String search_page=request.getParameter("search_page");//wzkzglList

            FxWzArgModel args=new FxWzArgModel();
            args.setMa_cd(ma_cd);
            args.setWh_cd(wh_cd);
            args.setMa_pc(ma_pc);
            args.setBinnum(binnum);
            args.setWr_ma_inventory_id(wr_ma_inventory_id);
            args.setSearch_page(search_page);
            if(!StringUtil.isNotEmpty(search_page)||"wzkzglList".equalsIgnoreCase(search_page)){
                args.setMa_cd(search_ma_cd);
                args.setWh_cd(search_wh_cd);
            }

            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return wzkzglService.getWzkzylListInfoByParams(args,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取物资集合
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getWzListInfo")
    @ResponseBody
    public Object getWzListInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.MAX_VALUE);
            return wzkzglService.getWzListInfo(easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取仓库集合
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getCkListInfo")
    @ResponseBody
    public Object getCkListInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.MAX_VALUE);
            return wzkzglService.getCkListInfo(easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getInfoById")
    @ResponseBody
    public Object getInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String id=request.getParameter("id");
            return InvokeResult.success(wzkzglService.getInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getCrkInfoById")
    @ResponseBody
    public Object getCrkInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String id=request.getParameter("id");
            return InvokeResult.success(wzkzglService.getCrkInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/saveOrUpdateInfo")
    @ResponseBody
    public Object saveOrUpdateInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(wzkzglService.saveOrUpdateInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  删除出入库信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/delCrkInfoByByIds")
    @ResponseBody
    public Object delCrkInfoByByIds(HttpServletRequest request, HttpServletResponse response){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(wzkzglService.delCrkInfoByByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getWrmaquanbInfoById")
    @ResponseBody
    public Object getWrmaquanbInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ma_cd=request.getParameter("ma_cd");
            String wh_cd=request.getParameter("wh_cd");
            String ma_pc=request.getParameter("ma_pc");
            String binnum=request.getParameter("binnum");
            FxWzArgModel args=new FxWzArgModel();
            args.setMa_cd(ma_cd);
            args.setWh_cd(wh_cd);
            args.setMa_pc(ma_pc);
            args.setBinnum(binnum);
            Object result = wzkzglService.getWrmaquanbInfoById(args);
            //System.out.println(this.getClass().getName()+" : " +com.dse.common.util.json.JsonUtil.object2Json(result));
            return InvokeResult.success(result);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/saveOrUpdateWrmaquanbInfo")
    @ResponseBody
    public Object saveOrUpdateWrmaquanbInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            Object result = wzkzglService.saveOrUpdateWrmaquanbInfo(dataStr);
            if(result!=null){
                WrMaPK wrmapk = JsonUtil.json2Object(dataStr,WrMaPK.class);
                wzkzglService.updateWrMaInventoryRealquan(wrmapk.getMa_cd(),wrmapk.getWh_cd());
            }
            return InvokeResult.success(result);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  保存出入库记录
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveCrkInfo")
    @ResponseBody
    public Object saveCrkInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(wzkzglService.saveCrkInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }



    @RequestMapping(value = "/addwz2ck")
    @ResponseBody
    public Object addwz2ck(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(wzkzglService.addwz2ck(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/deleteInfoByIds")
    @ResponseBody
    public Object deleteInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(wzkzglService.deleteInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }
}

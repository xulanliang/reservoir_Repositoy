package com.dse.reservoir.tableEdit.web;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.reservoir.api.tableEdit.rainLever.RainLeverService;
import com.dse.reservoir.tableEdit.rainLever.serviceImpl.RainLeverServiceImpl;
import com.dse.reservoir.zlgl.wdzl.util.DseStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xll on 2017/7/5.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Controller
@RequestMapping("/tableEditCtrl")
public class TableEditCtrl {

    @Resource(name = "rainLeverService")
    private RainLeverService rainLeverService;
    /**
     *  降水量表 ST_PPTN_R
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getRainListInfoByParams")
    @ResponseBody
    public Object getRainListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String stnm=request.getParameter("stnm");   //测点名称
            String sTM=request.getParameter("sTM");   //开始时间
            String eTM=request.getParameter("eTM");   //结束时间
            String PROJ_NM=request.getParameter("PROJ_NM");   //水库名称
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return rainLeverService.getRainListInfoByParams(stnm,sTM,eTM,PROJ_NM,easyUiPage);
//            return null;
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  监测项目基本信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getProjectBaseListInfoByParams")
    @ResponseBody
    public Object getProjectBaseListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ITEM_NM=request.getParameter("ITEM_NM");   //项目名称
            String MON_TP=request.getParameter("MON_TP");   //监测类型
            String IS_AUTO=request.getParameter("IS_AUTO");   //是否为自动化监测
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return rainLeverService.getProjectBaseListInfoByParams(ITEM_NM,MON_TP,IS_AUTO,easyUiPage);
//            return null;
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getSectionBaseListInfoByParams")
    @ResponseBody
    public Object getSectionBaseListInfoByParams(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String RB_NM=request.getParameter("RB_NM");   //断面名称
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return rainLeverService.getSectionBaseListInfoByParams(RB_NM,easyUiPage);
//            return null;
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取渗压统计模型回归系数列表
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping("/getShenyaStatsParamList")
    @ResponseBody
    public Object getShenyaStatsParamList(HttpServletRequest request,HttpServletResponse response,EasyUiPage easyUiPage){
        try {
            String STNM =request.getParameter("STNM");   //断面名称
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));

            Map<String,Object> conditionMap = new HashMap<>();
            conditionMap.put("STNM",STNM);
            return rainLeverService.getShenyaStatsParamList(conditionMap,easyUiPage);

        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    /**
     * 根据ID查询回归系数信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getShenyaStatsInfoById")
    @ResponseBody
    public Object getShenyaStatsInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            //监测项目编号
            String id=request.getParameter("id");
            Map<String,Object> conditionMap = new HashMap<>();
            conditionMap.put("ID",id);
            Object o = rainLeverService.getShenyaStatsInfoById(conditionMap) ;
            return InvokeResult.success(rainLeverService.getShenyaStatsInfoById(conditionMap));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  保存回归系数因子
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateShenyaStatsParamInfo")
    @ResponseBody
    public Object saveOrUpdateShenyaStatsParamInfo(HttpServletRequest request, HttpServletResponse response){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(rainLeverService.saveOrUpdateShenyaStatsParamInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    /**
     *  垂直位移监测信息表
     * @param RB_NM     测点名称
     * @param STM   采集开始时间  如2017-08-22
     * @param ETM   采集结束时间  如2017-08-22
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getCzwyjcxxListInfoByParams")
    @ResponseBody
    public Object getCzwyjcxxListInfoByParams(String RB_NM,String STM,String ETM,HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return rainLeverService.getCzwyjcxxListInfoByParams(RB_NM,STM,ETM,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  多测点信息查询
     * @param RB_NM
     * @param STM
     * @param ETM
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getDdwyjcxxListInfoByParams")
    @ResponseBody
    public Object getDdwyjcxxListInfoByParams(String RB_NM,String STM,String ETM,HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return rainLeverService.getDdwyjcxxListInfoByParams(RB_NM,STM,ETM,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  工程基本信息
     * @param RB_NM
     * @param STM
     * @param ETM
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getGcjbxxListInfoByParams")
    @ResponseBody
    public Object getGcjbxxListInfoByParams(String RB_NM,String CK_ORG,String STM,String ETM,HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return rainLeverService.getGcjbxxListInfoByParams(RB_NM,CK_ORG,STM,ETM,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  模块基本信息
     * @param RB_NM
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getMkjbxxbListInfoByParams")
    @ResponseBody
    public Object getMkjbxxbListInfoByParams(String RB_NM,HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return rainLeverService.getMkjbxxbListInfoByParams(RB_NM,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  气温气压表
     * @param STM 开始时间
     * @param ETM 结束时间
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getQwqyListInfoByParams")
    @ResponseBody
    public Object getQwqyListInfoByParams(String STM,String ETM,HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return rainLeverService.getQwqyListInfoByParams(STM,ETM,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  水位表
     * @param STM
     * @param ETM
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getSwbListInfoByParams")
    @ResponseBody
    public Object getSwbListInfoByParams(String STM,String ETM,HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return rainLeverService.getSwbListInfoByParams(STM,ETM,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  水库水情表
     * @param STM
     * @param ETM
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getSksqbListInfoByParams")
    @ResponseBody
    public Object getSksqbListInfoByParams(String STM,String ETM,HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return rainLeverService.getSksqbListInfoByParams(STM,ETM,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  水平位移监测信息
     * @param STM
     * @param ETM
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getSpwycjxxListInfoByParams")
    @ResponseBody
    public Object getSpwycjxxListInfoByParams(String STNM,String STM,String ETM,HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return rainLeverService.getSpwycjxxListInfoByParams(STNM,STM,ETM,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/getCdjcxxbListInfoByParams")
    @ResponseBody
    public Object getCdjcxxbListInfoByParams(String STNM,HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            easyUiPage.setPageSize(Integer.valueOf(DseStringUtil.isNotEmpty(request.getParameter("rows"))?request.getParameter("rows"):"10"));
            return rainLeverService.getCdjcxxbListInfoByParams(STNM,easyUiPage);
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getInfoById")
    @ResponseBody
    public Object getInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String id=request.getParameter("id");   //测站点id
            String tm=request.getParameter("tm");   //采集时间
            return InvokeResult.success(rainLeverService.getInfoById(id,tm));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    /**
     * 根据监测项目编号查询断面基础信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getSectionBaselnfoById")
    @ResponseBody
    public Object getSectionBaselnfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            //监测项目编号
            String id=request.getParameter("id");
            return InvokeResult.success(rainLeverService.getSectionBaselnfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  测点基础信息表
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getCdjcxxbInfoById")
    @ResponseBody
    public Object getCdjcxxbInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            //监测项目编号
            String id=request.getParameter("id");
            return InvokeResult.success(rainLeverService.getCdjcxxbInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  水平位移监测信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getSpwycjxxInfoById")
    @ResponseBody
    public Object getSpwycjxxInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            //监测项目编号
            String id=request.getParameter("id");
            return InvokeResult.success(rainLeverService.getSpwycjxxInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  根据时间，测点编号查询气温气压信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getQwqyInfoById")
    @ResponseBody
    public Object getQwqyInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            //监测项目编号
            String id=request.getParameter("id");
            return InvokeResult.success(rainLeverService.getQwqyInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  根据测点编号，时间联合查询水库水情信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getSksqbInfoById")
    @ResponseBody
    public Object getSksqbInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            //监测项目编号
            String id=request.getParameter("id");
            return InvokeResult.success(rainLeverService.getSksqbInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  水位表信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getSwbInfoById")
    @ResponseBody
    public Object getSwbInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            //监测项目编号
            String id=request.getParameter("id");
            return InvokeResult.success(rainLeverService.getSwbInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  根据 联合主键 测点编号：stcd  采集时间：TM  查询垂直位移监测信息  QS：期数
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getCzwyjcxxlnfoById")
    @ResponseBody
    public Object getCzwyjcxxlnfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            //监测项目编号
            String id=request.getParameter("id");
            String [] params = id.split(",");
            String stcd = params[0];    //S0000040
            String TM = params[1];      //2017-10-10 15:00:00
            String QS = params[2];      //期数
            return InvokeResult.success(rainLeverService.getCzwyjcxxlnfoById(stcd,TM,QS));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  根据 联合主键 测点编号：stcd  采集时间：TM  查询垂直位移监测信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getDdwyjcxxlnfoById")
    @ResponseBody
    public Object getDdwyjcxxlnfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            //监测项目编号
            String id=request.getParameter("id");
            String [] params = id.split(",");
            String stcd = params[0];    //S0000040
            String TM = params[1];      //2017-10-10 15:00:00
            return InvokeResult.success(rainLeverService.getDdwyjcxxlnfoById(stcd,TM));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  根据 工程编号查询
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getGcjbxxlnfoById")
    @ResponseBody
    public Object getGcjbxxlnfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            //监测项目编号
            String id=request.getParameter("id");
            return InvokeResult.success(rainLeverService.getGcjbxxlnfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  根据编号 查询模块基本信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/getMkjbxxblnfoById")
    @ResponseBody
    public Object getMkjbxxblnfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            //监测项目编号
            String id=request.getParameter("id");
            return InvokeResult.success(rainLeverService.getMkjbxxblnfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/getProjectBaseInfoById")
    @ResponseBody
    public Object getProjectBaseInfoById(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String id=request.getParameter("id");   //项目编号
            return InvokeResult.success(rainLeverService.getProjectBaseInfoById(id));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/saveOrUpdateInfo")
    @ResponseBody
    public Object saveOrUpdateInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(rainLeverService.saveOrUpdateInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  垂直位移监测信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateCzwyjcxxInfo")
    @ResponseBody
    public Object saveOrUpdateCzwyjcxxInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(rainLeverService.saveOrUpdateCzwyjcxxInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  编辑水平位移监测信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateSpwycjxxInfo")
    @ResponseBody
    public Object saveOrUpdateSpwycjxxInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(rainLeverService.saveOrUpdateSpwycjxxInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  编辑水库水情信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateSksqbInfo")
    @ResponseBody
    public Object saveOrUpdateSksqbInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(rainLeverService.saveOrUpdateSksqbInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  编辑模块基本信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateMkjbxxInfo")
    @ResponseBody
    public Object saveOrUpdateMkjbxxInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(rainLeverService.saveOrUpdateMkjbxxInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  编辑测点基础信息表
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateCdjcxxbInfo")
    @ResponseBody
    public Object saveOrUpdateCdjcxxbInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(rainLeverService.saveOrUpdateCdjcxxbInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  编辑多点位移监测信息表
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateDdwyjcxxInfo")
    @ResponseBody
    public Object saveOrUpdateDdwyjcxxInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(rainLeverService.saveOrUpdateDdwyjcxxInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  编辑工程基本信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateGcjbxxInfo")
    @ResponseBody
    public Object saveOrUpdateGcjbxxInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(rainLeverService.saveOrUpdateGcjbxxInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  编辑气温气压信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateQwqyInfo")
    @ResponseBody
    public Object saveOrUpdateQwqyInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(rainLeverService.saveOrUpdateQwqyInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  编辑水位表
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateSwbInfo")
    @ResponseBody
    public Object saveOrUpdateSwbInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(rainLeverService.saveOrUpdateSwbInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/saveOrUpdateProjectBaseInfo")
    @ResponseBody
    public Object saveOrUpdateProjectBaseInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(rainLeverService.saveOrUpdateProjectBaseInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  编辑断面基础信息保存
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateSectionBaseInfo")
    @ResponseBody
    public Object saveOrUpdateSectionBaseInfo(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){

        try {
            String dataStr=request.getParameter("dataStr");
            return InvokeResult.success(rainLeverService.saveOrUpdateSectionBaseInfo(dataStr));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/deleteInfoByIds")
    @ResponseBody
    public Object deleteInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(rainLeverService.deleteInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    @RequestMapping(value = "/deleteProjectBaseInfoByIds")
    @ResponseBody
    public Object deleteProjectBaseInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(rainLeverService.deleteProjectBaseInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  删除测点基础信息表
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/deleteCdjcxxbInfoByIds")
    @ResponseBody
    public Object deleteCdjcxxbInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(rainLeverService.deleteCdjcxxbInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  删除水平位移监测信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/deleteSpwycjxxInfoByIds")
    @ResponseBody
    public Object deleteSpwycjxxInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(rainLeverService.deleteSpwycjxxInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  根据联合主键删除水库水情信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/deleteSksqbInfoByIds")
    @ResponseBody
    public Object deleteSksqbInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(rainLeverService.deleteSksqbInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  删除垂直位移监测信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/deleteCzwyjcxxByIds")
    @ResponseBody
    public Object deleteCzwyjcxxByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(rainLeverService.deleteCzwyjcxxByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  删除气温气压信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/deleteQwqyInfoByIds")
    @ResponseBody
    public Object deleteQwqyInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(rainLeverService.deleteQwqyInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  删除水位信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/deleteSwbInfoByIds")
    @ResponseBody
    public Object deleteSwbInfoByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(rainLeverService.deleteSwbInfoByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  删除多点位移监测信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/deleteDdwyjcxxByIds")
    @ResponseBody
    public Object deleteDdwyjcxxByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(rainLeverService.deleteDdwyjcxxByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  删除工程基本信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/deleteGcjbxxByIds")
    @ResponseBody
    public Object deleteGcjbxxByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(rainLeverService.deleteGcjbxxByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  删除模块基本信息
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     */
    @RequestMapping(value = "/deleteMkjbxxByIds")
    @ResponseBody
    public Object deleteMkjbxxByIds(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage){
        try {
            String ids=request.getParameter("ids");
            return InvokeResult.success(rainLeverService.deleteMkjbxxByIds(ids));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

}

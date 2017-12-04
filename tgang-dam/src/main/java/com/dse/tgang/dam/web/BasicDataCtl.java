package com.dse.tgang.dam.web;

import com.dse.tgang.dam.service.BasicDataService;
import com.dse.tgang.dam.util.DseStringUtil;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoq on 2016-12-24.
 */
@Controller
@RequestMapping("BasicDataCtl")
public class BasicDataCtl {

    @Resource
    private BasicDataService basicDataService;

    /**
     * 基础数据树
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryData", method = RequestMethod.POST)
    @ResponseBody
    public Object queryData(HttpServletRequest request) throws Exception {
        return basicDataService.buildTree(request);
    }

    /**
     * 分页查询(水库)
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "getReservoirList")
    @ResponseBody
    protected Object getReservoirList(@RequestBody Map<String, String> dataMap) {
        return basicDataService.getReservoirList(dataMap);
    }

    /**
     * 查询(坝)
     *
     * @param dataMap
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getDykeList", method = RequestMethod.POST)
    @ResponseBody
    protected Object getDykeList(@RequestBody Map<String, String> dataMap) throws Exception {
        return basicDataService.getDykeList(dataMap);
    }

    /**
     * 查询(断面)
     *
     * @param dataMap
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getSectionList", method = RequestMethod.POST)
    @ResponseBody
    protected Object getSectionList(@RequestBody Map<String, String> dataMap) throws Exception {
        return basicDataService.getSectionList(dataMap);
    }

    /**
     * 查询(监测点)
     *
     * @param dataMap
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getMonitorList", method = RequestMethod.POST)
    @ResponseBody
    protected Object getMonitorList(@RequestBody Map<String, String> dataMap) throws Exception {
        return basicDataService.getMonitorList(dataMap);
    }

    /**
     * 查询(渗压监测点)
     *
     * @param dataMap
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getPreMonitorList", method = RequestMethod.POST)
    @ResponseBody
    protected Object getPreMonitorList(@RequestBody Map<String, String> dataMap) throws Exception {
        return basicDataService.getPreMonitorList(dataMap);
    }

    /**
     * 保存水库信息
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "saveReservoirInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object saveReservoirInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            basicDataService.saveReservoir(dataMap);
            map.put("msg", "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "保存失败！\n水库名称代码【" + dataMap.get("ennmcd") + "】已经存在！");
        }
        return map;
    }

    /**
     * 更新水库信息
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "updateReservoirInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateReservoirInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            basicDataService.updateReservoir(dataMap);
            map.put("msg", "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "保存失败！\n" + e.getMessage());
        }
        return map;
    }

    /**
     * 删除水库信息
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "deleteReservoirInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteReservoirInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            basicDataService.deleteReservoir(dataMap);
            map.put("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "删除失败！\n" + e.getMessage());
        }
        return map;
    }

    /**
     * 保存坝信息
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "saveDykeInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object saveDykeInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            basicDataService.saveDyke(dataMap);
            map.put("msg", "保存成功！");
        } catch (ConstraintViolationException e) {
            map.put("flag", "1");
            map.put("msg", "保存失败！\n堤防(段)名称代码【" + dataMap.get("ennmcd") + "】已经存在！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "保存失败！\n" + e.getMessage());
        }
        return map;
    }

    /**
     * 更新坝信息
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "updateDykeInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateDykeInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            basicDataService.updateDyke(dataMap);
            map.put("msg", "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "保存失败！\n" + e.getMessage());
        }
        return map;
    }

    /**
     * 删除坝信息
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "deleteDykeInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteDykeInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            basicDataService.deleteDyke(dataMap);
            map.put("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "删除失败！\n" + e.getMessage());
        }
        return map;
    }

    /**
     * 保存断面信息
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "saveSectionInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object saveSectionInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            basicDataService.saveSection(dataMap);
            map.put("msg", "保存成功！");
        } catch (ConstraintViolationException e) {
            map.put("flag", "1");
            map.put("msg", "保存失败！\n堤防(段)横断面代码【" + dataMap.get("bntrcd") + "】已经存在！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "保存失败！\n" + e.getMessage());
        }
        return map;
    }

    /**
     * 更新断面信息
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "updateSectionInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateSectionInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            basicDataService.updateSection(dataMap);
            map.put("msg", "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "保存失败！\n" + e.getMessage());
        }
        return map;
    }

    /**
     * 删除断面信息
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "deleteSectionInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteSectionInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            basicDataService.deleteSection(dataMap);
            map.put("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "删除失败！\n" + e.getMessage());
        }
        return map;
    }

    /**
     * 保存监测点信息
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "saveMonitorInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object saveMonitorInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            basicDataService.saveMonitor(dataMap);
            map.put("msg", "保存成功！");
        } catch (ConstraintViolationException e) {
            map.put("flag", "1");
            map.put("msg", "保存失败！\n监测点代码【" + dataMap.get("pointcd") + "】已经存在！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "保存失败！\n监测点代码【" + dataMap.get("pointcd") + "】已经存在！");
        }
        return map;
    }

    /**
     * 更新监测点信息
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "updateMonitorInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateMonitorInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            basicDataService.updateMonitor(dataMap);
            map.put("msg", "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "保存失败！\n监测点代码【\" + dataMap.get(\"pointcd\") + \"】已经存在！");
        }
        return map;
    }

    /**
     * 删除监测点信息
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "deleteMonitorInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteMonitorInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            basicDataService.deleteMonitor(dataMap);
            map.put("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "删除失败！\n" + e.getMessage());
        }
        return map;
    }

    /**
     * 返回水库所有断面数据
     *
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/querySection", method = RequestMethod.POST)
    @ResponseBody
    protected Object querySection(@RequestBody Map<String, String> dataMap) throws Exception {
        String ennmcd = dataMap.get("ennmcd");
        List<Map<String, Object>> list = basicDataService.listDM(ennmcd);
        return list;
    }

    /**
     * 返回水库所有大坝数据
     *
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/queryDyKe", method = RequestMethod.POST)
    @ResponseBody
    protected Object queryDyKe(@RequestBody Map<String, String> dataMap) throws Exception {
        String ennmcd = dataMap.get("ennmcd");
        List<Map<String, Object>> list = basicDataService.queryDyKe(ennmcd);
        return list;
    }

    /**
     * 返回大坝所有断面数据
     *
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/querySectionByEnnmcd", method = RequestMethod.POST)
    @ResponseBody
    protected Object querySectionByEnnmcd(@RequestBody Map<String, String> dataMap) throws Exception {
        String ennmcd = dataMap.get("ennmcd");
        List<Map<String, Object>> list = basicDataService.querySectionByEnnmcd(ennmcd);
        return list;
    }

    /**
     * 返回大坝的基本信息及实时渗压信息
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/getDbInfo", method = RequestMethod.POST)
    @ResponseBody
    protected Object getDbInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ennmcd = request.getParameter("ennmcd");
        String bntrcd = request.getParameter("bntrcd");
        String date = request.getParameter("date");
        if (DseStringUtil.empty(ennmcd) || DseStringUtil.empty(bntrcd)) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>(2);
        try {
            // 防渗墙、防浪墙
            map.put("FSQ", basicDataService.listFSQ(bntrcd));
            // 坝体
            map.put("BT", basicDataService.listBT(bntrcd));
            // 渗压管及渗压水位
            map.put("SY", basicDataService.querySY(bntrcd, date));
            //修改水位取值 chens 2014-06-26
            map.put("SW", basicDataService.querySW(ennmcd,date));
            // 汛限水位
            //修改汛限水位取值 chens 2014-06-26
            map.put("XXSW", basicDataService.queryXXSW(ennmcd));
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "查询失败！\n" + e.getMessage());
        }
        return map;
    }

    /**
     *  渗压 断面 数据绑定 添加  修改公用方法
     * @param @param request
     * @param @param dataMap
     */
    @RequestMapping(value="updateConfig",method = RequestMethod.POST)
    @ResponseBody
    protected Object updateConfig(HttpServletRequest request,@RequestBody Map<String,String>dataMap)throws Exception{
        Map <String,String> resultMap = new HashMap<String, String>(1);
        try{
            basicDataService.updateConfig(dataMap);
            resultMap.put("msg", "保存成功！");
        }
        catch(Exception e){
            resultMap.put("flag", "1");
            resultMap.put("msg", "保存失败！\n"+e.getMessage());
        }
        return resultMap;
    }

    /**
     *  删除坝体关键点
     * @param @param request
     * @param @param dataMap
     */
    @RequestMapping(value="deletePoint",method = RequestMethod.POST)
    @ResponseBody
    protected Object deletePoint(HttpServletRequest request,@RequestBody Map<String,String>dataMap)throws Exception{
        Map <String,String> resultMap = new HashMap<String, String>(1);
        try{
            basicDataService.deletePoint(dataMap);
            resultMap.put("msg", "删除成功！");
        }
        catch(Exception e){
            resultMap.put("flag", "1");
            resultMap.put("msg", "删除失败！\n"+e.getMessage());
        }
        return resultMap;
    }

    /**
     *  删除防渗墙
     * @param @param request
     * @param @param dataMap
     */
    @RequestMapping(value="deleteFsq",method = RequestMethod.POST)
    @ResponseBody
    protected Object deleteFsq(HttpServletRequest request,@RequestBody Map<String,String>dataMap)throws Exception{
        Map <String,String> resultMap = new HashMap<String, String>(1);
        try{
            basicDataService.deleteFsq(dataMap);
            resultMap.put("msg", "删除成功！");
        }
        catch(Exception e){
            resultMap.put("flag", "1");
            resultMap.put("msg", "删除失败！\n"+e.getMessage());
        }
        return resultMap;
    }

    /**
     * 返回水库分布图信息
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/getDisInfo", method = RequestMethod.POST)
    @ResponseBody
    protected Object getDisInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String bntrcd = request.getParameter("bntrcd");
        String date = request.getParameter("date");
        if (DseStringUtil.empty(bntrcd)) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>(2);
        try {
            return basicDataService.getDisInfo(bntrcd, date);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "查询失败！\n" + e.getMessage());
        }
        return map;
    }

    /**
     * 返回水库水位过程线
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/getLevelInfo", method = RequestMethod.POST)
    @ResponseBody
    protected Object getLevelInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String ennmcd = request.getParameter("ennmcd");
        String bntrcd = request.getParameter("bntrcd");
        String sdate = request.getParameter("sdate");
        String edate = request.getParameter("edate");
        if (DseStringUtil.empty(bntrcd) || DseStringUtil.empty(sdate) || DseStringUtil.empty(edate) || DseStringUtil.empty(ennmcd)) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>(2);
        try {
            return basicDataService.getLevelInfo(bntrcd, sdate, edate, ennmcd);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "查询失败！\n" + e.getMessage());
        }
        return map;
    }

    /**
     *  删除数据管理
     * @param @param request
     * @param @param dataMap
     */
    @RequestMapping(value="deleteData",method = RequestMethod.POST)
    @ResponseBody
    protected Object deleteData(HttpServletRequest request,@RequestBody Map<String,String>dataMap)throws Exception{
        Map <String,String> resultMap = new HashMap<String, String>(1);
        try{
            basicDataService.deleteData(dataMap);
            resultMap.put("msg", "删除成功！");
        }
        catch(Exception e){
            resultMap.put("flag", "1");
            resultMap.put("msg", "删除失败！\n"+e.getMessage());
        }
        return resultMap;
    }

    /**
     *  保存数据管理
     * @param @param request
     * @param @param dataMap
     */
    @RequestMapping(value="updateData",method = RequestMethod.POST)
    @ResponseBody
    protected Object updateData(HttpServletRequest request,@RequestBody Map<String,Object>dataMap)throws Exception{
        Map <String,String> resultMap = new HashMap<String, String>(1);
        try{
            basicDataService.updateData(dataMap);
            resultMap.put("msg", "保存成功！");
        }
        catch(Exception e){
            resultMap.put("flag", "1");
            resultMap.put("msg", "保存失败！");
        }
        return resultMap;
    }

    /**
     * 返回铁岗石岩今日水情
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/getWaterInfo", method = RequestMethod.POST)
    @ResponseBody
    protected Object getWaterInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>(2);
        try {
            return basicDataService.getWaterInfo();
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "查询失败！\n" + e.getMessage());
        }
        return map;
    }

    /**
     *  获取库容信息
     * @param @param request
     * @param @param dataMap
     */
    @RequestMapping(value="getKrInfo",method = RequestMethod.POST)
    @ResponseBody
    protected Object getKrInfo(HttpServletRequest request, HttpServletResponse response, Map<String, Object> dataMap) throws Exception {
        String stcd = request.getParameter("stcd");
        String rz = request.getParameter("rz");
        if (DseStringUtil.empty(stcd) || DseStringUtil.empty(rz)) {
            return null;
        }
        dataMap.put("stcd", stcd);
        dataMap.put("rz", rz);
        return basicDataService.getKrInfo(dataMap);
    }

    /**
     * 查询(渗流)
     *
     * @param dataMap
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getSeepageList", method = RequestMethod.POST)
    @ResponseBody
    protected Object getSeepageList(@RequestBody Map<String, String> dataMap) throws Exception {
        return basicDataService.getSeepageList(dataMap);
    }

    /**
     *  删除渗流数据
     * @param @param request
     * @param @param dataMap
     */
    @RequestMapping(value="deleteSeepage",method = RequestMethod.POST)
    @ResponseBody
    protected Object deleteSeepage(HttpServletRequest request,@RequestBody Map<String,String>dataMap)throws Exception{
        Map <String,String> resultMap = new HashMap<String, String>(1);
        try{
            basicDataService.deleteSeepage(dataMap);
            resultMap.put("msg", "删除成功！");
        }
        catch(Exception e){
            resultMap.put("flag", "1");
            resultMap.put("msg", "删除失败！\n"+e.getMessage());
        }
        return resultMap;
    }

    @RequestMapping(value = "getStcdByEnnmcd", method = RequestMethod.POST)
    @ResponseBody
    protected Object getStcdByEnnmcd(@RequestBody Map<String, String> dataMap) throws Exception {
        return basicDataService.getStcdByEnnmcd(dataMap);
    }

    /**
     *  保存渗流数据管理
     * @param @param request
     * @param @param dataMap
     */
    @RequestMapping(value="saveSeepage",method = RequestMethod.POST)
    @ResponseBody
    protected Object saveSeepage(HttpServletRequest request,@RequestBody Map<String,Object>dataMap)throws Exception{
        Map <String,String> resultMap = new HashMap<String, String>(1);
        try{
            basicDataService.saveSeepage(dataMap);
            resultMap.put("msg", "保存成功！");
        }
        catch(Exception e){
            resultMap.put("flag", "1");
            resultMap.put("msg", "保存失败！");
        }
        return resultMap;
    }
}

package com.dse.tgang.dam.web;

import com.dse.tgang.dam.service.BasicFeatureService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaoq on 2017-4-18.
 */
@Controller
@RequestMapping("BasicFeatureCtl")
public class BasicFeatureCtl {

    @Resource
    private BasicFeatureService service;

    /**
     * 查询水库特征值
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "getList")
    @ResponseBody
    protected Object getList(@RequestBody Map<String, String> dataMap) {
        return service.getList(dataMap);
    }

    /**
     * 保存水库特征值
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "saveInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object saveInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            service.saveInfo(dataMap);
            map.put("msg", "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "保存失败！");
        }
        return map;
    }

    /**
     * 更新水库特征值
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "updateInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            service.updateInfo(dataMap);
            map.put("msg", "保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "保存失败！");
        }
        return map;
    }

    /**
     * 删除水库特征值
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "deleteInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object deleteInfo(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            service.deleteInfo(dataMap);
            map.put("msg", "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "删除失败！");
        }
        return map;
    }

    /**
     * 手动交换大坝数据
     *
     * @param dataMap
     * @return
     */
    @RequestMapping(value = "exchangeData", method = RequestMethod.POST)
    @ResponseBody
    public Object exchangeData(@RequestBody Map<String, String> dataMap) {
        Map<String, String> map = new HashMap<String, String>(1);
        try {
            service.exchangeData(dataMap);
            map.put("msg", "同步成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "1");
            map.put("msg", "同步失败！");
        }
        return map;
    }
}

package com.dse.tgang.dam.web;

import com.dse.tgang.dam.service.HydOrigDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/14.
 */
@Controller
@RequestMapping("HydOrigDataCtrl")
public class HydOrigDataCtrl {

    @Resource
    private HydOrigDataService hydOrigDataService;

    @RequestMapping(value = "queryData", method = RequestMethod.POST)
    @ResponseBody
    public Object queryData(@RequestBody Map<String, String> dataMap) throws Exception {
       return hydOrigDataService.queryCdbhjSysw(dataMap);
    }
}

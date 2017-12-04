package com.dse.reservoir.sjfx.shenya.web;

import com.dse.reservoir.api.sjfx.pojo.entity.WrrbmEntity;
import com.dse.reservoir.api.sjfx.shenya.service.WrrbmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pengzx on 2017/6/6.
 */
@Controller
@RequestMapping("/wrrbmCtrl")
public class WrrbmCtrl {

    @Resource(name="wrrbmService")
    private WrrbmService wrrbmService;

    @RequestMapping(value = "/getWrrbmListData")
    @ResponseBody
    public Object getWrrbmListData(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String rb_cd=request.getParameter("rb_cd");
        String proj_cd_one=request.getParameter("proj_cd_one");
        String proj_cd_two=request.getParameter("proj_cd_two");
        String item_cd=request.getParameter("item_cd");
        String rb_type=request.getParameter("rb_type");
        String st_tp=request.getParameter("st_tp");

        WrrbmEntity args=new WrrbmEntity();
        args.setItem_cd(item_cd);
        args.setProj_cd_one(proj_cd_one);
        args.setProj_cd_two(proj_cd_two);
        args.setRb_cd(rb_cd);
        args.setRb_type(rb_type);
        args.setSt_tp_list(st_tp);

        List<Map> dataList=(List<Map>)wrrbmService.getWrrbmListData(args);
        List resultDataList=new ArrayList<Map>();
        if(dataList!=null&& dataList.size()>0){
            for (Map data:dataList) {
                Map dataMap=new HashMap();
                dataMap.put("id",data.get("RB_CD")) ;
                dataMap.put("text",data.get("RB_NM")) ;
                resultDataList.add(dataMap);
            }
        }
        //String jsonStr=com.dse.common.util.json.JsonUtil.object2Json(resultDataList);
        //System.err.println(this.getClass().getName()+" >>>>>>>>>.jsonStr："+jsonStr);

        return  resultDataList;
    }

}

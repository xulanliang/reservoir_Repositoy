package com.dse.reservoir.scheduler.jobs;

import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.sgxc.wrchktask.pojo.WrchkTaskModel;
import com.dse.reservoir.api.sgxc.wrchktask.pojo.WrchkTaskVo;
import com.dse.reservoir.api.sgxc.wrchktask.service.WrchkTaskService;
import com.dse.reservoir.api.util.DateUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/15.
 */
public class WrchkTaskJob {

    @Resource(name = "wrchkTaskService")
    private WrchkTaskService wrchkTaskService;

    public void work() {
        WrchkTaskModel wrchkTask =new WrchkTaskModel();
        Object wrchkTaskCount = null;
        /*

         CK_TK_ID, CK_TK_DESC, CK_OBJ_ID, CREATE_USER, CREATE_DATE,
        CK_BEGIN, CK_END, CK_ORG, CK_TYPE, CK_USERS, CK_CYCLE, CK_FREQUENCY,
        CK_INT_HOURS,LAST_CREATE_DATE

         */
        try {
           //List<Map> taskList = (List<Map> ) wrchkTaskService.getJobWrchkTaskList(wrchkTask);
           // String   taskListStr=JsonUtil.object2Json(taskList);
           // System.err.println(" taskListStr: "+taskListStr);

            WrchkTaskVo wrVo=null;

            List<WrchkTaskModel> wrchkTaskList2 = wrchkTaskService.getJobWrchkTaskList2(wrchkTask);

            String   taskListStr=JsonUtil.object2Json(wrchkTaskList2);
            System.err.println(" taskListStr: "+taskListStr);
            if(wrchkTaskList2!=null && wrchkTaskList2.size()>0){
                for(WrchkTaskModel taskmodel:wrchkTaskList2){
                    if(StringUtil.isNotEmpty(taskmodel.getNt())){
                        taskmodel.setNt(taskmodel.getNt()+"系统自动");
                    }else{
                        taskmodel.setNt("系统自动");
                    }
                    if(taskmodel.getLast_create_date()==null){
                        taskmodel.setLast_create_date(new java.util.Date());
                    }
                    wrchkTaskService.execTask(taskmodel);
                }
            }

            /*
            if(taskList!=null){
                for (Map data:taskList) {
                    wrVo=new WrchkTaskVo();
                    wrchktaskUpdate=new WrchkTaskModel();
                    wrVo.setCk_int_hours((Integer) data.get("CK_INT_HOURS"));
                    wrVo.setCk_cycle((String)data.get("CK_CYCLE"));
                    wrVo.setCk_frequency((Integer)  data.get("CK_FREQUENCY"));
                    wrVo.setCk_tk_id((String) data.get("CK_TK_ID"));
                    wrVo.setLast_create_date((Date) data.get("LAST_CREATE_DATE"));
                    wrVo.setCreate_date((Date)data.get("CREATE_DATE"));
                    wrVo.setCreate_user((String)data.get("CREATE_USER"));

                    wrchktaskUpdate.setCk_tk_id(wrchktaskUpdate.getCk_tk_id());

                }
            }
        */
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("date:" + new Date().toString() +"wrchkTaskCount:"+wrchkTaskCount );

    }


}

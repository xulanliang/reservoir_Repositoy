package com.dse.reservoir.scheduler.jobs;

import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wrmawarningb.pojo.WrMaWarningbModel;
import com.dse.reservoir.api.fxwz.wrmawarningb.service.WrMaWarningbService;
import com.dse.reservoir.api.sgxc.wrchktask.pojo.WrchkTaskVo;
import com.dse.reservoir.api.sgxc.wrchktask.service.WrchkTaskService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/4.
 */
public class WrMaWarningbTaskJob {

    @Resource(name = "wrMaWarningbService")
    private WrMaWarningbService wrMaWarningbService;

    public void work() {
        FxWzArgModel args=new FxWzArgModel();
        WrMaWarningbModel wrmaVo=null;
        try {
            List<Map> stdGuanList = wrMaWarningbService.getWrMaWarningbStdGuanList(args);
            if(stdGuanList!=null){
                for (Map data:stdGuanList) {
                    wrmaVo=new WrMaWarningbModel();
                    wrmaVo.setOrg_cd((String)data.get("ORG_CD"));
                    wrmaVo.setWh_cd((String)data.get("WH_CD"));
                    wrmaVo.setMa_cd((String)  data.get("MA_CD"));
                    wrmaVo.setWa_dt(new Date());
                    wrmaVo.setWa_status("0");
                    wrmaVo.setWa_tp("0");
                    Double wa_value=0D;
                    Double da_value=0D;
                    String std_quan ="";
                    if(data.get("STD_QUAN")!=null ){
                        std_quan= data.get("STD_QUAN").toString();
                    }
                    String real_quan =data.get("REAL_QUAN").toString();
                    if(!StringUtil.isNotEmpty(std_quan)){
                        if(data.get("GS_STD_QUAN")!=null ){
                            std_quan= data.get("GS_STD_QUAN").toString();
                        }
                    }
                    if(StringUtil.isNotEmpty(std_quan) && StringUtil.isNotEmpty(real_quan)){
                        wa_value=Double.parseDouble(std_quan);
                        Double rq_value=Double.parseDouble(real_quan);
                        da_value=wa_value-rq_value;
                    }
                    wrmaVo.setDa_value(da_value.toString());
                    wrmaVo.setReal_value(data.get("REAL_QUAN").toString());
                    wrmaVo.setWa_value(wa_value.toString());
                    wrmaVo.setNt("系统自动生成");
                    wrMaWarningbService.saveOrUpdateInfo(wrmaVo);
                }
            }

            List<Map> stdYearList = wrMaWarningbService.getWrMaWarningbStdYearList(args);
            if(stdYearList!=null){
                for (Map data:stdYearList) {
                    wrmaVo=new WrMaWarningbModel();
                    wrmaVo.setOrg_cd((String)data.get("ORG_CD"));
                    wrmaVo.setWh_cd((String)data.get("WH_CD"));
                    wrmaVo.setMa_cd((String)  data.get("MA_CD"));
                    wrmaVo.setWa_dt(new Date());
                    wrmaVo.setWa_status("0");
                    wrmaVo.setWa_tp("1");
                    wrmaVo.setDa_value(data.get("STD_YEAR").toString());
                    wrmaVo.setReal_value(data.get("TS").toString());
                    wrmaVo.setWa_value(data.get("NOWYEAR").toString());
                    wrmaVo.setNt("系统自动生成");
                    wrMaWarningbService.saveOrUpdateInfo(wrmaVo);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

package com.dse.reservoir.sgxc.wrchktask.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sgxc.wrchkobject.pojo.WrchkObjectModel;
import com.dse.reservoir.api.sgxc.wrchktask.pojo.WrchkTaskModel;
import com.dse.reservoir.api.sgxc.wrchktask.pojo.WrchkTaskVo;
import com.dse.reservoir.api.sgxc.wrchktask.service.WrchkTaskService;
import com.dse.reservoir.api.util.DateUtil;
import com.dse.reservoir.sgxc.wrchkrecord.dao.WrchkRecordDao;
import com.dse.reservoir.sgxc.wrchktask.dao.WrchkTaskDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/***
 *
 */
@Service("wrchkTaskService")
@Transactional
public class WrchkTaskServiceImp implements WrchkTaskService {

    @Resource(name="wrchkTaskDao")
    public WrchkTaskDao wrchkTaskDao;

    @Resource(name="wrchkRecordDao")
    public WrchkRecordDao wrchkRecordDao;

    /***
     *
     * @param args
     * @param notcktkid
     * @return
     * @throws Exception
     */
    public Object getWrchkTaskList(WrchkTaskModel args, String notcktkid) throws Exception{
        return wrchkTaskDao.getWrchkTaskList(args,notcktkid);
    }

    /****
     *
     * @param args
     * @return
     * @throws Exception
     */
    public Object getWrchkTaskCount(WrchkTaskModel args) throws Exception{
        return wrchkTaskDao.getWrchkTaskCount(args);
    }

    @Override
    public EasyUiPage getListInfoByParams(WrchkTaskModel args, EasyUiPage easyUiPage){
        return wrchkTaskDao.getListInfoByParams(args,easyUiPage);
    }

    @Override
    public Object getInfoById(String id) {
        return wrchkTaskDao.getInfoById(id);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) {
        return wrchkTaskDao.saveOrUpdateInfo(dataStr);
    }

    @Override
    public Object deleteInfoByIds(String ids) {
         return wrchkTaskDao.deleteInfoByIds(ids);
    }

    /***
     *
     * @param args
     * @return
     * @throws Exception
     */
    public Object getJobWrchkTaskList(WrchkTaskModel args) throws Exception{
        return wrchkTaskDao.getJobWrchkTaskList(args);
    }

    /**
     *
     * @param args
     * @return
     * @throws Exception
     */
    public List<WrchkTaskModel> getJobWrchkTaskList2(WrchkTaskModel args) throws Exception{
        return wrchkTaskDao.getJobWrchkTaskList2(args);
    }

    /***
     * 根据计划生成任务方法
     * @param taskmodel
     * @return
     */
    public Object createJobToWrChkRecordData(WrchkTaskModel taskmodel) throws Exception{
        return  wrchkRecordDao.createWrChkRecordData(taskmodel);
    }

    /***
     *
     * @param taskmodel
     * @throws Exception
     */
    public Object execTask(WrchkTaskModel taskmodel) throws Exception{
        if(taskmodel.getLast_create_date()==null){
            taskmodel.setLast_create_date(new Date());
        }
        if(taskmodel.getCk_frequency()==null){
            taskmodel.setCk_frequency(1);
        }
        System.err.println("old taskmodel.getCk_frequency():"+taskmodel.getCk_frequency()
                +" taskmodel.getLast_create_date(): "+DateUtil.dateToStr(taskmodel.getLast_create_date(),DateUtil.DATE_MASK
        )    +" taskmodel.getLast_create_dateStr(): "+taskmodel.getLast_create_dateStr());

        if(WrchkTaskVo.CYCLE_001.equalsIgnoreCase(taskmodel.getCk_cycle())){//按年
            Date last_create_date=taskmodel.getLast_create_date();
            if(taskmodel.getCk_frequency()!=null){
                if(taskmodel.getCk_frequency()>1){
                    int days=365;
                    days=days/taskmodel.getCk_frequency();
                    last_create_date=DateUtil.addDay2Date(taskmodel.getLast_create_date(),days);
                }else{
                    last_create_date=DateUtil.add2Date(taskmodel.getLast_create_date(),1,DateUtil.DATE_YEAR);
                }
            }
            taskmodel.setLast_create_date(last_create_date);
            taskmodel.setLast_create_dateStr(null);
        }else if(WrchkTaskVo.CYCLE_002.equalsIgnoreCase(taskmodel.getCk_cycle())){//按半年
            Date last_create_date=taskmodel.getLast_create_date();
            if(taskmodel.getCk_frequency()!=null){
                if(taskmodel.getCk_frequency()>1){
                    int days=183;
                    days=days/taskmodel.getCk_frequency();
                    last_create_date=DateUtil.addDay2Date(taskmodel.getLast_create_date(),days);
                }else{
                    last_create_date=DateUtil.add2Date(taskmodel.getLast_create_date(),6,DateUtil.DATE_MONTH);
                }
            }
            taskmodel.setLast_create_date(last_create_date);
            taskmodel.setLast_create_dateStr(null);
        }else if(WrchkTaskVo.CYCLE_003.equalsIgnoreCase(taskmodel.getCk_cycle())){//按季
            Date last_create_date=taskmodel.getLast_create_date();
            if(taskmodel.getCk_frequency()!=null){
                if(taskmodel.getCk_frequency()>1){
                    int days=93;
                    days=days/taskmodel.getCk_frequency();
                    last_create_date=DateUtil.addDay2Date(taskmodel.getLast_create_date(),days);
                }else{
                    last_create_date=DateUtil.add2Date(taskmodel.getLast_create_date(),3,DateUtil.DATE_MONTH);
                }
            }
            taskmodel.setLast_create_date(last_create_date);
            taskmodel.setLast_create_dateStr(null);
        }else if(WrchkTaskVo.CYCLE_004.equalsIgnoreCase(taskmodel.getCk_cycle())){//按月
            Date last_create_date=taskmodel.getLast_create_date();
            if(taskmodel.getCk_frequency()!=null){
                if(taskmodel.getCk_frequency()>1){
                    int days=30;
                    days=days/taskmodel.getCk_frequency();
                    last_create_date=DateUtil.addDay2Date(taskmodel.getLast_create_date(),days);
                }else{
                    last_create_date=DateUtil.add2Date(taskmodel.getLast_create_date(),1,DateUtil.DATE_MONTH);
                }
            }
            taskmodel.setLast_create_date(last_create_date);
            taskmodel.setLast_create_dateStr(null);
        }else if(WrchkTaskVo.CYCLE_005.equalsIgnoreCase(taskmodel.getCk_cycle())){//按周
            Date last_create_date=taskmodel.getLast_create_date();
            if(taskmodel.getCk_frequency()!=null){
                if(taskmodel.getCk_frequency()>1){
                    int days=7;
                    days=days/taskmodel.getCk_frequency();
                    last_create_date=DateUtil.addDay2Date(taskmodel.getLast_create_date(),days);
                }else{
                    last_create_date=DateUtil.addDay2Date(taskmodel.getLast_create_date(),7);
                }
            }
            taskmodel.setLast_create_date(last_create_date);
            taskmodel.setLast_create_dateStr(null);
        }else if(WrchkTaskVo.CYCLE_006.equalsIgnoreCase(taskmodel.getCk_cycle())){ //按天

            Date last_create_date=taskmodel.getLast_create_date();
            if(taskmodel.getCk_frequency()!=null && taskmodel.getCk_frequency()>1){
                int hours=24;
                hours=hours/taskmodel.getCk_frequency();
                last_create_date=DateUtil.addHour2Date(taskmodel.getLast_create_date(),hours);
            }else{
                if(taskmodel.getCk_int_hours()!=null && taskmodel.getCk_int_hours()>0){
                    last_create_date=DateUtil.addHour2Date(taskmodel.getLast_create_date(),taskmodel.getCk_int_hours());
                }else{
                    last_create_date=DateUtil.addDay2Date(taskmodel.getLast_create_date(),1);
                }
            }
            taskmodel.setLast_create_date(last_create_date);
            taskmodel.setLast_create_dateStr(null);
        }
        System.err.println("new taskmodel.getCk_frequency():"+taskmodel.getCk_frequency()
                +" taskmodel.getLast_create_date(): "+DateUtil.dateToStr(taskmodel.getLast_create_date(),DateUtil.DATE_MASK
        )    +" taskmodel.getLast_create_dateStr(): "+taskmodel.getLast_create_dateStr());
        Object flag = this.createJobToWrChkRecordData(taskmodel);
        return flag;
    }
}

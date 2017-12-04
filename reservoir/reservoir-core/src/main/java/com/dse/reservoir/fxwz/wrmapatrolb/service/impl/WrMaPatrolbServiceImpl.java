package com.dse.reservoir.fxwz.wrmapatrolb.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wrmapatrolb.service.WrMaPatrolbService;
import com.dse.reservoir.fxwz.wrmapatrolb.dao.WrMaPatrolbDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by pc on 2017-8-3.
 */
@Service("wrmapatrolbService")
@Transactional
public class WrMaPatrolbServiceImpl implements WrMaPatrolbService {

    @Resource(name="wrmapatrolbDao")
    public WrMaPatrolbDao wrmapatrolbDao;

    @Override
    public EasyUiPage getListInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage) throws Exception {
        return wrmapatrolbDao.getListInfoByParams(args, easyUiPage);
    }

    @Override
    public EasyUiPage getListWZXCNRInfoByParams(String isflood, EasyUiPage easyUiPage) throws Exception {
        return wrmapatrolbDao.getListWZXCNRInfoByParams(isflood, easyUiPage);
    }

    @Override
    public EasyUiPage getWZXCListInfoByParams(String search_ck_re_id,String search_ck_cnt_desc,String search_ch_status, EasyUiPage easyUiPage) throws Exception {
        return wrmapatrolbDao.getWZXCListInfoByParams(search_ck_re_id,search_ck_cnt_desc,search_ch_status, easyUiPage);
    }

    @Override
    public Object deleteInfoByIds(String ids) throws Exception {
        return wrmapatrolbDao.deleteInfoByIds(ids);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception {
        return wrmapatrolbDao.saveOrUpdateInfo(dataStr);
    }

    @Override
    public Object doSave(String taskID) throws Exception {
        return wrmapatrolbDao.doSave(taskID);
    }

    @Override
    public Object saveXcsb(String ckID, String issue, String issueID, String taskID) throws Exception {
        return wrmapatrolbDao.saveXcsb(ckID,issue,issueID,taskID);
    }

    @Override
    public Object getInfoById(String id) throws Exception {
        return wrmapatrolbDao.getInfoById(id);
    }

    public Object updateStautsByIds(String ids,String stauts) throws Exception{
        return wrmapatrolbDao.updateStautsByIds(ids,stauts);
    }
}

package com.dse.reservoir.fxwz.wzkzgl.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wzkzgl.pojo.WzkzglModel;
import com.dse.reservoir.api.fxwz.wzkzgl.service.WzkzglService;
import com.dse.reservoir.fxwz.wzkzgl.dao.WzkzglDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/***
 *
 */
@Service("wzkzglService")
@Transactional
public class WzkzglServiceImp implements WzkzglService {

    @Resource(name="wzkzglDao")
    public WzkzglDao wzkzglDao;

    @Override
    public EasyUiPage getListInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage){
        return wzkzglDao.getListInfoByParams(args,easyUiPage);
    }

    @Override
    public EasyUiPage getCrkListInfoByParams(String type,String sTime, String eTime, String dep_id, String ck_id,String statu, EasyUiPage easyUiPage) {
        return wzkzglDao.getCrkListInfoByParams(type,sTime,eTime,dep_id,ck_id,statu,easyUiPage);
    }


    /**
     * 查询仓库基础信息
     * @param args 仓库
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getWzkzylListInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage){
        return wzkzglDao.getWzkzylListInfoByParams(args,easyUiPage);
    }

    @Override
    public Object getInfoById(String id) {
        return wzkzglDao.getInfoById(id);
    }

    @Override
    public Object getCrkInfoById(String id) {
        return wzkzglDao.getCrkInfoById(id);
    }

    /**
     * 获取信息
     * @param args
     * @return
     */
    public Object getWrmaquanbInfoById(FxWzArgModel args){
        return wzkzglDao.getWrmaquanbInfoById(args);
    }


    public Object saveOrUpdateInfo(String dataStr) {
        return wzkzglDao.saveOrUpdateInfo(dataStr);
    }

    @Override
    public Object delCrkInfoByByIds(String ids) {
        return wzkzglDao.delCrkInfoByByIds(ids);
    }

    /**
     * 保存或修改
     * @param dataStr
     * @return
     */
    public Object saveOrUpdateWrmaquanbInfo(String dataStr){
        return wzkzglDao.saveOrUpdateWrmaquanbInfo(dataStr);
    }

    @Override
    public Object saveCrkInfo(String dataStr) {
        return wzkzglDao.saveCrkInfo(dataStr);
    }

    /**
     *
     * @param dataStr
     * @return
     */
    public Object addwz2ck(String dataStr){
        return wzkzglDao.addwz2ck(dataStr);
    }
    @Override
    public Object deleteInfoByIds(String ids) {
         return wzkzglDao.deleteInfoByIds(ids);
    }

    @Override
    public EasyUiPage getCkListInfo(EasyUiPage easyUiPage) {
        return wzkzglDao.getCkListInfo(easyUiPage);
    }

    @Override
    public EasyUiPage getWzListInfo(EasyUiPage easyUiPage) {
        return wzkzglDao.getWzListInfo(easyUiPage);
    }

    /**
     * 修改
     * @param ma_cd
     * @param wh_cd
     * @return
     */
    public Object updateWrMaInventoryRealquan(String ma_cd,String wh_cd){
        return wzkzglDao.updateWrMaInventoryRealquan(ma_cd,wh_cd);
    }
}

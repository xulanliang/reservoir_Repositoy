package com.dse.reservoir.api.fxwz.wrmawarningb.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wrmawarningb.pojo.WrMaWarningbModel;

import java.util.List;
import java.util.Map;


/**
 * Created by  on 2017-09-04.
 * 物资报警信息管理表
 */
public interface WrMaWarningbService {


    /**
     * 查询数据
     *
     * @param args
     * @return
     */
    public EasyUiPage getListInfoByParams(FxWzArgModel args , EasyUiPage easyUiPage) throws Exception;

    /**
     * 删除数据
     *
     * @param ids
     * @return
     */
    public Object deleteInfoByIds(String ids) throws Exception;

    /**
     * 保存或修改
     *
     * @param dataStr
     * @return
     */
    public Object saveOrUpdateInfo(String dataStr) throws Exception;

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    public Object getInfoById(String id) throws Exception;

    public Object updateStautsByIds(String ids,String stauts) throws Exception;

    public List<Map> getWrMaWarningbStdGuanList(FxWzArgModel args) throws Exception;

    public List<Map> getWrMaWarningbStdYearList(FxWzArgModel args) throws Exception;

    public Object saveOrUpdateInfo(WrMaWarningbModel model) throws Exception;

}

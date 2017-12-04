package com.dse.reservoir.api.fxwz.wzxxgl.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;

/**
 * Created by pc on 2017-8-3.
 */
public interface WzxxglService {

    /**
     * 查询物资基础数据
     * @param name 物资名称
     * @param type 物资分类
     * @return
     */
    public EasyUiPage getListInfoByParams(String name, String type, EasyUiPage easyUiPage) throws Exception;

    /**
     * 删除数据
     * @param ids
     * @return
     */
    public Object deleteInfoByIds(String ids) throws Exception;

    /**
     * 保存或修改
     * @param dataStr
     * @return
     */
    public Object saveOrUpdateInfo(String dataStr) throws Exception;

    /**
     * 获取详情
     * @param id
     * @return
     */
    public Object getInfoById(String id) throws Exception;

    public EasyUiPage getListWzCkPcBinInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage) throws Exception;

    public EasyUiPage getListWzCkPcBinInfoByParamsNew(FxWzArgModel args, EasyUiPage easyUiPage) throws Exception;

    public Object getWzCkPcBinInfoById(FxWzArgModel args) throws Exception;

}

package com.dse.reservoir.api.fxwz.wzflgl.service;

import com.dse.common.entity.EasyUiPage;

/**
 * Created by pc on 2017-8-1.
 */
public interface WzflglService {

    /**
     * 查询物资分类数据
     * @return
     */
    public Object getfl(String id) throws Exception;

    /**
     * 检查ID
     * @return
     */
    public Object checkId(String id) throws Exception;

    /**
     * 查询物资分类数据
     * @param wztypename
     * @return
     */
    public EasyUiPage getListInfoByParams(String wztypename, EasyUiPage easyUiPage) throws Exception;

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

}

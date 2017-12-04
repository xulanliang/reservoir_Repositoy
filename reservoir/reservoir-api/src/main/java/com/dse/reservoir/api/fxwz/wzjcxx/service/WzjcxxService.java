package com.dse.reservoir.api.fxwz.wzjcxx.service;


import com.dse.common.entity.EasyUiPage;


/**
 * @Description:物资基础信息接口
 * @Copyright: Copyright 2016 ShenZhen DSE Software Corporation
 * @Company: 深圳市东深电子股份有限公司
 * @author 刘旭
 * @version 2.0 2016-11-07
 */
public interface WzjcxxService {

    /**
     * 查询物资基础信息
     * @param wzname 物资名称
     * @param wztype 物资类型
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getListInfoByParams(String wzname, String wztype, EasyUiPage easyUiPage);

    /**
     * 获取信息
     * @param wzid
     * @return
     */
    public Object getInfoById(String wzid);

    /**
     * 保存或修改
     * @param dataStr
     * @return
     */
    public Object saveOrUpdateInfo(String dataStr);

    /**
     * 删除
     * @param ids
     * @return
     */
    public Object deleteInfoByIds(String ids);
}
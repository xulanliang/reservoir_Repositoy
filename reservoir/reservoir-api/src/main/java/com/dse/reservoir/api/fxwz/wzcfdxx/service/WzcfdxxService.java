package com.dse.reservoir.api.fxwz.wzcfdxx.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.wzcfdxx.pojo.WzcfdxxModel;


/**
 * 物资存放地信息
 * Created by liuxu on 2016/11/7.
 */
public interface WzcfdxxService  {
    /**
     * 查询物资存放点数据
     * @param orgid
     * @param ckname
     * @param year
     * @return
     */
    public EasyUiPage getListInfoByParams(String adcd, String ckname, String year, EasyUiPage easyUiPage);

    /**
     * 删除数据
     * @param ids
     * @return
     */
    public Object deleteInfoByIds(String ids);

    /**
     * 保存或修改
     * @param dataStr
     * @return
     */
    public Object saveOrUpdateInfo(String dataStr);

    /**
     * 获取详情
     * @param ckid
     * @return
     */
    public Object getInfoById(String ckid);
}

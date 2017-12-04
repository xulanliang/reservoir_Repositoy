package com.dse.reservoir.fxwz.wzcfxx.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;

/**
 * Created by pengzx on 2017-6-19.
 */
public interface WzcfxxDao extends IBaseDao {

    /**
     * 查询仓库基础信息
     * @param ckid 仓库名称
     * @param wzid 物资名称
     * @param year 年份
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getListInfoByParams(String ckid, String wzid, String year, EasyUiPage easyUiPage);

    /**
     * 获取信息
     * @param id
     * @return
     */
    public Object getInfoById(String id);

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

    /**
     * 获取仓库信息
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getCkListInfo(EasyUiPage easyUiPage);

    /**
     * 获取物资信息
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getWzListInfo(EasyUiPage easyUiPage);

}

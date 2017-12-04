package com.dse.reservoir.fxwz.wzcfdxx.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;

/**
 * Created by pengzx on 2017-6-19.
 */
public interface WzcfdxxDao   {

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

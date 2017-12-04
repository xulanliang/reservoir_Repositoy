package com.dse.reservoir.fxwz.wzjcxx.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;

/**
 * Created by pc on 2017-6-19.
 */
public interface WzjcxxDao extends IBaseDao {

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

package com.dse.reservoir.sjfx.wralarmparamm.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.wralarmparamm.pojo.WrAlarmParammModel;


/**
 * Created by   on 2017-08-22.
 */
public interface WrAlarmParammDao extends IBaseDao<WrAlarmParammModel, String> {


    /**
     * 查询数据
     *
     * @param args
     * @return
     */
    public EasyUiPage getListInfoByParams(WrAlarmParammModel args, EasyUiPage easyUiPage) throws Exception;

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

}

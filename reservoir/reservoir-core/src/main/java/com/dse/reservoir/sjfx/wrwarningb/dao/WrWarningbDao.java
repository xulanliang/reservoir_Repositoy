package com.dse.reservoir.sjfx.wrwarningb.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.wrwarningb.pojo.WrWarningbModel;

import java.util.Map;

/**
 * Created by   on 2017-08-22.
 */
public interface WrWarningbDao extends IBaseDao<WrWarningbModel, String> {

    /**
     * 查询物资分类数据
     *
     * @param args
     * @return
     */
    public EasyUiPage getListInfoByParams(WrWarningbModel args, EasyUiPage easyUiPage) throws Exception;

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

    /**
     * 根据工程编号获取报警数据
     * @param conditionMap
     * @param type 0:表示查询列表数据 ； 1：表示查询单条数据
     * @param easyUiPage
     * @return
     * @throws Exception
     */
    public Object getWarnListByProjCd(Map<String,Object> conditionMap, EasyUiPage easyUiPage,String type) throws  Exception;


    public Integer UpdateWarnStatus(Map<String,Object> params) throws Exception;

    Object getRateData(Map<String,Object> params) throws Exception;

    /**
     * 获取数据缺失率
     * @param params
     * @return
     * @throws Exception
     */
    Object getLostRate(Map<String, Object> params) throws  Exception;
    /**
     * 获取每个工程的无故障工作时间和出现故障次数
     * @param params
     * @return
     * @throws Exception
     */
    Object getWorkingHours(Map<String, Object> params) throws  Exception;

    /**
     * 根据工程编号获得报警数量
     * @param params
     * @return
     * @throws Exception
     */
    Object getAlarmCountByCd(Map<String, Object> params) throws  Exception;

}

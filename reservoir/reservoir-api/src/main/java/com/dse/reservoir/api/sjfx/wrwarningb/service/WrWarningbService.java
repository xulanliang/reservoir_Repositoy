package com.dse.reservoir.api.sjfx.wrwarningb.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.wrwarningb.pojo.WrWarningbModel;

import java.util.Map;

/**
 * Created by  on 2017-08-21.
 */
public interface WrWarningbService {


    /**
     * 查询数据
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
     * 获取相应工程的报警数据
     * @param type              0:表示查询列表数据 ； 1：表示查询单条数据
     * @param condtionMap       查询参数map
     * @param easyUiPage
     * @return
     * @throws Exception
     */
    public Object getWarnListByProjCd(Map<String,Object> condtionMap, EasyUiPage easyUiPage, String type) throws  Exception;

    /**
     * 保存或修改(直接传entity参数
     *
     * @param
     * @return
     */
    public Integer saveOrUpdate(Map<String,Object> params) throws Exception;

    /**
     * 获取首页的 完整率信息
     * @param params
     * @return
     * @throws Exception
     */
    Object getRateData(Map<String,Object> params) throws Exception;

    /**
     * 获取数据缺失率数据
     * @param params
     * @return
     * @throws Exception
     */
    Object getLostRate(Map<String, Object> params) throws  Exception ;

    Object getWorkingHours(Map<String, Object> params) throws  Exception;

    /**
     * 根据工程编号获得报警数量
     * @param params
     * @return
     * @throws Exception
     */
    Object getAlarmCountByCd(Map<String, Object> params) throws  Exception;

}

package com.dse.reservoir.api.fxwz.ckxxgl.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.ckxxgl.pojo.WrWhB;

/**
 * Created by pc on 2017-8-2.
 */
public interface CkxxglService {

    /**
     * 管理单位
     * @return
     */
    public Object getOrg() throws Exception;

    /**
     *  获取巡查点
     * @return
     * @throws Exception
     */
    public Object getXcdListBycode(String depID,String objID) throws Exception;

    /**
     * 采集方式
     * @return
     */
    public Object getGetType() throws Exception;

    /**
     *  监测类型
     * @return
     * @throws Exception
     */
    public Object getJclx() throws Exception;

    /**
     *  一级工程名称
     * @return
     * @throws Exception
     */
    public Object getProject() throws Exception;

    /**
     *  根据一级工程id获取模块名称
     * @return
     * @throws Exception
     */
    public Object getMDNAME(String PROJ_CD) throws Exception;

    /**
     *  测点测量状态
     * @return
     * @throws Exception
     */
    public Object getCdclzt() throws Exception;

    /**
     * 查询仓库信息数据
     * @param args
     * @return
     */
    public EasyUiPage getListInfoByParams(WrWhB args, EasyUiPage easyUiPage) throws Exception;

    /***
     *
     * @param args
     * @return
     * @throws Exception
     */
    public Object getListDataByParams(WrWhB args)  throws Exception ;

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

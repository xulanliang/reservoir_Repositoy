package com.dse.reservoir.comm.sys.dao;

import com.dse.common.dao.IBaseDao;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/30.
 */
public interface DseSysCommonsqlDao extends IBaseDao {


    /**
     * 获取行政区划信息
     * @param  code : 区划编码
     * @author ZHOUP
     * @date  2017年06月30日
     * @return
     */
    public Object divisionInfo(String code);

    /**
     * 获取测站信息
     * @author ZHOUP
     * @date  2016年10月20日
     * @return
     */
    public Object getStationInfo(Map<String, String> dataMap) throws Exception;
    /**
     * 获取字典列表
     * @author
     * @date  2016年10月20日
     * @return
     */
    public Object getListBycode( String ids,String state,String pcode) throws Exception;

    /**
     *  获取物资信息
     * @param id
     * @return
     * @throws Exception
     */
    public Object getWzInfoBycode2( String id) throws Exception;

    /**
     *  获取巡查对象
     * @param pcode
     * @param ck_org
     * @return
     * @throws Exception
     */
    public Object getListCheckObj( String pcode,String ck_org) throws Exception;

}
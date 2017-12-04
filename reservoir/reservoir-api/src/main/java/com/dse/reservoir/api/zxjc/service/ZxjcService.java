package com.dse.reservoir.api.zxjc.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;

/**
 * Created by pc on 2017-7-13.
 */
public interface ZxjcService {

    /**
     * 获取左侧菜单树
     * @return
     */
    public Object getTree() throws Exception;

    /**
     * 查询在线监测数据
     * @param stm 开始时间
     * @param etm 结束时间
     * @param   gcxArgs 项目ID
     * @return
     */
    public EasyUiPage getZxjcDate(String stm, String etm, GcxEntity gcxArgs, EasyUiPage easyUiPage) throws Exception;

    /**
     * 测点名称模糊查询
     * @param key 关键字
     * @param projcd 工程ID
     * @param type 测点类型
     * @return
     */
    public Object getPointByKey(String key,String projcd,String type) throws Exception;

}

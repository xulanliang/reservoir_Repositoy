package com.dse.reservoir.api.tableEdit.cdgclx;

import com.dse.common.entity.EasyUiPage;

/**
 * Created by yuan_feng on 2017/8/21.
 */
public interface CdgclxService {
//测点工程类型映射表
//    查询列表
    public EasyUiPage getCdgclxList(String ITEM_NM, String MON_TP, String IS_AUTO, EasyUiPage easyUiPage);
//    根据id删除数据
    public Object deleteCdgcByIds(String ids);
//    新增或者修改
    public Object saveOrUpdateCdgcList(String dataStr);
//    涵管基本信息表
    public EasyUiPage getHgList(String HG_NM, String HG_DESC, String ids, EasyUiPage easyUiPage);
    public Object deleteHgByIds(String ids);
    public Object saveOrUpdateHgList(String dataStr);
//    渗压监测数据表
    public EasyUiPage getSyjc(String ids, String tm, String  getType,EasyUiPage easyUiPage);
    public Object deleteSyjcByIds(String ids,String tm);
    public Object saveOrUpdateSyjc(String dataStr);
}


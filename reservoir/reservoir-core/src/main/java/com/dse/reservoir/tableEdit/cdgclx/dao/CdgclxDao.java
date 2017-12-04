package com.dse.reservoir.tableEdit.cdgclx.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;

/**
 * Created by yuan_feng on 2017/8/21.
 */
public interface CdgclxDao extends IBaseDao {
//   测点工程类型映射
    public EasyUiPage getCdgclxList(String ITEM_NM, String MON_TP, String IS_AUTO, EasyUiPage easyUiPage);
    public Object deleteCdgcByIds(String ids);
    public Object saveOrUpdateCdgcListDao(String dataStr);
//   涵管基本信息
    public EasyUiPage getHgList(String HG_NM, String HG_DESC, String ids, EasyUiPage easyUiPage);
    public Object deleteHgByIds(String ids);
    public Object saveOrUpdateHgList(String dataStr);
//    渗压监测数据表
    public EasyUiPage getSyjc(String ids, String tm, String  getType,EasyUiPage easyUiPage);
    public Object deleteSyjcByIds(String ids,String tm);
    public Object saveOrUpdateSyjc(String dataStr);
}

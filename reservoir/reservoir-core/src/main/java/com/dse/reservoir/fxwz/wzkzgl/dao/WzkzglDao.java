package com.dse.reservoir.fxwz.wzkzgl.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wzkzgl.pojo.WzkzglModel;

/***
 *物资库存表
 * 2017-08-06
 */
public interface WzkzglDao extends IBaseDao {

    /**
     * 查询仓库基础信息
     * @param args 参数
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getListInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage);

    /**
     *  查询入库记录信息
     * @param sTime
     * @param eTime
     * @param dep_id
     * @param ck_id
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getCrkListInfoByParams(String type,String sTime, String eTime, String dep_id, String ck_id,String statu, EasyUiPage easyUiPage);

    /**
     * 查询仓库基础信息
     * @param args 仓库
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getWzkzylListInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage);

    /**
     * 获取信息
     * @param id
     * @return
     */
    public Object getInfoById(String id);

    /**
     *  获取入库信息记录
     * @param id
     * @return
     */
    public Object getCrkInfoById(String id);

    /**
     * 获取信息
     * @param args
     * @return
     */
    public Object getWrmaquanbInfoById(FxWzArgModel args);

    /**
     * 保存或修改
     * @param dataStr
     * @return
     */
    public Object saveOrUpdateInfo(String dataStr);

    /**
     *  删除出入库记录
     * @param ids
     * @return
     */
    public Object delCrkInfoByByIds(String ids);

    /**
     * 保存或修改
     * @param dataStr
     * @return
     */
    public Object saveOrUpdateWrmaquanbInfo(String dataStr);

    /**
     *  保存出入库记录
     * @param dataStr
     * @return
     */
    public Object saveCrkInfo(String dataStr);

    /**
     *
     * @param dataStr
     * @return
     */
    public Object addwz2ck(String dataStr);

    /**
     * 删除
     * @param ids
     * @return
     */
    public Object deleteInfoByIds(String ids);

    /**
     * 获取仓库信息
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getCkListInfo(EasyUiPage easyUiPage);

    /**
     * 获取物资信息
     * @param easyUiPage
     * @return
     */
    public EasyUiPage getWzListInfo(EasyUiPage easyUiPage);

    /**
     * 修改
     * @param ma_cd
     * @param wh_cd
     * @return
     */
    public Object updateWrMaInventoryRealquan(String ma_cd,String wh_cd);



}

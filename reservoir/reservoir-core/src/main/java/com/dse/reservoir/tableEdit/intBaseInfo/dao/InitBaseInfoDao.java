package com.dse.reservoir.tableEdit.intBaseInfo.dao;

import com.dse.common.dao.IBaseDao;

/**
 * Created by 许兰良 on 2017/7/7.
 *
 * @Company 深圳市东深电子股份有限公司
 */
public interface InitBaseInfoDao extends IBaseDao {
    public Object reservoirInfo();
    public Object initSectionInfo();
    public Object initSectionExtendInfo(String id);
    public Object initCcxmInfo();
}

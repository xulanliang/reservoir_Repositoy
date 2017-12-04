package com.dse.reservoir.tableEdit.cdgclx;
import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.tableEdit.cdgclx.CdgclxService;
import com.dse.reservoir.tableEdit.cdgclx.dao.CdgclxDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by yuan_feng on 2017/8/21.
 */
@Service("cdgclxServiceImpl")
@Transactional
public class CdgclxServiceImpl implements CdgclxService {

    @Resource(name ="cdgclxDao")
    public CdgclxDao cdgclxDao;
    @Override
    public EasyUiPage getCdgclxList(String ITEM_NM, String MON_TP, String IS_AUTO, EasyUiPage easyUiPage) {
        return cdgclxDao.getCdgclxList(ITEM_NM, MON_TP,IS_AUTO,easyUiPage);
    }

    @Override
    public Object deleteCdgcByIds(String ids) {
        return cdgclxDao.deleteCdgcByIds(ids);
    }

    @Override
    public Object saveOrUpdateCdgcList(String dataStr) {
        return cdgclxDao.saveOrUpdateCdgcListDao(dataStr);
    }

    @Override
    public EasyUiPage getHgList(String HG_NM, String HG_DESC, String ids, EasyUiPage easyUiPage) {
        return cdgclxDao.getHgList(HG_NM,HG_DESC,ids,easyUiPage);
    }

    @Override
    public Object deleteHgByIds(String ids) {
        return cdgclxDao.deleteHgByIds(ids);
    }

    @Override
    public Object saveOrUpdateHgList(String dataStr) {
        return cdgclxDao.saveOrUpdateHgList(dataStr);
    }

    @Override
    public EasyUiPage getSyjc(String ids, String tm, String getType, EasyUiPage easyUiPage) {
        return cdgclxDao.getSyjc(ids,tm,getType,easyUiPage);
    }
    @Override
    public Object deleteSyjcByIds(String ids , String tm) {
        return cdgclxDao.deleteSyjcByIds(ids,tm );
    }

    @Override
    public Object saveOrUpdateSyjc(String dataStr) {
        return cdgclxDao.saveOrUpdateSyjc(dataStr);
    }

}

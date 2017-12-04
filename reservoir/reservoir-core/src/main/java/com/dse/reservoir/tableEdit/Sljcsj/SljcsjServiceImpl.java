package com.dse.reservoir.tableEdit.Sljcsj;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.pojo.vo.Sljcsj;
import com.dse.reservoir.api.tableEdit.sljcsj.SljcsjService;
import com.dse.reservoir.tableEdit.Sljcsj.sljcsjDao.SljcsjDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuan_feng on 2017/9/6.
 */
@Service("sljcsjServiceImpl")
@Transactional
public class SljcsjServiceImpl implements SljcsjService {
    @Resource(name="sljcsjDao")
    private SljcsjDao sljcsjDao;

    @Override
    public EasyUiPage getSljcsjListService(Sljcsj slj,EasyUiPage easyUiPage) {
        return sljcsjDao.getSljcsjList(slj,easyUiPage);
    }

    @Override
    public Object deleteSljcsjService(Sljcsj slj) {
        return sljcsjDao.deleteSljcsjDao(slj);
    }

    @Override
    public Object saveSljcsjService(String  dataStr) {
        return  sljcsjDao.saveSljcsjDao(dataStr);
    }

    @Override
    public EasyUiPage getDcListService(String dcCd,String dcNm,EasyUiPage easyUiPage) {
        return sljcsjDao.getDcListDao( dcCd, dcNm,easyUiPage);
    }

    @Override
    public Object deleteDcServiceById(String id) {
        return sljcsjDao.deleteDcByIdDao(id);
    }

    @Override
    public Object savevDcService(String dataStr) {
        return  sljcsjDao.savevDcDao(dataStr);
    }

    @Override
    public EasyUiPage getDccjListService(Sljcsj slj, EasyUiPage easyUiPage) {
        return sljcsjDao.getDccjListDao(slj,easyUiPage);
    }

    @Override
    public Object deleteDccjService(Sljcsj slj) {
        return sljcsjDao.deleteDccjDao(slj);
    }

    @Override
    public Object saveDccjService(String dataStr) {
        return  sljcsjDao.saveDccjDao(dataStr);
    }

    @Override
    public EasyUiPage getJcdmCdService(String id,String name, EasyUiPage easyUiPage) {
        return  sljcsjDao.getJcdmCdDao( id,name, easyUiPage);
    }

    @Override
    public Object deleteJcdmCdService(String id) {
        return  sljcsjDao.deleteJcdmCdDao(id);
    }

    @Override
    public Object saveJcdmCdService(String dataStr) {
        return  sljcsjDao.saveJcdmCdDao(dataStr);
    }


}

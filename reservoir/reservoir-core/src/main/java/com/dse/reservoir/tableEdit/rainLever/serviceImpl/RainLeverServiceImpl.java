package com.dse.reservoir.tableEdit.rainLever.serviceImpl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.tableEdit.rainLever.RainLeverService;
import com.dse.reservoir.tableEdit.rainLever.dao.RainLeverDao;
import com.dse.reservoir.tableEdit.rainLever.dao.impl.RainLeverDaoImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Xll on 2017/7/5.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Service("rainLeverService")
@Transactional
public class RainLeverServiceImpl implements RainLeverService {

    @Resource(name = "rainLeverDao")
    private RainLeverDao rainLeverDao;

    @Override
    public EasyUiPage getRainListInfoByParams(String stnm, String sTM, String eTM,String PROJ_NM, EasyUiPage easyUiPage) {
        return rainLeverDao.getRainListInfoByParams(stnm, sTM, eTM,PROJ_NM, easyUiPage);
    }

    @Override
    public EasyUiPage getProjectBaseListInfoByParams(String ITEM_NM, String MON_TP, String IS_AUTO, EasyUiPage easyUiPage) {
        return rainLeverDao.getProjectBaseListInfoByParams(ITEM_NM, MON_TP, IS_AUTO, easyUiPage);
    }

    @Override
    public EasyUiPage getSectionBaseListInfoByParams(String RB_NM, EasyUiPage easyUiPage) {
        return rainLeverDao.getSectionBaseListInfoByParams(RB_NM, easyUiPage);
    }

    @Override
    public EasyUiPage getCzwyjcxxListInfoByParams(String RB_NM, String STM, String ETM, EasyUiPage easyUiPage) {
        return rainLeverDao.getCzwyjcxxListInfoByParams(RB_NM,STM,ETM,easyUiPage);
    }

    @Override
    public EasyUiPage getDdwyjcxxListInfoByParams(String RB_NM, String STM, String ETM, EasyUiPage easyUiPage) {
        return rainLeverDao.getDdwyjcxxListInfoByParams(RB_NM,STM,ETM,easyUiPage);
    }

    @Override
    public EasyUiPage getGcjbxxListInfoByParams(String RB_NM,String CK_ORG, String STM, String ETM, EasyUiPage easyUiPage) {
        return rainLeverDao.getGcjbxxListInfoByParams(RB_NM,CK_ORG,STM,ETM,easyUiPage);
    }

    @Override
    public EasyUiPage getMkjbxxbListInfoByParams(String RB_NM, EasyUiPage easyUiPage) {
        return rainLeverDao.getMkjbxxbListInfoByParams(RB_NM,easyUiPage);
    }

    @Override
    public EasyUiPage getQwqyListInfoByParams(String STM, String ETM, EasyUiPage easyUiPage) {
        return rainLeverDao.getQwqyListInfoByParams(STM,ETM,easyUiPage);
    }

    @Override
    public EasyUiPage getSwbListInfoByParams(String STM, String ETM, EasyUiPage easyUiPage) {
        return rainLeverDao.getSwbListInfoByParams(STM,ETM,easyUiPage);
    }

    @Override
    public EasyUiPage getSksqbListInfoByParams(String STM, String ETM, EasyUiPage easyUiPage) {
        return rainLeverDao.getSksqbListInfoByParams(STM,ETM,easyUiPage);
    }

    @Override
    public EasyUiPage getSpwycjxxListInfoByParams(String STNM, String STM, String ETM, EasyUiPage easyUiPage) {
        return rainLeverDao.getSpwycjxxListInfoByParams(STNM,STM,ETM,easyUiPage);
    }

    @Override
    public EasyUiPage getCdjcxxbListInfoByParams(String STNM, EasyUiPage easyUiPage) {
        return rainLeverDao.getCdjcxxbListInfoByParams(STNM,easyUiPage);
    }

    @Override
    public Object getInfoById(String id, String tm) {
        return rainLeverDao.getInfoById(id,tm);
    }

    @Override
    public Object getSectionBaselnfoById(String id) {
        return rainLeverDao.getSectionBaselnfoById(id);
    }

    @Override
    public Object getCdjcxxbInfoById(String id) {
        return rainLeverDao.getCdjcxxbInfoById(id);
    }

    @Override
    public Object getSpwycjxxInfoById(String id) {
        return rainLeverDao.getSpwycjxxInfoById(id);
    }

    @Override
    public Object getQwqyInfoById(String id) {
        return rainLeverDao.getQwqyInfoById(id);
    }

    @Override
    public Object getSksqbInfoById(String id) {
        return rainLeverDao.getSksqbInfoById(id);
    }

    @Override
    public Object getSwbInfoById(String id) {
        return rainLeverDao.getSwbInfoById(id);
    }

    @Override
    public Object getCzwyjcxxlnfoById(String stcd, String TM,String QS) {
        return rainLeverDao.getCzwyjcxxlnfoById(stcd,TM,QS);
    }

    @Override
    public Object getDdwyjcxxlnfoById(String stcd, String TM) {
        return rainLeverDao.getDdwyjcxxlnfoById(stcd,TM);
    }

    @Override
    public Object getGcjbxxlnfoById(String id) {
        return rainLeverDao.getGcjbxxlnfoById(id);
    }

    @Override
    public Object getMkjbxxblnfoById(String id) {
        return rainLeverDao.getMkjbxxblnfoById(id);
    }

    @Override
    public Object getProjectBaseInfoById(String id) {
        return rainLeverDao.getProjectBaseInfoById(id);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) {
        return rainLeverDao.saveOrUpdateInfo(dataStr);
    }

    @Override
    public Object saveOrUpdateCzwyjcxxInfo(String dataStr) {
        return rainLeverDao.saveOrUpdateCzwyjcxxInfo(dataStr);
    }

    @Override
    public Object saveOrUpdateSpwycjxxInfo(String dataStr) {
        return rainLeverDao.saveOrUpdateSpwycjxxInfo(dataStr);
    }

    @Override
    public Object saveOrUpdateSksqbInfo(String dataStr) {
        return rainLeverDao.saveOrUpdateSksqbInfo(dataStr);
    }

    @Override
    public Object saveOrUpdateMkjbxxInfo(String dataStr) {
        return rainLeverDao.saveOrUpdateMkjbxxInfo(dataStr);
    }

    @Override
    public Object saveOrUpdateCdjcxxbInfo(String dataStr) {
        return rainLeverDao.saveOrUpdateCdjcxxbInfo(dataStr);
    }

    @Override
    public Object saveOrUpdateDdwyjcxxInfo(String dataStr) {
        return rainLeverDao.saveOrUpdateDdwyjcxxInfo(dataStr);
    }

    @Override
    public Object saveOrUpdateGcjbxxInfo(String dataStr) {
        return rainLeverDao.saveOrUpdateGcjbxxInfo(dataStr);
    }

    @Override
    public Object saveOrUpdateQwqyInfo(String dataStr) {
        return rainLeverDao.saveOrUpdateQwqyInfo(dataStr);
    }

    @Override
    public Object saveOrUpdateSwbInfo(String dataStr) {
        return rainLeverDao.saveOrUpdateSwbInfo(dataStr);
    }

    @Override
    public Object saveOrUpdateProjectBaseInfo(String dataStr) {
        return rainLeverDao.saveOrUpdateProjectBaseInfo(dataStr);
    }

    @Override
    public Object saveOrUpdateSectionBaseInfo(String dataStr) {
        return rainLeverDao.saveOrUpdateSectionBaseInfo(dataStr);
    }

    @Override
    public Object deleteInfoByIds(String ids) {
        return rainLeverDao.deleteInfoByIds(ids);
    }

    @Override
    public Object deleteProjectBaseInfoByIds(String ids) {
        return rainLeverDao.deleteProjectBaseInfoByIds(ids);
    }

    @Override
    public Object deleteCdjcxxbInfoByIds(String ids) {
        return rainLeverDao.deleteCdjcxxbInfoByIds(ids);
    }

    @Override
    public Object deleteSpwycjxxInfoByIds(String ids) {
        return rainLeverDao.deleteSpwycjxxInfoByIds(ids);
    }

    @Override
    public Object deleteSksqbInfoByIds(String ids) {
        return rainLeverDao.deleteSksqbInfoByIds(ids);
    }

    @Override
    public Object deleteCzwyjcxxByIds(String ids) {
        return rainLeverDao.deleteCzwyjcxxByIds(ids);
    }

    @Override
    public Object deleteQwqyInfoByIds(String ids) {
        return rainLeverDao.deleteQwqyInfoByIds(ids);
    }

    @Override
    public Object deleteSwbInfoByIds(String ids) {
        return rainLeverDao.deleteSwbInfoByIds(ids);
    }

    @Override
    public Object deleteDdwyjcxxByIds(String ids) {
        return rainLeverDao.deleteDdwyjcxxByIds(ids);
    }

    @Override
    public Object deleteGcjbxxByIds(String ids) {
        return rainLeverDao.deleteGcjbxxByIds(ids);
    }

    @Override
    public Object deleteMkjbxxByIds(String ids) {
        return rainLeverDao.deleteMkjbxxByIds(ids);
    }

    @Override
    public Object getShenyaStatsParamList(Map<String, Object> conditionMap,EasyUiPage easyUiPage) {
        return rainLeverDao.getShenyaStatsParamList(conditionMap,easyUiPage);
    }

    @Override
    public Object getShenyaStatsInfoById(Map<String, Object> conditionMap) {
        return rainLeverDao.getShenyaStatsInfoById(conditionMap);
    }

    @Override
    public Object saveOrUpdateShenyaStatsParamInfo(String dataStr) {
        return rainLeverDao.saveOrUpdateShenyaStatsParamInfo(dataStr);
    }
}

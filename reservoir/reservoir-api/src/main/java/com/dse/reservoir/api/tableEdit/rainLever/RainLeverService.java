package com.dse.reservoir.api.tableEdit.rainLever;

import com.dse.common.entity.EasyUiPage;

import java.util.Map;

/**
 * Created by Xll on 2017/7/5.
 *
 * @Company 深圳市东深电子股份有限公司
 */
public interface RainLeverService {
    public EasyUiPage getRainListInfoByParams(String stnm,String sTM,String eTM,String PROJ_NM,EasyUiPage easyUiPage);
    public EasyUiPage getProjectBaseListInfoByParams(String ITEM_NM,String MON_TP,String IS_AUTO,EasyUiPage easyUiPage);
    public EasyUiPage getSectionBaseListInfoByParams(String RB_NM,EasyUiPage easyUiPage);
    public EasyUiPage getCzwyjcxxListInfoByParams(String RB_NM,String STM,String ETM,EasyUiPage easyUiPage);
    public EasyUiPage getDdwyjcxxListInfoByParams(String RB_NM,String STM,String ETM,EasyUiPage easyUiPage);
    public EasyUiPage getGcjbxxListInfoByParams(String RB_NM,String CK_ORG,String STM,String ETM,EasyUiPage easyUiPage);
    public EasyUiPage getMkjbxxbListInfoByParams(String RB_NM,EasyUiPage easyUiPage);
    public EasyUiPage getQwqyListInfoByParams(String STM,String ETM,EasyUiPage easyUiPage);
    public EasyUiPage getSwbListInfoByParams(String STM,String ETM,EasyUiPage easyUiPage);
    public EasyUiPage getSksqbListInfoByParams(String STM,String ETM,EasyUiPage easyUiPage);
    public EasyUiPage getSpwycjxxListInfoByParams(String STNM,String STM,String ETM,EasyUiPage easyUiPage);
    public EasyUiPage getCdjcxxbListInfoByParams(String STNM,EasyUiPage easyUiPage);
    public Object getInfoById(String id,String tm);
    public Object getSectionBaselnfoById(String id);
    public Object getCdjcxxbInfoById(String id);
    public Object getSpwycjxxInfoById(String id);
    public Object getQwqyInfoById(String id);
    public Object getSksqbInfoById(String id);
    public Object getSwbInfoById(String id);
    public Object getCzwyjcxxlnfoById(String stcd,String TM,String QS);
    public Object getDdwyjcxxlnfoById(String stcd,String TM);
    public Object getGcjbxxlnfoById(String id);
    public Object getMkjbxxblnfoById(String id);
    public Object getProjectBaseInfoById(String id);
    public Object saveOrUpdateInfo(String dataStr);
    public Object saveOrUpdateCzwyjcxxInfo(String dataStr);
    public Object saveOrUpdateSpwycjxxInfo(String dataStr);
    public Object saveOrUpdateSksqbInfo(String dataStr);
    public Object saveOrUpdateMkjbxxInfo(String dataStr);
    public Object saveOrUpdateCdjcxxbInfo(String dataStr);
    public Object saveOrUpdateDdwyjcxxInfo(String dataStr);
    public Object saveOrUpdateGcjbxxInfo(String dataStr);
    public Object saveOrUpdateQwqyInfo(String dataStr);
    public Object saveOrUpdateSwbInfo(String dataStr);
    public Object saveOrUpdateProjectBaseInfo(String dataStr);
    public Object saveOrUpdateSectionBaseInfo(String dataStr);
    public Object deleteInfoByIds(String ids);
    public Object deleteProjectBaseInfoByIds(String ids);
    public Object deleteCdjcxxbInfoByIds(String ids);
    public Object deleteSpwycjxxInfoByIds(String ids);
    public Object deleteSksqbInfoByIds(String ids);
    public Object deleteCzwyjcxxByIds(String ids);
    public Object deleteQwqyInfoByIds(String ids);
    public Object deleteSwbInfoByIds(String ids);
    public Object deleteDdwyjcxxByIds(String ids);
    public Object deleteGcjbxxByIds(String ids);
    public Object deleteMkjbxxByIds(String ids);

    Object getShenyaStatsParamList(Map<String,Object> conditionMap,EasyUiPage easyUiPage);
    Object getShenyaStatsInfoById(Map<String,Object> conditionMap);
    Object saveOrUpdateShenyaStatsParamInfo(String dataStr);
}

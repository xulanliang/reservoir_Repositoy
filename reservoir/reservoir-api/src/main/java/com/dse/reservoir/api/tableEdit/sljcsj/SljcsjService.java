package com.dse.reservoir.api.tableEdit.sljcsj;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.pojo.vo.Sljcsj;

import java.util.List;

/**
 * Created by yuan_feng on 2017/9/6.
 */
public interface SljcsjService {
    public EasyUiPage getSljcsjListService(Sljcsj slj,EasyUiPage easyUiPage);
    public Object deleteSljcsjService(Sljcsj slj);
    public Object saveSljcsjService(String  dataStr);
    public EasyUiPage getDcListService(String dcCd,String dcNm,EasyUiPage easyUiPage);
    public Object deleteDcServiceById(String id);
    public Object savevDcService(String  dataStr);
    public EasyUiPage getDccjListService(Sljcsj slj,EasyUiPage easyUiPage);
    public Object deleteDccjService(Sljcsj slj);
    public Object saveDccjService(String  dataStr);
    public EasyUiPage getJcdmCdService(String id,String name,EasyUiPage easyUiPage);
    public Object deleteJcdmCdService(String id);
    public Object saveJcdmCdService(String  dataStr);

}

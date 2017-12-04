package com.dse.reservoir.tableEdit.Sljcsj.sljcsjDao;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.pojo.vo.Sljcsj;

import java.util.List;

/**
 * Created by yuan_feng on 2017/9/6.
 */
public interface SljcsjDao {
    public EasyUiPage getSljcsjList(Sljcsj slj ,EasyUiPage easyUiPage);
    public Object deleteSljcsjDao(Sljcsj slj) ;
    public Object saveSljcsjDao(String  dataStr) ;
    public EasyUiPage getDcListDao(String dcCd,String dcNm,EasyUiPage easyUiPage);
    public Object deleteDcByIdDao(String id);
    public Object savevDcDao(String  dataStr);
    public EasyUiPage getDccjListDao(Sljcsj slj ,EasyUiPage easyUiPage);
    public Object deleteDccjDao(Sljcsj slj) ;
    public Object saveDccjDao(String  dataStr) ;
    public EasyUiPage getJcdmCdDao(String id,String name ,EasyUiPage easyUiPage);
    public Object deleteJcdmCdDao(String id);
    public Object saveJcdmCdDao(String  dataStr);

}

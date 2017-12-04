package com.dse.reservoir.api.zlgl.wdzl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo.QuestionModel;

import java.util.List;

/**
 * Created by 许兰良 on 2017/6/22.
 *  文档管理
 * @Company 深圳市东深电子股份有限公司
 */

public interface WordglService {
    public EasyUiPage getListInfoByParams(String adcd, String ttype, String ptitle, String strDate, String endDate, EasyUiPage easyUiPage);

    public Object saveOrUpdateInfo(String dataStr,String creator);

    public Object deleteInfoByIds(String ids);

    public Object saveOrUpdateQuestion(List<QuestionModel> list);

}

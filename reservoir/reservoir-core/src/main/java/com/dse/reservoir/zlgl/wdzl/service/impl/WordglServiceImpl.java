package com.dse.reservoir.zlgl.wdzl.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.zlgl.wdzl.WordglService;
import com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo.QuestionModel;
import com.dse.reservoir.zlgl.wdzl.dao.WordglDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 许兰良 on 2017/6/22.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Service("wordglService")
@Transactional
public class WordglServiceImpl implements WordglService {
    @Resource(name = "wordglDao")
    private WordglDao wordglDao;
    @Override
    public EasyUiPage getListInfoByParams(String adcd, String ttype, String ptitle, String strDate, String endDate, EasyUiPage easyUiPage) {
        return wordglDao.getListInfoByParams(adcd,ttype,ptitle,strDate,endDate,easyUiPage);
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr,String creator) {
        return wordglDao.saveOrUpdateInfo(dataStr,creator);
    }

    @Override
    public Object deleteInfoByIds(String ids) {
        return wordglDao.deleteInfoByIds(ids);
    }

    @Override
    public Object saveOrUpdateQuestion(List<QuestionModel> list) {
        return wordglDao.saveOrUpdateQuestion(list);
    }
}

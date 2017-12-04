package com.dse.reservoir.core.service.impl;

import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.ConvertUtils;
import com.dse.reservoir.api.pojo.entity.Example;
import com.dse.reservoir.api.pojo.vo.ExampleVO;
import com.dse.reservoir.api.service.ExampleService;
import com.dse.reservoir.core.dao.ExampleDao;
import com.dse.reservoir.core.vo.assembly.ExampleVOAssembly;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhoujc on 2016-3-3.
 */
@Service("exampleService")
@Transactional
public class ExampleServiceImpl implements ExampleService {

    @Resource
    private ExampleDao exampleDao;


    @Override
    public EasyUiPage findExample(ExampleVO exampleVO, EasyUiPage easyUiPage) throws Exception {
        String id = exampleVO.getId();
        if (id != null && !"".equals(id)) {
            List<String> pids = ConvertUtils.convertElementPropertyToList(exampleDao.listAllDictionaryByPidsAndStatus(Arrays.asList(id), null), "id");
            pids.add(id);
            exampleVO.setPids(pids);
        }
        return exampleDao.listDictionary(exampleVO, easyUiPage).easyuiRowsToDto(ExampleVOAssembly.class);
    }


    /**
     * 根据id获取字典项
     *
     * @param exampleVO
     * @return
     */
    @Override
    public ExampleVO getExampleById(ExampleVO exampleVO) throws Exception {
        return ExampleVOAssembly.toVo(exampleDao.get(exampleVO.getId()));
    }


    /**
     * 保存数据项
     *
     * @param exampleVO
     * @return
     */
    @Override
    public String saveExample(ExampleVO exampleVO) throws Exception {
        Example dictionary = ExampleVOAssembly.toEntity(exampleVO);
        exampleDao.saveOrUpdate(dictionary);
        return dictionary.getId();
    }


    /**
     * 根据数据项id删除下级所有数据项
     *
     * @param exampleVO
     * @return
     */
    @Override
    public Boolean removeExampleById(ExampleVO exampleVO) throws Exception {
        String dictionaryId = exampleVO.getId();
        if (dictionaryId != null && !"".equals(dictionaryId)) {
            List<String> ids = ConvertUtils.convertElementPropertyToList(exampleDao.listAllDictionaryByPidsAndStatus(Arrays.asList(dictionaryId), null), "id");
            ids.add(dictionaryId);
            return exampleDao.removeDictionaryByIds(ids);
        } else
            return false;
    }


}

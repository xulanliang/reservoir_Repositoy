package com.dse.reservoir.core.dao;


import com.dse.common.dao.IBaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.enums.Status;
import com.dse.reservoir.api.pojo.entity.Example;
import com.dse.reservoir.api.pojo.vo.ExampleVO;
import com.dse.service.api.baseplatform.entity.pojo.sys.Dictionary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by zhoujc on 2016-3-3.
 */
@Repository("exampleDao")
@Transactional
public interface ExampleDao extends IBaseDao<Example, String> {


    /**
     * 通过传入父ID列表，获取下面所有的字典 ,状态传null查询所有，状态传入启用只查询启用
     *
     * @param pids
     * @param status
     * @return
     * @throws Exception
     */
    List<Dictionary> listAllDictionaryByPidsAndStatus(List<String> pids, Status status) throws Exception;


    /**
     * 获取字典项管理列表
     *
     * @param exampleVO
     * @param easyUiPage
     * @return
     */
    EasyUiPage listDictionary(ExampleVO exampleVO, EasyUiPage easyUiPage) throws Exception;


    /**
     * 根据id删除数据项（包括所有子节点）
     *
     * @param ids
     */
    Boolean removeDictionaryByIds(List<String> ids) throws Exception;


}
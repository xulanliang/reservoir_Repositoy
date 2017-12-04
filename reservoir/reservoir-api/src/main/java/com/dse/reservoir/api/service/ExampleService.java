package com.dse.reservoir.api.service;

import com.dse.common.entity.EasyUiPage;
import com.dse.reservoir.api.pojo.vo.ExampleVO;

/**
 * Created by zhoujc on 2016-3-3.
 */
public interface ExampleService {



    /**
     * 获取字典项管理列表
     *
     * @param exampleVO
     * @param easyUiPage
     * @return
     */
    EasyUiPage findExample(ExampleVO exampleVO, EasyUiPage easyUiPage) throws Exception;

    /**
     * 根据id获取字典项
     *
     * @param exampleVO
     * @return
     */
    ExampleVO getExampleById(ExampleVO exampleVO) throws Exception;


    /**
     * 保存数据项
     *
     * @param exampleVO
     * @return
     */
    String saveExample(ExampleVO exampleVO) throws Exception;

    /**
     * 根据数据项id删除下级所有数据项
     *
     * @param exampleVO
     * @return
     */
    Boolean removeExampleById(ExampleVO exampleVO) throws Exception;



}

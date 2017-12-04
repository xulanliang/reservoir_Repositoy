package com.dse.tgang.dam.dao;

import com.dse.common.dao.IBaseDao;
import com.dse.tgang.dam.domain.BasicFeature;

import java.util.List;
import java.util.Map;

/**
 * Created by gaoq on 2017-4-27.
 */
public interface BasicFeatureDao extends IBaseDao<BasicFeature, String> {

    void exchangeData(Map<String, String> dataMap) throws Exception;
}

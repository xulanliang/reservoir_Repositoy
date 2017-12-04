package com.dse.tgang.dam.service;

import java.util.Map;

/**
 * Created by gaoq on 2017-4-18.
 */
public interface BasicFeatureService {

    Object getList(Map<String, String> dataMap);

    void saveInfo(Map<String, String> dataMap);

    void updateInfo(Map<String, String> dataMap);

    void deleteInfo(Map<String, String> dataMap);

    void exchangeData(Map<String, String> dataMap) throws Exception;
}

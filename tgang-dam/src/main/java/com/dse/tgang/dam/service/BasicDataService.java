package com.dse.tgang.dam.service;


import net.sf.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoq on 2016-12-24.
 */
public interface BasicDataService {

    JSONArray buildTree(HttpServletRequest request) throws Exception;

    Object getReservoirList(Map<String, String> dataMap);

    Object getDykeList(Map<String, String> dataMap);

    Object getSectionList(Map<String, String> dataMap);

    Object getMonitorList(Map<String, String> dataMap);

    void saveReservoir(Map<String, String> dataMap);

    void updateReservoir(Map<String, String> dataMap);

    void deleteReservoir(Map<String, String> dataMap);

    void saveDyke(Map<String, String> dataMap);

    void updateDyke(Map<String, String> dataMap);

    void deleteDyke(Map<String, String> dataMap);

    void saveSection(Map<String, String> dataMap);

    void updateSection(Map<String, String> dataMap);

    void deleteSection(Map<String, String> dataMap);

    void saveMonitor(Map<String, String> dataMap);

    void updateMonitor(Map<String, String> dataMap);

    void deleteMonitor(Map<String, String> dataMap);

    List<Map<String,Object>> listDM(String ennmcd);

    Object listFSQ(String bntrcd);

    Object listBT(String bntrcd);

    Object querySY(String bntrcd, String date);

    Object querySW(String ennmcd,String date);

    Object queryXXSW(String ennmcd);

    void updateConfig(Map<String, String> dataMap);

    void deletePoint(Map<String, String> dataMap);

    List<Map<String,Object>> queryDyKe(String ennmcd);

    List<Map<String,Object>> querySectionByEnnmcd(String ennmcd);

    Object getLevelInfo(String bntrcd, String sdate, String edate, String ennmcd);

    Object getDisInfo(String bntrcd, String date);

    void deleteData(Map<String, String> dataMap);

    void updateData(Map<String, Object> dataMap);

    Object getPreMonitorList(Map<String, String> dataMap);

    Object getWaterInfo();

    Object getKrInfo(Map<String, Object> dataMap);

    void deleteFsq(Map<String, String> dataMap);

    Object getSeepageList(Map<String, String> dataMap);

    void deleteSeepage(Map<String, String> dataMap);

    Object getStcdByEnnmcd(Map<String, String> dataMap);

    void saveSeepage(Map<String, Object> dataMap) throws Exception;
}

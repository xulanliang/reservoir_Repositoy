package com.dse.tgang.dam.dao.impl;

import com.dse.common.annotations.DSESessionFactoryMapping;
import com.dse.common.dao.BaseDao;
import com.dse.tgang.dam.dao.BasicFeatureDao;
import com.dse.tgang.dam.domain.BasicFeature;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoq on 2017-4-27.
 */
@Repository("basicFeatureDaoImpl")
public class BasicFeatureDaoImpl extends BaseDao<BasicFeature, String > implements BasicFeatureDao {

    @Resource
    private JdbcTemplate jdbcTemplate;// 用于复杂sql

    public BasicFeatureDaoImpl(){

    }

    /**
     * 注入数据源
     * @param sessionFactory
     */
    @DSESessionFactoryMapping(name = "dse_common_sessionFactory")
    public void setRainSession(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void exchangeData(Map<String, String> dataMap) throws Exception {
        String days = dataMap.get("days");
        executeProcedure("up_exchange_data", null, days);
    }

    public Map<Integer, Object> executeProcedure(String procedureName, List<Integer> outValues, Object... inValues) throws Exception {

        Map<Integer, Object> outMap = null;
        Connection con = null;
        CallableStatement cstmt = null;
        try {

            con = jdbcTemplate.getDataSource().getConnection();

            // 组织查询语句
            String procedure = "{ call " + procedureName + "(";

            // in 参数列
            if (inValues != null) {
                for (int k = 0; k < inValues.length; k++) {
                    procedure += "?,";
                }
            }

            // out 参数列
            if (outValues != null && outValues.size() > 0) {
                for (int i = 0; i < outValues.size(); i++) {
                    procedure += "?,";
                }
            }

            procedure = StringUtils.substringBeforeLast(procedure, ",") + ")}";

            cstmt = con.prepareCall(procedure);
            // 设置查询in 参数
            if (inValues != null) {

                for (int i = 1; i < inValues.length + 1; i++) {
                    // cstmt.setObject(i, inValues[i - 1]);
                    if (inValues[i - 1] instanceof java.util.Date) {
                        cstmt.setDate(i, new java.sql.Date(((java.util.Date) inValues[i - 1]).getTime()));
                    } else {
                        cstmt.setObject(i, inValues[i - 1]);
                    }
                }
            }

            int len = 1;
            if (inValues != null) {
                len = len + inValues.length;
            }
            // 设置查询out 参数
            if (outValues != null && outValues.size() > 0) {
                for (int i = 0; i < outValues.size(); i++) {
                    cstmt.registerOutParameter(len + i, outValues.get(i));
                }
            }
            cstmt.execute();

            // 现在我们做一个循环:
            ResultSet rs = null;
            int updateCount = -1;
            int index = 0;
            outMap = new HashMap<Integer, Object>();
            do {
                updateCount = cstmt.getUpdateCount();
                if (updateCount != -1) {// 说明当前行是一个更新计数
                    // 处理.
                    cstmt.getMoreResults();
                    continue;// 已经是更新计数了,处理完成后应该移动到下一行
                    // 不再判断是否是ResultSet
                }
                rs = cstmt.getResultSet();
                if (rs != null) {// 如果到了这里,说明updateCount == -1
                    List<Object> lst = new ArrayList<Object>();
                    int length = rs.getMetaData().getColumnCount();

                    while (rs.next()) {
                        Map<Object, Object> objMap = new HashMap<Object, Object>();
                        for (int j = 0; j < length; j++) {
                            objMap.put(rs.getMetaData().getColumnName(j + 1), rs.getObject(j + 1));
                        }
                        lst.add(objMap);
                    }
                    if (rs != null) {
                        rs.close();
                    }

                    outMap.put(index++, lst);
                    // 处理rs
                    cstmt.getMoreResults();
                    continue;
                    // 是结果集,处理完成后应该移动到下一行
                }
                // 如果到了这里,说明updateCount == -1 && rs == null,什么也没的了

            } while (!(updateCount == -1 && rs == null));

            if (outValues != null && outValues.size() > 0) {
                for (int i = 0; i < outValues.size(); i++) {
                    outMap.put(100 + i, cstmt.getObject(len + i));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (null != cstmt) {
                cstmt.close();
            }
            if (null != con) {
                con.close();
            }
        }
        return outMap;

    }
}

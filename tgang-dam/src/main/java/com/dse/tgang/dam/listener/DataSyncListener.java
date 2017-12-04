package com.dse.tgang.dam.listener;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.log4j.Logger;
import org.wxd.common.utils.ConfigurationUtil;
import org.wxd.common.utils.JDBCUtil;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wangxd on 2017/2/8.
 */
public class DataSyncListener {
    private static final Logger logger = Logger.getLogger(DataSyncListener.class);
    private static final String FILE = "dam.properties";
    public static final String IS_OPEN_SYN = "isOpenSyn";
    public static final String SYN_TIME = "syn.time";
    public static final String SYN_BETTWEN_SECOND = "syn.bettwn.second";
    public static final String IS_SYN_DATA = "isSynData";
    public static final String IS_CLEAR_DATA = "isClearData";
    public static final String SRC_TABLE_NAME = "src.table.name";
    public static final String SRC_EXT_TABLE_NAME = "src.ext.table.name";
    public static final String TAR_TABLE_NAME = "tar.table.name";
    public static final String TAR_EXT_TABLE_NAME = "tar.ext.table.name";

    public static final String SRC_DRIVER = "src.jdbc.driver_class";
    public static final String SRC_URL = "src.jdbc.url";
    public static final String SRC_USERNAME = "src.jdbc.username";
    public static final String SRC_PWD = "src.jdbc.password";

    public static final String TAR_DRIVER = "tar.jdbc.driver_class";
    public static final String TAR_URL = "tar.jdbc.url";
    public static final String TAR_USERNAME = "tar.jdbc.username";
    public static final String TAR_PWD = "tar.jdbc.password";

    public static final String SRC_TABLE_FIELD_PRE = "src.table.field.";
    public static final String SRC_EXT_TABLE_FIELD_PRE = "src.ext.table.field.";
    public static final String SRC_FIELD_SAME_LINK = "src.field.same.link";

    public static final String SRC_SYN_SQL = "src.syn.sql";
    public static final String SRC_EXT_SYN_SQL = "src.ext.syn.sql";


    private static Map<String, String> props = Maps.newHashMap();
    private static Connection srcConn = null;
    private static Connection tarConn = null;


    private static String srcTableName = null;
    private static String srcExtTableName = null;
    private static String tarTableName = null;
    private static String tarExtTableName = null;

    private static List<String> srcFieldKeys = null;
    private static List<String> srcExtFieldKeys = null;
    private static List<String> tarFieldKeys = null;
    private static List<String> tarExtFieldKeys = null;


    private static List<String> srcField = null;
    private static List<String> srcExtField = null;
    private static List<String> tarField = null;
    private static List<String> tarExtField = null;

    // 对应两个以上字段的目标字段，如notest1+notest2=HTCD
    private static Map<String, String> linkField = Maps.newLinkedHashMap();
    private static String linkMark = "";
    private static Map<String, String> linkExtField = Maps.newLinkedHashMap();

    private DataSyncListener() {
    }

    public static void start() {
        init();
        startBuildData();
        startSyncData();
    }

    private static void init() {
        if (props.isEmpty()) props = ConfigurationUtil.getAllOfFile(FILE);
        srcTableName = props.get(SRC_TABLE_NAME);
        srcExtTableName = props.get(SRC_EXT_TABLE_NAME);
        tarTableName = props.get(TAR_TABLE_NAME);
        tarExtTableName = props.get(TAR_EXT_TABLE_NAME);

        srcFieldKeys = getFields(SRC_TABLE_FIELD_PRE);
        srcExtFieldKeys = getFields(SRC_EXT_TABLE_FIELD_PRE);
        tarFieldKeys = srcFieldKeys.stream().map(s -> props.get(s)).collect(Collectors.toList());
        tarExtFieldKeys = srcExtFieldKeys.stream().map(s -> props.get(s)).collect(Collectors.toList());

        srcField = keysTFields(srcFieldKeys);
        srcExtField = keysTFields(srcExtFieldKeys);
        tarField = keysTFields(tarFieldKeys);
        tarExtField = keysTFields(tarExtFieldKeys);

        linkMark = props.get(SRC_FIELD_SAME_LINK);
        // 获取连接字段
        buildLinkMap(tarField, srcField, linkField, linkMark);
        buildLinkMap(tarExtField, srcExtField, linkExtField, linkMark);

    }

    private static void buildLinkMap(List<String> tarField, List<String> srcField, Map<String, String> tarMap, String linkMark) {
        Map<String, String> isExits = Maps.newHashMap();
        for (int i = 0; i < tarField.size(); i++) {
            String tarF = tarField.get(i), srcF = srcField.get(i);
            if (isExits.get(tarF) != null) {
                isExits.put(tarF, isExits.get(tarF) + linkMark + srcF);
                tarMap.put(tarF, isExits.get(tarF));
            } else {
                isExits.put(tarF, srcF);
            }
        }
    }

    public static List<String> getFields(String pre) {
        return props.keySet().stream().filter(s -> s.startsWith(pre)).collect(Collectors.toList());
    }

    public static List<String> keysTFields(List<String> keys) {
        return keys.stream().map(s -> s.substring(s.lastIndexOf(".") + 1)).collect(Collectors.toList());
    }

    private static Connection srcNewConnection()throws Exception {
        srcConn = JDBCUtil.build(props.get(SRC_DRIVER), props.get(SRC_URL), props.get(SRC_USERNAME), props.get(SRC_PWD));
        srcConn.setAutoCommit(false);
        return srcConn;
    }

    private static Connection tarNewConnection() throws Exception {
        tarConn = JDBCUtil.build(props.get(TAR_DRIVER), props.get(TAR_URL), props.get(TAR_USERNAME), props.get(TAR_PWD));
        tarConn.setAutoCommit(false);
        return tarConn;
    }

    private static Connection srcConnection() throws Exception {
        if (srcConn != null) return srcConn;
        srcConn = JDBCUtil.build(props.get(SRC_DRIVER), props.get(SRC_URL), props.get(SRC_USERNAME), props.get(SRC_PWD));
        srcConn.setAutoCommit(false);
        return srcConn;
    }

    private static Connection tarConnection() throws Exception {
        if (tarConn != null) return tarConn;
        tarConn = JDBCUtil.build(props.get(TAR_DRIVER), props.get(TAR_URL), props.get(TAR_USERNAME), props.get(TAR_PWD));
        tarConn.setAutoCommit(false);
        return tarConn;
    }


    private static void startBuildData() {
        if (!Boolean.valueOf(ConfigurationUtil.get(FILE, IS_SYN_DATA))) return;
        try {
            logger.info("start sync data.....");
            Statement srcPs = null;
            Statement srcExtPs = null;
            ResultSet srcRs = null;
            ResultSet srcExtRs = null;
            Statement tarPs = null;
            Statement tarExtPs = null;

            // 是否清空数据
            srcConn = srcConnection();
            tarConn = tarConnection();
            if (Boolean.valueOf(props.get(IS_CLEAR_DATA))) {
                tarPs = tarConn.createStatement();
                tarPs.execute("DELETE FROM " + tarTableName);
                JDBCUtil.closeStatement(tarPs);

                tarExtPs = tarConn.createStatement();
                tarExtPs.execute("DELETE FROM " + tarExtTableName);
                JDBCUtil.closeStatement(tarExtPs);
            }
            // 获取src数据
            srcPs = srcConn.createStatement();
            srcRs = srcPs.executeQuery("SELECT * FROM " + srcTableName);

            srcExtPs = srcConn.createStatement();
            srcExtRs = srcExtPs.executeQuery("SELECT * FROM " + srcExtTableName);


            // 同步src与tar
            List<String> tarInsertList = getInsertSql(srcRs, tarTableName, srcField, tarField, linkField, linkMark);
            List<String> tarExtInsertList = getInsertSql(srcExtRs, tarExtTableName, srcExtField, tarExtField, linkExtField, linkMark);
            // 关闭相应连接
            JDBCUtil.close(null, srcPs, srcRs);
            JDBCUtil.close(null, srcExtPs, srcExtRs);

            insertBatch(tarConn, tarExtInsertList);

            insertBatch(tarConn, tarInsertList);

            tarConn.commit();

            JDBCUtil.close(tarConn, null, null);

            logger.info("end sync data.....");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }

    }

    private static void insertBatch(Connection tarConn, List<String> insertSqls) throws Exception {
        Statement st = tarConn.createStatement();
        for (String insertSql : insertSqls) {
            try{
                System.out.println("execute insert : " + insertSql);
                st.execute(insertSql);
            }catch (Exception e){
                e.printStackTrace();
                logger.error(e.getMessage(),e);
            }
        }
        tarConn.commit();
        JDBCUtil.closeStatement(st);
    }


    private static List<String> getInsertSql(ResultSet rs, String tableName, List<String> srcField, List<String> tarField, Map<String, String> linkField, String linkMark) throws Exception {
        List<String> insertSql = Lists.newArrayList();
        while (rs.next()) {
            StringBuilder tarInsertSql = insertSql(tableName, tarField);

            for (int i = 0; i < srcField.size(); i++) {
                String srcFieldName = srcField.get(i);
                Object val = rs.getObject(srcFieldName);
                if (val == null) {
                    tarInsertSql.append("NULL,");
                    continue;
                }
                if (val.getClass().getTypeName().equalsIgnoreCase("java.math.BigDecimal") || val.getClass().getTypeName().equalsIgnoreCase("java.lang.Integer"))
                    tarInsertSql.append(val + ",");
                else
                    tarInsertSql.append("'" + val + "',");
            }

            tarInsertSql.deleteCharAt(tarInsertSql.length() - 1).append(");");
            insertSql.add(tarInsertSql.toString());
        }
        return insertSql;
    }

    private static StringBuilder insertSql(String tableName, List<String> tarField) {
        StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
        LinkedHashSet<String> set = Sets.newLinkedHashSet();
        set.addAll(tarField);
        for (String colName : set) sql.append(colName).append(",");

        return sql.deleteCharAt(sql.length() - 1).append(") VALUES (");
    }

    private static void startSyncData() {
        if (!Boolean.valueOf(ConfigurationUtil.get(FILE, IS_OPEN_SYN))) return;

        String[] timeRule = ConfigurationUtil.get(FILE, SYN_TIME).split(" ");
        if (timeRule == null || timeRule.length < 3) {
            logger.error("时间格式配置有误，定时器启动失败!");
            return;
        }
        int hour = Integer.parseInt(timeRule[0]), min = Integer.parseInt(timeRule[1]), second = Integer.parseInt(timeRule[2]);
        logger.info("定时器为每天" + hour + "时" + min + "分" + second + "秒，执行同步.");

        long oneDayMillis = 24 * 60 * 60 * 1000;
        LocalTime beginSyncTime = LocalTime.of(hour, min, second);
        LocalDateTime nowDateTime = LocalDateTime.now();

        long beginStart = 0l;
        System.out.println(beginSyncTime);
        if (nowDateTime.toLocalTime().isBefore(beginSyncTime)) {
            beginStart = Duration.between(nowDateTime.toLocalTime(), beginSyncTime).toMillis();
        } else if (nowDateTime.toLocalTime().isAfter(beginSyncTime)) {
            beginStart = oneDayMillis - Duration.between(beginSyncTime, nowDateTime.toLocalTime()).toMillis();
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                logger.info("begin sync data...");
                try {
                    Connection srcCon = srcNewConnection();
                    Connection tarCon = tarNewConnection();

                    PreparedStatement srcPs = null;
                    PreparedStatement srcExtPs = null;
                    ResultSet srcRs = null;
                    ResultSet srcExtRs = null;
                    // 查询需要同步的数据
                    srcPs = srcCon.prepareStatement(props.get(SRC_SYN_SQL));
                    srcRs = srcPs.executeQuery();

                    List<String> tarInsertSql = getInsertSql(srcRs, tarTableName, srcField, tarField, linkField, linkMark);
                    JDBCUtil.close(null, srcPs, srcRs);

                    srcExtPs = srcCon.prepareStatement(props.get(SRC_EXT_SYN_SQL));
                    srcExtRs = srcExtPs.executeQuery();

                    List<String> tarExtInsertSql = getInsertSql(srcExtRs, tarExtTableName, srcExtField, tarExtField, linkExtField, linkMark);
                    JDBCUtil.close(null, srcExtPs, srcExtRs);

                    // 进行同步
                    insertBatch(tarCon, tarInsertSql);
                    insertBatch(tarCon, tarExtInsertSql);
                    tarCon.commit();

                    JDBCUtil.closeConnection(tarCon);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error(e.getMessage(), e);
                }finally {
                    try {
                        JDBCUtil.closeConnection(tarConn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            JDBCUtil.closeConnection(srcConn);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                logger.info("end sync data...");
            }
        }, /*beginStart*/0, Long.parseLong(props.get(SYN_BETTWEN_SECOND)) * 1000);
    }


}

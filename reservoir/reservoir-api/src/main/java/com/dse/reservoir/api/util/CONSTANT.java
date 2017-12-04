package com.dse.reservoir.api.util;

/**
 * ${DESCRIPTION}
 *
 * @author wangzy
 * @date 2017-10-28
 */
public class CONSTANT {

    public static final String CALC_TYPE_AVG = "1001";      // 计算平均值
    public static final String CALC_TYPE_SUM = "1002" ;     //计算累计值

    public static final String STATS_TYPE_SY = "SY"    ;    //渗压统计模型
    public static final String STATS_TYPE_SL = "SL"    ;    //渗流统计模型

    // 辅助决策统计模型 渗流测点编号
    public static final String STATS_TYPE_SL_M2 = "S0000078" ;          //主坝 M2 测点
    public static final String STATS_TYPE_SL_L = "S0000096" ;           //左副坝 L测点
    public static final String STATS_TYPE_SL_L4 = "S0000097" ;          //左副坝 L4测点
    public static final String STATS_TYPE_SL_R2 = "S0000113" ;          // 右副坝R 测点
}

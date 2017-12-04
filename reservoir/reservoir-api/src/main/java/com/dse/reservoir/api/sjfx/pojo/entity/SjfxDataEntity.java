package com.dse.reservoir.api.sjfx.pojo.entity;

import com.dse.common.entity.base.BaseEntity;


/**
 * 用于数据处理存储使用
 **/
public class SjfxDataEntity implements java.io.Serializable {


	/***
	 * 测点类型 1:渗压
	 */
	public static final String ST_TP_1 ="渗压";
	/***
	 * 测点类型 2 渗流
	 */
	public static final String ST_TP_2 ="渗流";
	/***
	 * 测点类型  3 水平位移
	 */
	public static final String ST_TP_3 ="水平位移";
	/***
	 * 测点类型 4垂直位移
	 */
	public static final String ST_TP_4 ="垂直位移";
	/***
	 * 测点类型 5水位
	 */
	public static final String ST_TP_5 ="水位";
	/***
	 * 测点类型 6雨量
	 */
	public static final String ST_TP_6 ="雨量";
	/***
	 * 测点类型 7气温<含气压>)
	 */
	public static final String ST_TP_7 ="气温";
	/***
	 * 测点类型 7气温<含气压>)
	 */
	public static final String ST_TP_7_1 ="气压";
	/***
	 * 测点类型 8深层位移
	 */
	public static final String ST_TP_8 ="深层位移";
	/***
	 * 测点类型 9渡槽沉降
	 */
	public static final String ST_TP_9 ="渡槽沉降";

	//数据值
	private Object data;

	//气温值
	private Object atmp;

	//气压值
	private Object airp;

	public Object getAirp() {
		return airp;
	}

	public void setAirp(Object airp) {
		this.airp = airp;
	}

	public Object getAtmp() {
		return atmp;
	}

	public void setAtmp(Object atmp) {
		this.atmp = atmp;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
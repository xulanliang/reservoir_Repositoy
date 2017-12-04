package com.dse.reservoir.api.sjfx.pojo.entity;


/***
 * 断面信息类
 */
public class WrrbmEntity implements java.io.Serializable {

	/***
	 * 断面编码
	 */
	private String rb_cd;

	/***
	 *一级工程编码
	 */
	private String proj_cd_one;

	/***
	 *二级工程编码
	 */
	private String proj_cd_two;
	/***
	 *监测项目编号
	 */
	private String item_cd;
	/***
	 *断面类型(0:横断面,1:纵断面)
	 */
	private String rb_type;

	/***
	 *测点类型(1:渗压 2 渗流 3 水平位移4垂直位移5水位6雨量7气温<含气压>8深层位移9渡槽沉降);例：3,5
	 */
	private String st_tp_list;

	public String getItem_cd() {
		return item_cd;
	}

	public void setItem_cd(String item_cd) {
		this.item_cd = item_cd;
	}

	public String getProj_cd_one() {
		return proj_cd_one;
	}

	public void setProj_cd_one(String proj_cd_one) {
		this.proj_cd_one = proj_cd_one;
	}

	public String getProj_cd_two() {
		return proj_cd_two;
	}

	public void setProj_cd_two(String proj_cd_two) {
		this.proj_cd_two = proj_cd_two;
	}

	public String getRb_cd() {
		return rb_cd;
	}

	public void setRb_cd(String rb_cd) {
		this.rb_cd = rb_cd;
	}

	public String getRb_type() {
		return rb_type;
	}

	public void setRb_type(String rb_type) {
		this.rb_type = rb_type;
	}

	public String getSt_tp_list() {
		return st_tp_list;
	}

	public void setSt_tp_list(String st_tp_list) {
		this.st_tp_list = st_tp_list;
	}
}
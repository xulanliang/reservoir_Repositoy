package com.dse.reservoir.api.sjfx.pojo.entity;

import com.dse.common.entity.base.BaseEntity;


/**
 * 用于过程线参数信息
 **/
public class GcxEntity extends BaseEntity {


	public String getId() {
		return null;
	}
	//断面编码
	private String wrrbm_rbcd;
	//工程编号
	private String wrprojb_proj_cd;
	//一工程编码
	private String projcd;

	//测点编号
	private String stcd;

	//测点编号集合,如1,2,3,4
	private String stcdids;

	//搜索关键字
	private String keyword;
	//测点类型
	private String ckID;

	public String getCkID() {
		return ckID;
	}

	public void setCkID(String ckID) {
		this.ckID = ckID;
	}

	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}

	public String getWrprojb_proj_cd() {
		return wrprojb_proj_cd;
	}

	public void setWrprojb_proj_cd(String wrprojb_proj_cd) {
		this.wrprojb_proj_cd = wrprojb_proj_cd;
	}

	public String getWrrbm_rbcd() {
		return wrrbm_rbcd;
	}

	public void setWrrbm_rbcd(String wrrbm_rbcd) {
		this.wrrbm_rbcd = wrrbm_rbcd;
	}

	public String getProjcd() {
		return projcd;
	}

	public void setProjcd(String projcd) {
		this.projcd = projcd;
	}

	public String getStcdids() {
		return stcdids;
	}

	public void setStcdids(String stcdids) {
		this.stcdids = stcdids;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
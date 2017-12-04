package com.dse.reservoir.api.fxwz.wzcfdxx.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @Description:物资存放点信息实体
 * @Copyright: Copyright 2016 ShenZhen DSE Software Corporation
 * @Company: 深圳市东深电子股份有限公司
 * @author 刘旭
 * @version 2.0 2016-11-09
 */
@Entity
@Table(name = "DSE_SF_CK_INFO_b")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WzcfdxxModel implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	/** 主键**/
	private Long ckid;
	
		/** 仓库名称**/
	private String ckname;	
	
		/** 启用年份**/
	private Long year;	
	
		/** 经度**/
	private Double lgtd;	
	
		/** 纬度**/
	private Double lttd;	
	
		/** 所属行政区划**/
	private String adcd;	
	
		/** 向上负责机构名称**/
	private String deptid;	
	
		/** 仓库详细地点**/
	private String ckaddress;	
	
		/** 物资来源**/
	private String wzly;	
	
		/** 联系电话**/
	private String lxtel;	
	
		/** 负责人名称**/
	private String fzrname;	
	
		/** 负责人联系电话**/
	private String fzrtel;	
	
		/** 备注**/
	private String remark;	
	

	
	public WzcfdxxModel() {
		super();
	}
	@Id
	@Column(name = "CKID",  nullable = false, precision = 16, scale = 0   )
	@NotNull(message="CKID不能为空")
	public Long getCkid() {
		return ckid;
	}

	public void setCkid(Long ckid) {
		this.ckid = ckid;
	}	
	@Column(name = "CKNAME" ,  length = 50   )
	@Length(min=0, max=50, message="仓库名称长度必须介于 0 和 50 之间")
	public String getCkname() {
		return ckname;
	}

	public void setCkname(String ckname) {
		this.ckname = ckname;
	}	
	@Column(name = "YEAR" ,  precision = 18, scale = 0   )
	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}
	@Column(name = "LGTD" ,  precision = 21, scale = 9   )
	public Double getLgtd() {
		return lgtd;
	}

	public void setLgtd(Double lgtd) {
		this.lgtd = lgtd;
	}	
	@Column(name = "LTTD" ,  precision = 20, scale = 9   )
	public Double getLttd() {
		return lttd;
	}

	public void setLttd(Double lttd) {
		this.lttd = lttd;
	}	
	@Column(name = "ADCD" ,  length = 15   )
	@Length(min=0, max=15, message="所属行政区划(暂未用)长度必须介于 0 和 15 之间")
	public String getAdcd() {
		return adcd;
	}

	public void setAdcd(String adcd) {
		this.adcd = adcd;
	}	
	@Column(name = "DEPTID" ,  length = 32   )
	@Length(min=0, max=32, message="向上负责机构名称长度必须介于 0 和 32 之间")
	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}	
	@Column(name = "CKADDRESS" ,  length = 100   )
	@Length(min=0, max=100, message="仓库详细地点长度必须介于 0 和 100 之间")
	public String getCkaddress() {
		return ckaddress;
	}

	public void setCkaddress(String ckaddress) {
		this.ckaddress = ckaddress;
	}	
	@Column(name = "WZLY" ,  length = 200   )
	@Length(min=0, max=200, message="物资来源长度必须介于 0 和 200 之间")
	public String getWzly() {
		return wzly;
	}

	public void setWzly(String wzly) {
		this.wzly = wzly;
	}	
	@Column(name = "LXTEL" ,  length = 20   )
	@Length(min=0, max=20, message="联系电话长度必须介于 0 和 20 之间")
	public String getLxtel() {
		return lxtel;
	}

	public void setLxtel(String lxtel) {
		this.lxtel = lxtel;
	}	
	@Column(name = "FZRNAME" ,  length = 50   )
	@Length(min=0, max=50, message="负责人名称长度必须介于 0 和 50 之间")
	public String getFzrname() {
		return fzrname;
	}

	public void setFzrname(String fzrname) {
		this.fzrname = fzrname;
	}	
	@Column(name = "FZRTEL" ,  length = 20   )
	@Length(min=0, max=20, message="负责人联系电话长度必须介于 0 和 20 之间")
	public String getFzrtel() {
		return fzrtel;
	}

	public void setFzrtel(String fzrtel) {
		this.fzrtel = fzrtel;
	}	
	@Column(name = "REMARK" ,  length = 200   )
	@Length(min=0, max=200, message="备注长度必须介于 0 和 200 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}	
	
	
}
package com.dse.reservoir.api.fxwz.wzjcxx.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @Description:物资基础信息实体
 * @Copyright: Copyright 2016 ShenZhen DSE Software Corporation
 * @Company: 深圳市东深电子股份有限公司
 * @author 刘旭
 * @version 2.0 2016-11-07
 */
 
 
@Entity
@Table(name = "DSE_SF_WZ_INFO_b")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WzjcxxModel implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	/** 主键**/
	private Long wzid;
	
		/** 物资名称**/
	private String wzname;	
	
		/** 物资计量单位**/
	private String wzdw;	
	
		/** 物资参考单价**/
	private Double wzdj;	
	
		/** 物资类型: 0工程抢险机具,1工程抢险物料,2救生救援器材,3应急照明器材4,抗旱器具物料,5其他**/
	private String wztype;	
	
		/** 型号及参数**/
	private String xhcs;	
	
		/** 生产厂家**/
	private String wzcj;	
	
		/** 备注**/
	private String remark;	
	
		/** 责任人电话**/
	private String ltel;	
	

	
	public WzjcxxModel() {
		super();
	}
	@Id
	@Column(name = "WZID",  nullable = false, precision = 16, scale = 0   )
	@NotNull(message="WZID不能为空")
	public Long getWzid() {
		return wzid;
	}

	public void setWzid(Long wzid) {
		this.wzid = wzid;
	}	
	@Column(name = "WZNAME" ,  length = 50   )
	@Length(min=0, max=50, message="物资名称长度必须介于 0 和 50 之间")
	public String getWzname() {
		return wzname;
	}

	public void setWzname(String wzname) {
		this.wzname = wzname;
	}	
	@Column(name = "WZDW" ,  length = 10   )
	@Length(min=0, max=10, message="物资计量单位长度必须介于 0 和 10 之间")
	public String getWzdw() {
		return wzdw;
	}

	public void setWzdw(String wzdw) {
		this.wzdw = wzdw;
	}	
	@Column(name = "WZDJ" ,  precision = 16, scale = 2   )
	public Double getWzdj() {
		return wzdj;
	}

	public void setWzdj(Double wzdj) {
		this.wzdj = wzdj;
	}	
	@Column(name = "WZTYPE" ,  length = 1   )
	@Length(min=0, max=1, message="物资类型: 0工程抢险机具,1工程抢险物料,2救生救援器材,3应急照明器材4,抗旱器具物料,5其他长度必须介于 0 和 1 之间")
	public String getWztype() {
		return wztype;
	}

	public void setWztype(String wztype) {
		this.wztype = wztype;
	}	
	@Column(name = "XHCS" ,  length = 100   )
	@Length(min=0, max=100, message="型号及参数长度必须介于 0 和 100 之间")
	public String getXhcs() {
		return xhcs;
	}

	public void setXhcs(String xhcs) {
		this.xhcs = xhcs;
	}	
	@Column(name = "WZCJ" ,  length = 100   )
	@Length(min=0, max=100, message="生产厂家长度必须介于 0 和 100 之间")
	public String getWzcj() {
		return wzcj;
	}

	public void setWzcj(String wzcj) {
		this.wzcj = wzcj;
	}	
	@Column(name = "REMARK" ,  length = 200   )
	@Length(min=0, max=200, message="备注长度必须介于 0 和 200 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}	
	@Column(name = "LTEL" ,  length = 20   )
	@Length(min=0, max=20, message="责任人电话长度必须介于 0 和 20 之间")
	public String getLtel() {
		return ltel;
	}

	public void setLtel(String ltel) {
		this.ltel = ltel;
	}	
	
	
}
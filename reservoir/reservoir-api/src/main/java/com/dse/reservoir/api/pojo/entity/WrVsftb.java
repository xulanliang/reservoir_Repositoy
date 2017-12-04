package com.dse.reservoir.api.pojo.entity;

import com.dse.common.entity.base.BaseEntity;
import com.dse.common.enums.DelFlag;
import com.dse.common.enums.Status;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用于记录垂直位置监测信息表(垂直位置监测信息表)数据信息
 * Created by pengzx on 2017/5/26.
 */

@Entity
@Table(name = "WR_VSFT_B")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrVsftb extends BaseEntity {
	private static final long serialVersionUID = 5616137817796769818L;

	@Id
	@Column(name = "STCD")
	private String stcd; // 测点编号

	@Column(name = "TM")
	private Date tm;// 采集时间

	@Column(name = "ORIGDATA")
	private BigDecimal origdata; // 监测值

	@Column(name = "CALCDATA")
	private BigDecimal calcdata; // 监测值

	@Column(name = "JCL")
	private String jcl; // 监测量

	@Column(name = "TRANSST",length = 1 )
	private String transst; // 转换状态

	@Column(name = "OTDESC"  )
	private String otdesc; // 其他

	@Column(name = "GATTYPE"  )
	private String gattype; // 采集方式

	@Column(name = "TS" )
	private Date ts; // 时间戳

	@Column(name = "NT"  )
	private String nt; // 备注

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStcd() {
		return stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}

	public Date getTm() {
		return tm;
	}

	public void setTm(Date tm) {
		this.tm = tm;
	}

	public BigDecimal getCalcdata() {
		return calcdata;
	}

	public void setCalcdata(BigDecimal calcdata) {
		this.calcdata = calcdata;
	}

	public String getTransst() {
		return transst;
	}

	public void setTransst(String transst) {
		this.transst = transst;
	}

	public String getGattype() {
		return gattype;
	}

	public void setGattype(String gattype) {
		this.gattype = gattype;
	}

	public BigDecimal getOrigdata() {
		return origdata;
	}

	public void setOrigdata(BigDecimal origdata) {
		this.origdata = origdata;
	}

	public String getOtdesc() {
		return otdesc;
	}

	public void setOtdesc(String otdesc) {
		this.otdesc = otdesc;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
	}

	public String getNt() {
		return nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

	public String getJcl() {
		return jcl;
	}

	public void setJcl(String jcl) {
		this.jcl = jcl;
	}
}
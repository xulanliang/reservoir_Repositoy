package com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description:文档管理实体
 * @Copyright: Copyright 2016 ShenZhen DSE Software Corporation
 * @Company: 深圳市东深电子股份有限公司
 * @author 刘旭
 * @version 2.0 2016-12-09
 */
 
 
@Entity
@Table(name = "DSE_ZL_MANAGER")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WdglModel implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
//	/** 主键**/
//	private Long did;
//
//	/** 行政区划编码**/
//	private String adcd;
//
//	/** 文档类型: 1水库大坝注册信息、2建筑物安全鉴定、3安全评估、4大事记、5工程资料、6防汛管理、7巡视检查资料 **/
//	private String ttype;
//
//	/** 发文日期**/
//	private Date tm;
//
//	/** 文号**/
//	private String docno;
//
//	/** 标题**/
//	private String doctitle;
//
//	/** 签发人**/
//	private String qhr;
//
//
//
//	public WdglModel() {
//		super();
//	}
//
//
//	@Id
//	@Column(name = "DID" ,  precision = 16, scale = 0   )
//	public Long getDid() {
//		return did;
//	}
//
//	public void setDid(Long did) {
//		this.did = did;
//	}
//	@Column(name = "ADCD" ,  length = 15   )
//	@Length(min=0, max=15, message="行政区划编码长度必须介于 0 和 15 之间")
//	public String getAdcd() {
//		return adcd;
//	}
//
//	public void setAdcd(String adcd) {
//		this.adcd = adcd;
//	}
//	@Column(name = "TTYPE" ,  length = 2   )
//	@Length(min=0, max=2, message="文档类型: 1法律法规、2洪水调度方案、3水库调度规程、4汛情通报、5防汛简报、6传真电报、7防总发文、8防办发文、9会议纪要、10上级批示长度必须介于 0 和 2 之间")
//	public String getTtype() {
//		return ttype;
//	}
//
//	public void setTtype(String ttype) {
//		this.ttype = ttype;
//	}
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "TM" ,  length = 23   )
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	public Date getTm() {
//		return tm;
//	}
//
//	public void setTm(Date tm) {
//		this.tm = tm;
//	}
//	@Column(name = "DOCNO" ,  length = 50   )
//	@Length(min=0, max=50, message="文号长度必须介于 0 和 50 之间")
//	public String getDocno() {
//		return docno;
//	}
//
//	public void setDocno(String docno) {
//		this.docno = docno;
//	}
//	@Column(name = "DOCTITLE" ,  length = 100   )
//	@Length(min=0, max=100, message="标题长度必须介于 0 和 100 之间")
//	public String getDoctitle() {
//		return doctitle;
//	}
//
//	public void setDoctitle(String doctitle) {
//		this.doctitle = doctitle;
//	}
//	@Column(name = "QHR" ,  length = 50   )
//	@Length(min=0, max=50, message="签发人长度必须介于 0 和 50 之间")
//	public String getQhr() {
//		return qhr;
//	}
//
//	public void setQhr(String qhr) {
//		this.qhr = qhr;
//	}
	/** 主键 资料编号**/
	private String INFO_CD;
	/** 标题**/
	private String INFO_TITLE;
	/** 上传时间**/
	private Date UPDATE_DT;
	/** 注册时间/鉴定通过时间/评估通过时间/发生时间**/
	private Date IN_DT;
	/** 1-水库大坝注册，2-建筑物安全鉴定，3-安全评估，4-大事记，5-工程资料，6-防汛管理，7-巡视检查资料
	 **/
	private String INFO_TP;
	/** 上传人 **/
	private String UPDATE_USER;
	/** 备注 **/
	private String NT;
	/** 组织机构代码 **/
	private String ADCD;
	/** 业务ID **/
	private String DID;
	@Id
	@Column(name = "INFO_CD" ,  length = 32   )
	@Length(min=0, max=32, message="资料编号必须介于 0 和 50 之间")
	public String getINFO_CD() {
		return INFO_CD;
	}

	public void setINFO_CD(String INFO_CD) {
		this.INFO_CD = INFO_CD;
	}

	@Column(name = "INFO_TITLE" ,  length = 50   )
	@Length(min=0, max=50, message="标题必须介于 0 和 50 之间")
	public String getINFO_TITLE() {
		return INFO_TITLE;
	}

	public void setINFO_TITLE(String INFO_TITLE) {
		this.INFO_TITLE = INFO_TITLE;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DT" ,  length = 23   )
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUPDATE_DT() {
		return UPDATE_DT;
	}

	public void setUPDATE_DT(Date UPDATE_DT) {
		this.UPDATE_DT = UPDATE_DT;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "IN_DT" ,  length = 23   )
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getIN_DT() {
		return IN_DT;
	}

	public void setIN_DT(Date IN_DT) {
		this.IN_DT = IN_DT;
	}

	@Column(name = "INFO_TP" ,  length = 20   )
	@Length(min=0, max=20, message="文件分类必须介于 0 和 20 之间")
	public String getINFO_TP() {
		return INFO_TP;
	}

	public void setINFO_TP(String INFO_TP) {
		this.INFO_TP = INFO_TP;
	}

	@Column(name = "UPDATE_USER" ,  length = 32   )
	@Length(min=0, max=32, message="上传人必须介于 0 和 32 之间")
	public String getUPDATE_USER() {
		return UPDATE_USER;
	}

	public void setUPDATE_USER(String UPDATE_USER) {
		this.UPDATE_USER = UPDATE_USER;
	}

	@Column(name = "NT" ,  length = 256   )
	@Length(min=0, max=256, message="备注必须介于 0 和 256 之间")
	public String getNT() {
		return NT;
	}

	public void setNT(String NT) {
		this.NT = NT;
	}

	@Column(name = "ADCD" ,  length = 50   )
	@Length(min=0, max=50, message="组织机构代码必须介于 0 和 50 之间")
	public String getADCD() {
		return ADCD;
	}

	public void setADCD(String ADCD) {
		this.ADCD = ADCD;
	}


	@Column(name = "DID" ,  length = 50   )
	public String getDID() {
		return DID;
	}

	public void setDID(String DID) {
		this.DID = DID;
	}
}
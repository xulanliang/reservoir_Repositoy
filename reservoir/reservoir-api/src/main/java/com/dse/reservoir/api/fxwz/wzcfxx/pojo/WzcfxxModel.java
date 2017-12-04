package com.dse.reservoir.api.fxwz.wzcfxx.pojo;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * @Description:实体
 * @Copyright: Copyright 2016 ShenZhen DSE Software Corporation
 * @Company: 深圳市东深电子股份有限公司
 * @author 刘旭
 * @version 2.0 2016-11-15
 */


@Entity
@Table(name = "DSE_SF_WZCF_INFO_b")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WzcfxxModel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    /** 主键**/
    private Long id;

    /** 年份**/
    private Integer year;

    /** 仓库编号ID**/
    private Long ckid;

    /** 物资编号ID**/
    private Long wzid;

    /** 批次**/
    private Long pc;

    /** 物资数量**/
    private Long wznum;

    /** 可用数量**/
    private Long kynum;

    /** 损耗数量**/
    private Long shnum;

    /** 入库签收人员**/
    private String jsrname;

    /** 备注**/
    private String remark;



    public WzcfxxModel() {
        super();
    }


    @Id
    @Column(name = "ID",  nullable = false, precision = 16, scale = 0   )
    @NotNull(message="ID不能为空")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "YEAR")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    @Column(name = "CKID",  nullable = false, precision = 16, scale = 0   )
    public Long getCkid() {
        return ckid;
    }

    public void setCkid(Long ckid) {
        this.ckid = ckid;
    }
    @Column(name = "WZID",  nullable = false, precision = 16, scale = 0   )
    public Long getWzid() {
        return wzid;
    }

    public void setWzid(Long wzid) {
        this.wzid = wzid;
    }
    @Column(name = "PC" ,  precision = 18, scale = 0   )
    public Long getPc() {
        return pc;
    }

    public void setPc(Long pc) {
        this.pc = pc;
    }
    @Column(name = "WZNUM" ,  precision = 10, scale = 0   )
    public Long getWznum() {
        return wznum;
    }

    public void setWznum(Long wznum) {
        this.wznum = wznum;
    }
    @Column(name = "KYNUM" ,  precision = 10, scale = 0   )
    public Long getKynum() {
        return kynum;
    }

    public void setKynum(Long kynum) {
        this.kynum = kynum;
    }
    @Column(name = "SHNUM" ,  precision = 10, scale = 0   )
    public Long getShnum() {
        return shnum;
    }

    public void setShnum(Long shnum) {
        this.shnum = shnum;
    }
    @Column(name = "JSRNAME" ,  length = 50   )
    @Length(min=0, max=50, message="入库签收人员长度必须介于 0 和 50 之间")
    public String getJsrname() {
        return jsrname;
    }

    public void setJsrname(String jsrname) {
        this.jsrname = jsrname;
    }
    @Column(name = "REMARK" ,  length = 200   )
    @Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

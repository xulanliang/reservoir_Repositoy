package com.dse.reservoir.api.sjfx.wrwarningb.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author
 * @version 1.0 2017-08-21
 * @Description:实体 报警信息管理表
 * @Copyright:
 * @Company:
 */
@Entity
@Table(name = "WR_WARNING_B")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrWarningbModel implements java.io.Serializable {

    public WrWarningbModel() {
        super();
    }

    private static final long serialVersionUID = 1L;
    /**
     * 编码
     */
    private String wa_id;
    /**
     * 巡查记录编码
     */
    private String proj_cd;
    private String proj_cd_name;
    /**
     * 巡查点编码
     */
    private String mon_tp;
    private String mon_tp_name;
    /**
     * 巡查内容编码
     */
    private String stcd;
    private String stnm;
    /***
     * 巡查内容描述
     */
    private String wa_dt;

    /***
     * 巡查标准描述
     */
    private String wa_tp;
    private String wa_tp_name;
    /**
     * 问题记录及处理方式
     */
    private Double wa_value;
    /**
     * 序号
     */
    private Double real_value;
    /**
     * 创建时间
     */
    private Double da_value;
    /**
     * 处理状态(0:未开始;   1:进行中 ; 2:已完成)
     */
    private String wa_status;
    private String wa_status_name;
    /**
     * 备注
     */
    private String nt;

    private Date ts;

    private String stm;
    private String etm;

    @Column(name = "DA_VALUE")
    public Double getDa_value() {
        return da_value;
    }

    public void setDa_value(Double da_value) {
        this.da_value = da_value;
    }

    @Column(name = "MON_TP")
    public String getMon_tp() {
        return mon_tp;
    }

    public void setMon_tp(String mon_tp) {
        this.mon_tp = mon_tp;
    }

    @Transient
    public String getMon_tp_name() {
        return mon_tp_name;
    }

    public void setMon_tp_name(String mon_tp_name) {
        this.mon_tp_name = mon_tp_name;
    }

    @Column(name = "NT")
    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    @Column(name = "PROJ_CD")
    public String getProj_cd() {
        return proj_cd;
    }

    public void setProj_cd(String proj_cd) {
        this.proj_cd = proj_cd;
    }

    @Column(name = "REAL_VALUE")
    public Double getReal_value() {
        return real_value;
    }

    public void setReal_value(Double real_value) {
        this.real_value = real_value;
    }

    @Column(name = "STCD")
    public String getStcd() {
        return stcd;
    }

    public void setStcd(String stcd) {
        this.stcd = stcd;
    }

    @Column(name = "TS")
    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    @Column(name = "WA_DT")
    public String getWa_dt() {
        return wa_dt;
    }

    public void setWa_dt(String wa_dt) {
        this.wa_dt = wa_dt;
    }


    @Column(name = "WA_STATUS")
    public String getWa_status() {
        return wa_status;
    }

    public void setWa_status(String wa_status) {
        this.wa_status = wa_status;
    }

    @Transient
    public String getWa_status_name() {
        return wa_status_name;
    }

    public void setWa_status_name(String wa_status_name) {
        this.wa_status_name = wa_status_name;
    }

    @Column(name = "WA_TP")
    public String getWa_tp() {
        return wa_tp;
    }

    public void setWa_tp(String wa_tp) {
        this.wa_tp = wa_tp;
    }

    @Column(name = "WA_VALUE")
    public Double getWa_value() {
        return wa_value;
    }

    public void setWa_value(Double wa_value) {
        this.wa_value = wa_value;
    }

    @Id
    @Column(name = "WA_ID", nullable = false, precision = 32, scale = 0)
    @NotNull(message = "编码不能为空")
    public String getWa_id() {
        return wa_id;
    }

    public void setWa_id(String wa_id) {
        this.wa_id = wa_id;
    }
    @Transient
    public String getStnm() {
        return stnm;
    }

    public void setStnm(String stnm) {
        this.stnm = stnm;
    }

    @Transient
    public String getEtm() {
        return etm;
    }

    public void setEtm(String etm) {
        this.etm = etm;
    }

    @Transient
    public String getStm() {
        return stm;
    }

    public void setStm(String stm) {
        this.stm = stm;
    }

    @Transient
    public String getProj_cd_name() {
        return proj_cd_name;
    }

    public void setProj_cd_name(String proj_cd_name) {
        this.proj_cd_name = proj_cd_name;
    }

    @Transient
    public String getWa_tp_name() {
        return wa_tp_name;
    }

    public void setWa_tp_name(String wa_tp_name) {
        this.wa_tp_name = wa_tp_name;
    }
    //Column(name = "JSRNAME" ,  length = 50   )
    //Length(min=0, max=50, message="入库签收人员长度必须介于 0 和 50 之间")
    //Column(name = "CKID",  nullable = false, precision = 16, scale = 0   )
}

package com.dse.reservoir.tableEdit.Sljcsj.sljcsjDao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yuan_feng on 2017/9/7.
 */
@Entity
@Table(name = "WR_DC_M")
public class DcEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String DC_CD ;
    private String PROJ_CD ;
    private String DC_NM ;
    private String DC_LEAGUE;
    private BigDecimal LEN;
    private BigDecimal PLAN_INS;
    private BigDecimal OPT_INS;
    private BigDecimal BOTTON_WIDTH;
    private BigDecimal NORMAL_DEPTH;
    private BigDecimal OTP_DEPTH;
    private BigDecimal BOTTOM_GC;
    private BigDecimal NORMAL_Z;
    private BigDecimal OTP_Z;
    private BigDecimal NORMAL_FLOW;
    private Date TS;
    private String NT;

    public String getDC_CD() {
        return DC_CD;
    }

    public void setDC_CD(String DC_CD) {
        this.DC_CD= DC_CD;
    }

    public String getPROJ_CD() {
        return PROJ_CD;
    }

    public void setPROJ_CD(String PROJ_CD) {
        this.PROJ_CD = PROJ_CD;
    }

    public String getDC_NM() {
        return DC_NM;
    }

    public void setDC_NM(String DC_NM) {
        this.DC_NM = DC_NM;
    }

    public String getDC_LEAGUE() {
        return DC_LEAGUE;
    }

    public void setDC_LEAGUE(String DC_LEAGUE) {
        this.DC_LEAGUE = DC_LEAGUE;
    }

    public BigDecimal getLEN() {
        return LEN;
    }

    public void setLEN(BigDecimal LEN) {
        this.LEN = LEN;
    }

    public BigDecimal getPLAN_INS() {
        return PLAN_INS;
    }

    public void setPLAN_INS(BigDecimal PLAN_INS) {
        this.PLAN_INS = PLAN_INS;
    }

    public BigDecimal getOPT_INS() {
        return OPT_INS;
    }

    public void setOPT_INS(BigDecimal OPT_INS) {
        this.OPT_INS = OPT_INS;
    }

    public BigDecimal getBOTTON_WIDTH() {
        return BOTTON_WIDTH;
    }

    public void setBOTTON_WIDTH(BigDecimal BOTTON_WIDTH) {
        this.BOTTON_WIDTH = BOTTON_WIDTH;
    }

    public BigDecimal getNORMAL_DEPTH() {
        return NORMAL_DEPTH;
    }

    public void setNORMAL_DEPTH(BigDecimal NORMAL_DEPTH) {
        this.NORMAL_DEPTH = NORMAL_DEPTH;
    }

    public BigDecimal getOTP_DEPTH() {
        return OTP_DEPTH;
    }

    public void setOTP_DEPTH(BigDecimal OTP_DEPTH) {
        this.OTP_DEPTH = OTP_DEPTH;
    }

    public BigDecimal getBOTTOM_GC() {
        return BOTTOM_GC;
    }

    public void setBOTTOM_GC(BigDecimal BOTTOM_GC) {
        this.BOTTOM_GC = BOTTOM_GC;
    }

    public BigDecimal getNORMAL_Z() {
        return NORMAL_Z;
    }

    public void setNORMAL_Z(BigDecimal NORMAL_Z) {
        this.NORMAL_Z = NORMAL_Z;
    }

    public BigDecimal getOTP_Z() {
        return OTP_Z;
    }

    public void setOTP_Z(BigDecimal OTP_Z) {
        this.OTP_Z = OTP_Z;
    }

    public BigDecimal getNORMAL_FLOW() {
        return NORMAL_FLOW;
    }

    public void setNORMAL_FLOW(BigDecimal NORMAL_FLOW) {
        this.NORMAL_FLOW = NORMAL_FLOW;
    }
    public String getNT() {
        return NT;
    }

    public void setNT(String NT) {
        this.NT = NT;
    }

    public Date getTS() {
        return TS;
    }

    public void setTS(Date TS) {
        this.TS = TS;
    }
}

package com.dse.reservoir.tableEdit.cdgclx.dao.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by yuan_feng on 2017/8/31.
 */
@Entity
@Table(name = "WR_HG_M")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class HgEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String  HG_CD;//              VARCHAR2(16)         not null,
    private String  PROJ_CD ; //            VARCHAR2(16),
    private String  HG_NM;//                VARCHAR2(100),
    private BigDecimal IN_GC;//                NUMBER(6,3),
    private BigDecimal OUT_GC;//               NUMBER(6,3),
    private String HG_DESC;//                   VARCHAR2(100),
    private BigDecimal IN__DIAM;//                  NUMBER(6,3),
    private BigDecimal PLAN_INS;//                  NUMBER(6,2),
    private BigDecimal  PLAN_PRESS;//                NUMBER(8,2),
    private Date TS;//                          DATE,
    private String NT;//                        VARCHAR2(256),
    @Id
    @Column(name = "HG_CD",  nullable = false, length =  16)
    @Length(min = 0,max = 16)
    public String getHG_CD() {
        return HG_CD;
    }
    public void setHG_CD(String HG_CD) {
        this.HG_CD = HG_CD;
    }

    @Column(name ="PROJ_CD", length = 50)
    public String getPROJ_CD() {
        return PROJ_CD;
    }
    public void setPROJ_CD(String PROJ_CD) {
        this.PROJ_CD = PROJ_CD;
    }

    @Column(name ="HG_NM", length = 50)
    public String getHG_NM() {
        return HG_NM;
    }
    public void setHG_NM(String HG_NM) {
        this.HG_NM = HG_NM;
    }

    @Column(name ="IN_GC", length = 50)
    public BigDecimal getIN_GC() {
        return IN_GC;
    }
    public void setIN_GC(BigDecimal IN_GC) {
        this.IN_GC = IN_GC;
    }

    @Column(name ="OUT_GC")
    public BigDecimal getOUT_GC() {
        return OUT_GC;
    }
    public void setOUT_GC(BigDecimal OUT_GC) {
        this.OUT_GC = OUT_GC;
    }

    @Column(name ="HG_DESC")
    public String getHG_DESC() {
        return HG_DESC;
    }
    public void setHG_DESC(String HG_DESC) {
        this.HG_DESC = HG_DESC;
    }

    @Column(name ="IN__DIAM")
    public BigDecimal getIN__DIAM() {
        return IN__DIAM;
    }
    public void setIN__DIAM(BigDecimal IN__DIAM) {
        this.IN__DIAM = IN__DIAM;
    }

    @Column(name ="PLAN_INS")
    public BigDecimal getPLAN_INS() {
        return PLAN_INS;
    }
    public void setPLAN_INS(BigDecimal PLAN_INS) {
        this.PLAN_INS = PLAN_INS;
    }

    @Column(name ="PLAN_PRESS")
    public BigDecimal getPLAN_PRESS() {
        return PLAN_PRESS;
    }
    public void setPLAN_PRESS(BigDecimal PLAN_PRESS) {
        this.PLAN_PRESS = PLAN_PRESS;
    }

    @Column(name ="TS")
    public Date getTS() {
        return TS;
    }
    public void setTS(Date TS) {
        this.TS = TS;
    }

    @Column(name ="NT", length = 256)
    public String getNT() {
        return NT;
    }
    public void setNT(String NT) {
        this.NT = NT;
    }
}

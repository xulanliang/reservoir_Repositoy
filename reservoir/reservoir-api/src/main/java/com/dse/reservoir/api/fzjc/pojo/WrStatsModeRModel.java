package com.dse.reservoir.api.fzjc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 渗压测点统计模型回归参数
 *
 * @author wangzy
 * @date 2017-10-28
 */
@Entity
@Table(name = "WR_STATS_MODE_R")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrStatsModeRModel implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String ID;
    private String PROJ_CD;
    private String ST_TP;
    private String STCD;
    private String STNM;
    private Double B0;
    private Double X1;
    private Double X2;
    private Double X3;
    private Double X4;
    private Double X5;
    private Double X6;
    private Double X7;
    private Double X8;
    private Double X9;
    private Double X10;
    private Double X11;
    private Double X12;
    private Double X13;
    private Double X14;
    private Double X15;
    private Double X16;
    private Double X17;
    private Double X18;
    private Date TS;

    @Id
    @Column(name = "ID", nullable = false, length = 32)
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Column(name = "PROJ_CD",length = 32)
    public String getPROJ_CD() {
        return PROJ_CD;
    }

    public void setPROJ_CD(String PROJ_CD) {
        this.PROJ_CD = PROJ_CD;
    }

    @Column(name = "ST_TP",length = 32)
    public String getST_TP() {
        return ST_TP;
    }

    public void setST_TP(String ST_TP) {
        this.ST_TP = ST_TP;
    }

    @Column(name = "STCD",length = 32)
    public String getSTCD() {
        return STCD;
    }

    public void setSTCD(String STCD) {
        this.STCD = STCD;
    }

    @Column(name = "STNM",length = 32)
    public String getSTNM() {
        return STNM;
    }

    public void setSTNM(String STNM) {
        this.STNM = STNM;
    }

    @Column(name = "B0",length = 12,precision = 5)
    public Double getB0() {
        return B0;
    }

    public void setB0(Double b0) {
        B0 = b0;
    }

    @Column(name = "X1",length = 12,precision = 5)
    public Double getX1() {
        return X1;
    }

    public void setX1(Double x1) {
        X1 = x1;
    }

    @Column(name = "X2",length = 12,precision = 5)
    public Double getX2() {
        return X2;
    }

    public void setX2(Double x2) {
        X2 = x2;
    }
    @Column(name = "X3",length = 12,precision = 5)
    public Double getX3() {
        return X3;
    }

    public void setX3(Double x3) {
        X3 = x3;
    }
    @Column(name = "X4",length = 12,precision = 5)
    public Double getX4() {
        return X4;
    }

    public void setX4(Double x4) {
        X4 = x4;
    }
    @Column(name = "X5",length = 12,precision = 5)
    public Double getX5() {
        return X5;
    }

    public void setX5(Double x5) {
        X5 = x5;
    }
    @Column(name = "X6",length = 12,precision = 5)
    public Double getX6() {
        return X6;
    }

    public void setX6(Double x6) {
        X6 = x6;
    }
    @Column(name = "X7",length = 12,precision = 5)
    public Double getX7() {
        return X7;
    }

    public void setX7(Double x7) {
        X7 = x7;
    }

    @Column(name = "X8",length = 12,precision = 5)
    public Double getX8() {
        return X8;
    }

    public void setX8(Double x8) {
        X8 = x8;
    }

    @Column(name = "X9",length = 12,precision = 5)
    public Double getX9() {
        return X9;
    }


    public void setX9(Double x9) {
        X9 = x9;
    }
    @Column(name = "X10",length = 12,precision = 5)
    public Double getX10() {
        return X10;
    }

    public void setX10(Double x10) {
        X10 = x10;
    }
    @Column(name = "X11",length = 12,precision = 5)
    public Double getX11() {
        return X11;
    }

    public void setX11(Double x11) {
        X11 = x11;
    }
    @Column(name = "X12",length = 12,precision = 5)
    public Double getX12() {
        return X12;
    }

    public void setX12(Double x12) {
        X12 = x12;
    }
    @Column(name = "X13",length = 12,precision = 5)
    public Double getX13() {
        return X13;
    }

    public void setX13(Double x13) {
        X13 = x13;
    }

    @Column(name = "X14",length = 12,precision = 5)
    public Double getX14() {
        return X14;
    }

    public void setX14(Double x14) {
        X14 = x14;
    }
    @Column(name = "X15",length = 12,precision = 5)
    public Double getX15() {
        return X15;
    }

    public void setX15(Double x15) {
        X15 = x15;
    }

    @Column(name = "X16",length = 12,precision = 5)
    public Double getX16() {
        return X16;
    }

    public void setX16(Double x16) {
        X16 = x16;
    }

    @Column(name = "X17",length = 12,precision = 5)
    public Double getX17() {
        return X17;
    }

    public void setX17(Double x17) {
        X17 = x17;
    }

    @Column(name = "X18",length = 12,precision = 5)
    public Double getX18() {
        return X18;
    }

    public void setX18(Double x18) {
        X18 = x18;
    }

    @Column(name = "TS")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTS() {
        return TS;
    }

    public void setTS(Date TS) {
        this.TS = TS;
    }
}

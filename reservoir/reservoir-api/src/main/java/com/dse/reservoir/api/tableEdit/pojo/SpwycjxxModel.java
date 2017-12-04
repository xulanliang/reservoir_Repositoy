package com.dse.reservoir.api.tableEdit.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by dse on 2017/8/8.
 */
@Entity
@Table(name = "WR_HSFT_B")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SpwycjxxModel implements Serializable {
    private static final Long serialVersionUID=1L;

    @EmbeddedId
    private SpwycjxxPK id;      //主键id

    private Double DS;      //度数
    private Double JDS;      //（观测值：度数）校验值
    private Double FS;      //（观测值：分数）
    private Double JFS;      //（观测值：分数）校验值
    private Double HS;      //（观测值：毫数）
    private Double JHS;      //（观测值：毫数）校验值
    private Double LDVALUE;      //差值（与上期比较）
    private Double LSHIFT;      //位移mm（与上期比较）
    private Double FDVALUE;      //差值（与首期比较）
    private Double FSHIFT;      //位移mm（与首期比较）
    private Double XSHIFT;      //X（m）
    private Double JXSHIFT;      //X（m）(校正)
    private Double YSHIFT;      //Y（m）
    private Double JYSHIFT;      //Y（m）（校正）
    private Double RSHIFT;      //径向偏移值
    private Double TSHIFT;      //本次位移（mm）
    private Double CSHIFT;      //累计位移（mm）
    private Double LDXSHIFT;      //DX(mm)(与上期比较)
    private Double LDYSHIFT;      //DY(mm)(与上期比较)
    private Double LDSSHIFT;      //DS(mm)(与上期比较)
    private Double FDXSHIFT;      //DX(mm)(与首期比较)
    private Double FDYSHIFT;      //DY(mm)(与首期比较)
    private Double FDSSHIFT;      //DS(mm)(与首期比较)
    private String NT;      //备注
    private String TYPE;      //类型(1:深圳水库主副坝水平位移,2:,3:)

    @Column(name = "LDYSHIFT")
    public Double getLDYSHIFT() {
        return LDYSHIFT;
    }

    public void setLDYSHIFT(Double LDYSHIFT) {
        this.LDYSHIFT = LDYSHIFT;
    }

    @Column(name = "LDSSHIFT")
    public Double getLDSSHIFT() {
        return LDSSHIFT;
    }

    public void setLDSSHIFT(Double LDSSHIFT) {
        this.LDSSHIFT = LDSSHIFT;
    }

    @Column(name = "FDXSHIFT")
    public Double getFDXSHIFT() {
        return FDXSHIFT;
    }

    public void setFDXSHIFT(Double FDXSHIFT) {
        this.FDXSHIFT = FDXSHIFT;
    }

    @Column(name = "FDYSHIFT")
    public Double getFDYSHIFT() {
        return FDYSHIFT;
    }

    public void setFDYSHIFT(Double FDYSHIFT) {
        this.FDYSHIFT = FDYSHIFT;
    }

    @Column(name = "FDSSHIFT")
    public Double getFDSSHIFT() {
        return FDSSHIFT;
    }

    public void setFDSSHIFT(Double FDSSHIFT) {
        this.FDSSHIFT = FDSSHIFT;
    }

    @Column(name = "NT",length = 200)
    @Length(min = 0,max = 200,message = "备注的长度只能在 0 至 200 之间")
    public String getNT() {
        return NT;
    }

    public void setNT(String NT) {
        this.NT = NT;
    }

    @Column(name = "TYPE",length = 1)
    @Length(min = 0,max = 1,message = "类型的长度只能在 0 至 1 之间")
    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public SpwycjxxPK getId() {
        return id;
    }

    public void setId(SpwycjxxPK id) {
        this.id = id;
    }

    @Column(name = "DS")
    public Double getDS() {
        return DS;
    }

    public void setDS(Double DS) {
        this.DS = DS;
    }

    @Column(name = "JDS")
    public Double getJDS() {
        return JDS;
    }

    public void setJDS(Double JDS) {
        this.JDS = JDS;
    }

    @Column(name = "FS")
    public Double getFS() {
        return FS;
    }

    public void setFS(Double FS) {
        this.FS = FS;
    }

    @Column(name = "JFS")
    public Double getJFS() {
        return JFS;
    }

    public void setJFS(Double JFS) {
        this.JFS = JFS;
    }

    @Column(name = "HS")
    public Double getHS() {
        return HS;
    }

    public void setHS(Double HS) {
        this.HS = HS;
    }

    @Column(name = "JHS")
    public Double getJHS() {
        return JHS;
    }

    public void setJHS(Double JHS) {
        this.JHS = JHS;
    }

    @Column(name = "LDVALUE")
    public Double getLDVALUE() {
        return LDVALUE;
    }

    public void setLDVALUE(Double LDVALUE) {
        this.LDVALUE = LDVALUE;
    }

    @Column(name = "LSHIFT")
    public Double getLSHIFT() {
        return LSHIFT;
    }

    public void setLSHIFT(Double LSHIFT) {
        this.LSHIFT = LSHIFT;
    }

    @Column(name = "FDVALUE")
    public Double getFDVALUE() {
        return FDVALUE;
    }

    public void setFDVALUE(Double FDVALUE) {
        this.FDVALUE = FDVALUE;
    }

    @Column(name = "FSHIFT")
    public Double getFSHIFT() {
        return FSHIFT;
    }

    public void setFSHIFT(Double FSHIFT) {
        this.FSHIFT = FSHIFT;
    }

    @Column(name = "XSHIFT")
    public Double getXSHIFT() {
        return XSHIFT;
    }

    public void setXSHIFT(Double XSHIFT) {
        this.XSHIFT = XSHIFT;
    }

    @Column(name = "JXSHIFT")
    public Double getJXSHIFT() {
        return JXSHIFT;
    }

    public void setJXSHIFT(Double JXSHIFT) {
        this.JXSHIFT = JXSHIFT;
    }

    @Column(name = "YSHIFT")
    public Double getYSHIFT() {
        return YSHIFT;
    }

    public void setYSHIFT(Double YSHIFT) {
        this.YSHIFT = YSHIFT;
    }

    @Column(name = "JYSHIFT")
    public Double getJYSHIFT() {
        return JYSHIFT;
    }

    public void setJYSHIFT(Double JYSHIFT) {
        this.JYSHIFT = JYSHIFT;
    }

    @Column(name = "RSHIFT")
    public Double getRSHIFT() {
        return RSHIFT;
    }

    public void setRSHIFT(Double RSHIFT) {
        this.RSHIFT = RSHIFT;
    }

    @Column(name = "TSHIFT")
    public Double getTSHIFT() {
        return TSHIFT;
    }

    public void setTSHIFT(Double TSHIFT) {
        this.TSHIFT = TSHIFT;
    }

    @Column(name = "CSHIFT")
    public Double getCSHIFT() {
        return CSHIFT;
    }

    public void setCSHIFT(Double CSHIFT) {
        this.CSHIFT = CSHIFT;
    }

    @Column(name = "LDXSHIFT")
    public Double getLDXSHIFT() {
        return LDXSHIFT;
    }

    public void setLDXSHIFT(Double LDXSHIFT) {
        this.LDXSHIFT = LDXSHIFT;
    }
}
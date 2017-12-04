package com.dse.reservoir.api.tableEdit.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dse on 2017/8/9.
 */
@Entity
@Table(name = "WR_STAT_M")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CdjcxxbModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String STCD;    //测点编码
    private String STNM;    //测点名称
    private String MDCD;    //模块编码(监测站/MCU/DAU/NDA)编码
    private String PROJ_CD;    //工程编码
    private Double LGTD;    //经度
    private Double LTTD;    //纬度
    private Double HEAD_GC;    //管口高度
    private Double BOTTOM_GC;    //管底高度
    private String ST_TP;    //测点类型(1:渗压 2 渗流 3 水平位移4垂直位移5水位6雨量7气温<含气压>8深层位移9渡槽沉降)
    private Double WEIR_WIDTH;    //堰口宽度
    private Double WEIR_LENGTH;    //堰口至堰槽底距离
    private String WEIR_SIZE;    //堰槽尺寸
    private String DISPLACE_TP;    //位移类型
    private Double INITIAL_VALUE;    //始测读数
    private String NT;    //备注
    private Date TS;    //时间戳
    private String ONMEA;    //测点测量状态，0 停测  1 测量 2 待修理 3 报废
    private String TYPEID;    //监测方式，0 自动 1人工
    private String ISJIDIAN;    //是否基点,1：基点，0：测点，展示数据一般只展示测点数据

    @Id
    @Column(name = "STCD",length = 32)
    @Length(min = 0,max = 32,message = "测点编号长度只能在 0 至 32 之间")
    public String getSTCD() {
        return STCD;
    }

    public void setSTCD(String STCD) {
        this.STCD = STCD;
    }

    @Column(name = "STNM",length = 100)
    @Length(min = 0,max = 100,message = "测点名称长度只能在 0 至 100 之间")
    public String getSTNM() {
        return STNM;
    }

    public void setSTNM(String STNM) {
        this.STNM = STNM;
    }

    @Column(name = "MDCD",length = 32)
    @Length(min = 0,max = 32,message = "模块编码长度只能在 0 至 32 之间")
    public String getMDCD() {
        return MDCD;
    }

    public void setMDCD(String MDCD) {
        this.MDCD = MDCD;
    }

    @Column(name = "PROJ_CD",length = 16)
    @Length(min = 0,max = 16,message = "工程编码长度只能在 0 至 16 之间")
    public String getPROJ_CD() {
        return PROJ_CD;
    }

    public void setPROJ_CD(String PROJ_CD) {
        this.PROJ_CD = PROJ_CD;
    }

    @Column(name = "LGTD")
    public Double getLGTD() {
        return LGTD;
    }

    public void setLGTD(Double LGTD) {
        this.LGTD = LGTD;
    }

    @Column(name = "LTTD")
    public Double getLTTD() {
        return LTTD;
    }

    public void setLTTD(Double LTTD) {
        this.LTTD = LTTD;
    }

    @Column(name = "HEAD_GC")
    public Double getHEAD_GC() {
        return HEAD_GC;
    }

    public void setHEAD_GC(Double HEAD_GC) {
        this.HEAD_GC = HEAD_GC;
    }

    @Column(name = "BOTTOM_GC")
    public Double getBOTTOM_GC() {
        return BOTTOM_GC;
    }

    public void setBOTTOM_GC(Double BOTTOM_GC) {
        this.BOTTOM_GC = BOTTOM_GC;
    }

    @Column(name = "ST_TP",length = 1)
    @Length(min = 0,max = 1,message = "测点类型长度只能在 0 至 1 之间")
    public String getST_TP() {
        return ST_TP;
    }

    public void setST_TP(String ST_TP) {
        this.ST_TP = ST_TP;
    }

    @Column(name = "WEIR_WIDTH")
    public Double getWEIR_WIDTH() {
        return WEIR_WIDTH;
    }

    public void setWEIR_WIDTH(Double WEIR_WIDTH) {
        this.WEIR_WIDTH = WEIR_WIDTH;
    }

    @Column(name = "WEIR_LENGTH")
    public Double getWEIR_LENGTH() {
        return WEIR_LENGTH;
    }

    public void setWEIR_LENGTH(Double WEIR_LENGTH) {
        this.WEIR_LENGTH = WEIR_LENGTH;
    }

    @Column(name = "WEIR_SIZE",length = 100)
    @Length(min = 0,max = 100,message = "堰槽尺寸长度只能在 0 至 100 之间")
    public String getWEIR_SIZE() {
        return WEIR_SIZE;
    }

    public void setWEIR_SIZE(String WEIR_SIZE) {
        this.WEIR_SIZE = WEIR_SIZE;
    }

    @Column(name = "DISPLACE_TP",length = 1)
    @Length(min = 0,max = 1,message = "位移类型长度只能在 0 至 1 之间")
    public String getDISPLACE_TP() {
        return DISPLACE_TP;
    }

    public void setDISPLACE_TP(String DISPLACE_TP) {
        this.DISPLACE_TP = DISPLACE_TP;
    }

    @Column(name = "INITIAL_VALUE")
    public Double getINITIAL_VALUE() {
        return INITIAL_VALUE;
    }

    public void setINITIAL_VALUE(Double INITIAL_VALUE) {
        this.INITIAL_VALUE = INITIAL_VALUE;
    }

    @Column(name = "NT",length = 256)
    @Length(min = 0,max = 256,message = "备注长度只能在 0 至 256 之间")
    public String getNT() {
        return NT;
    }

    public void setNT(String NT) {
        this.NT = NT;
    }

    @Column(name = "TS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTS() {
        return TS;
    }

    public void setTS(Date TS) {
        this.TS = TS;
    }

    @Column(name = "ONMEA",length = 1)
    @Length(min = 0,max = 1,message = "测点测量状态长度只能在 0 至 1 之间")
    public String getONMEA() {
        return ONMEA;
    }

    public void setONMEA(String ONMEA) {
        this.ONMEA = ONMEA;
    }

    @Column(name = "TYPEID",length = 1)
    @Length(min = 0,max = 1,message = "监测方式长度只能在 0 至 1 之间")
    public String getTYPEID() {
        return TYPEID;
    }

    public void setTYPEID(String TYPEID) {
        this.TYPEID = TYPEID;
    }

    @Column(name = "ISJIDIAN",length = 1)
    @Length(min = 0,max = 1,message = "是否基点长度只能在 0 至 1 之间")
    public String getISJIDIAN() {
        return ISJIDIAN;
    }

    public void setISJIDIAN(String ISJIDIAN) {
        this.ISJIDIAN = ISJIDIAN;
    }
}

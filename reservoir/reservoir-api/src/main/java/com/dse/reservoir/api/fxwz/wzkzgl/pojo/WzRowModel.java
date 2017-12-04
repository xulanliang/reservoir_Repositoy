package com.dse.reservoir.api.fxwz.wzkzgl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 *  出入库行（物资）表
 * Created by dse on 2017/8/30.
 */
@Entity
@Table(name = "WR_INOUT_STOCK_LINE")
public class WzRowModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ID;      //出入库行编号
    private Integer SEQ;      //序号，按行增加如1,2,3.4
    private String WH_CD;      //仓库编码
    private String MA_CD;      //物资编码
    private String MA_PC;      //物资批次
    private String BINNUM;      //货柜
    private String IN_OUT;      //出入库类型(0:出库,1:入库)
    private Date INOUT_DATE;      //出入库时间
    private Double INOUT_QUAN;      //入库数量
    private String INPUT_USER;      //登记人
    private String OUT_USEFOR;      //出库用途
    private Date TS;      //创建时间
    private String NT;      //备注
    private Double REAL_QUAN;      //实际发放数量
    private String WR_INOUT_ID;      //出入库登记表编号(外键，出入库登记表)

    @Id
    @Column(name = "ID",length = 32)
    @Length(min = 0,max = 32,message = "编码长度只能在 0 至 32 之间")
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Column(name = "SEQ")
    public Integer getSEQ() {
        return SEQ;
    }

    public void setSEQ(Integer SEQ) {
        this.SEQ = SEQ;
    }

    @Column(name = "WH_CD",length = 32)
    @Length(min = 0,max = 32,message = "仓库编码长度只能在 0 至 32 之间")
    public String getWH_CD() {
        return WH_CD;
    }

    public void setWH_CD(String WH_CD) {
        this.WH_CD = WH_CD;
    }

    @Column(name = "MA_CD",length = 32)
    @Length(min = 0,max = 32,message = "物资编码长度只能在 0 至 32 之间")
    public String getMA_CD() {
        return MA_CD;
    }

    public void setMA_CD(String MA_CD) {
        this.MA_CD = MA_CD;
    }

    @Column(name = "MA_PC",length = 32)
    @Length(min = 0,max = 32,message = "物资批次长度只能在 0 至 32 之间")
    public String getMA_PC() {
        return MA_PC;
    }

    public void setMA_PC(String MA_PC) {
        this.MA_PC = MA_PC;
    }

    @Column(name = "BINNUM",length = 200)
    @Length(min = 0,max = 200,message = "货柜长度只能在 0 至 200 之间")
    public String getBINNUM() {
        return BINNUM;
    }

    public void setBINNUM(String BINNUM) {
        this.BINNUM = BINNUM;
    }

    @Column(name = "IN_OUT",length = 1)
    @Length(min = 0,max = 1,message = "状态长度只能在 0 至 1 之间")
    public String getIN_OUT() {
        return IN_OUT;
    }

    public void setIN_OUT(String IN_OUT) {
        this.IN_OUT = IN_OUT;
    }

    @Column(name = "INOUT_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getINOUT_DATE() {
        return INOUT_DATE;
    }

    public void setINOUT_DATE(Date INOUT_DATE) {
        this.INOUT_DATE = INOUT_DATE;
    }

    @Column(name = "INOUT_QUAN")
    public Double getINOUT_QUAN() {
        return INOUT_QUAN;
    }

    public void setINOUT_QUAN(Double INOUT_QUAN) {
        this.INOUT_QUAN = INOUT_QUAN;
    }

    @Column(name = "INPUT_USER",length = 32)
    @Length(min = 0,max = 32,message = "登记人长度只能在 0 至 32 之间")
    public String getINPUT_USER() {
        return INPUT_USER;
    }

    public void setINPUT_USER(String INPUT_USER) {
        this.INPUT_USER = INPUT_USER;
    }

    @Column(name = "OUT_USEFOR",length = 100)
    @Length(min = 0,max = 100,message = "出库用途长度只能在 0 至 100 之间")
    public String getOUT_USEFOR() {
        return OUT_USEFOR;
    }

    public void setOUT_USEFOR(String OUT_USEFOR) {
        this.OUT_USEFOR = OUT_USEFOR;
    }

    @Column(name = "TS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTS() {
        return TS;
    }

    public void setTS(Date TS) {
        this.TS = TS;
    }

    @Column(name = "NT",length = 256)
    @Length(min = 0,max = 256,message = "备注长度只能在 0 至 256 之间")
    public String getNT() {
        return NT;
    }

    public void setNT(String NT) {
        this.NT = NT;
    }

    @Column(name = "REAL_QUAN")
    public Double getREAL_QUAN() {
        return REAL_QUAN;
    }

    public void setREAL_QUAN(Double REAL_QUAN) {
        this.REAL_QUAN = REAL_QUAN;
    }

    @Column(name = "WR_INOUT_ID",length = 32)
    @Length(min = 0,max = 32,message = "出入库登记表编号长度只能在 0 至 32 之间")
    public String getWR_INOUT_ID() {
        return WR_INOUT_ID;
    }

    public void setWR_INOUT_ID(String WR_INOUT_ID) {
        this.WR_INOUT_ID = WR_INOUT_ID;
    }
}

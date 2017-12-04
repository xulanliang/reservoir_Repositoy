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
 *  出入库登记表
 * Created by dse on 2017/8/30.
 */
@Entity
@Table(name = "WR_INOUT_STOCK_E")
public class CrkjlModel implements Serializable {
    private static final long serialVersionUID = 1L;

    String ID;      //编号
    String OUT_USEFOR;      //出入库描述
    String IN_OUT;      //出入库类型(0:出库,1:入库)
    Date INOUT_DATE;      //出入库时间
    String  INPUT_USER;      //登记人
    String  BACK_USER;      //归还人
    String  OUT_USER;      //领用人
    String  CHECK_USER;      //批准人
    Date  CHECK_TIME;      //批准时间
    Date  TS;      //创建时间
    String  NT;      //备注
    String  STATUS;      //出入库状态(0:创建，1:审批中，2:待收发料，3:已完成,4:取消)

    @Id
    @Column(name = "ID",length = 32)
    @Length(min = 0,max = 32,message = "ID长度只能在 0 至 32 之间")
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Column(name = "OUT_USEFOR",length = 100)
    @Length(min = 0,max = 100,message = "出入库描述长度只能在 0 至 100 之间")
    public String getOUT_USEFOR() {
        return OUT_USEFOR;
    }

    public void setOUT_USEFOR(String OUT_USEFOR) {
        this.OUT_USEFOR = OUT_USEFOR;
    }

    @Column(name = "IN_OUT",length = 1)
    @Length(min = 0,max = 1,message = "出入库类型长度只能在 0 至 1 之间")
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

    @Column(name = "INPUT_USER",length = 32)
    @Length(min = 0,max = 32,message = "登记人长度只能在 0 至 1 之间")
    public String getINPUT_USER() {
        return INPUT_USER;
    }

    public void setINPUT_USER(String INPUT_USER) {
        this.INPUT_USER = INPUT_USER;
    }

    @Column(name = "BACK_USER",length = 32)
    @Length(min = 0,max = 32,message = "归还人长度只能在 0 至 1 之间")
    public String getBACK_USER() {
        return BACK_USER;
    }

    public void setBACK_USER(String BACK_USER) {
        this.BACK_USER = BACK_USER;
    }

    @Column(name = "OUT_USER",length = 32)
    @Length(min = 0,max = 32,message = "领用人长度只能在 0 至 1 之间")
    public String getOUT_USER() {
        return OUT_USER;
    }

    public void setOUT_USER(String OUT_USER) {
        this.OUT_USER = OUT_USER;
    }

    @Column(name = "CHECK_USER",length = 32)
    @Length(min = 0,max = 32,message = "批准人长度只能在 0 至 1 之间")
    public String getCHECK_USER() {
        return CHECK_USER;
    }

    public void setCHECK_USER(String CHECK_USER) {
        this.CHECK_USER = CHECK_USER;
    }

    @Column(name = "CHECK_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCHECK_TIME() {
        return CHECK_TIME;
    }

    public void setCHECK_TIME(Date CHECK_TIME) {
        this.CHECK_TIME = CHECK_TIME;
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

    @Column(name = "STATUS",length = 1)
    @Length(min = 0,max = 1,message = "出入库状态长度只能在 0 至 1 之间")
    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}

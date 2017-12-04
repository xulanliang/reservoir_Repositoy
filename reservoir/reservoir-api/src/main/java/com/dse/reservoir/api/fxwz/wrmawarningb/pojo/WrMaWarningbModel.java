package com.dse.reservoir.api.fxwz.wrmawarningb.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author
 * @version 1.0 2017-09-04
 * @Description:实体 物资报警信息管理表
 * @Copyright:
 * @Company:
 */
@Entity
@Table(name = "WR_MA_WARNING_B")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrMaWarningbModel implements java.io.Serializable {

    public WrMaWarningbModel() {
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
    private String org_cd;
    /**
     *
     */
    private String wh_cd;

    private String ma_cd;
    /***
     *
     */
    private Date wa_dt;
    /***
     *
     */
    private String wa_tp;
    /**
     * 问题记录及处理方式
     */
    private String wa_value;
    /**
     * 序号
     */
    private String real_value;
    /**
     * 创建时间
     */
    private String da_value;
    /**
     * 处理状态(0:未开始;   1:进行中 ; 2:已完成)
     */
    private String wa_status;

    /**
     * 备注
     */
    private String nt;

    private Date ts;



    @Column(name = "DA_VALUE")
    public String getDa_value() {
        return da_value;
    }

    public void setDa_value(String da_value) {
        this.da_value = da_value;
    }
    @Column(name = "REAL_VALUE")
    public String getReal_value() {
        return real_value;
    }

    public void setReal_value(String real_value) {
        this.real_value = real_value;
    }
    @Column(name = "WA_VALUE")
    public String getWa_value() {
        return wa_value;
    }

    public void setWa_value(String wa_value) {
        this.wa_value = wa_value;
    }

    @Column(name = "NT")
    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    @Column(name = "TS")
    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }


    @Column(name = "WA_STATUS")
    public String getWa_status() {
        return wa_status;
    }

    public void setWa_status(String wa_status) {
        this.wa_status = wa_status;
    }


    @Column(name = "WA_TP")
    public String getWa_tp() {
        return wa_tp;
    }

    public void setWa_tp(String wa_tp) {
        this.wa_tp = wa_tp;
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

    @Column(name = "MA_CD")
    public String getMa_cd() {
        return ma_cd;
    }

    public void setMa_cd(String ma_cd) {
        this.ma_cd = ma_cd;
    }
    @Column(name = "ORG_CD")
    public String getOrg_cd() {
        return org_cd;
    }

    public void setOrg_cd(String org_cd) {
        this.org_cd = org_cd;
    }
    @Column(name = "WA_DT")
    public Date getWa_dt() {
        return wa_dt;
    }

    public void setWa_dt(Date wa_dt) {
        this.wa_dt = wa_dt;
    }
    @Column(name = "WH_CD")
    public String getWh_cd() {
        return wh_cd;
    }

    public void setWh_cd(String wh_cd) {
        this.wh_cd = wh_cd;
    }


//Column(name = "JSRNAME" ,  length = 50   )
    //Length(min=0, max=50, message="入库签收人员长度必须介于 0 和 50 之间")
    //Column(name = "CKID",  nullable = false, precision = 16, scale = 0   )
}

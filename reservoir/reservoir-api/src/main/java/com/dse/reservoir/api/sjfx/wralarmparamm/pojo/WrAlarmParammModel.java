package com.dse.reservoir.api.sjfx.wralarmparamm.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author
 * @version 1.0 2017-08-21
 * @Description:实体 报警阈值信息表
 * @Copyright:
 * @Company:
 */
@Entity
@Table(name = "WR_ALARM_PARAM_M")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrAlarmParammModel implements java.io.Serializable {

    public WrAlarmParammModel() {
        super();
    }

    private static final long serialVersionUID = 1L;
    /**
     * 编码
     */
    private String id;
    /**
     * 工程编号
     */
    private String proj_cd;
    private String proj_cd_name;
    /**
     * 测点编号
     */
    private String stcd;
    private String stnm;
    /**
     * 监测类型
     */
    private String mon_tp;
    private String mon_tp_name;
    /**
     * 历史最大值
     */
    private Double max_value;
    /***
     * 变幅
     */
    private Double cg_value;
    /***
     * 绝对值
     */
    private Double obs_value;

    /**
     * 创建时间
     */
    private Date ts;

    /**
     * 备注
     */
    private String nt;


    @Id
    @Column(name = "ID", nullable = false, precision = 32, scale = 0)
    @NotNull(message = "编码不能为空")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "PROJ_CD")
    public String getProj_cd() {
        return proj_cd;
    }

    public void setProj_cd(String proj_cd) {
        this.proj_cd = proj_cd;
    }

    @Column(name = "STCD")
    public String getStcd() {
        return stcd;
    }

    public void setStcd(String stcd) {
        this.stcd = stcd;
    }

    @Column(name = "MAX_VALUE")
    public Double getMax_value() {
        return max_value;
    }

    public void setMax_value(Double max_value) {
        this.max_value = max_value;
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

    @Column(name = "OBS_VALUE")
    public Double getObs_value() {
        return obs_value;
    }

    public void setObs_value(Double obs_value) {
        this.obs_value = obs_value;
    }

    @Column(name = "CG_VALUE")
    public Double getCg_value() {
        return cg_value;
    }

    public void setCg_value(Double cg_value) {
        this.cg_value = cg_value;
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

    @Transient
    public String getStnm() {
        return stnm;
    }

    public void setStnm(String stnm) {
        this.stnm = stnm;
    }
    @Transient
    public String getProj_cd_name() {
        return proj_cd_name;
    }

    public void setProj_cd_name(String proj_cd_name) {
        this.proj_cd_name = proj_cd_name;
    }

    //Column(name = "JSRNAME" ,  length = 50   )
    //Length(min=0, max=50, message="入库签收人员长度必须介于 0 和 50 之间")
    //Column(name = "CKID",  nullable = false, precision = 16, scale = 0   )
}

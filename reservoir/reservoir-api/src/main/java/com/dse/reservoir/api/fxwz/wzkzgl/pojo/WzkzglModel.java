package com.dse.reservoir.api.fxwz.wzkzgl.pojo;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Description:实体 物资库存表
 * @Copyright:
 * @Company:
 * @author
 * @version 1.0 2017-08-06
 */
@Entity
@Table(name = "WR_MA_INVENTORY")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WzkzglModel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /** 主键**/
    @EmbeddedId
    private WrMaInventoryPK idpk;//联合主键


    /**
     *所属管理部
     */
    private String org_cd;
    /**
     *当前库容量（累计：WR_MA_QUAN_B.REAL_QUAN（当次数量））
     */
    private Double real_quan;
    /**
     *存储定额
     */
    private Double std_quan;
    /**
     *创建时间
     */
    private Date ts;
    /**
     *备注
     */
    private String nt;
    /**
     *默认货柜
     */
    private String binnum;


    @Transient
    private String ma_pc;

    @Transient
    private String ma_nm;
    @Transient
    private String model;
    @Transient
    private String mu;
    @Transient
    private String manufacturer;
    @Transient
    private String ma_type_id;
    @Transient
    private String ma_type_name;
    @Transient
    private String wh_nm;
    @Transient
    private String org_cd_name;
    @Transient
    private String ma_status;


    public String getMa_nm() {
        return ma_nm;
    }

    public void setMa_nm(String ma_nm) {
        this.ma_nm = ma_nm;
    }


    public String getMa_type_id() {
        return ma_type_id;
    }

    public void setMa_type_id(String ma_type_id) {
        this.ma_type_id = ma_type_id;
    }


    public String getMa_type_name() {
        return ma_type_name;
    }

    public void setMa_type_name(String ma_type_name) {
        this.ma_type_name = ma_type_name;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getMu() {
        return mu;
    }

    public void setMu(String mu) {
        this.mu = mu;
    }


    public String getWh_nm() {
        return wh_nm;
    }

    public void setWh_nm(String wh_nm) {
        this.wh_nm = wh_nm;
    }


    public String getOrg_cd_name() {
        return org_cd_name;
    }

    public void setOrg_cd_name(String org_cd_name) {
        this.org_cd_name = org_cd_name;
    }

    public WzkzglModel() {
        super();
    }

    /*
    @Id
    , precision = 16, scale = 0
    */

    @Column(name = "ID", nullable = false  )
    @NotNull(message="ID不能为空")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "BINNUM")
    public String getBinnum() {
        return binnum;
    }

    public void setBinnum(String binnum) {
        this.binnum = binnum;
    }

    @Column(name = "NT")
    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }
    @Column(name = "ORG_CD")
    public String getOrg_cd() {
        return org_cd;
    }

    public void setOrg_cd(String org_cd) {
        this.org_cd = org_cd;
    }
    @Column(name = "REAL_QUAN")
    public Double getReal_quan() {
        return real_quan;
    }

    public void setReal_quan(Double real_quan) {
        this.real_quan = real_quan;
    }
    @Column(name = "STD_QUAN")
    public Double getStd_quan() {
        return std_quan;
    }

    public void setStd_quan(Double std_quan) {
        this.std_quan = std_quan;
    }
    @Column(name = "TS")
    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }


    public String getMa_status() {
        return ma_status;
    }

    public void setMa_status(String ma_status) {
        this.ma_status = ma_status;
    }


    public String getMa_pc() {
        return ma_pc;
    }
    public void setMa_pc(String ma_pc) {
        this.ma_pc = ma_pc;
    }

    public WrMaInventoryPK getIdpk() {
        return idpk;
    }

    public void setIdpk(WrMaInventoryPK idpk) {
        this.idpk = idpk;
    }


    //Column(name = "JSRNAME" ,  length = 50   )
    //Length(min=0, max=50, message="入库签收人员长度必须介于 0 和 50 之间")
    //Column(name = "CKID",  nullable = false, precision = 16, scale = 0   )
}

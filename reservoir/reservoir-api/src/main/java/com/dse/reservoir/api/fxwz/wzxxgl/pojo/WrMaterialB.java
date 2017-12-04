package com.dse.reservoir.api.fxwz.wzxxgl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

/**
 * 物资基本信息表
 */
@Entity
@Table(name = "WR_MATERIAL_B")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrMaterialB implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** 物资编码**/
    @Id
    private String ma_cd;

    /** 物资分类序号**/
    private String ma_type_id;

    /** 物资名称**/
    private String ma_nm;

    /** 规格或型号**/
    private String model;

    /** 单位**/
    private String mu;

    /** 参考储备年限**/
    private Integer std_year;

    /** 备注**/
    private String nt;

    /** 创建时间**/
    private Date ts;

    /** 水利部定额**/
    private Double sl_std_quan;

    /** 公司储备定额**/
    private Double gs_std_quan;

    /** 状态**/
    private String status;

    /** 生产厂家**/
    private String manufacturer;

    public WrMaterialB() {
    }

    @Id
    @Column(name = "MA_CD" , nullable = false ,  length = 32   )
    @Length(min=0, max=32, message="物资编码长度必须介于 0 和 32 之间")
    public String getMa_cd() {
        return ma_cd;
    }

    public void setMa_cd(String ma_cd) {
        this.ma_cd = ma_cd;
    }

    @Column(name = "MA_TYPE_ID" ,  length = 32   )
    @Length(min=0, max=32, message="物资分类编码长度必须介于 0 和 32 之间")
    public String getMa_type_id() {
        return ma_type_id;
    }

    public void setMa_type_id(String ma_type_id) {
        this.ma_type_id = ma_type_id;
    }

    @Column(name = "MA_NM" ,  length = 250  )
    @Length(min=0, max=250, message="物资名称长度必须介于 0 和 250 之间")
    public String getMa_nm() {
        return ma_nm;
    }

    public void setMa_nm(String ma_nm) {
        this.ma_nm = ma_nm;
    }

    @Column(name = "MODEL" ,  length = 100   )
    @Length(min=0, max=100, message="规格或型号长度必须介于 0 和 100 之间")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "MU" ,  length = 20   )
    @Length(min=0, max=20, message="单位长度必须介于 0 和 20 之间")
    public String getMu() {
        return mu;
    }

    public void setMu(String mu) {
        this.mu = mu;
    }

    @Column(name = "STD_YEAR", precision = 3, scale = 0   )
    public Integer getStd_year() {
        return std_year;
    }

    public void setStd_year(Integer std_year) {
        this.std_year = std_year;
    }

    @Column(name = "NT" ,  length = 256   )
    @Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TS" ,  length = 23   )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    @Column(name = "SL_STD_QUAN", precision = 8, scale = 2   )
    public Double getSl_std_quan() {
        return sl_std_quan;
    }

    public void setSl_std_quan(Double sl_std_quan) {
        this.sl_std_quan = sl_std_quan;
    }

    @Column(name = "GS_STD_QUAN", precision = 8, scale = 2   )
    public Double getGs_std_quan() {
        return gs_std_quan;
    }

    public void setGs_std_quan(Double gs_std_quan) {
        this.gs_std_quan = gs_std_quan;
    }

    @Column(name = "STATUS" ,  length = 1   )
    @Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "MANUFACTURER" ,  length = 100   )
    @Length(min=0, max=100, message="生产厂家长度必须介于 0 和 32 之间")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}

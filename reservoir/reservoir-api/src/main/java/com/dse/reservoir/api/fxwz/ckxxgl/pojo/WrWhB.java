package com.dse.reservoir.api.fxwz.ckxxgl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

/**
 * 仓库信息管理表
 */
@Entity
@Table(name = "WR_WH_B")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrWhB implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** 仓库编号**/
    @Id
    private String wh_cd;

    /** 仓库名称**/
    private String wh_nm;

    /** 管理单位**/
    private String org_cd;

    /** 经度**/
    private Double lgtd;

    /** 纬度**/
    private Double lttd;

    /** 面积**/
    private Double area;

    /** 所在地点**/
    private String loc;

    /** 责任人**/
    private String con_user;

    /** 联系电话**/
    private String con_number;

    /** 创建时间**/
    private Date ts;

    /** 状态**/
    private String wh_status;
    private String wh_status_name;

    /** 备注**/
    private String nt;

    public WrWhB() {
    }

    @Id
    @Column(name = "WH_CD" , nullable = false ,  length = 32   )
    @Length(min=0, max=32, message="仓库编码长度必须介于 0 和 32 之间")
    public String getWh_cd() {
        return wh_cd;
    }

    public void setWh_cd(String wh_cd) {
        this.wh_cd = wh_cd;
    }

    @Column(name = "WH_NM" ,  length = 50   )
    @Length(min=0, max=50, message="仓库名称长度必须介于 0 和 50 之间")
    public String getWh_nm() {
        return wh_nm;
    }

    public void setWh_nm(String wh_nm) {
        this.wh_nm = wh_nm;
    }

    @Column(name = "ORG_CD" ,  length = 32   )
    @Length(min=0, max=32, message="管理单位编码长度必须介于 0 和 32 之间")
    public String getOrg_cd() {
        return org_cd;
    }

    public void setOrg_cd(String org_cd) {
        this.org_cd = org_cd;
    }

    @Column(name = "LGTD", precision = 12, scale = 9   )
    public Double getLgtd() {
        return lgtd;
    }

    public void setLgtd(Double lgtd) {
        this.lgtd = lgtd;
    }

    @Column(name = "LTTD", precision = 11, scale = 9   )
    public Double getLttd() {
        return lttd;
    }

    public void setLttd(Double lttd) {
        this.lttd = lttd;
    }

    @Column(name = "AREA", precision = 7, scale = 3   )
    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Column(name = "LOC" ,  length = 50   )
    @Length(min=0, max=50, message="所在地点长度必须介于 0 和 50 之间")
    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Column(name = "CON_USER" ,  length = 50   )
    @Length(min=0, max=50, message="责任人长度必须介于 0 和 50 之间")
    public String getCon_user() {
        return con_user;
    }

    public void setCon_user(String con_user) {
        this.con_user = con_user;
    }

    @Column(name = "CON_NUMBER" ,  length = 11   )
    @Length(min=0, max=11, message="联系电话长度必须介于 0 和 11 之间")
    public String getCon_number() {
        return con_number;
    }

    public void setCon_number(String con_number) {
        this.con_number = con_number;
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

    @Column(name = "WH_STATUS" ,  length = 1   )
    @Length(min=0, max=1, message="状态长度必须介于 0 和 1 之间")
    public String getWh_status() {
        return wh_status;
    }

    public void setWh_status(String wh_status) {
        this.wh_status = wh_status;
    }

    @Column(name = "NT" ,  length = 256   )
    @Length(min=0, max=256, message="备注长度必须介于 0 和 256 之间")
    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    @Transient
    public String getWh_status_name() {
        return wh_status_name;
    }

    public void setWh_status_name(String wh_status_name) {
        this.wh_status_name = wh_status_name;
    }
}

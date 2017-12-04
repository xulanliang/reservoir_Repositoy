package com.dse.reservoir.api.fxwz.wrmapatrolb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

/**
 * 防汛物资巡查登记表
 */
@Entity
@Table(name = "WR_MA_PATROL_B")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrMaPatrolb implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public WrMaPatrolb() {
    }

    /** **/
    @Id
    private String id;
    /** **/
    private String org_cd;
    /** **/
    private String wh_cd;
    /** **/
    private String patrol_desc;
    /** **/
    private Date patrol_date;
    /** **/
    private String issues;

    private String measures;

    private Date plan_date;

    private String check_user;

    private String result_desc;

    private Date end_date;

    private String create_user;

    private String pa_status;
    /**
     * 备注
     **/
    private String nt;

    /**
     * 创建时间
     **/
    private Date ts;

    /** **/
    private String tech_duty;

    /** **/
    private String proj_duty;

    private String is_flood;


    @Column(name = "CHECK_USER", length = 32)
    @Length(min = 0, max = 32, message = "检查人员长度必须介于 0 和 32 之间")
    public String getCheck_user() {
        return check_user;
    }

    public void setCheck_user(String check_user) {
        this.check_user = check_user;
    }

    @Column(name = "RESULT_DESC", length = 100)
    @Length(min = 0, max = 100, message = "落实情况长度必须介于 0 和 100 之间")
    public String getResult_desc() {
        return result_desc;
    }

    public void setResult_desc(String result_desc) {
        this.result_desc = result_desc;
    }

    @Column(name = "CREATE_USER", length = 32)
    @Length(min = 0, max = 32, message = "检查人员长度必须介于 0 和 32 之间")
    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE", length = 23)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Id
    @Column(name = "ID", nullable = false, length = 32)
    @Length(min = 0, max = 32, message = "编码长度必须介于 0 和 32 之间")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //是否为汛前汛后检查(0:日常巡查,1:汛前检查2:汛后检查)
    @Column(name = "IS_FLOOD", length = 1)
    @Length(min = 0, max = 1, message = "状态长度必须介于 0 和 1 之间")
    public String getIs_flood() {
        return is_flood;
    }

    public void setIs_flood(String is_flood) {
        this.is_flood = is_flood;
    }

    @Column(name = "ISSUES", length = 100)
    @Length(min = 0, max = 100, message = "存在问题长度必须介于 0 和 100 之间")
    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }

    @Column(name = "MEASURES", length = 100)
    @Length(min = 0, max = 100, message = "处理措施长度必须介于 0 和 100 之间")
    public String getMeasures() {
        return measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures;
    }

    @Column(name = "ORG_CD", length = 32)
    @Length(min = 0, max = 32, message = "所属仓库长度必须介于 0 和 32 之间")
    public String getOrg_cd() {
        return org_cd;
    }

    public void setOrg_cd(String org_cd) {
        this.org_cd = org_cd;
    }

    @Column(name = "PA_STATUS", length = 1)
    @Length(min = 0, max = 1, message = "状态长度必须介于 0 和 1 之间")
    public String getPa_status() {
        return pa_status;
    }

    public void setPa_status(String pa_status) {
        this.pa_status = pa_status;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PATROL_DATE", length = 23)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getPatrol_date() {
        return patrol_date;
    }

    public void setPatrol_date(Date patrol_date) {
        this.patrol_date = patrol_date;
    }

    @Column(name = "PATROL_DESC", length = 100)
    @Length(min = 0, max = 100, message = "巡查内容长度必须介于 0 和 250 之间")
    public String getPatrol_desc() {
        return patrol_desc;
    }

    public void setPatrol_desc(String patrol_desc) {
        this.patrol_desc = patrol_desc;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PLAN_DATE", length = 23)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getPlan_date() {
        return plan_date;
    }

    public void setPlan_date(Date plan_date) {
        this.plan_date = plan_date;
    }

    @Column(name = "PROJ_DUTY", length = 32)
    @Length(min = 0, max = 32, message = "工程责任人长度必须介于 0 和 32 之间")
    public String getProj_duty() {
        return proj_duty;
    }

    public void setProj_duty(String proj_duty) {
        this.proj_duty = proj_duty;
    }

    @Column(name = "TECH_DUTY", length = 32)
    @Length(min = 0, max = 32, message = "工程技术责任人长度必须介于 0 和 32 之间")
    public String getTech_duty() {
        return tech_duty;
    }

    public void setTech_duty(String tech_duty) {
        this.tech_duty = tech_duty;
    }

    @Column(name = "WH_CD", length = 32)
    @Length(min = 0, max = 32, message = "管理单位长度必须介于 0 和 32 之间")
    public String getWh_cd() {
        return wh_cd;
    }

    public void setWh_cd(String wh_cd) {
        this.wh_cd = wh_cd;
    }

    @Column(name = "NT", length = 256)
    @Length(min = 0, max = 256, message = "备注长度必须介于 0 和 256 之间")
    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TS", length = 23)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }


}

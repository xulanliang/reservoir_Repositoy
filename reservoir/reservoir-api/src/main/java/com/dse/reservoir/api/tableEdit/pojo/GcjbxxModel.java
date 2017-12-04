package com.dse.reservoir.api.tableEdit.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dse on 2017/8/4.
 */
@Entity
@Table(name = "WR_PROJ_B")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class GcjbxxModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String PROJ_CD; //工程编号
    private String PROJ_NM; //工程名称
    private String PID; //父工程编号
    private String PROJ_DESC; //工程介绍
    private String CPLDT; //竣工年月
    private Date CREATE_TIME; //创建时间
    private String CREATE_USER; //创建人
    private Date TS=new Date(); //时间戳
    private String NT; //备注
    private String ISDISPLAY;   //是否显示(0：显示，1不显示)
    private String DEPARTMENTID;    //所属管理部门 1001 深圳部,1002 雁田部,1003 桥头部,1004 塘厦部
    private String ISSY;    //是否有渗压测点(0：没有，1有)
    private String ISSW;    //是否有渗压测点(0：没有，1有)
    private String ISDC;    //是否有渗压测点(0：没有，1有)
    private String ISSC;    //是否有渗压测点(0：没有，1有)
    private String ISCZ;    //是否有渗压测点(0：没有，1有)
    private String ISSP;    //是否有渗压测点(0：没有，1有)

    @Id
    @NotNull(message = "工程编号不能为空")
    @Column(name = "PROJ_CD",length = 16)
    @Length(min = 0,max = 16,message = "工程编号长度只能在 0 至 16 之间")
    public String getPROJ_CD() {
        return PROJ_CD;
    }

    public void setPROJ_CD(String PROJ_CD) {
        this.PROJ_CD = PROJ_CD;
    }

    @Column(name = "PROJ_NM",length = 50)
    @NotNull(message = "工程名称不能为空")
    @Length(min = 0,max = 50,message = "工程名称长度只能在 0 至 50 之间")
    public String getPROJ_NM() {
        return PROJ_NM;
    }

    public void setPROJ_NM(String PROJ_NM) {
        this.PROJ_NM = PROJ_NM;
    }

    @Column(name = "PID",length = 16)
    @Length(min = 0,max = 16,message = "父工程编号只能在 0 至 50 之间")
    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    @Column(name = "PROJ_DESC",length = 1024)
    @Length(min = 0,max = 1024,message = "工程介绍只能在 0 至 1024 之间")
    public String getPROJ_DESC() {
        return PROJ_DESC;
    }

    public void setPROJ_DESC(String PROJ_DESC) {
        this.PROJ_DESC = PROJ_DESC;
    }

    @Column(name = "CPLDT",length = 6)
    @Length(min = 0,max = 6,message = "竣工年月只能在 0 至 1024 之间")
    public String getCPLDT() {
        return CPLDT;
    }

    public void setCPLDT(String CPLDT) {
        this.CPLDT = CPLDT;
    }

    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(Date CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    @Column(name = "CREATE_USER",length = 9)
    @Length(min = 0,max = 9,message = "创建人只能在 0 至 9 之间")
    public String getCREATE_USER() {
        return CREATE_USER;
    }

    public void setCREATE_USER(String CREATE_USER) {
        this.CREATE_USER = CREATE_USER;
    }

    @Column(name = "TS")
    @NotNull(message = "时间戳不能为空")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTS() {
        return TS;
    }

    public void setTS(Date TS) {
        this.TS = TS;
    }

    @Column(name = "NT",length = 256)
    @Length(min = 0,max = 256,message = "备注只能在 0 至 256 之间")
    public String getNT() {
        return NT;
    }

    public void setNT(String NT) {
        this.NT = NT;
    }

    @Column(name = "ISDISPLAY",length = 1)
    @Length(min = 0,max = 1)
    public String getISDISPLAY() {
        return ISDISPLAY;
    }

    public void setISDISPLAY(String ISDISPLAY) {
        this.ISDISPLAY = ISDISPLAY;
    }

    @Column(name = "DEPARTMENTID",length = 20)
    @Length(min = 0,max = 20)
    public String getDEPARTMENTID() {
        return DEPARTMENTID;
    }

    public void setDEPARTMENTID(String DEPARTMENTID) {
        this.DEPARTMENTID = DEPARTMENTID;
    }

    @Column(name = "ISSY",length = 1)
    @Length(min = 0,max = 1)
    public String getISSY() {
        return ISSY;
    }

    public void setISSY(String ISSY) {
        this.ISSY = ISSY;
    }

    @Column(name = "ISSW",length = 1)
    @Length(min = 0,max = 1)
    public String getISSW() {
        return ISSW;
    }

    public void setISSW(String ISSW) {
        this.ISSW = ISSW;
    }

    @Column(name = "ISDC",length = 1)
    @Length(min = 0,max = 1)
    public String getISDC() {
        return ISDC;
    }

    public void setISDC(String ISDC) {
        this.ISDC = ISDC;
    }

    @Column(name = "ISSC",length = 1)
    @Length(min = 0,max = 1)
    public String getISSC() {
        return ISSC;
    }

    public void setISSC(String ISSC) {
        this.ISSC = ISSC;
    }

    @Column(name = "ISCZ",length = 1)
    @Length(min = 0,max = 1)
    public String getISCZ() {
        return ISCZ;
    }

    public void setISCZ(String ISCZ) {
        this.ISCZ = ISCZ;
    }

    @Column(name = "ISSP",length = 1)
    @Length(min = 0,max = 1)
    public String getISSP() {
        return ISSP;
    }

    public void setISSP(String ISSP) {
        this.ISSP = ISSP;
    }
}

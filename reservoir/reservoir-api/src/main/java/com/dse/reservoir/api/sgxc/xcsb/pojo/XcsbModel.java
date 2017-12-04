package com.dse.reservoir.api.sgxc.xcsb.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 *  问题跟踪表
 * Created by dse on 2017/8/22.
 */
@Entity
@Table(name = "WR_CH_ISSUES_B")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class XcsbModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ID;  //编码
    private String ISU_DESC;  //问题描述
    private String ISU_STATUS;  //问题状态（0:新建;   1:解决中 ; 2:已解决; 3:未解决）
    private String ISU_RESOLVE;  //解决说明
    private String RESOLVE_USER;  //解决人员
    private String NT;  //备注
    private Date TS;  //时间



    @Id()
    @Column(name = "ID",length = 32)
    @Length(min = 0,max = 32,message = "问题编码长度只能在 0 至 32 之间")
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Column(name = "ISU_DESC",length = 256)
    @Length(min = 0,max = 256,message = "问题描述长度只能在 0 至 256 之间")
    public String getISU_DESC() {
        return ISU_DESC;
    }

    public void setISU_DESC(String ISU_DESC) {
        this.ISU_DESC = ISU_DESC;
    }

    @Column(name = "ISU_STATUS",length = 1)
    @Length(min = 0,max = 1,message = "问题状态只能在 0 至 1 之间")
    public String getISU_STATUS() {
        return ISU_STATUS;
    }

    public void setISU_STATUS(String ISU_STATUS) {
        this.ISU_STATUS = ISU_STATUS;
    }

    @Column(name = "ISU_RESOLVE",length = 256)
    @Length(min = 0,max = 256,message = "问题说明长度只能在 0 至 256 之间")
    public String getISU_RESOLVE() {
        return ISU_RESOLVE;
    }

    public void setISU_RESOLVE(String ISU_RESOLVE) {
        this.ISU_RESOLVE = ISU_RESOLVE;
    }

    @Column(name = "RESOLVE_USER",length = 32)
    @Length(min = 0,max = 32,message = "解决人员长度只能在 0 至 32 之间")
    public String getRESOLVE_USER() {
        return RESOLVE_USER;
    }

    public void setRESOLVE_USER(String RESOLVE_USER) {
        this.RESOLVE_USER = RESOLVE_USER;
    }

    @Column(name = "NT",length = 256)
    @Length(min = 0,max = 256,message = "解决人员长度只能在 0 至 256 之间")
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
}

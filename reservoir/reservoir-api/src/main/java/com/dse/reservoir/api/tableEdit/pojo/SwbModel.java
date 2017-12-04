package com.dse.reservoir.api.tableEdit.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dse on 2017/8/7.
 */
@Entity
@Table(name = "WR_SW_R")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SwbModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SwbPK id;      //联合主键

    private Double Z;    //水位
    private Double BD;    //埋深
    private String RMSY;    //注解符号
    private String GATTYPE;    //采集方式
    private String NT;    //备注
    private Date TS;    //时间戳

    public SwbPK getId() {
        return id;
    }

    public void setId(SwbPK id) {
        this.id = id;
    }

    @Column(name = "Z")
    public Double getZ() {
        return Z;
    }

    public void setZ(Double z) {
        Z = z;
    }

    @Column(name = "BD")
    public Double getBD() {
        return BD;
    }

    public void setBD(Double BD) {
        this.BD = BD;
    }

    @Column(name = "RMSY",length = 1)
    @Length(min = 0,max = 1,message = "注解符号长度只能为1")
    public String getRMSY() {
        return RMSY;
    }

    public void setRMSY(String RMSY) {
        this.RMSY = RMSY;
    }

    @Column(name = "GATTYPE",length = 1)
    @Length(min = 0,max = 1,message = "采集方式只能为1")
    public String getGATTYPE() {
        return GATTYPE;
    }

    public void setGATTYPE(String GATTYPE) {
        this.GATTYPE = GATTYPE;
    }

    @Column(name = "NT",length = 200)
    @Length(min = 0,max = 200,message = "备注长度只能在 0 至 200 之间")
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

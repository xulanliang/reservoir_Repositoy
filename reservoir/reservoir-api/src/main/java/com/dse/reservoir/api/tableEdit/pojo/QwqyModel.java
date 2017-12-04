package com.dse.reservoir.api.tableEdit.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

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
@Table(name = "ST_TMP_R")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class QwqyModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private QwqyPK id;      //联合主键

    private double ATMP;    //气温
    private double CATMP;    //气温校正值
    private Integer AIRP;    //气压（单位：Pa）
    private Integer CAIRP ;    //气压校正值（单位：Pa）


    public QwqyPK getId() {
        return id;
    }

    public void setId(QwqyPK id) {
        this.id = id;
    }

    @Column(name = "ATMP")
    public double getATMP() {
        return ATMP;
    }

    public void setATMP(double ATMP) {
        this.ATMP = ATMP;
    }

    @Column(name = "CATMP")
    public double getCATMP() {
        return CATMP;
    }

    public void setCATMP(double CATMP) {
        this.CATMP = CATMP;
    }

    @Column(name = "AIRP")
    public Integer getAIRP() {
        return AIRP;
    }

    public void setAIRP(Integer AIRP) {
        this.AIRP = AIRP;
    }

    @Column(name = "CAIRP")
    public Integer getCAIRP() {
        return CAIRP;
    }

    public void setCAIRP(Integer CAIRP) {
        this.CAIRP = CAIRP;
    }
}

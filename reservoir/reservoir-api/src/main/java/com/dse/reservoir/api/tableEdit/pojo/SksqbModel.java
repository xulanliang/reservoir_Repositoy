package com.dse.reservoir.api.tableEdit.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by dse on 2017/8/8.
 */
@Entity
@Table(name = "ST_RSVR_R")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SksqbModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private SksqbPK id;     //联合主键

    private Double RZ;      //库上水位
    private Double INQ;      //入库流量
    private String W;      //蓄水量
    private Double BLRZ;      //库下水位
    private Double OTQ;      //出库流量
    private String RWCHRCD;      //库水特征码
    private String RWPTN;      //库水水势
    private Double INQDR;      //入流时段长
    private String GATTYPE;      //测流方法

    public SksqbPK getId() {
        return id;
    }

    public void setId(SksqbPK id) {
        this.id = id;
    }

    @Column(name = "RZ")
    public Double getRZ() {
        return RZ;
    }

    public void setRZ(Double RZ) {
        this.RZ = RZ;
    }

    @Column(name = "INQ")
    public Double getINQ() {
        return INQ;
    }

    public void setINQ(Double INQ) {
        this.INQ = INQ;
    }

    @Column(name = "W",length = 1)
    @Length(min = 0,max = 1,message = "蓄水量的长度只能在 0 至 1 之间")
    public String getW() {
        return W;
    }

    public void setW(String w) {
        W = w;
    }

    @Column(name = "BLRZ")
    public Double getBLRZ() {
        return BLRZ;
    }

    public void setBLRZ(Double BLRZ) {
        this.BLRZ = BLRZ;
    }

    @Column(name = "OTQ")
    public Double getOTQ() {
        return OTQ;
    }

    public void setOTQ(Double OTQ) {
        this.OTQ = OTQ;
    }

    @Column(name = "RWCHRCD",length = 1)
    @Length(min = 0,max = 1,message = "库水特征码的长度只能在 0 至 1 之间")
    public String getRWCHRCD() {
        return RWCHRCD;
    }

    public void setRWCHRCD(String RWCHRCD) {
        this.RWCHRCD = RWCHRCD;
    }

    @Column(name = "RWPTN",length = 1)
    @Length(min = 0,max = 1,message = "库水水势的长度只能在 0 至 1 之间")
    public String getRWPTN() {
        return RWPTN;
    }

    public void setRWPTN(String RWPTN) {
        this.RWPTN = RWPTN;
    }

    @Column(name = "INQDR")
    public Double getINQDR() {
        return INQDR;
    }

    public void setINQDR(Double INQDR) {
        this.INQDR = INQDR;
    }

    @Column(name = "GATTYPE",length = 1)
    @Length(min = 0,max = 1,message = "测流方式的长度只能在 0 至 1 之间")
    public String getGATTYPE() {
        return GATTYPE;
    }

    public void setGATTYPE(String GATTYPE) {
        this.GATTYPE = GATTYPE;
    }
}

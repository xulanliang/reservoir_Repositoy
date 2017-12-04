package com.dse.tgang.dam.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by gaoq on 2016-12-23.
 */
@Entity
@Table(name = "ST_RSVRFSR_B")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class StRsvrfsrB implements java.io.Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    /** 主键 */
    private StRsvrfsrBId id;
    /** 结束年月 */
    private String edmd;
    /** 汛限水位 */
    private Double fsltdz;
    /** 汛限库容 */
    private Double fsltdw;
    /** 汛奶类型 */
    private String fstp;
    /** 修改时间 */
    private Timestamp moditime;

    // Constructors

    /** default constructor */
    public StRsvrfsrB() {
    }

    /** minimal constructor */
    public StRsvrfsrB(StRsvrfsrBId id, String edmd) {
        this.id = id;
        this.edmd = edmd;
    }

    /** full constructor */
    public StRsvrfsrB(StRsvrfsrBId id, String edmd, Double fsltdz, Double fsltdw, String fstp, Timestamp moditime) {
        this.id = id;
        this.edmd = edmd;
        this.fsltdz = fsltdz;
        this.fsltdw = fsltdw;
        this.fstp = fstp;
        this.moditime = moditime;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "stcd", column = @Column(name = "STCD", nullable = false, length = 8)),
            @AttributeOverride(name = "bgmd", column = @Column(name = "BGMD", nullable = false, length = 4)) })
    public StRsvrfsrBId getId() {
        return this.id;
    }

    public void setId(StRsvrfsrBId id) {
        this.id = id;
    }

    @Column(name = "EDMD", nullable = false, length = 4)
    public String getEdmd() {
        return this.edmd;
    }

    public void setEdmd(String edmd) {
        this.edmd = edmd;
    }

    @Column(name = "FSLTDZ", precision = 7, scale = 3)
    public Double getFsltdz() {
        return this.fsltdz;
    }

    public void setFsltdz(Double fsltdz) {
        this.fsltdz = fsltdz;
    }

    @Column(name = "FSLTDW", precision = 9, scale = 3)
    public Double getFsltdw() {
        return this.fsltdw;
    }

    public void setFsltdw(Double fsltdw) {
        this.fsltdw = fsltdw;
    }

    @Column(name = "FSTP", length = 1)
    public String getFstp() {
        return this.fstp;
    }

    public void setFstp(String fstp) {
        this.fstp = fstp;
    }

    @Column(name = "MODITIME", length = 23)
    public Timestamp getModitime() {
        return this.moditime;
    }

    public void setModitime(Timestamp moditime) {
        this.moditime = moditime;
    }

    public StRsvrfsrB clone() {
        StRsvrfsrB o = null;
        try {
            o = (StRsvrfsrB) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

}

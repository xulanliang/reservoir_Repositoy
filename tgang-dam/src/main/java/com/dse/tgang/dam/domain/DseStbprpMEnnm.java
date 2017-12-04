package com.dse.tgang.dam.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by huangxy on 2016-12-23.
 */
@Entity
@Table(name = "DSE_STBPRP_M_ENNM")
public class DseStbprpMEnnm implements java.io.Serializable {

    // Fields
    /** 主键 */
    private Long dbcd;
    /** 测站编码 */
    private String stcd;
    /** 工程编码 */
    private String ennmcd;

    // Constructors

    /** default constructor */
    public DseStbprpMEnnm() {
    }

    /** full constructor */
    public DseStbprpMEnnm(String stcd, String ennmcd) {
        this.stcd = stcd;
        this.ennmcd = ennmcd;
    }

    // Property accessors
    @Id
    @Column(name = "DBCD", unique = true, nullable = false, precision = 16, scale = 0)
    public Long getDbcd() {
        return this.dbcd;
    }

    public void setDbcd(Long dbcd) {
        this.dbcd = dbcd;
    }

    @Column(name = "STCD", length = 8)
    public String getStcd() {
        return this.stcd;
    }

    public void setStcd(String stcd) {
        this.stcd = stcd;
    }

    @Column(name = "ENNMCD", length = 16)
    public String getEnnmcd() {
        return this.ennmcd;
    }

    public void setEnnmcd(String ennmcd) {
        this.ennmcd = ennmcd;
    }

}

package com.dse.tgang.dam.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by gaoq on 2016-12-23.
 */
@Embeddable
public class StRsvrfsrBId implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    /** 测站编码 */
    private String stcd;
    /** 开始年月 */
    private String bgmd;

    // Constructors

    /** default constructor */
    public StRsvrfsrBId() {
    }

    /** full constructor */
    public StRsvrfsrBId(String stcd, String bgmd) {
        this.stcd = stcd;
        this.bgmd = bgmd;
    }

    // Property accessors

    @Column(name = "STCD", nullable = false, length = 8)
    public String getStcd() {
        return this.stcd;
    }

    public void setStcd(String stcd) {
        this.stcd = stcd;
    }

    @Column(name = "BGMD", nullable = false, length = 4)
    public String getBgmd() {
        return this.bgmd;
    }

    public void setBgmd(String bgmd) {
        this.bgmd = bgmd;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof StRsvrfsrBId))
            return false;
        StRsvrfsrBId castOther = (StRsvrfsrBId) other;

        return ((this.getStcd() == castOther.getStcd()) || (this.getStcd() != null && castOther.getStcd() != null && this.getStcd().equals(castOther.getStcd())))
                && ((this.getBgmd() == castOther.getBgmd()) || (this.getBgmd() != null && castOther.getBgmd() != null && this.getBgmd().equals(
                castOther.getBgmd())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getStcd() == null ? 0 : this.getStcd().hashCode());
        result = 37 * result + (getBgmd() == null ? 0 : this.getBgmd().hashCode());
        return result;
    }

}
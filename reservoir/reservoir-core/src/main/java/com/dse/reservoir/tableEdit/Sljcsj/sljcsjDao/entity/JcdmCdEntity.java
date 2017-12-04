package com.dse.reservoir.tableEdit.Sljcsj.sljcsjDao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by yuan_feng on 2017/9/8.
 */
@Entity
@Table(name = "WR_ST_RB_MAP")
public class JcdmCdEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer WR_RB_ID;            // INTEGER              not null,
    private String  STCD;                 //VARCHAR2(32)         not null,
    private String RB_CD;                //VARCHAR2(16)         not null,
    private String NT;                  // VARCHAR2(256),

    public Integer getWR_RB_ID() {
        return WR_RB_ID;
    }

    public void setWR_RB_ID(Integer WR_RB_ID) {
        this.WR_RB_ID = WR_RB_ID;
    }

    public String getSTCD() {
        return STCD;
    }

    public void setSTCD(String STCD) {
        this.STCD = STCD;
    }

    public String getRB_CD() {
        return RB_CD;
    }

    public void setRB_CD(String RB_CD) {
        this.RB_CD = RB_CD;
    }

    public String getNT() {
        return NT;
    }

    public void setNT(String NT) {
        this.NT = NT;
    }
}

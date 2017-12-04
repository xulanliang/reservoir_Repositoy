package com.dse.reservoir.tableEdit.cdgclx.dao.vo;

/**
 * Created by yuan_feng on 2017/8/24.
 */
public class CdgclxVo  implements java.io.Serializable{
    private Integer WR_PROJ_ID;
    private String STCD;
    private String PROJ_CD;
    private Character ST_TP;
    private String NT;

    public Integer getWR_PROJ_ID() {
        return WR_PROJ_ID;
    }

    public void setWR_PROJ_ID(Integer WR_PROJ_ID) {
        this.WR_PROJ_ID = WR_PROJ_ID;
    }

    public String getSTCD() {
        return STCD;
    }

    public void setSTCD(String STCD) {
        this.STCD = STCD;
    }

    public String getPROJ_CD() {
        return PROJ_CD;
    }

    public void setPROJ_CD(String PROJ_CD) {
        this.PROJ_CD = PROJ_CD;
    }

    public Character getST_TP() {
        return ST_TP;
    }

    public void setST_TP(Character ST_TP) {
        this.ST_TP = ST_TP;
    }

    public String getNT() {
        return NT;
    }

    public void setNT(String NT) {
        this.NT = NT;
    }
}

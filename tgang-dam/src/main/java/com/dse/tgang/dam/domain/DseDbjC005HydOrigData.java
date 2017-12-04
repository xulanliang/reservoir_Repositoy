package com.dse.tgang.dam.domain;

import java.util.Date;

/**
 * Created by Administrator on 2017/1/13.
 */
public class DseDbjC005HydOrigData {

    public String getHydcd() {
        return hydcd;
    }

    public void setHydcd(String hydcd) {
        this.hydcd = hydcd;
    }

    public Date getTm() {
        return tm;
    }

    public void setTm(Date tm) {
        this.tm = tm;
    }

    public double getOrigdata() {
        return origdata;
    }

    public void setOrigdata(double origdata) {
        this.origdata = origdata;
    }

    public String getJcl() {
        return jcl;
    }

    public void setJcl(String jcl) {
        this.jcl = jcl;
    }

    public String getTransst() {
        return transst;
    }

    public void setTransst(String transst) {
        this.transst = transst;
    }

    public String getOtdesc() {
        return otdesc;
    }

    public void setOtdesc(String otdesc) {
        this.otdesc = otdesc;
    }

    public String getGattype() {
        return gattype;
    }

    public void setGattype(String gattype) {
        this.gattype = gattype;
    }

    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    public double getCalcdata() {
        return calcdata;
    }

    public void setCalcdata(double calcdata) {
        this.calcdata = calcdata;
    }

    private String hydcd;
    private Date tm;
    private double origdata;
    private String jcl;
    private String transst;
    private String otdesc;
    private String gattype;
    private String nt;
    private double calcdata;


}

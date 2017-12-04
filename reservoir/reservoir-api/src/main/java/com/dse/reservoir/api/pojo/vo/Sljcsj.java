package com.dse.reservoir.api.pojo.vo;

import java.util.Date;

/**
 * Created by yuan_feng on 2017/9/6.
 */
public class Sljcsj {
    private String  stcd;   //测点编号
    private String tm;   //采集时间
    private String origdata;   //监测值
    private String calcdata;   //校验值
    private String jcl;  //校验值
    private String transst;  //转换状态
    private String otdesc;  //其他
    private String gattype;  //采集方式(0:自动,1:人工)';
    private String nt;  //备注

    public String getStcd() {
        return stcd;
    }

    public void setStcd(String stcd) {
        this.stcd = stcd;
    }

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

    public String getOrigdata() {
        return origdata;
    }

    public void setOrigdata(String origdata) {
        this.origdata = origdata;
    }

    public String getCalcdata() {
        return calcdata;
    }

    public void setCalcdata(String calcdata) {
        this.calcdata = calcdata;
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

}

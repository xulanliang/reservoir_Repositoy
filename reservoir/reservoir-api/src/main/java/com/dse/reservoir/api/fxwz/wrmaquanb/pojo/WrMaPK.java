package com.dse.reservoir.api.fxwz.wrmaquanb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dse on 2017/8/7.
 */
@Embeddable
public class WrMaPK implements Serializable {

    //联合主键
    /**
     *所属仓库
     */
    private String wh_cd;
    /**
     *物资编码
     */
    private String ma_cd;

    /**
     *默认货柜
     */
    private String binnum="";

    /**
     *物资批次
     */
    private String ma_pc="";


    @Column(name = "WH_CD")
    public String getWh_cd() {
        return wh_cd;
    }

    public void setWh_cd(String wh_cd) {
        this.wh_cd = wh_cd;
    }
    @Column(name = "MA_PC")
    public String getMa_pc() {
        return ma_pc;
    }
    public void setMa_pc(String ma_pc) {
        this.ma_pc = ma_pc;
    }

    @Column(name = "BINNUM")
    public String getBinnum() {
        return binnum;
    }

    public void setBinnum(String binnum) {
        this.binnum = binnum;
    }
    @Column(name = "MA_CD")
    public String getMa_cd() {
        return ma_cd;
    }

    public void setMa_cd(String ma_cd) {
        this.ma_cd = ma_cd;
    }
}

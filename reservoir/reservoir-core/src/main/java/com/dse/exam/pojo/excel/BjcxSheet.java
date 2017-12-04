package com.dse.exam.pojo.excel;

import org.wxd.excel.annotation.ExcelCell;
import org.wxd.excel.annotation.ExcelSheet;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author wangzy
 * @date 2017-09-20
 */
@ExcelSheet(name = "报警查询报表",beginReadRowIndex = 1,beginWriteRowIndex = 1,hideColumns = "")
public class BjcxSheet implements Serializable {

    @ExcelCell(order = 0)
    private Integer orderIndex;

    @ExcelCell(order = 1)
    private String proj_cd_name ;

    @ExcelCell(order = 2)
    private String mon_tp_name ;

    @ExcelCell(order = 3)
    private String stnm ;

    @ExcelCell(order = 4)
    private String wa_dt ;

    @ExcelCell(order = 5)
    private String wa_tp_name ;

    @ExcelCell(order = 6)
    private Double wa_value ;

    @ExcelCell(order = 7)
    private Double real_value ;

    @ExcelCell(order = 8)
    private Double da_value;

    @ExcelCell(order = 9)
    private String wa_status_name;

    @ExcelCell(order = 10)
    private String nt;

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getProj_cd_name() {
        return proj_cd_name;
    }

    public void setProj_cd_name(String proj_cd_name) {
        this.proj_cd_name = proj_cd_name;
    }

    public String getMon_tp_name() {
        return mon_tp_name;
    }

    public void setMon_tp_name(String mon_tp_name) {
        this.mon_tp_name = mon_tp_name;
    }

    public String getStnm() {
        return stnm;
    }

    public void setStnm(String stnm) {
        this.stnm = stnm;
    }

    public String getWa_dt() {
        return wa_dt;
    }

    public void setWa_dt(String wa_dt) {
        this.wa_dt = wa_dt;
    }

    public String getWa_tp_name() {
        return wa_tp_name;
    }

    public void setWa_tp_name(String wa_tp_name) {
        this.wa_tp_name = wa_tp_name;
    }

    public Double getWa_value() {
        return wa_value;
    }

    public void setWa_value(Double wa_value) {
        this.wa_value = wa_value;
    }

    public Double getReal_value() {
        return real_value;
    }

    public void setReal_value(Double real_value) {
        this.real_value = real_value;
    }

    public Double getDa_value() {
        return da_value;
    }

    public void setDa_value(Double da_value) {
        this.da_value = da_value;
    }

    public String getWa_status_name() {
        return wa_status_name;
    }

    public void setWa_status_name(String wa_status_name) {
        this.wa_status_name = wa_status_name;
    }

    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }
}

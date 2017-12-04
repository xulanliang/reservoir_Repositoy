package com.dse.exam.pojo.excel;

import org.wxd.excel.annotation.ExcelCell;
import org.wxd.excel.annotation.ExcelSheet;

import java.io.Serializable;

/**
 * @Author Dongshf
 * @Date 2017/6/29
 */
@ExcelSheet(name = "渗流-观测记录表",beginReadRowIndex = 2,beginWriteRowIndex = 2,hideColumns = "")
public class SlGcjlbSheet implements Serializable {

    @ExcelCell(order = 0)
    private Integer orderIndex;

    /*项目*/
    @ExcelCell(order = 1)
    private String xm;

    /*上游水位*/
    @ExcelCell(order = 2)
    private String rz;

    /*降雨量*/
    @ExcelCell(order = 3)
    private String dyp;

    /*测点编号*/
    @ExcelCell(order = 4)
    private String stnm;



    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getRz() {
        return rz;
    }

    public void setRz(String rz) {
        this.rz = rz;
    }

    public String getDyp() {
        return dyp;
    }

    public void setDyp(String dyp) {
        this.dyp = dyp;
    }

    public String getStnm() {
        return stnm;
    }

    public void setStnm(String stnm) {
        this.stnm = stnm;
    }
}

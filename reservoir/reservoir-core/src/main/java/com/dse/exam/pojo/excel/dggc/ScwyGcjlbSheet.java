package com.dse.exam.pojo.excel.dggc;

import org.wxd.excel.annotation.ExcelCell;
import org.wxd.excel.annotation.ExcelSheet;

import java.io.Serializable;


/**
 * @Author Dongshf
 * @Date 2017/7/1
 */
@ExcelSheet(name = "深层位移-观测记录表",beginReadRowIndex = 2,beginWriteRowIndex = 2,hideColumns = "")
public class ScwyGcjlbSheet implements Serializable {

    @ExcelCell(order = 0)
    private Integer orderIndex;

    /*项目*/
    @ExcelCell(order = 1)
    private String xm;

    /*测点编号*/
    @ExcelCell(order = 2)
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

    public String getStnm() {
        return stnm;
    }

    public void setStnm(String stnm) {
        this.stnm = stnm;
    }
}

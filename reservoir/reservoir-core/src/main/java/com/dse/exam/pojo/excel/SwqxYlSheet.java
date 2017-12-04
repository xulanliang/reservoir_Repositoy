package com.dse.exam.pojo.excel;

import org.wxd.excel.annotation.ExcelCell;
import org.wxd.excel.annotation.ExcelSheet;

import java.io.Serializable;

/**
 * Created by pc on 2017-6-29.
 */

@ExcelSheet(name = "水文气象-雨量特征值报表",beginReadRowIndex = 2,beginWriteRowIndex = 2,hideColumns = "")
public class SwqxYlSheet implements Serializable {

    @ExcelCell(order = 0)
    private Integer orderIndex;

    /*年份*/
    @ExcelCell(order = 1)
    private String year;

    /*日最大值*/
    @ExcelCell(order = 2)
    private Double rmaxval;

    /*最大值时间*/
    @ExcelCell(order = 3)
    private String rmaxtm;

    /*月最大值*/
    @ExcelCell(order = 4)
    private Double ymaxval;

    /*月最大值时间*/
    @ExcelCell(order = 5)
    private String ymaxtm;

    /*年总值*/
    @ExcelCell(order = 6)
    private Double sumval;

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getRmaxval() {
        return rmaxval;
    }

    public void setRmaxval(Double rmaxval) {
        this.rmaxval = rmaxval;
    }

    public String getRmaxtm() {
        return rmaxtm;
    }

    public void setRmaxtm(String rmaxtm) {
        this.rmaxtm = rmaxtm;
    }

    public Double getYmaxval() {
        return ymaxval;
    }

    public void setYmaxval(Double ymaxval) {
        this.ymaxval = ymaxval;
    }

    public String getYmaxtm() {
        return ymaxtm;
    }

    public void setYmaxtm(String ymaxtm) {
        this.ymaxtm = ymaxtm;
    }

    public Double getSumval() {
        return sumval;
    }

    public void setSumval(Double sumval) {
        this.sumval = sumval;
    }
}

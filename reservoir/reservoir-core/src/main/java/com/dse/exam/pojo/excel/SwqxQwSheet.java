package com.dse.exam.pojo.excel;

import org.wxd.excel.annotation.ExcelCell;
import org.wxd.excel.annotation.ExcelSheet;

import java.io.Serializable;

/**
 * Created by pc on 2017-6-29.
 */

@ExcelSheet(name = "水文气象-气温特征值报表",beginReadRowIndex = 2,beginWriteRowIndex = 2,hideColumns = "")
public class SwqxQwSheet implements Serializable {

    @ExcelCell(order = 0)
    private Integer orderIndex;

    /*年份*/
    @ExcelCell(order = 1)
    private String year;

    /*最大值*/
    @ExcelCell(order = 2)
    private Double maxval;

    /*最大值时间*/
    @ExcelCell(order = 3)
    private String maxtm;

    /*最小值*/
    @ExcelCell(order = 4)
    private Double minval;

    /*最小值时间*/
    @ExcelCell(order = 5)
    private String mintm;

    /*变幅*/
    @ExcelCell(order = 6)
    private Double bf;

    /*平均值*/
    @ExcelCell(order = 7)
    private Double avgval;

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

    public Double getMaxval() {
        return maxval;
    }

    public void setMaxval(Double maxval) {
        this.maxval = maxval;
    }

    public String getMaxtm() {
        return maxtm;
    }

    public void setMaxtm(String maxtm) {
        this.maxtm = maxtm;
    }

    public Double getMinval() {
        return minval;
    }

    public void setMinval(Double minval) {
        this.minval = minval;
    }

    public String getMintm() {
        return mintm;
    }

    public void setMintm(String mintm) {
        this.mintm = mintm;
    }

    public Double getBf() {
        return bf;
    }

    public void setBf(Double bf) {
        this.bf = bf;
    }

    public Double getAvgval() {
        return avgval;
    }

    public void setAvgval(Double avgval) {
        this.avgval = avgval;
    }
}


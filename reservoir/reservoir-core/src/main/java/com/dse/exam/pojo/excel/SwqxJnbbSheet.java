package com.dse.exam.pojo.excel;

import org.wxd.excel.annotation.ExcelCell;
import org.wxd.excel.annotation.ExcelSheet;

import java.io.Serializable;

/**
 * Created by pc on 2017-6-29.
 */

@ExcelSheet(name = "水文气象-季年报表",beginReadRowIndex = 2,beginWriteRowIndex = 2,hideColumns = "")
public class SwqxJnbbSheet implements Serializable {

    @ExcelCell(order = 0)
    private Integer orderIndex;

    /*项目*/
    @ExcelCell(order = 1)
    private String name;

    /*单位*/
    @ExcelCell(order = 2)
    private String unit;

    /*最大值*/
    @ExcelCell(order = 3)
    private Double maxval;

    /*最大值日期*/
    @ExcelCell(order = 4)
    private String maxtm;

    /*最小值*/
    @ExcelCell(order = 5)
    private Double minval;

    /*最小值日期*/
    @ExcelCell(order = 6)
    private String mintm;

    /*最后一天测值*/
    @ExcelCell(order = 7)
    private Double lastval;

    /*历史最大值*/
    @ExcelCell(order = 8)
    private Double lsmaxval;

    /*历史最大值日期*/
    @ExcelCell(order = 9)
    private String lsmaxtm;

    /*历史最小值*/
    @ExcelCell(order = 10)
    private Double lsminval;

    /*历史最小值日期*/
    @ExcelCell(order = 11)
    private String lsmintm;

    /*历史最后一天测试*/
    @ExcelCell(order = 12)
    private Double lslastval;

    /*参考值*/
    @ExcelCell(order = 13)
    private Double ckz;

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public Double getLastval() {
        return lastval;
    }

    public void setLastval(Double lastval) {
        this.lastval = lastval;
    }

    public Double getLsmaxval() {
        return lsmaxval;
    }

    public void setLsmaxval(Double lsmaxval) {
        this.lsmaxval = lsmaxval;
    }

    public String getLsmaxtm() {
        return lsmaxtm;
    }

    public void setLsmaxtm(String lsmaxtm) {
        this.lsmaxtm = lsmaxtm;
    }

    public Double getLsminval() {
        return lsminval;
    }

    public void setLsminval(Double lsminval) {
        this.lsminval = lsminval;
    }

    public String getLsmintm() {
        return lsmintm;
    }

    public void setLsmintm(String lsmintm) {
        this.lsmintm = lsmintm;
    }

    public Double getLslastval() {
        return lslastval;
    }

    public void setLslastval(Double lslastval) {
        this.lslastval = lslastval;
    }

    public Double getCkz() {
        return ckz;
    }

    public void setCkz(Double ckz) {
        this.ckz = ckz;
    }
}

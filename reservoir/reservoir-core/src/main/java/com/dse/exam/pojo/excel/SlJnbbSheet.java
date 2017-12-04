package com.dse.exam.pojo.excel;

import org.wxd.excel.annotation.ExcelCell;
import org.wxd.excel.annotation.ExcelSheet;

import java.io.Serializable;

/**
 * @Author Dongshf
 * @Date 2017/6/29
 */
@ExcelSheet(name = "渗流-季年报表",beginReadRowIndex = 2,beginWriteRowIndex = 2,hideColumns = "")
public class SlJnbbSheet implements Serializable {

    @ExcelCell(order = 0)
    private Integer orderIndex;

    /*项目*/
    @ExcelCell(order = 1)
    private String stnm;

    /*单位*/
    @ExcelCell(order = 2)
    private String unit;

    /**
     * 本季（年）度监测情况
     */
    /*最大值*/
    @ExcelCell(order = 3)
    private Double maxdata;

    /*最大值日期*/
    @ExcelCell(order = 4)
    private String maxtm;

    /*最小值*/
    @ExcelCell(order = 5)
    private Double mindata;

    /*最小值日期*/
    @ExcelCell(order = 6)
    private String mintm;

    /*最后一天测值*/
    @ExcelCell(order = 7)
    private Double lastdata;

    /**
     *历史监测情况
     */
    /*历史最大值*/
    @ExcelCell(order = 8)
    private Double lsmaxdata;

    /*历史最大值日期*/
    @ExcelCell(order = 9)
    private String lsmaxtm;

    /*历史最小值*/
    @ExcelCell(order = 10)
    private Double lsmindata;

    /*历史最小值日期*/
    @ExcelCell(order = 11)
    private String lsmintm;


    /*参考值*/
    @ExcelCell(order = 12)
    private Double ckz;


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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getMaxdata() {
        return maxdata;
    }

    public void setMaxdata(Double maxdata) {
        this.maxdata = maxdata;
    }

    public String getMaxtm() {
        return maxtm;
    }

    public void setMaxtm(String maxtm) {
        this.maxtm = maxtm;
    }


    public String getMintm() {
        return mintm;
    }

    public void setMintm(String mintm) {
        this.mintm = mintm;
    }

    public String getLsmaxtm() {
        return lsmaxtm;
    }

    public void setLsmaxtm(String lsmaxtm) {
        this.lsmaxtm = lsmaxtm;
    }

    public String getLsmintm() {
        return lsmintm;
    }

    public void setLsmintm(String lsmintm) {
        this.lsmintm = lsmintm;
    }

    public Double getMindata() {
        return mindata;
    }

    public void setMindata(Double mindata) {
        this.mindata = mindata;
    }

    public Double getLastdata() {
        return lastdata;
    }

    public void setLastdata(Double lastdata) {
        this.lastdata = lastdata;
    }

    public Double getLsmaxdata() {
        return lsmaxdata;
    }

    public void setLsmaxdata(Double lsmaxdata) {
        this.lsmaxdata = lsmaxdata;
    }

    public Double getLsmindata() {
        return lsmindata;
    }

    public void setLsmindata(Double lsmindata) {
        this.lsmindata = lsmindata;
    }

    public Double getCkz() {
        return ckz;
    }

    public void setCkz(Double ckz) {
        this.ckz = ckz;
    }
}

package com.dse.exam.pojo.excel;

import org.wxd.excel.annotation.ExcelCell;
import org.wxd.excel.annotation.ExcelSheet;

import java.io.Serializable;

/**
 * @Author Dongshf
 * @Date 2017/6/30
 */

@ExcelSheet(name = "水平位移-多年平均特征值",beginReadRowIndex = 2,beginWriteRowIndex = 2,hideColumns = "")
public class SpwytzzSheet implements Serializable {

    @ExcelCell(order = 0)
    private Integer orderIndex;

    /*测点*/
    @ExcelCell(order = 1)
    private String stnm;

    /**
     * 最大值(向下游最大值)
     */

    /*数值(mm)*/
    @ExcelCell(order = 2)
    private Double maxdata;

    /*发生日期*/
    @ExcelCell(order = 3)
    private String maxtm;

    /**
     * 最小值(向上游最大值)
     */

     /*数值(mm)*/
    @ExcelCell(order = 4)
    private Double mindata;

    /*发生日期*/
    @ExcelCell(order = 5)
    private String mintm;

    /*变幅(mm)*/
    @ExcelCell(order = 6)
    private Double bf;

    /*平均值(mm)*/
    @ExcelCell(order = 7)
    private Double avgdata;


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

    public Double getMindata() {
        return mindata;
    }

    public void setMindata(Double mindata) {
        this.mindata = mindata;
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

    public Double getAvgdata() {
        return avgdata;
    }

    public void setAvgdata(Double avgdata) {
        this.avgdata = avgdata;
    }
}

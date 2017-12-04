package com.dse.exam.pojo.excel;

import org.wxd.excel.annotation.ExcelCell;
import org.wxd.excel.annotation.ExcelSheet;

import java.io.Serializable;

/**
 * @Author Dongshf
 * @Date 2017/6/30
 */

@ExcelSheet(name = "东改工程-多年平均特征值报表",beginReadRowIndex = 2,beginWriteRowIndex = 2,hideColumns = "")
public class DggctzzSheet implements Serializable {

    @ExcelCell(order = 0)
    private Integer orderIndex;

    /*测点*/
    @ExcelCell(order = 1)
    private String stnm;

    /*单位*/
    @ExcelCell(order = 2)
    private String UNIT;

    /**
     * 最高水位
     */

    /*数值(mm)*/
    @ExcelCell(order = 3)
    private Double maxdata;

    /*出现日期*/
    @ExcelCell(order = 4)
    private String maxtm;

    /**
     * 最低水位
     */
     /*数值(mm)*/
    @ExcelCell(order = 5)
    private Double mindata;

    /*出现日期*/
    @ExcelCell(order = 6)
    private String mintm;

    /*变幅(mm)*/
    @ExcelCell(order = 7)
    private Double bf;

    /*平均值(mm)*/
    @ExcelCell(order = 8)
    private Double avgdata;


    public Integer getOrderIndex() {
        return orderIndex;
    }

    public String getUNIT() {
        return UNIT;
    }

    public void setUNIT(String UNIT) {
        this.UNIT = UNIT;
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

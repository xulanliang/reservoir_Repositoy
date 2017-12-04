package com.dse.exam.pojo.excel;

import org.wxd.excel.annotation.ExcelCell;
import org.wxd.excel.annotation.ExcelParam;
import org.wxd.excel.annotation.ExcelSheet;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zhoujc on 2017/3/17.
 */
@ExcelSheet(name = "水文气象-观测记录表",beginReadRowIndex = 2,beginWriteRowIndex = 2,hideColumns = "")
public class ASheet implements Serializable {

    @ExcelCell(order = 0)
    private Integer orderIndex;

    /*项目*/
    @ExcelCell(order = 1)
    private String xm;

    /*水库水位*/
    @ExcelCell(order = 2)
    private String rz;

    /*降雨量*/
    @ExcelCell(order = 3)
    private String dyp;

    /*气压*/
    @ExcelCell(order = 4)
    private String airp;

    /*气温*/
    @ExcelCell(order = 5)
    private String atmp;

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
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

    public String getAirp() {
        return airp;
    }

    public void setAirp(String airp) {
        this.airp = airp;
    }

    public String getAtmp() {
        return atmp;
    }

    public void setAtmp(String atmp) {
        this.atmp = atmp;
    }
}

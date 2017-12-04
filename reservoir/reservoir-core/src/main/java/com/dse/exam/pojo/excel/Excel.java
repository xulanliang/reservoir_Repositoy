package com.dse.exam.pojo.excel;

import com.dse.exam.pojo.excel.dggc.*;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * 导入导出的Excel
 * @Author Dongshf
 * @Date 2017/6/28
 */
public class Excel implements Serializable {


    private List<ASheet> asheets = Lists.newArrayList();

    private List<SwqxJnbbSheet> jnsheets = Lists.newArrayList();

    private List<SwqxQwSheet> qwsheets = Lists.newArrayList();

    private List<SwqxSwSheet> swsheets = Lists.newArrayList();

    private List<SwqxYlSheet> ylsheets = Lists.newArrayList();

    //渗流观测记录表
    private List<SlGcjlbSheet> slGcjlbSheets = Lists.newArrayList();

    //渗流季年报表
    private List<SlJnbbSheet> slJnbbSheets = Lists.newArrayList();

    //渗压观测记录表
    private List<SyGcjlbSheet> syGcjlbSheets = Lists.newArrayList();

    //渗压季年报表
    private List<SyJnbbSheet> syJnbbSheets = Lists.newArrayList();

    //渗压特征值报表
    private  List<SyTzzbbSheet> syTzzbbSheets= Lists.newArrayList();

    //水平位移多年平均特征值
    private  List<SpwytzzSheet> spwytzzSheets= Lists.newArrayList();

    //垂直位移多年平均特征值
    private  List<CzwytzzSheet> czwytzzSheets= Lists.newArrayList();

    //水位观测记录表
    private List<SwGcjlbSheet> swGcjlbSheets = Lists.newArrayList();

    //水位季年报表
    private List<SwJnbbSheet> swJnbbSheets = Lists.newArrayList();

    //水位多年平均特征值
    private  List<SwtzzSheet> swtzzSheets= Lists.newArrayList();

    //深层位移观测记录表
    private  List<ScwyGcjlbSheet> scwyGcjlbSheets= Lists.newArrayList();

    //深层位移季年报表
    private  List<ScwyJnbbSheet> scwyJnbbSheets= Lists.newArrayList();

    //深层位移多年平均特征值
    private  List<ScwytzzSheet> scwytzzSheets= Lists.newArrayList();

    //渡槽沉降观测记录表
    private  List<DccjGcjlbSheet> dccjGcjlbSheets= Lists.newArrayList();

    //渡槽沉降季年报表
    private  List<DccjJnbbSheet> dccjJnbbSheets= Lists.newArrayList();

    //渡槽沉降多年平均特征值
    private  List<DccjtzzSheet> dccjtzzSheets= Lists.newArrayList();

    private List<BjcxSheet> bjcxSheets = Lists.newArrayList() ;

    public List<DggctzzSheet> getDggctzzSheet() {
        return dggctzzSheet;
    }

    public void setDggctzzSheet(List<DggctzzSheet> dggctzzSheet) {
        this.dggctzzSheet = dggctzzSheet;
    }

    private List<DggctzzSheet> dggctzzSheet = Lists.newArrayList() ;


    public List<ASheet> getAsheets() {
        return asheets;
    }

    public void setAsheets(List<ASheet> asheets) {
        this.asheets = asheets;
    }

    public List<SlGcjlbSheet> getSlGcjlbSheets() {
        return slGcjlbSheets;
    }

    public void setSlGcjlbSheets(List<SlGcjlbSheet> slGcjlbSheets) {
        this.slGcjlbSheets = slGcjlbSheets;
    }

    public List<SwqxJnbbSheet> getJnsheets() {
        return jnsheets;
    }

    public void setJnsheets(List<SwqxJnbbSheet> jnsheets) {
        this.jnsheets = jnsheets;
    }

    public List<SwqxQwSheet> getQwsheets() {
        return qwsheets;
    }

    public void setQwsheets(List<SwqxQwSheet> qwsheets) {
        this.qwsheets = qwsheets;
    }

    public List<SwqxSwSheet> getSwsheets() {
        return swsheets;
    }

    public void setSwsheets(List<SwqxSwSheet> swsheets) {
        this.swsheets = swsheets;
    }

    public List<SwqxYlSheet> getYlsheets() {
        return ylsheets;
    }

    public void setYlsheets(List<SwqxYlSheet> ylsheets) {
        this.ylsheets = ylsheets;
    }

    public List<SlJnbbSheet> getSlJnbbSheets() {
        return slJnbbSheets;
    }

    public void setSlJnbbSheets(List<SlJnbbSheet> slJnbbSheets) {
        this.slJnbbSheets = slJnbbSheets;
    }

    public List<SyTzzbbSheet> getSyTzzbbSheets() {
        return syTzzbbSheets;
    }

    public void setSyTzzbbSheets(List<SyTzzbbSheet> syTzzbbSheets) {
        this.syTzzbbSheets = syTzzbbSheets;
    }

    public List<SyJnbbSheet> getSyJnbbSheets() {
        return syJnbbSheets;
    }

    public void setSyJnbbSheets(List<SyJnbbSheet> syJnbbSheets) {
        this.syJnbbSheets = syJnbbSheets;
    }


    public List<SyGcjlbSheet> getSyGcjlbSheets() {
        return syGcjlbSheets;
    }

    public void setSyGcjlbSheets(List<SyGcjlbSheet> syGcjlbSheets) {
        this.syGcjlbSheets = syGcjlbSheets;
    }

    public List<SpwytzzSheet> getSpwytzzSheets() {
        return spwytzzSheets;
    }

    public void setSpwytzzSheets(List<SpwytzzSheet> spwytzzSheets) {
        this.spwytzzSheets = spwytzzSheets;
    }

    public List<CzwytzzSheet> getCzwytzzSheets() {
        return czwytzzSheets;
    }

    public void setCzwytzzSheets(List<CzwytzzSheet> czwytzzSheets) {
        this.czwytzzSheets = czwytzzSheets;
    }

    public List<SwGcjlbSheet> getSwGcjlbSheets() {
        return swGcjlbSheets;
    }

    public void setSwGcjlbSheets(List<SwGcjlbSheet> swGcjlbSheets) {
        this.swGcjlbSheets = swGcjlbSheets;
    }

    public List<SwJnbbSheet> getSwJnbbSheets() {
        return swJnbbSheets;
    }

    public void setSwJnbbSheets(List<SwJnbbSheet> swJnbbSheets) {
        this.swJnbbSheets = swJnbbSheets;
    }

    public List<SwtzzSheet> getSwtzzSheets() {
        return swtzzSheets;
    }

    public void setSwtzzSheets(List<SwtzzSheet> swtzzSheets) {
        this.swtzzSheets = swtzzSheets;
    }

    public List<ScwyGcjlbSheet> getScwyGcjlbSheets() {
        return scwyGcjlbSheets;
    }

    public void setScwyGcjlbSheets(List<ScwyGcjlbSheet> scwyGcjlbSheets) {
        this.scwyGcjlbSheets = scwyGcjlbSheets;
    }

    public List<ScwyJnbbSheet> getScwyJnbbSheets() {
        return scwyJnbbSheets;
    }

    public void setScwyJnbbSheets(List<ScwyJnbbSheet> scwyJnbbSheets) {
        this.scwyJnbbSheets = scwyJnbbSheets;
    }

    public List<ScwytzzSheet> getScwytzzSheets() {
        return scwytzzSheets;
    }

    public void setScwytzzSheets(List<ScwytzzSheet> scwytzzSheets) {
        this.scwytzzSheets = scwytzzSheets;
    }

    public List<DccjGcjlbSheet> getDccjGcjlbSheets() {
        return dccjGcjlbSheets;
    }

    public void setDccjGcjlbSheets(List<DccjGcjlbSheet> dccjGcjlbSheets) {
        this.dccjGcjlbSheets = dccjGcjlbSheets;
    }

    public List<DccjJnbbSheet> getDccjJnbbSheets() {
        return dccjJnbbSheets;
    }

    public void setDccjJnbbSheets(List<DccjJnbbSheet> dccjJnbbSheets) {
        this.dccjJnbbSheets = dccjJnbbSheets;
    }

    public List<DccjtzzSheet> getDccjtzzSheets() {
        return dccjtzzSheets;
    }

    public void setDccjtzzSheets(List<DccjtzzSheet> dccjtzzSheets) {
        this.dccjtzzSheets = dccjtzzSheets;
    }

    public List<BjcxSheet> getBjcxSheets() {
        return bjcxSheets;
    }

    public void setBjcxSheets(List<BjcxSheet> bjcxSheets) {
        this.bjcxSheets = bjcxSheets;
    }
}

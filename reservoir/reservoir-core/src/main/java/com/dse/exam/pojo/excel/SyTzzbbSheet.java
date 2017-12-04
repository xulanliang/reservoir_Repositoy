package com.dse.exam.pojo.excel;

import org.wxd.excel.annotation.ExcelCell;
import org.wxd.excel.annotation.ExcelSheet;

import java.io.Serializable;

/**
 * @Author Dongshf
 * @Date 2017/6/30
 */
    @ExcelSheet(name = "渗压-渗压特征值报表",beginReadRowIndex = 2,beginWriteRowIndex = 2,hideColumns = "")
    public class SyTzzbbSheet implements Serializable{

        @ExcelCell(order = 0)
        private Integer orderIndex;

        /*部位*/
        @ExcelCell(order = 1)
        private String PROJ_NM;

        /*测点编号*/
        @ExcelCell(order = 2)
        private String stnm;

        /**
         * 最高渗压水位
         */

        /*数值(m)*/
        @ExcelCell(order = 3)
        private Double maxdata;

        /*对应日期*/
        @ExcelCell(order = 4)
        private String maxtm;

        /*当日上游水位*/
        @ExcelCell(order = 5)
        private Double maxrz;

        /*当日气温*/
        @ExcelCell(order = 6)
        private Double maxatmp;

        /*当日降雨*/
        @ExcelCell(order = 7)
        private Double maxdyp;

        /**
         * 最低渗压水位
         */

        /*数值(m)*/
        @ExcelCell(order = 8)
        private Double mindata;

        /*对应日期*/
        @ExcelCell(order = 9)
        private String mintm;


        /*当日上游水位*/
        @ExcelCell(order = 10)
        private Double minrz;

        /*当日气温*/
        @ExcelCell(order = 11)
        private Double minatmp;

        /*当日降雨*/
        @ExcelCell(order = 12)
        private Double mindyp;


        /*变幅(m)*/
        @ExcelCell(order = 13)
        private Double bf;

        /*平均值(m)*/
        @ExcelCell(order = 14)
        private Double avgdata;


        public Integer getOrderIndex() {
            return orderIndex;
        }

        public void setOrderIndex(Integer orderIndex) {
            this.orderIndex = orderIndex;
        }

        public String getPROJ_NM() {
            return PROJ_NM;
        }

        public void setPROJ_NM(String PROJ_NM) {
            this.PROJ_NM = PROJ_NM;
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

        public Double getMaxrz() {
            return maxrz;
        }

        public void setMaxrz(Double maxrz) {
            this.maxrz = maxrz;
        }

        public Double getMaxatmp() {
            return maxatmp;
        }

        public void setMaxatmp(Double maxatmp) {
            this.maxatmp = maxatmp;
        }

        public Double getMaxdyp() {
            return maxdyp;
        }

        public void setMaxdyp(Double maxdyp) {
            this.maxdyp = maxdyp;
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

        public Double getMinrz() {
            return minrz;
        }

        public void setMinrz(Double minrz) {
            this.minrz = minrz;
        }

        public Double getMinatmp() {
            return minatmp;
        }

        public void setMinatmp(Double minatmp) {
            this.minatmp = minatmp;
        }

        public Double getMindyp() {
            return mindyp;
        }

        public void setMindyp(Double mindyp) {
            this.mindyp = mindyp;
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

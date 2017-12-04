package com.dse.exam.pojo.excel;

/**
 * Created by zhoujc on 2017/3/17.
 */
public class ExcelHelp {

    @org.wxd.excel.annotation.Excel
    private Excel excel;

    public Excel getExcel() {
        return excel;
    }

    public void setExcel(Excel excel) {
        this.excel = excel;
    }
}

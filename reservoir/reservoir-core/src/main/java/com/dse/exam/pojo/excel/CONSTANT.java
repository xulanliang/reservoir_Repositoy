package com.dse.exam.pojo.excel;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhoujc on 2017/2/22.
 */
public class CONSTANT {

    /*附件上传地址*/
    public static final String FILEPATH = "D:"+ File.separator+"examfile"+File.separator;

    /*文件模板地址*/
    public static final String EXCEL_TEMPLATE_DIR_PATH = /*File.separator + */"excel" + File.separator + "excelTemplate" + File.separator;

    public static final String EXCEL_TEMPLATE_NAME = "examExcel.xlsx";

    /*临时文件存放地址*/
    public static final String TEMP_DIR_PATH = File.separator + "excel" + File.separator + "temp" + File.separator;


    public static final Map<String, String> EXCEL_SHEET_NAME = new HashMap<String, String>() {
        private static final long serialVersionUID = -8164653884996984485L;
        {
//            put("a", "考核办法");
            put("SL_GCJLB", "渗流-观测记录表");
//            put("d", "年度目标");
//            put("e", "通报考核结果-自查分数");
//            put("f", "通报考核结果-最终分数");
        }
    };
    /*public static final Map<String, Class> EXCEL_SHEET_CLASS = new HashMap<String, Class>() {
        private static final long serialVersionUID = -8164653884996984485L;
        {
//            put("a", ASheet.class);
            put("SL_GCJLB", BSheet.class);
//            put("d", DSheet.class);
//            put("e", ESheet.class);
//            put("f", FSheet.class);
        }
    };*/
    
}

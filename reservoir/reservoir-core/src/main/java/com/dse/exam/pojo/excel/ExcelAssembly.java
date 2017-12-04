package com.dse.exam.pojo.excel;

import com.alibaba.fastjson.JSON;
import com.dse.exam.pojo.excel.dggc.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Dongshf
 * @Date 2017/6/27
 */
public class ExcelAssembly {

    public static ExcelHelp request2Excel(String exportType,List<Object> rows) throws Exception{
        ExcelHelp excelHelp = new ExcelHelp();
        switch (exportType) {
            case "水文气象-观测记录表":
                excelHelp.setExcel(request2ExcelA(exportType,rows));
                break;
            case "水文气象-季年报表":
                excelHelp.setExcel(request2ExcelJn(exportType,rows));
                break;
            case "水文气象-气温特征值报表":
                excelHelp.setExcel(request2ExcelQw(exportType,rows));
                break;
            case "水文气象-水位特征值报表":
                excelHelp.setExcel(request2ExcelSw(exportType,rows));
                break;
            case "水文气象-雨量特征值报表":
                excelHelp.setExcel(request2ExcelYl(exportType,rows));
                break;
            case "渗流-观测记录表":
                excelHelp.setExcel(request2ExcelSlGcjlb(exportType,rows));
                break;
            case "渗流-季年报表":
                excelHelp.setExcel(request2ExcelSlJnbb(exportType,rows));
                break;
            case "渗压-观测记录表":
                excelHelp.setExcel(request2ExcelSyGcjlb(exportType,rows));
                break;
            case "渗压-季年报表":
                excelHelp.setExcel(request2ExcelSyJnbb(exportType,rows));
                break;
            case "渗压-渗压特征值报表":
                excelHelp.setExcel(request2ExcelSyTzzbb(exportType,rows));
                break;
            case "水平位移-多年平均特征值":
                excelHelp.setExcel(request2ExcelSpwytzz(exportType,rows));
                break;
            case "垂直位移-多年平均特征值":
                excelHelp.setExcel(request2ExcelCzwytzz(exportType,rows));
                break;
            case "水位-观测记录表":
                excelHelp.setExcel(request2ExcelSwGcjlb(exportType,rows));
                break;
            case "水位-季年报表":
                excelHelp.setExcel(request2ExcelSwJnbb(exportType,rows));
                break;
            case "水位-多年平均特征值":
                excelHelp.setExcel(request2ExcelSwtzz(exportType,rows));
                break;
            case "东改工程-多年平均特征值报表":
                excelHelp.setExcel(request2ExcelDggctzz(exportType,rows));
                break;
            case "深层位移-观测记录表":
                excelHelp.setExcel(request2ExcelScwyGcjlb(exportType,rows));
                break;
            case "深层位移-季年报表":
                excelHelp.setExcel(request2ExcelScwyJnbb(exportType,rows));
                break;
            case "深层位移-多年平均特征值":
                excelHelp.setExcel(request2ExcelScwytzz(exportType,rows));
                break;
            case "渡槽沉降-观测记录表":
                excelHelp.setExcel(request2ExcelDccjGcjlb(exportType,rows));
                break;
            case "渡槽沉降-季年报表":
                excelHelp.setExcel(request2ExcelDccjJnbb(exportType,rows));
                break;
            case "渡槽沉降-多年平均特征值":
                excelHelp.setExcel(request2ExcelDccjtzz(exportType,rows));
                break;
            case "报警查询报表":
                excelHelp.setExcel(request2ExcelBjxc(exportType,rows));
                break;
            default:
                break;
        }
        return excelHelp;
    }

    private static Excel request2ExcelA(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<ASheet> aSheets = new ArrayList<ASheet>();
        for (int i = 0; i < rows.size(); i++){
            ASheet aSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),ASheet.class);
            aSheet.setOrderIndex(i + 1);
            aSheets.add(aSheet);
        }
        excel.setAsheets(aSheets);
        return excel;
    }

    private static Excel request2ExcelSlGcjlb(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<SlGcjlbSheet> slGcjlbSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            SlGcjlbSheet slGcjlbSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),SlGcjlbSheet.class);
            slGcjlbSheet.setOrderIndex(i + 1);
            slGcjlbSheets.add(slGcjlbSheet);
        }
        excel.setSlGcjlbSheets(slGcjlbSheets);
        return excel;
    }

    private static Excel request2ExcelJn(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<SwqxJnbbSheet> jnSheets = new ArrayList<SwqxJnbbSheet>();
        for (int i = 0; i < rows.size(); i++){
            SwqxJnbbSheet jnSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),SwqxJnbbSheet.class);
            jnSheet.setOrderIndex(i + 1);
            jnSheets.add(jnSheet);
        }
        excel.setJnsheets(jnSheets);
        return excel;
    }

    private static Excel request2ExcelQw(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<SwqxQwSheet> aSheets = new ArrayList<SwqxQwSheet>();
        for (int i = 0; i < rows.size(); i++){
            SwqxQwSheet aSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),SwqxQwSheet.class);
            aSheet.setOrderIndex(i + 1);
            aSheet.setAvgval(new BigDecimal(aSheet.getAvgval()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            aSheets.add(aSheet);
        }
        excel.setQwsheets(aSheets);
        return excel;
    }

    private static Excel request2ExcelSw(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<SwqxSwSheet> aSheets = new ArrayList<SwqxSwSheet>();
        for (int i = 0; i < rows.size(); i++){
            SwqxSwSheet aSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),SwqxSwSheet.class);
            aSheet.setOrderIndex(i + 1);
            aSheet.setAvgval(new BigDecimal(aSheet.getAvgval()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            aSheets.add(aSheet);
        }
        excel.setSwsheets(aSheets);
        return excel;
    }

    private static Excel request2ExcelYl(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<SwqxYlSheet> aSheets = new ArrayList<SwqxYlSheet>();
        for (int i = 0; i < rows.size(); i++){
            SwqxYlSheet aSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),SwqxYlSheet.class);
            aSheet.setOrderIndex(i + 1);
            aSheets.add(aSheet);
        }
        excel.setYlsheets(aSheets);
        return excel;
    }


    private static Excel request2ExcelSlJnbb(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<SlJnbbSheet> slJnbbSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            SlJnbbSheet slJnbbSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),SlJnbbSheet.class);
            slJnbbSheet.setOrderIndex(i + 1);
            slJnbbSheets.add(slJnbbSheet);
        }
        excel.setSlJnbbSheets(slJnbbSheets);
        return excel;
    }

    private static Excel request2ExcelSyGcjlb(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<SyGcjlbSheet> syGcjlbSheets = new ArrayList<SyGcjlbSheet>();
        for (int i = 0; i < rows.size(); i++){
            SyGcjlbSheet syGcjlbSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),SyGcjlbSheet.class);
            syGcjlbSheet.setOrderIndex(i + 1);
            syGcjlbSheets.add(syGcjlbSheet);
        }
        excel.setSyGcjlbSheets(syGcjlbSheets);
        return excel;
    }


    private static Excel request2ExcelSyJnbb(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<SyJnbbSheet> syJnbbSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            SyJnbbSheet syJnbbSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),SyJnbbSheet.class);
            syJnbbSheet.setOrderIndex(i + 1);
            syJnbbSheets.add(syJnbbSheet);
        }
        excel.setSyJnbbSheets(syJnbbSheets);
        return excel;
    }


    private static Excel request2ExcelSyTzzbb(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<SyTzzbbSheet> syTzzbbSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            SyTzzbbSheet syTzzbbSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),SyTzzbbSheet.class);
            syTzzbbSheet.setOrderIndex(i + 1);
            syTzzbbSheet.setAvgdata(new BigDecimal(syTzzbbSheet.getAvgdata()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            syTzzbbSheets.add(syTzzbbSheet);
        }
        excel.setSyTzzbbSheets(syTzzbbSheets);
        return excel;
    }



    private static Excel request2ExcelSpwytzz(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<SpwytzzSheet> spwytzzSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            SpwytzzSheet spwytzzSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),SpwytzzSheet.class);
            spwytzzSheet.setOrderIndex(i + 1);
            spwytzzSheet.setAvgdata(new BigDecimal(spwytzzSheet.getAvgdata()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            spwytzzSheets.add(spwytzzSheet);
        }
        excel.setSpwytzzSheets(spwytzzSheets);
        return excel;
    }


    private static Excel request2ExcelCzwytzz(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<CzwytzzSheet> czwytzzSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            CzwytzzSheet czwytzzSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),CzwytzzSheet.class);
            czwytzzSheet.setOrderIndex(i + 1);
            czwytzzSheet.setAvgdata(new BigDecimal(czwytzzSheet.getAvgdata()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            czwytzzSheets.add(czwytzzSheet);
        }
        excel.setCzwytzzSheets(czwytzzSheets);
        return excel;
    }


    private static Excel request2ExcelSwGcjlb(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<SwGcjlbSheet> swGcjlbSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            SwGcjlbSheet swGcjlbSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),SwGcjlbSheet.class);
            swGcjlbSheet.setOrderIndex(i + 1);
            swGcjlbSheets.add(swGcjlbSheet);
        }
        excel.setSwGcjlbSheets(swGcjlbSheets);
        return excel;
    }

    private static Excel request2ExcelSwJnbb(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<SwJnbbSheet> swJnbbSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            SwJnbbSheet swJnbbSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),SwJnbbSheet.class);
            swJnbbSheet.setOrderIndex(i + 1);
            swJnbbSheets.add(swJnbbSheet);
        }
        excel.setSwJnbbSheets(swJnbbSheets);
        return excel;
    }


    private static Excel request2ExcelSwtzz(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<SwtzzSheet> swtzzSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            SwtzzSheet swtzzSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),SwtzzSheet.class);
            swtzzSheet.setOrderIndex(i + 1);
            swtzzSheet.setAvgdata(new BigDecimal(swtzzSheet.getAvgdata()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            swtzzSheets.add(swtzzSheet);
        }
        excel.setSwtzzSheets(swtzzSheets);
        return excel;
    }

    private static Excel request2ExcelDggctzz(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<DggctzzSheet> swtzzSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            DggctzzSheet swtzzSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),DggctzzSheet.class);
            swtzzSheet.setOrderIndex(i + 1);
            if(swtzzSheet.getAvgdata() != null){
                swtzzSheet.setAvgdata(new BigDecimal(swtzzSheet.getAvgdata()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
            swtzzSheets.add(swtzzSheet);
        }
        excel.setDggctzzSheet(swtzzSheets);
        return excel;
    }


    private static Excel request2ExcelScwyGcjlb(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<ScwyGcjlbSheet> scwyGcjlbSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            ScwyGcjlbSheet scwyGcjlbSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),ScwyGcjlbSheet.class);
            scwyGcjlbSheet.setOrderIndex(i + 1);
            scwyGcjlbSheets.add(scwyGcjlbSheet);
        }
        excel.setScwyGcjlbSheets(scwyGcjlbSheets);
        return excel;
    }


    private static Excel request2ExcelScwyJnbb(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<ScwyJnbbSheet> scwyJnbbSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            ScwyJnbbSheet scwyJnbbSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),ScwyJnbbSheet.class);
            scwyJnbbSheet.setOrderIndex(i + 1);
            scwyJnbbSheets.add(scwyJnbbSheet);
        }
        excel.setScwyJnbbSheets(scwyJnbbSheets);
        return excel;
    }

    private static Excel request2ExcelScwytzz(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<ScwytzzSheet> scwytzzSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            ScwytzzSheet scwytzzSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),ScwytzzSheet.class);
            scwytzzSheet.setOrderIndex(i + 1);
            scwytzzSheet.setAvgdata(new BigDecimal(scwytzzSheet.getAvgdata()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            scwytzzSheets.add(scwytzzSheet);
        }
        excel.setScwytzzSheets(scwytzzSheets);
        return excel;
    }


    private static Excel request2ExcelDccjGcjlb(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<DccjGcjlbSheet> dccjGcjlbSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            DccjGcjlbSheet dccjGcjlbSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),DccjGcjlbSheet.class);
            dccjGcjlbSheet.setOrderIndex(i + 1);
            dccjGcjlbSheets.add(dccjGcjlbSheet);
        }
        excel.setDccjGcjlbSheets(dccjGcjlbSheets);
        return excel;
    }

    private static Excel request2ExcelDccjJnbb(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<DccjJnbbSheet> dccjJnbbSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            DccjJnbbSheet dccjJnbbSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),DccjJnbbSheet.class);
            dccjJnbbSheet.setOrderIndex(i + 1);
            dccjJnbbSheets.add(dccjJnbbSheet);
        }
        excel.setDccjJnbbSheets(dccjJnbbSheets);
        return excel;
    }

    private static Excel request2ExcelDccjtzz(String exportType,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<DccjtzzSheet> dccjtzzSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            DccjtzzSheet dccjtzzSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),DccjtzzSheet.class);
            dccjtzzSheet.setOrderIndex(i + 1);
            dccjtzzSheet.setAvgdata(new BigDecimal(dccjtzzSheet.getAvgdata()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            dccjtzzSheets.add(dccjtzzSheet);
        }
        excel.setDccjtzzSheets(dccjtzzSheets);
        return excel;
    }

    private static Excel request2ExcelBjxc(String exportType ,List<Object> rows) throws Exception{
        Excel excel = new Excel();
        List<BjcxSheet> bjcxSheets = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++){
            BjcxSheet bjcxSheet = JSON.parseObject(JSON.toJSONString(rows.get(i)),BjcxSheet.class);
            bjcxSheet.setOrderIndex(i+1);
           // bjcxSheet.set
            bjcxSheets.add(bjcxSheet);
        }
        excel.setBjcxSheets(bjcxSheets);
        return excel;
    }

    public static List<String> buildSheetTitle(String exportType) throws Exception{
        List<String> sheetTitles = new ArrayList<String>();
        sheetTitles.add(exportType);
        return sheetTitles;
    }

}

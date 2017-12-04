package com.dse.exam.web;

import com.alibaba.fastjson.JSONObject;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.common.util.FileUtil;
import com.dse.common.util.StringUtil;
import com.dse.exam.CONSTANT;
import com.dse.exam.pojo.excel.ExcelAssembly;
import com.google.common.collect.Maps;
import com.google.common.io.Closer;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.wxd.excel.handler.export.DefaultExportHandler;
import org.wxd.excel.handler.inport.DefaultEntityHandler;
import org.wxd.excel.utils.ExcelUtil;
import org.wxd.excel.utils.ExportFatory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhoujc on 2017/3/15.
 */
@Controller
@RequestMapping("/excelController")
public class ExcelController {

    private static Logger logger = Logger.getLogger(ExcelController.class);

    /**
     * 导出Excel
     */
    @RequestMapping(value = "exportExcel", method = {RequestMethod.POST})
    @ResponseBody
    public InvokeResult exportExcel(HttpServletRequest request) throws IOException{
        String exportType = request.getParameter("exportType");
        String data = request.getParameter("rows");
        List<Object> rows = JSONObject.parseArray(data);
        BufferedOutputStream out = null;
        try {
            String contextPath = request.getSession().getServletContext().getRealPath("/");
            File template = new File(contextPath + CONSTANT.EXCEL_TEMPLATE_DIR_PATH + CONSTANT.EXCEL_TEMPLATE_NAME);
            String resultFilePath = CONSTANT.TEMP_DIR_PATH;
            if (!new File(contextPath + resultFilePath).exists()) new File(contextPath + resultFilePath).mkdirs();
            resultFilePath +=  UUID.randomUUID() + ".xlsx";
            File resultFile = new File(contextPath + resultFilePath);
            Closer closer = Closer.create();
            out = closer.register(new BufferedOutputStream(new FileOutputStream(resultFile)));
            /*下载模板导出*/
            Workbook workbook = ExcelUtil.buildWorkbookFromEntityOfFile(
                                                ExcelAssembly.request2Excel(exportType,rows),
                                                ExcelAssembly.buildSheetTitle(exportType),
                                                template,
                                                new DefaultExportHandler()
                                                );
            workbook.write(out);
            out.close();
            return InvokeResult.success(resultFilePath,new InvokeResultMessage("生成Excel成功"));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return InvokeResult.failure(new InvokeResultMessage("生成Excel发生异常"));
        }finally {
            if(out != null){
                out.close();
            }
        }
    }




//    @RequestMapping(value = "exportExcels", method = {RequestMethod.POST})
//    @ResponseBody
//    public InvokeResult exportExcels(@RequestBody List<ExcelRequest> exportRequests, HttpServletRequest request) throws IOException{
//        try {
//            String contextPath = request.getSession().getServletContext().getRealPath("/");
//            File template = new File(contextPath + CONSTANT.EXCEL_TEMPLATE_DIR_PATH + CONSTANT.EXCEL_TEMPLATE_NAME);
//            String resultFilePath = CONSTANT.TEMP_DIR_PATH;
//            if (!new File(contextPath + resultFilePath).exists()) new File(contextPath + resultFilePath).mkdirs();
//            resultFilePath +=  UUID.randomUUID() + ".xlsx";
//            File resultFile = new File(contextPath + resultFilePath);
//            Closer closer = Closer.create();
//            BufferedOutputStream out = closer.register(new BufferedOutputStream(new FileOutputStream(resultFile)));
//            /*下载模板导出*/
//            Workbook workbook = ExcelUtil.buildWorkbookFromEntityOfFile(
//                    ExcelAssembly.request2Excels(exportRequests),
//                    ExcelAssembly.buildSheetTitle(exportRequests),
//                    template,
//                    new DefaultExportHandler()
//            );
//            workbook.write(out);
//            out.close();
//            return InvokeResult.success(resultFilePath,new InvokeResultMessage("生成Excel成功"));
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage());
//            return InvokeResult.failure(new InvokeResultMessage("生成Excel发生异常"));
//        }finally {
//
//        }
//    }

//    /**
//     * 导入Excel
//     * @param exportType
//     * @param file
//     * @param request
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/importExcel")
//    @ResponseBody
//    public InvokeResult importExcel( String exportType, @RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        try {
//            String contextPath = request.getSession().getServletContext().getRealPath("/");
//            File tempFile = new File(contextPath + CONSTANT.TEMP_DIR_PATH + UUID.randomUUID()  + ".xlsx");
//            String tempDirPath = contextPath + CONSTANT.TEMP_DIR_PATH;
//            if (!new File(tempDirPath).exists()) new File(tempDirPath).mkdirs();
//            file.transferTo(tempFile);
//
//            Workbook workbook = ExportFatory.buildWorkbookOfTemplate(tempFile);
//            HashMap result = Maps.newHashMap();
//            ExportFatory.buildEntityExecutor()
//                    .register((new DefaultEntityHandler()).registerAll(Arrays.asList(CONSTANT.EXCEL_SHEET_CLASS.get(exportType))))
//                    .handler(workbook, result, null);
//
//
////            Map<String, List<Object>> result = ExcelUtil.readExcelToEntityAsMap(
////                                                                    tempFile,
////                                                                    Arrays.asList(CONSTANT.EXCEL_SHEET_CLASS.get(exportType))
////                                                                    );
//            if (tempFile.exists()) tempFile.delete();
//            return InvokeResult.success(ExcelAssembly.buildExcelRequest(result),new InvokeResultMessage("导入Excel数据成功"));
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage());
//            return InvokeResult.failure(new InvokeResultMessage("导入Excel数据成功"));
//        }
//    }


    /**
     * 下载文件
     * @param request
     * @param response
     */
    @RequestMapping(value = "/downExcel", method = RequestMethod.GET)
    public void downExcel(HttpServletRequest request, HttpServletResponse response,@RequestParam String exportId) {
        try {
            String filePath = request.getSession().getServletContext().getRealPath("/") + exportId;
            String shortName= request.getParameter("shortName");
            System.err.println(this.getClass().getName()+">>>   filePath:"+ filePath+"  exportId:"+exportId +" shortName: "+shortName );
            /*
            if(StringUtil.isNotEmpty(shortName)){
                String str1=URLDecoder.decode(shortName, FileUtil.ENCODE_NAME_UTF_8);
                String str2= new String(shortName.getBytes("gb2312"), FileUtil.ENCODE_NAME_ISO);
                String str3= URLDecoder.decode(shortName, "GBK");
                String str4= new String(shortName.getBytes("ISO8859-1"), FileUtil.ENCODE_NAME_ISO);
                System.err.println(this.getClass().getName()+"  >>>>>>>>>>>>> str1: "+str1+" str2: "+str2+" str3:"+str3+" str4:"+str4);
            }
            */
            shortName= URLDecoder.decode(shortName, FileUtil.ENCODE_NAME_UTF_8);
            System.err.println(" encode1  shortName1:"+shortName);
            FileUtil.downLoadOfPath(request, response, filePath, shortName);
            File file = new File(filePath);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

//    @RequestMapping(value = "/downloadExcelOfDynamic", method = RequestMethod.POST)
//    @ResponseBody
//    public InvokeResult exportExcelOfDynamic(@RequestBody ExcelOfDynamicRequest edr,
//                                       HttpServletRequest request,HttpServletResponse response){
//        try {
//            String contextPath = request.getSession().getServletContext().getRealPath("/");
//            String tempfileName = UUID.randomUUID() + ".xlsx";
//            StringBuilder tempFilePath = new StringBuilder(contextPath).append(CONSTANT.EXCEL_TEMPLATE_DIR_PATH);
//            File parenFile = new File(tempFilePath.toString());
//            if(!parenFile.exists()){
//                parenFile.mkdirs();
//            }
//            String[] heads = edr.getHeads();
//            String[] colStyle = edr.getColStyle();
//            GenerateExcel.setColWidthBySelfForJson(edr.getWidthJson());
//            boolean flag = GenerateExcel.generateExcel(edr.getTitle(),edr.getSheetName(),
//                    heads,colStyle,edr.getData(),tempFilePath.append(tempfileName).toString());
//            if(flag){
//                return InvokeResult.success(CONSTANT.EXCEL_TEMPLATE_DIR_PATH+tempfileName,new InvokeResultMessage("导入Excel数据成功"));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            logger.error(e.getMessage());
//        }
//        return InvokeResult.failure(new InvokeResultMessage("导入Excel数据失败"));
//    }
//
//    @RequestMapping(value = "/importExcelForSelf", method = RequestMethod.POST)
//    @ResponseBody
//    public InvokeResult importExcelForSelf( @RequestParam("file") MultipartFile file,ExcelOfImportRequest eoir,
//                                    HttpServletRequest request, HttpServletResponse response){
//        InputStream inputStream = null;
//        Object obj = null;
//        try {
//            inputStream = file.getInputStream();
//            obj = GenerateExcel.parseExcel(eoir.getStartRowNum(),eoir.getShowCol(),inputStream);
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage());
//        }finally {
//            if(inputStream != null){
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return InvokeResult.success(obj,new InvokeResultMessage(null == obj ? "导入Excel数据失败" : "导入Excel数据成功"));
//    }


    /**
     * 下载文件 http://www.cnblogs.com/Damon-Luo/p/5919656.html
     * http://www.open-open.com/lib/view/open1437203159990.html
     *
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/downExcel2", method = RequestMethod.GET)
    public void downExcel2(HttpServletRequest request, HttpServletResponse response) {
        try {
//            String filePath = request.getSession().getServletContext().getRealPath("/") + exportId;
            // FileUtil.downLoadOfPath(request, response, filePath, shortName);
            //创建HSSFWorkbook对象(excel的文档对象)
            HSSFWorkbook wkb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
            HSSFSheet sheet=wkb.createSheet("成绩表");
//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
            HSSFRow row1=sheet.createRow(0);
//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
            HSSFCell cell=row1.createCell(0);
            //设置单元格内容
            cell.setCellValue("学员考试成绩一览表");
//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
            sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));

//在sheet里创建第二行
            HSSFRow row2=sheet.createRow(1);
            //创建单元格并设置单元格内容
            row2.createCell(0).setCellValue("姓名");
            row2.createCell(1).setCellValue("班级");
            row2.createCell(2).setCellValue("笔试成绩");
            row2.createCell(3).setCellValue("机试成绩");
            //在sheet里创建第三行
            HSSFRow row3=sheet.createRow(2);
            row3.createCell(0).setCellValue("李明");
            row3.createCell(1).setCellValue("As178");
            row3.createCell(2).setCellValue(87);
            row3.createCell(3).setCellValue(78);
            //.....省略部分代码
            HSSFRow r3=sheet.createRow(3);
            r3.createCell(0);
            r3.createCell(1);
            r3.createCell(2);
            r3.createCell(3);
            r3.createCell(4);

            HSSFRow r4=sheet.createRow(4);
            r4.createCell(0);
            r4.createCell(1);
            r4.createCell(2).setCellValue("学员考试成绩一览表");
            r4.createCell(3);
            r4.createCell(4);

            HSSFRow r5=sheet.createRow(5);
            r5.createCell(0);
            r5.createCell(1);
            r5.createCell(2);
            r5.createCell(3);
            r5.createCell(4);
//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
            sheet.addMergedRegion(new CellRangeAddress(4,5,0,1));
           sheet.addMergedRegion(new CellRangeAddress(4,5,3,4));

//输出Excel文件
            OutputStream output=response.getOutputStream();
            response.reset();
//            response.setHeader("Content-disposition", "attachment; filename="+exportId+".xls");
            response.setContentType("application/msexcel");
            wkb.write(output);
            output.close();
            //File file = new File(filePath);
            //file.delete();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }



    /**
     * poi读取Excel数据信息 http://www.cnblogs.com/Damon-Luo/p/5919656.html
     * http://www.open-open.com/lib/view/open1437203159990.html
     *http://www.open-open.com/lib/view/open1437203159990.html
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/readExcel", method = RequestMethod.GET)
    public void readExcel(HttpServletRequest request, HttpServletResponse response,@RequestParam String exportId,@RequestParam String shortName) {
        try {
            //String filePath = request.getSession().getServletContext().getRealPath("/") + exportId;
            String filePath = "F:\\水工安全监测综合管理\\6.人工变形观测项目常用报表--已修改\\6.人工变形观测项目常用报表--已修改\\桥头部\\莲湖泵站垂直位移观测记录表.xls";
            //判断是否为excel类型文件
            if(!filePath.endsWith(".xls")&&!filePath.endsWith(".xlsx")){
                System.out.println("文件不是excel类型");
            }
            FileInputStream fis =null;
            Workbook wookbook = null;
            try{
                //获取一个绝对地址的流
                fis = new FileInputStream(filePath);
            }catch(Exception e){
                e.printStackTrace();
            }
            try{
                //2003版本的excel，用.xls结尾
                wookbook = new HSSFWorkbook(fis);//得到工作簿
            }catch (Exception ex) {
                //ex.printStackTrace();
                try
                {
                    //2007版本的excel，用.xlsx结尾
                    wookbook = new XSSFWorkbook(fis);//得到工作簿
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            //得到一个工作表
            Sheet sheet = wookbook.getSheetAt(1);
            //获得表头
            Row rowHead = sheet.getRow(0);
            //判断表头是否正确
//            if(rowHead.getPhysicalNumberOfCells() != 3)
//            {
//                System.out.println("表头的数量不对!");
//            }
            //获得数据的总行数
            int totalRowNum = sheet.getLastRowNum();
            //要获得属性
            String stcd = "";
            String tm = "";
            double origdata = 0;
            //获得所有数据
            int i = 6;
            for(i = 6 ; i <= totalRowNum ; i++)
            {
                //获得第i行对象
                Row row = sheet.getRow(i);
                //获得获得第i行第0列的 String类型对象
                Cell cell = row.getCell((short)0);
                if(cell!=null) {
                    stcd = cell.getStringCellValue().toString();
                }
                //获得一个数字类型的数据
 //               cell = row.getCell((short)1);
//                latitude = (int) cell.getNumericCellValue();
//                System.out.println("名字："+name+",经纬度："+latitude);

                cell = row.getCell((short)3);
                if(cell!=null){
                    origdata = cell.getNumericCellValue();
                }
                System.out.println(" 测点： stcd:"+stcd+" origdata:"+origdata);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    /**
     * poi读取Excel数据信息 http://www.cnblogs.com/Damon-Luo/p/5919656.html
     * http://www.open-open.com/lib/view/open1437203159990.html
     *http://www.open-open.com/lib/view/open1437203159990.html
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/readExcel2", method = RequestMethod.GET)
    public void readExcel2(HttpServletRequest request, HttpServletResponse response,@RequestParam String exportId,@RequestParam String shortName) {
        try {
            //String filePath = request.getSession().getServletContext().getRealPath("/") + exportId;
            String filePath = "F:\\水工安全监测综合管理\\6.人工变形观测项目常用报表--已修改\\6.人工变形观测项目常用报表--已修改\\桥头部\\莲湖泵站垂直位移观测记录表.xls";
            //判断是否为excel类型文件
            if(!filePath.endsWith(".xls")&&!filePath.endsWith(".xlsx")){
                System.out.println("文件不是excel类型");
            }
            FileInputStream fis =null;
            Workbook wookbook = null;
            try{
                //获取一个绝对地址的流
                fis = new FileInputStream(filePath);
            }catch(Exception e){
                e.printStackTrace();
            }
            try{
                //2003版本的excel，用.xls结尾
                wookbook = new HSSFWorkbook(fis);//得到工作簿
            }catch (Exception ex) {
                //ex.printStackTrace();
                try
                {
                    //2007版本的excel，用.xlsx结尾
                    wookbook = new XSSFWorkbook(fis);//得到工作簿
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            //得到一个工作表
            Sheet sheet = wookbook.getSheetAt(1);
            //获得表头
            Row rowHead = sheet.getRow(0);
            //判断表头是否正确
//            if(rowHead.getPhysicalNumberOfCells() != 3)
//            {
//                System.out.println("表头的数量不对!");
//            }
            //获得数据的总行数
            int totalRowNum = sheet.getLastRowNum();
            //要获得属性
            String stcd = "";
            String tm = "";
            double origdata = 0;
            //获得所有数据
            int i = 6;
            for(i = 6 ; i <= totalRowNum ; i++)
            {
                //获得第i行对象
                Row row = sheet.getRow(i);
                //获得获得第i行第0列的 String类型对象
                Cell cell = row.getCell((short)0);
                if(cell!=null) {
                    stcd = cell.getStringCellValue().toString();
                }
                //获得一个数字类型的数据
                //               cell = row.getCell((short)1);
//                latitude = (int) cell.getNumericCellValue();
//                System.out.println("名字："+name+",经纬度："+latitude);

                cell = row.getCell((short)3);
                if(cell!=null){
                    origdata = cell.getNumericCellValue();
                }
                System.out.println(" 测点： stcd:"+stcd+" origdata:"+origdata);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

}

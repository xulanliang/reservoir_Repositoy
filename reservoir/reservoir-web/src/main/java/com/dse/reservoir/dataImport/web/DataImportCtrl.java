package com.dse.reservoir.dataImport.web;

/**
 * Created by dse on 2017/8/16.
 */

import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.common.util.ConfigurationInfoUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.tableEdit.importData.service.DataImportService;
import com.dse.reservoir.api.tableEdit.pojo.CzwyjcxxModel;
import com.dse.reservoir.api.tableEdit.pojo.CzwyjcxxPK;
import com.dse.reservoir.api.zlgl.wdzl.UpOrDownLoadService;
import com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo.UpOrDownLoadModel;
import com.dse.reservoir.zlgl.wdzl.util.DseBeanUtils;
import com.dse.reservoir.zlgl.wdzl.util.DseJsonUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *  POE读取Excel数据导入到数据库中
 */
@Controller
@RequestMapping("/dataImportCtrl")
public class DataImportCtrl {
    private static Logger logger = Logger.getLogger(DataImportCtrl.class);

    @Autowired
    private UpOrDownLoadService service;

    @Autowired
    private DataImportService dataImportService;

    /**
     * poi读取Excel数据信息 http://www.cnblogs.com/Damon-Luo/p/5919656.html
     * http://www.open-open.com/lib/view/open1437203159990.html
     *http://www.open-open.com/lib/view/open1437203159990.html
     *
     * @param request
     * @param response
     */
//    try {
//        String dataStr=request.getParameter("dataStr");
//        return InvokeResult.success(rainLeverService.saveOrUpdateCzwyjcxxInfo(dataStr));
//    } catch (Exception e) {
//        return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
//    }
    @RequestMapping(value = "/readExcel")
    @ResponseBody
    public Object readExcel(String bid,HttpServletRequest request, HttpServletResponse response) {
        try {
            UpOrDownLoadModel model = this.getFilePath(bid);
            String filePath = ConfigurationInfoUtil.get("reservoir.properties","file.path")+ File.separator+model.getFilepath();
            //判断是否为excel文件
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

            //要获得属性
            String stcd = "";
            String stcdName="";
            Date tm =new Date(); //时间
            Integer qs=0;     //期数
            List listModel = new LinkedList();
            CzwyjcxxPK czwyjcxxPK = null;
            double origdata = 0;


            //获取有效的sheet
            for(int j=0;j<wookbook.getNumberOfSheets();j++){
                Sheet sheet= wookbook.getSheetAt(j);
                int rowNum=sheet.getLastRowNum();
                if(rowNum != 0){
//获得表头
                    Row rowHead = sheet.getRow(0);
                    //判断表头是否正确
//            if(rowHead.getPhysicalNumberOfCells() != 3)
//            {
//                System.out.println("表头的数量不对!");
//            }
                    //获得数据的总行数
                    int totalRowNum = sheet.getLastRowNum();

                    //获得所有数据
                    int i = 6;
                    for(i = 2 ; i <= totalRowNum ; i++)
                    {
                        //获得第i行对象
                        Row row = sheet.getRow(i);
                        //获得获得第i行第0列的 String类型对象
                        Cell cell = row.getCell((short)0);

                        if(cell!=null) {
                            if(i==2){
                                //获取期数
                                String time = row.getCell((short)3).getStringCellValue();
                                qs=Integer.parseInt(time.substring(time.indexOf("第")+1,time.indexOf("期")));
                                i=i+2;
                                continue;
                            }else if (i==5){
                                czwyjcxxPK=new CzwyjcxxPK();
                                Date str = row.getCell(3).getDateCellValue();
                                tm=str;

                                czwyjcxxPK.setQS(qs);
                                czwyjcxxPK.setTM(tm);
//                        str.getTime();
//                        //获取时间
////                        String ts =str.replace("/","-");
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                        tm=sdf.parse(formatter.format(str.getTime()));
                                continue;
                            }
                            stcdName = cell.getStringCellValue();
                            if(stcdName.equals("最大值")){
                                break;
                            }
                            czwyjcxxPK=new CzwyjcxxPK();
                            czwyjcxxPK.setQS(qs);
                            czwyjcxxPK.setTM(tm);

                            CzwyjcxxModel czwyjcxxModel =new CzwyjcxxModel();
                            List list =dataImportService.getModel(stcdName);
                            Map map= (Map) list.get(0);
                            stcd = map.get("STCD").toString();
                            czwyjcxxPK.setSTCD(stcd);
                            czwyjcxxModel.setId(czwyjcxxPK);

                            cell = row.getCell((short)3);
                            CzwyjcxxModel czModel = new CzwyjcxxModel();
                            origdata = cell.getNumericCellValue();
                            czwyjcxxModel.setORIGDATA(origdata);
                            czwyjcxxModel.setGATTYPE("1");
                            listModel.add(czwyjcxxModel);
                        }
                    }
                    //删除文件
                    service.deleteFileByBid(bid);
                }
            }

            //将数据保存到数据库
            return InvokeResult.success(dataImportService.saveCzwyjcxx(listModel));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


    @RequestMapping(value = "/getFilePath")
    public UpOrDownLoadModel getFilePath(String bid){
        UpOrDownLoadModel model = new UpOrDownLoadModel();
        List list=service.getInfoByBId(bid);
        DseBeanUtils.copyProperties(DseJsonUtil.parseToMap(DseJsonUtil.toJson(list.get(0)).toString()),model);
        return model;
    }
}

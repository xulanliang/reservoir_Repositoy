package com.dse.reservoir.api.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * Excel 导出公共类
 * @author  wangzy
 * @date 2017-9-21
 */
public class ExcelUtil {
	

	public static void exportExcel(String title, Map<String, Object> colMap,
			JSONArray dataJsonArray, String operator, OutputStream out, Boolean isReport){
		exportExcel(title, colMap, dataJsonArray, operator,out,isReport,false, null);
	}
	
	public static void exportExcel(String title, Map<String, Object> colMap,
			JSONArray dataJsonArray, String operator, OutputStream out, Boolean isReport, Map<String, Object> spanHeadMap){
		exportExcel(title, colMap, dataJsonArray, operator,out,isReport,false, spanHeadMap);
	}
	
	public static void exportExcel(String title, Map<String, Object> colMap,
			JSONArray dataJsonArray, String operator, OutputStream out, Boolean isReport,Boolean noIndex, Map<String, Object> spanHeadMap) {
		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet();
		//设置 序号 列宽度
		sheet.setColumnWidth(0,10 * 256);
		String tit = title.substring(0,5);
		//判断是否为防汛物资巡查
		if(tit.equals("水库-泵站")){
			sheet.setColumnWidth(1,40 * 256);
		}
		workbook.setSheetName(0, title.substring(0,title.indexOf(".")));
		sheet.setDefaultColumnWidth(18);

		Long maxRows = 10000L; // 默认最多能导出10000行

		if(dataJsonArray != null && dataJsonArray.size() > maxRows){
			HSSFRow row = sheet.createRow(0);
			HSSFCell titleCell = row.createCell(0);
			HSSFRichTextString textTitle = new HSSFRichTextString("excel导出条数不能超过" + maxRows + "行，请按条件筛选后再导出！");
			titleCell.setCellValue(textTitle);
		} else {
			// 标题样式
			HSSFCellStyle titleStyle = workbook.createCellStyle();
			titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
			titleStyle.setBorderBottom(HSSFCellStyle.BORDER_NONE);
			titleStyle.setBorderLeft(HSSFCellStyle.BORDER_NONE);
			titleStyle.setBorderTop(HSSFCellStyle.BORDER_NONE);
			titleStyle.setBorderRight(HSSFCellStyle.BORDER_NONE);
			titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			
			HSSFFont titleFont = workbook.createFont();
			titleFont.setFontHeightInPoints((short) 18);
			titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			titleStyle.setFont(titleFont);
			
			// 操作样式
			HSSFCellStyle operateStyle = workbook.createCellStyle();
			operateStyle.setBorderBottom(HSSFCellStyle.BORDER_NONE);
			operateStyle.setBorderLeft(HSSFCellStyle.BORDER_NONE);
			operateStyle.setBorderTop(HSSFCellStyle.BORDER_NONE);
			operateStyle.setBorderRight(HSSFCellStyle.BORDER_NONE);
			operateStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			
			HSSFFont operateFont = workbook.createFont();
			operateFont.setFontHeightInPoints((short) 12);
			operateFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			operateStyle.setFont(operateFont);
			
			// 表头样式
			HSSFCellStyle headStyle = workbook.createCellStyle();
			headStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			headStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			headStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			headStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	
			HSSFFont boldFont = workbook.createFont();
			HSSFFont boldFontt = workbook.createFont();
			boldFont.setFontHeightInPoints((short) 12);
			boldFontt.setFontHeightInPoints((short) 12);
			boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			boldFontt.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			headStyle.setFont(boldFont);
			
			// 合并单元格样式
			HSSFCellStyle mergeStyle = workbook.createCellStyle();
			mergeStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			mergeStyle.setFont(boldFontt);
	
			// 文字样式
			HSSFCellStyle style2 = workbook.createCellStyle();
			style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
//			style2.setBorderBottom((short) 1);
//			style2.setBorderLeft((short) 1);
//			style2.setBorderTop((short) 1);
//			style2.setBorderRight((short) 1);
			style2.setAlignment(HSSFCellStyle.VERTICAL_CENTER);
			//设置单元格自动换行
			style2.setWrapText(true);

			HSSFFont font2 = workbook.createFont();
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			style2.setFont(font2);
	
			HSSFFont font3 = workbook.createFont();
			font3.setColor(HSSFColor.BLUE.index);
	
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
//			HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
//					0, 0, 0, (short) 4, 2, (short) 6, 5));
//			comment.setString(new HSSFRichTextString("可以在POI中添加注释"));
//			comment.setAuthor("hengxin");
			
			// 偶数行样式
			HSSFCellStyle evenStyle = workbook.createCellStyle();
			evenStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			evenStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			evenStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			evenStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			evenStyle.setAlignment(HSSFCellStyle.VERTICAL_CENTER);
			//设置自动换行
			evenStyle.setWrapText(true);

//			evenStyle.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
//			evenStyle.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
//			evenStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			
			HSSFFont evenFont = workbook.createFont();
			evenFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			evenStyle.setFont(evenFont);
			
			// 统计行样式
			HSSFCellStyle reportStyle = workbook.createCellStyle();
			reportStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
			reportStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			reportStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
			
			int cols = colMap.size();
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, cols));
			//sheet.addMergedRegion(new CellRangeAddress(, 0, 1, (short)cols));
			// 1、生成表格标题
			HSSFRow row = sheet.createRow(0);
			HSSFCell titleCell = row.createCell(0);
			titleCell.setCellStyle(titleStyle);
			String sheetTitle = title.substring(0,title.indexOf("."));
			HSSFRichTextString textTitle = new HSSFRichTextString(sheetTitle);
			titleCell.setCellValue(sheetTitle);
			
			// 2、生成导出时间和操作员
			row = sheet.createRow(2);
			HSSFCell operatorCell = row.createCell(0);
			operatorCell.setCellStyle(operateStyle);
			String dateStr = DateUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss");
			String operateStr = "导出时间：" + dateStr /*+ "  " + "操作员: " + operator*/;
			HSSFRichTextString operateText = new HSSFRichTextString(operateStr);
			operatorCell.setCellValue(operateText);
			
			// 生成大表头
			if(spanHeadMap != null){
				row = sheet.createRow(3);
				Iterator<Entry<String, Object>> it = spanHeadMap.entrySet().iterator();
				int span = 0;
				while (it.hasNext()) {
					Entry<String, Object> entry = it.next();
					String key = entry.getKey();
					int spanVal = Integer.valueOf(entry.getValue().toString());
					if(spanVal > 1){
						sheet.addMergedRegion(new CellRangeAddress(3, 3, span, span + spanVal - 1));
					}
					HSSFCell cell1 = row.createCell(span);
					HSSFRichTextString headerText = new HSSFRichTextString(key);
					cell1.setCellValue(headerText);
					cell1.setCellStyle(mergeStyle);
					span += spanVal;
				}
			}
			
			Map headerMap = new HashMap();
			// 1、生成表头
			row = sheet.createRow(spanHeadMap == null ? 3 : 4);
			List<String> keyList = new ArrayList<String>();
			if (colMap != null) {
				Iterator<Entry<String, Object>> it = colMap.entrySet().iterator();
				HSSFCell cell = row.createCell(0);
				cell.setCellStyle(headStyle);
				HSSFRichTextString headerText = new HSSFRichTextString("序号");
				int i = 1;
				if(!noIndex){//不设置序号列
					cell.setCellValue(headerText);
				}else{
					i=0;
				}
				while (it.hasNext()) {
					Entry<String, Object> entry = it.next();
					String key = entry.getKey();
					String header = entry.getValue().toString();
					if(Utility.isNotEmpty(header) && header.indexOf("全部")  != -1 && header.indexOf("已全部开票") == -1){
						header = header.substring(0, header.indexOf("全部"));
					}
					if(Utility.isNotEmpty(header) && header.indexOf("已全部开票")  != -1){
						header = "已全部开票";
					}
					keyList.add(key);
					cell = row.createCell(i);
					i++;
					cell.setCellStyle(headStyle);
					headerText = new HSSFRichTextString(header);
					cell.setCellValue(headerText);
					if(!noIndex){//不设置序号列
						headerMap.put(i-2, header);
					}else{
						headerMap.put(i-1, header);
					}
				}
			}
			
			// 2、生成内容
			if (dataJsonArray != null && dataJsonArray.size() > 0) {
				for (int i = 0, size = dataJsonArray.size(); i < size; i++) {
					HSSFCell cell ;
					row = sheet.createRow(i + (spanHeadMap == null ? 4 : 5));
					JSONObject jsonObject = dataJsonArray.getJSONObject(i);
					if(!noIndex){//不设置序号列
						if(!(isReport &&  i == (dataJsonArray.size() - 1))){
							// 单元格样式处理
							cell = row.createCell(0);
							cell.setCellValue(i + 1);
							if(i%2 == 0){
								cell.setCellStyle(style2);
							} else {
								cell.setCellStyle(evenStyle);
							}
						}else {
							cell = row.createCell(0);
							cell.setCellValue("");
							cell.setCellStyle(reportStyle);
						}
					}

					for (int col = 0, colnum = keyList.size(); col < colnum; col++) {
						int createCellIndex = col+1;
						if(noIndex){//不设置序号列
							createCellIndex=col;
						}
						cell = row.createCell(createCellIndex);
						String key = keyList.get(col);
						String cellValue = "";
						Object cellObject;
						int dotLen = 2; // 小数位数
						String defaultValue = "";
						//判断是否为数字类型
						boolean numFlag = false;
						if(key.indexOf("#") != -1){
							// 如果是指定了小数位数
							String[] keys = key.split("#");
							key = keys[0];
							dotLen = Integer.valueOf(keys[1]);
						}
						if(key.indexOf("&") != -1){
							// 如果指定了默认值
							String[] keys = key.split("&");
							defaultValue = keys[1];
							key = keys[0];
							if("0".equals(defaultValue)){
								defaultValue = "0.00";
							}
						}
						SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
						if(key.indexOf("@") != -1){
							fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String[] keys = key.split("@");
							key = keys[0];
						}
						if(key.indexOf("!")!=-1){
							fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
							String[] keys = key.split("!");
							key = keys[0];
						}
						if(key.indexOf(":") != -1) {
							String[] keys = key.split(":");
							key = keys[0];
							numFlag = true;
						}
						if(key.indexOf(".") !=-1){
							String[] keys;
							if (key.indexOf("*") !=-1) {
								String[] tempKeys = key.split("[*]");
								keys = tempKeys[0].split("[.]");
							} else {
								keys = key.split("[.]");
							}
							cellValue = jsonObject.getJSONObject(keys[0]).getString(keys[1]);
							cellObject = jsonObject.getJSONObject(keys[0]).get(keys[1]);
						} else {
							cellValue = jsonObject.getString(key);
							cellObject = jsonObject.get(key);
						}
						if(cellObject instanceof Double || (cellObject instanceof BigDecimal )){
							// 如果是double类型的，则默认保留两位小数
							cellValue = String.format("%." + dotLen + "f", Double.valueOf(cellValue));
							numFlag =true;
						}

						if(cellObject==null){
							cellValue = "";
						}

						if (key.indexOf("$") != -1) {
							key =key.substring(0, key.indexOf("$"));
							cellValue = jsonObject.getString(key);
							/*if (cellValue!=null && String.valueOf(Constants.VALID_VALUE).equals(cellValue)) {
								cellValue = "√";
							} else if (cellValue!=null && String.valueOf(Constants.DELETE_VALUE).equals(cellValue)) {
								cellValue = "";
							}*/
						}

						if(key.indexOf("~") != -1) {
						}

						if(!Utility.isEmpty(cellValue)){

	    					try {
	    						if (key.indexOf("*") == -1) {
	    							cellValue = fmt.format(fmt.parse(cellValue));
	    						}
	    					} catch (ParseException e) {

	    					}
						} else {
							// 最后如果是统计行则不需要处理
							/*if(!(isReport && (i == size - 1))){
								Boolean EXCEL_NO_DEFAULT_VALUE = jsonObject.getBoolean(Constants.EXCEL_NO_DEFAULT_VALUE);
								if(EXCEL_NO_DEFAULT_VALUE!=null&&EXCEL_NO_DEFAULT_VALUE){

								}else if(Utility.isEmpty(defaultValue)){
									Iterator it = defaultValueMapping.entrySet().iterator();
									String headerText = (String)headerMap.get(col);
									if(!Utility.isEmpty(headerText)){
										while(it.hasNext()){
											Entry entry = (Entry)it.next();
											String _key = (String)entry.getKey();
											String _value = (String)entry.getValue();
											if(headerText.indexOf(_key) !=-1&&!notContainMapping.containsKey(headerText.trim())){
												cellValue = _value;
												numFlag =true;
												break;
											}
										}
									}
								} else {
									cellValue = defaultValue;
								}
							}*/
						}
						if(numFlag){
							cell.setCellValue(Double.valueOf(cellValue));
						}else{
							cell.setCellValue(cellValue);
						}


						if(i%2 == 0){
							cell.setCellStyle(style2);
						} else {
							cell.setCellStyle(evenStyle);
						}
						/*Boolean isCellReport = jsonObject.getBoolean(Constants.IS_CELL_REPORT_STYLE);//当前行作为合计样式
						if(isCellReport!=null&&isCellReport){
							cell.setCellStyle(reportStyle);
						}else if(isReport && i == (dataJsonArray.size() - 1)){
							cell.setCellStyle(reportStyle);
						}*/

					}
				}
			}
		}

		// 3、输出表格
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void exportExcel(String title, Map<String, Object> colMap,
			List<Map<String, Object>> mapList, OutputStream out,String operator) {
		JSONArray dataArray = (JSONArray)JSONArray.toJSON(mapList);
		new ExcelUtil().exportExcel(title, colMap, dataArray, operator, out, false);
	}
	
	public static void exportExcel(String title, Map<String, Object> colMap,
			List<Map<String, Object>> mapList, OutputStream out,String operator,boolean isReport) {
		JSONArray dataArray = (JSONArray)JSONArray.toJSON(mapList);
		new ExcelUtil().exportExcel(title, colMap, dataArray, operator, out, isReport);
	}


}

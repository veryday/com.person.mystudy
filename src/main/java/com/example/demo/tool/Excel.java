package com.example.demo.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {

	/**
	 * 报表
	 * @param response
	 * @param excelInfo   用于设置sheetName 和excelName
	 * @param cellNameAndFieldName 用于设置需要导出的表格字段命名和类属性名
	 * @param dataList 数据集合
	 * @throws Exception
	 */
	public static void downloadExcel(HttpServletResponse response,Map<String,String> excelInfo,Map<String,String> cellNameAndFieldName,List dataList) throws Exception{
		//创建工作簿
		@SuppressWarnings("resource")
		HSSFWorkbook workBook=new HSSFWorkbook();
		//创建sheet
		HSSFSheet sheet=null;
		if(excelInfo.get("sheetName") == null ||excelInfo.get("sheetName")==""){
			 sheet=workBook.createSheet(""+System.currentTimeMillis());
		}else{
			 sheet=workBook.createSheet(excelInfo.get("sheetName"));
		}
		//导出文件名
		String fileName=null;
		if(excelInfo.get("excelName")==""||excelInfo.get("excelName")==null){
			 fileName=System.currentTimeMillis()+".xls";
		}else{
			if(excelInfo.get("excelName").endsWith(".xls")||excelInfo.get("excelName").endsWith(".xlsx")) {
				fileName=new String((excelInfo.get("excelName")).getBytes("GB2312"), "iso8859-1");
			}else{
				fileName=new String((excelInfo.get("excelName")).getBytes("GB2312"), "iso8859-1")+".xls";
			}
			 
		}
		//新增数据行，并设置单元格数
		int rowNum=1;
		//headers是sheet第一行的名称
		List<String> headerList=new ArrayList<String>();
		List<String> fieldList=new ArrayList<String>();
		for(Entry<String,String> entry:cellNameAndFieldName.entrySet()){
			headerList.add(entry.getKey());
			fieldList.add(entry.getValue());
		}
		//创建行已添加sheet添加行列名称
		HSSFRow row=sheet.createRow(0);
		//创建列
		HSSFCell cell=null;
		for(int i=0;i<headerList.size();i++){
			cell=row.createCell(i);
			cell.setCellValue(headerList.get(i));
		}
		//表中存放数据
		for(Object obj:dataList){
			HSSFRow row1=sheet.createRow(rowNum);
			List<String> fieldValueList=ClassInfo.getFieldValueByNames(fieldList, obj);
			int cellNum=0;
			for(String fieldValue:fieldValueList){
				row1.createCell(cellNum).setCellValue(fieldValue);
				cellNum++;
			}
			rowNum++;
		}
		
		//导出
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition","attachment;filename="+fileName);
		response.flushBuffer();
		workBook.write(response.getOutputStream());
	}
}

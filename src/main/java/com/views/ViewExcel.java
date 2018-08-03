package com.views;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractExcelView;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


@SuppressWarnings("deprecation")
public class ViewExcel extends AbstractExcelView   {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,  
        HSSFWorkbook workbook, HttpServletRequest request,  
        HttpServletResponse response) throws Exception {
		//获取日期
		Date now =new Date();//获取日期
		SimpleDateFormat data = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = data.format(now).toString()+".xls";  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/ms-excel");  
        response.setHeader("Content-Disposition", "inline; filename="+new String(fileName.getBytes(),"iso8859-1"));  
        OutputStream outputStream = response.getOutputStream();

        @SuppressWarnings("unchecked")
		List<Map<String, Object>> ExcelData =  (List<Map<String, Object>>) model.get("model");
        System.out.println(ExcelData.toString());
        for(Map<String, Object> sheet : ExcelData){
        	CreateSheet(workbook,sheet);
        }
        
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();  
    }  
	
	public void GetList(HSSFRow row,String[] list){
		int i = 0;
		for(String data : list){
        	row.createCell(i).setCellValue(data);
        	i++;
        }
	}
	
	public void CreateSheet(HSSFWorkbook workbook,Map<String, Object> model){
		// 新建工作表
        HSSFSheet sheet = workbook.createSheet((String) model.get("sheetName"));
        HSSFRow header = sheet.createRow(0);
        // 标题数据
		String[] DataTitles =  (String[]) model.get("DataTitle");
		GetList(header,DataTitles);
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyy"));
        int rowNumber = 1;
        //数据信息
        @SuppressWarnings("unchecked")
		List<String[]> DataLists = (List<String[]>) model.get("Data");    
		
        for (String[] list : DataLists) {
            HSSFRow row = sheet.createRow(rowNumber++);
            GetList(row,list);
        }
	}
}

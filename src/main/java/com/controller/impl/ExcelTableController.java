package com.controller.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.model.ExcelTable;
import com.model.SqlMessage;
import com.service.IExcelTableService;
import com.service.impl.SqlMessageService;

@Controller
@RequestMapping("/ExcelTable")
public class ExcelTableController {

	@Autowired
	private SqlMessageService sqlMessageService;
	
	@Autowired
	private IExcelTableService excelTableService;
	
	@RequestMapping("/AddExcelTable")
	@ResponseBody
	public String AddExcelTable(@RequestParam String SqlMessage,
							@RequestParam String TableName,
							@RequestParam String SqlText,
							@RequestParam String Memo,
							@RequestParam String CodeIcon,
							@RequestParam String DeptIcon,
							@RequestParam String StartDateIcon,
							@RequestParam String FinishDateIcon){
		SqlMessage SqlMessageDetial =  sqlMessageService.FindSqlMessage(SqlMessage);
		ExcelTable excelTable = new ExcelTable();
		excelTable.setTableName(TableName);
		excelTable.setSql(SqlText);
		excelTable.setMemo(Memo);
		excelTable.setCodeIcon(CodeIcon);
		excelTable.setDeptIcon(DeptIcon);
		excelTable.setStartDateIcon(StartDateIcon);
		excelTable.setFinishDateIcon(FinishDateIcon);
		excelTable.setSqlMessage(SqlMessageDetial);
		return excelTableService.AddExcelTable(excelTable)?"success":"error";
	}
	
	@RequestMapping("/FindExcelTables")
	@ResponseBody
	public List<ExcelTable> FindExcelTables(){
		//System.out.println(excelTableService.FindExcelTables());
		return excelTableService.FindExcelTables();
	}
	
	@RequestMapping(value="/Find")
	@ResponseBody
	public Map<String, Object> Find(String Code){
		return excelTableService.Find(Code);
	}
	
}

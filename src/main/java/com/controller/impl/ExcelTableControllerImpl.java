package com.controller.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.controller.IExcelTableController;
import com.model.ExcelTable;
import com.service.IExcelTableService;
import com.service.ISqlMessageService;


@RequestMapping("/ExcelTable")
public class ExcelTableControllerImpl extends BasicControllerImpl<ExcelTable> implements IExcelTableController{

	@SuppressWarnings("unused")
	@Autowired
	private ISqlMessageService sqlMessageService;
	
	@Autowired
	private IExcelTableService excelTableService;

	@RequestMapping(value="/FindAll",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindAll(String page, String limit) {
		return LayUiListFormat(excelTableService.FindAll());
	}

	@RequestMapping(value="/FindById",method=RequestMethod.POST)
	public ModelAndView FindById(Map<String, Object> Json) {
		return ForwardEditOrShow(Json);
	}

	@RequestMapping(value="/FindByKey",method=RequestMethod.POST)
	@ResponseBody
	public List<ExcelTable> FindByKey(String keyword) {
		return excelTableService.FindByKey(keyword);
	}

	@RequestMapping(value="/Del",method=RequestMethod.POST)
	@ResponseBody
	public String Del(String Id) {
		return LayuiFormatResult(excelTableService.DeleteById(Id));
	}

	public String Add(ExcelTable o) {
		return LayuiFormatResult(excelTableService.SaveOrEdit(o));
	}

	public ExcelTable FindById(String Id) {
		return excelTableService.FindById(Id);
	}
	
	
	
//	@RequestMapping("/AddExcelTable")
//	@ResponseBody
//	public String AddExcelTable(@RequestParam String SqlMessage,
//							@RequestParam String TableName,
//							@RequestParam String SqlText,
//							@RequestParam String Memo,
//							@RequestParam String CodeIcon,
//							@RequestParam String DeptIcon,
//							@RequestParam String StartDateIcon,
//							@RequestParam String FinishDateIcon){
//		SqlMessage SqlMessageDetial =  sqlMessageService.FindSqlMessage(SqlMessage);
//		ExcelTable excelTable = new ExcelTable();
//		excelTable.setTableName(TableName);
//		excelTable.setSql(SqlText);
//		excelTable.setMemo(Memo);
//		excelTable.setCodeIcon(CodeIcon);
//		excelTable.setDeptIcon(DeptIcon);
//		excelTable.setStartDateIcon(StartDateIcon);
//		excelTable.setFinishDateIcon(FinishDateIcon);
//		excelTable.setSqlMessage(SqlMessageDetial);
//		return excelTableService.AddExcelTable(excelTable)?"success":"error";
//	}
//	
//	@RequestMapping("/FindExcelTables")
//	@ResponseBody
//	public List<ExcelTable> FindExcelTables(){
//		//System.out.println(excelTableService.FindExcelTables());
//		return excelTableService.FindExcelTables();
//	}
//	
//	@RequestMapping(value="/Find")
//	@ResponseBody
//	public Map<String, Object> Find(String Code){
//		return excelTableService.Find(Code);
//	}
	
}

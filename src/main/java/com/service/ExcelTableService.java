package com.service;

import java.util.List;
import java.util.Map;

import com.model.ExcelTable;


public interface ExcelTableService extends BasicService<ExcelTable> {
	List<ExcelTable> FindExcelTables();
	List<Map<String, Object>> FindData(String ExceleTableId,String code,String Dept,String StartDate,String FinishDate);
}

package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelHelp {

	public static List<Map<String, Object>> ExcelModel(List<Map<String, Object>> Book,String SheetName,String[] DataTitle,List<String[]> Data){
		if(Book==null){
			Book = new ArrayList<Map<String,Object>>();
		}
		Map<String,Object> Sheet = new HashMap<String,Object>();
		Sheet.put("sheetName", SheetName);
		Sheet.put("DataTitle", DataTitle);
		Sheet.put("Data", Data);
		Book.add(Sheet);
		return Book;
	}
}

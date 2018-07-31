package com.repository.impl;

import com.model.ExcelTable;
import com.repository.IExcelTableRepository;

public class ExcelTableRepositoryImpl extends BasicRepositoryImpl<ExcelTable> implements IExcelTableRepository{
	
	/**public ExcelTable Find(String Id){
		String Hql = "from ExcelTable where Id='"+Id+"'";
		return FindByHql(Hql).get(0);
		
	}
	
	public List<ExcelTable> Find(){
		String Hql = "from ExcelTable";
		return FindByHql(Hql);
	}**/
}

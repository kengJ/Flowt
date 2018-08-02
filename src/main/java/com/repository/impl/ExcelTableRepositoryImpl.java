package com.repository.impl;

import org.springframework.stereotype.Repository;

import com.model.ExcelTable;
import com.repository.ExcelTableRepository;
@Repository(value="excelTableRepository")
public class ExcelTableRepositoryImpl extends BasicRepositoryImpl<ExcelTable> implements ExcelTableRepository{
	
	/**public ExcelTable Find(String Id){
		String Hql = "from ExcelTable where Id='"+Id+"'";
		return FindByHql(Hql).get(0);
		
	}
	
	public List<ExcelTable> Find(){
		String Hql = "from ExcelTable";
		return FindByHql(Hql);
	}**/
}

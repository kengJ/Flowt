package com.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.ExcelTable;

@Repository
public class ExcelTableRepository extends BasicRepository2<ExcelTable>{
	
	public ExcelTable Find(String Id){
		String Hql = "from ExcelTable where Id='"+Id+"'";
		return FindByHql(Hql).get(0);
		
	}
	
	public List<ExcelTable> Find(){
		String Hql = "from ExcelTable";
		return FindByHql(Hql);
	}
}

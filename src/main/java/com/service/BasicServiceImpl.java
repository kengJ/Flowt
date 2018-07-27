package com.service;

import java.util.List;

import com.repository.BasicRepository;

public class BasicServiceImpl<T> {
	
	private Class<T> entityClass;
	
	public BasicRepository<T> GetRepository(){
		return null;
	}

	public T FindById(String Id) {
		try {
			return GetRepository().FindByHql(String.format("from "+entityClass.getSimpleName()+" where Id = '%s'", Id)).get(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean Delete(T o) {
		try {
			GetRepository().Delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean DeleteById(String Id){
		T o = FindById(Id);
		if(o!=null){
			Delete(o);
			return true;
		}
		return false;
	}
	
	public List<T> FindByKey(String Sql){
		System.out.println(Sql);
		System.out.println(GetRepository());
		List<T> Data = GetRepository().FindByHql(Sql);
		return Data;
	}
}

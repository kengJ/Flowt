package com.service;

import java.util.List;

import com.repository.BasicRepository2;

public class BasicServiceImpl<T> implements BasicService<T>{
	
	private Class<T> entityClass;

	private String GetEntityClassName(){
		return this.entityClass.getSimpleName();
	}
	
	@Override
	public List<T> FindAll() {
		String Hql = "from "+GetEntityClassName();
		
		return null;
	}

	@Override
	public T FindById(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> FindByKey(String Key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Delete(T o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean SaveOrEdit(T o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**public BasicRepository<T> GetRepository(){
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
	}**/
}

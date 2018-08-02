package com.service.impl;

import java.util.List;
import com.repository.BasicRepository;
import com.service.BasicService;

public abstract class  BasicServiceImpl<T> implements BasicService<T>{
	
	private Class<T> entityClass;

	public abstract  BasicRepository<T> GetBasicRepository();
	
	@SuppressWarnings("unused")
	private String GetEntityClassName(){
		return this.entityClass.getSimpleName();
	}
	
	@Override
	public List<T> FindAll() {
		//String Hql = "from "+GetEntityClassName();
		return GetBasicRepository().FindAll();
	}

	@Override
	public T FindById(String Id) {
		return GetBasicRepository().Get(Id);
	}

	/**@Override
	public List<T> FindByKey(String Key) {
		return null;
	}**/

	@Override
	public boolean Delete(T o) {
		return GetBasicRepository().Delete(o);
	}

	@Override
	public boolean SaveOrEdit(T o) {
		try {
			GetBasicRepository().SaveOrUpdate(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean DeleteById(String Id) {
		T o = FindById(Id);
		return Delete(o);
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

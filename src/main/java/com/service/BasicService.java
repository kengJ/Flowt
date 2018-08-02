package com.service;

import java.util.List;

public interface BasicService<T> {

	/**boolean Add(T o);
	boolean Delete(T o);
	boolean Update(T o);
	List<T> FindAll();
	T FindById(String Id);
	boolean DeleteById(String Id);
	List<T> FindByKey(String Sql);**/

	List<T> FindAll();
	T FindById(String Id);
	List<T> FindByKey(String Key);
	boolean Delete(T o);
	boolean SaveOrEdit(T o);
	boolean DeleteById(String Id);
}

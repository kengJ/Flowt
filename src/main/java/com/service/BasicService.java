package com.service;

import java.util.List;

public interface BasicService<T> {

	boolean Add(T o);
	boolean Delete(T o);
	boolean Update(T o);
	List<T> FindAll();
	T FindById(String Id);
}

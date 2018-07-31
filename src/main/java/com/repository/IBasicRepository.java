package com.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IBasicRepository<T> {

	boolean Save(T o);
	boolean Delete(T o);
	boolean Update(T o);
	T Get(String id);
	boolean SaveOrUpdate(T o);
	List<T> FindAll();
	List<T> FindByHql(String Hql);
}

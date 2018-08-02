package com.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import com.repository.BasicRepository;

public class BasicRepositoryImpl<T> implements BasicRepository<T>{
	
	private Class<T> entityClass; 
	
	public Class<T> GetEntityClassName(){
		return entityClass;
	}
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Session getCurrentSession() {
        return hibernateTemplate.getSessionFactory().getCurrentSession();
	}
	
	public HibernateTemplate GetHibernateTemplate(){
		return this.hibernateTemplate;
	}
	
	public boolean Save(T o){
		try{
			hibernateTemplate.save(o);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean Delete(T o){
		try {
			hibernateTemplate.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean Update(T o){
		try{
			hibernateTemplate.update(o);
			//hibernateTemplate.flush();
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> FindByHql(String Hql){
		List<T> DataList = new ArrayList<T>(); 
		try {
			 Session session = getCurrentSession();
			 DataList = session.createQuery(Hql).list();
		} catch (Exception e) {
		}
		return DataList;
	}
	
	public T Get(String Id) {
		Long id = Long.parseLong(Id);
		return hibernateTemplate.get(entityClass, id);
	}
	
	public boolean SaveOrUpdate(T o){
		try {
			hibernateTemplate.saveOrUpdate(o);
			return true;
		} catch (DataAccessException e) {
			return false;
		}
		
	}


	@SuppressWarnings("unchecked")
	public List<T> FindAll() {
		//System.out.println(GetEntityClassName().getSimpleName());
		String ClassName = GetEntityClassName().getSimpleName();
		String Hql = "from "+ClassName;
		List<T> Data = null;
		Data = getCurrentSession().createQuery(Hql).list();
		return Data ;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BasicRepositoryImpl() {
		super();
		Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass =  (Class)params[0];
	}
	
}

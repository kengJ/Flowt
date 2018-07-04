package com.repository;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class BasicRepository<T> {
	
	@SuppressWarnings("unused")
	private Class<T> entityClass;  
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Session getCurrentSession() {
        return hibernateTemplate.getSessionFactory().getCurrentSession();
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
}

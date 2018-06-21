package com.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BasicRepository<T> {
	
	@SuppressWarnings("unused")
	private Class<T> entityClass;  
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//@Transactional(readOnly=true)
	private Session getCurrentSession() {
		
        return this.sessionFactory.getCurrentSession();
	}
	
	public boolean Save(T o){
		try{
			getCurrentSession().save(o);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean Delete(T o){
		try {
			getCurrentSession().delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean Update(T o){
		try{
			getCurrentSession().update(o);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> FindByHql(String Hql){
		 Session session = getCurrentSession();
		 return session.createQuery(Hql).list();
	}
}

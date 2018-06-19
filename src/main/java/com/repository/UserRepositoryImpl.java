package com.repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;


@Repository
public class UserRepositoryImpl extends BasicRepository<User> {

	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 private Session getCurrentSession() {
	        return this.sessionFactory.openSession();
	 }
	 
	 public Long addUser(User user) {
		 return (Long) getCurrentSession().save(user);
	 }
	 
	 
	 
	 
}

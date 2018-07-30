package com.repository;
import org.springframework.stereotype.Repository;

import com.model.User;


@Repository
public class UserRepositoryImpl extends BasicRepository2<User> {
	 
	 public Long addUser(User user) {
		 return (Long) getCurrentSession().save(user);
	 }
	 
	 
	 
	 
}

package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepositoryImpl;

@Service
public class UserService {

	@Autowired(required = true)
    private UserRepositoryImpl userRepositoryImpl;
	
	public Long Save() {
		User user = new User();
		user.setUserName("admin");
		user.setPassword("123456");
		return userRepositoryImpl.addUser(user);
	}
	
	public User Check(String UserName,String Password){
		return userRepositoryImpl.FindByHql("from User where UserName='"+UserName+"' and Password='"+Password+"'").get(0);
	}
}
	
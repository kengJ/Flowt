package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean AddUser(String UserName,String Password){
		try{
			userRepository.Save(new User(UserName, Password));
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean FindUserByName(String UserName){
		String Hql = "from User where UserName='%s'";
		List<User> users = userRepository.FindByHql(String.format(Hql, UserName));
		return users.size()<=0;
	}
	
	public User FindUserById(String Id){
		String Hql = "from User where Id='%s'";
		List<User> users = userRepository.FindByHql(String.format(Hql, Id));
		return users.size()<=0?users.get(0):null;
	}
}

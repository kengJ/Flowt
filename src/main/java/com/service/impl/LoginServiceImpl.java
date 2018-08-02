package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.BasicRepository;
import com.repository.UserRepository;
import com.service.LoginService;
@Service(value="loginService")
public class LoginServiceImpl extends BasicServiceImpl<User> implements LoginService {

	@SuppressWarnings("rawtypes")
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> FindByKey(String Key) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BasicRepository<User> GetBasicRepository() {
		return userRepository;
	}
	
	public User FindUser(String UserName,String Password) {
		return userRepository.FindUser(UserName, Password);
	}
	
	/**public boolean AddUser(String UserName,String Password){
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
	
	public User FindUser(String UserName,String Password) {
		try {
			return userRepository.FindByHql(String.format("from User where UserName='%s' and Password='%s'", UserName,Password)).get(0);
		} catch (Exception e) {
			return null;
		}
	}**/
}

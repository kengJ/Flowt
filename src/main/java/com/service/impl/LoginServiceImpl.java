package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.model.User;
import com.repository.IBasicRepository;
import com.repository.IUserRepository;
import com.service.ILoginService;

public class LoginServiceImpl extends BasicServiceImpl<User> implements ILoginService {

	@SuppressWarnings("rawtypes")
	@Autowired
	private IUserRepository userRepository;

	@Override
	public List<User> FindByKey(String Key) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IBasicRepository<User> GetBasicRepository() {
		return userRepository;
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

package com.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.User;
import com.repository.UserRepository;

@Repository(value="userRepository")
public class UserRepositoryImpl extends BasicRepositoryImpl<User> implements UserRepository<User>{

	@Override
	public User FindUser(String UserName, String Password) {
		String Hql = String.format("from User where UserName = '%s' and Password = '%s'", UserName,Password);
		List<User> Data = FindByHql(Hql);
		return Data!=null&Data.size()>0?Data.get(0):null;
	}

}

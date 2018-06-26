package com.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repository.UserRepositoryImpl;
import com.util.MessageBox;


@Service
@Transactional
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
	
	public List<User> FindList(){
		return userRepositoryImpl.FindByHql("From User");
	}
	
	public List<User> FindListByCode(String Code){
		return userRepositoryImpl.FindByHql("From User where UserName like '%"+Code+"%'");
	}
	
	public Map<String, Object> UpdateUser(User OldUser,User NewUser){
		//查询旧值是否与数据库匹配
		List<User> users =  userRepositoryImpl.FindByHql(String.format("from User where Id='%s' and UserName = '%s' and Password = '%s'", OldUser.getId(),OldUser.getUserName(),OldUser.getPassword()));
		if(users.size()>0){
			userRepositoryImpl.FindByHql(String.format("update User set UserName = '%s',Password = '%s' where Id = '%s'", NewUser.getUserName(),NewUser.getPassword(),NewUser.getId()));
			return MessageBox.UserMessageBox("success", userRepositoryImpl.FindByHql(String.format("from User where Id = '%s'", NewUser.getId())).get(0));
		}else{
			return MessageBox.UserMessageBox("error",userRepositoryImpl.FindByHql(String.format("from User where Id = '%s'", NewUser.getId())).get(0));
		}
	}
}
	
package com.service;

import com.model.User;

public interface LoginService extends BasicService<User>{
	User FindUser(String UserName,String Password);
}

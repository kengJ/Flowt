package com.repository;

import com.model.User;

public interface UserRepository<T> extends BasicRepository<T>{

	User FindUser(String UserName,String Password);
}

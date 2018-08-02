package com.controller;

import com.model.User;

public interface IUserController extends IBasicController<User> {
	String Add(String UserName,String Password);
}

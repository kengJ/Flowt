package com.controller;

import org.springframework.stereotype.Controller;
import com.model.User;

@Controller
public interface IUserController extends IBasicController<User> {
	String Add(String UserName,String Password);
}

package com.controller;

import org.springframework.web.servlet.ModelAndView;
import com.model.User;

public interface ILoginController extends IBasicController<User> {
	ModelAndView Login(String UserName,String Password);
}

package com.controller;

import org.springframework.web.servlet.ModelAndView;

import com.model.User;

public interface IUserController extends IBasicController<User> {
	String Add(String UserName,String Password);
	ModelAndView IndexPage();
	ModelAndView UpdateRolePage(String Id);
}

package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.model.User;

public interface IUserController extends IBasicController<User> {
	String Add(String UserName,String Password);
	ModelAndView IndexPage();
	ModelAndView UpdateRolePage(String Id);
	List<User> FindAll();
	List<User> FindeByKey(Map<String,String> Key);
	String UpdateUser(Map<String,String> Json);
}

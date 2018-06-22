package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.User;
import com.service.UserService;

@Controller
@RequestMapping(value="/User")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/UserList")
	@ResponseBody
	public List<User> UserList(){
		return userService.FindList();
	}
	
	@RequestMapping(value="/UserListByCode")
	@ResponseBody
	public List<User> UserListByCode(@RequestParam String Code){
		return userService.FindListByCode(Code);
	}
}

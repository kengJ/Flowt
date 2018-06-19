package com.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.User;
import com.service.LoginService;
import com.service.UserService;
import com.util.MessageBox;

@Controller
@RequestMapping("/Login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/LoginPage")
	public String LoginPage(){
		return "Login";
	}
	
	@RequestMapping(value="/LoginCheck",method=RequestMethod.GET)
	@ResponseBody
	public String CheckUser(@RequestParam String UserName,@RequestParam String Password){
		//System.out.println("UserName:"+UserName+"   Password:"+Password);
		boolean check = loginService.AddUser(UserName, Password);
		if(check){
			return "success";
		}else{
			return "error";
		}
	}
	
	@RequestMapping(value="/Login",method=RequestMethod.POST)
	//@ResponseBody
	public String Login(@RequestParam String UserName,@RequestParam String Password) {
		System.out.println(UserName+'_'+Password);
		if(UserName.equals("admin")&&Password.equals("admin")) {
			//return "success";
			return "index";
		}else {
			return "redirect:Login";
		}
	}
	
	@RequestMapping(value="/CheckUserName",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, String> CheckUserName(@RequestParam String UserName){
		Map<String, String> result = null;
		if(loginService.FindUserByName(UserName)){
			result = MessageBox.UserMessageBox("error", "用户名不存在");
		}else{
			result = MessageBox.UserMessageBox("success", "");
		}
		return result;
	}
	
	@RequestMapping(value="/LoginForReact")
	@ResponseBody
	public Map<String, String> LoginForReact(String UserName,String Password){
		
		User user = userService.Check(UserName, Password);
		if(user!=null&&!user.equals("")){
			Map<String, String> result = new HashMap<String,String>();
			result.put("name", user.getUserName());
			result.put("role", "ADMIN");
			result.put("uid", user.getId().toString());
			return result;
		}
		return null;
		
	}
}

package com.controller.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.controller.ILoginController;
import com.model.User;
import com.service.ILoginService;
import com.service.IMenuService;

@RequestMapping("/Login")
public class LoginControllerImpl extends BasicControllerImpl<User> implements ILoginController {

	@Autowired
	private ILoginService loginService;
	
	@SuppressWarnings("unused")
	@Autowired
	private IMenuService menuService;

	@RequestMapping(value="/FindAll",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindAll(String page, String limit) {
		return LayUiListFormat(loginService.FindAll());
	}

	@RequestMapping(value="/FindById",method=RequestMethod.POST)
	public ModelAndView FindById(Map<String, Object> Json) {
		return ForwardEditOrShow(Json);
	}

	@RequestMapping(value="/FindByKey",method=RequestMethod.POST)
	@ResponseBody
	public List<User> FindByKey(String keyword) {
		return loginService.FindByKey(keyword);
	}

	@RequestMapping(value="/Del",method=RequestMethod.POST)
	@ResponseBody
	public String Del(String Id) {
		return LayuiFormatResult(loginService.DeleteById(Id));
	}

	public String Add(User o) {
		return LayuiFormatResult(loginService.SaveOrEdit(o));
	}

	public User FindById(String Id) {
		return loginService.FindById(Id);
	}
	
//	@RequestMapping(value="/LoginPage")
//	public String LoginPage(){
//		return "Login/UiTest";
//	}
//	
//	@RequestMapping(value="/LoginCheck",method=RequestMethod.GET)
//	@ResponseBody
//	public String CheckUser(@RequestParam String UserName,@RequestParam String Password){
//		//System.out.println("UserName:"+UserName+"   Password:"+Password);
//		boolean check = loginService.AddUser(UserName, Password);
//		if(check){
//			return "success";
//		}else{
//			return "error";
//		}
//	}
//	
//	@RequestMapping(value="/Login",method=RequestMethod.POST)
//	//@ResponseBody
//	public ModelAndView Login(@RequestParam String UserName,@RequestParam String Password) {
//		ModelAndView mv = new ModelAndView("redirect:Login");
//		if(UserName.equals("admin")&&Password.equals("admin")) {
//			//return "success";
//			//return "LayUiIndex";
//			//menuService.FindAll();
//			mv.setViewName("LayUiIndex");
//			mv.addObject("menus", menuService.FindAll());
//		}
//		return mv;
//	}
//	
//	@RequestMapping(value="/CheckUserName",method=RequestMethod.GET)
//	@ResponseBody
//	public Map<String, Object> CheckUserName(@RequestParam String UserName){
//		Map<String, Object> result = null;
//		if(loginService.FindUserByName(UserName)){
//			result = MessageBox.UserMessageBox("error", "用户名不存在");
//		}else{
//			result = MessageBox.UserMessageBox("success", "");
//		}
//		return result;
//	}
//	
//	@RequestMapping(value="/LoginForReact")
//	@ResponseBody
//	public Map<String, String> LoginForReact(@RequestBody Map<String, String> Json){
//		User user = null;
//		String Id = Json.get("uid");
//		if(Id!=null&&!Id.equals("")){
//			user = loginService.FindUserById(Id);
//		}else{
//			user = loginService.FindUser(Json.get("UserName"), Json.get("Password"));
//		}
//		if(user!=null){
//			Map<String, String> result = new HashMap<String,String>();
//			result.put("name", user.getUserName());
//			result.put("role", "ADMIN");
//			result.put("uid", user.getId().toString());
//			return result;
//		}
//		return null;
//		
//	}
//	
//	@RequestMapping("/Logout")
//	public String Ladyout(){
//		return "Login/UiTest";
//	}
}

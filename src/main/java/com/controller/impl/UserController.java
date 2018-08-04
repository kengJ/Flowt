package com.controller.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.controller.IUserController;
import com.model.User;
import com.service.UserService;
@Controller
@RequestMapping(value="/User")
public class UserController extends BasicControllerImpl<User> implements IUserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/FindAll",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindAll(String page, String limit) {
		List<User> Data = userService.FindAll();
		return super.LayUiListFormat(Data,page,limit);
	}

	@RequestMapping(value="/FindById",method=RequestMethod.POST)
	public ModelAndView FindById(@RequestParam Map<String, Object> Json) {
		return ForwardEditOrShow(Json);
	}

	@RequestMapping(value="/FindByKey",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindByKey(String keyword,String page, String limit) {
		return LayUiListFormat(userService.FindByKey(keyword),page,limit);
	}

	@RequestMapping(value="/Add",method=RequestMethod.POST)
	@ResponseBody
	public String Add(String UserName, String Password) {
		User user = new User(UserName, Password);
		return Add(user);
	}

	@RequestMapping(value="/Del",method=RequestMethod.POST)
	@ResponseBody
	public String Del(String Id) {
		return LayuiFormatResult(userService.DeleteById(Id));
	}

	public String Add(User o) {
		return LayuiFormatResult(userService.SaveOrEdit(o));
	}

	public User FindById(String Id) {
		return userService.FindById(Id);
	}
	
	/**
	 * 查询用户
	 * @param Code
	 * @return
	 
	@RequestMapping(value="/FindUser")
	@ResponseBody
	public Map<String, Object> FindUser(@RequestParam(value="Code") String Code){
		List<User> DataList = userService.FindListByCode(Code);
		return MessageBox.SuccessBox("数据查询成功", DataList);
	}*/
	
	/**
	 * 更新用户
	 * @param result
	 * @return
	 
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/UpdateUserById",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> UpdateUserById(@RequestBody Map<String, Object> result){
		Map<String, Object> OldData =  (Map<String, Object>) result.get("oldData");
		Map<String, Object> NewData =  (Map<String, Object>) result.get("newData");
		User OldUser = new User(OldData.get("id").toString(),OldData.get("userName").toString(), OldData.get("password").toString());
		User NewUser = new User(NewData.get("id").toString(),NewData.get("userName").toString(), NewData.get("password").toString());
		return userService.UpdateUser(OldUser,NewUser);
	}*/
	
	/**
	 * 新增用户
	 * @param result
	 * @return
	 
	@RequestMapping(value="/Add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> AddUser(String UserName,String Password){
		//String UserName = result.get("UserName").toString();
		//String Password = result.get("Password").toString();
		return userService.AddUser(UserName, Password);
	}*/
	
	/**
	 * 删除用户
	 * @param result
	 * @return
	 
	@RequestMapping(value="/DelUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> DelUser(@RequestBody Map<String, Object> result){
		String Id = result.get("Id").toString();
		return userService.DelUser(Id);
	}*/
	
	/**
	 * 
	 * @param page 页编号
	 * @param limit 每页条数
	 * @return
	 
	@RequestMapping(value="FindAll")
	@ResponseBody
	public Map<String, Object> FindAll(String page,String limit,@RequestParam(name="keyword",defaultValue="")String keyword){
		//int maxPage = Integer.parseInt(limit);
		List<User> data = null;
		if(keyword==""||keyword.equals("")){
			data = userService.FindAll();
		}else{
			data = userService.FindByKey(keyword);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "");
		result.put("msg", "");
		result.put("count", data.size());
		result.put("data", data);
		return result;
	}*/
	
	/**@RequestMapping("/FindById")
	public ModelAndView FindById(@RequestParam(defaultValue="",name="Type")String Type,@RequestParam(name="Id")String Id){
		User User = userService.FindById(Id);
		//System.out.println(Computer);
		ModelAndView mv = null;
		if(Type==""||Type.equals("")){
			mv = new ModelAndView("forward:/Page/Show");
		}else{
			mv = new ModelAndView("forward:/Page/Edit");
		}
		mv.addObject("result", User);
		return mv;
	}**/
	
//	@RequestMapping(value="Del")
//	@ResponseBody
//	public String Del(String Id){
//		User computer = userService.FindById(Id);
//		if(computer!=null){
//			userService.Delete(computer);
//			return "success";
//		}
//		return "error";
//	}
	
//	@RequestMapping(value="Update")
//	@ResponseBody
//	public String Update(@RequestParam(defaultValue="",name="Id")String Id,String UserName,String Password){
//		try {
//			User User = null;
//			if(Id==null||Id==""||Id.equals("")){
//				//新增跳过查询
//				User = new User(UserName,Password);
//			}else{
//				User = userService.FindById(Id);
//			}
//			User.setUserName(UserName);
//			User.setPassword(Password);
//			userService.Update(User);
//			return "success";
//		} catch (Exception e) {
//			return "error";
//		}
//	}
}

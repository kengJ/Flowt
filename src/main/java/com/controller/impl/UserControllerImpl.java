package com.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.controller.IUserController;
import com.model.MessageTable;
import com.model.MessageTableAction;
import com.model.MessageTableDetial;
import com.model.Role;
import com.model.User;
import com.service.MessageTableService;
import com.service.RoleService;
import com.service.UserService;
import com.util.ServerTool;

@Controller
@RequestMapping(value="/User")
public class UserControllerImpl extends BasicControllerImpl<User> implements IUserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageTableService messageTableService;
	
	@Autowired
	private RoleService roleService;

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

	@Override
	@RequestMapping("/IndexPage")
	public ModelAndView IndexPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Page/User/BasicPage");
		MessageTable MessageTable = messageTableService.FindMessageTable("User");
		String Title = MessageTable.getTitle();
		String Tip = MessageTable.getTip();
		mv.addObject("title", Title);//获取标题
		mv.addObject("tip", Tip);//获取提示
		mv.addObject("width", "500px");//获取提示
		mv.addObject("action", MessageTable.getName());
		List<MessageTableDetial> MessageTableDetials = MessageTable.getMessageTableDetial();
		List<Map<String, String>> Detials = new ArrayList<>();
		for(MessageTableDetial MessageTableDetial :MessageTableDetials){
			Map<String, String> line = new HashMap<>();
			line.put("title", MessageTableDetial.getTitle());
			line.put("field", MessageTableDetial.getKeyName());
			Detials.add(line);
		}
		mv.addObject("cols", Detials);
		Set<MessageTableAction> MessageTableActions = MessageTable.getMessageTableActions();
		String AppPath = ServerTool.GetAppPath();
		for(MessageTableAction MessageTableAction : MessageTableActions){
			mv.addObject("Action"+MessageTableAction.getType(), AppPath+MessageTableAction.getUrl());
		}
		mv.addObject("ActionUpdateRolePage", ServerTool.GetAppPath()+"/User/UpdateRolePage");
		return mv;
	}

	@Override
	@RequestMapping(value="/UpdateRolePage",method=RequestMethod.POST)
	public ModelAndView UpdateRolePage(String Id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Page/User/UpdatRolePage");
		List<Role> Roles = roleService.FindAll();
		User User = FindById(Id);
		mv.addObject("roles", Roles);
		mv.addObject("name", User.getUserName());
		mv.addObject("id", Id);
		return mv;
	}

	@Override
	@RequestMapping("/ReactFindAll")
	@ResponseBody
	public List<User> FindAll() {
		// TODO Auto-generated method stub
		return userService.FindAll();
	}

	@Override
	@RequestMapping("/ReactFindByKey")
	@ResponseBody
	public List<User> FindeByKey(@RequestBody Map<String,String> Json) {
		System.out.println(Json);
		return userService.FindByKey(Json.get("Key"));
	}

	@Override
	@RequestMapping("/UpdateUser")
	@ResponseBody
	public String UpdateUser(@RequestBody Map<String, String> Json) {
		System.out.println(Json);
		boolean Check = false;
		User User = userService.FindById(Json.get("Id"));
		if(User!=null){
			User.setUserName(Json.get("UserName"));
			User.setPassword(Json.get("Password"));
			Check = userService.SaveOrEdit(User);
		}
		if(Check){
			return "success";
		}else{
			return "error";
		}
		//return userService.SaveOrEdit(User);
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

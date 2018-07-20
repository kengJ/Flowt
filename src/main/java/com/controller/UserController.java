package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Computer;
import com.model.User;
import com.service.UserService;
import com.util.MessageBox;

@Controller
@RequestMapping(value="/User")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 查询用户
	 * @param Code
	 * @return
	 */
	@RequestMapping(value="/FindUser")
	@ResponseBody
	public Map<String, Object> FindUser(@RequestParam(value="Code") String Code){
		List<User> DataList = userService.FindListByCode(Code);
		return MessageBox.SuccessBox("数据查询成功", DataList);
	}
	
	/**
	 * 更新用户
	 * @param result
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/UpdateUserById",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> UpdateUserById(@RequestBody Map<String, Object> result){
		Map<String, Object> OldData =  (Map<String, Object>) result.get("oldData");
		Map<String, Object> NewData =  (Map<String, Object>) result.get("newData");
		User OldUser = new User(OldData.get("id").toString(),OldData.get("userName").toString(), OldData.get("password").toString());
		User NewUser = new User(NewData.get("id").toString(),NewData.get("userName").toString(), NewData.get("password").toString());
		return userService.UpdateUser(OldUser,NewUser);
	}
	
	/**
	 * 新增用户
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/AddUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> AddUser(@RequestBody Map<String, Object> result){
		String UserName = result.get("UserName").toString();
		String Password = result.get("Password").toString();
		return userService.AddUser(UserName, Password);
	}
	
	/**
	 * 删除用户
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/DelUser",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> DelUser(@RequestBody Map<String, Object> result){
		String Id = result.get("Id").toString();
		return userService.DelUser(Id);
	}
	
	/**
	 * 
	 * @param page 页编号
	 * @param limit 每页条数
	 * @return
	 */
	@RequestMapping(value="FindAll")
	@ResponseBody
	public Map<String, Object> FindAll(String page,String limit,@RequestParam(name="keyword",defaultValue="")String keyword){
		int maxPage = Integer.parseInt(limit);
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
	}
}

package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Role;
import com.service.RoleService;
import com.util.MessageBox;

@Controller
@RequestMapping(value="/Role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="Find",method=RequestMethod.GET)
	@ResponseBody
	public List<Role> Find(String Code){
		List<Role> RoleList = null;
		if(Code==""||Code.equals("")){
			RoleList = roleService.FindAll();
		}else{
			RoleList = roleService.FindByName(Code);
		}
		/**if(RoleList.size()>0){
			return MessageBox.SuccessBox(RoleList);
		}else{
			return MessageBox.ErrorBox("没有查到相应的数据");	
		}**/
		return RoleList;
	}
	
	@RequestMapping(value="AddRole",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> AddRole(@RequestBody Map<String, String> Result){
		System.out.println("AddRole>args:"+Result);
		String RoleName = Result.get("roleName");
		String Memo = Result.get("memo");
		
		
		boolean AddCheck = roleService.AddRole(RoleName, Memo);
		if(AddCheck){
			return MessageBox.SuccessBox("新增成功");
		}else{
			return MessageBox.ErrorBox("新增失败");
		}
		//return null;
	}
}

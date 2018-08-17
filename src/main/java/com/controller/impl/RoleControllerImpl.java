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

import com.controller.IRoleController;
import com.model.Role;
import com.service.RoleService;

@Controller
@RequestMapping(value="/Role")
public class RoleControllerImpl extends BasicControllerImpl<Role> implements IRoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping(value="/FindAll",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindAll(String page, String limit) {
		List<Role> Data = roleService.FindAll();
		return LayUiListFormat(Data,page,limit);
	}

	@RequestMapping(value="/FindById",method=RequestMethod.POST)
	public ModelAndView FindById(@RequestParam Map<String, Object> Json) {
		return ForwardEditOrShow(Json);
	}

	@RequestMapping(value="/FindByKey",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindByKey(String keyword,String page, String limit) {
		return LayUiListFormat(roleService.FindByKey(keyword),page,limit);
	}

	@RequestMapping(value="/Del",method=RequestMethod.POST)
	@ResponseBody
	public String Del(String Id) {
		return LayuiFormatResult(roleService.DeleteById(Id));
	}

	@Override
	public String Add(Role o) {
		return LayuiFormatResult(roleService.SaveOrEdit(o));
	}

	@Override
	public Role FindById(String Id) {
		return roleService.FindById(Id);
	}

	@Override
	@RequestMapping(value="/ReactFindAll")
	@ResponseBody
	public List<Role> FindAll() {
		return roleService.FindAll();
	}
	
//	@RequestMapping(value="Find",method=RequestMethod.GET)
//	@ResponseBody
//	public Map<String, Object> Find(String Code){
//		List<Role> RoleList = null;
//		if(Code==""||Code.equals("")){
//			RoleList = roleService.FindAll();
//		}else{
//			RoleList = roleService.FindByName(Code);
//		}
//		if(RoleList==null||RoleList.size()==0){
//			return MessageBox.ErrorBox("未能查到相应数据");
//		}
//		return MessageBox.SuccessBox("数据查询成功", RoleList);
//	}
//	
//	@RequestMapping(value="AddRole",method=RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Object> AddRole(@RequestBody Map<String, String> Result){
//		System.out.println("AddRole>args:"+Result);
//		String RoleName = Result.get("roleName");
//		String Memo = Result.get("memo");
//		
//		
//		boolean AddCheck = roleService.AddRole(RoleName, Memo);
//		if(AddCheck){
//			return MessageBox.SuccessBox("新增成功");
//		}else{
//			return MessageBox.ErrorBox("新增失败");
//		}
//		//return null;
//	}
}

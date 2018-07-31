package com.controller.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.controller.ISystemTypeController;
import com.model.SystemType;
import com.service.ISystemTypeService;


@RequestMapping(value="/SystemType")
public class SystemTypeControllerImpl extends BasicControllerImpl<SystemType> implements ISystemTypeController {

	@Autowired
	private ISystemTypeService systemTypeService;

	@RequestMapping(value="/FindAll",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindAll(String page, String limit) {
		List<SystemType> Data = systemTypeService.FindAll();
		return LayUiListFormat(Data);
	}

	@RequestMapping(value="/FindById",method=RequestMethod.POST)
	@Override
	public ModelAndView FindById(Map<String, Object> Json) {
		return ForwardEditOrShow(Json);
	}

	@RequestMapping(value="/FindById",method=RequestMethod.POST)
	@ResponseBody
	public List<SystemType> FindByKey(String keyword) {
		return systemTypeService.FindByKey(keyword);
	}

	@RequestMapping(value="/Del",method=RequestMethod.POST)
	@ResponseBody
	public String Del(String Id) {
		return LayuiFormatResult(systemTypeService.DeleteById(Id));
	}

	@RequestMapping(value="/Add",method=RequestMethod.POST)
	@ResponseBody
	public String Add(String name, String key) {
		SystemType SystemType = new SystemType(name, key);
		return Add(SystemType);
	}

	public String Add(SystemType o) {
		return LayuiFormatResult(systemTypeService.SaveOrEdit(o));
	}

	@Override
	public SystemType FindById(String Id) {
		return systemTypeService.FindById(Id);
	}
	
	
	
	/**@RequestMapping(value="/Find",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> Find(String Code){
		List<SystemType> DataList = null;
		if(Code==""||Code.equals("")){
			DataList = systemTypeService.FindAll();
		}else{
			DataList = systemTypeService.Find(Code);
		}
		if(DataList==null||DataList.size()==0){
			return MessageBox.ErrorBox("未能查到相应条目");
		}
		return MessageBox.SuccessBox("查询成功", DataList);
	}
	
	@RequestMapping(value="/AddSystemType")
	public Map<String, Object> AddSystemType(@RequestBody Map<String, Object> Result){
		String SystemName = (String) Result.get("systemName");
		String SystemKey = (String) Result.get("systemKey");
		boolean Check = systemTypeService.Add(new SystemType(SystemName, SystemKey));
		if(Check){
			return MessageBox.SuccessBox("新增成功:系统类型"+SystemName+"已添加");
		}else{
			return MessageBox.ErrorBox("系统信息添加失败");
		}
	}
	
	public Map<String, Object> DelSystemType(@RequestBody Map<String, Object> Result){
		String Id = (String) Result.get("Id");
		boolean Check = systemTypeService.Del(Id);
		if(Check){
			return MessageBox.SuccessBox("删除系统信息成功");
		}else{
			return MessageBox.ErrorBox("删除失败");
		}
	}**/
}

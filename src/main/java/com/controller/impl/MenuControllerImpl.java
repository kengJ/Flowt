package com.controller.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.controller.IMenuController;
import com.model.Menu;
import com.service.IMenuService;

@RequestMapping("/Menu")
public class MenuControllerImpl extends BasicControllerImpl<Menu> implements IMenuController{

	@Autowired
	private IMenuService menuService;

	@RequestMapping(value="/FindAll",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindAll(String page, String limit) {
		return LayUiListFormat(menuService.FindAll());
	}

	@RequestMapping(value="/FindById",method=RequestMethod.POST)
	public ModelAndView FindById(Map<String, Object> Json) {
		return ForwardEditOrShow(Json);
	}

	@RequestMapping(value="/FindByKey",method=RequestMethod.POST)
	@ResponseBody
	public List<Menu> FindByKey(String keyword) {
		return menuService.FindByKey(keyword);
	}

	@RequestMapping(value="/Del",method=RequestMethod.POST)
	@ResponseBody
	public String Del(String Id) {
		return LayuiFormatResult(menuService.DeleteById(Id));
	}

	@Override
	public String Add(Menu o) {
		return LayuiFormatResult(menuService.SaveOrEdit(o));
	}

	@Override
	public Menu FindById(String Id) {
		return menuService.FindById(Id);
	}

	
	
//	@Override
//	public IBasicService<Menu> GetService() {
//		return menuService;
//	}
//
//	@RequestMapping(value="/FindAll")
//	@ResponseBody
//	public Map<String, Object> FindAll(String page,String limit) {
//		return super.FindAll(page, limit);
//	}
//
//	@RequestMapping(value="/FindById",method=RequestMethod.POST)
//	public ModelAndView FindById(@RequestParam Map<String, Object> Json) {
//		/**String Id = (String) Json.get("Id");
//		String Type = (String) Json.get("Type");
//		Menu Menu = menuService.FindById(Id);
//		ModelAndView mv = null;
//		if(Type==""||Type.equals("")|Type==null){
//			mv = new ModelAndView("forward:/Page/Show");
//		}else{
//			mv = new ModelAndView("forward:/Page/Edit");
//		}
//		mv.addObject("result", Menu);
//		return mv;**/
//		return super.FindById(Json);
//	}
//
//	@RequestMapping(value="/Add",method=RequestMethod.POST)
//	@ResponseBody
//	public String Add(@RequestParam  Map<String, Object> result){
//		/**
//		try{
//			menuService.Add(Menu);
//			return "success";
//		}catch (Exception e) {
//			return "error";
//		}**/
//		Menu Menu = new Menu((String)result.get("Name"),(String)result.get("Title"),(String)result.get("Memo"),Integer.parseInt((String)result.get("OrderBy")));
//		return super.Add(Menu);
//	}
//
//	@RequestMapping(value="/Del",method=RequestMethod.POST)
//	@ResponseBody
//	public String Del(String Id) {
//		/**try {
//			menuService.DeleteByKey(Id);
//			return "success";
//		} catch (Exception e) {
//			return "error";
//		}**/
//		return super.Del(Id);
//	}
//
//	@RequestMapping(value="/Edit",method=RequestMethod.POST)
//	@ResponseBody
//	public String Edit(@RequestParam Map<String, Object> Json) {
//		String Id = (String) Json.get("Id");
//		if(Id==null){
//			Id = "";
//		}
//		Menu menu = menuService.FindById(Id);
//		menu.setName((String)Json.get("Name"));
//		menu.setTitle((String)Json.get("Title"));
//		menu.setMemo((String)Json.get("Memo"));
//		menu.setOrderBy(Integer.parseInt((String)Json.get("OrderBy")));
//		return super.Edit(menu)?"success":"error";
//	}
//	
//	@RequestMapping(value="/FindByKey")
//	@ResponseBody
//	public Map<String,Object> FindByKey(String keyword ,String page,String limit){
//		System.out.println(keyword);
//		List<Menu> data = super.FindByKey(keyword);
//		System.out.println(data);
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("code", "");
//		result.put("msg", "");
//		result.put("count", data.size());
//		result.put("data", data);
//		return result;
//	}

}

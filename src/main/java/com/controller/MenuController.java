package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.Computer;
import com.model.Menu;
import com.service.MenuService;

@Controller
@RequestMapping("/Menu")
public class MenuController implements BasicController<Menu>{

	@Autowired
	private MenuService menuService;

	@RequestMapping(value="/FindAll")
	@ResponseBody
	public Map<String, Object> FindAll(String page,String limit) {
		List<Menu> data = menuService.FindAll();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "");
		result.put("msg", "");
		result.put("count", data.size());
		result.put("data", data);
		return result;
	}

	@RequestMapping(value="/FindById")
	public ModelAndView FindById(@RequestParam(defaultValue="",name="Type")String Type, @RequestParam(name="Id")String Id) {
		Menu Menu = menuService.FindById(Id);
		ModelAndView mv = null;
		if(Type==""||Type.equals("")){
			mv = new ModelAndView("forward:/Page/Show");
		}else{
			mv = new ModelAndView("forward:/Page/Edit");
		}
		mv.addObject("result", Menu);
		return mv;
	}

	@RequestMapping(value="/Add",method=RequestMethod.POST)
	@ResponseBody
	public String Add(@RequestBody Map<String, String> Json){
		System.out.println(Json);
		/**Menu Menu = new Menu((String)request.getAttribute("Name"),(String)request.getAttribute("Title"),(String)request.getAttribute("Memo"),Integer.parseInt((String)request.getAttribute("Name")));
		try{
			menuService.Add(Menu);
			return "success";
		}catch (Exception e) {
			return "error";
		}**/
		return "";
	}
	
}

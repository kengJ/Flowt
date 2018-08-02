package com.controller.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;
import com.controller.IBasicController;
import com.service.BasicService;

public abstract class BasicControllerImpl_bak<T> implements IBasicController<T>{

	/**
	 * 此函数必须重写
	 */
	public BasicService<T> GetService() {
		return null;
	}

	@Override
	public Map<String, Object> FindAll(String page, String limit) {
		List<T> data = GetService().FindAll();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "");
		result.put("msg", "");
		result.put("count", data.size());
		result.put("data", data);
		return result;
	}

	@Override
	public ModelAndView FindById(Map<String, Object> Json) {
		String Id = (String) Json.get("Id");
		String Type = (String) Json.get("Type");
		T o = GetService().FindById(Id);
		ModelAndView mv = null;
		if(Type==null){
			mv = new ModelAndView("forward:/Page/Show");
		}else{
			mv = new ModelAndView("forward:/Page/Edit");
		}
		mv.addObject("result", o);
		return mv;
	}

	/**
	public String Add(T o) {
		try{
			GetService().Add(o);
			return "success";
		}catch (Exception e) {
			return "error";
		}
	}**/

	/**@Validated
	public String Del(String Id) {
		try {
			GetService().DeleteById(Id);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}**/

	/**@Override
	public boolean Edit(T o) {
		GetService().Update(o);
		return true;
	}**/

	@Override
	public Map<String, Object> FindByKey(String keyword) {
		return LayUiListFormat(GetService().FindByKey(keyword));
	}
}

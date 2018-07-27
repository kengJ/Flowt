package com.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;

import com.service.BasicService;

public interface BasicController<T> {

	BasicService<T> GetService();
	
	Map<String, Object> FindAll(String page,String limit);
	/**
	 * @RequestParam(defaultValue="",name="Type")
	 * @RequestParam(name="Id")
	 * @param Type
	 * @param Id
	 * @return
	 */
	ModelAndView FindById(Map<String, Object> Json);
	
	String Add(T o);
	
	String Del(String Id);
	
	boolean Edit(T o);
	
	List<T> FindByKey(String keyword);
}

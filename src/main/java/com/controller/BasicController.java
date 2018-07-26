package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface BasicController<T> {

	Map<String, Object> FindAll(String page,String limit);
	/**
	 * @RequestParam(defaultValue="",name="Type")
	 * @RequestParam(name="Id")
	 * @param Type
	 * @param Id
	 * @return
	 */
	ModelAndView FindById(String Type,String Id);
	
	String Add(Map<String, String> Json);
}

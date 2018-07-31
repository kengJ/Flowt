package com.controller;

import java.util.List;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;

public interface IBasicController<T> {
	Map<String, Object> FindAll(String page,String limit);
	ModelAndView FindById(Map<String, Object> Json);
	List<T> FindByKey(String keyword);
	String Del(String Id);
	String Add(T o);
	ModelAndView ForwardEditPage(T o);
	ModelAndView ForwardShowPage(T o);
	Map<String, Object> LayUiListFormat(List<T> Data);
	ModelAndView ForwardEditOrShow(Map<String, Object> Json);
	T FindById(String Id);
	String LayuiFormatResult(boolean Result);
}

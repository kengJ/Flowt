package com.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.controller.IBasicController;

public abstract class BasicControllerImpl<T> implements IBasicController<T> {

	/**
	 * 封装返回edit面的请求
	 */
	@Override
	public ModelAndView ForwardEditPage(T o) {
		ModelAndView mv = new ModelAndView("forward:/Page/Edit");
		mv.addObject("result", o);
		return mv;
	}
	
	/**
	 * 封装返回show页面的请求
	 */
	@Override
	public ModelAndView ForwardShowPage(T o) {
		ModelAndView mv = new ModelAndView("forward:/Page/Show");
		mv.addObject("result", o);
		return mv;
	}
	
	/**
	 * layui 前端框架返回专用格式
	 */
	@Override
	public Map<String, Object> LayUiListFormat(List<T> Data,String page, String limit) {
		Map<String, Object> result = new HashMap<String, Object>();
		//判断是否有数据
		if(Data!=null){
			int Max = Data.size();
			int StartIndex = (Integer.parseInt(page)-1)*Integer.parseInt(limit);
			int EndIndex = StartIndex+Integer.parseInt(limit)>Max?Max:StartIndex+Integer.parseInt(limit);
			List<T> ResultData = new ArrayList<>();
			for(int i = StartIndex;i<EndIndex;i++){
				ResultData.add(Data.get(i));
			}
			result.put("code", "");
			result.put("msg", "");
			result.put("count", Max);
			result.put("data", ResultData);
		}else{
			result.put("code", "0");
			result.put("msg", "没有查到相应的数据");
			result.put("count", "0");
			result.put("data", new ArrayList<T>());
		}
		return result;
	}
	@Override
	public ModelAndView ForwardEditOrShow(Map<String, Object> Json) {
		String Id = (String) Json.get("Id");
		String Type = (String) Json.get("Type");
		T Data = FindById(Id);
		if(Type==null){
			return ForwardShowPage(Data);
		}else{
			return ForwardEditPage(Data);
		}
	}
	
	@Override
	public String LayuiFormatResult(boolean Result) {
		if(Result){
			return "success";
		}
		return "error";
	}
}

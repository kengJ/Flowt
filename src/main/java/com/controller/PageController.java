package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.MessageTable;
import com.service.MessageTableService;

@Controller
@RequestMapping(value="/Page")
public class PageController {
	
	@Autowired
	private MessageTableService messageTableService;
	
	/**@RequestMapping(value="/ComputerEditPage")
	public ModelAndView ComputerEditPage(String Id,String Ip,String LoginName){
		ModelAndView mav  = new ModelAndView("Page/Computer/Edit");
		mav.addObject("id", Id);
		mav.addObject("ip", Ip);
		mav.addObject("loginName", LoginName);
		return mav;
	}**/
	
	@RequestMapping(value="/{action}Edit")
	public ModelAndView AddPage(@PathVariable("action")String action) {
		String ActionName = action.substring(0, 1).toUpperCase()+action.substring(1);
		return new ModelAndView("Page/"+ActionName+"/Edit");
	}
	
	@RequestMapping(value="/Show/{action}")
	public ModelAndView ShowPage(@PathVariable("action")String action,HttpServletRequest request){
		MessageTable MessageTable =messageTableService.getMessageTable(request.getAttribute("result").getClass().getSimpleName());
		ModelAndView mv = new ModelAndView("Page/Computer/Show");
		return mv;
	}
}

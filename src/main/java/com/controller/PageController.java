package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/Page")
public class PageController {
	
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
}

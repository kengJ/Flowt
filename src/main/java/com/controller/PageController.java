package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/Page")
public class PageController {
	
	@RequestMapping(value="ComputerEditPage")
	public ModelAndView ComputerEditPage(String Id,String Ip,String LoginName){
		ModelAndView mav  = new ModelAndView("Page/Computer/Edit");
		mav.addObject("id", Id);
		mav.addObject("ip", Ip);
		mav.addObject("loginName", LoginName);
		return mav;
	}
}

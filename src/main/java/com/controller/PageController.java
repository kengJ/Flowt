package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/Page")
public class PageController {

	@RequestMapping(value="UserIndexPage")
	public String UserIndexPage(){
		return "user/index";
	}
	
	@RequestMapping(value="IpAddressIndexPage")
	public String IpAddressIndexPage(){
		return "Page/BasicPage";
	}
}

package com.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/PageIndex")
public class PageIndexController {
	/**@RequestMapping(value="/UserIndexPage")
	public String UserIndexPage(){
		return "Page/Index/UserPage";
	}
	
	@RequestMapping(value="/IpAddressIndexPage")
	public String IpAddressIndexPage(){
		return "Page/Index/IpAddressPage";
	}**/

	@RequestMapping(value="/IndexPage/{action}")
	public String IndexPage(@PathVariable("action") String action){
		return "Page/Index/"+action+"Page";
	}
}

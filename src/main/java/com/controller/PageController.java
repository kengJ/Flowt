package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/Page")
public class PageController {

	@RequestMapping(value="UserIndexPage")
	public String UserIndexPage(){
		return "user/index";
	}
}

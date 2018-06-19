package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Computer;
import com.service.ComputerService;

@Controller
@RequestMapping("/Computer")
public class ComputerController {

	@Autowired
	private ComputerService computerService;
	
	@RequestMapping("AddComputer")
	@ResponseBody
	public String AddComputer(@RequestParam String LoginName,
							@RequestParam String Ip,
							@RequestParam String UserCode,
							@RequestParam String UserName){
		Computer computer = new Computer();
		computer.setIp(Ip);
		computer.setLoginName(LoginName);
		computer.setUserCode(UserCode);
		computer.setUserName(UserName);
		try{
			computerService.AddComputer(computer);
			return "sucess";
		}catch (Exception e) {
			return "error";
		}
	}
}

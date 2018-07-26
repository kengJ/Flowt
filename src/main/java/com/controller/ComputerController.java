package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.Computer;
import com.service.ComputerService;

@Controller
@RequestMapping("/Computer")
public class ComputerController {

	@Autowired
	private ComputerService computerService;
	
	@RequestMapping("Add")
	@ResponseBody
	public String AddComputer(String LoginName,String Ip){
		Computer computer = new Computer(LoginName,Ip);
		try{
			computerService.AddComputer(computer);
			return "success";
		}catch (Exception e) {
			return "error";
		}
	}
	/**
	 * 
	 * @param page 页编号
	 * @param limit 每页条数
	 * @return
	 */
	@RequestMapping(value="FindAll")
	@ResponseBody
	public Map<String, Object> FindAll(String page,String limit,@RequestParam(name="keyword",defaultValue="")String keyword){
		//int maxPage = Integer.parseInt(limit);
		List<Computer> data = null;
		if(keyword==""||keyword.equals("")){
			data = computerService.FindAll();
		}else{
			data = computerService.FindByKey(keyword);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", "");
		result.put("msg", "");
		result.put("count", data.size());
		result.put("data", data);
		return result;
	}
	
	@RequestMapping(value="Del")
	@ResponseBody
	public String Del(String Id){
		Computer computer = computerService.FindById(Id);
		if(computer!=null){
			computerService.Delete(computer);
			return "success";
		}
		return "error";
	}
	
	@RequestMapping(value="Update")
	@ResponseBody
	public String Update(@RequestParam(defaultValue="",name="Id")String Id,String LoginName,String Ip){
		try {
			Computer computer = null;
			if(Id==null||Id==""||Id.equals("")){
				//新增跳过查询
				computer = new Computer();
				computer.setUserCode("Admin");
				computer.setUserName("Admin");
			}else{
				computer = computerService.FindById(Id);
			}
			computer.setIp(Ip);
			computer.setLoginName(LoginName);
			computerService.Update(computer);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping("/FindById")
	public ModelAndView FindById(@RequestParam(defaultValue="",name="Type")String Type,@RequestParam(name="Id")String Id){
		Computer Computer = computerService.FindById(Id);
		ModelAndView mv = null;
		if(Type==""||Type.equals("")){
			mv = new ModelAndView("forward:/Page/Show");
		}else{
			mv = new ModelAndView("forward:/Page/Edit");
		}
		mv.addObject("result", Computer);
		return mv;
	}
}

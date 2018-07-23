package com.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.model.MessageTableDetial;
import com.service.MessageTableService;
import com.util.StrUtil;

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
		Map<String, String> Data = StrUtil.ObjectToMap(request.getAttribute("result"));
		//System.out.println(Data);
		System.out.println(MessageTable);
		List<Map<String, String>> ResultData = new ArrayList<Map<String, String>>();
		Set<MessageTableDetial> MessageTableDetials = MessageTable.getMessageTableDetial();
		for(MessageTableDetial mtd : MessageTableDetials ) {
			Map<String, String> line = new HashMap<String, String>();
			line.put("title", mtd.getTitle());
			line.put("Value", Data.get(mtd.getName()));
			ResultData.add(line);
		}
		ModelAndView mv = new ModelAndView("Page/Show");
		mv.addObject("data", ResultData);
		return mv;
	}
}

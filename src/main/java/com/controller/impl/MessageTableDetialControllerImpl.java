package com.controller.impl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.controller.IMessageTableDetialController;
import com.model.MessageTableDetial;
import com.service.MessageTableDetialService;

@Controller
@RequestMapping("/MessageTableDetial")
public class MessageTableDetialControllerImpl extends BasicControllerImpl<MessageTableDetial> implements IMessageTableDetialController{

	@Autowired
	private MessageTableDetialService messageTableDetialService;
	
	@RequestMapping(value="/FindAll",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindAll(String page, String limit) {
		System.out.println(messageTableDetialService.FindAll());
		return LayUiListFormat(messageTableDetialService.FindAll());
	}

	@RequestMapping(value="/FindById",method=RequestMethod.POST)
	public ModelAndView FindById(@RequestParam Map<String, Object> Json) {
		return ForwardEditOrShow(Json);
	}

	@RequestMapping(value="/FindByKey",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindByKey(String keyword) {
		return LayUiListFormat(messageTableDetialService.FindByKey(keyword));
	}

	@RequestMapping(value="/Del",method=RequestMethod.POST)
	@ResponseBody
	public String Del(String Id) {
		return LayuiFormatResult(messageTableDetialService.DeleteById(Id));
	}

	@Override
	public String Add(MessageTableDetial o) {
		return LayuiFormatResult(messageTableDetialService.SaveOrEdit(o));
	}

	@Override
	public MessageTableDetial FindById(String Id) {
		return messageTableDetialService.FindById(Id);
	}

}

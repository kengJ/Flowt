package com.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.controller.IMessageTableController;
import com.model.MessageTable;
import com.service.MessageTableService;

@Controller
@RequestMapping(value="/MessageTable")
public class MessageTableControllerImpl extends BasicControllerImpl<MessageTable> implements IMessageTableController {

	@Autowired
	private MessageTableService messageTableService;
	
	@RequestMapping(value="/FindAll",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindAll(String page, String limit) {
		List<MessageTable> Data = messageTableService.FindAll();
		return LayUiListFormat(Data);
	}

	@RequestMapping(value="/FindById",method=RequestMethod.POST)
	public ModelAndView FindById(@RequestParam Map<String, Object> Json) {
		return ForwardEditOrShow(Json);
	}

	@RequestMapping(value="/FindByKey",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindByKey(String keyword,String page, String limit) {
		return LayUiListFormat(messageTableService.FindByKey(keyword));
	}

	@RequestMapping(value="/Del",method=RequestMethod.POST)
	@ResponseBody
	public String Del(String Id) {
		return LayuiFormatResult(messageTableService.DeleteById(Id));
	}

	@Override
	public String Add(MessageTable o) {
		return LayuiFormatResult(messageTableService.SaveOrEdit(o));
	}

	@Override
	public MessageTable FindById(String Id) {
		return messageTableService.FindById(Id);
	}

	public Map<String, Object> LayUiListFormat(List<MessageTable> Data) {
		List<Map<String,String>> ResultData = new ArrayList<Map<String,String>>();
		for(MessageTable Line : Data){
			Map<String,String> LineData = new HashMap<>();
			LineData.put("id", Line.getId().toString());
			LineData.put("name", Line.getName());
			LineData.put("upMenu", messageTableService.FindMenuName(Line.getId().toString()));
			LineData.put("url", Line.getUrl());
			LineData.put("title", Line.getTitle());
			LineData.put("type", Line.getType());//orderNo
			LineData.put("orderNo", Line.getOrderNo()+"");
			LineData.put("tip", Line.getTip());
			ResultData.add(LineData);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		//判断是否有数据
		if(Data!=null&Data.size()>0){
			result.put("code", "");
			result.put("msg", "");
			result.put("count", Data.size());
			result.put("data", ResultData);
		}else{
			result.put("code", "0");
			result.put("msg", "没有查到相应的数据");
			result.put("count", "0");
			result.put("data", new ArrayList<Map<String,String>>());
		}
		return result;
	}

	@RequestMapping(value="/Add",method=RequestMethod.POST)
	@ResponseBody
	public String Add(String Name, String Type, String Url, String Tip, String Title, String OrderNo) {
		return Add(new MessageTable(Name, Type, Url, Title, Integer.parseInt(OrderNo), Tip));
	}
}

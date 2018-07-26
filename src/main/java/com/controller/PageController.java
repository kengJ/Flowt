package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.model.MessageTable;
import com.model.MessageTableAction;
import com.model.MessageTableDetial;
import com.service.MessageTableService;
import com.util.ServerTool;
import com.util.StrUtil;

@Controller
@RequestMapping(value="/Page")
public class PageController {
	
	@Autowired
	private MessageTableService messageTableService;
	
	@RequestMapping(value="/ComputerEditPage")
	public ModelAndView ComputerEditPage(String Id,String Ip,String LoginName){
		ModelAndView mav  = new ModelAndView("Page/Computer/Edit");
		mav.addObject("id", Id);
		mav.addObject("ip", Ip);
		mav.addObject("loginName", LoginName);
		return mav;
	}
	
	/**@RequestMapping(value="/{action}Edit")
	public ModelAndView AddPage(@PathVariable("action")String action) {
		String ActionName = action.substring(0, 1).toUpperCase()+action.substring(1);
		return new ModelAndView("Page/"+ActionName+"/Edit");
	}**/
	
	@RequestMapping(value="/Edit")
	public ModelAndView Edit(HttpServletRequest request){
		List<Map<String, String>> ResultData = new ArrayList<Map<String, String>>();
		try {
			String ActionName = request.getAttribute("result").getClass().getSimpleName();
			//System.out.println(ActionName);
			MessageTable MessageTable =messageTableService.getMessageTable(ActionName);
			Map<String, String> Data = StrUtil.ObjectToMap(request.getAttribute("result"));//数据转换
			List<MessageTableDetial> MessageTableDetials = MessageTable.getMessageTableDetial();
			//把表字段配置信息匹配到request传过来的数据，并封装到list里
			for(MessageTableDetial mtd : MessageTableDetials ) {
				if(mtd.getIsEdit()==1){
					Map<String, String> line = new HashMap<String, String>();
					line.put("title", mtd.getTitle());
					line.put("Value", Data.get(mtd.getName()));
					line.put("name", mtd.getName());
					ResultData.add(line);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		ModelAndView mv = new ModelAndView("Page/Edit");
		mv.addObject("data", ResultData);
		return mv;
	}
	
	/**
	 * 普通数据展示请求
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/Show")
	public ModelAndView ShowPage(HttpServletRequest request){
		System.out.println(request.getAttribute("result").getClass().getSimpleName());
		//获取表字段配置信息
		MessageTable MessageTable =messageTableService.getMessageTable(request.getAttribute("result").getClass().getSimpleName());
		System.out.println(request.getAttribute("result"));
		Map<String, String> Data = StrUtil.ObjectToMap(request.getAttribute("result"));//数据转换
		List<Map<String, String>> ResultData = new ArrayList<Map<String, String>>();
		List<MessageTableDetial> MessageTableDetials = MessageTable.getMessageTableDetial();
		//System.out.println(MessageTableDetials);
		//把表字段配置信息匹配到request传过来的数据，并封装到list里
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
	
	@RequestMapping(value="/Index")
	public ModelAndView IndexPage(String ActionName){
		String Action = StrUtil.FormatFirstCharUp(ActionName);
		MessageTable MessageTable = messageTableService.getMessageTable(Action);
		String Title = MessageTable.getTitle();
		String Tip = MessageTable.getTip();
		ModelAndView mv = new ModelAndView("Page/BasicPage");
		mv.addObject("title", Title);//获取标题
		mv.addObject("tip", Tip);//获取提示
		mv.addObject("action", MessageTable.getName());
		List<MessageTableDetial> MessageTableDetials = MessageTable.getMessageTableDetial();
		List<Map<String, String>> Detials = new ArrayList<>();
		for(MessageTableDetial MessageTableDetial :MessageTableDetials){
			Map<String, String> line = new HashMap<>();
			line.put("title", MessageTableDetial.getTitle());
			line.put("field", MessageTableDetial.getKey());
			Detials.add(line);
		}
		mv.addObject("cols", Detials);
		Set<MessageTableAction> MessageTableActions = MessageTable.getMessageTableActions();
		String AppPath = ServerTool.GetAppPath();
		for(MessageTableAction MessageTableAction : MessageTableActions){
			mv.addObject("Action"+MessageTableAction.getType(), AppPath+MessageTableAction.getUrl());
		}
		return mv;
	}
	@RequestMapping(value="/AddPage")
	public ModelAndView AddPage(String ActionName){
		List<Map<String, String>> ResultData = new ArrayList<Map<String, String>>();
		String Action = StrUtil.FormatFirstCharUp(ActionName);
		MessageTable MessageTable = messageTableService.getMessageTable(Action);
		List<MessageTableDetial> MessageTableDetials = MessageTable.getMessageTableDetial();
		for(MessageTableDetial MessageTableDetial : MessageTableDetials){
			if(MessageTableDetial.getIsAdd()==1){
				Map<String, String> line = new HashMap<String, String>();
				line.put("title", MessageTableDetial.getTitle());
				line.put("name", MessageTableDetial.getName());
				ResultData.add(line);
			}
		}
		ModelAndView mv = new ModelAndView("Page/AddPage");
		mv.addObject("data", ResultData);
		return mv;
	}
}

package com.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.model.MessageTable;
import com.model.MessageTableAction;
import com.model.MessageTableDetial;
import com.service.MessageTableService;
import com.service.PageService;
import com.util.ServerTool;
import com.util.StrUtil;

/***
 * 页面处理控制器
 * 基础页面的切换和基础模块的处理，只限无关联关系的表
 * @author heyanzhu
 *
 */
@Controller
@RequestMapping(value="/Page")
public class PageController {
	
	@Autowired
	private MessageTableService messageTableService;
	
	@Autowired
	private PageService PageService;
	
//	@RequestMapping(value="/ComputerEditPage")
//	public ModelAndView ComputerEditPage(String Id,String Ip,String LoginName){
//		ModelAndView mav  = new ModelAndView("Page/Computer/Edit");
//		mav.addObject("id", Id);
//		mav.addObject("ip", Ip);
//		mav.addObject("loginName", LoginName);
//		return mav;
//	}
	
	@RequestMapping(value="/EditPage")
	public ModelAndView EditPage(HttpServletRequest request){
		List<Map<String, String>> ResultData = new ArrayList<Map<String, String>>();
		try {
			String ActionName = request.getAttribute("result").getClass().getSimpleName();
			MessageTable MessageTable =messageTableService.FindMessageTable(ActionName);
			Map<String, String> Data = StrUtil.ObjectToMap(request.getAttribute("result"));//数据转换
			List<MessageTableDetial> MessageTableDetials = MessageTable.getMessageTableDetial();
			//把表字段配置信息匹配到request传过来的数据，并封装到list里
			for(MessageTableDetial mtd : MessageTableDetials ) {
				if(mtd.getName()!=null&!mtd.getName().equals("")){
					if(mtd.getIsEdit()==1){
						Map<String, String> line = new HashMap<String, String>();
						line.put("title", mtd.getTitle());
						line.put("Value", Data.get(mtd.getName()));
						line.put("name", mtd.getName());
						ResultData.add(line);
					}
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
	@RequestMapping(value="/ShowPage")
	public ModelAndView ShowPagePage(HttpServletRequest request){
		//获取表字段配置信息
		MessageTable MessageTable =messageTableService.FindMessageTable(request.getAttribute("result").getClass().getSimpleName());
		Map<String, String> Data = StrUtil.ObjectToMap(request.getAttribute("result"));//数据转换
		List<Map<String, String>> ResultData = new ArrayList<Map<String, String>>();
		List<MessageTableDetial> MessageTableDetials = MessageTable.getMessageTableDetial();
		//把表字段配置信息匹配到request传过来的数据，并封装到list里
		for(MessageTableDetial mtd : MessageTableDetials ) {
			if(mtd.getName()!=null&!mtd.getName().equals("")){
				Map<String, String> line = new HashMap<String, String>();
				line.put("title", mtd.getTitle());
				line.put("Value", Data.get(mtd.getName()));
				ResultData.add(line);	
			}
		}
		ModelAndView mv = new ModelAndView("Page/Show");
		mv.addObject("data", ResultData);
		return mv;
	}

	@RequestMapping(value="/AddPage")
	public ModelAndView AddPage(String ActionName){
		List<Map<String, String>> ResultData = new ArrayList<Map<String, String>>();
		String Action = StrUtil.FormatFirstCharUp(ActionName);
		MessageTable MessageTable = messageTableService.FindMessageTable(Action);
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
	
	@RequestMapping(value="/FindAll",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindAll(String ActionName,String page, String limit){
		return LayUiListFormat(PageService.FindAll(ActionName), page, limit);
	}
	
	
	@RequestMapping(value="/Index")
	public ModelAndView IndexPage(String ActionName){
		String Action = StrUtil.FormatFirstCharUp(ActionName);
		MessageTable MessageTable = messageTableService.FindMessageTable(Action);
		String Title = MessageTable.getTitle();
		String Tip = MessageTable.getTip();
		ModelAndView mv = new ModelAndView("Page/BasicPage");
		mv.addObject("title", Title);//获取标题
		mv.addObject("tip", Tip);//获取提示
		mv.addObject("width", "500px");//获取提示
		mv.addObject("action", MessageTable.getName());
		List<MessageTableDetial> MessageTableDetials = MessageTable.getMessageTableDetial();
		List<Map<String, String>> Detials = new ArrayList<>();
		for(MessageTableDetial MessageTableDetial :MessageTableDetials){
			Map<String, String> line = new HashMap<>();
			line.put("title", MessageTableDetial.getTitle());
			line.put("field", MessageTableDetial.getKeyName());
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

	@RequestMapping(value="/LoginPage")
	public String LoginPage(){
		return "Login/UiTest";
	}
	
	@RequestMapping("/Logout")
	public String Ladyout(){
		return "Login/UiTest";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Object> LayUiListFormat(List<?> Data,String page, String limit) {
		Map<String, Object> result = new HashMap<String, Object>();
		//判断是否有数据
		if(Data!=null){
			int Max = Data.size();
			int StartIndex = (Integer.parseInt(page)-1)*Integer.parseInt(limit);
			int EndIndex = StartIndex+Integer.parseInt(limit)>Max?Max:StartIndex+Integer.parseInt(limit);
			List ResultData = new ArrayList<>();
			for(int i = StartIndex;i<EndIndex;i++){
				ResultData.add(Data.get(i));
			}
			result.put("code", "");
			result.put("msg", "");
			result.put("count", Max);
			result.put("data", ResultData);
		}else{
			result.put("code", "0");
			result.put("msg", "没有查到相应的数据");
			result.put("count", "0");
			result.put("data", new ArrayList());
		}
		return result;
	}
}

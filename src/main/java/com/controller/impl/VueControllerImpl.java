package com.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controller.VueController;
import com.model.VueMenuItem;
import com.model.VueTable;
import com.service.VueTableService;

/**
 * 处理 vue 界面问题
 * @author heyanzhu
 *
 */
@Controller
@RequestMapping(value="/Vue")
public class VueControllerImpl implements VueController{

	@Autowired
	private VueTableService vueTableService;
	
	@Override
	@RequestMapping(value="/FindMenus",method=RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> FindMenus() {
		List<Map<String, Object>> Result = new ArrayList<Map<String, Object>>();
		List<VueTable> VueTables = vueTableService.FindAll();
		for(VueTable VueTable : VueTables){
			String icon = VueTable.getIcon();
			String index = VueTable.getId().toString();
			String title = VueTable.getTtile();
			List<Map<String, String>> subs = new ArrayList<>();
			List<VueMenuItem> VueMenuItems = VueTable.getVueMenuItems();
			for(VueMenuItem VueMenuItem : VueMenuItems){
				String subIndex = VueMenuItem.getIndex();
				String subTitile = VueMenuItem.getTitle();
				Map<String, String> SubResult = new HashMap<>();
				SubResult.put("index", subIndex);
				SubResult.put("title", subTitile);
				subs.add(SubResult);
			}
			Map<String, Object> ResultLine = new HashMap<>();
			ResultLine.put("icon", icon);
			ResultLine.put("index", index);
			ResultLine.put("title", title);
			ResultLine.put("subs", subs);
			Result.add(ResultLine);
		}
		return Result;
	}

	
}

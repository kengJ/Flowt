package com.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageBox {

	public static Map<String, Object> UserMessageBox(String Key,String Value){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("key", Key);
		result.put("value", Value);
		return result;
	}
	
	public static Map<String, Object> SuccessBox(String Value){
		return MessageBox.UserMessageBox("success", Value);
	}
	
	public static Map<String, Object> ErrorBox(String Value){
		return MessageBox.UserMessageBox("error", Value);
	}
	/**
	 * 含数据列表返回信息
	 * @param Value
	 * @param DataList
	 * @return
	 */
	public static Map<String, Object> SuccessBox(Object Value,List<?> DataList){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("key", "success");
		result.put("value", Value);
		result.put("list", DataList);
		return result;
	}
}

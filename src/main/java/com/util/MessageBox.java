package com.util;

import java.util.HashMap;
import java.util.Map;

public class MessageBox {

	public static Map<String, Object> UserMessageBox(String Key,Object Value){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("key", Key);
		result.put("value", Value);
		return result;
	}
	
	public static Map<String, Object> SuccessBox(Object Value){
		return MessageBox.UserMessageBox("success", Value);
	}
	
	public static Map<String, Object> ErrorBox(Object Value){
		return MessageBox.UserMessageBox("error", Value);
	}
}

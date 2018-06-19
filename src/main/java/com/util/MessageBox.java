package com.util;

import java.util.HashMap;
import java.util.Map;

public class MessageBox {

	public static Map<String, String> UserMessageBox(String Key,String Value){
		Map<String, String> result = new HashMap<String, String>();
		result.put("key", Key);
		result.put("value", Value);
		return result;
	}
}

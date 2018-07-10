package com.util;

import java.util.regex.Pattern;

/**
 * 字符串工具类
 * @author heyanzhu
 *
 */
public class StrUtil {

	/**
	 * 利用正则表达式判断传入值是否含有
	 * @param Value
	 * @return
	 */
	public static boolean IsNotNullOrBank(String Value){
		if(Value.trim().length()==0) return false;
		String pattern = ".*_blank.*";
		return !Pattern.matches(pattern, Value);
	}
}

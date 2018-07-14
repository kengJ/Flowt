package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	/**
	 * 格式化日期
	 * @param Date
	 * @return
	 */
	public static String FormatDate(Date Date){
		return FormatDateTime("yyyy-MM-dd",Date);
	}
	
	/**
	 * 格式化日期(含时间)
	 * @param Date
	 * @return
	 */
	public static String FormatDateTime(Date Date){
		return FormatDateTime("yyyy-MM-dd HH:mm:ss",Date);
	}
	
	/**
	 * 格式化日期
	 * @param FormatStr 格式字符串
	 * @param Date 需要格式化的日期
	 * @return 字符串日期
	 */
	public static String FormatDateTime(String FormatStr ,Date Date){
		SimpleDateFormat sdf = new SimpleDateFormat(FormatStr);
		return sdf.format(Date);
	}
}

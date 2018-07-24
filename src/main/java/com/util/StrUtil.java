package com.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
	
	/**
	 * 对象转换成Map
	 * @param obj
	 * @return
	 */
	public static Map<String, String> ObjectToMap(Object obj){
		Field[] fields = obj.getClass().getDeclaredFields();
		Map<String, String> Result = new HashMap<String, String>();
		for(int i = 0; i < fields.length; i++){
			Field subField;
			try {
				subField = obj.getClass().getDeclaredField(fields[i].getName());
				subField.setAccessible(true);
				Object o = subField.get(obj);
				Result.put(fields[i].getName(), o.toString());
			} catch (NoSuchFieldException e) {
				System.out.println(e);
			} catch (SecurityException e) {
				System.out.println(e);
			} catch (IllegalArgumentException e) {
				System.out.println(e);
			} catch (IllegalAccessException e) {
				System.out.println(e);
			}
		}
		return Result;
	}
	
	/**
	 * 字符串格式化>首字母大写
	 * @param Str
	 * @return
	 */
	public static String FormatFirstCharUp(String Str){
		String pattern = "^[A-Z]{1}[A-Za-z]+";
		boolean check = Pattern.matches(pattern, Str);
		if(check){
			return Str;
		}
		pattern = "^[A-Za-z]+";
		check = Pattern.matches(pattern, Str);
		if(check){
			return Str.substring(0,1).toUpperCase()+Str.substring(1);
		}else{
			return "-1";
		}
	}
}

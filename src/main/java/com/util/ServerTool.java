package com.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ServerTool {
	
	/**
	 * 获取request
	 * @return
	 */
	public static HttpServletRequest GetRequest(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取客户端IP
	 * @param Request
	 * @return
	 */
	public static String GetClientIp(){
		HttpServletRequest Request = ServerTool.GetRequest();
		String remoteAddr = "";
		remoteAddr = Request.getHeader("x-forwarded-for");
		
		if(remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr)) remoteAddr = Request.getHeader("Proxy-Client-IP");
		
		if(remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr)) remoteAddr = Request.getHeader("WL-Proxy-Client-IP");
	
		if(remoteAddr == null || remoteAddr.length() == 0 || "unknown".equalsIgnoreCase(remoteAddr)) remoteAddr = Request.getRemoteAddr();
		
		return remoteAddr;
	}
	
	/**
	 * 获取请求链接
	 * @param Request
	 * @return
	 */
	public static String GetUrl(){
		HttpServletRequest Request = ServerTool.GetRequest();
		return Request.getRequestURI();
	}
	
	/**
	 * 获取应用地址
	 * @return
	 */
	public static String GetAppPath(){
		HttpServletRequest Request = ServerTool.GetRequest();
		return Request.getContextPath();
	}
}

package com.service;

import org.springframework.stereotype.Service;
import com.model.InterceptedLog;


public interface InterceptedLogService extends BasicService<InterceptedLog> {
	boolean SaveInterceptedComputer(String Ip, String Url);
}

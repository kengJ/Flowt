package com.service;

import org.springframework.stereotype.Service;
import com.model.InterceptedLog;

@Service
public interface IInterceptedLogService extends IBasicService<InterceptedLog> {
	boolean SaveInterceptedComputer(String Ip, String Url);
}

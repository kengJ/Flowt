package com.service;

import java.util.List;
import java.util.Map;

public interface PageService {
	List<?> FindAll(String ActionName);
	String Add(Map<String,String> Data,String ActionName);
	String Edit(Map<String, String> Data, String ActionName);
}

package com.controller;

import org.springframework.stereotype.Controller;
import com.model.SystemType;

@Controller
public interface ISystemTypeController extends IBasicController<SystemType> {
	String Add(String name, String key);
}

package com.controller;

import com.model.MessageTable;

public interface IMessageTableController extends IBasicController<MessageTable>{
	String Add(String Name,String Type,String Url,String Tip,String Title,String OrderNo);
}

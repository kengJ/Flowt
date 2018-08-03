package com.service;

import com.model.MessageTable;

public interface MessageTableService extends BasicService<MessageTable> {
	MessageTable FindMessageTable(String ActionName);
	String FindMenuName(String Id);
}

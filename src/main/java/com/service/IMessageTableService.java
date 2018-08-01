package com.service;

import org.springframework.stereotype.Service;
import com.model.MessageTable;

@Service
public interface IMessageTableService extends IBasicService<MessageTable> {
	MessageTable FindMessageTable(String ActionName);
}

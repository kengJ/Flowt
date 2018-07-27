package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.MessageTable;
import com.repository.MessageTableRepository;

@Service
public class MessageTableService {

	@Autowired
	private MessageTableRepository messageTableRepository;
	
	public MessageTable  getMessageTable(String KeyName){
		MessageTable data = null;
		
		try {
			data =  messageTableRepository.FindByHql(String.format("from MessageTable where Type = 'Basic' and Name='%s' order by Id", KeyName)).get(0);
			System.out.println(data);
		} catch (Exception e) {
			
		}
		return data;
	}
	
	public MessageTable  getMessageTable(String KeyName,String Type){
		MessageTable data = null;
		
		try {
			String Sql = String.format("from MessageTable where Type = 'Basic' and Name='%s' order by Id", KeyName);
			data =  messageTableRepository.FindByHql(Sql).get(0);
			//System.out.println(data);
		} catch (Exception e) {
			
		}
		return data;
	}
}

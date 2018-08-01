package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.model.MessageTable;
import com.repository.IBasicRepository;
import com.repository.IMessageTableRepository;
import com.service.IMessageTableService;

public class MessageTableServiceImpl extends BasicServiceImpl<MessageTable> implements IMessageTableService{

	@Autowired
	private IMessageTableRepository messageTableRepository;

	@Override
	public List<MessageTable> FindByKey(String Key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBasicRepository<MessageTable> GetBasicRepository() {
		return messageTableRepository;
	}

	@Override
	public MessageTable FindMessageTable(String ActionName) {
		MessageTable data = null;
		try {
			data =  messageTableRepository.FindByHql(String.format("from MessageTable where Type = 'Basic' and Name='%s' order by Id", ActionName)).get(0);
		} catch (Exception e) {
			
		}
		return data;
	}
	
	/**public MessageTable  getMessageTable(String KeyName){
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
	}**/
}

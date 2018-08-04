package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.MessageTableDetial;
import com.repository.BasicRepository;
import com.repository.MessageTableDetialRepository;
import com.service.MessageTableDetialService;

@Service
public class MessageTableDetialServiceImpl extends BasicServiceImpl<MessageTableDetial> implements MessageTableDetialService{

	@Autowired
	private MessageTableDetialRepository messageTableDetialRepository;
	
	public List<MessageTableDetial> FindByKey(String Key) {
		String Hql = "from MessageTableDetial where Name like '%"+Key+"%' or Title like '%"+Key+"%' or KeyName like '%"+Key+"%'";
		return messageTableDetialRepository.FindByHql(Hql);
	}

	@Override
	public BasicRepository<MessageTableDetial> GetBasicRepository() {
		return messageTableDetialRepository;
	}

}

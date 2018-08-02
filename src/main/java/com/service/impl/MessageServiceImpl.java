package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Message;
import com.repository.BasicRepository;
import com.repository.MessageRepository;
import com.service.MessageService;
@Service(value="messageService")
public class MessageServiceImpl extends BasicServiceImpl<Message> implements MessageService{

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public List<Message> FindByKey(String Key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicRepository<Message> GetBasicRepository() {
		return messageRepository;
	}
	
	/**@Override
	public boolean Add(Message o) {
		return messageRepository.Save(o);
	}

	@Override
	public boolean Delete(Message o) {
		return messageRepository.Delete(o);
	}

	@Override
	public boolean Update(Message o) {
		return messageRepository.Update(o);
	}

	@Override
	public List<Message> FindAll() {
		return messageRepository.FindByHql("from Message");
	}

	@Override
	public Message FindById(String Id) {
		return messageRepository.FindByHql("from Message where Id ='"+Id+"'").get(0);
	}**/

}

package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Message;
import com.repository.MessageRepository;

@Service
public class MessageService implements BasicService<Message>{

	@Autowired
	private MessageRepository messageRepository;
	
	@Override
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
	}

}

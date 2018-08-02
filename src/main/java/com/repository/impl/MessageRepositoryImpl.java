package com.repository.impl;

import org.springframework.stereotype.Repository;

import com.model.Message;
import com.repository.MessageRepository;
@Repository(value="messageRepository")
public class MessageRepositoryImpl extends BasicRepositoryImpl<Message> implements MessageRepository {
}

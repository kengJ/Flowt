package com.repository.impl;

import org.springframework.stereotype.Repository;

import com.model.MessageTableDetial;
import com.repository.MessageTableDetialRepository;
@Repository(value="messageTableDetialRepository")
public class MessageTableDetialRepositoryImpl extends BasicRepositoryImpl<MessageTableDetial> implements MessageTableDetialRepository{

}

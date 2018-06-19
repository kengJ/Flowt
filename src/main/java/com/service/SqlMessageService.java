package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.SqlMessage;
import com.repository.SqlMessageRepository;

@Service
public class SqlMessageService {

	@Autowired
	private SqlMessageRepository sqlMessageRepository;
	
	public boolean AddSqlMessage(SqlMessage sqlMessage){
		return sqlMessageRepository.Save(sqlMessage);
	}
	
	public List<SqlMessage> FindSqlMessage(){
		return sqlMessageRepository.FindAll();
	}
	
	public boolean CheckMemoIsCreate(String Memo){
		return sqlMessageRepository.FindByMemo(Memo).size()>0;
	}
	
	public SqlMessage FindSqlMessage(String Id){
		return sqlMessageRepository.FindById(Id);
	}
}

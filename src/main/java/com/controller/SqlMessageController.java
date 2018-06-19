package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.SqlMessage;
import com.service.SqlMessageService;

@Controller
@RequestMapping("/SqlMessage")
public class SqlMessageController {
	
	@Autowired
	private SqlMessageService sqlMessageService;

	@RequestMapping("/AddSqlMessage")
	@ResponseBody
	public String AddSqlMessage(
			@RequestParam String Ip,
			@RequestParam String UserName,
			@RequestParam String Password,
			@RequestParam String Type,
			@RequestParam String Memo,
			@RequestParam String DbName
			){
		SqlMessage sqlMessage = new SqlMessage();
		sqlMessage.setIp(Ip);
		sqlMessage.setMemo(Memo);
		sqlMessage.setUserName(UserName);
		sqlMessage.setPassword(Password);
		sqlMessage.setType(Integer.parseInt(Type));
		sqlMessage.setDatabaseName(DbName);
		boolean result = sqlMessageService.AddSqlMessage(sqlMessage);
		return result?"success":"error";
	}
	
	@RequestMapping("/CheckMemoIsCreate")
	@ResponseBody
	public String CheckMemoIsCreate(@RequestParam String Memo){
		return sqlMessageService.CheckMemoIsCreate(Memo)?"1":"0";
	}
	
	@RequestMapping("/FindSqlMessages")
	@ResponseBody
	public List<SqlMessage> FindSqlMessages(){
		return sqlMessageService.FindSqlMessage();
	}
}

package com.controller.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.controller.ISqlMessageController;
import com.model.SqlMessage;
import com.service.SqlMessageService;

@Controller
@RequestMapping("/SqlMessage")
public class SqlMessageControllerImpl extends BasicControllerImpl<SqlMessage> implements ISqlMessageController {
	
	@Autowired
	private SqlMessageService sqlMessageService;

	@RequestMapping(value="/FindAll",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindAll(String page, String limit) {
		List<SqlMessage> Data = sqlMessageService.FindAll();
		return LayUiListFormat(Data);
	}

	@RequestMapping(value="/FindById",method=RequestMethod.POST)
	public ModelAndView FindById(Map<String, Object> Json) {
		return ForwardEditOrShow(Json);
	}

	@RequestMapping(value="/FindByKey",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> FindByKey(String keyword) {
		return LayUiListFormat(sqlMessageService.FindByKey(keyword));
	}

	@RequestMapping(value="/Del",method=RequestMethod.POST)
	@ResponseBody
	public String Del(String Id) {
		return LayuiFormatResult(sqlMessageService.DeleteById(Id));
	}

	@Override
	public String Add(SqlMessage o) {
		return LayuiFormatResult(sqlMessageService.SaveOrEdit(o));
	}

	@Override
	public SqlMessage FindById(String Id) {
		return sqlMessageService.FindById(Id);
	}

//	@RequestMapping("/AddSqlMessage")
//	@ResponseBody
//	public String AddSqlMessage(
//			@RequestParam String Ip,
//			@RequestParam String UserName,
//			@RequestParam String Password,
//			@RequestParam String Type,
//			@RequestParam String Memo,
//			@RequestParam String DbName
//			){
//		SqlMessage sqlMessage = new SqlMessage();
//		sqlMessage.setIp(Ip);
//		sqlMessage.setMemo(Memo);
//		sqlMessage.setUserName(UserName);
//		sqlMessage.setPassword(Password);
//		sqlMessage.setType(Integer.parseInt(Type));
//		sqlMessage.setDatabaseName(DbName);
//		boolean result = sqlMessageService.AddSqlMessage(sqlMessage);
//		return result?"success":"error";
//	}
//	
//	@RequestMapping("/CheckMemoIsCreate")
//	@ResponseBody
//	public String CheckMemoIsCreate(@RequestParam String Memo){
//		return sqlMessageService.CheckMemoIsCreate(Memo)?"1":"0";
//	}
//	
//	@RequestMapping("/FindSqlMessages")
//	@ResponseBody
//	public List<SqlMessage> FindSqlMessages(){
//		return sqlMessageService.FindSqlMessage();
//	}
//	@RequestMapping("/Find")
//	@ResponseBody
//	public Map<String, Object> Find(String Code){
//		return sqlMessageService.Find(Code);
//	}
}

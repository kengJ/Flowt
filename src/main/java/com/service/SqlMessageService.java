package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.SqlMessage;
import com.repository.SqlMessageRepository;
import com.util.MessageBox;

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
	
	public Map<String, Object> Find(String Code){
		List<SqlMessage> DataList = null;
		if(Code==""||Code.equals("")){
			DataList = sqlMessageRepository.FindByHql("from SqlMessage");
		}else{
			try{
				DataList = sqlMessageRepository.FindByHql(String.format("from SqlMessage where Memo like '%%s%' or Ip like '%%s%'", Code,Code));
			}catch (Exception e) {
				return MessageBox.ErrorBox("查询出错");
			}
		}
		if(DataList.size()>0&&DataList!=null){
			return MessageBox.SuccessBox("查询成功", DataList);
		}else{
			return MessageBox.ErrorBox("查询失败,未能找到相应的数据");
		}
	}
}

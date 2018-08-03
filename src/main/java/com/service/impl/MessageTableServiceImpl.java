package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.MessageTable;
import com.repository.BasicRepository;
import com.repository.MenuRepository;
import com.repository.MessageTableRepository;
import com.service.MessageTableService;

@Service(value="messageTableService")
public class MessageTableServiceImpl extends BasicServiceImpl<MessageTable> implements MessageTableService{

	@Autowired
	private MessageTableRepository messageTableRepository;
	
	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<MessageTable> FindByKey(String Key) {
		String Hql = "from MessageTable where Name like '%"+Key+"%' or Type like '%"+Key+"%' or Title like '%"+Key+"%'";
		return messageTableRepository.FindByHql(Hql);
	}

	@Override
	public BasicRepository<MessageTable> GetBasicRepository() {
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
	
	@Override
	public List<MessageTable> FindAll() {
		return messageTableRepository.FindByHql("from MessageTable Order By OrderNo,Id");
	}

	@Override
	public String FindMenuName(String Id) {
		//System.out.println(messageTableRepository.getCurrentSession().createSQLQuery("select Menu_id from messagetable where Id="+Id).list().get(0));
		try {
			String Menu_Id = messageTableRepository.getCurrentSession().createSQLQuery("select Menu_id from messagetable where Id="+Id).list().get(0).toString();
			return menuRepository.Get(Menu_Id.toString()).getTitle();
		} catch (Exception e) {
			return "";
		}
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

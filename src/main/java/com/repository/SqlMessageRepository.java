package com.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.model.SqlMessage;

@Repository
public class SqlMessageRepository extends BasicRepository<SqlMessage> {
	
	public boolean Save(SqlMessage sqlMessage){
		if(getCurrentSession().createQuery("from SqlMessage where Memo='"+sqlMessage.getMemo()+"'").list().size()<=0){
			getCurrentSession().save(sqlMessage);
			return true;
		}else{
			return false;
		}	
	}
	
	public List<SqlMessage> FindByMemo(String Memo){
		String Hql = "from SqlMessage where Memo = '"+Memo+"'";
		return FindByHql(Hql);
	}
	
	public boolean Delete(SqlMessage sqlMessage){
		try{
			getCurrentSession().delete(sqlMessage);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean Update(SqlMessage sqlMessage){
		try {
			getCurrentSession().update(sqlMessage);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public SqlMessage Find(SqlMessage sqlMessage){
		 return (SqlMessage) getCurrentSession().get(sqlMessage.getClass(), sqlMessage.getId());
	 }
	
	@SuppressWarnings("unchecked")
	public List<SqlMessage> FindAll(){
		return getCurrentSession().createQuery("from SqlMessage").list();
	}
	
	public SqlMessage FindById(String Id){
		String Hql = "From SqlMessage where Id="+Id;
		return  FindByHql(Hql).get(0);
	}
}

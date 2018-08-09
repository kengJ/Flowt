package com.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.model.HqlMessage;
import com.repository.HqlMessageRepository;
import com.service.PageService;
import com.util.StrUtil;

@Service
public class PageServiceImpl implements PageService {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private HqlMessageRepository hqlMessageRepository;
	
	public Session getCurrentSession() {
        return hibernateTemplate.getSessionFactory().getCurrentSession();
	}

	@Override
	public List<?> FindAll(String ActionName) {
		return getCurrentSession().createQuery("from "+ActionName).list();
	}

	@Override
	public String Add(Map<String,String> Data,String ActionName) {
		HqlMessage HqlMessage = hqlMessageRepository.FindByHql("from HqlMessage where ActionName = '"+ActionName+"' and Type = 'Add'").get(0);
		String Hql = HqlMessage.getHql();
		Query query = getCurrentSession().createQuery(StrUtil.FormatStr(Data, Hql));
		int Result = query.executeUpdate();
		return Result>0?"success":"error";
	}
	
	@Override
	public String Edit(Map<String,String> Data,String ActionName) {
		HqlMessage HqlMessage = hqlMessageRepository.FindByHql("from HqlMessage where ActionName = '"+ActionName+"' and Type = 'Edit'").get(0);
		String Hql = HqlMessage.getHql();
		Query query = getCurrentSession().createQuery(StrUtil.FormatStr(Data, Hql));
		int Result = query.executeUpdate();
		return Result>0?"success":"error";
	}

}

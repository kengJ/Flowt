package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.VueTable;
import com.repository.BasicRepository;
import com.repository.VueTableRepository;
import com.service.VueTableService;

@Service
public class VueTableServiceImpl extends BasicServiceImpl<VueTable> implements VueTableService{

	@Autowired
	private VueTableRepository vueTableRepository;
	
	@Override
	public List<VueTable> FindByKey(String Key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicRepository<VueTable> GetBasicRepository() {
		return vueTableRepository;
	}

}

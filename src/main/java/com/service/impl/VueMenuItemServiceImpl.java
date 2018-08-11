package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.VueMenuItem;
import com.repository.BasicRepository;
import com.repository.VueMenuItemRepository;
import com.service.VueMenuItemService;

@Service
public class VueMenuItemServiceImpl extends BasicServiceImpl<VueMenuItem> implements VueMenuItemService{

	@Autowired
	private VueMenuItemRepository vueMenuItemRepository;
	
	@Override
	public List<VueMenuItem> FindByKey(String Key) {
		return null;
	}

	@Override
	public BasicRepository<VueMenuItem> GetBasicRepository() {
		return vueMenuItemRepository;
	}

}

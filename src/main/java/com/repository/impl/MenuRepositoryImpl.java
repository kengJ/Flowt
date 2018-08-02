package com.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Menu;
import com.repository.MenuRepository;
@Repository(value="menuRepository")
public class MenuRepositoryImpl extends BasicRepositoryImpl<Menu> implements MenuRepository{

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> FindAll() {
		return getCurrentSession().createQuery("from Menu Order By OrderNo desc").list();
	}
}

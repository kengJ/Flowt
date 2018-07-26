package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Menu;
import com.repository.MenuRepository;

@Service
public class MenuService implements BasicService<Menu>{

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public boolean Add(Menu o) {
		menuRepository.Save(o);
		return true;
	}

	@Override
	public boolean Delete(Menu o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Menu o) {
		menuRepository.Update(o);
		return true;
	}

	@Override
	public List<Menu> FindAll() {
		return menuRepository.FindByHql("from Menu");
	}

	@Override
	public Menu FindById(String Id) {
		List<Menu> Menus = menuRepository.FindByHql(String.format("from Menu where Id='%s'", Id));
		if(Menus.size()>0){
			return Menus.get(0);
		}
		return null;
	}
}

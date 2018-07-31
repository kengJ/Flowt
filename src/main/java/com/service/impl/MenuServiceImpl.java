package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.model.Menu;
import com.repository.IBasicRepository;
import com.repository.IMenuRepository;
import com.service.IMenuService;

public class MenuServiceImpl extends BasicServiceImpl<Menu> implements IMenuService{

	@Autowired
	private IMenuRepository menuRepository;

	@Override
	public List<Menu> FindByKey(String Key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBasicRepository<Menu> GetBasicRepository() {
		return menuRepository;
	}

	/**public BasicRepositoryImpl<Menu> GetRepository(){
		return menuRepository;
	}
	
	@Override
	public boolean Add(Menu o) {
		menuRepository.Save(o);
		return true;
	}

	@Override
	public boolean Delete(Menu o) {
		menuRepository.Delete(o);
		return true;
	}
	
	public boolean DeleteByKey(String Id){
		Menu menu = FindById(Id);
		Delete(menu);
		return true;
	}

	@Override
	public boolean Update(Menu o) {
		menuRepository.Update(o);
		return true;
	}
	
	@Override
	public List<Menu> FindAll() {
		return menuRepository.FindByHql("from Menu Order by OrderBy,Id");
	}

	@Override
	public Menu FindById(String Id) {
		List<Menu> Menus = menuRepository.FindByHql(String.format("from Menu where Id='%s'", Id));
		if(Menus.size()>0){
			return Menus.get(0);
		}
		return null;
	}
	
	public List<Menu> FindByKey(String Key) {
		System.out.println(Key);
		Key = "'%"+Key+"%'";
		System.out.println(Key);
		Object[] subsql = {Key};
		String Sql = MessageFormat.format("from Menu where Memo like {0} or Name like {0} or Title like {0}", subsql);
		return super.FindByKey(Sql);
	}**/
}

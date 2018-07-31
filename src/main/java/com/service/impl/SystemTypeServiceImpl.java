package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.model.SystemType;
import com.repository.IBasicRepository;
import com.repository.ISystemTypeRepository;
import com.service.ISystemTypeService;

public class SystemTypeServiceImpl extends BasicServiceImpl<SystemType> implements ISystemTypeService{
	
	@Autowired
	private ISystemTypeRepository systemTypeRepository;

	@Override
	public List<SystemType> FindByKey(String Key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBasicRepository<SystemType> GetBasicRepository() {
		return systemTypeRepository;
	}

	/**@Override
	public boolean Add(SystemType o) {
		try {
			systemTypeRepository.Save(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean Delete(SystemType o) {
		try {
			systemTypeRepository.Delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean Update(SystemType o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SystemType> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SystemType FindById(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SystemType> Find(String Code){
		return systemTypeRepository.FindByHql(String.format("form SystemType where Name like '%%s%' or Key like '%%s%'", Code,Code));
	}
	
	public boolean Del(String Id){
		SystemType SystemType = null;
		try {
			SystemType = systemTypeRepository.FindByHql(String.format("from SystemType where Id = '%s'", Id)).get(0);
		} catch (Exception e) {
			SystemType = null;
		}
		if(SystemType==null) return false;
		systemTypeRepository.Delete(SystemType);
		return true;
	}**/
}

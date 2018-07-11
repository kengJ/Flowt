package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.model.SystemType;
import com.repository.SystemTypeRepository;

public class SystemTypeService implements BasicService<SystemType>{
	
	@Autowired
	private SystemTypeRepository systemTypeRepository;

	@Override
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

}

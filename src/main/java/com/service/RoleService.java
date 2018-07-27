package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Role;
import com.repository.RoleRepository;

@Service
public class RoleService extends BasicServiceImpl<Role> implements BasicService<Role> {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public boolean Add(Role o) {
		try {
			roleRepository.Save(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean Delete(Role o) {
		try {
			roleRepository.Delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean Update(Role o) {
		try {
			roleRepository.Update(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Role> FindAll() {
		try {
			return roleRepository.FindByHql("from Role");
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Role FindById(String Id) {
		try {
			return roleRepository.FindByHql(String.format("from Role where Id = '%s'", Id)).get(0);
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Role> FindByName(String Name){
		try {
			return roleRepository.FindByHql(String.format("from Role where RoleName like '%%s%'", Name));
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean AddRole(String RoleName,String Memo){
		List<Role> Roles = roleRepository.FindByHql(String.format("from Role where RoleName = '%s'", RoleName));
		if(Roles.size()<=0){
			this.Add(new Role(RoleName, Memo));
			return true;
		}else{
			return false;
		}
	}
	
}

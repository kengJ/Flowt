package com.repository.impl;

import org.springframework.stereotype.Repository;

import com.model.Role;
import com.repository.RoleRepository;
@Repository(value="roleRepository")
public class RoleRepositoryImpl extends BasicRepositoryImpl<Role> implements RoleRepository {
	
}

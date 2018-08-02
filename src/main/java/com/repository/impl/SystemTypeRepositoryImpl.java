package com.repository.impl;

import org.springframework.stereotype.Repository;

import com.model.SystemType;
import com.repository.SystemTypeRepository;
@Repository(value="systemTypeRepository")
public class SystemTypeRepositoryImpl extends BasicRepositoryImpl<SystemType> implements SystemTypeRepository{

}

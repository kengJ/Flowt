package com.repository.impl;

import org.springframework.stereotype.Repository;

import com.model.Computer;
import com.repository.ComputerRepository;
@Repository(value="computerRepository")
public class ComputerRepositoryImpl extends BasicRepositoryImpl<Computer> implements ComputerRepository{

}

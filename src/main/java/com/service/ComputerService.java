package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Computer;
import com.repository.ComputerRepository;

@Service
public class ComputerService {

	@Autowired
	private ComputerRepository computerRepository;
	
	public boolean AddComputer(Computer computer){
		try{
			computerRepository.Save(computer);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
}

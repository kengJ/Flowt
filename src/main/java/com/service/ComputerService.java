package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Computer;
import com.repository.ComputerRepository;

@Service
public class ComputerService implements BasicService<Computer>{

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
	
	public List<Computer> FindAll() {
		return computerRepository.FindByHql("form Computer");
	}

	public Computer FindById(String Id) {
		try {
			return computerRepository.FindByHql(String.format("from Computer where Id = '%s'", Id)).get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public boolean Add(Computer o) {
		try {
			computerRepository.Save(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean Delete(Computer o) {
		try {
			computerRepository.Delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean Update(Computer o) {
		try {
			computerRepository.Update(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean FindByIP(String Ip){
		List<Computer> computers =  computerRepository.FindByHql(String.format("select Id from Computer where Ip = '%s'", Ip));
		return computers.size()>0;
	}
}

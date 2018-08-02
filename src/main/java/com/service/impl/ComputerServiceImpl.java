package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Computer;
import com.repository.BasicRepository;
import com.repository.ComputerRepository;
import com.service.ComputerService;
@Service(value="computerService")
public class ComputerServiceImpl extends BasicServiceImpl<Computer> implements ComputerService{

	@Autowired
	private ComputerRepository computerRepository;

	@Override
	public BasicRepository<Computer> GetBasicRepository() {
		return computerRepository;
	}

	@Override
	public List<Computer> FindByKey(String Key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean FindByIP(String Ip) {
		List<Computer> computers =  computerRepository.FindByHql(String.format("select Id from Computer where Ip like '%s'", Ip));
		return computers.size()>0;
	}
	
	/**public boolean AddComputer(Computer computer){
		try{
			computerRepository.Save(computer);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public List<Computer> FindAll() {
		return computerRepository.FindByHql("from Computer");
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
			computerRepository.SaveOrUpdate(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean FindByIP(String Ip){
		List<Computer> computers =  computerRepository.FindByHql(String.format("select Id from Computer where Ip = '%s'", Ip));
		return computers.size()>0;
	}
	
	public List<Computer> FindByKey(String Key){
		return computerRepository.FindByHql("from Computer where LoginName like '%"+Key+"%' or Ip like '%"+Key+"%' or UserCode like '%"+Key+"%' or UserName like '%"+Key+"%' ");
	}

	@Override
	public boolean DeleteById(String Id) {
		Computer Computer = FindById(Id);
		if(Computer!=null){
			Delete(Computer);
		}
		return false;
	}**/
}

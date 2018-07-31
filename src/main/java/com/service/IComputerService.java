package com.service;

import org.springframework.stereotype.Service;
import com.model.Computer;

@Service
public interface IComputerService extends IBasicService<Computer> {
	boolean FindByIP(String Ip);
}

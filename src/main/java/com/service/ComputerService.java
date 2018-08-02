package com.service;

import com.model.Computer;

public interface ComputerService extends BasicService<Computer> {
	boolean FindByIP(String Ip);
}

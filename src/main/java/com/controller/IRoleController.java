package com.controller;

import java.util.List;

import com.model.Role;

public interface IRoleController extends IBasicController<Role> {

	List<Role> FindAll();
}

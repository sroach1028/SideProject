package com.sideproject.services;

import java.util.List;

import com.sideproject.entities.User;

public interface UserSvc {

	List<User> findAll();
	User findById(int id);
	User getUserByUsername(String name);
}

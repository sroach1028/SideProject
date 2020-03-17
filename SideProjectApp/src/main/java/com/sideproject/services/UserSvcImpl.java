package com.sideproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sideproject.entities.User;
import com.sideproject.repositories.UserRepo;

@Transactional
@Service
public class UserSvcImpl implements UserSvc {

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String name) {
		return userRepo.findByUsername(name);
	}
}

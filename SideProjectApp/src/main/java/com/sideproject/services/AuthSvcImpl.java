package com.sideproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sideproject.entities.User;
import com.sideproject.repositories.AddressRepo;
import com.sideproject.repositories.UserRepo;

@Service
public class AuthSvcImpl implements AuthSvc {
	
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private AddressRepo addressRepo;

	@Override
	public User register(User user) {

		String encrypted = encoder.encode(user.getPassword());
		user.setPassword(encrypted);

		user.setEnabled(true);
		
//		user.setAvatarImage(imageRepo.findById(1));

		user.setRole("standard");
//		addressRepo.saveAndFlush(user.getAddress());
		userRepo.saveAndFlush(user);
		return user;
	}

	@Override
	public boolean isUserUnique(String username, String email) {
		List<User> allUsers = userRepo.findAll();

		boolean isUnique = true;

		for (User user : allUsers) {
			if ((user.getEmail().equalsIgnoreCase(email)) || (user.getUsername().equalsIgnoreCase(username))) {
				isUnique = false;
			}

		}

		return isUnique;
	}

	@Override
	public boolean isUserUsernameUnique(String username) {
		List<User> allUsers = userRepo.findAll();
		
		boolean isUnique = true;
		
		for (User user : allUsers) {
			if ((user.getUsername().equalsIgnoreCase(username))) {
				isUnique = false;
			}
			
		}
		
		return isUnique;
	}

	@Override
	public boolean isUserEmailUnique(String email) {
		List<User> allUsers = userRepo.findAll();
		
		boolean isUnique = true;
		
		for (User user : allUsers) {
			if ((user.getEmail().equalsIgnoreCase(email))) {
				isUnique = false;
			}
			
		}
		
		return isUnique;
	}

}

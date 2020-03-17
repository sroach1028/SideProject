package com.sideproject.services;

import com.sideproject.entities.User;

public interface AuthSvc {

	public User register(User user);
	public boolean isUserUsernameUnique(String username);
	public boolean isUserEmailUnique(String email);
	public boolean isUserUnique(String username, String email);
}

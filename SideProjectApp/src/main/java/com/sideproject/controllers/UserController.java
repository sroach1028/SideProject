package com.sideproject.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sideproject.entities.User;
import com.sideproject.services.UserSvc;

@RestController
@CrossOrigin({"*", "http://localhost:4210"})
public class UserController {
	
	@Autowired
	private UserSvc userSvc;
	
	@GetMapping("api/users")
	public List<User> findAllUsers(HttpServletResponse resp, Principal principal){
		return userSvc.findAll();
	}
	
	@GetMapping("api/users/getUser")
	public User getUser(HttpServletResponse resp, Principal principal) {
		User user = userSvc.getUserByUsername(principal.getName());
		if (user == null) {
			resp.setStatus(404);
		} else
			resp.setStatus(200);
		return user;	}

}

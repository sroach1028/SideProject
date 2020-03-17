package com.sideproject.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sideproject.entities.User;
import com.sideproject.services.AuthSvc;
import com.sideproject.services.UserSvc;

@RestController
@CrossOrigin({ "*", "http://localhost:4210" })
public class AuthController {

	@Autowired
	private AuthSvc authService;
	
	@Autowired
	private UserSvc userSvc;

	@PostMapping("/register")
	public User register(@RequestBody User user, HttpServletResponse res) {

		if (!authService.isUserUnique(user.getUsername(), user.getEmail())) {
			user = null;

		}

		if (user == null) {
			res.setStatus(400);
			return null;
		}

		user = authService.register(user);
		return user;
	}

	@GetMapping("/authenticate")
	public Principal authenticate(Principal principal) {
		
		User loggedInUser = userSvc.getUserByUsername(principal.getName());
		if(!loggedInUser.isEnabled()) {
			principal = null;
		}
		
		return principal;
	}

}

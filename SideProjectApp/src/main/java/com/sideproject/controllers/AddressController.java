package com.sideproject.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sideproject.entities.Address;
import com.sideproject.services.AddressSvc;

@RestController
@CrossOrigin({"*", "http://localhost:4210"})
public class AddressController {
	
	@Autowired
	private AddressSvc addressSvc;
	
	@GetMapping("addresses")
	public List<Address> findAllAddresses(HttpServletResponse resp){
		return addressSvc.findAll();
	}

}

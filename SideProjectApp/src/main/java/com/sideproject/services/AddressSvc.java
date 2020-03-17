package com.sideproject.services;

import java.util.List;

import com.sideproject.entities.Address;

public interface AddressSvc {

	List<Address> findAll();
	Address findById(int id);
}

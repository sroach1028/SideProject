package com.sideproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sideproject.entities.Address;
import com.sideproject.repositories.AddressRepo;

@Transactional
@Service
public class AddressSvcImpl implements AddressSvc {

	@Autowired
	private AddressRepo addressRepo;

	@Override
	public List<Address> findAll() {
		return addressRepo.findAll();
	}

	@Override
	public Address findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

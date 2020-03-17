package com.sideproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sideproject.entities.Item;
import com.sideproject.repositories.ItemRepo;

@Transactional
@Service
public class ItemSvcImpl implements ItemSvc {

	@Autowired
	private ItemRepo itemRepo;

	@Override
	public List<Item> findAll() {
		return itemRepo.findAll();
	}

	@Override
	public Item findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

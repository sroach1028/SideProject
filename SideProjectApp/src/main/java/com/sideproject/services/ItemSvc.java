package com.sideproject.services;

import java.util.List;

import com.sideproject.entities.Item;

public interface ItemSvc {

	List<Item> findAll();
	
	Item findById (int id);
}

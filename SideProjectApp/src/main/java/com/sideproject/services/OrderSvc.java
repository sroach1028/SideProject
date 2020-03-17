package com.sideproject.services;

import java.util.List;

import com.sideproject.entities.Image;
import com.sideproject.entities.Order;

public interface OrderSvc {

	List<Order> findAll();
	
	Order findById(int id);
	
	Order newOrder(Order order);
	
	Order trackOrder(int id, String email);
}

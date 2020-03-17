package com.sideproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sideproject.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {
	
	Order findByIdAndCustomer_Email(int id, String email);

}

package com.sideproject.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sideproject.entities.Order;
import com.sideproject.repositories.AddressRepo;
import com.sideproject.repositories.ItemRepo;
import com.sideproject.repositories.OrderRepo;
import com.sideproject.repositories.UserRepo;

@Transactional
@Service
public class OrderSvcImpl implements OrderSvc {

	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ItemRepo itemRepo;
	@Autowired
	private AddressRepo addressRepo;

	@Override
	public List<Order> findAll() {
		return orderRepo.findAll();
	}

	@Override
	public Order findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order newOrder(Order order) {
		order.setAccepted("PENDING");
		order.setDatePlaced(LocalDate.now().toString());
		order.setCustomer(userRepo.save(order.getCustomer()));
		order.setItem(itemRepo.save(order.getItem()));
		order.setShipAddress(addressRepo.save(order.getShipAddress()));
		return orderRepo.saveAndFlush(order);
	}

	@Override
	public Order trackOrder(int id, String email) {
		return orderRepo.findByIdAndCustomer_Email(id, email);
	}
	
}

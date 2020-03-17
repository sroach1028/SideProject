package com.sideproject.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sideproject.entities.Order;
import com.sideproject.services.AddressSvc;
import com.sideproject.services.ItemSvc;
import com.sideproject.services.OrderSvc;
import com.sideproject.services.UserSvc;

@RestController
@CrossOrigin({"*", "http://localhost:4210"})
public class OrderController {
	
	@Autowired
	private OrderSvc orderSvc;
	@Autowired
	private UserSvc userSvc;
	@Autowired
	private AddressSvc addressSvc;
	@Autowired
	private ItemSvc itemSvc;
	
	@GetMapping("api/orders")
	public List<Order> findAllOrders(HttpServletResponse resp, Principal principal) {
		List<Order> allOrders = orderSvc.findAll();
		if (allOrders == null) {
			resp.setStatus(404);
		} else
			resp.setStatus(200);
		return allOrders;	
		}
	
	@PostMapping("order")
	public Order postNewImage(@RequestBody Order order, HttpServletResponse res) {
		Order copy = null;
		try {
			copy = orderSvc.newOrder(order);
			res.setStatus(201);
		} catch (Exception e) {
			res.setStatus(400);
			e.printStackTrace();
		}
		
		return copy;
	}
	
	@GetMapping("order/{id}/{email}")
	public Order trackOrder(@PathVariable int id, @PathVariable String email, HttpServletResponse res) {
		Order order = orderSvc.trackOrder(id, email);
		if (order == null){
			res.setStatus(404);
		}
		else {
			res.setStatus(200);
		}
		return order;
	}
	
}

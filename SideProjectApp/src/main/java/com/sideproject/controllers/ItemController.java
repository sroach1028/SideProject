package com.sideproject.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sideproject.entities.Item;
import com.sideproject.services.ItemSvc;

@RestController
@CrossOrigin({"*", "http://localhost:4210"})
public class ItemController {

	@Autowired
	private ItemSvc itemSvc;
	
	@GetMapping("items")
	public List<Item> findAllItems(HttpServletResponse resp){
		return itemSvc.findAll();
	}
}

package com.sideproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sideproject.entities.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}

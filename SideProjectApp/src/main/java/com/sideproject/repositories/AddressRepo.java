package com.sideproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sideproject.entities.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}

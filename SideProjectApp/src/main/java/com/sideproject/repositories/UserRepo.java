package com.sideproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sideproject.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUsername(String name);

}

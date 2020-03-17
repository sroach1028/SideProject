package com.sideproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sideproject.entities.Image;

public interface ImageRepo extends JpaRepository<Image, Integer> {

}

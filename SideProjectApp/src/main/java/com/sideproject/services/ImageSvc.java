package com.sideproject.services;

import java.util.List;

import com.sideproject.entities.Image;

public interface ImageSvc {

	List<Image> findAll();
	Image postNewImage(Image image);
	
	void removeImage(int imageId);
}

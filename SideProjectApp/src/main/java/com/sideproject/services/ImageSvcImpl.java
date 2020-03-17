package com.sideproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sideproject.entities.Image;
import com.sideproject.repositories.ImageRepo;

@Transactional
@Service
public class ImageSvcImpl implements ImageSvc {

	@Autowired
	private ImageRepo imageRepo;
	
	@Override
	public List<Image> findAll() {
		return imageRepo.findAll();
	}

	@Override
	public Image postNewImage(Image image) {
		return imageRepo.saveAndFlush(image);
	}

	@Override
	public void removeImage(int imageId) {
		imageRepo.deleteById(imageId);
		// TODO Auto-generated method stub
	}

}

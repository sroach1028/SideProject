package com.sideproject.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sideproject.entities.Image;
import com.sideproject.services.ImageSvc;

@RestController
@CrossOrigin({ "*", "http://localhost:4210" })
public class ImageController {

	@Autowired
	private ImageSvc imageSvc;
	
	@GetMapping("images")
	public List<Image> findAllImages(HttpServletResponse resp){
		return imageSvc.findAll();
	}
	
	@PostMapping("images")
	public Image postNewImage(@RequestBody Image image, HttpServletResponse res) {
		return imageSvc.postNewImage(image);
	}
	
	@DeleteMapping("images/{imageId}")
	public void removeImage(@PathVariable Integer imageId, HttpServletResponse res) {
		imageSvc.removeImage(imageId);
	}
}

package com.sideproject.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String author;
	private int year;
	private String ages;
	private String condition;
	
	@Column(name="image_url")
	private String imageUrl;
	
	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	@OneToMany(mappedBy="book")
	private List<Rental> rentals;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAges() {
		return ages;
	}

	public void setAges(String ages) {
		this.ages = ages;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", ages=" + ages
				+ ", condition=" + condition + ", imageUrl=" + imageUrl + "]";
	}

	public Inventory(String title, String author, int year, String ages, String condition, String imageUrl) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.ages = ages;
		this.condition = condition;
		this.imageUrl = imageUrl;
	}

	public Inventory() {
		super();
	}
	
	
}

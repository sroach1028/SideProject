package com.sideproject.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String type;
	
	@Column(name="image_one")
	private String imageOne;
	
	@Column(name="image_two")
	private String imageTwo;
	
	@Column(name="image_three")
	private String imageThree;
	
	@OneToMany(mappedBy="item")
	private List<Order> itemOrders;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageOne() {
		return imageOne;
	}

	public void setImageOne(String imageOne) {
		this.imageOne = imageOne;
	}

	public String getImageTwo() {
		return imageTwo;
	}

	public void setImageTwo(String imageTwo) {
		this.imageTwo = imageTwo;
	}

	public String getImageThree() {
		return imageThree;
	}

	public void setImageThree(String imageThree) {
		this.imageThree = imageThree;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", imageOne=");
		builder.append(imageOne);
		builder.append(", imageTwo=");
		builder.append(imageTwo);
		builder.append(", imageThree=");
		builder.append(imageThree);
		builder.append("]");
		return builder.toString();
	}

	public Item(String type, String imageOne, String imageTwo, String imageThree) {
		super();
		this.type = type;
		this.imageOne = imageOne;
		this.imageTwo = imageTwo;
		this.imageThree = imageThree;
	}

	public Item() {
		super();
	}
	
	
	
	
}

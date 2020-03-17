package com.sideproject.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="orders_placed")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="date_placed")
	private String datePlaced;
	
	@Column(name="date_requested")
	private String dateRequested;

	@Column(name="date_fulfilled")
	private String dateFulfilled;
	
	@JsonIgnoreProperties({"ordersPlaced"})
	@ManyToOne
	@JoinColumn(name="customer_id")
	private User customer;
	
	@Column(name="ingredients_specified")
	private String ingredients;
	
	@ManyToOne
	@JoinColumn(name="ship_address_id")
	private Address shipAddress;
	
	private double price;
	
	private String accepted;
	
	@ManyToOne
	@JoinColumn(name="item_id")
	private Item item;
	
	@Column(name="item_quantity")
	private int itemQuantity;
	
	@Column(name="design_specified")
	private String designSpecified;
	
	private String occasion;
	
	@Column(name="allergies_specified")
	private String allergiesSpecified;
	
	@Column(name="special_requests")
	private String specialRequests;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatePlaced() {
		return datePlaced;
	}

	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}

	public String getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(String dateRequested) {
		this.dateRequested = dateRequested;
	}

	public String getDateFulfilled() {
		return dateFulfilled;
	}

	public void setDateFulfilled(String dateFulfilled) {
		this.dateFulfilled = dateFulfilled;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public Address getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(Address shipAddress) {
		this.shipAddress = shipAddress;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAccepted() {
		return accepted;
	}

	public void setAccepted(String accepted) {
		this.accepted = accepted;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getDesignSpecified() {
		return designSpecified;
	}

	public void setDesignSpecified(String designSpecified) {
		this.designSpecified = designSpecified;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public String getAllergiesSpecified() {
		return allergiesSpecified;
	}

	public void setAllergiesSpecified(String allergiesSpecified) {
		this.allergiesSpecified = allergiesSpecified;
	}

	public String getSpecialRequests() {
		return specialRequests;
	}

	public void setSpecialRequests(String specialRequests) {
		this.specialRequests = specialRequests;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", datePlaced=");
		builder.append(datePlaced);
		builder.append(", dateRequested=");
		builder.append(dateRequested);
		builder.append(", dateFulfilled=");
		builder.append(dateFulfilled);
		builder.append(", customer=");
		builder.append(customer);
		builder.append(", ingredients=");
		builder.append(ingredients);
		builder.append(", shipAddress=");
		builder.append(shipAddress);
		builder.append(", price=");
		builder.append(price);
		builder.append(", accepted=");
		builder.append(accepted);
		builder.append(", item=");
		builder.append(item);
		builder.append(", itemQuantity=");
		builder.append(itemQuantity);
		builder.append(", designSpecified=");
		builder.append(designSpecified);
		builder.append(", occasion=");
		builder.append(occasion);
		builder.append(", allergiesSpecified=");
		builder.append(allergiesSpecified);
		builder.append(", specialRequests=");
		builder.append(specialRequests);
		builder.append("]");
		return builder.toString();
	}

	public Order(String datePlaced, User customer, Address shipAddress, Item item, int itemQuantity) {
		super();
		this.datePlaced = datePlaced;
		this.customer = customer;
		this.shipAddress = shipAddress;
		this.item = item;
		this.itemQuantity = itemQuantity;
	}

	public Order() {
		super();
	}
	
	
	
}

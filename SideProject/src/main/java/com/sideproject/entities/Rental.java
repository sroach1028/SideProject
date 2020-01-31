package com.sideproject.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Inventory book;
	
	@ManyToOne
	@JoinColumn(name="lender_id")
	private User lender;
	
	@ManyToOne
	@JoinColumn(name="reader_id")
	private User reader;
	
	@Column(name="checkout_date")
	private Date checkoutDate;
	@Column(name="return_date")
	private Date returnDate;
	@Column(name="late_fees")
	private double lateFees;
	@ManyToOne
	@JoinColumn(name="ship_address_id")
	private Address shipAddress;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", book=");
		builder.append(book);
		builder.append(", lender=");
		builder.append(lender);
		builder.append(", reader=");
		builder.append(reader);
		builder.append(", checkoutDate=");
		builder.append(checkoutDate);
		builder.append(", returnDate=");
		builder.append(returnDate);
		builder.append(", lateFees=");
		builder.append(lateFees);
		builder.append(", shipAddress=");
		builder.append(shipAddress);
		builder.append("]");
		return builder.toString();
	}

	public Rental(Inventory book, User lender, User reader, Date checkoutDate, Date returnDate, double lateFees,
			Address shipAddress) {
		super();
		this.book = book;
		this.lender = lender;
		this.reader = reader;
		this.checkoutDate = checkoutDate;
		this.returnDate = returnDate;
		this.lateFees = lateFees;
		this.shipAddress = shipAddress;
	}

	public Rental() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Inventory getBook() {
		return book;
	}

	public void setBook(Inventory book) {
		this.book = book;
	}

	public User getLender() {
		return lender;
	}

	public void setLender(User lender) {
		this.lender = lender;
	}

	public User getReader() {
		return reader;
	}

	public void setReader(User reader) {
		this.reader = reader;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public double getLateFees() {
		return lateFees;
	}

	public void setLateFees(double lateFees) {
		this.lateFees = lateFees;
	}

	public Address getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(Address shipAddress) {
		this.shipAddress = shipAddress;
	}

}

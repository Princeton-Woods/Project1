package com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pendingreimbursements")
public class PendingTickets {
	
	public PendingTickets() {
		
	}
	
	public PendingTickets(double amount, String description, Date timeStamp) {
		super();
		this.amount = amount;
		this.description = description;
		this.timeStamp = timeStamp;
	}
	
	@ManyToOne
	@JoinColumn(name="typeId")
	private PendingTickets typeTicket;
	
	@ManyToOne
	@JoinColumn(name="empId")
	private PendingTickets empTicket;

	@Id
	@Column(name = "pendId")
	private int id;
	
	@Column(name = "pendAmt")
	private double amount;
	
	@Column(name = "pendDescription")
	private String description;
	
	@Column(name = "pendDate")
	private Date timeStamp;

	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
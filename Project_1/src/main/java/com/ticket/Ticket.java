package com.ticket;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {
	@Id
	private int id;
	private String type;
	private double amount;
	private String description;
	private Date timeStamp;
	
	public Ticket() {
		
	}
	public Ticket(String type, double amount, String description, Date timeStamp) {
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.timeStamp = timeStamp;
	}

	//Getters and Setters
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
	
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", type=" + type + ", amount=" + amount + ", description=" + description
				+ ", timeStamp=" + timeStamp + "]";
	}

}
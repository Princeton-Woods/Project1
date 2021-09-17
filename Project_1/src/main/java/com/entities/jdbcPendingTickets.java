package com.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class jdbcPendingTickets {
	
	public jdbcPendingTickets() {
		
	}
	

	
	public jdbcPendingTickets(double amount, String description, Date timeStamp, String type) {
		super();
		this.amount = amount;
		this.description = description;
		this.timeStamp = timeStamp;
		this.type = type;
	}



	public jdbcPendingTickets(int id, double amount, String description, Date timeStamp, String type, int empId) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.timeStamp = timeStamp;
		this.type = type;
		this.empId = empId;
	}



	private int id;
	private double amount;
	private String description;
	private Date timeStamp;
	private String type;
	private int empId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	
}
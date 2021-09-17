package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees {
	
	@Id
	@Column(name="empId")
	private int id;
	
	@Column(name="empFname")
	private String fname;
	
	@Column(name="empLname")
	private String lname;
	
	private String phoneNum;
	private String addressStreet;
	private String addressCity;
	private String addressState;
	
	@Column(name="empUsername")
	private String username;
	
	@Column(name="empPassword")
	private String password;
	
	public Employees() {
		
	}
	
	public Employees(int id, String fname, String lname, String phoneNum, String addressStreet, String addressCity,
			String addressState, String username, String password) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.phoneNum = phoneNum;
		this.addressStreet = addressStreet;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressState() {
		return addressState;
	}
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}



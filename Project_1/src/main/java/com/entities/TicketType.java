package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursementtype")
public class TicketType {
	
	TicketType() {
		
	}
	
	@Id
	@Column(name = "typeId")
	private int id;
	
	@Column(name = "typeName")
	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}

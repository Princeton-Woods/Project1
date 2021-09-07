package com.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

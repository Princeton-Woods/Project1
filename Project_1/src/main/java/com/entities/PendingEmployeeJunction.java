package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pending_reimbursement_junction")
public class PendingEmployeeJunction implements Serializable{
	
	public PendingEmployeeJunction() {
		
	}
	
	@OneToOne
	private PendingTickets pendingTickets;
	
	
	@Id
	private int empId;
	
	@Id
	private int pendId;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getPendId() {
		return pendId;
	}

	public void setPendId(int pendId) {
		this.pendId = pendId;
	}

}

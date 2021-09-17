package com.entities;

import java.io.Serializable;

import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pending_type_junction")
public class PendingTypeJunction implements Serializable{
	
	public PendingTypeJunction() {
		
	}

//	@ManyToOne
//    @MapsId("publisherId")
//    private Publisher publisher;
	
	@Id
	private int pendId;
	
	@Id
	private int typeId;

	public int getPendId() {
		return pendId;
	}

	public void setPendId(int pendId) {
		this.pendId = pendId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

}

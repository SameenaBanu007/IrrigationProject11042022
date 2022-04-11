package com.springboot.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Slots {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer slotID;
	
	private String irrigatehour;

	private Integer irrigateID;
	
	public Slots() {
		super();
	}

	public Slots(Integer slotID, String irrigatehour, Integer irrigateID) {
		super();
		this.slotID = slotID;
		this.irrigatehour = irrigatehour;
		this.irrigateID = irrigateID;
	}

	public Integer getSlotID() {
		return slotID;
	}

	public void setSlotID(Integer slotID) {
		this.slotID = slotID;
	}

	public String getIrrigatehour() {
		return irrigatehour;
	}

	public void setIrrigatehour(String irrigatehour) {
		this.irrigatehour = irrigatehour;
	}

	public Integer getIrrigateID() {
		return irrigateID;
	}

	public void setIrrigateID(Integer irrigateID) {
		this.irrigateID = irrigateID;
	}

	
}
package com.springboot.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Irrigate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private Integer time;

	private Integer water;

	private String status;


	public Irrigate() {
		super();
	}

	public Irrigate(Integer id, String name, Integer time, Integer water, String status) {
		this.id = id;
		this.name = name;
		this.time = time;
		this.water = water;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getTime() {
		return time;
	}


	public void setTime(Integer time) {
		this.time = time;
	}


	public Integer getWater() {
		return water;
	}


	public void setWater(Integer water) {
		this.water = water;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}



}
package com.springboot.rest.dto;

import java.util.List;

import com.springboot.rest.model.Irrigate;

public class Response {


	private String statusMessage;

	private String statusCode;
	
	private List<Irrigate> plot;
	
	
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public List<Irrigate> getPlot() {
		return plot;
	}

	public void setPlot(List<Irrigate> plot) {
		this.plot = plot;
	}

	

}
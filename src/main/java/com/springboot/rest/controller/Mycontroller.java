package com.springboot.rest.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.rest.dto.Response;
import com.springboot.rest.model.Irrigate;
import com.springboot.rest.service.Myservice;

@RestController
public class Mycontroller {

	@Autowired
	Myservice service;

	@GetMapping("/getAll")
	public Response getAll() {
		Response response = new Response();
		try {			
			response.setStatusCode("200");
			response.setStatusMessage("success");
			List<Irrigate> list  = service.findAllPlots();
			response.setPlot(list);					
		} catch (Exception e) {
			response.setStatusMessage(e.getMessage());
		}		
		return response;
	}
	
	@PostMapping("/add")
	public Response add(@RequestBody Irrigate dto) {
		Response response = new Response();
		try {
			response.setStatusCode("200");
			response.setStatusMessage("success");
			List<Irrigate> list  = new ArrayList<>();
			list.add(service.add(dto));
			response.setPlot(list);	
		} catch (Exception e) {
			response.setStatusMessage(e.getMessage());
		}		
		return response;
	}

	
	@PostMapping("/update")
	public Response update(@RequestBody Irrigate dto) {
		Response response = new Response();
		try {
			response.setStatusCode("200");
			response.setStatusMessage("success");
			List<Irrigate> list  = new ArrayList<>();
			list.add(service.update(dto));
			response.setPlot(list);	
		} catch (Exception e) {
			response.setStatusMessage(e.getMessage());
		}		
		return response;
	}
	
	@GetMapping("/irrigate")
	public Response irrigate() {
		Response response = new Response();
		try {
			response.setStatusCode("200");
			response.setStatusMessage(service.process());
			service.process();
		} catch (Exception e) {
			response.setStatusMessage(e.getMessage());
		}		
		return response;
	}
		
}
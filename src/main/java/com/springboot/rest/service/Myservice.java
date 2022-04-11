package com.springboot.rest.service;

import java.util.List;
import com.springboot.rest.model.Irrigate;

public interface Myservice {
	
	List<Irrigate> findAllPlots();
	
	Irrigate add(Irrigate dto);

	Irrigate update(Irrigate dto);

	String process();
	
}
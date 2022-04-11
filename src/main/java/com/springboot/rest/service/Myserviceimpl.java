package com.springboot.rest.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.rest.dao.IrrigateRepository;
import com.springboot.rest.dao.SlotsRepository;
import com.springboot.rest.model.Irrigate;
import com.springboot.rest.model.Slots;

@Service
public class Myserviceimpl implements Myservice {

	@Autowired
	IrrigateRepository rep;	

	@Autowired
	SlotsRepository slotRep;

	@Override
	public List<Irrigate> findAllPlots() {	

		List<Irrigate> list = new ArrayList<Irrigate>();  
		rep.findAll().forEach(obj -> list.add(obj));  
		return list;	
	}

	@Override
	public Irrigate add(Irrigate dto) {		
		return rep.save(dto);
	}

	@Override
	public Irrigate update(Irrigate dto) {
		 rep.updateIrrigationPlotConf(dto.getTime(),dto.getName());
		 return dto;
		//return rep.save(dto);
	}

	@Override
	public String process() {		
		String msg = "success";

		Map<String,Integer> map = new HashMap<>();		
		map.put("type1", 10);
		map.put("type2", 20);
		map.put("type2", 30);
		String hour = null;

		try {
			List<Irrigate> list = new ArrayList<Irrigate>();  
			rep.findAll().forEach(obj -> list.add(obj)); // to get all the plot of lands to process for irrigation

			while(true) {	
				
                hour = getCurrentHour();
                
				for (Irrigate irrigate : list) {
                
					try {
						int retryCount = 3;
						int period = irrigate.getTime();
						boolean flag = false;
						
						while(retryCount > 0) {							
							
							innerloop:
								for(Entry<String, Integer> duration : map.entrySet()) { // finding sensordevice
									if(map.get(duration.getKey()) >= period) {
										flag = true;
										break innerloop;
									}
								}

							if(flag) {	// if sensordevice is found then irrigate				
								List<Slots> slotList = slotRep.getSlotsForIrrigation(hour,irrigate.getId());	// if the slot timing is current hour				 
								System.out.println(slotList.size());
								for (Slots slot : slotList) {  
									irrigate.setStatus("Irrigated");
									rep.save(irrigate);						
								}
							}
							retryCount--;
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}

				System.out.println("Thread is going to sleep for an hour !!!");
				Thread.sleep(3600000);// 1 hour sleep, assuming irrigation gap is 1 hour 
			}
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

	static String getCurrentHour() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		return String.valueOf(hours);
	}
}
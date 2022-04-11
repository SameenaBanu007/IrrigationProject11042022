package com.springboot.rest.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springboot.rest.model.Slots;


@Repository
public interface SlotsRepository extends CrudRepository<Slots, Integer> {	
	
	@Query("SELECT s FROM Slots s where s.irrigatehour = :irrigatehour and s.irrigateID = :irrigateID")
	public List<Slots> getSlotsForIrrigation(@Param("irrigatehour") String irrigatehour,@Param("irrigateID") Integer irrigateID);
	

}

package com.springboot.rest.dao;


import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springboot.rest.model.Irrigate;

@Repository
public interface IrrigateRepository extends CrudRepository<Irrigate, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE Irrigate s SET s.time = :time where s.name = :name")
	public void updateIrrigationPlotConf(@Param("time") Integer time,@Param("name") String name);
}

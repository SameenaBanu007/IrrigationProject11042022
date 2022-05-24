package com.saudi.springboot.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.saudi.springboot.rest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
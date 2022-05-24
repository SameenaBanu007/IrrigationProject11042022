package com.saudi.springboot.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.saudi.springboot.rest.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
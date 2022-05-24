package com.saudi.springboot.rest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saudi.springboot.rest.dao.CommentRepository;
import com.saudi.springboot.rest.dao.PostRepository;
import com.saudi.springboot.rest.dao.UserRepository;
import com.saudi.springboot.rest.model.Comment;
import com.saudi.springboot.rest.model.Post;
import com.saudi.springboot.rest.model.User;

@Service
public class ServiceImpl implements Services {

	@Autowired
	UserRepository userRep;
	
	@Autowired
	PostRepository postRep;
	
	@Autowired
	CommentRepository commentRep;

	@Override
	public List<User> getAllUsers() {
		return userRep.findAll();
	}

	@Override
	public List<Post> getAllPosts() {
		return postRep.findAll();		
	}

	@Override
	public List<Comment> getAllComments() {		
		return commentRep.findAll();
	}

	
	public String saveUser(User dto) {
		
		userRep.save(dto);
		
		return "success";
	}
}
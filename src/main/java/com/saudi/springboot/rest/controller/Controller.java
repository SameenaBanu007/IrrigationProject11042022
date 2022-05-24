package com.saudi.springboot.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saudi.springboot.rest.model.Comment;
import com.saudi.springboot.rest.model.Post;
import com.saudi.springboot.rest.model.User;
import com.saudi.springboot.rest.service.Services;

@RestController
@RequestMapping("/test")
public class Controller {

	@Autowired
	Services service;

	@GetMapping(value= "/users")
	public List<User> getUsers() {
		return service.getAllUsers();
	}

	@GetMapping(value= "/posts")
	public List<Post> getPosts() {
		return service.getAllPosts();
	}

	@GetMapping(value= "/comments")
	public List<Comment> getComments() {
		return service.getAllComments();
	}

	
	/*@PostMapping(value= "/addUser")
	public String addUser(@RequestBody User user) {
		String status = "";
		try {
			status = service.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}		
		return status;
	}*/
	
		
}
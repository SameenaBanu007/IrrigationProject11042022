package com.saudi.springboot.rest.service;

import java.util.List;
import com.saudi.springboot.rest.model.Comment;
import com.saudi.springboot.rest.model.Post;
import com.saudi.springboot.rest.model.User;

public interface Services {

	public List<User> getAllUsers();

	public List<Post> getAllPosts();

	public List<Comment> getAllComments();
	
	public String saveUser(User dto);

}
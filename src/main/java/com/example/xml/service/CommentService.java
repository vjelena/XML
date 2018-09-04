package com.example.xml.service;

import java.util.List;

import com.example.xml.model.Comment;

public interface CommentService {

	Comment findOne(Long id);
	
	List<Comment> findAll();
	
	Comment save(Comment user);
	
	List<Comment> save(List<Comment> users);
	
	Comment delete(Long id);
	
	void delete(List<Long> ids);
}

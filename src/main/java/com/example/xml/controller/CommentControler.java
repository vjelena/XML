package com.example.xml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.xml.model.Comment;
import com.example.xml.service.CommentService;

@RestController
@RequestMapping(value = "/comment")
public class CommentControler {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/getComm", method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> getComm() {
		List<Comment> agenti = commentService.findAll();
		return new ResponseEntity<>(agenti, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/approve", method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Comment> approve(@RequestBody Comment user) {		
		Comment e = commentService.findOne(user.getId());
		e.setStatus(1);
		commentService.save(e);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
}

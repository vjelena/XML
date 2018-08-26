package com.example.xml.service;

import java.util.List;

import com.example.xml.model.EndUser;


public interface UserService {

	EndUser findOne(Long id);
	
	List<EndUser> findAll();
	
	EndUser save(EndUser user);
	
	List<EndUser> save(List<EndUser> users);
	
	EndUser delete(Long id);
	
	void delete(List<Long> ids);
}

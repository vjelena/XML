package com.example.xml.service;

import java.util.List;

import com.example.xml.model.Admin;

public interface AdminService {

	Admin findOne(Long id);
	
	Admin findByUsername(String email);
	
	List<Admin> findAll();
	
	Admin save(Admin user);
	
	List<Admin> save(List<Admin> users);
	
	Admin delete(Long id);
	
	void delete(List<Long> ids);
}

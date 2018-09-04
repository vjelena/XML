package com.example.xml.service;

import java.util.List;

import com.example.xml.model.Extras;

public interface ExtrasService {

	Extras findOne(Long id);
	
	List<Extras> findAll();
	
	Extras save(Extras user);
	
	List<Extras> save(List<Extras> users);
	
	Extras delete(Long id);
	
	void delete(List<Long> ids);
}

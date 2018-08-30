package com.example.xml.service;

import java.util.List;

import com.example.xml.model.Accommodation;

public interface AccommodationService {

	Accommodation findOne(Long id);
	
	List<Accommodation> findAll();
	
	Accommodation save(Accommodation accommodation);
	
	List<Accommodation> save(List<Accommodation> accommodations);
	
	Accommodation delete(Long id);
	
	void delete(List<Long> ids);
}

package com.example.xml.service;

import java.util.List;

import com.example.xml.model.Reservation;

public interface ReservationService {

	List<Reservation> findAll();
	
	Reservation save(Reservation reservation);
	
	Reservation delete(Long id);
}

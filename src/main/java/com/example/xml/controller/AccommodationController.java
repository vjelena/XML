package com.example.xml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.xml.model.Accommodation;
import com.example.xml.service.AccommodationService;
/**
 * Kontroler vezan za smeštaj
 */
@RestController
@RequestMapping(value="accommodations")
public class AccommodationController {

	@Autowired
	private AccommodationService accommodationService;
	
	@GetMapping(value="getAccommodations")
	public ResponseEntity<List<Accommodation>> getAccommodations() {
		List<Accommodation> accs = accommodationService.findAll();
		return new ResponseEntity<List<Accommodation>>(accs, HttpStatus.OK);
	}
}

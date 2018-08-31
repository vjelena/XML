package com.example.xml.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.xml.model.Accommodation;
import com.example.xml.repository.AccommodationRepository;
import com.example.xml.service.AccommodationService;
/**
 * Kontroler vezan za smeštaj
 */
@RestController
@RequestMapping(value="accommodations")
public class AccommodationController {

	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Autowired
	private AccommodationService accommodationService;
	
	@GetMapping(value="getAccommodations")
	public ResponseEntity<List<Accommodation>> getAccommodations() {
		List<Accommodation> accs = accommodationService.findAll();
		return new ResponseEntity<List<Accommodation>>(accs, HttpStatus.OK);
	}
	
	//pretraga
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public ResponseEntity<List<Accommodation>> search(@RequestParam("place") String place, @RequestParam("numPersons") int numPersons) {
		List<Accommodation> accommodations = accommodationRepository.findByPlaceIgnoreCaseContaining(place);
		List<Accommodation> result = new ArrayList<Accommodation>();
		for(Accommodation acc : accommodations) {
			if(acc.getNumPersons() >= numPersons) {
				result.add(acc);
			}
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}

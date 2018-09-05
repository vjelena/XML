package com.example.xml.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.xml.model.EndUser;
import com.example.xml.model.Reservation;
import com.example.xml.model.ReservationDTO;
import com.example.xml.service.AccommodationService;
import com.example.xml.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private AccommodationService accommodationService;
	
	@RequestMapping(value="/getReservations", method=RequestMethod.GET)
	public ResponseEntity<List<Reservation>> getReservations(HttpServletRequest request) {
		EndUser user = new EndUser();
		user = (EndUser) request.getSession().getAttribute("aktivanKorisnik");

		List<Reservation> res = reservationService.findAll();
		List<Reservation> result = new ArrayList<Reservation>();
		for(Reservation reservation : res) {
			System.out.println(reservation.getEndUser().getEmail());
			if(reservation.getEndUser().getEmail().equals(user.getEmail())) {
				System.out.println("jednakooo");
				result.add(reservation);
			}
		}
		return new ResponseEntity<List<Reservation>>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addReservation", method=RequestMethod.POST)
	public ResponseEntity<Reservation> addReservation(@RequestBody ReservationDTO reservationDto, HttpServletRequest request) {
		Reservation res = new Reservation();
		res.setStatus(1);
		res.setEndUser((EndUser) request.getSession().getAttribute("aktivanKorisnik"));
		res.setDateFrom(reservationDto.getDateFrom());
		res.setDateTo(reservationDto.getDateTo());
		res.setAccommodation(accommodationService.findOne(reservationDto.getAccommodation()));
		Reservation newRes = reservationService.save(res);
		return new ResponseEntity<Reservation>(newRes, HttpStatus.OK);
	}
	
	
}

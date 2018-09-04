package com.example.xml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.xml.model.EndUser;
import com.example.xml.model.Registration;
import com.example.xml.service.UserService;
/**
 * Kontroler vezan za krajnjeg korisnika
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/registration") //prvo prikazujemo html stranicu
    public ModelAndView showRegistrationForm() {
        return new ModelAndView("registration", "registration", new Registration());
    }
	
	@RequestMapping(value="/getKorisnici", method = RequestMethod.GET)
	public ResponseEntity<List<EndUser>> getOglasi() {
		List<EndUser> korisnici = userService.findAll();
		return new ResponseEntity<>(korisnici, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ukloni", method = RequestMethod.PUT)
	public ResponseEntity<EndUser> delete(@RequestBody EndUser user) {
		EndUser deleted = userService.delete(user.getId());
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/aktiviraj", method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<EndUser> aktiviraj(@RequestBody EndUser user) {		
		EndUser e = userService.findOne(user.getId());
		e.setStatus(1);
		userService.save(e);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/blokiraj", method = RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<EndUser> blokiraj(@RequestBody EndUser user) {		
		EndUser e = userService.findOne(user.getId());
		e.setStatus(0);
		userService.save(e);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}
}

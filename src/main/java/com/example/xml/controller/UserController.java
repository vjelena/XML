package com.example.xml.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.example.xml.model.Admin;
import com.example.xml.model.EndUser;
import com.example.xml.model.Registration;
import com.example.xml.repository.UserRepository;
import com.example.xml.service.UserService;
/**
 * Kontroler vezan za krajnjeg korisnika
 */
@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/prijava", method = RequestMethod.POST)
	public ResponseEntity<EndUser> prijava(@RequestBody EndUser requestKorisnik, HttpServletRequest request){
		EndUser user = userRepository.findByEmail(requestKorisnik.getEmail());
		
		if(user != null) {
			if(user.getPassword().equals(requestKorisnik.getPassword())) {
				
				request.getSession().setAttribute("aktivanKorisnik", user);

				return new ResponseEntity<EndUser>(user, HttpStatus.OK);
			}
		} else {
			System.out.println("\n\t\tNe postoji korisnik sa unetim emailom i lozinkom u bazi!\n");
		}
			
		return new ResponseEntity<EndUser>(user, HttpStatus.NOT_FOUND);
	}

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

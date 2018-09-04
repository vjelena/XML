package com.example.xml.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.xml.model.Admin;
import com.example.xml.service.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/prijava", method = RequestMethod.POST)
	public ResponseEntity<Admin> prijava(@RequestBody Admin requestKorisnik, HttpServletRequest request){
		Admin a = adminService.findByUsername(requestKorisnik.getUsername());
		
		if(a != null) {
			if(a.getPassword().equals(requestKorisnik.getPassword())) {
				
				request.getSession().setAttribute("aktivanKorisnik", a);

				return new ResponseEntity<Admin>(a, HttpStatus.OK);
			}
		} else {
			System.out.println("\n\t\tNe postoji korisnik sa unetim emailom i lozinkom u bazi!\n");
		}
			
		return new ResponseEntity<Admin>(a, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/odjava", method = RequestMethod.GET)
	public String odjava(HttpServletRequest request) {
		request.getSession().invalidate();
		return "odjavljen";
	}

}

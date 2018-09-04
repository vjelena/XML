package com.example.xml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.xml.model.Extras;
import com.example.xml.service.ExtrasService;

@RestController
@RequestMapping(value = "/extra")
public class ExtrasController {

	@Autowired
	private ExtrasService extraService;
	
	@RequestMapping(value="/getExtras", method = RequestMethod.GET)
	public ResponseEntity<List<Extras>> getAgenti() {
		List<Extras> agenti = extraService.findAll();
		return new ResponseEntity<>(agenti, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addExtra")
	public ResponseEntity<Extras> dodajAgenta(@RequestBody Extras agent) {
		Extras a = new Extras();
		a.setName(agent.getName());
		extraService.save(a);		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.PUT)
	public ResponseEntity<Extras> delete(@RequestBody Extras user) {
		Extras deleted = extraService.delete(user.getId());
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Extras> edit(@PathVariable Long id, @RequestBody String newextra) {
		Extras extra = extraService.findOne(id);
		extra.setName(newextra);
		extraService.save(extra);
		return new ResponseEntity<>(extra, HttpStatus.OK);
	}
}

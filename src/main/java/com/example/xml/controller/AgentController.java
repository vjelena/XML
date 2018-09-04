package com.example.xml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.xml.model.Agent;
import com.example.xml.service.AgentService;

@RestController
@RequestMapping(value = "/agent")
public class AgentController {

	@Autowired
	private AgentService agentService;
	
	@RequestMapping(value="/getAgenti", method = RequestMethod.GET)
	public ResponseEntity<List<Agent>> getAgenti() {
		List<Agent> agenti = agentService.findAll();
		return new ResponseEntity<>(agenti, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/dodajAgenta")
	public ResponseEntity<Agent> dodajAgenta(@RequestBody Agent agent) {
		Agent a = new Agent();
		a.setName(agent.getName());
		a.setLastName(agent.getLastName());
		a.setAddress(agent.getAddress());
		a.setNumber(agent.getNumber());
		a.setUsername(agent.getUsername());
		a.setPassword(agent.getPassword());
		agentService.save(a);		
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
}

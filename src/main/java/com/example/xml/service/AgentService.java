package com.example.xml.service;

import java.util.List;

import com.example.xml.model.Agent;

public interface AgentService {

	Agent findOne(Long id);
		
	List<Agent> findAll();
	
	Agent save(Agent user);
	
	List<Agent> save(List<Agent> users);
	
	Agent delete(Long id);
	
	void delete(List<Long> ids);
}

package com.example.xml.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xml.model.Agent;
import com.example.xml.repository.AgentRepository;

@Transactional
@Service
public class AgentServiceImpl implements AgentService{

	
	@Autowired
	private AgentRepository agentRepository;
	
	@Override
	public Agent findOne(Long id) {
		return agentRepository.findById(id).get();
	}

	@Override
	public List<Agent> findAll() {
		return agentRepository.findAll();
	}

	@Override
	public Agent save(Agent user) {
		return agentRepository.save(user);
	}

	@Override
	public List<Agent> save(List<Agent> users) {
		return agentRepository.saveAll(users);
	}

	@Override
	public Agent delete(Long id) {
		Agent user = agentRepository.findById(id).get();
		if(user == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant user");
		}
		agentRepository.delete(user);
		return user;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}
}

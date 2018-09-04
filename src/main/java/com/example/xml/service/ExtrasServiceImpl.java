package com.example.xml.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.xml.model.Extras;
import com.example.xml.repository.ExtrasRepository;

@Transactional
@Service
public class ExtrasServiceImpl implements ExtrasService{

	@Autowired
	private ExtrasRepository agentRepository;
	
	@Override
	public Extras findOne(Long id) {
		return agentRepository.findById(id).get();
	}

	@Override
	public List<Extras> findAll() {
		return agentRepository.findAll();
	}

	@Override
	public Extras save(Extras user) {
		return agentRepository.save(user);
	}

	@Override
	public List<Extras> save(List<Extras> users) {
		return agentRepository.saveAll(users);
	}

	@Override
	public Extras delete(Long id) {
		Extras user = agentRepository.findById(id).get();
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

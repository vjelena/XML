package com.example.xml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.xml.model.EndUser;
import com.example.xml.repository.UserRepository;


@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public EndUser findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public List<EndUser> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public EndUser save(EndUser city) {
		// TODO Auto-generated method stub
		return userRepository.save(city);
	}

	@Override
	public List<EndUser> save(List<EndUser> cities) {
		// TODO Auto-generated method stub
		return userRepository.saveAll(cities);
	}

	@Override
	public EndUser delete(Long id) {
		// TODO Auto-generated method stub
		EndUser city = userRepository.findById(id).get();
		if(city == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant city");
		}
		userRepository.delete(city);
		return city;
	}

	@Override
	public void delete(List<Long> ids) {
		// TODO Auto-generated method stub
		for(Long id : ids){
			this.delete(id);
		}
	}

}

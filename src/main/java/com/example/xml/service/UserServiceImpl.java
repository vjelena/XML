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
		return userRepository.findById(id).get();
	}

	@Override
	public List<EndUser> findAll() {
		return userRepository.findAll();
	}

	@Override
	public EndUser save(EndUser user) {
		return userRepository.save(user);
	}

	@Override
	public List<EndUser> save(List<EndUser> users) {
		return userRepository.saveAll(users);
	}

	@Override
	public EndUser delete(Long id) {
		EndUser user = userRepository.findById(id).get();
		if(user == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant user");
		}
		userRepository.delete(user);
		return user;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

}

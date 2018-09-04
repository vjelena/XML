package com.example.xml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.xml.model.Admin;
import com.example.xml.repository.AdminRepository;

@Transactional
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin findByUsername(String email) {
		return adminRepository.findByUsernameIgnoreCaseContaining(email);
	}
	
	@Override
	public Admin findOne(Long id) {
		return adminRepository.findById(id).get();
	}

	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public Admin save(Admin user) {
		return adminRepository.save(user);
	}

	@Override
	public List<Admin> save(List<Admin> users) {
		return adminRepository.saveAll(users);
	}

	@Override
	public Admin delete(Long id) {
		Admin user = adminRepository.findById(id).get();
		if(user == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant user");
		}
		adminRepository.delete(user);
		return user;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}
}

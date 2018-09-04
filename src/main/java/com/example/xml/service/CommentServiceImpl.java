package com.example.xml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.xml.model.Comment;
import com.example.xml.repository.CommentRepository;

@Transactional
@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository adminRepository;
	
	@Override
	public Comment findOne(Long id) {
		return adminRepository.findById(id).get();
	}

	@Override
	public List<Comment> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public Comment save(Comment user) {
		return adminRepository.save(user);
	}

	@Override
	public List<Comment> save(List<Comment> users) {
		return adminRepository.saveAll(users);
	}

	@Override
	public Comment delete(Long id) {
		Comment user = adminRepository.findById(id).get();
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

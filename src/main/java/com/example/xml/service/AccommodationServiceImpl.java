package com.example.xml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.xml.model.Accommodation;
import com.example.xml.repository.AccommodationRepository;

@Transactional
@Service
public class AccommodationServiceImpl implements AccommodationService {

	@Autowired
	private AccommodationRepository accommodationRepository;
	
	@Override
	public Accommodation findOne(Long id) {
		return accommodationRepository.getOne(id);
	}

	@Override
	public List<Accommodation> findAll() {
		return accommodationRepository.findAll();
	}

	@Override
	public Accommodation save(Accommodation accommodation) {
		return accommodationRepository.save(accommodation);
	}

	@Override
	public List<Accommodation> save(List<Accommodation> accommodations) {
		return accommodationRepository.saveAll(accommodations);
	}

	@Override
	public Accommodation delete(Long id) {
		Accommodation accommodation = accommodationRepository.findById(id).get();
		if(accommodation == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant accommodation");
		}
		accommodationRepository.delete(accommodation);
		return accommodation;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id:ids) {
			this.delete(id);
		}
	}

}

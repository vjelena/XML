package com.example.xml.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xml.model.Accommodation;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
	List<Accommodation> findByPlaceIgnoreCaseContaining(String place);
}

package com.example.xml.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xml.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}

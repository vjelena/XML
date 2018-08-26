package com.example.xml.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xml.model.EndUser;


public interface UserRepository extends JpaRepository<EndUser, Long>{

}

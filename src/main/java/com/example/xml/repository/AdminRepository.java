package com.example.xml.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.xml.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findByUsernameIgnoreCaseContaining(String email);

}

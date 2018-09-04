package com.example.xml.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Agent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5744608235561893832L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column
	private String name;
	
	@Column
	private String lastName;
	
	@Column
	private String address;
	
	@Column
	private String number;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@OneToMany
	private Set<Accommodation> accommodationList = new HashSet<Accommodation>();
	
	public Agent() {
		
	}
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Set<Accommodation> getAccommodationList() {
		return accommodationList;
	}

	public void setAccommodationList(Set<Accommodation> accommodationList) {
		this.accommodationList = accommodationList;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	
}

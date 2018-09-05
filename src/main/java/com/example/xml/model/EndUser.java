package com.example.xml.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EndUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2303283871457607238L;

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
	private String email;
	
	@Column
	private String password;
	
	@Column 
	private int status;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "endUser")
	@JsonIgnore
	private Set<Reservation> reservationList = new HashSet<Reservation>();
	
	public EndUser() {
		
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

	public Set<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(Set<Reservation> reservationList) {
		this.reservationList = reservationList;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

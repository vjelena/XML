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
	
	@OneToMany
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
	
	
}

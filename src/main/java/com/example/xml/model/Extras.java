package com.example.xml.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.xml.model.Accommodation;

@Entity
public class Extras implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column
	private String name;
	
	/*@ManyToOne(optional = false)
	private Accommodation accommodation;*/

	public Extras() {
		
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

	/*public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}*/
	
	
}

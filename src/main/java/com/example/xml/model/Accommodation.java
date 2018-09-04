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
public class Accommodation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4185174871157814877L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String place;
	
	@Column
	private String typeService;		//hb, bb, fb
	
	@Column
	private String type;			//hotel, apartman, bed&breakfast
	
	@Column
	private String description;
	
	@Column
	private String image;
	
	@Column
	private int numPersons;
	
	@Column
	private float rate;
	
	@Column
	private int category;
	
	@JsonIgnore
	@OneToMany
	private Set<PriceDateSchedule> priceDateSchedule = new HashSet<PriceDateSchedule>();
	
	@OneToMany(fetch = FetchType.LAZY/*, mappedBy="accommodation"*/)
	@JsonIgnore
	private Set<Extras> extras = new HashSet<Extras>();
	
	public Accommodation() {
		
	}

	public Accommodation(String name, String address, String place,
			String typeService, String type, String description, String image,
			int numPersons, float rate, int category,
			Set<PriceDateSchedule> priceDateSchedule, Set<Extras> extras) {
		super();
		this.name = name;
		this.address = address;
		this.place = place;
		this.typeService = typeService;
		this.type = type;
		this.description = description;
		this.image = image;
		this.numPersons = numPersons;
		this.rate = rate;
		this.category = category;
		this.priceDateSchedule = priceDateSchedule;
		this.extras = extras;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTypeService() {
		return typeService;
	}

	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNumPersons() {
		return numPersons;
	}

	public void setNumPersons(int numPersons) {
		this.numPersons = numPersons;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public Set<PriceDateSchedule> getPriceDateSchedule() {
		return priceDateSchedule;
	}

	public void setPriceDateSchedule(Set<PriceDateSchedule> priceDateSchedule) {
		this.priceDateSchedule = priceDateSchedule;
	}

	public Set<Extras> getExtras() {
		return extras;
	}

	public void setExtras(Set<Extras> extras) {
		this.extras = extras;
	}
	
	
	
}

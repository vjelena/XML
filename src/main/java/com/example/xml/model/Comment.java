package com.example.xml.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3744101756883046114L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column
	private String content;
	
	@Column
	private int status;
	
	@ManyToOne
	private EndUser user;
	
	@ManyToOne
	private Accommodation accommodation;
	
	public Comment() {}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public EndUser getUser() {
		return user;
	}

	public void setUser(EndUser user) {
		this.user = user;
	}

	public Accommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accommodation accommodation) {
		this.accommodation = accommodation;
	}
	

}

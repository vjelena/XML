package com.example.xml.model;

import java.sql.Date;

public class ReservationDTO {
	private Date dateFrom;
	private Date dateTo;
	private Long accommodationId;
	
	public ReservationDTO() {}
	
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public Long getAccommodation() {
		return accommodationId;
	}
	public void setAccommodation(Long accommodation) {
		this.accommodationId = accommodation;
	}
	
	
}

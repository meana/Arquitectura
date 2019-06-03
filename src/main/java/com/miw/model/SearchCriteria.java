package com.miw.model;

import java.sql.Date;

public class SearchCriteria {
	
	private int		originId;
	private int		destinationId;
	private Date	departureDate;
	private Date 	arriveDate;
	private int 	passengers;
	
	public int getOriginId() {
		return originId;
	}
	public void setOriginId(int originId) {
		this.originId = originId;
	}
	public int getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArriveDate() {
		return arriveDate;
	}
	public void setArriveDate(Date arriveDate) {
		this.arriveDate = arriveDate;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	
}

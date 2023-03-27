package com.flightwebapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public Flight() {
		super();
	}


	public Flight(Airlines airline, Place sourcePlace, Place destinationPlace, LocalDate departureTime, int price) {
		super();
		this.airline = airline;
		this.sourcePlace = sourcePlace;
		this.destinationPlace = destinationPlace;
		this.departureTime = departureTime;
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public Airlines getAirline() {
		return airline;
	}

	public void setAirline(Airlines airline) {
		this.airline = airline;
	}

	public Place getSourcePlace() {
		return sourcePlace;
	}

	public void setSourcePlace(Place sourcePlace) {
		this.sourcePlace = sourcePlace;
	}

	public Place getDestinationPlace() {
		return destinationPlace;
	}

	public void setDestinationPlace(Place destinationPlace) {
		this.destinationPlace = destinationPlace;
	}

	public LocalDate getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDate departureTime) {
		this.departureTime = departureTime;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "airline_id")
	private Airlines airline;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "source_place_id")
	private Place sourcePlace;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "destination_place_id")
	private Place destinationPlace;
	
	@Column(name = "departure_time")
	private LocalDate departureTime;
	
	@Column(name="price")
	private int price;
	
	
}

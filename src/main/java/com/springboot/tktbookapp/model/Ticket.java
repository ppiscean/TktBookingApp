package com.springboot.tktbookapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tbl_ticket")
public class Ticket {
	@Id
	@Column(name="ticket_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;
	
	@Column(name="passenger_name")
	private String passengerName;
	
	@Column(name="travel_date")
	private Date travelDate;
	
	@Column(name="source_station")
	private String sourceStation;
	
	@Column(name="destination_station")
	private String destinationStation;
	
	@Column(name="email")
	private String email;

	public Ticket(Integer ticketId, String passengerName, Date travelDate, String sourceStation,
			String destinationStation, String email) {
		super();
		this.ticketId = ticketId;
		this.passengerName = passengerName;
		this.travelDate = new Date();
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.email = email;
	}

	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public String getEmail() {
		return email;
	} 

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", travelDate=" + travelDate
				+ ", sourceStation=" + sourceStation + ", destinationStation=" + destinationStation + ", email=" + email
				+ "]";
	}
}

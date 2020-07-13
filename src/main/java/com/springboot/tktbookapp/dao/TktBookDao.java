package com.springboot.tktbookapp.dao;

import org.springframework.stereotype.Repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import com.springboot.tktbookapp.model.Ticket;


@Repository
public interface TktBookDao extends CrudRepository<Ticket, Integer>{

	public Ticket findByPassengerName(String passengerName);
	public Ticket findByEmail(String email);
	public Ticket findByDestinationStation(String destinationStation);
	public Ticket findBySourceStation(String sourceStation);
	public Ticket findByTravelDate(Date travelDate);
	
		
}

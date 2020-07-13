package com.springboot.tktbookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.tktbookapp.dao.TktBookDao;
import com.springboot.tktbookapp.model.Ticket;

@Service
public class TktService {

	@Autowired
	private TktBookDao tktBookDao;
	
	// Create 
	public Ticket createTicket(Ticket ticket) {
		return tktBookDao.save(ticket);
	}
	
	// Get 
	public Ticket getTicket(Integer id) {
		return tktBookDao.findById(id).orElse(new Ticket());
	}
	// Update
	public Ticket updateTicket(Integer id, String email) {
		Ticket ticket = getTicket(id);
		if (null != ticket && null!=ticket.getEmail())
			ticket.setEmail(email);
		return ticket;
	}
	
	//GETall 
	public Iterable<Ticket> getAllTickets(){
		return tktBookDao.findAll(); 
	}

	// Delete
	public void deleteTicket(Integer id) {
		tktBookDao.deleteById(id);
	}

	public Ticket getTicket(String passengerName) {
		return tktBookDao.findByPassengerName(passengerName);
	}

}

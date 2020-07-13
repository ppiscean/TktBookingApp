package com.springboot.tktbookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.springboot.tktbookapp.model.Ticket;
import com.springboot.tktbookapp.service.TktService;
import com.springboot.tktbookapp.exception.RequiredFiledsException;
import com.springboot.tktbookapp.exception.ExceptionHandlerControllerAdvice;
import com.springboot.tktbookapp.exception.TicketNotFoundException;
import com.springboot.tktbookapp.service.TktServiceException;
import com.springboot.tktbookapp.exception.ExceptionResponse;


@RestController
@RequestMapping(value="/api/tickets")
public class TktController {
	
	@Autowired
	private TktService tktService;
	
	@GetMapping (value="/all")  // http://localhost:8080/api/tickets/all
	public Iterable<Ticket> getAllTickets() throws TicketNotFoundException{
		Iterable<Ticket> ticketList = tktService.getAllTickets();
		
		if (ticketList == null || (!ticketList.iterator().hasNext())) {
			throw new TicketNotFoundException("No Tickets Available in the Database");
		}
		return tktService.getAllTickets();
	}

	@GetMapping (value="/{id}") // http://localhost:8080/api/tickets/1
	public ResponseEntity<Object> getTicket(@PathVariable("id") Integer id) throws TicketNotFoundException {
		Ticket ticket = tktService.getTicket(id);
		if (ticket == null || (ticket != null && ticket.getPassengerName() == null)) {
			//ExceptionResponse error = new ExceptionResponse();
			//error.setErrorMessage("No Tickets Are Avaiable with ticket Id ..>" + ticketId);
			//error.callerURL("/getTicket");

			// return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
			
			throw new TicketNotFoundException("No Tickets Available");
		}
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}
	
	
	@GetMapping (value="/passengerName/{passengerName}") // http://localhost:8080/api/tickets/passengerName/Ishae
	public Ticket getTicket(@PathVariable("passengerName") String passengerName) {
		return tktService.getTicket(passengerName);
	}
	

	@PostMapping (value="/create" ) // http://localhost:8080/api/tickets/create
	public Ticket createTicket(@RequestBody Ticket ticket) throws TktServiceException, RequiredFiledsException {
		try {
			ticket = tktService.createTicket(ticket);
		} catch (Throwable th) {
			if (th instanceof RequiredFiledsException) {
				System.out.println("Missing Required Fields : Passengername");
				throw new RequiredFiledsException(th.getMessage());
			} else {
				System.out.println("Normal ticket Exception");
				throw new TktServiceException(th.getMessage());
			}
		}
		return ticket;
	}

	
	@PutMapping ( value="/update/{id}/{email}" ) // http://localhost:8080/api/tickets/update/1/p@mail.com
	public ResponseEntity<Object> updateTicket(
			@PathVariable("id") Integer id,
			@PathVariable("newEmail") String newEmail) throws Exception {

		if (newEmail != null && newEmail.length() <= 4) {
			ExceptionResponse error = new ExceptionResponse();
			error.setErrorMessage("Missign Email");
			error.callerURL("/updateTicket");

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		} else {
			Ticket updateTicket = tktService.updateTicket(id, newEmail);
			return new ResponseEntity<>(updateTicket, HttpStatus.OK);
		}
	}

	
	@DeleteMapping (value="/delete/{id}")	// http://localhost:8080/api/tickets/delete/3
	public void deleteTicket(@PathVariable ("id") Integer id) {
		tktService.deleteTicket(id);
	}
}

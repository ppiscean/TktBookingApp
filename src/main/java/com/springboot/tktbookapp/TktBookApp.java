package com.springboot.tktbookapp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.tktbookapp.model.Ticket;
import com.springboot.tktbookapp.service.TktService;

@SpringBootApplication
public class TktBookApp implements CommandLineRunner{

	@Autowired
	private TktService tktService;
	
	public static void main(String[] args) {
		SpringApplication.run(TktBookApp.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		Ticket ticket = new Ticket();
		ticket.setPassengerName("PP");
		ticket.setDestinationStation("Menands");
		ticket.setSourceStation("BLR");
		ticket.setEmail("ppiscean@yahoo.com");
		ticket.setTravelDate(new Date());
		
		tktService.createTicket(ticket);
	}

}

package com.onlinebooking.controller;

import com.onlinebooking.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebooking.entities.Ticket;

@RestController
@RequestMapping(value="/api/tickets")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;
	
	@CrossOrigin
	@PostMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Ticket createTicket(@RequestBody Ticket ticket){
		return ticketBookingService.createTicket(ticket);
	}
	
	@CrossOrigin
	@GetMapping(value="/ticketId/{ticketId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Ticket getTicketById(@PathVariable("ticketId")Long ticketId){
		return ticketBookingService.getTicketById(ticketId);
	}
	
	@CrossOrigin
	@GetMapping(value="/alltickets",produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Ticket> getAllBookedTickets(){
		return ticketBookingService.getAllBookedTickets();
	}
	
	@CrossOrigin
	@GetMapping(value="/email/{email:.+}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Ticket getTicketByEmail(@PathVariable("email")String email){
		return ticketBookingService.getTicketByEmail(email);
	}
	
	@CrossOrigin
	@DeleteMapping(value="/ticketId/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId")Long ticketId){
		ticketBookingService.deleteTicket(ticketId);
	}
	
	@CrossOrigin
	@PutMapping(value="/ticketId/{ticketId}/email/{newEmail:.+}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Ticket updateTicket(@PathVariable("ticketId")Long ticketId,@PathVariable("newEmail")String newEmail){
		return ticketBookingService.updateTicket(ticketId,newEmail);
	}
}

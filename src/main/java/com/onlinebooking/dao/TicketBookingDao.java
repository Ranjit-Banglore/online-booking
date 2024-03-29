package com.onlinebooking.dao;

import org.springframework.data.repository.CrudRepository;

import com.onlinebooking.entities.Ticket;

public interface TicketBookingDao extends CrudRepository<Ticket, Integer>{
	Ticket findByEmail(String email);
}

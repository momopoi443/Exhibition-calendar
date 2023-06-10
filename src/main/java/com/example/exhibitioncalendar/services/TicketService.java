package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.Ticket;

import java.util.Optional;

public interface TicketService {

    Ticket saveNewTicket(Ticket newTicket);

    Optional<Ticket> getTicketById(Long ticketId);
}

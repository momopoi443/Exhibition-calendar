package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.Ticket;

public interface TicketService {

    Ticket saveNewTicket(Ticket newTicket);

    Ticket getTicketById(Long ticketId);
}

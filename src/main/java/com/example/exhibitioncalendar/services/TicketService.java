package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.dataModels.entities.Ticket;

public interface TicketService {

    Ticket saveNewTicket(Ticket newTicket);

    Ticket getTicketById(Long ticketId);
}

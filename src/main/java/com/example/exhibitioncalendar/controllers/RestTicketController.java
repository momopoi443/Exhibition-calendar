package com.example.exhibitioncalendar.controllers;

import com.example.exhibitioncalendar.dataModels.entities.Ticket;
import com.example.exhibitioncalendar.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestTicketController {
    public static final String TICKET_PATH = "/api/v1/ticket";
    public static final String TICKET_PATH_ID = TICKET_PATH + "/{ticketId}";

    private final TicketService ticketService;

    @GetMapping(TICKET_PATH_ID)
    public Ticket getTicketInfoById(@PathVariable Long ticketId) {
        return ticketService.getTicketById(ticketId);
    }
}

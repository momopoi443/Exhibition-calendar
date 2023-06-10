package com.example.exhibitioncalendar.controllers;

import com.example.exhibitioncalendar.entities.Ticket;
import com.example.exhibitioncalendar.services.TicketService;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class TicketController {
    public static final String TICKET_PATH = "/api/v1/ticket";
    public static final String TICKET_PATH_ID = TICKET_PATH + "/{ticketId}";

    private final TicketService ticketService;

    @GetMapping(TICKET_PATH_ID)
    public String getTicketInfoById(@PathVariable Long ticketId, Model model) {
        Ticket ticket = ticketService
                .getTicketById(ticketId)
                .orElseThrow(() -> new NotFoundException("No ticket with such id"));

        model.addAttribute("ticket", ticket);

        return "ticketInfo";
    }
}

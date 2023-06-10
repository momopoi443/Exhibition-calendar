package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.Ticket;
import com.example.exhibitioncalendar.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public Ticket saveNewTicket(Ticket newTicket) {
        return ticketRepository.save(newTicket);
    }

    @Override
    public Optional<Ticket> getTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId);
    }
}

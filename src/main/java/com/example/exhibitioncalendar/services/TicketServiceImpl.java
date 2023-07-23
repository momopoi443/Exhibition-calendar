package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.dataModels.entities.Ticket;
import com.example.exhibitioncalendar.repositories.TicketRepository;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public Ticket saveNewTicket(Ticket newTicket) {
        Ticket savedTicket = ticketRepository.save(newTicket);

        log.info("Saved new Ticket with " + savedTicket.getId() + " id into database");

        return savedTicket;
    }

    @Override
    public Ticket getTicketById(Long ticketId) {
        return ticketRepository
                .findById(ticketId)
                .orElseThrow(() -> {
                    var ex = new NotFoundException("No ticket with such id");
                    log.error(ex.getLocalizedMessage());
                    return ex;
                });
    }
}

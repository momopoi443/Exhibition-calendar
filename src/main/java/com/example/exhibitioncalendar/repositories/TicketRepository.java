package com.example.exhibitioncalendar.repositories;

import com.example.exhibitioncalendar.dataModels.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

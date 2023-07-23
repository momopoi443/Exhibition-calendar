package com.example.exhibitioncalendar.repositories;

import com.example.exhibitioncalendar.dataModels.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

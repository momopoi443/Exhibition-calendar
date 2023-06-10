package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.Payment;

import java.util.Optional;

public interface PaymentService {

    Payment createPayment(Long userId, Long expositionId);

    Payment saveNewPayment(Payment newPayment);

    Optional<Payment> getPaymentById(Long paymentId);
}

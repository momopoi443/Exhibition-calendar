package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.Payment;

public interface PaymentService {

    Payment createPayment(Long userId, Long expositionId);

    Payment saveNewPayment(Payment newPayment);

    Payment getPaymentById(Long paymentId);
}

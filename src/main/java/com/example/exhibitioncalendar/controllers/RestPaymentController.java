package com.example.exhibitioncalendar.controllers;

import com.example.exhibitioncalendar.entities.Payment;
import com.example.exhibitioncalendar.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RestPaymentController {
    public static final String PAYMENT_PATH = "/api/v1/payment";
    public static final String PAYMENT_PATH_ID = PAYMENT_PATH + "/{paymentId}";

    private final PaymentService paymentService;

    @PostMapping(PAYMENT_PATH)
    public Payment createPayment(
            @RequestParam(name= "expositionId") Long expositionId,
            @RequestParam(name= "userId") Long userId
    ) {
        return paymentService.createPayment(userId, expositionId);
    }

    @GetMapping(PAYMENT_PATH_ID)
    public Payment getPaymentById(@PathVariable Long paymentId) {
        return paymentService.getPaymentById(paymentId);
    }
}

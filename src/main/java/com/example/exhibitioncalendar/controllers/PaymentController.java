package com.example.exhibitioncalendar.controllers;

import com.example.exhibitioncalendar.entities.Payment;
import com.example.exhibitioncalendar.services.PaymentService;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PaymentController {
    public static final String PAYMENT_PATH = "/api/v1/payment";
    public static final String PAYMENT_PATH_ID = PAYMENT_PATH + "/{paymentId}";

    private final PaymentService paymentService;

    @PostMapping(PAYMENT_PATH)
    public String createPayment(
            @RequestParam(name= "expositionId") Long expositionId,
            @RequestParam(name= "userId") Long userId,
            Model model
    ) {
        Payment createdPayment = paymentService.createPayment(expositionId, userId);

        model.addAttribute("createdPayment", createdPayment);

        return "createdPaymentInfo";
    }

    @GetMapping(PAYMENT_PATH_ID)
    public String getPaymentById(@PathVariable Long paymentId, Model model) {
        Payment payment = paymentService
                .getPaymentById(paymentId)
                .orElseThrow(() -> new NotFoundException("No payment with such id"));

        model.addAttribute("payment", payment);

        return "paymentInfo";
    }
}

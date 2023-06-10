package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.Exposition;
import com.example.exhibitioncalendar.entities.Payment;
import com.example.exhibitioncalendar.entities.Ticket;
import com.example.exhibitioncalendar.entities.User;
import com.example.exhibitioncalendar.repositories.PaymentRepository;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final ExpositionService expositionService;
    private final UserService userService;
    private final TicketService ticketService;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public Payment createPayment(Long userId, Long expositionId) {
        User owner = userService
                .getUserById(userId)
                .orElseThrow(() -> new NotFoundException("No user with such id"));
        Exposition exposition = expositionService
                .getExpositionById(expositionId)
                .orElseThrow(() -> new NotFoundException("No exposition with such id"));

        userService.decreaseUserBalanceBy(owner.getId(), exposition.getTicketPrice());

        Ticket ticket = Ticket.builder()
                .payment(null)
                .exposition(exposition)
                .owner(owner)
                .build();
        ticket = ticketService.saveNewTicket(ticket);

        Payment payment = Payment.builder()
                .ticket(ticket)
                .price(exposition.getTicketPrice())
                .build();
        payment = saveNewPayment(payment);

        return payment;
    }

    @Override
    public Payment saveNewPayment(Payment newPayment) {
        return paymentRepository.save(newPayment);
    }

    @Override
    public Optional<Payment> getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }
}

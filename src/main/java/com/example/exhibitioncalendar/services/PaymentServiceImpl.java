package com.example.exhibitioncalendar.services;

import com.example.exhibitioncalendar.entities.Exposition;
import com.example.exhibitioncalendar.entities.Payment;
import com.example.exhibitioncalendar.entities.Ticket;
import com.example.exhibitioncalendar.entities.User;
import com.example.exhibitioncalendar.repositories.PaymentRepository;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final ExpositionService expositionService;
    private final UserService userService;
    private final TicketService ticketService;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public Payment createPayment(Long userId, Long expositionId) {
        User owner = userService.getUserById(userId);
        Exposition exposition = expositionService.getExpositionById(expositionId);

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

        log.info("Created and saved new Payment with associated Ticket");

        return payment;
    }

    @Override
    public Payment saveNewPayment(Payment newPayment) {
        Payment savedPayment = paymentRepository.save(newPayment);

        log.info("Saved new Payment with " + savedPayment.getId() + " id into database");

        return savedPayment;
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository
                .findById(paymentId)
                .orElseThrow(() -> {
                    var ex = new NotFoundException("No payment with such id");
                    log.error(ex.getLocalizedMessage());
                    return ex;
                });
    }
}

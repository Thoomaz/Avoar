package com.project.Avoar.service;

import com.project.Avoar.dto.TicketDTO;
import com.project.Avoar.entity.Flight;
import com.project.Avoar.entity.Payment;
import com.project.Avoar.entity.Ticket;
import com.project.Avoar.entity.User;
import com.project.Avoar.entity.enumns.ClassAirplane;
import com.project.Avoar.entity.enumns.PaymentStatus;
import com.project.Avoar.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TicketService {

    @Autowired
    private TicketRepository repository;

    @Autowired
    private FlightService flightService;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    public List<Ticket> findAllByUser(Long userId){
        return repository.findAllByUserId(userId);
    }

    public List<Ticket> book(Long userId, Long flightId, int economic, int executive, int firstClass){
        User user = userService.findById(userId);
        Flight flight = flightService.detailsById(flightId);

        // Cria o pagamento PENDING
        Payment payment = new Payment(PaymentStatus.PENDING);

        // Gera tickets por classe
        List<Ticket> tickets = new ArrayList<>();
        tickets.addAll(generateTicketsByClass(flight, economic, ClassAirplane.ECONOMIC, flight.getPriceEconomic(), user, payment));
        tickets.addAll(generateTicketsByClass(flight, executive, ClassAirplane.EXECUTIVE, flight.getPriceExecutive(), user, payment));
        tickets.addAll(generateTicketsByClass(flight, firstClass, ClassAirplane.FIRST_CLASS, flight.getPriceFirstClass(), user, payment));

        // Associa tickets ao pagamento
        payment.getTickets().addAll(tickets);

        // Persiste o pagamento (cascade persiste todos os tickets)
        paymentService.save(payment);

        // Persiste o usuário atualizado (opcional, caso queira manter lista de tickets)
        user.getTickets().addAll(tickets);
        userService.save(user);

        return tickets;
    }

    // Gera os tickets por classe
    private List<Ticket> generateTicketsByClass(Flight flight, int quantity, ClassAirplane classAirplane,
                                                double price, User user, Payment payment) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            Ticket ticket = new Ticket(
                    null,
                    getSeats(classAirplane),
                    classAirplane,
                    flight.getDepartureDate(),
                    price,
                    payment,
                    user
            );
            tickets.add(ticket);

            // Relação bidirecional
            user.getTickets().add(ticket);
            payment.getTickets().add(ticket);
            ticket.getFlights().add(flight);
        }
        return tickets;
    }

    public String getSeats(ClassAirplane classAirplane) {
        String prefix;
        switch (classAirplane) {
            case ECONOMIC:
                prefix = "A";
                break;
            case EXECUTIVE:
                prefix = "B";
                break;
            case FIRST_CLASS:
                prefix = "C";
                break;
            default:
                prefix = "X";
        }
        int seatNumber = ThreadLocalRandom.current().nextInt(1, 61);
        return prefix + seatNumber;
    }
}

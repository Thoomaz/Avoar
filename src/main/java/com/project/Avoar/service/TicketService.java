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

    public List<Ticket> findAllByUser(Long userId){
        return repository.findAllByUser(userId);
    }

    public List<Ticket> book(Long userId, Long flightId, int economic, int executive, int firstClass){
        User user = userService.findById(userId);
        Flight flight = flightService.detailsById(flightId);

        List<Ticket> tickets = generateTickets(flight, economic, executive, firstClass);
        user.getTickets().addAll(tickets);
        userService.save(user);

        return tickets;
    }

    private List<Ticket> generateTickets(Flight flight, int economic, int executive, int firstClass) {
        List<Ticket> tickets = new ArrayList<>();

        Payment payment = new Payment(PaymentStatus.PENDING);

        tickets.addAll(generateTicketsByClass(flight, economic, ClassAirplane.ECONOMIC, flight.getPriceEconomic(), payment));
        tickets.addAll(generateTicketsByClass(flight, executive, ClassAirplane.EXECUTIVE, flight.getPriceExecutive(), payment));
        tickets.addAll(generateTicketsByClass(flight, firstClass, ClassAirplane.FIRST_CLASS, flight.getPriceFirstClass(), payment));

        return repository.saveAll(tickets);
    }
    private List<Ticket> generateTicketsByClass(Flight flight, int quantity, ClassAirplane classAirplane, double price, Payment payment) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            tickets.add(new Ticket(
                    null,
                    getSeats(classAirplane),
                    classAirplane,
                    flight.getDepartureDate(),
                    price,
                    payment
            ));
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

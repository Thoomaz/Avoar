package com.project.Avoar.entity;

import com.project.Avoar.entity.enumns.ClassAirplane;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "tb_ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seat;
    @Enumerated(EnumType.STRING)
    private ClassAirplane classAirplane;
    private LocalDate date;
    private Double ticketValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToMany(mappedBy = "ticket")
    private List<Flight> flights = new ArrayList<>();

    public Ticket() {}

    public Ticket(Long id, String seat, ClassAirplane classAirplane, LocalDate date, Double value, Payment payment, User user) {
        this.id = id;
        this.seat = seat;
        this.classAirplane = classAirplane;
        this.date = date;
        this.ticketValue = value;
        this.payment = payment;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public ClassAirplane getClassAirplane() {
        return classAirplane;
    }

    public void setClassAirplane(ClassAirplane classAirplane) {
        this.classAirplane = classAirplane;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTicketValue() {
        return ticketValue;
    }

    public void setTicketValue(Double ticketValue) {
        this.ticketValue = ticketValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                '}';
    }
}

package com.project.Avoar.entities;

import com.project.Avoar.entities.enumns.ClassAirplane;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String seat;
    private ClassAirplane classAirplane;
    private LocalDate date;
    private Double value;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "ticket")
    private Payment payment;

    @OneToMany
    private Set<Flight> flights = new HashSet<>();

    @OneToMany
    private Set<Baggage> baggages = new HashSet<>();

    public Ticket() {}

    public Ticket(Long id, String code, String seat, ClassAirplane classAirplane, LocalDate date, Double value) {
        this.id = id;
        this.code = code;
        this.seat = seat;
        this.classAirplane = classAirplane;
        this.date = date;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    public Set<Baggage> getBaggages() {
        return baggages;
    }

    public void setBaggages(Set<Baggage> baggages) {
        this.baggages = baggages;
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

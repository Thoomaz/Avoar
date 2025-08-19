package com.project.Avoar.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private LocalDate departureDate;
    private LocalDate arrivalDate;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "airport_takeoff_id")
    private Airport takeOff;

    @ManyToOne
    @JoinColumn(name = "airport_land_id")
    private Airport land;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    public Flight() {}

    public Flight(Long id, String code, LocalDate departureDate, LocalDate arrivalDate) {
        this.id = id;
        this.code = code;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
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

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Airport getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(Airport takeOff) {
        this.takeOff = takeOff;
    }

    public Airport getLand() {
        return land;
    }

    public void setLand(Airport land) {
        this.land = land;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                '}';
    }
}

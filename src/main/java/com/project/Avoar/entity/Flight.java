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
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private String departurePlace;
    private String arrivalPlace;
    private Double priceEconomic;
    private Double priceExecutive;
    private Double priceFirstClass;

    private int seatAvaliableEconomic;
    private int seatAvaliableExecutive;
    private int seatAvaliableFirstClass;

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

    public Flight(Long id, LocalDate departureDate, LocalDate arrivalDate) {
        this.id = id;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public String getArrivalPlace() {
        return arrivalPlace;
    }

    public void setArrivalPlace(String arrivalPlace) {
        this.arrivalPlace = arrivalPlace;
    }


    public Double getPriceEconomic() {
        return priceEconomic;
    }

    public void setPriceEconomic(Double priceEconomic) {
        this.priceEconomic = priceEconomic;
    }

    public Double getPriceExecutive() {
        return priceExecutive;
    }

    public void setPriceExecutive(Double priceExecutive) {
        this.priceExecutive = priceExecutive;
    }

    public Double getPriceFirstClass() {
        return priceFirstClass;
    }

    public void setPriceFirstClass(Double priceFirstClass) {
        this.priceFirstClass = priceFirstClass;
    }

    public int getSeatAvaliableEconomic() {
        return seatAvaliableEconomic;
    }

    public void setSeatAvaliableEconomic(int seatAvaliableEconomic) {
        this.seatAvaliableEconomic = seatAvaliableEconomic;
    }

    public int getSeatAvaliableExecutive() {
        return seatAvaliableExecutive;
    }

    public void setSeatAvaliableExecutive(int seatAvaliableExecutive) {
        this.seatAvaliableExecutive = seatAvaliableExecutive;
    }

    public int getSeatAvaliableFirstClass() {
        return seatAvaliableFirstClass;
    }

    public void setSeatAvaliableFirstClass(int seatAvaliableFirstClass) {
        this.seatAvaliableFirstClass = seatAvaliableFirstClass;
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

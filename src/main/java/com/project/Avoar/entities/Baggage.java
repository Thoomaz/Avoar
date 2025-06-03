package com.project.Avoar.entities;

import com.project.Avoar.entities.enumns.BaggageType;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_baggage")
public class Baggage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BaggageType type;
    private Double weight;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public Baggage() {}

    public Baggage(Long id, BaggageType type, Double weight) {
        this.id = id;
        this.type = type;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaggageType getType() {
        return type;
    }

    public void setType(BaggageType type) {
        this.type = type;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Baggage baggage = (Baggage) o;
        return Objects.equals(id, baggage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Baggage{" +
                "id=" + id +
                '}';
    }
}

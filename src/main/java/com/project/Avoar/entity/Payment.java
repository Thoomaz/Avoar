package com.project.Avoar.entity;

import com.project.Avoar.entity.enumns.PaymentStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentMethod;
    private LocalDate date;
    private PaymentStatus status;
    private Double valuePayment;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.PERSIST)
    private List<Ticket> tickets = new ArrayList<>();

    public Payment() {}

    public Payment(Long id, String paymentMethod, LocalDate date, PaymentStatus status) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.date = date;
        this.status = status;
    }

    public Payment(PaymentStatus status) {
        this.status = status;
    }

    public Payment(Double value, String paymentMethod) {
        this.valuePayment = value;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Double getValuePayment() {
        return valuePayment;
    }

    public void setValuePayment(Double valuePayment) {
        this.valuePayment = valuePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                '}';
    }
}

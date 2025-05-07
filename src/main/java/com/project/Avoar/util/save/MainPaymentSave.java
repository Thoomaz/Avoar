package com.project.Avoar.util.save;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.dao.impl.PaymentDAOImpl;
import com.project.Avoar.entities.Payment;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainPaymentSave {
    public static void main(String[] args) {
        Payment payment = new Payment(
                null,
                "Cartão de Crédito",
                LocalDate.of(2025, 5, 7),
                "Confirmado"
        );

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("avoar")) {
            PaymentDAOImpl repository = new PaymentDAOImpl(Payment.class, emf);
            repository.save(payment);
        } catch (PersistenciaDawException e){
            System.out.println(e.getMessage());
        }
    }
}

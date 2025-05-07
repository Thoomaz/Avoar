package com.project.Avoar.util.delete;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.dao.impl.PaymentDAOImpl;
import com.project.Avoar.entities.Payment;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainPaymentDeleteAll {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("avoar")) {
            PaymentDAOImpl repository = new PaymentDAOImpl(Payment.class, emf);
            repository.deleteAll();
        } catch (PersistenciaDawException e){
            System.out.println(e.getMessage());
        }
    }
}

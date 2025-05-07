package com.project.Avoar.util.delete;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.dao.impl.TicketDAOImpl;
import com.project.Avoar.entities.Ticket;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainTicketDeleteAll {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("avoar")) {
            TicketDAOImpl repository = new TicketDAOImpl(Ticket.class, emf);
            repository.deleteAll();
        } catch (PersistenciaDawException e){
            System.out.println(e.getMessage());
        }
    }
}

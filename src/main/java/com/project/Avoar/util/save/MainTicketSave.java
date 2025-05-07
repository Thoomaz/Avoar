package com.project.Avoar.util.save;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.dao.impl.TicketDAOImpl;
import com.project.Avoar.entities.Ticket;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainTicketSave {
    public static void main(String[] args) {
        Ticket ticket = new Ticket(
                null,
                "TK123456",
                "12A",
                "Econômica",
                LocalDate.of(2025, 5, 10),
                599.90
        );
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("avoar")) {
            TicketDAOImpl repository = new TicketDAOImpl(Ticket.class, emf);
            repository.save(ticket);
        } catch (PersistenciaDawException e){
            System.out.println(e.getMessage());
        }
    }
}

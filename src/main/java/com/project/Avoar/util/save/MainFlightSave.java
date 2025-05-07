package com.project.Avoar.util.save;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.dao.impl.FlightDAOImpl;
import com.project.Avoar.entities.Flight;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainFlightSave {
    public static void main(String[] args) {
        Flight flight = new Flight(
                null,
                "FL1234",
                LocalDate.of(2025, 6, 10),
                LocalDate.of(2025, 6, 11)
        );

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("avoar")) {
            FlightDAOImpl repository = new FlightDAOImpl(Flight.class, emf);
            repository.save(flight);
        } catch (PersistenciaDawException e){
            System.out.println(e.getMessage());
        }
    }


}

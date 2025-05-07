package com.project.Avoar.util.delete;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.dao.impl.FlightDAOImpl;
import com.project.Avoar.entities.Flight;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainFlightDeleteAll {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("avoar")) {
            FlightDAOImpl repository = new FlightDAOImpl(Flight.class, emf);
            repository.deleteAll();
        } catch (PersistenciaDawException e){
            System.out.println(e.getMessage());
        }
    }
}

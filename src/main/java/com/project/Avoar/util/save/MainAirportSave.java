package com.project.Avoar.util.save;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.dao.impl.AirportDAOImpl;
import com.project.Avoar.entities.Airport;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAirportSave {
    public static void main(String[] args) {
        Airport airport = new Airport(
                null,
                "Aeroporto Internacional de Guarulhos",
                "Guarulhos",
                "SP",
                "Brasil",
                "GRU"
        );

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("avoar")) {
            AirportDAOImpl repository = new AirportDAOImpl(Airport.class, emf);
            repository.save(airport);
        } catch (PersistenciaDawException e){
            System.out.println(e.getMessage());
        }
    }
}

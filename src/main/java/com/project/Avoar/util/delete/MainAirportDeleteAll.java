package com.project.Avoar.util.delete;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.dao.impl.AirportDAOImpl;
import com.project.Avoar.entities.Airport;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAirportDeleteAll {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("avoar")) {
            AirportDAOImpl repository = new AirportDAOImpl(Airport.class, emf);
            repository.deleteAll();
        } catch (PersistenciaDawException e){
            System.out.println(e.getMessage());
        }
    }
}

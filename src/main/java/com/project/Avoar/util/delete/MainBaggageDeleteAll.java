package com.project.Avoar.util.delete;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.dao.impl.BaggageDAOImpl;
import com.project.Avoar.entities.Baggage;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainBaggageDeleteAll {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("avoar")) {
            BaggageDAOImpl repository = new BaggageDAOImpl(Baggage.class, emf);
            repository.deleteAll();
        } catch (PersistenciaDawException e){
            System.out.println(e.getMessage());
        }
    }
}

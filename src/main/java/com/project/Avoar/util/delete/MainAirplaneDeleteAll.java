package com.project.Avoar.util.delete;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.dao.impl.AirplaneDAOImpl;
import com.project.Avoar.entities.Airplane;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAirplaneDeleteAll {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("avoar")) {
            AirplaneDAOImpl repository = new AirplaneDAOImpl(Airplane.class, emf);
            repository.deleteAll();
        } catch (PersistenciaDawException e){
            System.out.println(e.getMessage());
        }
    }
}

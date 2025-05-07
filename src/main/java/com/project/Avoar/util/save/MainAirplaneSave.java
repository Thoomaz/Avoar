package com.project.Avoar.util.save;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.dao.impl.AirplaneDAOImpl;
import com.project.Avoar.entities.Airplane;
import com.project.Avoar.util.DawException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAirplaneSave {
    public static void main(String[] args) throws DawException {

        Airplane airplane = new Airplane(
                null,
                "Boeing 737",
                "LATAM Airlines",
                180,
                120,
                40,
                20
        );
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("avoar")) {
            AirplaneDAOImpl repository = new AirplaneDAOImpl(Airplane.class, emf);
            repository.save(airplane);
        } catch (PersistenciaDawException e){
            System.out.println(e.getMessage());
        }
    }
}

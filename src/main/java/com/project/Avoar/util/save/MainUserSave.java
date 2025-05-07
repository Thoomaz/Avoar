package com.project.Avoar.util.save;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.dao.impl.UserDAOImpl;
import com.project.Avoar.entities.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainUserSave {
    public static void main(String[] args) {
        User user = new User(
                null,
                "João Silva",
                "joao.silva@example.com",
                "senhaSegura123"
        );

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("avoar")) {
            UserDAOImpl repository = new UserDAOImpl(User.class, emf);
            repository.save(user);
        } catch (PersistenciaDawException e) {
            System.out.println(e.getMessage());
        }
    }
}

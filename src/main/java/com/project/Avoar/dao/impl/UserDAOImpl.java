package com.project.Avoar.dao.impl;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class UserDAOImpl extends AbstractDAOImpl<User, Long>{
    public UserDAOImpl(Class<User> entityClass, EntityManagerFactory emf) {
        super(entityClass, emf);
    }

    @Override
    protected EntityManager getEntityManager() {
        return super.getEntityManager();
    }

    @Override
    public void save(User obj) throws PersistenciaDawException {
        super.save(obj);
    }

    @Override
    public User update(User obj) throws PersistenciaDawException {
        return super.update(obj);
    }

    @Override
    public void delete(Long primaryKey) throws PersistenciaDawException {
        super.delete(primaryKey);
    }

    @Override
    public User getByID(Long primaryKey) throws PersistenciaDawException {
        return super.getByID(primaryKey);
    }

    @Override
    public List<User> getAll() throws PersistenciaDawException {
        return super.getAll();
    }

    @Override
    public void deleteAll() throws PersistenciaDawException {
        super.deleteAll();
    }
}

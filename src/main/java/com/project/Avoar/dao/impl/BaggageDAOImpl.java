package com.project.Avoar.dao.impl;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.entities.Baggage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class BaggageDAOImpl extends AbstractDAOImpl<Baggage, Long>{
    public BaggageDAOImpl(Class<Baggage> entityClass, EntityManagerFactory emf) {
        super(entityClass, emf);
    }

    @Override
    protected EntityManager getEntityManager() {
        return super.getEntityManager();
    }

    @Override
    public void save(Baggage obj) throws PersistenciaDawException {
        super.save(obj);
    }

    @Override
    public Baggage update(Baggage obj) throws PersistenciaDawException {
        return super.update(obj);
    }

    @Override
    public void delete(Long primaryKey) throws PersistenciaDawException {
        super.delete(primaryKey);
    }

    @Override
    public Baggage getByID(Long primaryKey) throws PersistenciaDawException {
        return super.getByID(primaryKey);
    }

    @Override
    public List<Baggage> getAll() throws PersistenciaDawException {
        return super.getAll();
    }

    @Override
    public void deleteAll() throws PersistenciaDawException {
        super.deleteAll();
    }
}

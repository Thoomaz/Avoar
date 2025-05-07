package com.project.Avoar.dao.impl;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.entities.Airport;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class AirportDAOImpl extends AbstractDAOImpl<Airport, Long>{
    public AirportDAOImpl(Class<Airport> entityClass, EntityManagerFactory emf) {
        super(entityClass, emf);
    }

    @Override
    protected EntityManager getEntityManager() {
        return super.getEntityManager();
    }

    @Override
    public void save(Airport obj) throws PersistenciaDawException {
        super.save(obj);
    }

    @Override
    public Airport update(Airport obj) throws PersistenciaDawException {
        return super.update(obj);
    }

    @Override
    public void delete(Long primaryKey) throws PersistenciaDawException {
        super.delete(primaryKey);
    }

    @Override
    public Airport getByID(Long primaryKey) throws PersistenciaDawException {
        return super.getByID(primaryKey);
    }

    @Override
    public List<Airport> getAll() throws PersistenciaDawException {
        return super.getAll();
    }

    @Override
    public void deleteAll() throws PersistenciaDawException {
        super.deleteAll();
    }
}

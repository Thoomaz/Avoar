package com.project.Avoar.dao.impl;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.entities.Airplane;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class AirplaneDAOImpl extends AbstractDAOImpl<Airplane, Long>{
    public AirplaneDAOImpl(Class<Airplane> entityClass, EntityManagerFactory emf) {
        super(entityClass, emf);
    }

    @Override
    protected EntityManager getEntityManager() {
        return super.getEntityManager();
    }

    @Override
    public void save(Airplane obj) throws PersistenciaDawException {
        super.save(obj);
    }

    @Override
    public Airplane update(Airplane obj) throws PersistenciaDawException {
        return super.update(obj);
    }

    @Override
    public void delete(Long primaryKey) throws PersistenciaDawException {
        super.delete(primaryKey);
    }

    @Override
    public Airplane getByID(Long primaryKey) throws PersistenciaDawException {
        return super.getByID(primaryKey);
    }

    @Override
    public List<Airplane> getAll() throws PersistenciaDawException {
        return super.getAll();
    }
}

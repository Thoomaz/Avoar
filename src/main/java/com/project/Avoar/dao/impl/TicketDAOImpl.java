package com.project.Avoar.dao.impl;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.entities.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class TicketDAOImpl extends AbstractDAOImpl<Ticket, Long>{
    public TicketDAOImpl(Class<Ticket> entityClass, EntityManagerFactory emf) {
        super(entityClass, emf);
    }

    @Override
    protected EntityManager getEntityManager() {
        return super.getEntityManager();
    }

    @Override
    public void save(Ticket obj) throws PersistenciaDawException {
        super.save(obj);
    }

    @Override
    public Ticket update(Ticket obj) throws PersistenciaDawException {
        return super.update(obj);
    }

    @Override
    public void delete(Long primaryKey) throws PersistenciaDawException {
        super.delete(primaryKey);
    }

    @Override
    public Ticket getByID(Long primaryKey) throws PersistenciaDawException {
        return super.getByID(primaryKey);
    }

    @Override
    public List<Ticket> getAll() throws PersistenciaDawException {
        return super.getAll();
    }
}

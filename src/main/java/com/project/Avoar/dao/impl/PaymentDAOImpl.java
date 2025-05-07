package com.project.Avoar.dao.impl;

import com.project.Avoar.dao.PersistenciaDawException;
import com.project.Avoar.entities.Payment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class PaymentDAOImpl extends AbstractDAOImpl<Payment, Long>{
    public PaymentDAOImpl(Class<Payment> entityClass, EntityManagerFactory emf) {
        super(entityClass, emf);
    }

    @Override
    protected EntityManager getEntityManager() {
        return super.getEntityManager();
    }

    @Override
    public void save(Payment obj) throws PersistenciaDawException {
        super.save(obj);
    }

    @Override
    public Payment update(Payment obj) throws PersistenciaDawException {
        return super.update(obj);
    }

    @Override
    public void delete(Long primaryKey) throws PersistenciaDawException {
        super.delete(primaryKey);
    }

    @Override
    public Payment getByID(Long primaryKey) throws PersistenciaDawException {
        return super.getByID(primaryKey);
    }

    @Override
    public List<Payment> getAll() throws PersistenciaDawException {
        return super.getAll();
    }
}

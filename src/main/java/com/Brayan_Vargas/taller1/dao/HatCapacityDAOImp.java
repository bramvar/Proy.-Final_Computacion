package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.HatCapacitydetail;
import com.Brayan_Vargas.taller1.model.HatParameter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HatCapacityDAOImp implements HatCapacityDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(HatCapacitydetail capacitydetail) {
        entityManager.persist(capacitydetail);
    }

    @Override
    public void edit(HatCapacitydetail capacitydetail) {
        entityManager.merge(capacitydetail);
    }

    @Override
    public void delete(HatCapacitydetail capacitydetail) {
        entityManager.remove(capacitydetail);
    }

    @Override
    public boolean isSaved(HatCapacitydetail capacitydetail) {
        return entityManager.contains(capacitydetail);
    }

    @Override
    public HatCapacitydetail findById(long id) {
        return entityManager.find(HatCapacitydetail.class, id);
    }

    @Override
    public List<HatCapacitydetail> findAll() {
        String jpql ="Select h From HatCapacitydetail h";
        return entityManager.createQuery(jpql).getResultList();
    }
}

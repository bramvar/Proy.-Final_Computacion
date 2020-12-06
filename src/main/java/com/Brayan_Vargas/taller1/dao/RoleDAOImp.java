package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.Rolee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDAOImp implements RoleDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Rolee rolee) {
        entityManager.persist(rolee);
    }
}

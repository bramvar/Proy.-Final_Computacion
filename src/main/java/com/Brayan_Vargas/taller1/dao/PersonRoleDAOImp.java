package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.PersonRole;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonRoleDAOImp implements PersonRoleDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(PersonRole personRole) {
        entityManager.persist(personRole);
    }
}

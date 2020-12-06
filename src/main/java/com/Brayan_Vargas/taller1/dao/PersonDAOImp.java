package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonDAOImp implements PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Person person) {
        entityManager.persist(person);
    }
}

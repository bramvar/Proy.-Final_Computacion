package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.Userr;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserrDAOImp implements UserrDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Userr userr) {
        entityManager.persist(userr);
    }

    @Override
    public List<Userr> findByName(String name) {
        String jpql= "SELECT u FROM Userr u WHERE u.userName='"+name+"'";
        return entityManager.createQuery(jpql).getResultList();
    }
}

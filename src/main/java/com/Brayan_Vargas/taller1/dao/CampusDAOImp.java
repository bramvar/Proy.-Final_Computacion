package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Institutioncampus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CampusDAOImp implements CampusDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Institutioncampus institutioncampus){
        entityManager.persist(institutioncampus);
    }

    @Override
    public void edit(Institutioncampus institutioncampus){
        entityManager.merge(institutioncampus);
    }

    @Override
    public void delete(Institutioncampus institutioncampus) {
        entityManager.remove(institutioncampus);
    }

    @Override
    public boolean isSaved(Institutioncampus institutioncampus) {
        return entityManager.contains(institutioncampus);
    }


    @Override
    public Institutioncampus findById(long id) {
        return entityManager.find(Institutioncampus.class, id);
    }

    @Override
    public List<Institutioncampus> findAll() {
        String jpql ="Select c From Institutioncampus c";
        return entityManager.createQuery(jpql).getResultList();
    }
}

package com.Brayan_Vargas.taller1.dao;


import com.Brayan_Vargas.taller1.model.Institution;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class InstitutionDAOImp implements InstitutionDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Institution institution) {
        entityManager.persist(institution);
    }

    @Override
    public void edit(Institution institution){
        entityManager.merge(institution);
    }

    @Override
    public void delete(Institution institution) {
        entityManager.remove(institution);
    }

    @Override
    public boolean isSaved(Institution institution) {
        return entityManager.contains(institution);
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE from Institutioncampus").executeUpdate();
        entityManager.createQuery("DELETE from Institution").executeUpdate();
    }

    @Override
    public Institution findById(long id) {
        return  entityManager.find(Institution.class, id);
    }

    @Override
    public List<Institution> findAll() {
        String jpql ="Select i From Institution i";
        return entityManager.createQuery(jpql).getResultList();
    }

}

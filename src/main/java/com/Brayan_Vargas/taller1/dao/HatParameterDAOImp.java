package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.HatParameter;
import com.Brayan_Vargas.taller1.model.Institutioncampus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HatParameterDAOImp implements HatParameterDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(HatParameter hatParameter) {
        entityManager.persist(hatParameter);
    }

    @Override
    public void edit(HatParameter hatParameter) {
        entityManager.merge(hatParameter);
    }

    @Override
    public void delete(HatParameter hatParameter) {
        entityManager.remove(hatParameter);
    }

    @Override
    public boolean isSaved(HatParameter hatParameter) {
        return entityManager.contains(hatParameter);
    }

    @Override
    public HatParameter findById(long id) {
        return entityManager.find(HatParameter.class, id);
    }

    @Override
    public List<HatParameter> findAll() {
        String jpql ="Select h From HatParameter h";
        return entityManager.createQuery(jpql).getResultList();
    }
}

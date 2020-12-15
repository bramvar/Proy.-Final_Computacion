package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.HatParameter;
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

    }

    @Override
    public void edit(HatParameter hatParameter) {

    }

    @Override
    public void delete(HatParameter hatParameter) {

    }

    @Override
    public boolean isSaved(HatParameter hatParameter) {
        return false;
    }

    @Override
    public HatParameter findById(long id) {
        return null;
    }

    @Override
    public List<HatParameter> findAll() {
        return null;
    }
}

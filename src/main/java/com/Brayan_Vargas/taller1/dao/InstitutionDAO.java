package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.Institution;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface InstitutionDAO {

    public void save(Institution institution);
    public void edit(Institution institution);
    public void delete(Institution institution);
    public boolean isSaved(Institution institution);
    public void deleteAll();

    public Institution findById(long id);
    public List<Institution> findAll();
}

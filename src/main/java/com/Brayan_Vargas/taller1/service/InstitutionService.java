package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.model.Institution;

import java.util.List;

public interface InstitutionService {

    public Institution saveInstitution(Institution inst);
    public Institution editInstitution(Institution inst);
    public Institution getInstitution(long id);
    //public Iterable<Institution> findAll();
    public List<Institution> findAll();
    public void delete(Institution inst);

    public boolean isSaved(Institution institution);

}

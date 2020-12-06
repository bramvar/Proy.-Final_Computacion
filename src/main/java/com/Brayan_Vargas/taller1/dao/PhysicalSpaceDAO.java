package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.Physicalspace;

import java.util.Date;
import java.util.List;

public interface PhysicalSpaceDAO {

    public void save(Physicalspace physicalspace);
    public boolean isSaved(Physicalspace physicalspace);
    public void edit(Physicalspace physicalspace);
    public void delete(Physicalspace physicalspace);

    public void deletedAll();

    public Physicalspace findById(long id);
    public List<Physicalspace> findAll();
    public List<Physicalspace> findByExtId(String id);
    public List<Physicalspace> findByName(String name);
    public List<Physicalspace> findByDate(Date dateIni, Date dateFin);
    public List<Physicalspace> findByDateAndOccupation(Date dateIni, Date dateFin);

}

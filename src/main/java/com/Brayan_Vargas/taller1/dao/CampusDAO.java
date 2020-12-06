package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.Institutioncampus;

import java.util.List;

public interface CampusDAO {

    public void save(Institutioncampus institutioncampus);
    public void edit(Institutioncampus institutioncampus);
    public void delete(Institutioncampus institutioncampus);
    public boolean isSaved(Institutioncampus institutioncampus);

    public Institutioncampus findById(long id);
    public List<Institutioncampus> findAll();
}

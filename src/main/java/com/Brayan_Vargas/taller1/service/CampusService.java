package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.model.Institutioncampus;

import java.util.List;

public interface CampusService {

    public Institutioncampus saveCampus(Institutioncampus campus);
    public Institutioncampus editCampus(Institutioncampus campus);
    public List<Institutioncampus> findAll();
    public Institutioncampus findById(long id);
    public void delete(Institutioncampus campus);
}

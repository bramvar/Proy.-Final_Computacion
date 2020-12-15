package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.model.Physicalspace;

import java.util.List;

public interface PhysicalspaceService {

    public Physicalspace savePhysicalspace(Physicalspace physicalspace);
    public Physicalspace editPhysicalspace(Physicalspace physicalspace);
    public List<Physicalspace> findAll();
    public Physicalspace findById(long id);
    public void delete(Physicalspace physicalspace);
}

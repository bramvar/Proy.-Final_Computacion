package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;

import java.util.List;
import java.util.Optional;

public interface PhysicalspaceTypeService {

    public Physicalspacetype savePhysicalspaceTypeService(Physicalspacetype ps);
    public Physicalspacetype  editPhysicalspaceTypeService(Physicalspacetype ps);
    public List<Physicalspacetype> findAll();
    public Physicalspacetype findById(long id);
    public List<Institution> findAllInst();
    public Physicalspacetype delete(Physicalspacetype ps);
}

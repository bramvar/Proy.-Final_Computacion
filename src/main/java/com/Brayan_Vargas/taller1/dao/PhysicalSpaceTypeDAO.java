package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.Physicalspacetype;

import java.util.List;

public interface PhysicalSpaceTypeDAO {

    public void save(Physicalspacetype physicalspacetype);
    public void edit(Physicalspacetype physicalspacetype);
    public void delete(Physicalspacetype physicalspacetype);
    public boolean isSaved(Physicalspacetype physicalspacetype);

    public Physicalspacetype findById(long id);
    public List<Physicalspacetype> findAll();
    public List<Physicalspacetype> findByName(String name);
    public List<Physicalspacetype> findByExtId(String id);
}

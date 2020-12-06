package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.Physicalspace;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PhysicalSpaceTypeDAOImp implements PhysicalSpaceTypeDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Physicalspacetype physicalspacetype){
        entityManager.persist(physicalspacetype);
    }

    @Override
    public void edit(Physicalspacetype physicalspacetype){
        entityManager.merge(physicalspacetype);
    }

    @Override
    public void delete(Physicalspacetype physicalspacetype) {
        entityManager.remove(physicalspacetype);
    }

    @Override
    public boolean isSaved(Physicalspacetype physicalspacetype) {
        return entityManager.contains(physicalspacetype);
    }

    @Override
    public Physicalspacetype findById(long id) {
        return entityManager.find(Physicalspacetype.class,id);
    }

    @Override
    public List<Physicalspacetype> findAll() {
        String jpql = "Select pt From Physicalspacetype pt";
        return entityManager.createQuery(jpql).getResultList();
    }


    @Override
    public List<Physicalspacetype> findByName(String name) {
        String jpql= "SELECT p FROM Physicalspacetype p WHERE p.physpctypeName='"+name+"'";
        return entityManager.createQuery(jpql).getResultList();
    }

    @Override
    public List<Physicalspacetype> findByExtId(String id) {
        String jpql= "SELECT p FROM Physicalspacetype p WHERE p.physpctypeExtid='"+id+"'";
        return entityManager.createQuery(jpql).getResultList();
    }
}

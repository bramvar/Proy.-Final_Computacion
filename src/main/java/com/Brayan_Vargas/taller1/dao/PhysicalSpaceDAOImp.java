package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.Physicalspace;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
public class PhysicalSpaceDAOImp implements PhysicalSpaceDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Physicalspace physicalspace){
        entityManager.persist(physicalspace);
    }

    @Override
    public void edit(Physicalspace physicalspace){
        entityManager.merge(physicalspace);
    }

    @Override
    public void delete(Physicalspace physicalspace) {
        entityManager.remove(physicalspace);
    }

    @Override
    public void deletedAll() {
        entityManager.createQuery("DELETE From Physicalspace").executeUpdate();
    }

    @Override
    public Physicalspace findById(long id) {
        return  entityManager.find(Physicalspace.class, id);
    }

    @Override
    public List<Physicalspace> findAll() {
        String jpql = "Select p From Physicalspace p";
        return entityManager.createQuery(jpql).getResultList();
    }


    @Override
    public boolean isSaved(Physicalspace physicalspace) {
        return entityManager.contains(physicalspace);
    }


    @Override
    public List<Physicalspace> findByExtId(String id) {
        String jpql= "SELECT p FROM Physicalspace p WHERE p.physpcExtid='"+id+"'";
        return entityManager.createQuery(jpql).getResultList();
    }

    @Override
    public List<Physicalspace> findByName(String name) {
        String jpql= "SELECT p FROM Physicalspace p WHERE p.physpcName='"+name+"'";
        return entityManager.createQuery(jpql).getResultList();
    }

    @Override
    public List<Physicalspace> findByDate(Date dateIni, Date dateFin) {
        String jpql = "Select p from Physicalspace p INNER JOIN Communityinstance c ON (p.physpcId=c.physicalspace.physpcId) AND (c.comminstStartdatehour BETWEEN :dateIni AND  :dateFin OR c.comminstEnddatehour BETWEEN :dateIni AND :dateFin) ORDER BY c.comminstStartdatehour ASC"; // WHERE t.scheduledDate BETWEEN  '"+init+"' and '"+end+"'";
        Query i = entityManager.createQuery(jpql).setParameter("dateIni",dateIni)
                                                 .setParameter("dateFin", dateFin);
        return i.getResultList();
    }

    @Override
    public List<Physicalspace> findByDateAndOccupation(Date dateIni, Date dateFin) {
        String jpql = "Select p from Physicalspace p INNER JOIN Communityinstance c ON (p.physpcId=c.physicalspace.physpcId) AND (c.comminstStartdatehour BETWEEN :dateIni AND  :dateFin OR c.comminstEnddatehour BETWEEN :dateIni AND :dateFin) AND (p.physpcOccupation < 10)";
        Query i = entityManager.createQuery(jpql).setParameter("dateIni",dateIni)
                                                 .setParameter("dateFin", dateFin);
        return i.getResultList();
    }
}

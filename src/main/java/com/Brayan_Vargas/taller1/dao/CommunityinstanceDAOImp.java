package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.Communityinstance;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class CommunityinstanceDAOImp implements CommunityinstanceDAO{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Communityinstance communityinstance){
        entityManager.persist(communityinstance);
    }

    @Override
    public void edit(Communityinstance communityinstance){
        entityManager.merge(communityinstance);
    }

    @Override
    public void delete(Communityinstance communityinstance) {
        entityManager.remove(communityinstance);
    }

    @Override
    public boolean isSaved(Communityinstance communityinstance) {
        return entityManager.contains(communityinstance);
    }

    @Override
    public Communityinstance findById(long id) {
        return entityManager.find(Communityinstance.class, id);
    }

    @Override
    public List<Communityinstance> findByDate(Date  dateIni, Date dateFin) {

        String jpql = "Select c from Communityinstance c WHERE c.comminstStartdatehour  BETWEEN :dateIni AND  :dateFin OR c.comminstEnddatehour BETWEEN :dateIni AND :dateFin";
        //String jpql = "Select c from Communityinstance c WHERE c.comminstStartdatehour  BETWEEN '"+CAST(dateIni AS DATE)+"' AND c.comminstEnddatehour < PARSEDATETIME(dateFin)";
        Query i = entityManager.createQuery(jpql).setParameter("dateIni",dateIni)
                .setParameter("dateFin", dateFin);

       // Query f= entityManager.createQuery(jpql).setParameter("dateFin", dateFin);

        return i.getResultList();

    }
}

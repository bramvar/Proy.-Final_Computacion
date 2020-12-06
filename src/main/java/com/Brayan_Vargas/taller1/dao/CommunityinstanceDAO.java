package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.Communityinstance;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CommunityinstanceDAO {
    public void save(Communityinstance communityinstance);
    public void edit(Communityinstance communityinstance);
    public void delete(Communityinstance communityinstance);
    public boolean isSaved(Communityinstance communityinstance);

    public Communityinstance findById(long id);
    public List<Communityinstance> findByDate(Date dateIni,Date dateFin);
}

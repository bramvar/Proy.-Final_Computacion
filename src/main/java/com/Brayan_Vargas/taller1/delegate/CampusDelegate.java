package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.dao.InstitutionDAO;
import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Institutioncampus;

public interface CampusDelegate {

    public Institutioncampus GET_Campus(long id);
    public void GET_Institutions();
    public Institutioncampus POST_Campus(Institutioncampus institutioncampus);
    public void PUT_Campus(Institutioncampus institutioncampus);
    public void DELETE_Campus(Institutioncampus institutioncampus);
}

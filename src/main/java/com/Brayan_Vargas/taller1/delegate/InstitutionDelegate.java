package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Institution;

public interface InstitutionDelegate {

    public Institution GET_Institution(long id);
    public Iterable<Institution> GET_Institutions();
    public Institution POST_Institution(Institution institution);
    public void PUT_Institution(Institution institution);
    public void DELETE_Institution(Institution institution);
}

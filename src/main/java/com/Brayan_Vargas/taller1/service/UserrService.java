package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.model.Userr;

public interface UserrService {

    public Userr saveUserr(Userr userr);
    public Iterable<Userr> findAll();

    public Iterable<Userr> findAllAdmins();

    public Iterable<Userr> findAllOperadores();

    public void deleteUserr(Userr userApp);

   //public Use[] getRoles();
}

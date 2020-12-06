package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.dao.UserrDAO;
import com.Brayan_Vargas.taller1.model.Userr;
import com.Brayan_Vargas.taller1.repository.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserrServiceImp implements UserrService {

    //private UserrRepository userrRep;
    private UserrDAO userrDAO;

    @Autowired
    public UserrServiceImp(UserrDAO userrDAO) {
        this.userrDAO = userrDAO;
    }

    @Override
    public Userr saveUserr(Userr userr) {
        userrDAO.save(userr);
        return userr;
    }

    @Override
    public Iterable<Userr> findAll() {
        return null;
    }

    @Override
    public Iterable<Userr> findAllAdmins() {
        return null;
    }

    @Override
    public Iterable<Userr> findAllOperadores() {
        return null;
    }

    @Override
    public void deleteUserr(Userr userApp) {

    }
}

package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.Userr;

import java.util.List;

public interface UserrDAO {
    public void save(Userr userr);
    public List<Userr> findByName(String name);
}

package com.Brayan_Vargas.taller1.dao;

import com.Brayan_Vargas.taller1.model.HatParameter;

import java.util.List;

public interface HatParameterDAO {
    public void save(HatParameter hatParameter);
    public void edit(HatParameter hatParameter);
    public void delete(HatParameter hatParameter);
    public boolean isSaved(HatParameter hatParameter);

    public HatParameter findById(long id);
    public List<HatParameter> findAll();
}

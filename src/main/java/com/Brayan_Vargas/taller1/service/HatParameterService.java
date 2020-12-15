package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.model.HatParameter;
import com.Brayan_Vargas.taller1.model.Institution;

import java.util.List;

public interface HatParameterService {

    public HatParameter saveHatParameter(HatParameter hatParameter);
    public HatParameter editHatParameter(HatParameter hatParameter);
    public HatParameter getHatParameter(long id);
    public List<HatParameter> findAll();

    public boolean isSaved(HatParameter hatParameter);
}

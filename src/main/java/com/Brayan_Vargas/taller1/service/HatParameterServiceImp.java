package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.dao.HatParameterDAO;
import com.Brayan_Vargas.taller1.model.HatParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HatParameterServiceImp implements HatParameterService {

    private HatParameterDAO hatParameterDAO;

    @Autowired
    public HatParameterServiceImp(HatParameterDAO hatParameterDAO) {
        this.hatParameterDAO = hatParameterDAO;
    }

    @Override
    public HatParameter saveHatParameter(HatParameter hatParameter) {
        return null;
    }

    @Override
    public HatParameter editHatParameter(HatParameter hatParameter) {
        return null;
    }

    @Override
    public HatParameter getHatParameter(long id) {
        return null;
    }

    @Override
    public List<HatParameter> findAll() {
        return null;
    }

    @Override
    public boolean isSaved(HatParameter hatParameter) {
        return false;
    }
}

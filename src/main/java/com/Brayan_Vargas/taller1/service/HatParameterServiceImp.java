package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.dao.HatParameterDAO;
import com.Brayan_Vargas.taller1.dao.InstitutionDAO;
import com.Brayan_Vargas.taller1.model.HatParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HatParameterServiceImp implements HatParameterService {

    private HatParameterDAO hatParameterDAO;
    private InstitutionDAO institutionDAO;

    @Autowired
    public HatParameterServiceImp(HatParameterDAO hatParameterDAO, InstitutionDAO institutionDAO) {
        this.hatParameterDAO = hatParameterDAO;
        this.institutionDAO = institutionDAO;
    }

    @Override
    @Transactional
    public HatParameter saveHatParameter(HatParameter hatParameter) {
        if(hatParameter!=null && institutionDAO.findById(hatParameter.getInstitution().getInstId())!=null){
            hatParameterDAO.save(hatParameter);
            return hatParameter;
        }
        return null;
    }

    @Override
    @Transactional
    public HatParameter editHatParameter(HatParameter hatParameter) {
        if(hatParameter!=null && institutionDAO.findById(hatParameter.getInstitution().getInstId())!=null ){

            HatParameter hatParameter1=hatParameterDAO.findById(hatParameter.getParamId());
            if(hatParameter1!=null){
                hatParameterDAO.edit(hatParameter);
                return hatParameter;
            }
        }
        return null;
    }

    @Override
    public HatParameter getHatParameter(long id) {
        return hatParameterDAO.findById(id);
    }

    @Override
    public List<HatParameter> findAll() {
        return hatParameterDAO.findAll();
    }

    @Override
    public void delete(HatParameter hatParameter) {
        hatParameterDAO.delete(hatParameter);
    }

    @Override
    public boolean isSaved(HatParameter hatParameter) {
        return hatParameterDAO.isSaved(hatParameter);
    }
}

package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.dao.CampusDAO;
import com.Brayan_Vargas.taller1.dao.InstitutionDAO;
import com.Brayan_Vargas.taller1.model.Institutioncampus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CampusServiceImp implements CampusService{

    //private CampusRepository campusRep;
    //private InstitutionRepository institutionRep;

    private CampusDAO campusDAO;
    private InstitutionDAO institutionDAO;

    @Autowired
    public CampusServiceImp(CampusDAO campusDAO, InstitutionDAO institutionDAO) {
        this.campusDAO = campusDAO;
        this.institutionDAO = institutionDAO;
    }

    @Override
    @Transactional
    public Institutioncampus saveCampus(Institutioncampus campus) {
        if(campus.getInstcamName()!=null &&
            campus.getInstcamOccupation().equals(new BigDecimal("0")) &&
            campus.getInstitution() != null && institutionDAO.findById(campus.getInstitution().getInstId()) != null
        ){
            campusDAO.save(campus);
            return campus;
        }
        return null;
    }

    @Override
    @Transactional
    public Institutioncampus editCampus(Institutioncampus campus) {

        if(campus.getInstcamName()!=null &&
                campus.getInstcamOccupation().equals(new BigDecimal("0")) &&
                campus.getInstitution() != null && institutionDAO.findById(campus.getInstitution().getInstId())!=null
        ){
            //Optional<Institutioncampus> instC = campusRep.findById( campus.getInstcamId());
            Institutioncampus instC = campusDAO.findById(campus.getInstcamId());
            if(instC!=null){
                /*instC.get().setInstcamName(campus.getInstcamName());
                instC.get().setInstcamOccupation(campus.getInstcamOccupation());
                instC.get().setInstitution(campus.getInstitution());*/
                campusDAO.edit(campus);
                return campus;
            }

        }
        return null;
    }

    @Override
    @Transactional
    public List<Institutioncampus> findAll() {
        return campusDAO.findAll();
    }

    @Override
    @Transactional
    public Institutioncampus findById(long id) {
        return campusDAO.findById(id);
    }
}

package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.dao.CampusDAO;
import com.Brayan_Vargas.taller1.dao.HatCapacityDAO;
import com.Brayan_Vargas.taller1.dao.HatParameterDAO;
import com.Brayan_Vargas.taller1.dao.InstitutionDAO;
import com.Brayan_Vargas.taller1.model.HatCapacitydetail;
import com.Brayan_Vargas.taller1.model.HatParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HatCapacityServiceImp implements HatCapacityService{

    private HatCapacityDAO hatCapacityDAO;
    private CampusDAO campusDAO;

    @Autowired
    public HatCapacityServiceImp(HatCapacityDAO hatCapacityDAO, CampusDAO campusDAO) {
        this.hatCapacityDAO = hatCapacityDAO;
        this.campusDAO = campusDAO;
    }

    @Override
    @Transactional
    public HatCapacitydetail saveHatCapacitydetail(HatCapacitydetail capacity) {
        if(capacity!=null && campusDAO.findById(capacity.getInstitutioncampus().getInstcamId())!=null){
            hatCapacityDAO.save(capacity);
            return capacity;
        }
        return null;
    }

    @Override
    @Transactional
    public HatCapacitydetail editHatCapacitydetail(HatCapacitydetail capacity) {
        if(capacity!=null && campusDAO.findById(capacity.getInstitutioncampus().getInstcamId())!=null){

            HatCapacitydetail capacity1=hatCapacityDAO.findById(capacity.getCapId());
            if(capacity1!=null){
                hatCapacityDAO.edit(capacity);
                return capacity;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public HatCapacitydetail getHatCapacitydetail(long id) {
        return hatCapacityDAO.findById(id);
    }

    @Override
    @Transactional
    public List<HatCapacitydetail> findAll() {
        return hatCapacityDAO.findAll();
    }

    @Override
    @Transactional
    public void delete(HatCapacitydetail capacity) { hatCapacityDAO.delete(capacity); }

    @Override
    @Transactional
    public boolean isSaved(HatCapacitydetail capacity) {
        return hatCapacityDAO.isSaved(capacity);
    }
}

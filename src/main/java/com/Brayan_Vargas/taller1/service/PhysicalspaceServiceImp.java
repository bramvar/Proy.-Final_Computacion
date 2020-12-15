package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.dao.CampusDAO;
import com.Brayan_Vargas.taller1.dao.PhysicalSpaceDAO;
import com.Brayan_Vargas.taller1.dao.PhysicalSpaceTypeDAO;
import com.Brayan_Vargas.taller1.model.Physicalspace;
import com.Brayan_Vargas.taller1.repository.CampusRepository;
import com.Brayan_Vargas.taller1.repository.PhysicalspaceRepository;
import com.Brayan_Vargas.taller1.repository.PhysicalspacetypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PhysicalspaceServiceImp implements PhysicalspaceService {

   /* private CampusRepository campusRep;
    private PhysicalspacetypeRepository physicalspacetypeRep;
    private PhysicalspaceRepository physicalspaceRep;*/

    private CampusDAO campusDAO;
    private PhysicalSpaceTypeDAO physicalSpaceTypeDAO;
    private PhysicalSpaceDAO physicalSpaceDAO;

    public PhysicalspaceServiceImp(CampusDAO campusDAO, PhysicalSpaceTypeDAO physicalSpaceTypeDAO, PhysicalSpaceDAO physicalSpaceDAO) {
        this.campusDAO = campusDAO;
        this.physicalSpaceTypeDAO = physicalSpaceTypeDAO;
        this.physicalSpaceDAO = physicalSpaceDAO;
    }

    @Override
    @Transactional
    public Physicalspace savePhysicalspace(Physicalspace physicalspace) {
        if(physicalspace.getPhysicalspacetype()!=null &&
                physicalspace.getInstitutioncampus() != null &&
                physicalspace.getPhyspcExtid().length()==5
                //physicalspace.getPhysicalspace() != null
        ){
            if((physicalSpaceTypeDAO.findById( physicalspace.getPhysicalspacetype().getPhyspctypeId())!=null) &&
                    (campusDAO.findById( physicalspace.getInstitutioncampus().getInstcamId())!=null)
            ){
                physicalSpaceDAO.save(physicalspace);
                return physicalspace;
            }

        }
        return null;
    }

    @Override
    public Physicalspace editPhysicalspace(Physicalspace physicalspace) {
        if(physicalspace.getPhysicalspacetype()!=null &&
                physicalspace.getInstitutioncampus() != null &&
                physicalspace.getPhyspcExtid().length()==5 &&
                //physicalspace.getPhysicalspace() != null &&
                physicalSpaceTypeDAO.findById(physicalspace.getPhysicalspacetype().getPhyspctypeId())!=null &&
                campusDAO.findById(physicalspace.getInstitutioncampus().getInstcamId())!=null
        ){
            Physicalspace ps = physicalSpaceDAO.findById(physicalspace.getPhyspcId());
            if(ps!=null){
                /*
                ps.get().setPhyspcExtid(physicalspace.getPhyspcExtid());
                ps.get().setInstitutioncampus(physicalspace.getInstitutioncampus());
                ps.get().setPhysicalspace(physicalspace.getPhysicalspace());*/

                physicalSpaceDAO.edit(physicalspace);
                return physicalspace;
            }


        }
        return null;
    }

    @Override
    public List<Physicalspace> findAll() {
        return physicalSpaceDAO.findAll();
    }

    @Override
    public Physicalspace findById(long id) {
        return physicalSpaceDAO.findById(id);
    }

    @Override
    public void delete(Physicalspace physicalspace) {
        physicalSpaceDAO.delete(physicalspace);
    }
}

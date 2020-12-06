package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.dao.InstitutionDAO;
import com.Brayan_Vargas.taller1.dao.PhysicalSpaceTypeDAO;
import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PhysicalspaceTypeServiceImp implements PhysicalspaceTypeService {

   //private InstitutionRepository institutionRep;
   //private PhysicalspacetypeRepository physicalspacetypeRep;

    private InstitutionDAO institutionDAO;
    private PhysicalSpaceTypeDAO physicalSpaceTypeDAO;

    @Autowired
    public PhysicalspaceTypeServiceImp(InstitutionDAO institutionDAO, PhysicalSpaceTypeDAO physicalSpaceTypeDAO) {
        this.institutionDAO = institutionDAO;
        this.physicalSpaceTypeDAO = physicalSpaceTypeDAO;
    }

    @Override
    @Transactional
    public Physicalspacetype savePhysicalspaceTypeService(Physicalspacetype ps) {
        if(ps.getPhyspctypeName() != null && !ps.getPhyspctypeName().equals("") &&
                ps.getPhyspctypeImpliescomm() != null &&
                ps.getInstitution() != null
        ) {
            if (institutionDAO.findById(ps.getInstitution().getInstId())!=null) {
                physicalSpaceTypeDAO.save(ps);
                return ps;
            }
        }
        return null;
    }

    @Override
    public Physicalspacetype editPhysicalspaceTypeService(Physicalspacetype ps) {
        if(ps.getPhyspctypeName()!=null && !ps.getPhyspctypeName().equals("") &&
                ps.getPhyspctypeImpliescomm() != null &&
                ps.getInstitution() != null && institutionDAO.findById( ps.getInstitution().getInstId())!=null
        ){
            //if ps.getInstitution().getInstId();
            Physicalspacetype pst = physicalSpaceTypeDAO.findById(ps.getPhyspctypeId());
            if (pst!=null){
                /*pst.get().setPhyspctypeName(ps.getPhyspctypeName());
                pst.get().setPhyspctypeImpliescomm(ps.getPhyspctypeImpliescomm());
                pst.get().setInstitution(ps.getInstitution());*/
                //physicalspacetypeRep.save(pst.get());

                physicalSpaceTypeDAO.edit(ps);
                return ps;
            }
        }
        return null;
    }

    @Override
    public List<Physicalspacetype> findAll() {
        return physicalSpaceTypeDAO.findAll();
    }

    @Override
    public Physicalspacetype findById(long id) {
        return physicalSpaceTypeDAO.findById(id);
    }

    @Override
    public List<Institution> findAllInst() {
        return institutionDAO.findAll();
    }


}

package com.Brayan_Vargas.taller1.service;

import com.Brayan_Vargas.taller1.dao.InstitutionDAO;
import com.Brayan_Vargas.taller1.model.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstitutionServiceImp implements InstitutionService{

    private final InstitutionDAO institutionDAO;

    @Autowired
    public InstitutionServiceImp(InstitutionDAO institutionDAO) {
        this.institutionDAO = institutionDAO;
    }

    /*
    private InstitutionRepository institutionRep;

    @Autowired
    public InstitutionServiceImp(InstitutionRepository institutionRep) {
        this.institutionRep = institutionRep;
    }
*/

    @Override
    @Transactional
    public Institution saveInstitution(Institution inst) {
        if(inst.getInstAcademicserverurl().startsWith("https://") &&
                inst.getInstAcadextradataurl().startsWith("https://") &&
                inst.getInstAcadloginurl().startsWith("https://") &&
                inst.getInstAcadpersoninfodocurl().startsWith("https://") &&
                inst.getInstAcadpersoninfoidurl().startsWith("https://") &&
                inst.getInstAcadphysicalspacesurl().startsWith("https://") &&
                inst.getInstAcadprogrammedcoursesurl().startsWith("https://") &&
                inst.getInstLdapurl().startsWith("https://") &&
                inst.getInstName()!= null &&
                !inst.getInstName().equals("")
        ) {
            //institutionRep.save(inst);
            institutionDAO.save(inst);
            return inst;
        }

        return null;
    }

    //Punto 5a
    @Override
    @Transactional
    public Institution editInstitution(Institution inst) {

        if(inst.getInstAcademicserverurl().startsWith("https://") &&
           inst.getInstAcadextradataurl().startsWith("https://") &&
           inst.getInstAcadloginurl().startsWith("https://") &&
           inst.getInstAcadpersoninfodocurl().startsWith("https://") &&
                inst.getInstAcadpersoninfoidurl().startsWith("https://") &&
           inst.getInstAcadphysicalspacesurl().startsWith("https://") &&
           inst.getInstAcadprogrammedcoursesurl().startsWith("https://") &&
           inst.getInstLdapurl().startsWith("https://") &&
                inst.getInstName()!= null &&
            !inst.getInstName().equals("")
        ){

            //Optional<Institution> in=institutionRep.findById(inst.getInstId());
            Institution in = institutionDAO.findById(inst.getInstId());
            if(in != null){
              /*  in.setInstName(inst.getInstName());
                in.setInstAcademicserverurl(inst.getInstAcademicserverurl());
                in.setInstAcadextradataurl(inst.getInstAcadextradataurl());
                in.setInstAcadloginurl(inst.getInstAcadloginurl());
                in.setInstAcadpersoninfodocurl(inst.getInstAcadpersoninfodocurl());
                in.setInstAcadpersoninfoidurl(inst.getInstAcadpersoninfoidurl());
                in.setInstAcadphysicalspacesurl(inst.getInstAcadphysicalspacesurl());
                in.setInstAcadprogrammedcoursesurl(inst.getInstAcadprogrammedcoursesurl());
                in.setInstLdapurl(inst.getInstLdapurl());*/

                institutionDAO.edit(inst);
                return inst;
            }
        }
        return null;

    }

    @Override
    public Institution getInstitution(long id) {
       // return institutionRep.findById(id);
        return institutionDAO.findById(id);
    }

    @Override
    public boolean isSaved(Institution institution) {
        return institutionDAO.isSaved(institution);
    }


    @Override
    public List<Institution> findAll() {
        //return institutionRep.findAll();
        return institutionDAO.findAll();
    }

}

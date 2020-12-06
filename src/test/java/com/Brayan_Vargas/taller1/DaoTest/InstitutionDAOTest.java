package com.Brayan_Vargas.taller1.DaoTest;

import com.Brayan_Vargas.taller1.dao.InstitutionDAO;
import com.Brayan_Vargas.taller1.model.Institution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InstitutionDAOTest {

    @Autowired
    private InstitutionDAO institutionDAO;

    private Institution institution;
    private Institution institution2;

    @BeforeEach
    public void setUp(){
        institution=new Institution();

        String url="https://prueba.ku";

        institution.setInstId(1);
        institution.setInstName("inst");
        /*
        institution.setInstAcademicserverurl(url);
        institution.setInstAcadextradataurl(url);
        institution.setInstAcadloginurl(url);
        institution.setInstAcadpersoninfoidurl(url);
        institution.setInstAcadpersoninfodocurl(url);
        institution.setInstAcadphysicalspacesurl(url);
        institution.setInstAcadprogrammedcoursesurl(url);
        institution.setInstLdapurl(url);*/

        institution2=new Institution();

        institution2.setInstId(32);
        institution2.setInstName("inst2");
    }

    @Test
    @Transactional
    public void saveTest(){
        assertFalse(institutionDAO.isSaved(institution));

            institutionDAO.save(institution);

            assertTrue(institutionDAO.isSaved(institution));


    }

    @Test
    @Transactional(propagation= Propagation.REQUIRED)
    public void editTest(){
        String url="https://exct.ku";
        String newName="instEdit";

        Institution insT=new Institution();
        //EL OBJETO EDITADO DEBE TENER EL MISMO ID DEL OBJETO QUE SE QUIERE EDITAR
        insT.setInstId(1);
        insT.setInstName(newName);
        insT.setInstLdapurl(url);

        institutionDAO.save(institution);
        assertEquals("inst", institutionDAO.findById(1).getInstName());

        institutionDAO.edit(insT);
        //¿DEBERIA UN METODO, QUE ESTA SIENDO PROBADO, SER USADO POR OTRO METODO DIFERENTE PUESTO TAMBIEN A PRUEBA?
        assertEquals(newName, institutionDAO.findById(1).getInstName());
        assertNotNull(institutionDAO.findById(1).getInstLdapurl());
        assertEquals(url, institutionDAO.findById(1).getInstLdapurl());
    }

    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void notEditTest(){
        String url="https://exct.ku";
        String newName="instEdit";

        Institution insT=new Institution();
        insT.setInstId(2);
        insT.setInstName(newName);
        insT.setInstLdapurl(url);

        institutionDAO.save(institution);
        assertEquals("inst", institutionDAO.findById(1).getInstName());

        institutionDAO.edit(insT);
        assertNotEquals(institution,insT);
    }

    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void deleteTest(){
            institutionDAO.save(institution);
            assertTrue(institutionDAO.isSaved(institution));

            institutionDAO.delete(institution);
            assertFalse(institutionDAO.isSaved(institution));
    }

    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void notDeleteTest(){
        institutionDAO.save(institution);
        assertTrue(institutionDAO.isSaved(institution));

        institutionDAO.delete(institution2);
        assertTrue(institutionDAO.isSaved(institution));
    }

    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void findById(){

            institutionDAO.save(institution);
            institutionDAO.save(institution2);

            Institution inst=institutionDAO.findById(1);
            Institution inst2=institutionDAO.findById(32);

            assertEquals(institution,inst);
            assertEquals(institution2,inst2);
            assertNotEquals(inst,inst2);
    }

    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void notFindById(){
        institutionDAO.save(institution);

        Institution inst=institutionDAO.findById(32);

        assertNull(inst);
    }

    @Test
    @Transactional(propagation=Propagation.REQUIRED)
    public void findAll(){
        institutionDAO.save(institution);
        institutionDAO.save(institution2);

        List<Institution> lInst=new ArrayList<Institution>();
        lInst.add(institution);
        lInst.add(institution2);

        List<Institution> foundIns=institutionDAO.findAll();

        assertFalse(foundIns.isEmpty());
        assertTrue(foundIns.containsAll(lInst));


    }

}

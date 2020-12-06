package com.Brayan_Vargas.taller1.IntegTesting;

import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.service.InstitutionServiceImp;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.xmlunit.util.IterableNodeList;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InstitutionTest {

    @Autowired
    private InstitutionServiceImp instServ;


    private Institution ins;
    private Institution ins2;

    @BeforeEach
    public void setUp(){
        String url="https://prueba.ku";
        String name="nameInst";
        long id = 2;

        ins=new Institution();
        ins.setInstAcademicserverurl(url);
        ins.setInstAcadextradataurl(url);
        ins.setInstAcadloginurl(url);
        ins.setInstAcadpersoninfoidurl(url);
        ins.setInstAcadpersoninfodocurl(url);
        ins.setInstAcadphysicalspacesurl(url);
        ins.setInstAcadprogrammedcoursesurl(url);
        ins.setInstLdapurl(url);
        ins.setInstName(name);
        ins.setInstId(id);

        ins2=new Institution();
        ins2.setInstAcademicserverurl(url);
        ins2.setInstAcadextradataurl(url);
        ins2.setInstAcadloginurl(url);
        ins2.setInstAcadpersoninfoidurl(url);
        ins2.setInstAcadpersoninfodocurl(url);
        ins2.setInstAcadphysicalspacesurl(url);
        ins2.setInstAcadprogrammedcoursesurl(url);
        ins2.setInstLdapurl(url);
        ins2.setInstName(name);
        ins2.setInstId(3);
    }

    @Test
    @Transactional
    public void saveInstitutionTest(){

        assertFalse(instServ.isSaved(ins));

        Institution in = instServ.saveInstitution(ins);

        assertNotNull(in);
        assertTrue(instServ.isSaved(ins));
    }

    @Test
    public void notSaveInstitutionTest_url(){

        ins.setInstLdapurl("");
        assertNull(instServ.saveInstitution(ins));
        //assertEquals(instServImp.saveInstitution(ins),ins);
    }

    @Test
    public void notSaveInstitutionTest_nameNull(){

        ins.setInstName(null);
        assertNull(instServ.saveInstitution(ins));
        //assertEquals(instServImp.saveInstitution(ins),ins);
    }

    @Test
    public void editInstitutionTest(){
        assertNotNull(instServ.editInstitution(ins));

    }




}

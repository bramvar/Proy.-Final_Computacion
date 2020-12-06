package com.Brayan_Vargas.taller1.UnitTesting;

import com.Brayan_Vargas.taller1.service.InstitutionServiceImp;
import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.repository.InstitutionRepository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InstitutionTest {

    @Mock
    private InstitutionRepository  instR;

    @InjectMocks
    private InstitutionServiceImp instServImp;

    private Institution ins;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        String url="https://prueba.ku";
        String name="nameInst";
        long id = 98765432;

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
        //com.example.taller1.model.Institution inst=new com.example.taller1.model.Institution();
    }

    @Test
    public void saveInstitutionTest(){
        when(instR.save(ins)).thenReturn(ins);
        assertNotNull(instServImp.saveInstitution(ins));
        //assertEquals(instServImp.saveInstitution(ins),ins);
    }

    @Test
    public void notSaveInstitutionTest_url(){
        ins.setInstAcademicserverurl("http://prueba.ku");

        assertNull(instServImp.saveInstitution(ins));
    }

    @Test
    public void notSaveInstitutionTest_name(){

        ins.setInstName(null);

        assertNull(instServImp.saveInstitution(ins));

    }

    @Test
    public void editInstitutionTest(){
        when(instR.findById(ins.getInstId())).thenReturn(java.util.Optional.of(ins));
        assertNotNull(instServImp.editInstitution(ins));
    }

    @Test
    public void notEditInstitutionTest_url(){
        ins.setInstAcademicserverurl("ttps://prueba.ku");
        assertNull(instServImp.editInstitution(ins));
    }

    @Test
    public void notEditInstitutionTest_name(){
        ins.setInstName(null);
        assertNull(instServImp.editInstitution(ins));
    }

    @Test
    public void notEditInstitutionTest_InstitutionNotFound(){
        when(instR.findById( ins.getInstId())).thenReturn(java.util.Optional.ofNullable(null));
        assertNull(instServImp.editInstitution(ins));
    }

}

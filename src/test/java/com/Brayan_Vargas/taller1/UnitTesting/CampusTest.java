package com.Brayan_Vargas.taller1.UnitTesting;

import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.repository.InstitutionRepository;
import com.Brayan_Vargas.taller1.model.Institutioncampus;
import com.Brayan_Vargas.taller1.repository.CampusRepository;
import com.Brayan_Vargas.taller1.service.CampusServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CampusTest{

    @Mock
    private CampusRepository campusRep;
    @Mock
    private InstitutionRepository institutionRep;

    @InjectMocks
    private CampusServiceImp campusServiceImp;

    private Institution inst;
    private Institutioncampus campus;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        String nameInst="nameInst";
        String nameCampus="nameCampus";
        long idInst = 123456789;
        long idCampus= 987654321;
        BigDecimal occup=new BigDecimal("0");

        inst=new Institution();
        inst.setInstName(nameInst);
        inst.setInstId(idInst);

        campus=new Institutioncampus();
        campus.setInstcamId(idCampus);
        campus.setInstcamName(nameCampus);
        campus.setInstcamOccupation(occup);
        campus.setInstitution(inst);
    }

    @Test
    public void saveCampusTest(){
        when(institutionRep.findById(campus.getInstitution().getInstId())).thenReturn( Optional.of(inst));
        when(campusRep.save(campus)).thenReturn(campus);

        assertNotNull(campusServiceImp.saveCampus(campus));
    }

    @Test
    public void notSaveCampusTest_nameNull(){
        campus.setInstcamName(null);
        assertNull(campusServiceImp.saveCampus(campus));
    }

    @Test
    public void notSaveCampusTest_occupationNull(){
        campus.setInstcamOccupation(new BigDecimal("1"));
        assertNull(campusServiceImp.saveCampus(campus));
    }

    @Test
    public void notSaveCampusTest_InstitutionNull(){
        campus.setInstitution(null);
        assertNull(campusServiceImp.saveCampus(campus));
    }

    @Test
    public void notSaveCampusTest_InstitutionNotFound(){
        when(institutionRep.findById( campus.getInstitution().getInstId())).thenReturn( Optional.ofNullable(null));
        assertNull(campusServiceImp.saveCampus(campus));
    }

    @Test
    public void editCampusTest(){
        when(institutionRep.findById( campus.getInstitution().getInstId())).thenReturn( Optional.of(inst));
        when(campusRep.findById(campus.getInstcamId())).thenReturn(Optional.of(campus));
        assertNotNull(campusServiceImp.editCampus(campus));
    }

    @Test
    public void notEditCampusTest_nameNull(){
        campus.setInstcamName(null);
        assertNull(campusServiceImp.editCampus(campus));
    }

    @Test
    public void notEditCampusTest_occupationDifferent(){
        campus.setInstcamOccupation(new BigDecimal("1"));
        assertNull(campusServiceImp.editCampus(campus));
    }

    @Test
    public void notEditCampusTest_InstitutionNull(){
        campus.setInstitution(null);
        assertNull(campusServiceImp.editCampus(campus));
    }

    @Test
    public void notEditCampusTest_InstitutionNotFound(){
        when(institutionRep.findById( campus.getInstitution().getInstId())).thenReturn( Optional.ofNullable(null));
        assertNull(campusServiceImp.editCampus(campus));
    }

    @Test
    public void notEditCampusTest_PhysSpcStyleNotFound(){
        when(institutionRep.findById( campus.getInstitution().getInstId())).thenReturn( Optional.of(inst));
        when(campusRep.findById(campus.getInstcamId())).thenReturn(Optional.ofNullable(null));
        assertNull(campusServiceImp.editCampus(campus));
    }





}

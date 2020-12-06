package com.Brayan_Vargas.taller1.UnitTesting;


import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;
import com.Brayan_Vargas.taller1.repository.InstitutionRepository;
import com.Brayan_Vargas.taller1.repository.PhysicalspacetypeRepository;
import com.Brayan_Vargas.taller1.service.PhysicalspaceTypeServiceImp;
import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PhysicalspaceTypeTest {

    @Mock
    private InstitutionRepository institutionRep;

    @Mock
    private PhysicalspacetypeRepository physicalspacetypeRep;

    @InjectMocks
    private PhysicalspaceTypeServiceImp physicalspaceTypeServImp;

    private Physicalspacetype physicalspacetype;
    private Institution inst;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        String nameInst="nameInst";
        String namePhyS="namePhysSpaceType";
        long idInst = 123456789;
        long idPhyS= 987654321;

        inst=new Institution();
        inst.setInstName(nameInst);
        inst.setInstId(idInst);

        physicalspacetype =new Physicalspacetype();
        physicalspacetype.setPhyspctypeName(namePhyS);
        physicalspacetype.setPhyspctypeImpliescomm("comm");
        physicalspacetype.setPhyspctypeId(idPhyS);
        physicalspacetype.setInstitution(inst);
    }

    @Test
    public void savePhysicalspaceTypeTest(){
        when(institutionRep.findById(physicalspacetype.getInstitution().getInstId())).thenReturn( Optional.of(inst));
        when(physicalspacetypeRep.save(physicalspacetype)).thenReturn(physicalspacetype);

        assertNotNull(physicalspaceTypeServImp.savePhysicalspaceTypeService(physicalspacetype));
    }

    @Test
    public void notSavePhysicalspaceTypeTest_nameNull(){
        physicalspacetype.setPhyspctypeName(null);
        assertNull(physicalspaceTypeServImp.savePhysicalspaceTypeService(physicalspacetype));
    }

    @Test
    public void notSavePhysicalspaceTypeTest_ImpliescommNull(){

        physicalspacetype.setPhyspctypeImpliescomm(null);
        assertNull(physicalspaceTypeServImp.savePhysicalspaceTypeService(physicalspacetype));
    }

    @Test
    public void notSavePhysicalspaceTypeTest_IntitutionNull(){
        physicalspacetype.setInstitution(null);
        assertNull(physicalspaceTypeServImp.savePhysicalspaceTypeService(physicalspacetype));
    }

    @Test
    public void notSavePhysicalspaceTypeTest_IntitutionNotFound(){
        when(institutionRep.findById( physicalspacetype.getInstitution().getInstId())).thenReturn( Optional.ofNullable(null));
        assertNull(physicalspaceTypeServImp.savePhysicalspaceTypeService(physicalspacetype));
    }

    @Test
    public void editPhysicalspaceType(){
        when(institutionRep.findById( physicalspacetype.getInstitution().getInstId())).thenReturn( Optional.of(inst));
        when(physicalspacetypeRep.findById(physicalspacetype.getPhyspctypeId())).thenReturn(Optional.of(physicalspacetype));
        assertNotNull(physicalspaceTypeServImp.editPhysicalspaceTypeService(physicalspacetype));
    }

    @Test
    public void notEditPhysicalspaceType_name(){
        physicalspacetype.setPhyspctypeName(null);
        assertNull(physicalspaceTypeServImp.editPhysicalspaceTypeService(physicalspacetype));
    }

    @Test
    public void notEditPhysicalspaceType_Impliescomm(){
        physicalspacetype.setPhyspctypeImpliescomm(null);
        assertNull(physicalspaceTypeServImp.editPhysicalspaceTypeService(physicalspacetype));
    }

    @Test
    public void notEditPhysicalspaceType_Institution(){
        physicalspacetype.setInstitution(null);
        assertNull(physicalspaceTypeServImp.editPhysicalspaceTypeService(physicalspacetype));
    }

    @Test
    public void notEditPhysicalspaceType_InstitutionNotFound(){
        when(institutionRep.findById( physicalspacetype.getInstitution().getInstId())).thenReturn( Optional.ofNullable(null));
        assertNull(physicalspaceTypeServImp.editPhysicalspaceTypeService(physicalspacetype));
    }

    @Test
    public void notEditPhysicalspaceType_PhysicalspcTypeNotFound(){
        when(institutionRep.findById( physicalspacetype.getInstitution().getInstId())).thenReturn( Optional.of(inst));
        when(physicalspacetypeRep.findById( physicalspacetype.getPhyspctypeId())).thenReturn(Optional.ofNullable(null));
        assertNull(physicalspaceTypeServImp.editPhysicalspaceTypeService(physicalspacetype));
    }

}

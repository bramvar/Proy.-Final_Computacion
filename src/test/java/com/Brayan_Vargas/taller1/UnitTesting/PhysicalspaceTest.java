package com.Brayan_Vargas.taller1.UnitTesting;

import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Institutioncampus;
import com.Brayan_Vargas.taller1.model.Physicalspace;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;
import com.Brayan_Vargas.taller1.repository.CampusRepository;
import com.Brayan_Vargas.taller1.repository.PhysicalspaceRepository;
import com.Brayan_Vargas.taller1.repository.PhysicalspacetypeRepository;
import com.Brayan_Vargas.taller1.service.PhysicalspaceServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
    import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PhysicalspaceTest {

    @Mock
    private CampusRepository campusRep;
    @Mock
    private PhysicalspacetypeRepository physicalspacetypeRep;
    @Mock
    private PhysicalspaceRepository physicalspaceRep;

    @InjectMocks
    private PhysicalspaceServiceImp physicalspaceServiceImp;

    private Institutioncampus campus;
    private Institution inst;
    private Physicalspacetype physicalspacetype;
    private Physicalspace physicalspace;
    private Physicalspace physicalspaceP;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        String namePhysSpc="namePhysicalSpace";
        String nameInst="nameInst";
        String nameCampus="nameCampus";
        String namePhysSpcStyle="namePhysSpaceStyle";

        long idPhySpc= 65112301;
        long idInst = 123456789;
        long idCampus= 987654321;
        long idPhysSpcSty=789415454;
        String extId = "12345";
        BigDecimal occup=new BigDecimal("0");

        inst=new Institution();
        inst.setInstName(nameInst);
        inst.setInstId(idInst);

        physicalspacetype = new Physicalspacetype();
        physicalspacetype.setPhyspctypeId(idPhysSpcSty);
        physicalspacetype.setPhyspctypeName(namePhysSpcStyle);

        campus=new Institutioncampus();
        campus.setInstcamId(idCampus);
        campus.setInstcamName(nameCampus);
        //campus.setInstcamOccupation(occup);
        //campus.setInstitution(inst);

        physicalspaceP = new Physicalspace();
        physicalspaceP.setPhyspcName(namePhysSpc);
        physicalspaceP.setPhyspcId(idPhySpc);

        physicalspace = new Physicalspace();
        physicalspace.setPhyspcName(namePhysSpc);
        physicalspace.setPhyspcId(idPhySpc);
        physicalspace.setInstitutioncampus(campus);
        physicalspace.setPhysicalspacetype(physicalspacetype);
        physicalspace.setPhysicalspace(physicalspaceP);
        physicalspace.setPhyspcExtid(extId);

    }

    @Test
    public void savePhysicalSpace(){
        when(physicalspacetypeRep.findById( physicalspace.getPhysicalspacetype().getPhyspctypeId())).thenReturn(Optional.of(physicalspacetype));
        when(campusRep.findById(physicalspace.getInstitutioncampus().getInstcamId())).thenReturn(Optional.of(campus));
        when(physicalspaceRep.save(physicalspace)).thenReturn(physicalspace);

        assertNotNull(physicalspaceServiceImp.savePhysicalspace(physicalspace));
    }

    @Test
    public void notSavePhysicalSpace_PhysSpcStyleNull(){
        physicalspace.setPhysicalspacetype(null);
        assertNull(physicalspaceServiceImp.savePhysicalspace(physicalspace));
    }

    @Test
    public void notSavePhysicalSpace_CampusNull(){
        physicalspace.setInstitutioncampus(null);
        assertNull(physicalspaceServiceImp.savePhysicalspace(physicalspace));
    }

    @Test
    public void notSavePhysicalSpace_ExtIdIncorrect(){
        physicalspace.setPhyspcExtid("155");
        assertNull(physicalspaceServiceImp.savePhysicalspace(physicalspace));
    }

    @Test
    public void notSavePhysicalSpace_FatherNull(){
        physicalspace.setPhysicalspace(null);
        assertNull(physicalspaceServiceImp.savePhysicalspace(physicalspace));
    }

    @Test
    public void notSavePhysicalSpace_PhysSpcStyNotFound(){
        when(physicalspacetypeRep.findById( physicalspace.getPhysicalspacetype().getPhyspctypeId())).thenReturn(Optional.ofNullable(null));
        assertNull(physicalspaceServiceImp.savePhysicalspace(physicalspace));
    }

    @Test
    public void notSavePhysicalSpace_CampusNotFound(){
        when(physicalspacetypeRep.findById( physicalspace.getPhysicalspacetype().getPhyspctypeId())).thenReturn(Optional.of(physicalspacetype));
        when(campusRep.findById(physicalspace.getInstitutioncampus().getInstcamId())).thenReturn(Optional.ofNullable(null));
        assertNull(physicalspaceServiceImp.savePhysicalspace(physicalspace));
    }

    @Test
    public void editPhysicalSpace(){
        when(physicalspacetypeRep.findById( physicalspace.getPhysicalspacetype().getPhyspctypeId())).thenReturn(Optional.of(physicalspacetype));
        when(campusRep.findById(physicalspace.getInstitutioncampus().getInstcamId())).thenReturn(Optional.of(campus));
        when(physicalspaceRep.findById( physicalspace.getPhyspcId())).thenReturn(Optional.of(physicalspace));

        assertNotNull(physicalspaceServiceImp.editPhysicalspace(physicalspace));
    }

    @Test
    public void notEditPhysicalSpace_PhysSpcStyleNull(){
        physicalspace.setPhysicalspacetype(null);
        assertNull(physicalspaceServiceImp.editPhysicalspace(physicalspace));
    }

    @Test
    public void notEditPhysicalSpace_CampusNull(){
        physicalspace.setInstitutioncampus(null);
        assertNull(physicalspaceServiceImp.editPhysicalspace(physicalspace));
    }

    @Test
    public void notEditPhysicalSpace_ExtIdIncorrect(){
        physicalspace.setPhyspcExtid("155");
        assertNull(physicalspaceServiceImp.editPhysicalspace(physicalspace));
    }

    @Test
    public void notEditPhysicalSpace_FatherNull(){
        physicalspace.setPhysicalspace(null);
        assertNull(physicalspaceServiceImp.editPhysicalspace(physicalspace));
    }

    @Test
    public void notEditPhysicalSpace_PhysSpcStyNotFound(){
        when(physicalspacetypeRep.findById( physicalspace.getPhysicalspacetype().getPhyspctypeId())).thenReturn(Optional.ofNullable(null));
        assertNull(physicalspaceServiceImp.editPhysicalspace(physicalspace));
    }

    @Test
    public void notEditPhysicalSpace_CampusNotFound(){
        when(physicalspacetypeRep.findById( physicalspace.getPhysicalspacetype().getPhyspctypeId())).thenReturn(Optional.of(physicalspacetype));
        when(campusRep.findById( physicalspace.getInstitutioncampus().getInstcamId())).thenReturn(Optional.ofNullable(null));
        assertNull(physicalspaceServiceImp.editPhysicalspace(physicalspace));
    }

    @Test
    public void notEditPhysicalSpace(){
        when(physicalspacetypeRep.findById( physicalspace.getPhysicalspacetype().getPhyspctypeId())).thenReturn(Optional.of(physicalspacetype));
        when(campusRep.findById(physicalspace.getInstitutioncampus().getInstcamId())).thenReturn(Optional.of(campus));
        when(physicalspaceRep.findById(physicalspace.getPhyspcId())).thenReturn(Optional.ofNullable(null));

        assertNull(physicalspaceServiceImp.editPhysicalspace(physicalspace));
    }
}

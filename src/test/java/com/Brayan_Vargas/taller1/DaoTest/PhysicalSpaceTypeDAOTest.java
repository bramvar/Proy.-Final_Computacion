package com.Brayan_Vargas.taller1.DaoTest;

import com.Brayan_Vargas.taller1.dao.PhysicalSpaceTypeDAO;
import com.Brayan_Vargas.taller1.model.Physicalspace;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PhysicalSpaceTypeDAOTest {

    @Autowired
    private PhysicalSpaceTypeDAO physicalSpaceTypeDAO;

    private Physicalspacetype physicalspacetype;
    private Physicalspacetype physicalspacetype2;
    private Physicalspacetype physicalspacetype3;

    @BeforeEach
    public void setUp(){
        physicalspacetype =new Physicalspacetype();
        physicalspacetype.setPhyspctypeName("physpcType");
        physicalspacetype.setPhyspctypeExtid("123");
        physicalspacetype.setPhyspctypeId(1);

        physicalspacetype2 =new Physicalspacetype();
        physicalspacetype2.setPhyspctypeName("physpcType2");
        physicalspacetype2.setPhyspctypeExtid("123");
        physicalspacetype2.setPhyspctypeId(2);

        physicalspacetype3 =new Physicalspacetype();
        physicalspacetype3.setPhyspctypeName("physpcType2");
        physicalspacetype3.setPhyspctypeExtid("321");
        physicalspacetype3.setPhyspctypeId(3);

    }

    @Test
    @Transactional
    public void saveTest(){
        assertFalse(physicalSpaceTypeDAO.isSaved(physicalspacetype));

        try {
            physicalSpaceTypeDAO.save(physicalspacetype);
            assertTrue(physicalSpaceTypeDAO.isSaved(physicalspacetype));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Transactional
    public void editTest(){
        String newName="physpcTypeEdit";
        String newExtId="777";
        Physicalspacetype phyTypeEdit =new Physicalspacetype();
        phyTypeEdit.setPhyspctypeName(newName);
        phyTypeEdit.setPhyspctypeExtid(newExtId);
        phyTypeEdit.setPhyspctypeId(2);

        physicalSpaceTypeDAO.save(physicalspacetype2);
        assertEquals(physicalspacetype2.getPhyspctypeName(),physicalSpaceTypeDAO.findById(2).getPhyspctypeName());
        assertEquals(physicalspacetype2.getPhyspctypeExtid(),physicalSpaceTypeDAO.findById(2).getPhyspctypeExtid());

        physicalSpaceTypeDAO.edit(phyTypeEdit);
        assertEquals(newName, physicalSpaceTypeDAO.findById(2).getPhyspctypeName());
        assertEquals(newExtId,physicalSpaceTypeDAO.findById(2).getPhyspctypeExtid());


    }

    @Test
    @Transactional
    public void notEditTest(){
        String newName="physpcTypeEdit";
        String newExtId="777";
        Physicalspacetype phyTypeEdit =new Physicalspacetype();
        phyTypeEdit.setPhyspctypeName(newName);
        phyTypeEdit.setPhyspctypeExtid(newExtId);
        phyTypeEdit.setPhyspctypeId(1);

        physicalSpaceTypeDAO.save(physicalspacetype2);
        assertEquals(physicalspacetype2.getPhyspctypeName(),physicalSpaceTypeDAO.findById(2).getPhyspctypeName());
        assertEquals(physicalspacetype2.getPhyspctypeExtid(),physicalSpaceTypeDAO.findById(2).getPhyspctypeExtid());

        physicalSpaceTypeDAO.edit(phyTypeEdit);
        assertNotEquals(physicalspacetype2,phyTypeEdit);
    }

    @Test
    @Transactional
    public void delete(){

            physicalSpaceTypeDAO.save(physicalspacetype);
            assertTrue(physicalSpaceTypeDAO.isSaved(physicalspacetype));

            physicalSpaceTypeDAO.delete(physicalspacetype);
            assertFalse(physicalSpaceTypeDAO.isSaved(physicalspacetype));
    }

    @Test
    @Transactional
    public void notDelete(){
        physicalSpaceTypeDAO.save(physicalspacetype);
        assertTrue(physicalSpaceTypeDAO.isSaved(physicalspacetype));

        physicalSpaceTypeDAO.delete(physicalspacetype2);
        assertTrue(physicalSpaceTypeDAO.isSaved(physicalspacetype));

    }

    @Test
    @Transactional
    public void findByNameTest(){
        List<Physicalspacetype> exp=new ArrayList<Physicalspacetype>();
        exp.add(physicalspacetype2);
        exp.add(physicalspacetype3);

        physicalSpaceTypeDAO.save(physicalspacetype);
        physicalSpaceTypeDAO.save(physicalspacetype2);
        physicalSpaceTypeDAO.save(physicalspacetype3);

        List<Physicalspacetype> foundList= physicalSpaceTypeDAO.findByName("physpcType2");
        List<Physicalspacetype> foundList2= physicalSpaceTypeDAO.findByName("physpcType");

        assertEquals(exp,foundList);
        assertEquals(physicalspacetype,foundList2.get(0));
    }

    @Test
    @Transactional
    public void notFindByNameTest(){
        physicalSpaceTypeDAO.save(physicalspacetype);

        List<Physicalspacetype> foundList= physicalSpaceTypeDAO.findByName("physpcType2");

        assertTrue(foundList.isEmpty());
    }

    @Test
    @Transactional
    public void findByExtIdTest(){
        List<Physicalspacetype> exp=new ArrayList<Physicalspacetype>();
        exp.add(physicalspacetype);
        exp.add(physicalspacetype2);

        physicalSpaceTypeDAO.save(physicalspacetype);
        physicalSpaceTypeDAO.save(physicalspacetype2);
        physicalSpaceTypeDAO.save(physicalspacetype3);

        List<Physicalspacetype> foundList= physicalSpaceTypeDAO.findByExtId("123");
        List<Physicalspacetype> foundList2= physicalSpaceTypeDAO.findByExtId("321");

        assertEquals(exp,foundList);
        assertEquals(physicalspacetype3,foundList2.get(0));

    }

    @Test
    @Transactional
    public void notFindByExtIdTest(){
        physicalSpaceTypeDAO.save(physicalspacetype);

        List<Physicalspacetype> foundList2= physicalSpaceTypeDAO.findByExtId("321");

        assertTrue(foundList2.isEmpty());
    }
}

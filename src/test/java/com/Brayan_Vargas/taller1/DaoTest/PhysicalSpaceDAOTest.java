package com.Brayan_Vargas.taller1.DaoTest;

import com.Brayan_Vargas.taller1.dao.CommunityinstanceDAO;
import com.Brayan_Vargas.taller1.dao.PhysicalSpaceDAO;
import com.Brayan_Vargas.taller1.model.Communityinstance;
import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Physicalspace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.comparator.Comparators;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PhysicalSpaceDAOTest {

    @Autowired
    private PhysicalSpaceDAO physicalSpaceDAO;
    @Autowired
    private CommunityinstanceDAO communityinstanceDAO;

    private Physicalspace physicalspace;
    private Physicalspace physicalspace2;
    private Physicalspace physicalspace3;
    private Physicalspace physicalspace4;

    private Communityinstance communityinstance;
    private Communityinstance communityinstance2;
    private Communityinstance communityinstance3;
    private Communityinstance communityinstance4;

    @BeforeEach
    public void setUp(){
        communityinstance =new Communityinstance();
        communityinstance.setComminstId(11);
        communityinstance.setComminstExtid("123");
        communityinstance.setComminstStartdatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());
        communityinstance.setComminstEnddatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 15).getTime());

        communityinstance2 =new Communityinstance();
        communityinstance2.setComminstId(22);
        communityinstance2.setComminstExtid("231");
        communityinstance2.setComminstStartdatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 13).getTime());
        communityinstance2.setComminstEnddatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 20).getTime());

        communityinstance3 =new Communityinstance();
        communityinstance3.setComminstId(33);
        communityinstance3.setComminstExtid("321");
        communityinstance3.setComminstStartdatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 23).getTime());
        communityinstance3.setComminstEnddatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 25).getTime());

        communityinstance4 =new Communityinstance();
        communityinstance4.setComminstId(44);
        communityinstance4.setComminstExtid("321");
        communityinstance4.setComminstStartdatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 21).getTime());
        communityinstance4.setComminstEnddatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 26).getTime());


        List<Communityinstance> comm=new ArrayList<Communityinstance>();
        comm.add(communityinstance);
        comm.add(communityinstance3);

        List<Communityinstance> comm2=new ArrayList<Communityinstance>();
        comm2.add(communityinstance2);

        List<Communityinstance> comm3=new ArrayList<Communityinstance>();
        comm.add(communityinstance4);

        physicalspace = new Physicalspace();
        physicalspace.setPhyspcName("physcp1");
        physicalspace.setPhyspcExtid("123");
        physicalspace.setPhyspcId(1);
        physicalspace.setPhyspcOccupation(new BigDecimal(5));
        physicalspace.setCommunityinstances(comm);

        physicalspace2 = new Physicalspace();
        physicalspace2.setPhyspcName("physcp2");
        physicalspace2.setPhyspcExtid("123");
        physicalspace2.setPhyspcId(2);
        physicalspace2.setPhyspcOccupation(new BigDecimal(11));
        physicalspace2.setCommunityinstances(comm2);

        physicalspace3 = new Physicalspace();
        physicalspace3.setPhyspcName("physcp2");
        physicalspace3.setPhyspcExtid("312");
        physicalspace3.setPhyspcId(3);
        physicalspace3.setPhyspcOccupation(new BigDecimal(5));
        physicalspace3.setCommunityinstances(comm3);

        physicalspace4 = new Physicalspace();
        physicalspace4.setPhyspcName("physcp4");
        physicalspace4.setPhyspcExtid("322");
        physicalspace4.setPhyspcId(4);

        communityinstance.setPhysicalspace(physicalspace);
        communityinstance3.setPhysicalspace(physicalspace);
        communityinstance2.setPhysicalspace(physicalspace2);
        communityinstance4.setPhysicalspace(physicalspace3);


    }

    @Test
    @Transactional
    public void saveTest(){
        assertFalse(physicalSpaceDAO.isSaved(physicalspace));

            physicalSpaceDAO.save(physicalspace);
            physicalSpaceDAO.save(physicalspace2);

            assertTrue(physicalSpaceDAO.isSaved(physicalspace));
            assertTrue(physicalSpaceDAO.isSaved(physicalspace2));
    }

    @Test
    @Transactional
    public void deleteTest(){
            physicalSpaceDAO.save(physicalspace);
            assertTrue(physicalSpaceDAO.isSaved(physicalspace));

            physicalSpaceDAO.delete(physicalspace);
            assertFalse(physicalSpaceDAO.isSaved(physicalspace));
    }

    @Test
    @Transactional
    public void notDeleteTest(){
        physicalSpaceDAO.save(physicalspace);
        assertTrue(physicalSpaceDAO.isSaved(physicalspace));

        physicalSpaceDAO.delete(physicalspace2);
        assertTrue(physicalSpaceDAO.isSaved(physicalspace));

    }

    @Test
    @Transactional
    public void editTest(){
        String newName="physcpEdit";
        String newExtId="555";
        BigDecimal newOccup=new BigDecimal(0);

        Physicalspace phyEdit=new Physicalspace();
        phyEdit.setPhyspcName(newName);
        phyEdit.setPhyspcExtid(newExtId);
        phyEdit.setPhyspcOccupation(newOccup);
        phyEdit.setPhyspcId(1);

        physicalSpaceDAO.save(physicalspace);
        assertEquals(physicalspace.getPhyspcName(),physicalSpaceDAO.findById(1).getPhyspcName());
        assertEquals(physicalspace.getPhyspcExtid(),physicalSpaceDAO.findById(1).getPhyspcExtid());
        assertEquals(physicalspace.getPhyspcOccupation(),physicalSpaceDAO.findById(1).getPhyspcOccupation());

        physicalSpaceDAO.edit(phyEdit);
        assertEquals(newName,physicalSpaceDAO.findById(1).getPhyspcName());
        assertEquals(newExtId,physicalSpaceDAO.findById(1).getPhyspcExtid());
        assertNotNull(physicalSpaceDAO.findById(1).getPhyspcOccupation());
        assertEquals(newOccup,physicalSpaceDAO.findById(1).getPhyspcOccupation());
    }

    @Test
    @Transactional
    public void notEditTest(){
        String newName="physcpEdit";
        String newExtId="555";
        BigDecimal newOccup=new BigDecimal(0);

        Physicalspace phyEdit=new Physicalspace();
        phyEdit.setPhyspcName(newName);
        phyEdit.setPhyspcExtid(newExtId);
        phyEdit.setPhyspcOccupation(newOccup);
        phyEdit.setPhyspcId(2);

        physicalSpaceDAO.save(physicalspace);
        assertEquals(physicalspace.getPhyspcName(),physicalSpaceDAO.findById(1).getPhyspcName());
        assertEquals(physicalspace.getPhyspcExtid(),physicalSpaceDAO.findById(1).getPhyspcExtid());
        assertEquals(physicalspace.getPhyspcOccupation(),physicalSpaceDAO.findById(1).getPhyspcOccupation());


        physicalSpaceDAO.edit(phyEdit);
        assertNotEquals(newOccup,physicalSpaceDAO.findById(1).getPhyspcOccupation());
    }

    @Test
    @Transactional
    public void findByNameTest(){
        List<Physicalspace> exp=new ArrayList<Physicalspace>();
        exp.add(physicalspace2);
        exp.add(physicalspace3);

        physicalSpaceDAO.save(physicalspace);
        physicalSpaceDAO.save(physicalspace2);
        physicalSpaceDAO.save(physicalspace3);

        List<Physicalspace> foundList= physicalSpaceDAO.findByName("physcp2");
        List<Physicalspace> foundList2= physicalSpaceDAO.findByName("physcp1");

        assertEquals(exp,foundList);
        assertEquals(physicalspace,foundList2.get(0));

    }

    @Test
    @Transactional
    public void notFindByNameTest(){
        physicalSpaceDAO.save(physicalspace);

        List<Physicalspace> foundList= physicalSpaceDAO.findByName("physcp2");

        assertTrue(foundList.isEmpty());
        //assertEquals(physicalspace,foundList2.get(0));
    }

    @Test
    @Transactional
    public void findByExtIdTest(){
        List<Physicalspace> exp=new ArrayList<Physicalspace>();
        exp.add(physicalspace);
        exp.add(physicalspace2);

        physicalSpaceDAO.save(physicalspace);
        physicalSpaceDAO.save(physicalspace2);
        physicalSpaceDAO.save(physicalspace3);

        List<Physicalspace> foundList= physicalSpaceDAO.findByExtId("123");
        List<Physicalspace> foundList2= physicalSpaceDAO.findByExtId("312");

        assertEquals(exp,foundList);
        assertEquals(physicalspace3,foundList2.get(0));

    }

    @Test
    @Transactional
    public void notFindByExtIdTest(){
        physicalSpaceDAO.save(physicalspace);

        List<Physicalspace> foundList2= physicalSpaceDAO.findByExtId("312");

        assertTrue(foundList2.isEmpty());
    }

    @Test
    @Transactional
    public void findByDate(){
        Date ini=new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Date fin=new GregorianCalendar(2014, Calendar.FEBRUARY, 15).getTime();

        physicalSpaceDAO.save(physicalspace);
        physicalSpaceDAO.save(physicalspace2);

        communityinstanceDAO.save(communityinstance);
        communityinstanceDAO.save(communityinstance2);
        communityinstanceDAO.save(communityinstance3);


        List<Physicalspace> lPhys=new ArrayList<Physicalspace>();
        lPhys.add(physicalspace);
        lPhys.add(physicalspace2);

        List<Physicalspace> foundPhys=physicalSpaceDAO.findByDate(ini,fin);

        assertFalse(foundPhys.isEmpty());
        assertEquals(lPhys,foundPhys);
    }

    @Test
    @Transactional
    public void findByDateAndOccupation(){
        Date ini=new GregorianCalendar(2014, Calendar.FEBRUARY, 10).getTime();
        Date fin=new GregorianCalendar(2014, Calendar.FEBRUARY, 20).getTime();

        physicalSpaceDAO.save(physicalspace);
        physicalSpaceDAO.save(physicalspace2);
        physicalSpaceDAO.save(physicalspace3);

        communityinstanceDAO.save(communityinstance);
        communityinstanceDAO.save(communityinstance2);
        communityinstanceDAO.save(communityinstance3);
        communityinstanceDAO.save(communityinstance4);

        List<Physicalspace> lPhys=new ArrayList<Physicalspace>();
        lPhys.add(physicalspace);

        List<Physicalspace> foundPhys=physicalSpaceDAO.findByDateAndOccupation(ini,fin);

        assertFalse(foundPhys.isEmpty());
        assertEquals(lPhys,foundPhys);
    }



}

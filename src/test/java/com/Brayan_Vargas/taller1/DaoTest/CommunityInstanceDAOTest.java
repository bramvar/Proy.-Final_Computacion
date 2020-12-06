package com.Brayan_Vargas.taller1.DaoTest;

import com.Brayan_Vargas.taller1.dao.CommunityinstanceDAO;
import com.Brayan_Vargas.taller1.model.Communityinstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CommunityInstanceDAOTest {

    @Autowired
    private CommunityinstanceDAO communityinstanceDAO;

    private Communityinstance communityinstance;
    private Communityinstance communityinstance2;
    private Communityinstance communityinstance3;

    @BeforeEach
    public void setUp(){
         communityinstance =new Communityinstance();
         communityinstance.setComminstId(1);
         communityinstance.setComminstExtid("123");
         communityinstance.setComminstStartdatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());
         communityinstance.setComminstEnddatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 15).getTime());

        communityinstance2 =new Communityinstance();
        communityinstance2.setComminstId(2);
        communityinstance2.setComminstExtid("231");
        communityinstance2.setComminstStartdatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 13).getTime());
        communityinstance2.setComminstEnddatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 20).getTime());

        communityinstance3 =new Communityinstance();
        communityinstance3.setComminstId(3);
        communityinstance3.setComminstExtid("321");
        communityinstance3.setComminstStartdatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 23).getTime());
        communityinstance3.setComminstEnddatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 25).getTime());
    }

    @Test
    @Transactional
    public void saveTest(){
        assertFalse(communityinstanceDAO.isSaved(communityinstance));

        communityinstanceDAO.save(communityinstance);

        assertTrue(communityinstanceDAO.isSaved(communityinstance));
    }

    @Test
    @Transactional
    public void editTest(){
        Communityinstance commEdit =new Communityinstance();
        commEdit.setComminstId(1);
        commEdit.setComminstExtid("1238");
        commEdit.setComminstStartdatehour(new GregorianCalendar(2020, Calendar.FEBRUARY, 11).getTime());
        commEdit.setComminstEnddatehour(new GregorianCalendar(2014, Calendar.FEBRUARY, 15).getTime());

        communityinstanceDAO.save(communityinstance);
        assertEquals(communityinstance, communityinstanceDAO.findById(1));

        communityinstanceDAO.edit(commEdit);
        assertEquals(commEdit.getComminstExtid(),communityinstanceDAO.findById(1).getComminstExtid());
        assertSame(commEdit,communityinstanceDAO.findById(1));
    }

    @Test
    @Transactional
    public void notEditTest(){
        Communityinstance commEdit =new Communityinstance();
        commEdit.setComminstId(111);
        commEdit.setComminstExtid("1234");
        commEdit.setComminstStartdatehour(new GregorianCalendar(2020, Calendar.FEBRUARY, 11).getTime());


        communityinstanceDAO.save(communityinstance);
        assertEquals(communityinstance, communityinstanceDAO.findById(1));

        communityinstanceDAO.edit(commEdit);
        assertNotSame(commEdit,communityinstanceDAO.findById(1));

    }

    @Test
    @Transactional
    public void deleteTest(){
        communityinstanceDAO.save(communityinstance);
        assertTrue(communityinstanceDAO.isSaved(communityinstance));

        communityinstanceDAO.delete(communityinstance);
        assertFalse(communityinstanceDAO.isSaved(communityinstance));
    }

    @Test
    @Transactional
    public void notDeleteTest(){
        communityinstanceDAO.save(communityinstance);
        assertTrue(communityinstanceDAO.isSaved(communityinstance));

        communityinstanceDAO.delete(communityinstance2);
        assertTrue(communityinstanceDAO.isSaved(communityinstance));
    }

    /**
     * cuando solo la fecha inicio se encuentra dentro del rango de busqueda
     */
    @Test
    @Transactional
    public void findByDate(){
        Date ini=new GregorianCalendar(2014, Calendar.FEBRUARY, 5).getTime();
        Date fin=new GregorianCalendar(2014, Calendar.FEBRUARY, 13).getTime();

        communityinstanceDAO.save(communityinstance);

        List<Communityinstance> found=communityinstanceDAO.findByDate(ini,fin);

        assertFalse(found.isEmpty());
        assertEquals(communityinstance, found.get(0));
    }

    @Test
    @Transactional
    public void notFindByDate(){
        Date ini=new GregorianCalendar(2014, Calendar.FEBRUARY, 5).getTime();
        Date fin=new GregorianCalendar(2014, Calendar.FEBRUARY, 10).getTime();

        communityinstanceDAO.save(communityinstance);

        List<Communityinstance> found=communityinstanceDAO.findByDate(ini,fin);

        assertTrue(found.isEmpty());
    }

    /**
     * cuando solo la fecha final se encuentra dentro del rango de busqueda
     */
    @Test
    @Transactional
    public void findByDate2(){
        Date ini=new GregorianCalendar(2014, Calendar.FEBRUARY, 14).getTime();
        Date fin=new GregorianCalendar(2014, Calendar.FEBRUARY, 16).getTime();

        communityinstanceDAO.save(communityinstance);

        List<Communityinstance> found=communityinstanceDAO.findByDate(ini,fin);

        assertFalse(found.isEmpty());
        assertEquals(communityinstance, found.get(0));
    }

    /**
     * cuando  la fecha inicial y final se encuentra dentro del rango de busqueda
     */
    @Test
    @Transactional
    public void findByDate3(){
        Date ini=new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime();
        Date fin=new GregorianCalendar(2014, Calendar.FEBRUARY, 15).getTime();

        communityinstanceDAO.save(communityinstance);

        List<Communityinstance> found=communityinstanceDAO.findByDate(ini,fin);

        assertFalse(found.isEmpty());
        assertEquals(communityinstance, found.get(0));
    }
}

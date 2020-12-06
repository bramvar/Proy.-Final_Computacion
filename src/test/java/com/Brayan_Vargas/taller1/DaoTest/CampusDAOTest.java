package com.Brayan_Vargas.taller1.DaoTest;

import com.Brayan_Vargas.taller1.dao.CampusDAO;
import com.Brayan_Vargas.taller1.model.Institutioncampus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CampusDAOTest {

    @Autowired
    private CampusDAO campusDAO;

    private Institutioncampus institutioncampus;
    private Institutioncampus institutioncampus2;
    @BeforeEach
    public void setUp(){
        institutioncampus=new Institutioncampus();
        institutioncampus.setInstcamId(2);
        institutioncampus.setInstcamName("instCam");
        institutioncampus.setInstcamOccupation(new BigDecimal(0));

        institutioncampus2=new Institutioncampus();
        institutioncampus2.setInstcamId(22);
        institutioncampus2.setInstcamName("instCam");
        institutioncampus2.setInstcamOccupation(new BigDecimal(0));
    }

    @Test
    @Transactional
    public void saveTest(){
        assertFalse(campusDAO.isSaved(institutioncampus));

        campusDAO.save(institutioncampus);

        assertTrue(campusDAO.isSaved(institutioncampus));
    }

    @Test
    @Transactional
    public void editTest(){
        String newName="camEdit";

        Institutioncampus camEdit=new Institutioncampus();
        camEdit.setInstcamName(newName);
        camEdit.setInstcamId(2);

        campusDAO.save(institutioncampus);
        assertEquals(institutioncampus.getInstcamName(), campusDAO.findById(2).getInstcamName());

        campusDAO.edit(camEdit);
        assertEquals(newName, campusDAO.findById(2).getInstcamName());
    }

    @Test
    @Transactional
    public void notEditTest(){
        String newName="camEdit";

        Institutioncampus camEdit=new Institutioncampus();
        camEdit.setInstcamName(newName);
        camEdit.setInstcamId(22);

        campusDAO.save(institutioncampus);
        assertEquals(institutioncampus.getInstcamName(), campusDAO.findById(2).getInstcamName());

        campusDAO.edit(camEdit);
        assertNotEquals(campusDAO.findById(2), camEdit);
    }

    @Test
    @Transactional
    public void deleteTest(){
            campusDAO.save(institutioncampus);
            assertTrue(campusDAO.isSaved(institutioncampus));

            campusDAO.delete(institutioncampus);
            assertFalse(campusDAO.isSaved(institutioncampus));
    }

    @Test
    @Transactional
    public void notDeleteTest(){
        campusDAO.save(institutioncampus);
        assertTrue(campusDAO.isSaved(institutioncampus));

        campusDAO.delete(institutioncampus2);
        assertTrue(campusDAO.isSaved(institutioncampus));
    }

    @Test
    @Transactional
    public void findByIdTest(){
        campusDAO.save(institutioncampus);

        Institutioncampus campus=campusDAO.findById(2);

        assertEquals(institutioncampus,campus);

    }

    @Test
    @Transactional
    public void notFindByIdTest(){
        campusDAO.save(institutioncampus);

        Institutioncampus campus=campusDAO.findById(22);

        assertNull(campus);
    }
}

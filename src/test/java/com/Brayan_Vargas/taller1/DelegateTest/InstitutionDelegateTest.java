package com.Brayan_Vargas.taller1.DelegateTest;

import com.Brayan_Vargas.taller1.dao.InstitutionDAO;
import com.Brayan_Vargas.taller1.delegate.InstitutionDelegate;
import com.Brayan_Vargas.taller1.delegate.InstitutionDelegateImp;
import com.Brayan_Vargas.taller1.model.Institution;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class InstitutionDelegateTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private InstitutionDelegateImp institutionDelegate;

    final String SERVER="http://localhost:8080/backapi/";

    private Institution ins;
    private Institution ins2;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void GET_InstitutionsTest(){
        ins=new Institution();
        ins2=new Institution();

        Institution[] inst={ins,ins2};

        when(restTemplate.getForObject(SERVER+"institution",Institution[].class)).thenReturn(inst);

        List<Institution> instList= Arrays.asList(inst);

        assertEquals(institutionDelegate.GET_Institutions(),instList);
    }

    @Test
    public void GET_InstitutionTest(){
        ins=new Institution();
        ins2=new Institution();

        when(restTemplate.getForObject(SERVER+"institution/"+1,Institution.class)).thenReturn(ins);

        assertNotNull(institutionDelegate.GET_Institution((long)1));
    }





}

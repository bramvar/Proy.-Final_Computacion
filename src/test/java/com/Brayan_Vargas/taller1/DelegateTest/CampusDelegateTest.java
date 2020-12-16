package com.Brayan_Vargas.taller1.DelegateTest;

import com.Brayan_Vargas.taller1.delegate.CampusDelegateImp;
import com.Brayan_Vargas.taller1.delegate.InstitutionDelegateImp;
import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Institutioncampus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CampusDelegateTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CampusDelegateImp campusDelegate;

    final String SERVER="http://localhost:8080/backapi/";

    private Institutioncampus campus;
    private Institutioncampus campus2;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void GET_CampusesTest(){
        campus=new Institutioncampus();
        campus2=new Institutioncampus();

        Institutioncampus[] cams={campus,campus2};

        when(restTemplate.getForObject(SERVER+"campus",Institutioncampus[].class)).thenReturn(cams);

        List<Institutioncampus> camsList= Arrays.asList(cams);

        assertEquals(campusDelegate.GET_Campuses(),camsList);
    }

    @Test
    public void GET_CampusTest(){
        campus=new Institutioncampus();
        campus2=new Institutioncampus();

        when(restTemplate.getForObject(SERVER+"campus/"+1,Institutioncampus.class)).thenReturn(campus);

        assertNotNull(campusDelegate.GET_Campus((long)1));
    }

    @Test
    public void POST_CampusTest(){
        campus=new Institutioncampus();

        when(restTemplate.postForEntity(SERVER+"campus", campus, Institutioncampus.class)).thenReturn(new ResponseEntity<>(campus, HttpStatus.OK));

        assertEquals(campusDelegate.POST_Campus(campus), campus);
    }

    @Test
    public void PUT_CampusTest(){
        campus=new Institutioncampus();

        campusDelegate.PUT_Campus(campus);

        verify(restTemplate, times(1)).put(ArgumentMatchers.eq(SERVER+"campus"),ArgumentMatchers.eq(campus), ArgumentMatchers.eq(Institutioncampus.class));
    }
}

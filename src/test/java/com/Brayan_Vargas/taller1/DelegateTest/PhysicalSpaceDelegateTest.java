package com.Brayan_Vargas.taller1.DelegateTest;

import com.Brayan_Vargas.taller1.delegate.PhysicalSpaceDelegate;
import com.Brayan_Vargas.taller1.delegate.PhysicalSpaceDelegateImp;
import com.Brayan_Vargas.taller1.model.Institutioncampus;
import com.Brayan_Vargas.taller1.model.Physicalspace;
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
public class PhysicalSpaceDelegateTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PhysicalSpaceDelegateImp physicalSpaceDelegate;

    final String SERVER="http://localhost:8080/backapi/";

    private Physicalspace physicalspace;
    private Physicalspace physicalspace2;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void GET_PhysicalspacesTest(){
        physicalspace=new Physicalspace();
        physicalspace2=new Physicalspace();

        Physicalspace[] phys={physicalspace,physicalspace2};

        when(restTemplate.getForObject(SERVER+"physicalspace",Physicalspace[].class)).thenReturn(phys);

        List<Physicalspace> physList= Arrays.asList(phys);

        assertEquals(physicalSpaceDelegate.GET_Spaces(),physList);
    }

    @Test
    public void GET_PhysicalspaceTest(){
        physicalspace=new Physicalspace();
        physicalspace2=new Physicalspace();

        when(restTemplate.getForObject(SERVER+"physicalspace/"+1,Physicalspace.class)).thenReturn(physicalspace);

        assertNotNull(physicalSpaceDelegate.GET_Space((long)1));
    }

    @Test
    public void POST_PhysicalspaceTest(){
        physicalspace=new Physicalspace();

        when(restTemplate.postForEntity(SERVER+"physicalspace", physicalspace, Physicalspace.class)).thenReturn(new ResponseEntity<>(physicalspace, HttpStatus.OK));

        assertEquals(physicalSpaceDelegate.POST_Space(physicalspace), physicalspace);
    }

    @Test
    public void PUT_PhysicalspaceTest(){
        physicalspace=new Physicalspace();

        physicalSpaceDelegate.PUT_Space(physicalspace);

        verify(restTemplate, times(1)).put(ArgumentMatchers.eq(SERVER+"physicalspace"),ArgumentMatchers.eq(physicalspace), ArgumentMatchers.eq(Physicalspace.class));
    }
}

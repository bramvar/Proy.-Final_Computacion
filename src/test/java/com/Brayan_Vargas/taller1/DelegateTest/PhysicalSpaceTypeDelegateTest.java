package com.Brayan_Vargas.taller1.DelegateTest;

import com.Brayan_Vargas.taller1.delegate.PhysicalSpaceDelegateImp;
import com.Brayan_Vargas.taller1.delegate.PhysicalSpaceTypeDelegateImp;
import com.Brayan_Vargas.taller1.model.Physicalspace;
import com.Brayan_Vargas.taller1.model.Physicalspacetype;
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
public class PhysicalSpaceTypeDelegateTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PhysicalSpaceTypeDelegateImp physicalSpacetypeDelegate;

    final String SERVER="http://localhost:8080/backapi/";

    private Physicalspacetype physicalspacetype;
    private Physicalspacetype physicalspacetype2;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void GET_PhysicalspacetypesTest(){
        physicalspacetype=new Physicalspacetype();
        physicalspacetype2=new Physicalspacetype();

        Physicalspacetype[] phys={physicalspacetype,physicalspacetype2};

        when(restTemplate.getForObject(SERVER+"physicalspacetype",Physicalspacetype[].class)).thenReturn(phys);

        List<Physicalspacetype> physList= Arrays.asList(phys);

        assertEquals(physicalSpacetypeDelegate.GET_Types(),physList);
    }

    @Test
    public void GET_PhysicalspacetypeTest(){
        physicalspacetype=new Physicalspacetype();
        physicalspacetype2=new Physicalspacetype();

        when(restTemplate.getForObject(SERVER+"physicalspacetype/"+1,Physicalspacetype.class)).thenReturn(physicalspacetype);

        assertNotNull(physicalSpacetypeDelegate.GET_Type((long)1));
    }

    @Test
    public void POST_PhysicalspaceTest(){
        physicalspacetype=new Physicalspacetype();

        when(restTemplate.postForEntity(SERVER+"physicalspacetype", physicalspacetype, Physicalspacetype.class)).thenReturn(new ResponseEntity<>(physicalspacetype, HttpStatus.OK));

        assertEquals(physicalSpacetypeDelegate.POST_Type(physicalspacetype), physicalspacetype);
    }

    @Test
    public void PUT_PhysicalspaceTest(){
        physicalspacetype=new Physicalspacetype();

        physicalSpacetypeDelegate.PUT_Type(physicalspacetype);

        verify(restTemplate, times(1)).put(ArgumentMatchers.eq(SERVER+"physicalspacetype"),ArgumentMatchers.eq(physicalspacetype), ArgumentMatchers.eq(Physicalspacetype.class));
    }
}

package com.Brayan_Vargas.taller1.DelegateTest;

import com.Brayan_Vargas.taller1.dao.InstitutionDAO;
import com.Brayan_Vargas.taller1.delegate.InstitutionDelegate;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class InstitutionDelegateTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private InstitutionDelegate institutionDelegate;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }



}

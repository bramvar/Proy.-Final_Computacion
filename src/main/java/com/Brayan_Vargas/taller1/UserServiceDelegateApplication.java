package com.Brayan_Vargas.taller1;

import com.Brayan_Vargas.taller1.delegate.InstitutionDelegate;
import com.Brayan_Vargas.taller1.delegate.InstitutionDelegateImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserServiceDelegateApplication {
/*
    @Bean
    RestTemplate template(){
        return new RestTemplate();
    }*/

    @Bean
    InstitutionDelegate institutionDelegate(){
        return new InstitutionDelegateImp();
    }
}

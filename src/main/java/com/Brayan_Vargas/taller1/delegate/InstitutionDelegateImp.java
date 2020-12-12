package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class InstitutionDelegateImp implements InstitutionDelegate {

    private RestTemplate restTemplate;
    final String SERVER="http://localhost:8080/backapi/";

    @Autowired
    public InstitutionDelegateImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public void GET_Institution(long id) {

    }

    @Override
    public void GET_Institutions() {

    }

    @Override
    public Institution POST_Institution(Institution institution) {
        return null;
    }

    @Override
    public void PUT_Institution(Institution institution) {

    }

    @Override
    public void DELETE_Institution(Institution institution) {

    }
}

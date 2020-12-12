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
    public Institution GET_Institution(long id) {
        Institution inst= restTemplate.getForObject(SERVER+"institution/"+id,Institution.class);
        return inst;
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

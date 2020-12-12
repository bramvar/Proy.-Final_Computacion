package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
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
    public Iterable<Institution> GET_Institutions() {
        Institution[] institutions= restTemplate.getForObject(SERVER+"institution",Institution[].class);
        List<Institution> instList= Arrays.asList(institutions);
        return instList;
    }

    @Override
    public Institution POST_Institution(Institution institution) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Institution> req =new HttpEntity<>(institution,headers);
        ResponseEntity<Institution> inst = restTemplate.postForEntity(SERVER+"institution,",req,Institution.class);
        return inst.getBody();
    }

    @Override
    public void PUT_Institution(Institution institution) {
        restTemplate.put(SERVER+"institution", institution,Institution.class);
    }

    @Override
    public void DELETE_Institution(Institution institution) {
        restTemplate.delete(SERVER+"institution/", institution,Institution.class);
    }
}

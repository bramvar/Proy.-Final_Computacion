package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Institutioncampus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CampusDelegateImp implements CampusDelegate{

    private RestTemplate restTemplate;
    final String SERVER="";

    @Autowired
    public CampusDelegateImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Institutioncampus GET_Campus(long id) {
        return null;
    }

    @Override
    public void GET_Institutions() {

    }

    @Override
    public Institutioncampus POST_Campus(Institutioncampus institutioncampus) {
        return null;
    }

    @Override
    public void PUT_Campus(Institutioncampus institutioncampus) {

    }

    @Override
    public void DELETE_Campus(Institutioncampus institutioncampus) {

    }
}

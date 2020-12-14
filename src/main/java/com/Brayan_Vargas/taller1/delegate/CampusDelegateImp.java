package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Institutioncampus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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
        Institutioncampus campus= restTemplate.getForObject(SERVER+"campus/"+id,Institutioncampus.class);
        return campus;
    }

    @Override
    public Iterable<Institutioncampus> GET_Campuses() {
        Institutioncampus[] campuses= restTemplate.getForObject(SERVER+"campus",Institutioncampus[].class);
        List<Institutioncampus> campusList= Arrays.asList(campuses);
        return campusList;
    }

    @Override
    public Institutioncampus POST_Campus(Institutioncampus institutioncampus) {
        return restTemplate.postForEntity(SERVER+"campus", institutioncampus, Institutioncampus.class).getBody();
    }

    @Override
    public void PUT_Campus(Institutioncampus institutioncampus) {
        restTemplate.put(SERVER+"campus", institutioncampus,Institutioncampus.class);
    }

    @Override
    public void DELETE_Campus(Institutioncampus institutioncampus) {
        restTemplate.delete(SERVER+"campus", institutioncampus,Institutioncampus.class);
    }
}

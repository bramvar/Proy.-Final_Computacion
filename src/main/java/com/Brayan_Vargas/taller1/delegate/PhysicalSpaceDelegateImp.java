package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Institution;
import com.Brayan_Vargas.taller1.model.Physicalspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Component
public class PhysicalSpaceDelegateImp implements PhysicalSpaceDelegate{

    private RestTemplate restTemplate;
    final String SERVER="http://localhost:8080/backapi/";

    @Autowired
    public PhysicalSpaceDelegateImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Physicalspace GET_Space(long id) {
        Physicalspace space= restTemplate.getForObject(SERVER+"physicalspace/"+id,Physicalspace.class);
        return space;
    }

    @Override
    public Iterable<Physicalspace> GET_Spaces() {
        Physicalspace[] spaces= restTemplate.getForObject(SERVER+"physicalspace",Physicalspace[].class);
        List<Physicalspace> instList= Arrays.asList(spaces);
        return instList;
    }

    @Override
    public Physicalspace POST_Space(Physicalspace space) {
        return restTemplate.postForEntity(SERVER+"physicalspace", space, Physicalspace.class).getBody();
    }

    @Override
    public void PUT_Space(Physicalspace space) {
        restTemplate.put(SERVER+"physicalspace", space,Physicalspace.class);
    }

    @Override
    public void DELETE_Space(Physicalspace space) {
        restTemplate.delete(SERVER+"physicalspace/", space,Physicalspace.class);
    }
}

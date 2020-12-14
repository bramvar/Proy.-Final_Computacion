package com.Brayan_Vargas.taller1.delegate;

import com.Brayan_Vargas.taller1.model.Physicalspace;
import org.springframework.web.client.RestTemplate;

public class PhysicalSpaceDelegateImp implements PhysicalSpaceDelegate{

    private RestTemplate restTemplate;
    final String SERVER="http://localhost:8080/backapi/";

    @Override
    public Physicalspace GET_Space(long id) {
        return null;
    }

    @Override
    public void GET_Space() {

    }

    @Override
    public Physicalspace POST_Space(Physicalspace institutioncampus) {
        return null;
    }

    @Override
    public void PUT_Space(Physicalspace institutioncampus) {

    }

    @Override
    public void DELETE_Space(Physicalspace institutioncampus) {

    }
}
